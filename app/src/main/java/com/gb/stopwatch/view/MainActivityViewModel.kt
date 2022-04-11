package com.gb.stopwatch.view

import androidx.lifecycle.LiveData
import com.gb.stopwatch.model.domain.IStopwatchStateHolder
import com.gb.stopwatch.viewmodel.BaseViewModel
import kotlinx.coroutines.*

class MainActivityViewModel(
    private val stopwatchStateHolder: IStopwatchStateHolder
): BaseViewModel() {

    override fun getLiveData(): LiveData<String> {
        return super.getLiveData()
    }

    override fun start() {
        if (job == null) startJob()
        stopwatchStateHolder.start()
    }

    private fun startJob() {
        scope.launch {
            withContext(Dispatchers.IO) {
                while (isActive) {
                    mutableLiveData.postValue(stopwatchStateHolder.getStringTimeRepresentation())
                    delay(20)
                }
            }
        }
    }


    override fun pause() {
        stopwatchStateHolder.pause()
        stopJob()
    }

    override fun clearValue() {
        mutableLiveData.postValue("00:00:000")
    }

    override fun stop() {
        stopwatchStateHolder.stop()
        stopJob()
        clearValue()
    }
}