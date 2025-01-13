package bluefox.mobileapps.stocktracing.zAPIEndPoints

import bluefox.mobileapps.stocktracing.loginModule.modalClass.LoginResponse

interface ApiHelper {
    suspend fun validateLogin(): LoginResponse
}