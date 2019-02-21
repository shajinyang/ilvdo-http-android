package com.ilvdo.ilvdo_http_android.retrofit.api

import io.reactivex.Flowable
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

    /**
     * get 请求
     */
    @GET
    fun get(@Url url: String?, @QueryMap params: WeakHashMap<String, Any>): Flowable<String>

    /**
     * post 请求
     */
    @FormUrlEncoded
    @POST
    fun post(@Url url: String, @FieldMap params: WeakHashMap<String, Any>): Flowable<String>

    /**
     * 自定义 结构
     */
    @POST
    fun postRaw(@Url url: String, @Body body: RequestBody): Flowable<String>

    /**
     * 单文件上传
     */
    @Multipart
    @POST
    fun uploadFile(@Url url: String, @Part file: MultipartBody.Part): Flowable<String>

    /**
     * 多文件上传
     */
    @Multipart
    @POST
    fun uploadFiles(@Url url:String, @Part parts: List<MultipartBody.Part>): Flowable<String>

    /**
     * 多文件上传,键值
     */
    @Multipart
    @POST
    fun uploadFilesMap(@Url url:String, @Part parts: HashMap<String,MultipartBody.Part>): Flowable<String>

    /**
     * 多文件混合上传
     */
    @Multipart
    @POST
    fun uploadMulti(@Url url:String,@PartMap map: Map<String, RequestBody> , @Part parts: List<MultipartBody.Part>): Flowable<String>


    /**
     * 多文件混合上传，键值
     */
    @Multipart
    @POST
    fun uploadMultiMap(@Url url:String,@PartMap map: Map<String, RequestBody> , @Part parts: HashMap<String,MultipartBody.Part>): Flowable<String>




    @FormUrlEncoded
    @PUT
    fun put(@Url url: String, @FieldMap params: WeakHashMap<String, Any>): Flowable<String>

    @PUT
    fun putRaw(@Url url: String, @Body body: RequestBody): Flowable<String>

    @DELETE
    fun delete(@Url url: String, @QueryMap params: WeakHashMap<String, Any>): Flowable<String>

    @Streaming
    @GET
    fun download(@Url url: String, @QueryMap params: WeakHashMap<String, Any>): Flowable<ResponseBody>


}