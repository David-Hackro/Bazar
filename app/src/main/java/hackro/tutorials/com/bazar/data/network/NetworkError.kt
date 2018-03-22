package hackro.tutorials.com.bazar.data.network

import android.app.Application
import android.text.TextUtils
import com.google.gson.Gson
import hackro.tutorials.com.bazar.R
import retrofit2.adapter.rxjava.HttpException
import java.io.IOException
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED

class NetworkError(private val application: Application) : Throwable() {
  var error: Throwable? = null

  val isAuthFailure: Boolean
    get() = error is HttpException && (error as HttpException).code() == HTTP_UNAUTHORIZED

  val isResponseNull: Boolean
    get() = error is HttpException && (error as HttpException).response() == null

  val appErrorMessage: String
    get() {
      if (this.error is IOException) return application.getString(
          R.string.text_error_conection_internet
      )
      if (this.error !is HttpException) return application.getString(R.string.text_error_try_again)
      val response = (this.error as HttpException).response()
      if (response != null) {
        val status = getJsonStringFromResponse(response)
        if (!TextUtils.isEmpty(status)) return status!!

        val headers = response.headers()
            .toMultimap()
        if (headers.containsKey(application.getString(R.string.text_error_unexpected)))
          return headers[application.getString(R.string.text_error_unexpected)]!!.get(0)
      }
      return application.getString(R.string.text_error_try_again)
    }

  /*fun getMessage(): String? {
      return error!!.message
  }*/

  protected fun getJsonStringFromResponse(response: retrofit2.Response<*>): String? {
    try {
      val jsonString = response.errorBody()
          .string()
      val errorResponse = Gson().fromJson(jsonString, Response::class.java)
      return errorResponse.errors!![0].message
    } catch (e: Exception) {
      return null
    }

  }

  override fun equals(o: Any?): Boolean {
    if (this === o) return true
    if (o == null || javaClass != o.javaClass) return false

    val that = o as NetworkError?

    return if (error != null) error == that!!.error else that!!.error == null

  }

  override fun hashCode(): Int {
    return if (error != null) error!!.hashCode() else 0
  }
}