package com.example.hope

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.hope.R.id.textViewview
import com.example.hope.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
private  val myName: MyName =MyName("SAHIL KUMAR..")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
binding.myName =myName
     //   findViewById<Button>(R.id.done_button).setOnClickListener{addNickname(it)}
      //  done_button.setOnClickListener{addNickname(it)}

        binding.doneButton.setOnClickListener{addNickname(it)}
    }


    private fun addNickname(view : View){ // view == button here

//        val editText = findViewById<EditText>(R.id.textNickName)
//        val nicknameTextView = findViewById<TextView>(R.id.textViewview)

       val editText = this.textNickName
     val nicknameTextView = textViewview// text id in xml

        binding.apply {


            nicknameTextView.text = editText.text
            myName?.nickname = editText.text.toString()
            invalidateAll()
            editText.visibility = View.GONE // visiblity gone , no empty space
            view.visibility = View.GONE
            nicknameTextView.visibility = View.VISIBLE

        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}