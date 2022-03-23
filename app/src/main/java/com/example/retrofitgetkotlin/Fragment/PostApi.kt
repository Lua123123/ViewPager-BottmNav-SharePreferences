package com.example.retrofitgetkotlin.Fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.retrofitgetkotlin.R
import com.example.retrofitgetkotlin.databinding.FragmentPostApiBinding
import com.example.retrofitgetkotlin.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PostApi : Fragment() {
    val mainViewModel: MainViewModel by sharedViewModel()

    lateinit var dataBinding: FragmentPostApiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_api, container, false)
        dataBinding.viewmodel = mainViewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner
        return dataBinding.root
    }

    //xử lý để trong đây, tương tự như onCreate
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.btnPostapi?.setOnClickListener(View.OnClickListener { item: View? -> mainViewModel!!.mutableLiveDataClickPostApi() })

    }
}