package uz.ilhomjon.bookapp.view.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.ilhomjon.bookapp.Models.myclass.AllBook.Book
import uz.ilhomjon.bookapp.databinding.TrendingItemBinding

class TrendingBooksRVAdapter(var trendingBookList: List<Book>) :
    RecyclerView.Adapter<TrendingBooksRVAdapter.TrendingVh>() {

    inner class TrendingVh(private val binding: TrendingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(trendingBookModel: Book, position: Int) {
            binding.trendingBooksText.text = trendingBookModel.title
            Picasso.get().load(trendingBookModel.book_image).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingVh {
        return TrendingVh(
            TrendingItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TrendingVh, position: Int) {
        holder.onBind(trendingBookList[position], position)
    }

    override fun getItemCount(): Int {
        return trendingBookList.size
    }

}