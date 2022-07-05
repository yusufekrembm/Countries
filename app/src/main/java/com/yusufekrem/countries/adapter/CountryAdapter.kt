package com.yusufekrem.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yusufekrem.countries.R
import com.yusufekrem.countries.databinding.ItemCountryBinding
import com.yusufekrem.countries.model.Country
import com.yusufekrem.countries.util.downloadFromUrl
import com.yusufekrem.countries.util.placeholderProgressBar
import com.yusufekrem.countries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.fragment_country.view.*
import kotlinx.android.synthetic.main.fragment_feed.view.*
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList:ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(),CountryClickListener {

    class CountryViewHolder(var view : ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
       // val view = inflater.inflate(R.layout.item_country,parent,false)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.country = countryList[position] // bir satır kod yeterli
        holder.view.listener = this









//        holder.view.name.text = countryList[position].name
//        holder.view.region.text = countryList[position].region
//        holder.view.imageView.downloadFromUrl(countryList[position].imageUrl, placeholderProgressBar(holder.view.context))
//
//        holder.view.setOnClickListener{
//            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryList[position].uuid)
//            //action.countryUUID
//
//            Navigation.findNavController(it).navigate(action)
//        }

    }

    override fun getItemCount(): Int {

        return countryList.size
    }

    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {
        val uuid = v.countryUuid.text.toString().toInt()
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
        //  action.countryUUID
         Navigation.findNavController(v).navigate(action)
    }

}