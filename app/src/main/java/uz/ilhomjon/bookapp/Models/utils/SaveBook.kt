package uz.ilhomjon.bookapp.Models.utils

import java.io.Serializable

data class SaveBook (val title:String, val author:String, val rank:Int, val price:String, val desc:String,  val imageLink:String):Serializable