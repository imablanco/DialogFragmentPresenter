package ablanco.com.dialogframentpresentersample

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment

/**
 * Created by Álvaro Blanco Cabrero on 16/08/2018.
 * DialogFragmentPresenter.
 */
class SampleDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(context)
            .setTitle("Sample Dialog")
            .setMessage("This is a sample dialog")
            .create()
    }
}