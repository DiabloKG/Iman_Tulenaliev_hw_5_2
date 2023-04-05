package com.example.iman_tulenaliev_hw_5_2.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.iman_tulenaliev_hw_5_2.R
import com.example.iman_tulenaliev_hw_5_2.databinding.FragmentOnBoardBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class onBoardFragment : Fragment() {

    lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val adapter = BoardingAdapter(childFragmentManager)
        binding.vp.adapter = adapter

    }
}