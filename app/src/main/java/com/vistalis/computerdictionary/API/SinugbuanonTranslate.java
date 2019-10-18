package com.vistalis.computerdictionary.API;

import com.vistalis.computerdictionary.Modules.Models.SinugbuanonRequest;
import com.vistalis.computerdictionary.Modules.Models.SinugbuanonResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SinugbuanonTranslate {
    @POST("translate")
    Call<SinugbuanonResponse> translate(@Body SinugbuanonRequest sinugbuanonRequest);
}
