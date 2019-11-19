package com.upgrade.doctriod.features.listdoctors

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.upgrade.doctriod.data.DoctorRepository
import com.upgrade.doctriod.data.mockdata.MockDataSource
import com.upgrade.doctriod.databinding.FragmentDoctorListBinding
import com.upgrade.doctriod.viewmodel.DoctorViewModel
import javax.inject.Inject

class ListDoctorFragment : Fragment() {

    @Inject
    lateinit var viewModel : DoctorViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity as DoctorListActivity).doctorComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        //viewModel = createViewModel()

        val binding = FragmentDoctorListBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.doctorsList.adapter =
            DoctorAdapter(emptyList())
        binding.doctorsList.layoutManager = LinearLayoutManager(activity)

        return binding.root
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