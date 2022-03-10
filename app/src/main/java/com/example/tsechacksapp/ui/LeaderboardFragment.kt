package com.example.tsechacksapp.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tsechacksapp.LeaderboardElements
import com.example.tsechacksapp.R
import com.example.tsechacksapp.adapters.RecyclerLeaderboardAdapter


class LeaderboardFragment : Fragment() {
    lateinit var recyclerView1: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    val leaderboard = arrayListOf(LeaderboardElements("Prasad Ranjane",50,1),
        LeaderboardElements("Siddhesh Shetty",45,2),
        LeaderboardElements("Puneet Shetty",40,3),
        LeaderboardElements("Yash Tripathi",30,4),
        LeaderboardElements("Mokshit Surana",25,5))

    lateinit var recyclerAdapter1 : RecyclerLeaderboardAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_leaderboard, container, false)

        recyclerView1 = view.findViewById(R.id.recyclerLeaderboard)
        layoutManager = LinearLayoutManager(activity)

        recyclerAdapter1 = RecyclerLeaderboardAdapter(activity as Context, leaderboard)
        return view





    }


}