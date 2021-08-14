package com.example.memory.mvvm_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memory.mvvm_ret.adapter.PostAdapter
import com.example.memory.mvvm_ret.repository.MainRepository
import com.example.memory.mvvm_ret.viewmodel.MainViewModel
import com.example.memory.mvvm_ret.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { PostAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerVew()

        val repository = MainRepository()
        val viewModelFactory =MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getCustomPosts(2, "id", "dsc")
        viewModel.myCustomPosts.observe(this, Observer { response ->
            if (response.isSuccessful) {
                myAdapter.setData(response.body()!!)
            } else {
                Toast.makeText(this, "Error Fetching data", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun setupRecyclerVew() {
        recycler.adapter = myAdapter
        recycler.layoutManager = LinearLayoutManager(this)
    }
}