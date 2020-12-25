package com.homeandroid.weather.di


import com.homeandroid.weather.network.ApiRepository
import com.homeandroid.weather.ui.WeatherViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val applicationModule = module {
    single { provideLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { ApiRepository(get()) }
   // single { provideListFragment() }
   // single { provideViewPagerFragmentAdapter(get(),get()) }

}


val viewModelsModule = module {

    viewModel { WeatherViewModel(get()) }


}