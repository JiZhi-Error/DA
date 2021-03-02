package com.tencent.mapsdk.rastercore;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogHelper {
    private static Boolean DEBUG = Boolean.FALSE;
    private static final String DEFAULT_TAG = "tencentSdk";

    public static void setDebugMode(boolean z) {
        AppMethodBeat.i(217176);
        DEBUG = Boolean.valueOf(z);
        AppMethodBeat.o(217176);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(217177);
        log(str, str2, 'e');
        AppMethodBeat.o(217177);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(217178);
        log(str, str2, 'w');
        AppMethodBeat.o(217178);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(217179);
        log(str, str2, 'i');
        AppMethodBeat.o(217179);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(217180);
        log(str, str2, 'd');
        AppMethodBeat.o(217180);
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(217181);
        log(str, str2, 'v');
        AppMethodBeat.o(217181);
    }

    public static void e(String str) {
        AppMethodBeat.i(217182);
        log(null, str, 'e');
        AppMethodBeat.o(217182);
    }

    public static void w(String str) {
        AppMethodBeat.i(217183);
        log(null, str, 'w');
        AppMethodBeat.o(217183);
    }

    public static void i(String str) {
        AppMethodBeat.i(217184);
        log(null, str, 'i');
        AppMethodBeat.o(217184);
    }

    public static void d(String str) {
        AppMethodBeat.i(217185);
        log(null, str, 'd');
        AppMethodBeat.o(217185);
    }

    public static void v(String str) {
        AppMethodBeat.i(217186);
        log(null, str, 'v');
        AppMethodBeat.o(217186);
    }

    public static void log(String str) {
        AppMethodBeat.i(217187);
        log(null, str, 'v');
        AppMethodBeat.o(217187);
    }

    private static void log(String str, String str2, char c2) {
        AppMethodBeat.i(217188);
        if (!DEBUG.booleanValue()) {
            AppMethodBeat.o(217188);
            return;
        }
        TextUtils.isEmpty(str);
        AppMethodBeat.o(217188);
    }
}
