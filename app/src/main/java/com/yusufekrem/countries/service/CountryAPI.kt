package com.yusufekrem.countries.service

import com.yusufekrem.countries.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {
    //GET,POST
    // BASE-URL-> //https://raw.githubusercontent.com/
   // EXT-> // atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json


    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
   fun getCountries():Single<List<Country>> // emits exactly one element

}