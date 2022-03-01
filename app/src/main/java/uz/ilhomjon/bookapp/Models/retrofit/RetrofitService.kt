package uz.ilhomjon.bookapp.Models.retrofit

import retrofit2.Call
import retrofit2.http.GET
import uz.ilhomjon.bookapp.Models.myclass.MyBook
import uz.ilhomjon.bookapp.Models.retrofit.Common.API_KEY

interface RetrofitService {

    @GET("lists/names.json?api-key=$API_KEY")
    suspend fun getAllBook():MyBook
}