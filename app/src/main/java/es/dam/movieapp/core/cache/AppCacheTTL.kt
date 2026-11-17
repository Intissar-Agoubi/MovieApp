package es.dam.movieapp.core.cache

import android.content.Context
import es.dam.movieapp.R
import es.dam.movieapp.core.time.AppTime
import androidx.core.content.edit

class AppCacheTTL(private val context: Context,private val appTime: AppTime): AppCache {

    val sharedPref = context.getSharedPreferences(context.getString(R.string.app_cache),Context.MODE_PRIVATE)

    //guardar la hora en long
    override fun updateTime(key: String) {
        sharedPref.edit { putLong(key, appTime.currentTimeToLong()) }
    }
    //leer la hora si esta caducada o no
    override fun isExpired(key: String, ttl: Long): Boolean {
        val timeSave = sharedPref.getLong(key,-1)
       return appTime.currentTimeToLong()-timeSave >= ttl

    }
}