package vn.musicstore.app.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T>{

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value?:throw IllegalStateException("Value not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if(this.value == null) value else throw IllegalStateException("Value already initialized")
    }
}

object DelegateExts{
    fun <T> notNullSingleValue() : ReadWriteProperty<Any?, T>  = NotNullSingleValueVar()
}