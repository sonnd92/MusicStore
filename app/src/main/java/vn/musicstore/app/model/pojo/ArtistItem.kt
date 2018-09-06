package vn.musicstore.app.model.pojo

import vn.musicstore.app.model.BaseModel
import java.util.*

data class ArtistItem(var Name: String, var Age: Int, var Country: String, var DateOfBirth: Date, var Gender: Boolean) : BaseModel() {
}