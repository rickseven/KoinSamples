package id.digisys.android.koinsamples.domain.router

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by Moh Eric on 17/02/2019.
 *
 * Copyright (c) 2019 Digital System Indonesia. All rights reserved.
 */
fun FragmentManager.openFragment(container: Int, fragmment: Fragment, bundle: Bundle? = null) {
    if(bundle != null){
        fragmment.arguments = bundle
    }

    val transition = beginTransaction()
    transition.replace(container, fragmment)
    transition.addToBackStack(null)
    transition.commit()
}