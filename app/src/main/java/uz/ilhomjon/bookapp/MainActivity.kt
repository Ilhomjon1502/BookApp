package uz.ilhomjon.bookapp

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.ilhomjon.bookapp.Adapters.CategoriesRVAdapter
import uz.ilhomjon.bookapp.Adapters.TopAuthorsRVAdapter
import uz.ilhomjon.bookapp.Adapters.TrendingBooksRVAdapter
import uz.ilhomjon.bookapp.Models.CategoriesModel
import uz.ilhomjon.bookapp.Models.TopAuthorsModel
import uz.ilhomjon.bookapp.Models.TrendingBookModel
import uz.ilhomjon.bookapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var categoriesRVAdapter: CategoriesRVAdapter
    private lateinit var categoriesItemList: ArrayList<CategoriesModel>

    private lateinit var trendingBooksRVAdapter: TrendingBooksRVAdapter
    private lateinit var trendingItemList: ArrayList<TrendingBookModel>

    private lateinit var topAuthorsRVAdapter: TopAuthorsRVAdapter
    private lateinit var topAuthorsList: ArrayList<TopAuthorsModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        categoriesRVAdapter = CategoriesRVAdapter(categoriesItemList)
        binding.categoriesRV.adapter = categoriesRVAdapter

        trendingBooksRVAdapter = TrendingBooksRVAdapter(trendingItemList)
        binding.trendingBooksRV.adapter = trendingBooksRVAdapter

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

        trendingItemList = ArrayList()

        trendingItemList.add(TrendingBookModel("Book 1"))
        trendingItemList.add(TrendingBookModel("Book 2"))
        trendingItemList.add(TrendingBookModel("Book 3"))
        trendingItemList.add(TrendingBookModel("Book 4"))
        trendingItemList.add(TrendingBookModel("Book 5"))
        trendingItemList.add(TrendingBookModel("Book 6"))
        trendingItemList.add(TrendingBookModel("Book 7"))
        trendingItemList.add(TrendingBookModel("Book 8"))
        trendingItemList.add(TrendingBookModel("Book 9"))
        trendingItemList.add(TrendingBookModel("Book 10"))

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
    }
}