package com.example.tangming.new2018;

import com.appbaselib.base.BaseModel;
import com.google.gson.JsonArray;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by tangming on 2017/5/11.
 */

public interface API {

    String AUTHEN = "spd/rest/authen/";

    String INDEX = "spd/rest/index/";

    String NO_AUTHEN = "spd/rest/";

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    @POST(INDEX + "authorize")
    Observable<BaseModel<LoginIdentity>> login(@Query("phone") String phone, @Query("password") String password);


}
