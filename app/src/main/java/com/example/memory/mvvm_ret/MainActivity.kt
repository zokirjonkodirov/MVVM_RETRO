package com.example.memory.mvvm_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.memory.mvvm_ret.repository.MainRepository
import com.example.memory.mvvm_ret.viewmodel.MainViewModel
import com.example.memory.mvvm_ret.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MainRepository()
        val viewModelFactory =MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        button.setOnClickListener {
            getPost()
        }

//        viewModel.getPost()
//        viewModel.response.observe(this, Observer { myResponse ->
//            if (myResponse.isSuccessful) {
//                text_title.text = myResponse.body()?.title
//                text_body.text = myResponse.body()?.body
//            }
//        })
    }

    private fun getPost() {

        val number = editTextNumber.text.toString()

        viewModel.getPost(Integer.parseInt(number))

        viewModel.dResponse.observe(this, Observer { myResponse ->
            if (myResponse.isSuccessful) {
                text_title.text = myResponse.body()?.title
                text_body.text = myResponse.body()?.body
            }
        })

    }
}