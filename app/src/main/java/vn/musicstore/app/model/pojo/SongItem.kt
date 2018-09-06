package vn.musicstore.app.model.pojo

data class SongItem(var Name:String,
                    var Size:Long,
                    var Time:Long,
                    var Authors:List<ArtistItem>,
                    var Categories: List<GenreItem>,
                    var PlayTimes:Int,
                    var Album:AlbumItem) {
}