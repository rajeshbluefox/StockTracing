package bluefox.mobileapps.stocktracing.zAPIEndPoints

import bluefox.mobileapps.stocktracing.loginModule.modalClass.LoginResponse
import retrofit2.http.GET

interface ApiInterface {


    @GET("products")
    suspend fun validateLogin(
    ): LoginResponse


}