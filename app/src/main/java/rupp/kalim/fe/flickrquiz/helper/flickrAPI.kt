package rupp.kalim.fe.flickrquiz.helper

/**
 * FlickrAPI Class
 * @variable apiKEY
 * @variable tag
 */
class flickrAPI{
    companion object {
        private const val apiKEY = "ebaad17a3185a51a2acfd0c15c7aca4c"
        private var tags = "nature"
        private var method= "flickr.photos.search"

        var apiLink = "https://api.flickr.com//services/rest/?api_key=$apiKEY&method=$method&tags=$tags&format=json&nojsoncallback=1"
    }
}