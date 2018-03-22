package hackro.tutorials.com.bazar.data.model

import com.google.gson.annotations.SerializedName

data class ResponseListPost(

  @field:SerializedName("data")
  val data: List<DataItem?>? = null
)