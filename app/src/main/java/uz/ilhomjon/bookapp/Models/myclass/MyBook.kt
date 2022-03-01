package uz.ilhomjon.bookapp.Models.myclass

data class MyBook(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)