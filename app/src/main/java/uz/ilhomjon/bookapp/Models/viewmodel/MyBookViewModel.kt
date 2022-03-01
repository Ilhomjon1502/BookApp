package uz.ilhomjon.bookapp.Models.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import uz.ilhomjon.bookapp.Models.myclass.MyBook
import uz.ilhomjon.bookapp.Models.retrofit.Common
import java.lang.Exception

class MyBookViewModel : ViewModel() {
    private val myBookViewModel = MutableLiveData<MyResource<MyBook>>()

    fun getMyBook(context: Context):LiveData<MyResource<MyBook>>{
        val apiService = Common.retrofitService(context)

        viewModelScope.launch {
            myBookViewModel.postValue(MyResource.loading(null))

            try {

                coroutineScope {
                    val async1 = async { apiService.getAllBook() }

                    val await = async1.await()
                    myBookViewModel.postValue(MyResource.success(await))
                }

            }catch (e:Exception){
                myBookViewModel.postValue(MyResource.error(e.message, null))
            }
        }
        return myBookViewModel
    }
}