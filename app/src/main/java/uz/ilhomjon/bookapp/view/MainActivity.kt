package uz.ilhomjon.bookapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import uz.ilhomjon.bookapp.view.Adapters.CategoriesRVAdapter
import uz.ilhomjon.bookapp.view.Adapters.TrendingBooksRVAdapter
import uz.ilhomjon.bookapp.Models.CategoriesModel
import uz.ilhomjon.bookapp.Models.Model
import uz.ilhomjon.bookapp.Models.myclass.AllBook.MyBook
import uz.ilhomjon.bookapp.Models.myclass.CategoryClass.MyCategory
import uz.ilhomjon.bookapp.Models.myclass.bookListByCategory.BookListByCategory
import uz.ilhomjon.bookapp.Models.viewmodel.MyBookViewModel
import uz.ilhomjon.bookapp.Models.viewmodel.MyResource
import uz.ilhomjon.bookapp.Models.viewmodel.MyStatus
import uz.ilhomjon.bookapp.databinding.ActivityMainBinding
import uz.ilhomjon.bookapp.presenter.Contacts
import uz.ilhomjon.bookapp.presenter.Presenter
import uz.ilhomjon.bookapp.view.Adapters.CategoryBooksAdapter

class MainActivity : AppCompatActivity(), Contacts.View {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"
    private var presenter: Presenter? = null

    private lateinit var categoriesRVAdapter: CategoriesRVAdapter
    private lateinit var categoryBooksRVAdapter: CategoryBooksAdapter
    private lateinit var trendingBooksRVAdapter: TrendingBooksRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        loadData()
        presenter = Presenter(this, Model(this, this))
        presenter?.onCreateStart()
    }

    private fun loadData() {

        val myBookViewModel: MyBookViewModel =
            ViewModelProvider(this).get(MyBookViewModel::class.java)
        myBookViewModel.getMyBook().observe(this) {
            when (it.status) {
                MyStatus.LOADING -> {
                    Log.d(TAG, "loadData: loading")
                    binding.progressAuthor.visibility = View.VISIBLE
                }
                MyStatus.ERROR -> {
                    Log.d(TAG, "loadData: Error \n ${it.message}")
                    binding.progressAuthor.visibility = View.GONE
                    Toast.makeText(
                        this,
                        "Error. Internetga ulanishni tekshiring...",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                MyStatus.SUCCESS -> {
                    Log.d(TAG, "loadData: ${it.data}")
                    binding.progressAuthor.visibility = View.GONE
                    trendingBooksRVAdapter =
                        TrendingBooksRVAdapter(it.data?.results?.lists?.get(0)?.books!!)
                    binding.topAuthorsRV.adapter = trendingBooksRVAdapter
                }
            }
        }

        myBookViewModel.getCategoryNames().observe(this) {
            when (it.status) {
                MyStatus.LOADING -> {
                    Log.d(TAG, "loadData: loading")
                    binding.progressCategoryNames.visibility = View.VISIBLE
                }
                MyStatus.ERROR -> {
                    Log.d(TAG, "loadData: Error \n ${it.message}")
                    binding.progressCategoryNames.visibility = View.GONE
                    Toast.makeText(
                        this,
                        "Error. Internetga ulanishni tekshiring...",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                MyStatus.SUCCESS -> {
                    Log.d(TAG, "loadData: ${it.data}")
                    binding.progressCategoryNames.visibility = View.GONE

                    val l = it.data?.results
                    categoriesRVAdapter =
                        CategoriesRVAdapter(l!!, object : CategoriesRVAdapter.RvClick {
                            override fun onClick(title: String) {
                                myBookViewModel.getBookByCategoryList(title)
                                    .observe(this@MainActivity) {
                                        when (it.status) {
                                            MyStatus.LOADING -> {
                                                binding.progressTrendingBooks.visibility =
                                                    View.VISIBLE
                                            }
                                            MyStatus.SUCCESS -> {
                                                binding.progressTrendingBooks.visibility = View.GONE
                                                Log.d(TAG, "onClick: ${it.data}")
                                                val categoryBooksAdapter =
                                                    CategoryBooksAdapter(it.data?.results?.books!!)
                                                binding.trendingBooksRV.adapter =
                                                    categoryBooksAdapter
                                            }
                                            MyStatus.ERROR -> {
                                                binding.progressTrendingBooks.visibility = View.GONE
                                                Toast.makeText(
                                                    this@MainActivity,
                                                    "Error category",
                                                    Toast.LENGTH_SHORT
                                                )
                                                    .show()
                                            }
                                        }
                                    }
                            }
                        })
                    binding.categoriesRV.adapter = categoriesRVAdapter
                }
            }
        }
    }

    override fun showTrendingBooks(res: MyResource<MyBook>) {
        when (res.status) {
            MyStatus.SUCCESS -> {
                val l = res.data?.results!!.lists[0].books
                trendingBooksRVAdapter = TrendingBooksRVAdapter(l)
                binding.trendingBooksRV.adapter = trendingBooksRVAdapter
                binding.progressTrendingBooks.visibility = View.GONE
            }
            MyStatus.ERROR -> {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                binding.progressTrendingBooks.visibility = View.GONE
            }
            MyStatus.LOADING->{
                binding.progressTrendingBooks.visibility = View.VISIBLE
            }
        }
    }

    override fun showCategoriesName(res: MyResource<MyCategory>) {
        when (res.status) {
            MyStatus.LOADING -> {
                Log.d(TAG, "loadData: loading")
                binding.progressCategoryNames.visibility = View.VISIBLE
            }
            MyStatus.ERROR -> {
                Log.d(TAG, "loadData: Error \n ${res.message}")
                binding.progressCategoryNames.visibility = View.GONE
                Toast.makeText(
                    this,
                    "Error. Internetga ulanishni tekshiring...",
                    Toast.LENGTH_SHORT
                ).show()
            }
            MyStatus.SUCCESS -> {
                Log.d(TAG, "loadData: ${res.data}")
                binding.progressCategoryNames.visibility = View.GONE
                categoriesRVAdapter = CategoriesRVAdapter(res.data?.results!!, object : CategoriesRVAdapter.RvClick{
                    override fun onClick(title: String) {
                        presenter?.setCategory(title)
                    }
                })
                binding.categoriesRV.adapter = categoriesRVAdapter

                binding.progressCategoryNames.visibility = View.GONE
            }
        }
    }

    override fun showCategoriesBooks(res: MyResource<BookListByCategory>) {
        when(res.status){
            MyStatus.LOADING->{
                binding.progressAuthor.visibility = View.VISIBLE
            }
            MyStatus.ERROR->{
                Toast.makeText(this, "Error category books", Toast.LENGTH_SHORT).show()
                binding.progressAuthor.visibility = View.GONE
            }
            MyStatus.SUCCESS->{
                val l = res.data?.results?.books!!
                categoryBooksRVAdapter = CategoryBooksAdapter(l)
                binding.topAuthorsRV.adapter = categoryBooksRVAdapter
                binding.progressAuthor.visibility = View.GONE
            }
        }
    }
}