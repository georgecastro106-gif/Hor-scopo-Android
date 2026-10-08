package com.example.horoscopo_android.utils

import android.content.Context
import androidx.core.content.edit

class SessionManager(val context: Context){


    val sharedPreferences = context.getSharedPreferences("horoscope_session", Context.MODE_PRIVATE)

    fun setFavorite(id: String) {
        sharedPreferences.edit {
            putString("FAVORITE_HOROSCOPE", id)
        }

    }

    fun getFavorite(): String {
       return  sharedPreferences.getString("FAVORITE_HOROSCOPE", "")!!
    }

    fun isFavorite(id: String): Boolean {
        return id == getFavorite()
    }
}