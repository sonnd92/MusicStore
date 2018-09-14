package vn.musicstore.app.prefs

class UserSaved(sharePreference: AppSharePreference) {

    private val sharedPref: AppSharePreference = sharePreference

    private val KEY_IS_LOGIN = "isLogged"
    private val KEY_ID = "id"
    private val KEY_FULL_NAME = "fullName"
    private val KEY_GENDER = "gender"
    private val KEY_AVATAR = "avatar"
    private val KEY_TYPE = "type"
    private val KEY_EMAIL = "email"
    private val KEY_UNCONFIRMED_EMAIL = "unconfirmedEmail"
    private val KEY_PHONE = "phone"
    private val KEY_USERNAME = "userName"
    private val KEY_ADDRESS = "userAddress"
    private val KEY_ADDRESS_X_POINT = "userAddressXPoint"
    private val KEY_ADDRESS_Y_POINT = "userAddressYPoint"
    private val KEY_FIREBASE_EMAIL_LINK = "firebaseEmailLink"
    private val KEY_TOKEN = "token"

    fun setIsLoggedIn(isLogged: Boolean) = sharedPref.set(KEY_IS_LOGIN, isLogged)
    fun isLoggedIn() = sharedPref.getBoolean(KEY_IS_LOGIN)

    fun setUserId(id: Int) = sharedPref.set(KEY_ID, id)
    fun getUserId() = sharedPref.getInt(KEY_ID)

    fun setFullName(fullName: String) = sharedPref.set(KEY_FULL_NAME, fullName)
    fun getFullName() = sharedPref.getString(KEY_FULL_NAME)

    fun setGender(isMale: Boolean) = sharedPref.set(KEY_GENDER, isMale)
    fun isMale() = sharedPref.getBoolean(KEY_GENDER)

    fun setAvatar(avatarUrl: String) = sharedPref.set(KEY_AVATAR, avatarUrl)
    fun getAvatar() = sharedPref.getString(KEY_AVATAR)

    fun setTypeId(typeId: Int) = sharedPref.set(KEY_TYPE, typeId)
    fun getTypeId() = sharedPref.getInt(KEY_TYPE)

    fun setUnconfirmedEmail(unconfirmedEmail: String) = sharedPref.set(KEY_UNCONFIRMED_EMAIL, unconfirmedEmail)
    fun getUnconfirmedEmail() = sharedPref.getString(KEY_UNCONFIRMED_EMAIL)

    fun setEmail(email: String) = sharedPref.set(KEY_EMAIL, email)
    fun getEmail() = sharedPref.getString(KEY_EMAIL)

    fun setPhonNumber(phoneNumber: String) = sharedPref.set(KEY_PHONE, phoneNumber)
    fun getPhoneNumber() = sharedPref.getString(KEY_PHONE)

    fun setUserName(userName: String) = sharedPref.set(KEY_USERNAME, userName)
    fun getUserName() = sharedPref.getString(KEY_USERNAME)

    fun setAddress(address: String) = sharedPref.set(KEY_ADDRESS, address)
    fun getAddress() = sharedPref.getString(KEY_ADDRESS)

    fun setAddressLatPoint(lat: Float) = sharedPref.set(KEY_ADDRESS_X_POINT, lat)
    fun getAddressLatPoint() = sharedPref.getFloat(KEY_ADDRESS_X_POINT)

    fun setAddressLngPoint(lng: Float) = sharedPref.set(KEY_ADDRESS_Y_POINT, lng)
    fun getAddressLngPoint() = sharedPref.getFloat(KEY_ADDRESS_Y_POINT)

    fun setTokenKey(token: String) = sharedPref.set(KEY_TOKEN, token)
    fun getTokenKey() = sharedPref.getString(KEY_TOKEN)

    fun setFirebaseEmailLink(token: String) = sharedPref.set(KEY_FIREBASE_EMAIL_LINK, token)
    fun getFirebaseEmailLink() = sharedPref.getString(KEY_FIREBASE_EMAIL_LINK)

    fun clear() = sharedPref.removeAll()
}