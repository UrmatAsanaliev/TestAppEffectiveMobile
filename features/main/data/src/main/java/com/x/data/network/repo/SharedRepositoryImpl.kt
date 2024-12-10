package com.x.data.network.repo

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.x.domain.network.repo.SharedRepository

class SharedRepositoryImpl(
    private val shared: SharedPreferences
): SharedRepository {

    override fun getCity(): String =
        shared.getString("city", "").toString()


    @SuppressLint("CommitPrefEdits")
    override fun putCity(city: String) {
        shared.edit().putString("city", city).apply()
    }
}