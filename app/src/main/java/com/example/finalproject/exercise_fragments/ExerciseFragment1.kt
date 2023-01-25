
package com.example.finalproject.exercise_fragments



import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import com.example.finalproject.R


class ExerciseFragment1 : Fragment() {
    private lateinit var countDownTimer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_exercise1, container, false)
        createNotificationChannel()
        view.findViewById<Button>(R.id.ex1_start).setOnClickListener {

            startCountdownTimer()
        }
        view.findViewById<Button>(R.id.ex1_stop).setOnClickListener {
            stopCountdownTimer()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val txt = view.findViewById<TextView>(R.id.exercise1)

        txt.text = "First Exercise"
    }

    private fun startCountdownTimer() {
        val timeInMillis = 60 * 1000  // 60 seconds
        countDownTimer = object : CountDownTimer(timeInMillis.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // update the notification with the remaining time
                updateNotification(millisUntilFinished)
            }

            override fun onFinish() {
                // cancel the notification
                cancelNotification()
            }
        }.start()
    }

    private fun stopCountdownTimer() {
        countDownTimer.cancel()
        cancelNotification()
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    private fun updateNotification(timeRemaining: Long) {
        val notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val builder = NotificationCompat.Builder(requireContext(), "countdown_timer")
            .setSmallIcon(R.drawable.ic_timer)
            .setContentTitle("Countdown Timer")
            .setContentText("Time remaining: ${timeRemaining / 1000} seconds")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(false)
            .addAction(
                R.drawable.ic_stop, "Stop",
                PendingIntent.getBroadcast(requireContext(), 0, Intent(requireContext(), StopReceiver::class.java), PendingIntent.FLAG_IMMUTABLE)
            )

        notificationManager.notify(1, builder.build())
    }

    class StopReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val myFragment = context as ExerciseFragment1
            myFragment.stopCountdownTimer()
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "countdown_timer",
                "Countdown Timer",
                NotificationManager.IMPORTANCE_HIGH
            )
            val notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun cancelNotification() {
        val notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(1)
    }

}