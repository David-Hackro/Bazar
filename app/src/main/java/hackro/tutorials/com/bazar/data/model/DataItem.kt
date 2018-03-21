package hackro.tutorials.com.bazar.data.model
import com.google.gson.annotations.SerializedName

data class DataItem(

        @field:SerializedName("created_time")
	val createdTime: String? = null,

        @field:SerializedName("full_picture")
	val fullPicture: String? = null,

        @field:SerializedName("name")
	val name: String? = null,

        @field:SerializedName("description")
	val description: String? = null,

        @field:SerializedName("from")
	val from: From? = null,

        @field:SerializedName("id")
	val id: String? = null,

        @field:SerializedName("message")
	val message: String? = null
)