package com.example.finance.ui.main

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.finance.R
import com.example.finance.model.Moeda
import com.example.finance.model.QuotationResponse
import com.example.finance.model.Results
import com.example.finance.ui.currencie.CurrencieActivity
import javax.xml.transform.Result

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val nameCurrencie1 by lazy { view?.findViewById<TextView>(R.id.home_tv_currencie1) }
    private val nameCurrencie2 by lazy { view?.findViewById<TextView>(R.id.home_tv_currencie2) }
    private val nameCurrencie3 by lazy { view?.findViewById<TextView>(R.id.home_tv_currencie3) }
    private val valueCurrencie1 by lazy { view?.findViewById<TextView>(R.id.home_tv_value1) }
    private val valueCurrencie2 by lazy { view?.findViewById<TextView>(R.id.home_tv_value2) }
    private val valueCurrencie3 by lazy { view?.findViewById<TextView>(R.id.home_tv_value3) }
    private val trendingUpCurrencie1 by lazy { view?.findViewById<ImageView>(R.id.home_trending_up_1) }
    private val trendingDownCurrencie1 by lazy { view?.findViewById<ImageView>(R.id.home_trending_down_1) }
    private val trendingUpCurrencie2 by lazy { view?.findViewById<ImageView>(R.id.home_trending_up_2) }
    private val trendingDownCurrencie2 by lazy { view?.findViewById<ImageView>(R.id.home_trending_down_2) }
    private val trendingUpCurrencie3 by lazy { view?.findViewById<ImageView>(R.id.home_trending_up_3) }
    private val trendingDownCurrencie3 by lazy { view?.findViewById<ImageView>(R.id.home_trending_down_3) }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trendingUpCurrencie1?.visibility = View.INVISIBLE
        trendingUpCurrencie2?.visibility = View.INVISIBLE
        trendingUpCurrencie3?.visibility = View.INVISIBLE
        trendingDownCurrencie1?.visibility = View.INVISIBLE
        trendingDownCurrencie2?.visibility = View.INVISIBLE
        trendingDownCurrencie3?.visibility = View.INVISIBLE

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getNewQuotationCoroutine()
        viewModel.quotationLiveData.observe(viewLifecycleOwner, Observer { valuesQuotation ->
            valuesQuotation.let {

                setNamesCurrencies(it)
                setValuesCurrencies(it)
                setTrendingCurrencie(it)
                onClick(it)

            }
        })
    }

    fun onClick(results: Results){
        nameCurrencie1?.setOnClickListener {

            val moeda = Moeda(
                    results.currencies?.USD?.name.toString(),
                    results.currencies?.USD?.buy.toString(),
                    results.currencies?.USD?.sell.toString(),
                    results.currencies?.USD?.variation.toString()
            )

            val intent = Intent(it.context, CurrencieActivity::class.java)

            intent.putExtra("values", moeda)

            it.context.startActivity(intent)
        }

        nameCurrencie2?.setOnClickListener {

            val moeda = Moeda(
                    results.currencies?.EUR?.name.toString(),
                    results.currencies?.EUR?.buy.toString(),
                    results.currencies?.EUR?.sell.toString(),
                    results.currencies?.EUR?.variation.toString()
            )

            val intent = Intent(it.context, CurrencieActivity::class.java)

            intent.putExtra("values", moeda)

            it.context.startActivity(intent)
        }

        nameCurrencie3?.setOnClickListener {

            val moeda = Moeda(
                    results.currencies?.GBP?.name.toString(),
                    results.currencies?.GBP?.buy.toString(),
                    results.currencies?.GBP?.sell.toString(),
                    results.currencies?.GBP?.variation.toString()
            )

            val intent = Intent(it.context, CurrencieActivity::class.java)

            intent.putExtra("values", moeda)

            it.context.startActivity(intent)
        }
    }

    fun setNamesCurrencies(results: Results){
        nameCurrencie1?.text = results.currencies?.USD?.name.toString()
        nameCurrencie2?.text = results.currencies?.EUR?.name.toString()
        nameCurrencie3?.text = results.currencies?.GBP?.name.toString()
    }

    fun setValuesCurrencies(results: Results){
        valueCurrencie1?.text = results.currencies?.USD?.variation.toString()
        valueCurrencie2?.text = results.currencies?.EUR?.variation.toString()
        valueCurrencie3?.text = results.currencies?.GBP?.variation.toString()
    }

    fun setTrendingCurrencie(results: Results){

        val result = results.currencies

        //Trending Currencie 1
        if (result?.USD?.variation!! > 0.0){
            trendingUpCurrencie1?.visibility = View.VISIBLE
        }else{
            trendingDownCurrencie1?.visibility = View.VISIBLE
        }

        //Trending Currencie 2
        if (result.EUR?.variation!! > 0.0){
            trendingUpCurrencie2?.visibility = View.VISIBLE
        }else{
            trendingDownCurrencie2?.visibility = View.VISIBLE
        }

        //Trending Currencie 3
        if (result.GBP?.variation!! > 0.0){
            trendingUpCurrencie3?.visibility = View.VISIBLE
        }else{
            trendingDownCurrencie3?.visibility = View.VISIBLE
        }
    }
}

