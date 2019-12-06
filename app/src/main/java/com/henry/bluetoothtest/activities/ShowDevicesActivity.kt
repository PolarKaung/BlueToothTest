package com.henry.bluetoothtest.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.henry.bluetoothtest.R
import com.henry.bluetoothtest.adapters.DeviceAdapter
import com.henry.bluetoothtest.models.Suppliers
import kotlinx.android.synthetic.main.activity_showdevices.*

class ShowDevicesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showdevices)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvDevices.layoutManager = layoutManager

        val adapter = DeviceAdapter(this, Suppliers.BtDevices)
        rvDevices.adapter = adapter
    }
}