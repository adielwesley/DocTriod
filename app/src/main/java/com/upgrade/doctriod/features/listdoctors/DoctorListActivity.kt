package com.upgrade.doctriod.features.listdoctors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.upgrade.doctriod.DocTriodApplication
import com.upgrade.doctriod.R
import com.upgrade.doctriod.data.DoctorRepository
import com.upgrade.doctriod.data.mockdata.MockDataSource
import com.upgrade.doctriod.di.DoctorComponent
import com.upgrade.doctriod.viewmodel.DoctorViewModel
import javax.inject.Inject

class DoctorListActivity : AppCompatActivity() {

    lateinit var doctorComponent : DoctorComponent

    @Inject lateinit var viewModel : DoctorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        doctorComponent =
            (applicationContext as DocTriodApplication).appComponent.doctorComponent().create()
        doctorComponent.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val finalHost = NavHostFragment.create(R.navigation.doctor_graph)
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host, finalHost)
            .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
            .commit()

//        viewModel = createViewModel()
//
//        val binding = DataBindingUtil
//            .setContentView<ActivityDoctorListBinding>(this,
//                R.layout.fragment_doctor_list
//            )
//        binding.viewModel = viewModel
//        binding.doctorsList.adapter =
//            DoctorAdapter(emptyList())
//        binding.doctorsList.layoutManager = LinearLayoutManager(this)
    }

    private fun createViewModel(): DoctorViewModel {
        val dataSource = MockDataSource()
        return DoctorViewModel(DoctorRepository(dataSource))
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }
}
