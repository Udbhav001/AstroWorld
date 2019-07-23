package com.example.astroworld.connection;

import com.example.astroworld.bean.Profile;
import com.example.astroworld.bean.QuestionAnswer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SendFunction
{
    @FormUrlEncoded
    @POST("RegisterAstrologer")
    Call<String> registerAstrologer(@Field("userid") String userid,
                                    @Field("Name") String Name,
                                    @Field("Address") String Address,
                                    @Field("email") String email,
                                    @Field("Gender") String Gender,
                                    @Field("PhoneNo") String Phoneno,
                                    @Field("experience") String experience,
                                    @Field("skills") String skills,
                                    @Field("registrationo") String registrationo,
                                    @Field("userpass") String userpass);

    @FormUrlEncoded
    @POST("RegisterUser")
    Call<String> registerUser(@Field("userid") String userid,
                              @Field("Name") String Name,
                              @Field("Address") String Address,
                              @Field("email") String email,
                              @Field("Gender") String Gender,
                              @Field("PhoneNo") String Phoneno,
                              @Field("date") String date,
                              @Field("datereg") String datereg,
                              @Field("userpass") String userpass);

@FormUrlEncoded
@POST("LoginUser")
Call<ArrayList<Profile>> Login(@Field("userid") String userid,
                               @Field("userpass") String pass);
@FormUrlEncoded
@POST("AskQuestions")
Call<ArrayList<String>>  askQuestions(@Field("userid") String s);

@FormUrlEncoded
@POST("updateUser")
Call<ArrayList<Profile>> updateUser(@Field("name") String name,
                                    @Field("address") String address,
                                    @Field("email") String email,
                                    @Field("phoneno") String phone,
                                    @Field("userid") String userid);
    @FormUrlEncoded
    @POST("updateAstrologer")
    Call<ArrayList<Profile>> updateAstrologer(@Field("name") String name,
                                              @Field("address") String address,
                                              @Field("email") String email,
                                              @Field("phoneno") String phone,
                                              @Field("experience") String exp,
                                              @Field("skills") String s,
                                              @Field("userid") String userid);

    @FormUrlEncoded
    @POST("viewAstrologer")
    Call<ArrayList<Profile>>  viewAstrologer(@Field("userid") String s);

    @FormUrlEncoded
    @POST("viewQuestionAstrologer")
    Call<ArrayList<QuestionAnswer>>  viewQuesAstro(@Field("userid") String s);
    @FormUrlEncoded
    @POST("Question")
    Call<String> question(@Field("userid") String uid,
                          @Field("astroid") String aid,
                          @Field("ques") String q,
                          @Field("dofques") String dq
    );
    @FormUrlEncoded
    @POST("answerAstrologer")
    Call<String>  answer(@Field("userid") String s,
                         @Field("question") String a,
                         @Field("answer") String q,
                         @Field("date") String w,
                         @Field("astroid") String e);
    @FormUrlEncoded
    @POST("viewAnswer")
    Call<ArrayList<QuestionAnswer>> viewanswer(@Field("userid") String u, @Field("astroid") String a);

    @FormUrlEncoded
    @POST("viewuserquesans")
    Call<ArrayList<QuestionAnswer>> view1(@Field("ques") String u,
                                          @Field("astroid") String a);


    @FormUrlEncoded
    @POST("call_sms")
    Call<ArrayList<Profile>> call_sms(@Field("id") String u);

}
