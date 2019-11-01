package com.vistalis.computerdictionary.API;

import com.vistalis.computerdictionary.Modules.Models.KamayoResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface KamayoTranslate {
    @POST("translate")
    Call<KamayoResponse> translate(@Body HashMap<String, String> body);
}
