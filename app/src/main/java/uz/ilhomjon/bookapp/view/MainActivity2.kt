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

        if (isCategory == 1){
            val book = intent.getSerializableExtra("keyBook") as Book
            binding.apply {
                Picasso.get().load(book.book_image).into(image2)
                tvDisplayName1.text = book.title
                tvDisplayName2.text = book.author
                tvRating.text = book.rank.toString()
                tvPrice.text = book.price
                tvDesc.text = book.description

                imageSave.setOnClickListener {
                    val saveBook = SaveBook(book.title, book.author, book.rank, book.price, book.description, book.book_image)
                    if (list.contains(saveBook)){
                        list.remove(saveBook)
                        MySharedPreference.obektString = list
                        Toast.makeText(this@MainActivity2, "Saqlanganlardan o'chirildi", Toast.LENGTH_SHORT).show()
                    }else{
                        list.add(saveBook)
                        MySharedPreference.obektString = list
                        Toast.makeText(this@MainActivity2, "Saqlanganlarga qo'sjildi", Toast.LENGTH_SHORT).show()
                    }
                }
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

                imageSave.setOnClickListener {
                    val saveBook = SaveBook(book.title, book.author, book.rank, book.price, book.description, book.book_image)
                    if (list.contains(saveBook)){
                        list.remove(saveBook)
                        MySharedPreference.obektString = list
                        Toast.makeText(this@MainActivity2, "Saqlanganlardan o'chirildi", Toast.LENGTH_SHORT).show()
                        imageSave.setImageResource(R.drawable.save)
                    }else{
                        list.add(saveBook)
                        MySharedPreference.obektString = list
                        Toast.makeText(this@MainActivity2, "Saqlanganlarga qo'sjildi", Toast.LENGTH_SHORT).show()
                        imageSave.setImageResource(R.drawable.ic_savong)
                    }
                }
            }
        }else if(isCategory == 3) {
            binding.apply {
                val book = intent.getSerializableExtra("keyBook") as SaveBook
                binding.apply {
                    Picasso.get().load(book.imageLink).into(image2)
                    tvDisplayName1.text = book.title
                    tvDisplayName2.text = book.author
                    tvRating.text = book.rank.toString()
                    tvPrice.text = book.price
                    tvDesc.text = book.desc
                    imageSave.setImageResource(R.drawable.ic_savong)

                    imageSave.setOnClickListener {
                        val saveBook = SaveBook(
                            book.title,
                            book.author,
                            book.rank,
                            book.price,
                            book.desc,
                            book.imageLink
                        )
                        if (list.contains(saveBook)) {
                            list.remove(saveBook)
                            MySharedPreference.obektString = list
                            Toast.makeText(
                                this@MainActivity2,
                                "Saqlanganlardan o'chirildi",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            list.add(saveBook)
                            MySharedPreference.obektString = list
                            Toast.makeText(
                                this@MainActivity2,
                                "Saqlanganlarga qo'sjildi",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }

        binding.imageBack.setOnClickListener { finish() }
    }
}