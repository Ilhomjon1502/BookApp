package uz.ilhomjon.bookapp.presenter

import uz.ilhomjon.bookapp.Models.myclass.AllBook.Book

interface Contacts {

    //update ui
    interface View{
        fun showTrendingBooks()
        fun showCategoriesName()
        fun showCategoriesBooks()
    }

    interface Model{

    }

    //action user
    interface Presenter{
        fun setCategory(title:String)
        fun clickItemTrendingBook(book: Book)
        fun clickItemByCategoryBook(book: uz.ilhomjon.bookapp.Models.myclass.bookListByCategory.Book)
        fun setSearch(text:String)
    }
}
