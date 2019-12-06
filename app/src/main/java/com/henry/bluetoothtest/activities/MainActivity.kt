package com.henry.bluetoothtest.activities

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.henry.bluetoothtest.R
import com.henry.bluetoothtest.models.BtDevice
import com.henry.bluetoothtest.models.Suppliers
import com.henry.bluetoothtest.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bluetoothAdapter : BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
        if (bluetoothAdapter == null) {
            showToast(
                this,
                resources.getString(R.string.bluetooth_not_supported)
            )
        }

        if (bluetoothAdapter?.isEnabled == false) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, 1)
        } else {
            val pairedDevices: Set<BluetoothDevice>? = bluetoothAdapter!!.bondedDevices
            pairedDevices?.forEachIndexed {index,device ->
                val deviceName = device.name
                val deviceHardwareAddress = device.address
                Suppliers.BtDevices.add(index, BtDevice(deviceName, deviceHardwareAddress))
            }
        }

        btnShowDevices.setOnClickListener {
            val intent = Intent(this, ShowDevicesActivity::class.java)
            startActivity(intent)
        }
    }
}
