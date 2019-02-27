package id.digisys.android.koinsamples.presentation.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.digisys.android.koinsamples.R
import id.digisys.android.koinsamples.data.responses.Team
import id.digisys.android.koinsamples.domain.router.openFragment
import id.digisys.android.koinsamples.external.constant.Constant
import id.digisys.android.koinsamples.presentation.main.detail.DetailTeamsFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainContract.View {

    val presenter : MainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setupView(this)
        setupUIListener()
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun showTeamData(teamData: Team?) {
        //toast(teamData?.strTeam.toString())
        val bundle = Bundle()
        bundle.putParcelable(Constant.BUNDLE_KEY, teamData)
        supportFragmentManager.openFragment(R.id.layoutSearchResult,
            DetailTeamsFragment(),bundle)

    }

    override fun setupUIListener() {
        btnSearch.setOnClickListener {
            val searchtext = etSearchTeam.text.toString()
            presenter.searchTeam(searchtext)
        }
    }
}
