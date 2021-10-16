package com.mepark.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mepark.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private val person = Person("Moon Family")
    private lateinit  var  viewModel : DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        binding.vm = viewModel

        binding.button.setOnClickListener {

            binding.apply {

                nickname.visibility = View.VISIBLE
                invalidateAll()

                button.visibility = View.GONE
                editText.visibility = View.GONE

                val inputMethod = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethod.hideSoftInputFromWindow(it.windowToken, 0)
            }

        }

        binding.nickname.setOnClickListener{

            binding.apply {

                nickname.visibility = View.GONE
                button.visibility = View.VISIBLE
                editText.visibility = View.VISIBLE

                editText.text.clear()
                editText.requestFocus()

                val inputMethod = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethod.showSoftInput(editText, 0)
            }

        }


    }
}
