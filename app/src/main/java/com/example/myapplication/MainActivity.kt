package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : MainActivityBinding
    private val myName = MyName("vaibhav")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.main_activity);
        binding.myName = myName
        binding.button.setOnClickListener {
            showText(it)
        }

    }

    private fun showText(view: View){
        binding.apply {
            myName?.nickname = nickName.text.toString()
            invalidateAll()
            nickName.visibility = View.GONE
            button.visibility = View.GONE
            showText.visibility = View.VISIBLE
        }


        //code for hiding keyboard after clicking done
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
        //**

    }
}