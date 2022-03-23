package com.example.retrofitgetkotlin.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.retrofitgetkotlin.R
import com.example.retrofitgetkotlin.adapter.ViewPagerAdapter
import com.example.retrofitgetkotlin.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    //view pager
    private lateinit var mViewPager: ViewPager
    var navigationView: BottomNavigationView? = null

    //MVVM
    val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        mainViewModel.mutableLiveDataClickCallApi()

//        val engineer: Engineer = Engineer()
//        val motor: Motor = Motor()
//        motor.KoinMotor()
//          val motor = get<Motor>()
//          motor.KoinMotor()

        initView();

    }

    private fun initView() {
        mViewPager = findViewById<ViewPager>(R.id.view_pager)
        navigationView = findViewById(R.id.bottom_nav)

        setUpViewPager();

        navigationView?.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.call_api -> mViewPager.setCurrentItem(0);
                R.id.pos_api -> mViewPager.setCurrentItem(1);
                R.id.view_pager -> mViewPager.setCurrentItem(2);
            }
            true
        })


//        mainViewModel.mWeathers.observe(this)
//        {
//            txtTitle!!.text = it!![0].title
//            txtLocationtype!!.text = it[0].locationType
//            txtWoeid!!.text = String.valueOf(it[0].woeid)
//            txtLatlng!!.text = it[0].lattLong
//        }

//        mainViewModel.mUsers.observe(this)
//        {
//            txtPostapi!!.text = it!!.toString()
//        }
    }

    private fun setUpViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(
            supportFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        mViewPager.setAdapter(viewPagerAdapter);

        //vuốt
        mViewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> navigationView?.getMenu()?.findItem(R.id.call_api)?.setChecked(true)
                    1 -> navigationView?.getMenu()?.findItem(R.id.pos_api)?.setChecked(true)
                    2 -> navigationView?.getMenu()?.findItem(R.id.view_pager)?.setChecked(true)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frameLayout, fragment)
//        fragmentTransaction.commit()
//    }

}
