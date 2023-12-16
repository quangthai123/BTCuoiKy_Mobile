package com.example.nhom19_mobile_foodordering

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nhom19_mobile_foodordering.adapter.MenuAdapter
import com.example.nhom19_mobile_foodordering.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)
        binding.buttonBack.setOnClickListener {
            dismiss()
        }
        val menuFoodName = listOf("Kem vally", "Canh Trường Thọ", "Mỳ xanh", "Bánh Herbal", "Xà lách trộn", "Tokbokki", "Canh Trường Thọ", "Mỳ xanh", "Bánh Herbal", "Xà lách trộn", "Tokbokki")
        val menuItemPrice = listOf("32.000đ", "188.000đ", "45.000đ", "102.000đ", "91.000đ", "78.000đ",  "45.000đ", "102.000đ", "32.000đ", "188.000đ", "45.000đ")
        val menuImage = listOf(
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu2,
            R.drawable.menu1,
            R.drawable.menu6,
            R.drawable.menu5,
            R.drawable.menu4,
            R.drawable.menu2,
            R.drawable.menu1,
            R.drawable.menu6,
            R.drawable.menu3
        )
        val adapter = MenuAdapter(ArrayList(menuFoodName), ArrayList(menuItemPrice), ArrayList(menuImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}