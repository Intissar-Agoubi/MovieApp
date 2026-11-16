package es.dam.movieapp.features.movies.domain

import kotlinx.serialization.Serializable

@Serializable
data class Movie(val id: String, val title: String, val director: String, val urlImage: String)
