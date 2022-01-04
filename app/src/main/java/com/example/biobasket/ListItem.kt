package com.example.biobasket

class ListItem(Image : Int , Price : Int , Name : String) {

    private val image = Image
    private val price = Price
    private val name = Name

    fun getImage(): Int {
        return image
    }

    fun getPrice() : Int {
        return price
    }

    fun getName() : String  {
        return name
    }

}