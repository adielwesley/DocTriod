package com.upgrade.doctriod.features.listdoctors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upgrade.doctriod.databinding.DoctorItemBinding
import com.upgrade.doctriod.models.Doctor
import com.upgrade.doctriod.view.AdapterItemsContract

class DoctorAdapter(var items: List<Doctor>) : RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>(),
    AdapterItemsContract {

    override fun replaceItems(items : List<*>) {
        this.items = items as List<Doctor>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DoctorItemBinding.inflate(inflater, parent, false)
        return DoctorViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    class DoctorViewHolder(private val binding: DoctorItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(doctor: Doctor) {
            binding.doctor = doctor
            binding.executePendingBindings()
        }
    }
}