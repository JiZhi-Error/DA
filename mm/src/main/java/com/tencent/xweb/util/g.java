package com.tencent.xweb.util;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import org.xwalk.core.Log;

public final class g {
    public static Object oj(String str, String str2) {
        Object obj = null;
        AppMethodBeat.i(157009);
        try {
            obj = Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
            AppMethodBeat.o(157009);
        } catch (Throwable th) {
            AppMethodBeat.o(157009);
        }
        return obj;
    }

    public static Object b(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Object obj = null;
        AppMethodBeat.i(157010);
        try {
            Method method = Class.forName(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            obj = method.invoke(null, objArr);
            AppMethodBeat.o(157010);
        } catch (Throwable th) {
            AppMethodBeat.o(157010);
        }
        return obj;
    }

    public static Object bsF(String str) {
        Object obj = null;
        AppMethodBeat.i(157011);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(157011);
        } else {
            try {
                obj = Class.forName(str).newInstance();
                AppMethodBeat.o(157011);
            } catch (Throwable th) {
                AppMethodBeat.o(157011);
            }
        }
        return obj;
    }

    public static Object f(Object obj, String str) {
        AppMethodBeat.i(157012);
        Object c2 = c(obj, str, null, new Object[0]);
        AppMethodBeat.o(157012);
        return c2;
    }

    public static Object c(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        AppMethodBeat.i(157013);
        if (obj == null) {
            AppMethodBeat.o(157013);
            return null;
        }
        try {
            Class<?> cls = obj.getClass();
            if (Build.VERSION.SDK_INT > 10) {
                declaredMethod = cls.getMethod(str, clsArr);
            } else {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            }
            declaredMethod.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            Object invoke = declaredMethod.invoke(obj, objArr);
            AppMethodBeat.o(157013);
            return invoke;
        } catch (Throwable th) {
            if (th.getCause() != null && th.getCause().toString().contains("AuthenticationFail")) {
                String str2 = new String("AuthenticationFail");
                AppMethodBeat.o(157013);
                return str2;
            } else if (str == null || (!str.equalsIgnoreCase("canLoadX5Core") && !str.equalsIgnoreCase("initTesRuntimeEnvironment"))) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                Log.e("ReflectionUtils", "invokeInstance -- exceptions:" + stringWriter.toString());
                AppMethodBeat.o(157013);
                return null;
            } else {
                AppMethodBeat.o(157013);
                return null;
            }
        }
    }
}
