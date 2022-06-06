package com.example.mydiary

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydiary.data.Line
import com.example.mydiary.data.LineViewModel
import com.example.mydiary.databinding.FragmentDiaryEntryBinding


class diary_entry : Fragment() {
    private lateinit var mLineViewModel: LineViewModel
    private var _binding:FragmentDiaryEntryBinding?=null
    private val binding get()=_binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentDiaryEntryBinding.inflate(inflater,container,false)






        return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recycleView=binding.recyclerView1
        val button=binding.submit


        recycleView.layoutManager=LinearLayoutManager(requireContext())
        var item:MutableList <String> = mutableListOf()
        for(i in 0..100){
            item.add(i," ")
        }

        mLineViewModel=ViewModelProvider(this).get(LineViewModel::class.java)

        recycleView.adapter=entryAdapter(item)
        button.setOnClickListener {
            for(i in 0..100){
                val line_no=i
                val line_text=item.get(i)
                val line=Line(line_no,line_text)
               // Log.d("stf", "${line.line_no}")
                mLineViewModel.addLine(line)
                Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

            }

            val action2=diary_entryDirections.actionDiaryEntryToHomeScreen()

            view.findNavController().navigate(action2)
            // text lines in item will be added to the database here ....Later
        }



        
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }


}