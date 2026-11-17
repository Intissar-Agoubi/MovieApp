package es.dam.movieapp.core.time

class LocalAppTime : AppTime {
    override fun currentTimeToLong() : Long {
       return System.currentTimeMillis()
    }
}