package com.androiddesdecero.baseandroid.mapper;
import com.androiddesdecero.baseandroid.base.BaseMapper;
import com.androiddesdecero.baseandroid.data.response.LoginResponse;

/**
 * Created by albertopalomarrobledo on 22/2/19.
 */

public class LoginMapper extends BaseMapper<LoginResponse, String> {

    @Override
    public String map(LoginResponse loginResponse) {
        String token = loginResponse.getData().getToken();
        return token;
    }
}
