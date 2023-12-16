package com.example.nhom19_mobile_foodordering.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nhom19_mobile_foodordering.R
import com.example.nhom19_mobile_foodordering.adapter.CartAdapter
import com.example.nhom19_mobile_foodordering.databinding.CartItemBinding
import com.example.nhom19_mobile_foodordering.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var binding:FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFoodName = listOf("Kem vally", "Canh Trường Thọ", "Mỳ xanh", "Bánh Herbal", "Xà lách trộn", "Tokbokki")
        val cartItemPrice = listOf("32.000đ", "188.000đ", "45.000đ", "102.000đ", "91.000đ", "78.000đ")
        val cartImage = listOf(
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu2,
            R.drawable.menu1,
            R.drawable.menu6,
            R.drawable.menu5,
        )
        val adapter = CartAdapter(ArrayList(cartFoodName), ArrayList(cartItemPrice), ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}