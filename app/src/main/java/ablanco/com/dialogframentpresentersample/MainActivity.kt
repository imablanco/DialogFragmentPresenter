package ablanco.com.dialogframentpresentersample

import ablanco.com.dialogfragmentpresenter.DialogFragmentPresenterProviders
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            DialogFragmentPresenterProviders.of(this).show(SampleDialogFragment())
            DialogFragmentPresenterProviders.of(this).show(SampleDialogFragment())
        }, 2000)
    }
}
