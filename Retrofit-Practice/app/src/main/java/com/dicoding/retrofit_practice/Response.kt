package com.dicoding.retrofit_practice

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("Response")
	val response: List<ResponseItem?>
)

data class ResponseItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("body")
	val body: String,

	@field:SerializedName("userId")
	val userId: Int
)
