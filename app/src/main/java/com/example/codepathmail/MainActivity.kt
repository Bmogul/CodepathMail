package com.example.codepathmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private val emailItems = mutableListOf<EmailItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
        for (i in 1..25){
            emailItems.add(EmailItem("John Doe $i", "Meeting Reminder", "Hello, the meeting is scheduled for tomorrow.Lorem ipsum dolor sit amet, consectetur adipiscing elit.", false, getCurrentDateTime()))

        }

        val load = findViewById<Button>(R.id.loadBtn)
        val recyclerView: RecyclerView = findViewById(R.id.emailList)
        val layoutManager = LinearLayoutManager(this)

        var currentItemCount = 10
        var limitedEmails: MutableList<EmailItem> = emailItems.take(currentItemCount).toMutableList()
        val adapter = EmailAdapter(limitedEmails)


        load.setOnClickListener {
            val remainingItems = emailItems.subList(currentItemCount, emailItems.size)

            // Check if there are remaining items to add
            if (remainingItems.isNotEmpty()) {
                val itemsToAdd = if (remainingItems.size >= 10) {
                    remainingItems.subList(0, 10) // Add up to 10 remaining items
                } else {
                    remainingItems // Add all remaining items
                }

                limitedEmails.addAll(itemsToAdd)
                currentItemCount += itemsToAdd.size
                adapter.notifyDataSetChanged()
            } else {
                // Handle the case where there are no more items to load
                // You can show a message or disable the "Load More" button
                // depending on your app's requirements.
                // For example:
                // showToast("No more items to load.")
                // load.isEnabled = false
            }
        }



        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    fun getCurrentDateTime(): Date {
        return Date() // Create a new Date instance representing the current date and time
    }
}