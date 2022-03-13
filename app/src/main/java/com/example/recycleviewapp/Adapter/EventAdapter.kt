package com.example.recycleviewapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewapp.MiLista
import com.example.recycleviewapp.Model.Event
import com.example.recycleviewapp.R
import com.example.recycleviewapp.Views.ThirdFragment
import com.example.recycleviewapp.fragmentNavigation


class EventAdapter(private val onEventClicked: EventClicked) : RecyclerView.Adapter<EventViewHolder>() {

    // This method will update our data set
    fun updateEventData(event: Event) {
        //eventList.add(0, event)
        MiLista.agregar(event)
        // this guy will notify adapter a new item has been introduces
        notifyDataSetChanged()
    }

    fun updateDataRemove(event: Event){
        MiLista.quitar(event)
        notifyDataSetChanged()
    }
    /**
     * Here you are creating your view holder that holds you views to be bound
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        // here i am inflating my EVENT ITEM coming from the XML file
        val eventView = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(eventView, onEventClicked)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = MiLista.eventos[position]
        //val event = eventList[position]

        holder.bind(event)
    }

    override fun getItemCount(): Int = MiLista.eventos.size
}

class EventViewHolder(itemView: View, private val eventClicked: EventClicked) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.EVENT_Title)
    private val category: TextView = itemView.findViewById(R.id.EVENT_Category)
    private val date: TextView = itemView.findViewById(R.id.EVENT_Date)

    val context = itemView.context
    val manager: FragmentManager = (context as AppCompatActivity).supportFragmentManager


    fun bind(event: Event) {
        title.text = event.Titulo
        category.text = event.Categoria
        date.text = event.Fecha

        itemView.setOnClickListener {
            eventClicked.onEventClicked(event)
        }

        /**
         * If you need to switch to another fragment, should happen in the fragment itself
         *
         * you can have another method in the interface for that.
         */
        title.setOnClickListener {
            fragmentNavigation(
                //manager, ThirdFragment.newInstance(event.Titulo,event.Categoria, event.Titulo)
                manager, ThirdFragment.newInstance(event)
            )
        }
    }
}