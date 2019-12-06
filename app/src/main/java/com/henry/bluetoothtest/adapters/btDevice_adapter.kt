package com.henry.bluetoothtest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henry.bluetoothtest.R
import com.henry.bluetoothtest.models.BtDevice
import kotlinx.android.synthetic.main.device_item.view.*

class DeviceAdapter(val context: Context, val devices:List<BtDevice>) : RecyclerView.Adapter<DeviceAdapter.viewHolder>() {
    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(deviceName:String?, deviceAddress:String?, pos:Int){
            itemView.txvDeviceName.text = deviceName
            itemView.txvDeviceAddress.text = deviceAddress
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.device_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return devices.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val deviceName:String? = devices[position].name
        val deviceAddress:String? = devices[position].address
        holder.setData(deviceName, deviceAddress, position)
    }
}