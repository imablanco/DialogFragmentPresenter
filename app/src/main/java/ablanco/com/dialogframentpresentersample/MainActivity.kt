package ablanco.com.dialogframentpresentersample

import ablanco.com.dialogfragmentpresenter.DialogFragmentPresenterProviders
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btShow.setOnClickListener {
            Handler().postDelayed({
                DialogFragmentPresenterProviders.of(this)?.show(SampleDialogFragment())
            }, 5000)
        }
        btStartForResult.setOnClickListener {
            startActivityForResult(Intent(this, ActivityForResult::class.java), 44444)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        DialogFragmentPresenterProviders.of(this)?.show(SampleDialogFragment())
    }
}
