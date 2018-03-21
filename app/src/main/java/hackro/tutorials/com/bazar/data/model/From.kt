package hackro.tutorials.com.bazar.data.model

import com.google.gson.annotations.SerializedName

data class From(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)