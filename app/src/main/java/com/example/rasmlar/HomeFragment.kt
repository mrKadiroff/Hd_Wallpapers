package com.example.rasmlar

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rasmlar.adapters.ViewPagerAdapter
import com.example.rasmlar.databinding.FragmentHomeBinding
import com.example.rasmlar.databinding.ItemTabBinding
import com.example.rasmlar.modules.Photo
import com.example.rasmlar.retrofit.Common
import com.example.rasmlar.retrofit.RetrofitService
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    val tabArray = arrayOf(
        "All",
        "Car",
        "Animals",
        "Girls",
        "Weather"
    )
    private val TAG = "HomeFragment"
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)


        setViewPager()



        return binding.root
    }

    private fun setViewPager() {


        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout


        val adapter = ViewPagerAdapter(tabArray,childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val itemTabBinding: ItemTabBinding = ItemTabBinding.inflate(layoutInflater)
            tab.customView = itemTabBinding.root
            itemTabBinding.text.text = tabArray[position]
            if (position == 0) {
                itemTabBinding.circle.visibility = View.VISIBLE
                itemTabBinding.text.setTextColor(Color.WHITE)
            } else {
                itemTabBinding.circle.visibility = View.INVISIBLE
                itemTabBinding.text.setTextColor(Color.parseColor("#808a93"))
            }

        }.attach()


        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val itemTabBinding = ItemTabBinding.bind(tab?.customView!!)
                itemTabBinding.circle.visibility = View.VISIBLE
                itemTabBinding.text.setTextColor(Color.WHITE)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val itemTabBinding = ItemTabBinding.bind(tab?.customView!!)
                itemTabBinding.circle.visibility = View.INVISIBLE
                itemTabBinding.text.setTextColor(Color.parseColor("#808a93"))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}