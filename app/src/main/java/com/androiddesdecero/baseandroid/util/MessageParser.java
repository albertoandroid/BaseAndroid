package com.androiddesdecero.baseandroid.util;

import android.os.Bundle;

/**
 * Created by albertopalomarrobledo on 21/2/19.
 */

public class MessageParser {

    //Error Message
    public static final String ERROR_GET_TOKEN= "error_TOKEN";

    public static final String ERROR_GET_CURSOS= "error_CURSOS";

    public static final String ERROR_GET_CURSOS_ARRAY= "error_CURSOS_ARRAY";

    public static final String ERROR_CREAR_CURSO= "error_CREAR_CURSO";


    public static String BUNDLE_TYPE = "bundle_type";

    public static Bundle createBundle(String type){
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TYPE, type);
        return bundle;
    }


}
