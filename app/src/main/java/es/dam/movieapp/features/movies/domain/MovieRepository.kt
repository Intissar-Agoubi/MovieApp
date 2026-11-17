package es.dam.movieapp.features.movies.domain

interface MovieRepository {
    fun getAll(): List<Movie>
    fun update(movie: Movie)
}