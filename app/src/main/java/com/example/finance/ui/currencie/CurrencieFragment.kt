package com.example.finance.ui.currencie

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.finance.R
import com.example.finance.model.Moeda
import com.example.finance.model.Results

class CurrencieFragment(val result: Moeda) : Fragment() {

    companion object {
        fun newInstance(it: Moeda) = CurrencieFragment(it)
    }

    private val currencieName by lazy { view?.findViewById<TextView>(R.id.currencie_tv_title) }
    private val currencieBuy by lazy { view?.findViewById<TextView>(R.id.currencie_tv_buy_value) }
    private val currencieSell by lazy { view?.findViewById<TextView>(R.id.currencie_tv_sell_value) }
    private val currencieVariation by lazy { view?.findViewById<TextView>(R.id.currencie_tv_variation) }
    private val currencie by lazy { view?.findViewById<TextView>(R.id.currencie_tv_balance_available_description2) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currencie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        currencieName?.text = result.nome
        currencieBuy?.text = result.compra
        currencieSell?.text = result.venda
        currencieVariation?.text = result.variacao
        currencie?.text = result.nome

        if (result.variacao > 0.0.toString()){
            currencieVariation?.setTextColor(Color.GREEN)
        } else {
            currencieVariation?.setTextColor(Color.RED)
        }
    }
}