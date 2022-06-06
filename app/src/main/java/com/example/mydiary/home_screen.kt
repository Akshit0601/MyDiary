package com.example.mydiary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydiary.data.LineViewModel
import com.example.mydiary.databinding.FragmentHomeScreenBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [home_screen.newInstance] factory method to
 * create an instance of this fragment.
 */
class home_screen : Fragment() {
    private lateinit var mLineViewModel: LineViewModel
    private var _binding:FragmentHomeScreenBinding?=null
    private val binding get() = _binding!!
    private lateinit var floatingActionButton:FloatingActionButton
    private lateinit var update_list:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeScreenBinding.inflate(inflater,container,false)
        val view=binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        update_list=binding.recyclerView2
        val adapter=ListAdapter()
        update_list.adapter= adapter
        update_list.layoutManager= LinearLayoutManager(requireContext())
        mLineViewModel = ViewModelProvider(this).get(LineViewModel::class.java)
        mLineViewModel.readAllData.observe(viewLifecycleOwner, Observer { line ->
            adapter.setData(line)

        })

        floatingActionButton=binding.floatingActionButton;
        floatingActionButton.setOnClickListener {
            val action=home_screenDirections.actionHomeScreenToDiaryEntry()
            view.findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}