package com.example.nhom19_mobile_foodordering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.nhom19_mobile_foodordering.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {
    private val binding: ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationList = arrayOf("Ba Đình","Bắc Từ Liêm","Cầu Giấy","Đống Đa","Hà Đông","Hai Bà Trưng","Hoàn Kiếm","Hoàng Mai","Long Biên","Nam Từ Liêm","Tây Hồ","Thanh Xuân")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)
    }
}