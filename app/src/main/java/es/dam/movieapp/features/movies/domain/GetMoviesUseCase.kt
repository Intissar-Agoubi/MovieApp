package es.dam.movieapp.features.movies.domain

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(): List<Movie> {
        return movieRepository.getAll()
    }
}