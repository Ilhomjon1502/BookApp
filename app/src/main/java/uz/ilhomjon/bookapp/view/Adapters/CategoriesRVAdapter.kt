package uz.ilhomjon.bookapp.view.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ilhomjon.bookapp.Models.CategoriesModel
import uz.ilhomjon.bookapp.databinding.CategoriesItemBinding

class CategoriesRVAdapter(var categoriesList: List<CategoriesModel>) :
    RecyclerView.Adapter<CategoriesRVAdapter.CategoriesVh>() {

    inner class CategoriesVh(private val binding: CategoriesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(categoriesModel: CategoriesModel) {
            binding.categoriesItemTv.text = categoriesModel.categoriesTv
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesVh {
        return CategoriesVh(CategoriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CategoriesVh, position: Int) {
        holder.onBind(categoriesList[position])
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

}