package uz.ilhomjon.bookapp.view.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ilhomjon.bookapp.Models.utils.SaveBook
import uz.ilhomjon.bookapp.databinding.ItemDrawerRvBinding

class RvSaveBookAdapter(val list: List<SaveBook>, var rvClick: RvClick) : RecyclerView.Adapter<RvSaveBookAdapter.Vh>() {

    inner class Vh(var itemRv: ItemDrawerRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(saveBook: SaveBook) {
            itemRv.tvItemDrawer.text = saveBook.title
            itemRv.root.setOnClickListener { rvClick.onClick(saveBook) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemDrawerRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface RvClick{
        fun onClick(saveBook: SaveBook)
    }
}