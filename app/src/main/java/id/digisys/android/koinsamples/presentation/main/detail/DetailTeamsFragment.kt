package id.digisys.android.koinsamples.presentation.main.detail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.digisys.android.koinsamples.R
import id.digisys.android.koinsamples.data.responses.Team
import id.digisys.android.koinsamples.external.constant.*
import id.digisys.android.koinsamples.external.extention.loadFromUrl
import kotlinx.android.synthetic.main.fragment_detail_teams.*

class DetailTeamsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if(bundle != null){
            val teamData = bundle.getParcelable<Team>(Constant.BUNDLE_KEY)
            teamName.text = teamData?.strTeam
            teamDesc.text = teamData?.strDescriptionEN

            imgTeam.loadFromUrl(teamData?.strTeamBadge)
        }
    }


}
