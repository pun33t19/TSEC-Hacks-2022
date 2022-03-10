package com.example.tsechacksapp.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.tsechacksapp.EventElements
import com.example.tsechacksapp.LeaderboardElements
import com.example.tsechacksapp.R
import com.example.tsechacksapp.adapters.RecyclerEventAdapter


class EventFragment : Fragment() {
    lateinit var recyclerView2 : RecyclerView
    lateinit var layoutManager2 : RecyclerView.LayoutManager
    lateinit var recyclerEventAdapter : RecyclerEventAdapter
    var currentUrl : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        recyclerView2 = view.findViewById(R.id.recyclerView2)


        layoutManager2 = LinearLayoutManager(activity)
        recyclerEventAdapter = RecyclerEventAdapter(requireContext())
        recyclerView2.adapter = recyclerEventAdapter
        recyclerView2.layoutManager = layoutManager2

        fetchData()
        return view
    }
    private fun fetchData() {
        Log.d("Running API","Escape")
        val queue = Volley.newRequestQueue(requireContext())
        val url = "https://kontests.net/api/v1/all"
        val jsonObjectRequest = JsonArrayRequest(
            Request.Method.GET,url,null,
            {
            Log.e("JSONArray",it.toString())
                val eventJsonObject = it.getJSONObject(1)
                val eventArray = ArrayList<EventElements>()
                Log.d("Error", eventArray.size.toString())
                for(i in 0 until it.length()){

                    val newsJsonObject = it.getJSONObject(i)
                    val news = EventElements(
                        newsJsonObject.getString("name"),
                        newsJsonObject.getString("start_time"),
                        newsJsonObject.getString("end_time"),
                        newsJsonObject.getString("duration")
                    )
                    eventArray.add(news)
                }
            },
            {
                Log.e("JSON API Error", it.toString())
            }

        )
        queue.add(jsonObjectRequest)
    }



}

