package com.danielsoto.spacephotos.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.danielsoto.spacephotos.databinding.FragmentOverviewBinding

class OverviewFragment: Fragment() {
    private val viewModel : OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photoGrid.adapter = PhotoGridAdapter()
        return binding.root
    }
}