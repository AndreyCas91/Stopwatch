package com.gb.stopwatch.model.domain

interface TimestampProvider {
    fun getMilliseconds(): Long
}