package com.mobile.community.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

//    TODO: 2. Simpan data ketika di rotate
    var diceRollResult = 1
    private lateinit var buttonRoll: Button
    private lateinit var imgDice: ImageView
    private lateinit var textDice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonRoll = findViewById(R.id.btn_roll)
        imgDice = findViewById(R.id.img_dice)
        textDice = findViewById(R.id.tv_dice)
        updateDice()
        buttonRoll.setOnClickListener {
            var res = (1..6).random()
            while (res == diceRollResult){
                res = (1..6).random()
            }
            diceRollResult = res
            updateDice()
        }
    }

    private fun updateDice() {
        textDice.text = diceRollResult.toString()
        imgDice.setImageResource(getDiceImage(diceRollResult))
    }

    private fun getDiceImage(num: Int): Int {
        return when (num) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            6 -> R.drawable.dice6
            else -> R.drawable.dice1
        }
    }
}