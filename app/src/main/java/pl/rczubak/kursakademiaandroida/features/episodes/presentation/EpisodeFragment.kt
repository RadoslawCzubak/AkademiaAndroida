package pl.rczubak.kursakademiaandroida.features.episodes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import pl.rczubak.kursakademiaandroida.R
import pl.rczubak.kursakademiaandroida.core.base.BaseFragment

class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModels()

    override fun initViews() {
        super.initViews()
        //init all view-related classes
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun handleIdleState() {
        super.handleIdleState()
        //TODO: Handle idle state
    }

    override fun handlePendingState() {
        super.handlePendingState()
        //TODO: Handle pending state
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(viewLifecycleOwner) {
            // TODO: Display episodes
        }
    }
}