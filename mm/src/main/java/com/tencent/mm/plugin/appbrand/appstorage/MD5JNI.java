package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MD5JNI {
    public static native int getMD5String(String str, String[] strArr);

    public static String getMD5Wrap(String str) {
        AppMethodBeat.i(102766);
        String[] strArr = new String[1];
        getMD5String(str, strArr);
        String str2 = strArr[0];
        AppMethodBeat.o(102766);
        return str2;
    }
}
