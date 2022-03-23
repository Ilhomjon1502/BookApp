package uz.ilhomjon.bookapp.Models

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import uz.ilhomjon.bookapp.Models.viewmodel.MyBookViewModel
import uz.ilhomjon.bookapp.presenter.Contacts

class Model(var viewModelStoreOwner: ViewModelStoreOwner, var lifecycleOwner: LifecycleOwner) :
    Contacts.Model {
    val myBookViewModel: MyBookViewModel =
        ViewModelProvider(viewModelStoreOwner).get(MyBookViewModel::class.java)

    override fun updateUiFirst(apiGetBooks: Contacts.Model.ApiGetBooks) {
        myBookViewModel.getMyBook().observe(lifecycleOwner) {
            apiGetBooks.getTrendingBooks(it)
        }
        myBookViewModel.getCategoryNames().observe(lifecycleOwner) {
            apiGetBooks.getCategoriesName(it)
        }
    }

    override fun setCategoryBooks(apiGetBooks: Contacts.Model.ApiGetBooks, title: String) {
        myBookViewModel.getBookByCategoryList(title).observe(lifecycleOwner){
            apiGetBooks.getCategoriesBooks(it)
        }
    }
}