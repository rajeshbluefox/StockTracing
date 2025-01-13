package bluefox.mobileapps.stocktracing.zAPIEndPoints

import bluefox.mobileapps.stocktracing.loginModule.modalClass.LoginResponse
import javax.inject.Inject

class ApiHelperImplementation @Inject constructor(private val apiService: ApiInterface) :
    ApiHelper {

    override suspend fun validateLogin(): LoginResponse {
        return apiService.validateLogin()
    }

}