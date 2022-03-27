package uz.ilhomjon.bookapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import uz.ilhomjon.bookapp.Models.myclass.bookListByCategory.Book
import uz.ilhomjon.bookapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    var isCategory  = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        isCategory = intent.getIntExtra("isCategory", -1)

        if (isCategory == 1){
            val book = intent.getSerializableExtra("keyBook") as Book
            binding.apply {
                Picasso.get().load(book.book_image).into(image2)
                tvDisplayName1.text = book.title
                tvDisplayName2.text = book.author
                tvRating.text = book.rank.toString()
                tvPrice.text = book.price
                tvDesc.text = book.description
            }
        }else if (isCategory == 0){
            val book = intent.getSerializableExtra("keyBook") as uz.ilhomjon.bookapp.Models.myclass.AllBook.Book
            binding.apply {
                Picasso.get().load(book.book_image).into(image2)
                tvDisplayName1.text = book.title
                tvDisplayName2.text = book.author
                tvRating.text = book.rank.toString()
                tvPrice.text = book.price
                tvDesc.text = book.description
            }
        }

        binding.imageBack.setOnClickListener { finish() }
    }
}