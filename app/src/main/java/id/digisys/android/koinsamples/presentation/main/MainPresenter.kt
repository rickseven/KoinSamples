package id.digisys.android.koinsamples.presentation.main

import android.content.Context
import com.google.gson.Gson
import id.digisys.android.koinsamples.data.responses.FootbalClubData
import id.digisys.android.koinsamples.data.responses.Team

/**
 * Created by Moh Eric on 17/02/2019.
 *
 * Copyright (c) 2019 Digital System Indonesia. All rights reserved.
 */
class MainPresenter (val context: Context,  val gson: Gson) :
    MainContract.UserActionListener {

    private var view : MainContract.View? = null

    override fun setupView(view: MainContract.View) {
        this.view = view
    }

    override fun searchTeam(searchText: String?) {
        if(!searchText.isNullOrEmpty()){
            try {
                val inputStream = context.assets.open("json/football_club.json")
                val inputString = inputStream.bufferedReader().use{it.readText()}
                val footballJson = gson.fromJson(inputString, FootbalClubData::class.java)
                val footbalData = footballJson.teams?.filter {
                    it?.strTeam?.toLowerCase()?.contains(searchText.toLowerCase()) == true
                }

                if(!footbalData.isNullOrEmpty()){
                    fetchTeamData(footbalData.first())
                }else{
                    view?.showError("Data tidak ditemukan!")
                }
            }catch (error: Exception){
                view?.showError(error.message.toString())
            }
        }else{
            view?.showError("Silahkan isi nama team yang dicari!")
        }
    }

    override fun fetchTeamData(teamData: Team?) {
        view?.showTeamData(teamData)
    }





}