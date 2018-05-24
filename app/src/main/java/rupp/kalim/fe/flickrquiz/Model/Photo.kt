package rupp.kalim.fe.flickrquiz.Model

class Photo {
    var idID: String
    var farmID: Int
    var serverID: Int
    var secretID: String

    var url: String
    constructor(id: String, farm: Int, server: Int,secret: String) {
        this.idID = id
        this.farmID = farm
        this.serverID = server
        this.secretID = secret
        this.url = "https://farm$farm.staticflickr.com/$server/$id" + "_" + "${secret}_q.jpg"
    }

}
