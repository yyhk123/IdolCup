package com.min.idolcup

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class Game : AppCompatActivity() {

    var femalefull = arrayListOf(
    R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
    R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8,
    R.drawable.img9, R.drawable.img10, R.drawable.img11, R.drawable.img12,
    R.drawable.img13, R.drawable.img14, R.drawable.img15, R.drawable.img16,
    R.drawable.img17, R.drawable.img18, R.drawable.img19, R.drawable.img20,
    R.drawable.img21, R.drawable.img22, R.drawable.img23, R.drawable.img24,
    R.drawable.img25, R.drawable.img26, R.drawable.img27, R.drawable.img28,
    R.drawable.img29, R.drawable.img30, R.drawable.img31, R.drawable.img32,
    R.drawable.img33, R.drawable.img34, R.drawable.img35, R.drawable.img36,
    R.drawable.img37, R.drawable.img38, R.drawable.img39, R.drawable.img40,
    R.drawable.img41, R.drawable.img42, R.drawable.img43, R.drawable.img44,
    R.drawable.img45, R.drawable.img46, R.drawable.img47, R.drawable.img48,
    R.drawable.img49, R.drawable.img50, R.drawable.img51, R.drawable.img52,
    R.drawable.img53, R.drawable.img54, R.drawable.img55, R.drawable.img56,
    R.drawable.img57, R.drawable.img58, R.drawable.img59, R.drawable.img60,
    R.drawable.img61, R.drawable.img62, R.drawable.img63, R.drawable.img64,
    R.drawable.img65, R.drawable.img66, R.drawable.img67, R.drawable.img68,
    R.drawable.img69, R.drawable.img70, R.drawable.img71, R.drawable.img72,
    R.drawable.img73, R.drawable.img74, R.drawable.img75, R.drawable.img76,
    R.drawable.img77, R.drawable.img78, R.drawable.img79, R.drawable.img80,
    R.drawable.img81, R.drawable.img82, R.drawable.img83, R.drawable.img84,
    R.drawable.img85, R.drawable.img86, R.drawable.img87
)
    var malefull = arrayListOf(
        R.drawable.mimg1, R.drawable.mimg2, R.drawable.mimg3, R.drawable.mimg4,
        R.drawable.mimg5, R.drawable.mimg6, R.drawable.mimg7, R.drawable.mimg8,
        R.drawable.mimg9, R.drawable.mimg10, R.drawable.mimg11, R.drawable.mimg12,
        R.drawable.mimg13, R.drawable.mimg14, R.drawable.mimg15, R.drawable.mimg16,
        R.drawable.mimg17, R.drawable.mimg18, R.drawable.mimg19, R.drawable.mimg20,
        R.drawable.mimg21, R.drawable.mimg22, R.drawable.mimg23, R.drawable.mimg24,
        R.drawable.mimg25, R.drawable.mimg26, R.drawable.mimg27, R.drawable.mimg28,
        R.drawable.mimg29, R.drawable.mimg30, R.drawable.mimg31, R.drawable.mimg32,
        R.drawable.mimg33, R.drawable.mimg34, R.drawable.mimg35, R.drawable.mimg36,
        R.drawable.mimg37, R.drawable.mimg38, R.drawable.mimg39, R.drawable.mimg40,
        R.drawable.mimg41, R.drawable.mimg42, R.drawable.mimg43, R.drawable.mimg44,
        R.drawable.mimg45, R.drawable.mimg46, R.drawable.mimg47, R.drawable.mimg48,
        R.drawable.mimg49, R.drawable.mimg50, R.drawable.mimg51, R.drawable.mimg52,
        R.drawable.mimg53, R.drawable.mimg54, R.drawable.mimg55, R.drawable.mimg56,
        R.drawable.mimg57, R.drawable.mimg58, R.drawable.mimg59, R.drawable.mimg60,
        R.drawable.mimg61, R.drawable.mimg62, R.drawable.mimg63, R.drawable.mimg64,
        R.drawable.mimg65, R.drawable.mimg66, R.drawable.mimg67, R.drawable.mimg68,
        R.drawable.mimg69, R.drawable.mimg70, R.drawable.mimg71, R.drawable.mimg72,
        R.drawable.mimg73, R.drawable.mimg74, R.drawable.mimg75, R.drawable.mimg76,
        R.drawable.mimg77, R.drawable.mimg78, R.drawable.mimg79, R.drawable.mimg80,
        R.drawable.mimg81,
    )

    var list = arrayListOf<Int>()
    var temp = arrayListOf<Int>()

    lateinit var imageView1: ImageView
    lateinit var imageView2: ImageView
    lateinit var textView: TextView

    var counter =0
    private var sex: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()



        val intent = intent
        sex = intent.getIntExtra("sex", 0)

        if(sex == 1){
            Log.d("sex", "Female")
            femalefull.shuffle();
            list = femalefull.take(32) as ArrayList<Int>
        }
        else if(sex == 2){
            Log.d("sex", "Male")
            malefull.shuffle();
            list = malefull.take(32) as ArrayList<Int>
        }



        imageView1 = findViewById(R.id.imageView1)
        imageView2 = findViewById(R.id.imageView2)
        textView = findViewById(R.id.textView)



        textView.setText("Round of 32")


        imageView1.setOnClickListener {
            onImageClick(it)
        }

        imageView2.setOnClickListener {
            onImageClick(it)
        }

        // 초기화
        onImageClick(null)


    }

    private fun onImageClick(view: View?) {
        var txtbackground = findViewById<ConstraintLayout>(R.id.include)


        counter++
        if(counter == 17){
            textView.setText("Round of 16")
            txtbackground.setBackgroundColor(Color.parseColor("#ffdfba"))
        }
        else if(counter == 25){
            textView.setText("Round of 8")
            txtbackground.setBackgroundColor(Color.parseColor("#baffc9"))
        }
        else if(counter == 29){
            textView.setText("Semi-Final")
            txtbackground.setBackgroundColor(Color.parseColor("#ffffba"))
        }
        else if(counter == 31){
            textView.setText("Final")
            txtbackground.setBackgroundColor(Color.parseColor("#ffb3ba"))
        }
        Log.d("counter: ", "" + counter)

        when (view?.id) {
            R.id.imageView1 -> (view?.tag as? Int)?.let {
                Log.d("img", "" + it)
                temp.add(it)
            }
            R.id.imageView2 -> (view?.tag as? Int)?.let {
                temp.add(it)
                Log.d("img", "" + it)
            }
        }

        val imageViews = listOf(imageView1, imageView2)
        imageViews.forEach {
            it.tag = null
        }

        val list: MutableList<Int>? = if (this.list.isNotEmpty()) {
            this.list
        } else if (temp.isNotEmpty()) {
            temp
        } else {
            null
        }

        if (list == null) {
            return
        } else {
            if (list.count() == 1) {
                val mDialog = LayoutInflater.from(this).inflate(R.layout.finalpopup, null)
                val mBuilder = AlertDialog.Builder(this).setView(mDialog)
                val mAlertDialog = mBuilder.show()
                var finalwinner = mDialog.findViewById<ImageView>(R.id.finalwinner)
                finalwinner.setImageResource(list[0])
                Log.d("final winner", "" + list[0])


                var menu = mDialog.findViewById<Button>(R.id.menu)
                menu.setOnClickListener {
                    finish();
                    mAlertDialog.dismiss();
                    onBackPressed();
                }

                var restart = mDialog.findViewById<Button>(R.id.restart)
                restart.setOnClickListener {
                    val intent = intent
                    finish();
                    mAlertDialog.dismiss();
                    startActivity(intent)
                }
                return
            }
        }

        imageViews.forEach { imageView ->
            list.removeFirstOrNull()?.let {
                imageView.setImageResource(it)
                imageView.tag = it
            }
        }
    }



}