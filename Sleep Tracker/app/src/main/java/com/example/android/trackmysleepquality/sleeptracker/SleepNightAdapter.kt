package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight

/**
 * Created by Mayokun Adeniyi on 2019-11-24.
 */

class SleepNightAdapter: RecyclerView.Adapter<SleepNightAdapter.ViewHolder>(){

    var data = listOf<SleepNight>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
                inflate(R.layout.sleep_item_list,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources
        holder.sleepQuality.text = convertNumericQualityToString(item.sleepQuality,res)
        holder.sleepLength.text = convertDurationToFormatted(item.startTimeMilli,item.endTimeMilli,res)
        holder.qualityImage.setImageResource(when(item.sleepQuality){
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2
            3 -> R.drawable.ic_sleep_3
            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_sleep_active
        })
    }



    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val sleepLength: TextView = itemView.findViewById(R.id.sleep_length)
        val sleepQuality: TextView = itemView.findViewById(R.id.quality_string)
        val qualityImage: ImageView = itemView.findViewById(R.id.quality_image)

    }

}