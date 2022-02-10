package ru.vdv.myfirstgooglemap.ui.points

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomappbar.BottomAppBar
import ru.vdv.myfirstgooglemap.R
import ru.vdv.myfirstgooglemap.databinding.PointsFragmentBinding

class PointsFragment : Fragment() {
    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var viewModel: PointsViewModel
    private lateinit var adapter: PointsAdapter
    private var _binding: PointsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PointsFragmentBinding.inflate(inflater, container, false)
        val root = binding.root
        adapter = PointsAdapter()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PointsViewModel::class.java)
        viewModel.getAllPoints()
        val listOfPoints = binding.pointList
        listOfPoints.adapter = adapter
        listOfPoints.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewModel.preparePointsList.observe(viewLifecycleOwner) {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }
    }

    override fun onStart() {
        super.onStart()
        bottomAppBar = requireActivity().findViewById(R.id.bottomAppBar)
        bottomAppBar.replaceMenu(R.menu.point_list_fragment_menu)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}