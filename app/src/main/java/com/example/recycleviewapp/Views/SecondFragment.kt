package com.example.recycleviewapp.Views

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.recycleviewapp.Adapter.EventAdapter
import com.example.recycleviewapp.Adapter.EventClicked
import com.example.recycleviewapp.Model.Event
import com.example.recycleviewapp.databinding.FragmentSecondBinding
import java.sql.Date
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment(), EventClicked {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val binding by lazy {
        FragmentSecondBinding.inflate(layoutInflater)
    }
    private val adaptando by lazy {
        EventAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            var algo = savedInstanceState.getStringArray("valores").toString()
            param1 = algo[0].toString()
            param2 = algo[1].toString()
        }
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val d = Date()
        var fecha: CharSequence = DateFormat.format("MM/dd/yyyy ", d.time)
        Log.d("SECONDFRAG", fecha.toString())

            binding.eventCalendar.setOnDateChangeListener { calendarView, year, month, day ->
                fecha = ("$month+1/$day/$year")
                Log.d("SECONDFRAG222", fecha.toString())
            }

            binding.doneBtn.setOnClickListener{
                if(binding.eventTitleEt.text.isNotEmpty() && binding.eventCategoryEt.text.isNotEmpty()){
                    adaptando.updateEventData(
                        Event(
                            binding.eventTitleEt.text.toString(),
                            binding.eventCategoryEt.text.toString(),
                            fecha.toString()
                        )
                    )
                    parentFragmentManager.popBackStackImmediate()
                }
                else{
                    Toast.makeText(context,"Please fill the fields",Toast.LENGTH_LONG).show()
                }
        // Inflate the layout for this fragment
        }

        return binding.root
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("valores", arrayListOf(param1.toString(),param2.toString()))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onEventClicked(event: Event) {
    }
}