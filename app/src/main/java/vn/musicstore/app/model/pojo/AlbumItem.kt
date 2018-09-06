package vn.musicstore.app.model.pojo

import java.util.*

data class AlbumItem (var Name: String,
                      var ReleasedDate: Date,
                      var Songs:List<SongItem>,
                      var Artist:ArtistItem,
                      var PlayTimes:Int) {
}