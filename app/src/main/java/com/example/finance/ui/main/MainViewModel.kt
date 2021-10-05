package com.example.finance.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finance.model.QuotationResponse
import com.example.finance.model.Results
import com.example.finance.repository.RepositoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val quotationLiveData = MutableLiveData<Results>()
    val repository = RepositoryApi()

    fun getNewQuotationCoroutine() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.getNewQuotation().let { quotation ->
                quotation.results?.let{
                    quotationLiveData.postValue(it)
                }
            }
        }
    }
}