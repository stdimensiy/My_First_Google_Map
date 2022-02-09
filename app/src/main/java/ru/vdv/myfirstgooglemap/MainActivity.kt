package ru.vdv.myfirstgooglemap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import ru.vdv.myfirstgooglemap.databinding.AppBarMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: AppBarMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = AppBarMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomAppBar = binding.bottomAppBar
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_menu_point_list-> {
                    // Отслеживание нажатия на кнопку суммарной статистики пользователя
                    navController.navigate(R.id.nav_points_fragment)
                    true
                }
                R.id.item_menu_map-> {
                    // Отслеживание нажатия на кнопку авторизации
                    navController.navigate(R.id.nav_maps_fragment)
                    true
                }
                else -> false
            }
        }

    }


}