package com.example.devopsapplicatioin.presenter.Home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devopsapplicatioin.data.local.model.MainItem
import com.example.devopsapplicatioin.data.remote.model.mainItems
import com.example.devopsapplicatioin.databinding.FragmentHomeBinding
import com.example.devopsapplicatioin.util.ResultState
import com.microsoft.appcenter.analytics.Analytics
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewmodel: HomeViewModel by viewModels()
    private lateinit var maintItemAdapter: maintItemAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Analytics.trackEvent("HOME FRAGMENT STARTED FINALssssss")
        viewmodel.mainItems. observe(viewLifecycleOwner, Observer { state->
            processMainItems(state)
        })

        viewmodel.itemFromDb.observe(viewLifecycleOwner, Observer { state->
          when(state){
              is ResultState.Error -> {Log.d("laman","NO LAMAN")}
              is ResultState.Success -> Log.d("laman",state.data!!.size.toString())
              is ResultState.Loading -> {}
          }
        })

        binding.btSave.setOnClickListener {
            s?.let { it1 -> viewmodel.insertitem(it1) }
        }
    }

    var s:MainItem? = null
    private fun processMainItems(state: ResultState<List<mainItems>>?) {
        when(state){
            is ResultState.Loading -> {}
            is ResultState.Success ->{

                if(!state.data.isNullOrEmpty()){
                   // coptMainItemlist = arrayListOf()
                    var count = state.data.size
                    maintItemAdapter= maintItemAdapter(this)
                    binding.rvMainItem.adapter= maintItemAdapter
                    binding.rvMainItem.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)
                    maintItemAdapter.showMainItems(state.data)
                    binding.rvMainItem.post {
                        val recyclerViewWidth = binding.rvMainItem.width
                        val itemWidth = recyclerViewWidth / count
                        maintItemAdapter.setItemWidth(itemWidth)
                    }

                    var item = state.data[0]
                    val method= MainItem(
                        Name = item.name
                    )
                    s = method


                }
            }
            is ResultState.Error -> {

                Toast.makeText(requireContext(),"${state.message}", Toast.LENGTH_LONG).show()
            }
            else -> {


            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}