package com.example.prince.socialride.api;

/**
 * Created by prince on 11/19/2017.
 */




import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface  ApiService {


    @POST("recoverpassword.php")
    @FormUrlEncoded
    Call<MessageStatus> recPassword(@Field("key") int code,
                                    @Field("email") String email);

    @POST("changepassword.php")
    @FormUrlEncoded
    Call <MessageStatus> rec2Password(@Field("key") int code,
                                           @Field("email") String email);

    @POST("changepassword2.php")
    @FormUrlEncoded
    Call <MessageStatus> newPassword(@Field("password") String password,
                                          @Field("email") String email);


    @POST("findpeople2.php")
    @FormUrlEncoded
    Call<MessageStatus> getPeople(@Field("id") int id,
                                            @Field("radius") int radius,
                                            @Field("type1") String type1,
                                            @Field("type2") String type2,
                                            @Field("type3") String type3,
                                            @Field("gender1") String gender1,
                                            @Field("gender2") String gender2);



    @FormUrlEncoded
    @POST("signin.php")
    Call<MessageStatus> authenticate(@Field("username") String username,
                                     @Field("password") String password,
                                     @Field("longitude") String longitude,
                                     @Field("latitude") String latittude);

    @FormUrlEncoded
    @POST("signup.php")
    Call<MessageStatus> registration(@Field("username") String username,
                                     @Field("password") String password,
                                     @Field("type") String type,
                                     @Field("email") String email,
                                     @Field("longitude") String longitude,
                                     @Field("latitude") String latittude);

    @FormUrlEncoded
    @POST("update.php")
    Call<MessageStatus> profileUpdater(@Field("id") int id,
                                           @Field("name") String name,
                                           @Field("sex") String sex,
                                           @Field("about") String about,
                                           @Field("work") String work,
                                           @Field("age") int age);

    @FormUrlEncoded
    @POST("deleteaccount.php")
    Call<MessageStatus> deleteAccount(@Field("id") int id);
}
