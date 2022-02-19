package uz.ilhomjon.bookapp.view.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ilhomjon.bookapp.Models.TrendingBookModel
import uz.ilhomjon.bookapp.databinding.TrendingItemBinding

class TrendingBooksRVAdapter(var trendingBookList: List<TrendingBookModel>) :
    RecyclerView.Adapter<TrendingBooksRVAdapter.TrendingVh>() {

    inner class TrendingVh(private val binding: TrendingItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(trendingBookModel: TrendingBookModel) {
            binding.trendingBooksText.text = trendingBookModel.trendingBookTv
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
        holder.onBind(trendingBookList[position])
    }

    override fun getItemCount(): Int {
        return trendingBookList.size
    }

}