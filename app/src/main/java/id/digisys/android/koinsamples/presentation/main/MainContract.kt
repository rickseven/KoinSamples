package id.digisys.android.koinsamples.presentation.main

import id.digisys.android.koinsamples.data.responses.Team

/**
 * Created by Moh Eric on 17/02/2019.
 *
 * Copyright (c) 2019 Digital System Indonesia. All rights reserved.
 */
class MainContract{
    interface View{
        fun setupUIListener()
        fun showTeamData(teamData: Team?)
        fun showError(message: String)
    }
    interface UserActionListener{
        fun setupView(view: View)
        fun searchTeam(searchText: String?)
        fun fetchTeamData(teamData: Team?)
    }
}