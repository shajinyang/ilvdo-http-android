package com.ilvdo.ilvdo_http_android.retrofit.api

import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*
import java.util.*

/**
 * Created by sjy on 2018/12/5
 * Describe
 */
interface ApiService {

    @GET
    fun get(@Url url: String, @QueryMap params: WeakHashMap<String, Any>): Observable<String>

    @FormUrlEncoded
    @POST
    fun post(@Url url: String, @FieldMap params: WeakHashMap<String, Any>): Observable<String>

    @POST
    fun postRaw(@Url url: String, @Body body: RequestBody): Observable<String>

    @FormUrlEncoded
    @PUT
    fun put(@Url url: String, @FieldMap params: WeakHashMap<String, Any>): Observable<String>

    @PUT
    fun putRaw(@Url url: String, @Body body: RequestBody): Observable<String>

    @DELETE
    fun delete(@Url url: String, @QueryMap params: WeakHashMap<String, Any>): Observable<String>

    @Streaming
    @GET
    fun download(@Url url: String, @QueryMap params: WeakHashMap<String, Any>): Observable<ResponseBody>

    @Multipart
    @POST
    fun upload(@Url url: String, @Part file: MultipartBody.Part): Observable<String>
}