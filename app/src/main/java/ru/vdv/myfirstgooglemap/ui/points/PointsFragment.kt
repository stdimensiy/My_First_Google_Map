package ru.vdv.myfirstgooglemap.ui.points

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomappbar.BottomAppBar
import ru.vdv.myfirstgooglemap.R

class PointsFragment : Fragment() {
    private lateinit var bottomAppBar: BottomAppBar

    private lateinit var viewModel: PointsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.points_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PointsViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        bottomAppBar = requireActivity().findViewById(R.id.bottomAppBar)
        bottomAppBar.replaceMenu(R.menu.point_list_fragment_menu)
    }

}