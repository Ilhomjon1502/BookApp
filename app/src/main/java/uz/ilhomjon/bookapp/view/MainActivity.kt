package uz.ilhomjon.bookapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import uz.ilhomjon.bookapp.view.Adapters.CategoriesRVAdapter
import uz.ilhomjon.bookapp.view.Adapters.TopAuthorsRVAdapter
import uz.ilhomjon.bookapp.view.Adapters.TrendingBooksRVAdapter
import uz.ilhomjon.bookapp.Models.CategoriesModel
import uz.ilhomjon.bookapp.Models.TopAuthorsModel
import uz.ilhomjon.bookapp.Models.viewmodel.MyBookViewModel
import uz.ilhomjon.bookapp.Models.viewmodel.MyStatus
import uz.ilhomjon.bookapp.R
import uz.ilhomjon.bookapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    private lateinit var categoriesRVAdapter: CategoriesRVAdapter
    private lateinit var categoriesItemList: ArrayList<CategoriesModel>

    private lateinit var trendingBooksRVAdapter: TrendingBooksRVAdapter

    private lateinit var topAuthorsRVAdapter: TopAuthorsRVAdapter
    private lateinit var topAuthorsList: ArrayList<TopAuthorsModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        categoriesRVAdapter = CategoriesRVAdapter(categoriesItemList)
        binding.categoriesRV.adapter = categoriesRVAdapter



        topAuthorsRVAdapter = TopAuthorsRVAdapter(topAuthorsList)
        binding.topAuthorsRV.adapter = topAuthorsRVAdapter

    }

    private fun loadData() {

        categoriesItemList = ArrayList()

        categoriesItemList.add(CategoriesModel("Motivation & Inspiration"))
        categoriesItemList.add(CategoriesModel("Motivation"))
        categoriesItemList.add(CategoriesModel("Motivation & Inspiration"))
        categoriesItemList.add(CategoriesModel("Motivation"))
        categoriesItemList.add(CategoriesModel("Motivation & Inspiration"))
        categoriesItemList.add(CategoriesModel("Motivation"))
        categoriesItemList.add(CategoriesModel("Motivation & Inspiration"))
        categoriesItemList.add(CategoriesModel("Motivation"))
        categoriesItemList.add(CategoriesModel("Motivation & Inspiration"))

        topAuthorsList = ArrayList()

        topAuthorsList.add(TopAuthorsModel(R.drawable.ic_launcher_background))
        topAuthorsList.add(TopAuthorsModel(R.drawable.ic_launcher_background))
        topAuthorsList.add(TopAuthorsModel(R.drawable.ic_launcher_background))
        topAuthorsList.add(TopAuthorsModel(R.drawable.ic_launcher_background))
        topAuthorsList.add(TopAuthorsModel(R.drawable.ic_launcher_background))
        topAuthorsList.add(TopAuthorsModel(R.drawable.ic_launcher_background))
        topAuthorsList.add(TopAuthorsModel(R.drawable.ic_launcher_background))
        topAuthorsList.add(TopAuthorsModel(R.drawable.ic_launcher_background))
        topAuthorsList.add(TopAuthorsModel(R.drawable.ic_launcher_background))
        topAuthorsList.add(TopAuthorsModel(R.drawable.ic_launcher_background))

        val myBookViewModel: MyBookViewModel = ViewModelProvider(this).get(MyBookViewModel::class.java)
        myBookViewModel.getMyBook(this).observe(this) {
            when (it.status) {
                MyStatus.LOADING ->{
                    Log.d(TAG, "loadData: loading")
                    binding.progressLoading.visibility = View.VISIBLE
                }
                MyStatus.ERROR ->{
                    Log.d(TAG, "loadData: Error \n ${it.message}")
                    binding.progressLoading.visibility = View.GONE
                    Toast.makeText(this, "Error. Internetga ulanishni tekshiring...", Toast.LENGTH_SHORT).show()
                }
                MyStatus.SUCCESS ->{
                    Log.d(TAG, "loadData: ${it.data}")
                    binding.progressLoading.visibility = View.GONE
                    trendingBooksRVAdapter = TrendingBooksRVAdapter(it.data?.results?.lists?.get(0)?.books!!)
                    binding.trendingBooksRV.adapter = trendingBooksRVAdapter
                }
            }
        }
    }
}