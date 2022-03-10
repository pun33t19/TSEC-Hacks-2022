package com.example.tsechacksapp.adapters

import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tsechacksapp.LeaderboardElements
import com.example.tsechacksapp.R
import org.w3c.dom.Text

class RecyclerEventAdapter(val context: Context) : RecyclerView.Adapter<RecyclerEventAdapter.EventViewHolder>(){
    val itemList: ArrayList<String> = ArrayList()
    class EventViewHolder(view:View):RecyclerView.ViewHolder(view){
        val txtNameOfEvent : TextView = view.findViewById(R.id.txtNameOfEvent)
        val txtStartTime : TextView = view.findViewById(R.id.txtStart_Time)
        val txtEndTime : TextView = view.findViewById(R.id.txtEnd_Time)
        val txtDuration : TextView = view.findViewById(R.id.txtDuration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_event_single_row,parent,false)

        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val text = itemList[position]
        holder.txtNameOfEvent.text = text
        holder.txtStartTime.text = text
        holder.txtEndTime.text = text
        holder.txtDuration.text = text
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}


