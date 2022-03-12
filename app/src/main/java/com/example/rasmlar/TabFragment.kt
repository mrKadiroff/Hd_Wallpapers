package com.example.rasmlar

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rasmlar.adapters.WallpAdapter
import com.example.rasmlar.databinding.FragmentHomeBinding
import com.example.rasmlar.databinding.FragmentTabBinding
import com.example.rasmlar.modules.Photo
import com.example.rasmlar.modules.WallpaperResult
import com.example.rasmlar.retrofit.Common
import com.example.rasmlar.retrofit.Common.retrofitService
import com.example.rasmlar.retrofit.RetrofitService
import com.example.rasmlar.utils.NetworkHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"


/**
 * A simple [Fragment] subclass.
 * Use the [TabFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var categoryID: Int? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            categoryID = it.getInt(ARG_PARAM1)

        }
    }
    private val TAG = "HomeFragment"
    lateinit var retrofitService: RetrofitService
    private lateinit var photo: Photo
    private lateinit var list: ArrayList<WallpaperResult>
    private lateinit var imageAdapter: WallpAdapter
    lateinit var binding: FragmentTabBinding
    lateinit var networkHelper: NetworkHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTabBinding.inflate(layoutInflater,container,false)

        networkHelper = NetworkHelper(binding.root.context)

        if (networkHelper.isNetworkConnected()){
            work()
        }else {
            binding.rv.visibility = View.GONE
            binding.internet.visibility = View.VISIBLE
        }







        return binding.root
    }

    private fun work() {
        list = ArrayList()

        imageAdapter = WallpAdapter(list,object:WallpAdapter.OnItemClickListener{
            override fun onItemClick(wallpaperResult: WallpaperResult) {
                var bundle = Bundle()
                bundle.putSerializable("wall",wallpaperResult.urls.full)
                findNavController().navigate(R.id.rawImageFragment,bundle)
            }

        })
        binding.rv.adapter = imageAdapter


        if (categoryID == 1){




            retrofitService = Common.retrofitService

            retrofitService.getListWallpaper("All","WcqS56m2RFo3mxnrvePBlcbU2uvVUrBEk0et1HYLapQ").enqueue(object:
                Callback<Photo> {
                override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        data?.results?.let { list.addAll(it) }
                        imageAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<Photo>, t: Throwable) {

                }


            })
        }

        if (categoryID == 2){




            retrofitService = Common.retrofitService

            retrofitService.getListWallpaper("Car","WcqS56m2RFo3mxnrvePBlcbU2uvVUrBEk0et1HYLapQ").enqueue(object:
                Callback<Photo> {
                override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        data?.results?.let { list.addAll(it) }
                        imageAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<Photo>, t: Throwable) {

                }


            })
        }

        if (categoryID == 3){




            retrofitService = Common.retrofitService

            retrofitService.getListWallpaper("Animals","WcqS56m2RFo3mxnrvePBlcbU2uvVUrBEk0et1HYLapQ").enqueue(object:
                Callback<Photo> {
                override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        data?.results?.let { list.addAll(it) }
                        imageAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<Photo>, t: Throwable) {

                }


            })
        }

        if (categoryID == 4){




            retrofitService = Common.retrofitService

            retrofitService.getListWallpaper("Girls","WcqS56m2RFo3mxnrvePBlcbU2uvVUrBEk0et1HYLapQ").enqueue(object:
                Callback<Photo> {
                override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        data?.results?.let { list.addAll(it) }
                        imageAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<Photo>, t: Throwable) {

                }


            })
        }

        if (categoryID == 5){




            retrofitService = Common.retrofitService

            retrofitService.getListWallpaper("Weather","WcqS56m2RFo3mxnrvePBlcbU2uvVUrBEk0et1HYLapQ").enqueue(object:
                Callback<Photo> {
                override fun onResponse(call: Call<Photo>, response: Response<Photo>) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        data?.results?.let { list.addAll(it) }
                        imageAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<Photo>, t: Throwable) {

                }


            })
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TabFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(categoryID: Int) =
            TabFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, categoryID)

                }
            }
    }
}