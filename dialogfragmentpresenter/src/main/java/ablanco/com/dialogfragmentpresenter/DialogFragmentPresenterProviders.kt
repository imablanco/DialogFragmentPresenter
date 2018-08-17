package ablanco.com.dialogfragmentpresenter

import android.arch.lifecycle.DefaultLifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.support.v4.app.FragmentActivity

/**
 * Created by Álvaro Blanco Cabrero on 06/08/2018.
 * DialogFragmentPresenter.
 */
object DialogFragmentPresenterProviders : DefaultLifecycleObserver {

    private val presenters: MutableList<DialogFragmentPresenter> = mutableListOf()

    fun of(context: FragmentActivity): DialogFragmentPresenter? {
        /*Do not return if context is destroyed*/
        if(context.isFinished){
            return null
        }
        /*Check if we have any presenter attached to this context*/
        var presenter = presenters.find { it.context === context }
        if (presenter == null) {
            presenter = DialogFragmentPresenter(context)
            context.lifecycle.addObserver(presenter)
            presenters.add(presenter)
            /*Observe the context to release attached presenter in onDestroy*/
            context.lifecycle.addObserver(this)
        }
        return presenter
    }

    override fun onDestroy(owner: LifecycleOwner) {
        presenters.find { it.context == owner }?.let(presenters::remove)
    }
}