package com.dsc.movie.Util

class Url {
    var base_url = "https://api.themoviedb.org/3/movie/"
    var api_key = "?api_key=8f7919c3578bc13ab5577ff2c1acc781"
    var attr = "&language=en-US&page=1"
    var image_path = "https://image.tmdb.org/t/p/w500/"

    fun getUrl(s: String): String{
        return base_url+s+api_key+attr
    }
}