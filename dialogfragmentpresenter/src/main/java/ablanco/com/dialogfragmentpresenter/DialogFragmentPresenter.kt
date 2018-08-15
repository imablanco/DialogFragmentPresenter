package ablanco.com.dialogfragmentpresenter

import android.arch.lifecycle.DefaultLifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentActivity

/**
 * Created by Álvaro Blanco Cabrero on 06/08/2018.
 * DialogFragmentPresenter.
 */
class DialogFragmentPresenter internal constructor(internal val context: FragmentActivity) :
    DefaultLifecycleObserver {

    private val pendingDialogs: MutableList<DialogFragmentPresentation> = mutableListOf()
    private var canShowDialogs: Boolean = false

    override fun onCreate(owner: LifecycleOwner) {
        canShowDialogs = false
    }

    override fun onResume(owner: LifecycleOwner) {
        canShowDialogs = true
        pendingDialogs.forEach {
            it.dialog.show(context.supportFragmentManager, it.tag)
        }
        pendingDialogs.clear()
    }

    override fun onPause(owner: LifecycleOwner) {
        canShowDialogs = false
    }

    override fun onDestroy(owner: LifecycleOwner) {
        pendingDialogs.clear()
    }

    fun show(dialogFragment: DialogFragment, tag: String? = null) {
        if (canShowDialogs) {
            dialogFragment.show(context.supportFragmentManager, tag)
        } else {
            pendingDialogs.add(DialogFragmentPresentation(dialogFragment, tag))
        }
    }
}