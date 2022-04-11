package com.gb.stopwatch.model.domain

interface IStopwatchStateHolder {

    fun start()

    fun pause()

    fun stop()

    fun getStringTimeRepresentation(): String
}