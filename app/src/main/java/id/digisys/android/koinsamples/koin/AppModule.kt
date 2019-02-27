package id.digisys.android.koinsamples.koin

import com.google.gson.Gson
import id.digisys.android.koinsamples.presentation.main.MainPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

/**
 * Created by Moh Eric on 17/02/2019.
 *
 * Copyright (c) 2019 Digital System Indonesia. All rights reserved.
 */
val appModule = module{
    single { Gson() }
    factory { MainPresenter(androidContext(), get()) }
}