package com.example.retrofitgetkotlin.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.retrofitgetkotlin.R
import com.example.retrofitgetkotlin.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CallApi : Fragment() {
    var txtTitle: TextView? = null
    var txtLocationtype: TextView? = null
    var txtWoeid: TextView? = null
    var txtLatlng: TextView? = null
    var btnCallapi: Button? = null
    var btnSave: Button? = null
    var btnClear: Button? = null

    //shared_preference
    var sharedPreferences: SharedPreferences? = null

    val mainViewModel: MainViewModel by sharedViewModel()

//    lateinit var dataBinding: FragmentCallApiBinding

    //sử dụng để gắn layout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view = inflater.inflate(R.layout.fragment_call_api, container, false)
//        return view
//        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_call_api, container, false)
//        dataBinding.viewmodel = mainViewModel
//        dataBinding.lifecycleOwner = viewLifecycleOwner
//        return dataBinding.root
        val view = inflater.inflate(R.layout.fragment_call_api, container, false)
        return view
    }


    //xử lý để trong đây, tương tự như onCreate
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtTitle = view.findViewById(R.id.txtTitle)
        txtLocationtype = view.findViewById(R.id.txtLocationtype)
        txtWoeid = view.findViewById(R.id.txtWoeid)
        txtLatlng = view.findViewById(R.id.txtLatlng)
        btnCallapi = view.findViewById(R.id.btnCallapi)
        btnClear = view.findViewById(R.id.btnClear)
        btnSave = view.findViewById(R.id.btnSave)

        sharedPreferences = this.activity!!.getSharedPreferences("data", Context.MODE_PRIVATE)

        btnCallapi?.setOnClickListener(View.OnClickListener {
                item: View? -> mainViewModel!!.mutableLiveDataClickCallApi() })

        btnSave?.setOnClickListener(View.OnClickListener {
            var editor: SharedPreferences.Editor? = sharedPreferences?.edit()
            val title = txtTitle?.getText().toString().trim()
            val locationtype = txtLocationtype?.getText().toString().trim()
            val woeid = txtWoeid?.getText().toString().trim()
            val latlng = txtLatlng?.getText().toString().trim()
            editor?.putString("title", title)
            editor?.putString("locationtype", locationtype)
            editor?.putString("woeid", woeid)
            editor?.putString("latlng", latlng)
            editor?.commit()
        })

        txtTitle?.setText(sharedPreferences?.getString("title", ""))
        txtLocationtype?.setText(sharedPreferences?.getString("locationtype", ""))
        txtWoeid?.setText(sharedPreferences?.getString("woeid", ""))
        txtLatlng?.setText(sharedPreferences?.getString("latlng", ""))

        btnClear?.setOnClickListener(View.OnClickListener {
            var editor: SharedPreferences.Editor? = sharedPreferences?.edit()
            editor?.remove("title")
            editor?.remove("locationtype")
            editor?.remove("woeid")
            editor?.remove("latlng")
            editor?.commit()
        })


        mainViewModel.mWeathers.observe(this, Observer {
            txtTitle!!.text = it!![0].title
            txtLocationtype!!.text = it[0].locationType
            txtWoeid!!.text = (it[0].woeid.toString())
            txtLatlng!!.text = it[0].lattLong
        })
    }
}