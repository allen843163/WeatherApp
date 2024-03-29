package com.allen.weatherapp.ui.weatherforecast.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.allen.weatherapp.R
import com.allen.weatherapp.databinding.FragmentWeatherForecastBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules


class WeatherForecastFragment : Fragment() {
    init {
        loadKoinModules(WeatherForecastModule)
    }

    lateinit var binding : FragmentWeatherForecastBinding

    val viewModel : WeatherForecastVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather_forecast, container, false)

        binding.weatherforecastviewmodel = viewModel

        arguments?.let {
            binding.root.findViewById<RecyclerView>(R.id.lv_forecast_report).adapter = ForecastReportAdapter(it.getParcelable("record"))
        }

        return binding.root
    }

}