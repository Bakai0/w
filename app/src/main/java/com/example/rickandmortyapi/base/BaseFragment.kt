package com.example.rickandmortyapi.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.viewbinding.ViewBinding
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.model.CharacterModel

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setupObserve()
        getData()
    }

    protected open fun initialize() {}

    protected open fun setupListener() {}

    protected open fun setupObserve() {}

    protected open fun getData() {}
}