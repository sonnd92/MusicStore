package vn.musicstore.app.model.pojo

import vn.musicstore.app.model.BaseModel

data class GenreItem(var Name:String, var Code:String, var ParentId:Long, var ParentName:String): BaseModel() {
}