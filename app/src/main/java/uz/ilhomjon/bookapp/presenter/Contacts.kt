package uz.ilhomjon.bookapp.presenter

import uz.ilhomjon.bookapp.Models.myclass.AllBook.Book
import uz.ilhomjon.bookapp.Models.myclass.AllBook.MyBook
import uz.ilhomjon.bookapp.Models.myclass.CategoryClass.MyCategory
import uz.ilhomjon.bookapp.Models.myclass.bookListByCategory.BookListByCategory
import uz.ilhomjon.bookapp.Models.viewmodel.MyResource

interface Contacts {

    //update ui
    interface View {
        fun showTrendingBooks(res: MyResource<MyBook>)
        fun showSearch(res:ArrayList<Book>)
        fun showCategoriesName(res: MyResource<MyCategory>)
        fun showCategoriesBooks(res: MyResource<BookListByCategory>)
    }

    interface Model {
        interface ApiGetBooks {
            fun getTrendingBooks(res: MyResource<MyBook>)
            fun getCategoriesName(res: MyResource<MyCategory>)
            fun getCategoriesBooks(res: MyResource<BookListByCategory>)
            fun getSerach(res:ArrayList<Book>)
        }
        fun updateUiFirst(apiGetBooks: ApiGetBooks)
        fun setCategoryBooks(apiGetBooks: ApiGetBooks, title: String)
        fun setSearch(apiGetBooks: ApiGetBooks, title:String)
    }

    //action user
    interface Presenter {
        fun onCreateStart()
        fun setCategory(title: String)
        fun setSearch(text: String)
    }
}
