package com.sam.shamsaha.retrofit

import com.sam.shamsaha.practiceAPI.QuotesList
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET

interface Apis {

    @GET("/quotes")
    suspend fun getQuotes( name : String) : Response<QuotesList>



}