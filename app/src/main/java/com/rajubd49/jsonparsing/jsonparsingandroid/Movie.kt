package com.rajubd49.jsonparsing.jsonparsingandroid

/**
 * Created by bs195 on 5/29/18.
 */

class Movie (
        val results: List<Item>
)

class Item(
        val id: Int,
        val title: String,
        val overview: String,
        val poster_path: String
)