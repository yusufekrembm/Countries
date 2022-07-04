package com.yusufekrem.countries.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yusufekrem.countries.model.Country

@Database(entities = arrayOf(Country::class), version = 1) // class Country olduğu için 1 tane

abstract class CountryDatabase : RoomDatabase() {
    abstract  fun countryDao() : CountryDao

    //Singleton -> İçerisinden bir tane obje oluşturulabiliyor..

    companion object{

        @Volatile private var instance: CountryDatabase? = null

        private val lock = Any()
        operator fun invoke (context: Context) = instance  ?: synchronized(lock) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,CountryDatabase::class.java,"countrydatabase"
        ).build()

        // Olurda kapatırsam çökmesin diye uygulama contextini aldım


    }

}