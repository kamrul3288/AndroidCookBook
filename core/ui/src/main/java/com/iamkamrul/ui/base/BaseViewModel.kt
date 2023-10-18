package com.iamkamrul.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel(){
     fun execute(job: suspend () -> Unit){
         viewModelScope.launch {
             job.invoke()
         }
     }
}