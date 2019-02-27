package id.digisys.android.koinsamples

import android.app.Application
import id.digisys.android.koinsamples.koin.appComponent
import org.koin.android.ext.android.startKoin

/**
 * Created by Moh Eric on 17/02/2019.
 *
 * Copyright (c) 2019 Digital System Indonesia. All rights reserved.
 */
class MainApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(this, appComponent)
    }
}