package vn.musicstore.app.data.remote.service

import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable
import vn.musicstore.app.model.data.BasicResponseModel
import vn.musicstore.app.model.data.request.*

interface UserService
{
    @POST("Agent/SignIn")
    fun Login(@Body loginRequest: LoginRequest): Observable<BasicResponseModel<String>>

    @POST("Agent/ForgetPassword")
    fun ForgotPass(@Body forgotPasswordRequest: ForgotPasswordRequest): Observable<BasicResponseModel<Any>>

    @POST("Agent/ResetPassword")
    fun ResetPassword(@Body resetModel: ResetPasswordRequest): Observable<BasicResponseModel<Any>>

    @POST("Agent/ChangePassword")
    fun ChangePassword(@Body changePasswordRequest: ChangePasswordRequest): Observable<BasicResponseModel<Any>>

    @POST("Agent/Register")
    fun Register(@Body registerRequest: RegisterRequest): Observable<BasicResponseModel<Any>>
}