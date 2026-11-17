package es.dam.movieapp.features.movies.data.local.xml

import android.content.Context
import es.dam.movieapp.R
import es.dam.movieapp.core.cache.AppCache
import es.dam.movieapp.core.serialization.JsonSerializer
import es.dam.movieapp.features.movies.domain.Movie


class MovieXmlLocalDataSource(
    private val context: Context,
    private val serializer: JsonSerializer<List<Movie>>,
    private val appCache: AppCache
) {
    private val ttl = 5 * 60 * 1000L
    private val keyMovies = "keyMovies"
    private val sharedPreferences = context.getSharedPreferences(
        context.getString(R.string.local_source_movies),
        Context.MODE_PRIVATE
    )


    //guardar una lista de peliculas
    fun saveAll(movies: List<Movie>) {
        sharedPreferences.edit().apply { putString(keyMovies, serializer.toJson(movies)).apply() }
        appCache.updateTime(keyMovies)
    }

    // recuperar un listado de movies
    fun findAll(): List<Movie> {
        if (appCache.isExpired(keyMovies, ttl)) return emptyList()
        val json = sharedPreferences.getString(keyMovies, null) ?: return emptyList()
        return serializer.fromJson(json)
    }

    // recuperar by id
    fun findById(id: String): Movie? {
        return findAll().find { it.id == id }
    }
    // delete by id
    fun deleteById(id : String){
        saveAll(findAll().filterNot { it.id == id })
    }
    // modificar un listado
    fun update(movie: Movie){
       val pelicula = findAll().filterNot { it.id == movie.id }.toMutableList()
          pelicula.add(movie)
        saveAll(pelicula)

    }



    // deleteall eliminar todo
    fun deleteAll(){
        sharedPreferences.edit().remove(keyMovies).apply()
    }

}