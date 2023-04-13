package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import timber.log.Timber
import java.security.Key


const val KEY_Dice_num = "dice_num_key"
const val KEY_Dice_num1 = "dice_num1_key"
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}

class MainActivity : AppCompatActivity() {
    private var dice = Dice(6)
    private var diceRoll = 1
    private var diceRoll1 = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate called")
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {

            diceRoll = savedInstanceState.getInt(KEY_Dice_num, 1)
            diceRoll1 = savedInstanceState.getInt(KEY_Dice_num1, 1)
            showImage()
        }
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice()  }


    }
    private fun rollDice(){
        dice = Dice(6)
        diceRoll = dice.roll()
        diceRoll1 = dice.roll()
        showImage()
    }
    private fun showImage() {
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage1: ImageView = findViewById(R.id.imageView2)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll1.toString()

        val drawableResource1 = when (diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage1.setImageResource(drawableResource1)
        diceImage1.contentDescription = diceRoll1.toString()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("onSaveInstanceState Called")
        outState.putInt(KEY_Dice_num, diceRoll)
        outState.putInt(KEY_Dice_num1, diceRoll1)
    }
    override fun onStart() {
        super.onStart()

        Timber.i("onStart called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }
}