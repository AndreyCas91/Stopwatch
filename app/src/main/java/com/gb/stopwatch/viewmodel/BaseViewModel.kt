package com.gb.stopwatch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

open class BaseViewModel(
    protected val mutableLiveData: MutableLiveData<String> = MutableLiveData()
): ViewModel() {

    open fun getLiveData(): LiveData<String>{
        return mutableLiveData
    }

    protected val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())
    protected var job: Job? = null

     open fun start() {
    }


    open fun pause() {
    }

    open fun stop() {
    }

    open fun stopJob() {
        scope.coroutineContext.cancelChildren()
        job = null
    }

    open fun clearValue() {

    }

    override fun onCleared() {
        super.onCleared()
        stopJob()
    }
}