package com.supercat.coroutines.di

import androidx.room.Room
import com.supercat.coroutines.data.DATABASE_NAME
import com.supercat.coroutines.data.Database
import com.supercat.coroutines.data.Repository
import com.supercat.coroutines.presentation.FirstFragmentViewModel
import com.supercat.coroutines.presentation.MainActivityViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

object Graph {
    val viewModelModule = module {
        viewModel { MainActivityViewModel(get()) }
        viewModel { FirstFragmentViewModel(get()) }
    }

    val repoModule = module {
        single { Repository(get()) }
    }

    val databaseModule = module {
        single {
            Room.databaseBuilder(
                androidContext(),
                Database::class.java,
                DATABASE_NAME,
            )
                .build()
        } bind Database::class

        factory { get<Database>().getEntityDao() }
    }

}
