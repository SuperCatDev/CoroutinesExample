package com.supercat.coroutines.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

object DiController {
    fun assembleGraph(application: Application): KoinApplication {
        val graph = listOf(
            Graph.repoModule,
            Graph.viewModelModule,
            Graph.databaseModule,
        )

        return startKoin {
            androidContext(application)
            modules(graph)
        }
    }
}
