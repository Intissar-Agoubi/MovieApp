package es.dam.movieapp.features.movies.data.remote.mock

import es.dam.movieapp.features.movies.domain.Movie

class MoviesMockRemoteDataSource {
    fun obtainAll(): List<Movie> {
        return listOf(
            Movie("1", "Inception", "Christopher Nolan", "https://1"),
            Movie("2", "Titanic", "James Cameron", "https://2"),
            Movie("3", "Parásitos", "Bong Joon-ho", "https://3"),
            Movie("4", "El laberinto del fauno", "Guillermo del Toro", "https://4")
        )
    }
}