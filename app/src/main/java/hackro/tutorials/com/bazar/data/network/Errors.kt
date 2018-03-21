package hackro.tutorials.com.bazar.data.network

import com.google.gson.annotations.SerializedName

class Errors {

    @SerializedName("code")
    var code: Int = 0

    @SerializedName("message")
    var message: String? = null
}
