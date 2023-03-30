package com.example.midtermapp.ui.dashboard

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.midtermapp.R
import com.example.midtermapp.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var start_button: Button
    private lateinit var stop_button: Button

    private val TAG: String = "ON_CREATE"


    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_button = findViewById(R.id.start_button)
        stop_button = findViewById(R.id.stop_button)

        start_button.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(this,"Hello")
            }
        )
        stop_button.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(this, "Stop")
            }

    }



    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun startTimeCounter(view: View) {
        val countTime: TextView = findViewById(R.id.countTime)
        object: CountDownTimer(50000,1000) {
            override fun ontick(millisUntilFinished: Long) {
                countTime.text = counter.toString()
            }
            override fun onFinish() {
                countTime.text = "finished"
            }
        }
    }
}