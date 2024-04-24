package com.example.rockpaperscissorgame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var restart_btn: Button

    private lateinit var scissors_btn: ImageView
    private lateinit var rock_btn: ImageView
    private lateinit var paper_btn: ImageView

    private lateinit var user_move_img: ImageView
    private lateinit var computer_move_img: ImageView

    private lateinit var winner_tv : TextView
    private lateinit var computer_score : TextView
    private lateinit var player_score : TextView


    @SuppressLint("UseCompatLoadingForDrawables", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        restart_btn = findViewById(R.id.restart_btn)
        scissors_btn = findViewById(R.id.scissors_btn)
        rock_btn = findViewById(R.id.rock_btn)
        paper_btn = findViewById(R.id.paper_btn)
        user_move_img = findViewById(R.id.user_move_img)
        computer_move_img = findViewById(R.id.computer_move_img)
        winner_tv = findViewById(R.id.winner_tv)
        computer_score = findViewById(R.id.computer_score)
        player_score = findViewById(R.id.player_score)

        restart_btn.setOnClickListener {
            clear_score()
        }

        // when player click on scissor icon.
        scissors_btn.setOnClickListener {

            // set the image of user move to scissors
            user_move_img.setImageDrawable(getDrawable(R.drawable.scissors))

            // choose a random number between 1 to 3.
            val computer_move = (1..4).random() // 4 is not included.

            when (computer_move) {
                1 -> {
                    // set the image of computer move to rock
                    // rock beats scissors.
                    // increase the computer score
                }
                2 -> {
                    // set the image of computer move to paper
                    // scissors beats paper
                    // increase the player score
                }
                else -> {
                    // set the image of computer move to scissors
                    // both 'user move and computer move' are "scissors"
                }
            }

        }

        // when player clicks on paper icon
        paper_btn.setOnClickListener {

        }

        // when player click on rock icon.
        rock_btn.setOnClickListener {
            
        }
        
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun clear_score() {

        // set the computer and player score to 0
        // set the images of computer move and user move to "Question mark image".

    }

}
