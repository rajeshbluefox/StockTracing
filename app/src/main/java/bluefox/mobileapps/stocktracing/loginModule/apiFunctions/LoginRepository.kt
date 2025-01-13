package bluefox.mobileapps.stocktracing.loginModule.apiFunctions

import bluefox.mobileapps.stocktracing.loginModule.modalClass.LoginResponse
import bluefox.mobileapps.stocktracing.zAPIEndPoints.ApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    private var loginResponse = LoginResponse()

    suspend fun validateLogin(): LoginResponse {
        try {
            withContext(Dispatchers.IO) {
                loginResponse = apiHelper.validateLogin()
            }
        } catch (_: Exception) {
        }
        return loginResponse
    }

}