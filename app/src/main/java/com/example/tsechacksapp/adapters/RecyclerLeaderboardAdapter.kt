package com.example.tsechacksapp.adapters

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tsechacksapp.LeaderboardElements
import com.example.tsechacksapp.R

class RecyclerLeaderboardAdapter(val context: Context, val itemList: ArrayList<LeaderboardElements>) : RecyclerView.Adapter<RecyclerLeaderboardAdapter.LeaderBoardViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderBoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_leaderboard_single_row,parent,false)
        return LeaderBoardViewHolder(view)


    }

    override fun onBindViewHolder(holder: LeaderBoardViewHolder, position: Int) {
        val text = itemList[position]
        holder.textName.text = text.name
        holder.textScore.text= text.score.toString()
        holder.textRank.text = text.rank.toString()

    }

    override fun getItemCount(): Int {
        return itemList.size

    }
    class LeaderBoardViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textName : TextView = view.findViewById(R.id.txtName)
        val textScore : TextView = view.findViewById(R.id.txtScore)
        val textRank : TextView = view.findViewById(R.id.txtRank)

    }


}