package com.example.midtermapp.ui.notifications

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
import com.example.midtermapp.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private lateinit var start2_button: Button
    private lateinit var stop2_button: Button

    private val TAG: String = "ON_CREATE"

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start2_button = findViewById(R.id.start1_button)
        stop2_button = findViewById(R.id.stop1_button)

        start2_button.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(this,"Hello")
            }
        )
        stop2_button.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(this, "Stop")
            }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
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