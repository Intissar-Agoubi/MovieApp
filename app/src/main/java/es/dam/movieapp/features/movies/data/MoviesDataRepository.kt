package es.dam.movieapp.features.movies.data

import es.dam.movieapp.features.movies.data.local.xml.MovieXmlLocalDataSource
import es.dam.movieapp.features.movies.data.remote.mock.MoviesMockRemoteDataSource
import es.dam.movieapp.features.movies.domain.Movie
import es.dam.movieapp.features.movies.domain.MovieRepository

class MoviesDataRepository(
    private val movieXmlLocalDataSource: MovieXmlLocalDataSource,
    private val mockRemoteDataSource: MoviesMockRemoteDataSource
) :
    MovieRepository {
    override fun getAll(): List<Movie> {
        return movieXmlLocalDataSource.findAll()
    }

    override fun update(movie: Movie) {
        movieXmlLocalDataSource.saveAll(mockRemoteDataSource.obtainAll())
        movieXmlLocalDataSource.update(movie)
    }
}