package com.example.horoscopo_android
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo_android.R

class HoroscopeAdapter(
    val items: List<Horoscope>,
    val onItemClick: (position: Int) -> Unit
) : RecyclerView.Adapter<HoroscopeViewHolder>() {

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope,parent,false)
    return HoroscopeViewHolder(view)
}

override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
    val horoscope = items[position]
    holder.render(horoscope)
    holder.itemView.setOnClickListener {
        onItemClick(position)
    }
}

// Cuántos elementos tengo que mostrar
override fun getItemCount(): Int {
    return items.size
    }
}


class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val signImageView: ImageView = view.findViewById(R.id.signImageView)
    val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    val datesTextView : TextView = view.findViewById(R.id.datesTextView)

    fun render(horoscope: Horoscope) {
        nameTextView.setText(horoscope.name)
        datesTextView.setText(horoscope.dates)
        signImageView.setImageResource(horoscope.sign)
    }
}