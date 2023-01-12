package com.example.url

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        website.setOnClickListener {
            val br = web.text.toString()
          //  var validate = Pattern.compile("/((([A-Za-z]{3,9}:(?:\\/\\/)?)(?:[-;:&=\\+\\\$,\\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\\+\\\$,\\w]+@)[A-Za-z0-9.-]+)((?:\\/[\\+~%\\/.\\w-_]*)?\\??(?:[-\\+=&;%@.\\w_]*)#?(?:[\\w]*))?)/")
            if(br.isEmpty()) {
                web.error = "Required"
            }

            //if(validate.matcher(br).matches()){
            //  web.error = "Please enter correct url"
            // }

            if(br.isNotEmpty()){
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(br)
            startActivity(intent)

        }

}
        dial.setOnClickListener {
            val d = di.text.toString()
           val  intent  = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:"+d)
            startActivity(intent)
        }


        sms.setOnClickListener() {
            val num = sm.text.toString()
            if (num.isEmpty()) {
                sm.error = "Required"
            }
            if (num.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW)
                val url = "https://api.whatsapp.com/send?phone=$num"
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
        }

        mail.setOnClickListener(){
           val imail = Intent(Intent.ACTION_SEND)
           imail.data = Uri.parse("mailto")
           imail.putExtra(Intent.EXTRA_EMAIL, "mudassarjani096@gmail.com")
           imail.putExtra(Intent.EXTRA_SUBJECT, "Software Project Management")
           imail.putExtra(Intent.EXTRA_TEXT,"Mudassar Mehar")
           imail.type="message/rfc223"
           startActivity(Intent.createChooser(imail,"Email"))
        }


        btn_alarm.setOnClickListener() {
            val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(intent)
        }

       map.setOnClickListener(){
           val intent=Intent(Intent.ACTION_VIEW )
           Uri.parse("geo:0:0")
           startActivity(Intent.createChooser(intent,Intent.ACTION_VIEW))
       }

        play.setOnClickListener(){
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://play.google.com/store/apps?h1=en"))
            startActivity(intent)
        }


    }
}