package karunkumar.com.expandebledemo


import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class Test : AppCompatActivity() {


    internal var countryName = arrayOf("India", "Pakistan", "China", "Nepal", "Bangladesh")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)


        val mLinearLayout = findViewById<View>(R.id.linear1) as LinearLayout
        for (k in 1..20) {
            //create text button
            val title = TextView(this)
            title.text = "Question Number:" + k
            title.setTextColor(Color.BLUE)
            mLinearLayout.addView(title)
            // create radio button
            val rb = arrayOfNulls<RadioButton>(5)
            val rg = RadioGroup(this)
            rg.orientation = RadioGroup.VERTICAL
            for (i in 0..4) {
                rb[i] = RadioButton(this)
                rg.addView(rb[i])
                rb[i]!!.text = countryName[i]
            }
            mLinearLayout.addView(rg)
        }
    }
}


