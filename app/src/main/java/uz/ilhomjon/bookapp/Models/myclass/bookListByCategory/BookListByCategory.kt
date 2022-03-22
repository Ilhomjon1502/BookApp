package uz.ilhomjon.bookapp.Models.myclass.bookListByCategory

data class BookListByCategory(
    val copyright: String,
    val last_modified: String,
    val num_results: Int,
    val results: Results,
    val status: String
)