package com.example.finance.ui.currencie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finance.R
import com.example.finance.model.Moeda
import com.example.finance.model.Results

class CurrencieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currencie)

        val info = intent.extras
        val values = info?.getSerializable("values") as Moeda

        if (savedInstanceState == null) {
            values.let {
                CurrencieFragment.newInstance(it)
            }?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.containerCurrencie, it)
                    .commitNow()
            }
        }
    }
}