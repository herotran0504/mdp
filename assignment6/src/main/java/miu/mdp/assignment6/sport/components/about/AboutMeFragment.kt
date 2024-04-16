package miu.mdp.assignment6.sport.components.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import miu.mdp.assignment6.R
import miu.mdp.assignment6.databinding.FragmentAboutMeBinding
import miu.mdp.assignment6.sport.data.ProfileRepository
import miu.mdp.core.BaseFragment

class AboutMeFragment : BaseFragment<FragmentAboutMeBinding>() {
    private val repository = ProfileRepository()

    override fun initializeBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAboutMeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val profile = repository.data
        binding.name.text = profile.name
        binding.about.text = profile.about
        val radius = requireContext().resources.getDimensionPixelSize(R.dimen.corner_radius)
        Glide.with(requireContext())
            .load(profile.avatar)
            .transform(RoundedCorners(radius))
            .fitCenter()
            .transition(DrawableTransitionOptions.withCrossFade()).into(binding.avatar)
    }
}
