package com.quyenlx.visibility_utils.utils;

import android.util.Log;

/**
 * Created by QuyenLx on 7/17/2017.
 */

public class Logger {
    public static int err(final String TAG, final String message) {
        return Log.e(TAG, attachThreadId(message));
    }

    public static int err(final String TAG, final String message, Throwable throwable) {
        return Log.e(TAG, attachThreadId(message), throwable);
    }

    public static int w(final String TAG, final String message) {
        return Log.w(TAG, attachThreadId(message));
    }

    public static int inf(final String TAG, final String message) {
        return Log.i(TAG, attachThreadId(message));
    }

    public static int d(final String TAG, final String message) {
        return Log.d(TAG, attachThreadId(message));
    }

    public static int v(final String TAG, final String message) {
        return Log.v(TAG, attachThreadId(message));
    }

    private static String attachThreadId(String str){
        return "" + Thread.currentThread().getId() + " " + str;
    }
}
