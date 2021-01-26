package com.bookandgo.data

import com.bookandgo.data.sources.API
import org.json.JSONException
import retrofit2.Call
import java.io.IOException
open class CallService{
    fun <T:Any> genericCall(call : Call<T>) : T?  {
        var message =""
        try {
            call.execute().apply {
                message = this.message()
                if(isSuccessful) {
                    return body()
                } else {
                    message = this.raw().message()
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        message = if (message == "")"Timeout" else message
        throw Exception(message)
    }
}

