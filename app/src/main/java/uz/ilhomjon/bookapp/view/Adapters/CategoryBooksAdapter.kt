package uz.ilhomjon.bookapp.view.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.ilhomjon.bookapp.Models.myclass.bookListByCategory.Book
import uz.ilhomjon.bookapp.databinding.TrendingItemBinding

class CategoryBooksAdapter(val list: List<Book>) : RecyclerView.Adapter<CategoryBooksAdapter.Vh>() {

    inner class Vh(var itemRv: TrendingItemBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(book: Book) {
            Picasso.get().load(book.book_image).into(itemRv.imageView)
            itemRv.trendingBooksText.text = book.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(TrendingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}