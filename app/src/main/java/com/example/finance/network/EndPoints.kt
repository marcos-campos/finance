package com.example.finance.network

import com.example.finance.model.QuotationResponse
import retrofit2.http.GET

interface EndPoints{

    @GET("finance")
    suspend fun getQuotation() : QuotationResponse

}