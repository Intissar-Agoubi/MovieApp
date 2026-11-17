package es.dam.movieapp.core.cache

interface AppCache {
    //guardar la hora actual
    fun updateTime(key: String)

   // dice si esta caducada la hora o no ????
   fun isExpired(key: String , ttl : Long): Boolean
}