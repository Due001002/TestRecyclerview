package com.example.testrecyclerview

import android.app.PendingIntent.*
import android.content.Context
import android.media.session.PlaybackState
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.*
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.marginLeft
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils
import com.google.firebase.*
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.FirebaseFirestore.*
//import com.google.firebase.firestore.FirebaseFirestore.getInstance
import java.sql.RowId
import java.util.ArrayList
import kotlin.coroutines.coroutineContext


class MainActivity : AppCompatActivity() {
    var db = getInstance()
    var dbRoomName = db.collection("RoomName")
    var ArrayShowRecyclerview = mutableListOf<String>()
    var foods = arrayListOf<String>(
        "1.Minced pork omelette",
        "2.Stir fried pork with basil",
        "3.Papaya salad",
        "4.Boiled egg, Bael leaves",
        "5.Pad Thai",
        "6.Korat Noodle",
        "7.Shrimp Salad",
        "8.Boiled pork noodles",
        "9.Steamed sea",
        "10.Steamed rices",
        "11.Pork Belly",
        "12.Liang Vegetable Fried Eggs"
    )
    var data = mutableListOf<Map<String, Any>>(
        mapOf("name" to "a", "value" to 10),
        mapOf("name" to "b", "value" to 50),
        mapOf("name" to "c", "value" to 55)
    )
    var abc = "abc"

    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main)
        //setView()
        databaseShowRecyclerview()

    }

    //TODO databaseShowRecyclerview
    private fun databaseShowRecyclerview() {
        var room = "room"
        for (i in 1..10) {
            var updateData = mapOf<String,Any>("name" to "$room$i")
            dbRoomName.document("$room$i").update(updateData)

        }
    }

    //TODO setView2
    private fun setView2() {
        var x = 1
        if (x == 1) {
            x += 1
        }
        if (x == 2) {
            x += 1
        }
        if (x == 3) {
            x += 1
        }
        logdfix(abc,"x= $x")
    }

    //TODO testArrayMap
    fun testArrayMap() {
        var a1 = mutableListOf<Any>()
        var a2 = a1.asReversed()
        var dataSortValue = mutableListOf<Map<String, Any>>()

        var data2 = mutableListOf<Int>(5, 610, 50, 7, 8, 9)

        for (i in data) {
            var a = i.get("value").toString().toInt()
            a1.add(a)
            logdfix(abc, "${a1}")
        }

        dataSortValue = data.asReversed()
        logdfix(abc, "a2_asReversed: ${a2}")
        logdfix(abc, "dataSortValue: ${dataSortValue}")
        logdfix(abc, "data.asReversed(): ${data.asReversed()}")
    }

    //TODO setView
    fun setView() {
        var a = 0
        for (i in 1..100) {
            var gg = "a$i"
            foods.add(gg)
            recyclerView = findViewById(R.id.recyclerView) as RecyclerView
            recyclerView!!.layoutManager = LinearLayoutManager(this)
            recyclerView!!.setLayoutManager(GridLayoutManager(this, 1))
            var setAdapter = MyAdapter(foods)
            recyclerView!!.adapter = setAdapter
        }
    }

    //TODO Logd
    fun logdfix(str: String, str2: String) {
        Log.d(str, str2)
    }
}

//var data: MutableList<Map<String,Any>>
class MyAdapter(var data: ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.activity_text_view_recycler_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var getText = holder.itemView.findViewById<TextView>(R.id.textView2)
        getText.text = data.get(position).toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}




