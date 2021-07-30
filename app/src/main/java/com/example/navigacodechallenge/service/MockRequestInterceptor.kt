package com.example.navigacodechallenge.service

import android.content.Context
import okhttp3.*
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets.UTF_8

class MockRequestInterceptor(private val context: Context) : Interceptor {

    companion object {
        private val JSON_MEDIA_TYPE = MediaType.parse("application/json")
        private const val MOCK = "mock"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val header = request.header(MOCK)

        if (header != null) {
            return Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .message("")
                .code(200)
                .body(
                    ResponseBody.create(
                        JSON_MEDIA_TYPE,
                        loadJSONFromAsset("payload2")
                    )
                )
                .build()
        }

        return chain.proceed(request.newBuilder().removeHeader(MOCK).build())
    }

    fun loadJSONFromAsset(fileName: String): String {
        var json = " "
        json = try {
            val `is`: InputStream = context.assets.open(fileName)
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return json
        }
        return json
    }
}