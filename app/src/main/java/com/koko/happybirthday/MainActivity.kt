package com.koko.happybirthday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This Activity allows the User to Roll a dice and view
 * the results on the Screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    private fun rollDice() {
        //create new Dice with 6 Sides and Roll the Dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Find the Image in the Layout File
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Determine which drawable will be Used when the Dice is Rolled
       val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Set the correct drawable Id
        diceImage.setImageResource(drawableResource)

        //Update content Description
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}