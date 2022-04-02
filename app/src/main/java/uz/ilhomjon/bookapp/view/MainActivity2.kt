package uz.ilhomjon.bookapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import uz.ilhomjon.bookapp.Models.myclass.bookListByCategory.Book
import uz.ilhomjon.bookapp.Models.utils.MySharedPreference
import uz.ilhomjon.bookapp.Models.utils.SaveBook
import uz.ilhomjon.bookapp.R
import uz.ilhomjon.bookapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    var isCategory  = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)
        val list = MySharedPreference.obektString

        isCategory = intent.getIntExtra("isCategory", -1)

        when(isCategory){
            0->{
                val book = intent.getSerializableExtra("keyBook") as uz.ilhomjon.bookapp.Models.myclass.AllBook.Book
                val saveBook = SaveBook(
                    book.title,
                    book.author,
                    book.rank,
                    book.price,
                    book.description,
                    book.book_image
                )
                saving(saveBook)
            }
            1->{
                val book = intent.getSerializableExtra("keyBook") as Book
                val saveBook = SaveBook(
                    book.title,
                    book.author,
                    book.rank,
                    book.price,
                    book.description,
                    book.book_image
                )
                saving(saveBook)
            }
            3->{
                saving(intent.getSerializableExtra("keyBook") as SaveBook)
            }
        }

        binding.imageBack.setOnClickListener { finish() }
    }

    fun saving(book:SaveBook){
        MySharedPreference.init(this)
        val list = MySharedPreference.obektString
        binding.apply {
            if (list.contains(book)){
                imageSave.setImageResource(R.drawable.ic_savong)
            }
            Picasso.get().load(book.imageLink).into(image2)
            tvDisplayName1.text = book.title
            tvDisplayName2.text = book.author
            tvRating.text = book.rank.toString()
            tvPrice.text = book.price
            tvDesc.text = book.desc

            imageSave.setOnClickListener {
                if (list.contains(book)){
                    list.remove(book)
                    MySharedPreference.obektString = list
                    Toast.makeText(this@MainActivity2, "O'chirildi", Toast.LENGTH_SHORT).show()
                    imageSave.setImageResource(R.drawable.save)
                }else{
                    list.add(book)
                    MySharedPreference.obektString = list
                    Toast.makeText(this@MainActivity2, "Saqlandi", Toast.LENGTH_SHORT).show()
                    imageSave.setImageResource(R.drawable.ic_savong)
                }
            }
        }

    }
}