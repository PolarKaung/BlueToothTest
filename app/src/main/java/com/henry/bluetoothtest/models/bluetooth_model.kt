package com.henry.bluetoothtest.models

data class BtDevice(val name:String?, val address: String?)

object Suppliers {
    val BtDevices = mutableListOf<BtDevice>(

    )
}