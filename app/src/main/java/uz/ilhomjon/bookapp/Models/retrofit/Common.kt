package uz.ilhomjon.bookapp.Models.retrofit

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//api link site: https://developer.nytimes.com/docs/books-product/1/overview
//api key: beKOJAq1sjYHYp2raykgNMvjzHt4npjr

//api books: https://api.nytimes.com/svc/books/v3/lists/full-overview.json?api-key=beKOJAq1sjYHYp2raykgNMvjzHt4npjr
object Common {
    const val BASE_URL = "https://api.nytimes.com/svc/books/v3/"
    const val API_KEY = "beKOJAq1sjYHYp2raykgNMvjzHt4npjr"

    fun retrofitService(context: Context):RetrofitService {
        return getRetrofit(context).create(RetrofitService::class.java)
    }

    fun getRetrofit(context: Context) : Retrofit{
        val build = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .client(okHttpClient)
        .build()
    return build
}
}