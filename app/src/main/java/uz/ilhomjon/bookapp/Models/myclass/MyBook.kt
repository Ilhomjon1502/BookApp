package uz.ilhomjon.bookapp.Models.myclass

data class MyBook(
    val copyright: String,
    val num_results: Int,
    val results: Results,
    val status: String
)