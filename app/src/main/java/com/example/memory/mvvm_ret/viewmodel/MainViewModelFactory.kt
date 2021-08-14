package com.example.memory.mvvm_ret.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.memory.mvvm_ret.repository.MainRepository

/**
 * @author user
 * @date 14.08.2021
 */
class MainViewModelFactory(

    private val repository: MainRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}