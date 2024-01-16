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
                    computer_move_img.setImageDrawable(getDrawable(R.drawable.rock));

                    // rock beats scissors.
                    winner_tv.text = "Computer has won"

                    // increase the computer score
                    val cscore: Int = computer_score.text.toString().toInt() + 1
                    computer_score.text = cscore.toString()
                }
                2 -> {

                    // set the image of computer move to paper
                    computer_move_img.setImageDrawable(getDrawable(R.drawable.paper));

                    // scissors beats paper
                    winner_tv.text = "Player has won"

                    // increase the player score
                    val pscore: Int = player_score.text.toString().toInt() + 1
                    player_score.text = pscore.toString()
                }
                else -> {

                    // set the image of computer move to scissors
                    computer_move_img.setImageDrawable(getDrawable(R.drawable.scissors));

                    // both user move and computer move are "scissors"
                    winner_tv.text = "Draw"
                }
            }

        }

        // when player clicks on paper icon
        paper_btn.setOnClickListener {

            // set the image of player move to paper
            user_move_img.setImageDrawable(getDrawable(R.drawable.paper))


            val computer_move = (1..4).random()

            when (computer_move) {
                1 -> {

                    // set the image of computer move to rock
                    computer_move_img.setImageDrawable(getDrawable(R.drawable.rock))

                    // paper beats rock
                    winner_tv.text = "Player has won"

                    // increase count of player score
                    val pscore: Int = player_score.text.toString().toInt() + 1
                    player_score.text = pscore.toString()
                }
                2 -> {

                    // set the image of computer move to paper
                    computer_move_img.setImageDrawable(getDrawable(R.drawable.paper))

                    // both user move and computer move are "paper"
                    winner_tv.text = "Draw"
                }
                else -> {

                    // set the image of computer move to scissors

                    computer_move_img.setImageDrawable(getDrawable(R.drawable.scissors));
                    // scissors beats paper
                    winner_tv.text = "Computer has won"

                    // increase the computer score
                    val cscore: Int = computer_score.text.toString().toInt() + 1
                    computer_score.text = cscore.toString()
                }
            }

        }

        // when player click on rock icon.
        rock_btn.setOnClickListener {


            // set the image of user move to rock
            user_move_img.setImageDrawable(getDrawable(R.drawable.rock));


            val computer_move = (1..4).random()

            when (computer_move) {
                1 -> {
                    // set the image of computer move to rock
                    computer_move_img.setImageDrawable(getDrawable(R.drawable.rock));

                    // both user and computer moves are rock
                    winner_tv.text = "Draw"

                }
                2 -> {

                    // set the image of computer move to paper
                    computer_move_img.setImageDrawable(getDrawable(R.drawable.paper));

                    // paper beats rock
                    winner_tv.text = "Computer has won"

                    // increase the computer score
                    val cscore: Int = computer_score.text.toString().toInt() + 1
                    computer_score.text = cscore.toString()


                }
                else -> {
                    // set the image of computer move to scissors
                    computer_move_img.setImageDrawable(getDrawable(R.drawable.scissors));

                    // rock beats scissors
                    winner_tv.text = "Player has won"

                    // increase the count of player
                    val pscore: Int = player_score.text.toString().toInt() + 1
                    player_score.text = pscore.toString()
                }
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun clear_score() {

        // set the computer and player score to 0
        computer_score.text = "0"
        player_score.text = "0"

        winner_tv.text = ""

        // set the images of computer move and user move to "Question mark image".
        user_move_img.setImageDrawable(getDrawable(R.drawable.question_mark));
        computer_move_img.setImageDrawable(getDrawable(R.drawable.question_mark));

    }

}
