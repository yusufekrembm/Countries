package com.yusufekrem.countries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yusufekrem.countries.R
import com.yusufekrem.countries.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {
    private lateinit var viewModel : CountryViewModel

    private var countryUuid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom()



        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUUID
        }
        observeLiveData()
    }
    private fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer {country->
            country?.let {
                countryName.text = country.name
                countryCapital.text = country.capital
                countryCurrency.text = country.currency
                countryLanguage.text = country.language
                countryRegion.text = country.region
            }
        })
    }
    }
