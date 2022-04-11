package com.gb.stopwatch.model.domain

class TimestampProvide : TimestampProvider {
        override fun getMilliseconds(): Long {
            return System.currentTimeMillis()
        }
    }