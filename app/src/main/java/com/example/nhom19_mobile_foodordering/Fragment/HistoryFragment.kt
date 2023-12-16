package com.example.nhom19_mobile_foodordering.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nhom19_mobile_foodordering.R
import com.example.nhom19_mobile_foodordering.adapter.BuyAgainAdapter
import com.example.nhom19_mobile_foodordering.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding:FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        setupRecyclerView()
        return binding.root
    }
    private fun setupRecyclerView() {
        val buyAgainFoodName = arrayListOf("Mỳ xanh", "Kem Vally", "Nem Nướng Nha Trang", "Tokbokki")
        val buyAgainFoodPrice = arrayListOf("45.000đ", "32.000đ", "65.000đ", "78.000đ")
        val buyAgainFoodImage = arrayListOf(R.drawable.menu2, R.drawable.menu3, R.drawable.menu6, R.drawable.menu5)
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage)
        binding.BuyAgainRecyclerView.adapter = buyAgainAdapter
        binding.BuyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
    companion object {

    }
}