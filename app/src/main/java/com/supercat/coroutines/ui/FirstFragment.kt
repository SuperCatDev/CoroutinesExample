package com.supercat.coroutines.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.supercat.coroutines.R
import com.supercat.coroutines.presentation.FirstFragmentViewModel
import kotlinx.android.synthetic.main.fragment_first.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : Fragment() {

    private val viewModel: FirstFragmentViewModel by viewModel()

    private lateinit var adapter: EntitiesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()

        viewModel.observeElements().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.observeShowProgress().observe(viewLifecycleOwner) {
            vProgress.isVisible = it
        }
    }

    private fun initList() {
        adapter = EntitiesAdapter()
        vList.adapter = adapter
        vList.layoutManager = LinearLayoutManager(requireContext())
    }
}
