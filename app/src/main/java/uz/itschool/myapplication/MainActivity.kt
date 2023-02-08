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
import uz.itschool.myapplication.model.Test
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var question: TextView
    lateinit var group: RadioGroup
    lateinit var answer1: RadioButton
    lateinit var answer2: RadioButton
    lateinit var answer3: RadioButton
    lateinit var answer4: RadioButton
    lateinit var finish: Button
    lateinit var next: ImageButton
    lateinit var prev: ImageButton
    var count = 0
    var list = mutableListOf<Test>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        question = findViewById(R.id.question)
        answer1 = findViewById(R.id.answer1)
        answer2 = findViewById(R.id.answer2)
        answer3 = findViewById(R.id.answer3)
        answer4 = findViewById(R.id.answer4)
        next = findViewById(R.id.next)
        prev = findViewById(R.id.previus)
        group = findViewById(R.id.radioGroup)
        var index = 0
        list.add(Test("1*1", "1", "2", "3", "4", false))
        list.add(Test("2*2", "12", "4", "9", "13", false))
        list.add(Test("3*3", "5", "6", "17", "9", false))
        list.add(Test("4*5", "10", "20", "30", "40", false))

        createTest(index)
        next.setOnClickListener {
            if (index < list.size - 1) {
                index++
                createTest(index)
            }
        }

        prev.setOnClickListener {
            if (index < list.size - 1 && index != 0) {
                index--
                createTest(index)
                if (group.checkedRadioButtonId != -1){
                    group.clearCheck()
                }
            }

        }
    }


    fun createTest(i: Int) {
        question.text = list[i].qustion
        answer1.text = list[i].answer1
        answer2.text = list[i].answer2
        answer3.text = list[i].answer3
        answer4.text = list[i].answer4
        list[i].status = true
    }
}
