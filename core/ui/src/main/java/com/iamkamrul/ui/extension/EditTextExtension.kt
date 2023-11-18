package com.iamkamrul.ui.extension

import android.text.Editable
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun EditText.debounce(delay:Long, scope:CoroutineScope, action:(Editable?)->Unit){
    var job: Job? = null
    this.doAfterTextChanged {
        job?.cancel()
        job = scope.launch {
            delay(delay)
            action(it)
        }
    }
}