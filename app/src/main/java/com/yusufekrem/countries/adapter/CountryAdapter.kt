package com.yusufekrem.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yusufekrem.countries.R
import com.yusufekrem.countries.model.Country
import com.yusufekrem.countries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.fragment_country.view.*
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList:ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(var view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.name.text = countryList[position].name
        holder.view.region.text = countryList[position].region

        holder.view.setOnClickListener{
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {

        return countryList.size
    }

    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

}