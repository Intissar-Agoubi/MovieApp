package es.dam.movieapp.features.movies.data.local.xml

import android.content.Context
import es.dam.movieapp.R
import es.dam.movieapp.core.cache.AppCache
import es.dam.movieapp.core.serialization.JsonSerializer
import es.dam.movieapp.features.movies.domain.Movie
import androidx.core.content.edit

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

}