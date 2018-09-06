package vn.musicstore.app.model.pojo

import vn.musicstore.app.model.BaseModel
import java.util.*

data class UserModel(
        var UserName:String,
        var Address: String,
        var PhoneNumber: String,
        var DateOfBirth: Date,
        var Gender: Boolean
) : BaseModel()