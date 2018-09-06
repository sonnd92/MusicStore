package vn.musicstore.app.basic

interface IDynamicUIBehavior<T> : IBaseUIBehavior {
    fun loadDataSuccess(data: T)
}