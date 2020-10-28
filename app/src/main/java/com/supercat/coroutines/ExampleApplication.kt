package com.supercat.coroutines

import androidx.multidex.MultiDexApplication
import com.supercat.coroutines.di.DiController

class ExampleApplication() : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        DiController.assembleGraph(this)
    }
}
