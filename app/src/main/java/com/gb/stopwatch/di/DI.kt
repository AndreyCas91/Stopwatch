package com.gb.stopwatch.di

import com.gb.stopwatch.model.domain.*
import com.gb.stopwatch.view.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DI {
    val mainModule = module {
        viewModel { MainActivityViewModel(stopwatchStateHolder = get()) }
        single<IStopwatchStateHolder> {
            StopwatchStateHolder(
                stopwatchStateCalculator = get(),
                elapsedTimeCalculator = get(),
                timestampMillisecondsFormatter = get()
            )
        }
        single<StopwatchStateCalculator> {
            StopwatchStateCalculator(
                timestampProvider = get(),
                elapsedTimeCalculator = get()
            )
        }
        single<TimestampProvider> { TimestampProvide() }
        single<ElapsedTimeCalculator> { ElapsedTimeCalculator(timestampProvider = get()) }
        single<TimestampMillisecondsFormatter> { TimestampMillisecondsFormatter() }
    }
}