package uz.ilhomjon.bookapp.view.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ilhomjon.bookapp.Models.TopAuthorsModel
import uz.ilhomjon.bookapp.databinding.TopAuthorsItemBinding

class TopAuthorsRVAdapter(var authorsItemList: List<TopAuthorsModel>) :
    RecyclerView.Adapter<TopAuthorsRVAdapter.TopAuthorsVh>() {

    inner class TopAuthorsVh(private val binding: TopAuthorsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun onBind(authorsModel: TopAuthorsModel) {
            binding.topAuthorsImage
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopAuthorsVh {
        return TopAuthorsVh(
            TopAuthorsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TopAuthorsVh, position: Int) {
        holder.onBind(authorsItemList[position])
    }

    override fun getItemCount(): Int {
        return authorsItemList.size
    }

}