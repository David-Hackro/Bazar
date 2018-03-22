package hackro.tutorials.com.bazar.data.network

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class Response {

  @SerializedName("errors")
  var errors: ArrayList<Errors>? = null

  constructor() {}

  constructor(errors: ArrayList<Errors>) {
    this.errors = errors
  }
}