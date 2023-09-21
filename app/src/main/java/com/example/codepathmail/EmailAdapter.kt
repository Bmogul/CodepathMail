package com.example.codepathmail

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EmailAdapter(private val emailItems: List<EmailItem>)
    : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>(){

//    fun setOnItemClickListener(listener: (position: Int) -> Unit) {
//        onItemClickListener = listener
//    }

    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.sender)
        val subjectTextView: TextView = itemView.findViewById(R.id.subject)
        val messageTextView: TextView = itemView.findViewById(R.id.message)
        val dateView: TextView = itemView.findViewById(R.id.date)
        init {
            // Set an OnClickListener for the entire item view
            itemView.setOnClickListener {
                // Get the adapter position of the clicked item
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedItem = emailItems[position]
                    // Perform the click action here
                    onItemClick(clickedItem, itemView)
                }
            }
        }
    }

    private fun onItemClick(emailItem: EmailItem, itemView: View) {
        emailItem.hasOpened=true
        itemView.setBackgroundColor(Color.parseColor("#A3A3A3"))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.email_layout, parent, false)
        return EmailViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return emailItems.size
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val emailItem = emailItems[position]
        holder.nameTextView.text = emailItem.senderName
        holder.subjectTextView.text = emailItem.subjectLine
        holder.messageTextView.text = emailItem.emailMessage
        holder.dateView.text = formatDateToMonthDay(emailItem.date)

        // Set background color based on 'hasOpened'
//        val backgroundColor = if (emailItem.hasOpened == true) {
//            R.color.color_email_opened
//        } else {
//            R.color.color_email_unopened
//        }

//        holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, backgroundColor))
    }

    fun formatDateToMonthDay(date: Date?): String {
        val dateFormat = SimpleDateFormat("MMMM d", Locale.getDefault())
        return dateFormat.format(date)
    }
}