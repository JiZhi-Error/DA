package com.tencent.smtt.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Class f2261a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f2262b;

    static {
        AppMethodBeat.i(53937);
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            f2261a = cls;
            f2262b = cls.getDeclaredMethod("get", String.class, String.class);
            AppMethodBeat.o(53937);
        } catch (Throwable th) {
            AppMethodBeat.o(53937);
        }
    }

    public static String a(String str, String str2) {
        AppMethodBeat.i(53935);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(53935);
            return str2;
        }
        String b2 = b(str, str2);
        AppMethodBeat.o(53935);
        return b2;
    }

    private static String b(String str, String str2) {
        String str3;
        AppMethodBeat.i(53936);
        if (f2261a == null || f2262b == null) {
            AppMethodBeat.o(53936);
            return str2;
        }
        try {
            str3 = (String) f2262b.invoke(f2261a, str, str2);
        } catch (Throwable th) {
            str3 = str2;
        }
        AppMethodBeat.o(53936);
        return str3;
    }
}
