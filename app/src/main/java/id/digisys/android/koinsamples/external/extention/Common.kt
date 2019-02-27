package id.digisys.android.koinsamples.external.extention

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Moh Eric on 17/02/2019.
 *
 * Copyright (c) 2019 Digital System Indonesia. All rights reserved.
 */
fun ImageView.loadFromUrl(url: String?){
    Picasso.get()
        .load(url)
        .fit()
        .centerCrop()
        .into(this)
}