package vn.musicstore.app.model.data

data class BasicResponseModel<T>(var status: Int = 0,
                                 var message: String = "",
                                 var data: T? = null,
                                 var total: Int = 0){

    operator fun not():Boolean{
        return data == null || status != 200
    }
}