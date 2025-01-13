package bluefox.mobileapps.stocktracing.loginModule.modalClass

import com.google.gson.annotations.SerializedName


data class LoginResponse(
    @SerializedName("status")
    val status: Int? = null,
    @SerializedName("products")
    val message: String? = null
)