package ru.vdv.myfirstgooglemap.ui.main

import androidx.fragment.app.Fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomappbar.BottomAppBar
import ru.vdv.myfirstgooglemap.R
import ru.vdv.myfirstgooglemap.ui.points.PointsViewModel

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val spb = LatLng(59.9386, 30.3141)
        googleMap.addMarker(MarkerOptions().position(spb).title("Санкт-Петербург"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(spb))
        googleMap.setOnMapLongClickListener {
            googleMap.addMarker(MarkerOptions().position(LatLng(it.latitude, it.longitude)))
            viewModel.savePoint(it.latitude, it.longitude)
        }

    }
    private lateinit var viewModel: PointsViewModel
    private lateinit var bottomAppBar: BottomAppBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        viewModel = ViewModelProvider(this).get(PointsViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        bottomAppBar = requireActivity().findViewById(R.id.bottomAppBar)
        bottomAppBar.replaceMenu(R.menu.map_fragment_menu)
    }
}