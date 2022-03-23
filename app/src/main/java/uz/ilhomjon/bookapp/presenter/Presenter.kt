package uz.ilhomjon.bookapp.presenter

import uz.ilhomjon.bookapp.Models.myclass.AllBook.Book
import uz.ilhomjon.bookapp.Models.myclass.AllBook.MyBook
import uz.ilhomjon.bookapp.Models.myclass.CategoryClass.MyCategory
import uz.ilhomjon.bookapp.Models.myclass.bookListByCategory.BookListByCategory
import uz.ilhomjon.bookapp.Models.viewmodel.MyResource

class Presenter(
    private val mainView: Contacts.View?,
    private val model: Contacts.Model
) : Contacts.Presenter, Contacts.Model.ApiGetBooks {
    override fun getTrendingBooks(res: MyResource<MyBook>) {
        mainView?.showTrendingBooks(res)
    }

    override fun getCategoriesName(res: MyResource<MyCategory>) {
        mainView?.showCategoriesName(res)
    }

    override fun getCategoriesBooks(res: MyResource<BookListByCategory>) {
        mainView?.showCategoriesBooks(res)
    }

    override fun onCreateStart() {
        model.updateUiFirst(this)
    }

    override fun setCategory(title: String) {
        model.setCategoryBooks(this, title)
    }

    override fun clickItemTrendingBook(book: Book) {
        TODO("Not yet implemented")
    }

    override fun clickItemByCategoryBook(book: uz.ilhomjon.bookapp.Models.myclass.bookListByCategory.Book) {
        TODO("Not yet implemented")
    }

    override fun setSearch(text: String) {
        TODO("Not yet implemented")
    }

}