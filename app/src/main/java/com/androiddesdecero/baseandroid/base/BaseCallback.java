package com.androiddesdecero.baseandroid.base;

import android.os.Bundle;

/**
 * Created by albertopalomarrobledo on 21/2/19.
 */

public interface BaseCallback<T> {

    void onSuccess(T t, int httpCode);

    void onError(Bundle errorInfo, Integer httpCode);

    void always();

}
