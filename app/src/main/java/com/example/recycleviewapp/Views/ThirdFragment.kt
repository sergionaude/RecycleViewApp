package com.example.recycleviewapp.Views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recycleviewapp.Adapter.EventAdapter
import com.example.recycleviewapp.Adapter.EventClicked
import com.example.recycleviewapp.MiLista
import com.example.recycleviewapp.Model.Event
import com.example.recycleviewapp.R
import com.example.recycleviewapp.databinding.FragmentThirdBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment(), EventClicked {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null

    private val binding by lazy {
        FragmentThirdBinding.inflate(layoutInflater)
    }

    private val adaptando by lazy {
        EventAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        Log.d("ALGO", param1.toString())
        Log.d("ALGO", param2.toString())

        binding.textView1.text = param1
        binding.textView2.text = param2
        binding.textView3.text = param3

        binding.BtnDelete.setOnClickListener{
            adaptando.updateDataRemove(
                Event(param1.toString(), param2.toString(), param3.toString())
            )
            parentFragmentManager.popBackStackImmediate()
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(event: Event) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, event.Titulo)
                    putString(ARG_PARAM2, event.Categoria)
                    putString(ARG_PARAM3, event.Fecha)
                }
            }
    }

    override fun onEventClicked(event: Event) {
        TODO("Not yet implemented")
    }
}