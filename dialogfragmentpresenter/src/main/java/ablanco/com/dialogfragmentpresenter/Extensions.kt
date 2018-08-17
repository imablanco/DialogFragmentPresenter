package ablanco.com.dialogfragmentpresenter

import android.app.Activity
import android.os.Build

/**
 * Created by Álvaro Blanco Cabrero on 18/08/2018.
 * DialogFragmentPresenter.
 */
internal val Activity.isFinished: Boolean
    get() {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            isFinishing || isDestroyed
        } else {
            isFinishing
        }
    }