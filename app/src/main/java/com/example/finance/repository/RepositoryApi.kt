package com.example.finance.repository

import com.example.finance.model.QuotationResponse
import com.example.finance.network.EndPoints
import com.example.finance.network.RetrofitInit

class RepositoryApi  {

    private var url = "https://api.hgbrasil.com/"
    private var service = EndPoints::class

    private val conectionService = RetrofitInit(url).create(service)

    suspend fun getNewQuotation(): QuotationResponse = conectionService.getQuotation()

}