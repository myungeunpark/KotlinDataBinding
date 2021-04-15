package com.mepark.aboutme

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.mepark.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val person = Person("Moon Family", "James and Sunny", 40)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.person = person
        binding.invalidateAll()
        binding.button.setOnClickListener {

            binding.apply {

                nickname.visibility = View.VISIBLE
                //nickname.text = editText.text
                person?.nickname = editText.text.toString()
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
