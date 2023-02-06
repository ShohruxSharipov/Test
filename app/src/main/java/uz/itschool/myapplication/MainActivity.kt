package uz.itschool.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var question:TextView
    lateinit var group: RadioGroup
    lateinit var answer1:RadioButton
    lateinit var answer2:RadioButton
    lateinit var answer3:RadioButton
    lateinit var answer4:RadioButton
    lateinit var finish:Button
    lateinit var next:ImageButton
    lateinit var prev:ImageButton
    var n = 1
    var array = Array<Int>(4,{-1})

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        question = findViewById(R.id.question)
        group = findViewById(R.id.radioGroup)
        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        answer4 = findViewById(R.id.answer4)
        question = findViewById(R.id.question)
        finish = findViewById(R.id.finish)
        next = findViewById(R.id.next)
        prev = findViewById(R.id.previus)



        next.setOnClickListener {
            question.text = question.text.dropLast(1)
            n++
            question.text = question.text.toString() + n.toString()
            answer1.text = answer1.text.dropLast(1).toString() + (n+3).toString()
            answer2.text = answer2.text.dropLast(1).toString() + (n+4).toString()
            answer3.text = answer3.text.dropLast(1).toString() + (n+5).toString()
            answer4.text = answer4.text.dropLast(1).toString() + (n+6).toString()

            var b = findViewById<RadioButton>(group.checkedRadioButtonId)
            array[n] = b.text.lastIndex.toInt()

            if (n == 5){
                finish.visibility = View.VISIBLE
            }

        }

        prev.setOnClickListener {
            question.text = question.text.dropLast(1)
            n--
            question.text = question.text.toString() + n.toString()
            answer1.text = answer1.text.dropLast(1).toString() + (n+3).toString()
            answer2.text = answer2.text.dropLast(1).toString() + (n+4).toString()
            answer3.text = answer3.text.dropLast(1).toString() + (n+5).toString()
            answer4.text = answer4.text.dropLast(1).toString() + (n+6).toString()
//            var a = group.checkedRadioButtonId
//            var b = findViewById<RadioButton>(a)
//            b.isChecked = false
        }

    }
}