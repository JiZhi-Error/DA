package com.tencent.smtt.utils;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class k {
    public static Object a(String str, String str2) {
        Object obj = null;
        AppMethodBeat.i(54031);
        try {
            obj = Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
            AppMethodBeat.o(54031);
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            AppMethodBeat.o(54031);
        }
        return obj;
    }

    public static Object a(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        Object obj = null;
        AppMethodBeat.i(54032);
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            obj = method.invoke(null, objArr);
            AppMethodBeat.o(54032);
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            AppMethodBeat.o(54032);
        }
        return obj;
    }

    public static Object a(Object obj, String str) {
        AppMethodBeat.i(54033);
        Object a2 = a(obj, str, (Class<?>[]) null, new Object[0]);
        AppMethodBeat.o(54033);
        return a2;
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        AppMethodBeat.i(54034);
        if (obj == null) {
            AppMethodBeat.o(54034);
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
            AppMethodBeat.o(54034);
            return invoke;
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            if (th.getCause() != null && th.getCause().toString().contains("AuthenticationFail")) {
                String str2 = new String("AuthenticationFail");
                AppMethodBeat.o(54034);
                return str2;
            } else if (str == null || (!str.equalsIgnoreCase("canLoadX5Core") && !str.equalsIgnoreCase("initTesRuntimeEnvironment"))) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                TbsLog.i("ReflectionUtils", "invokeInstance -- exceptions:" + stringWriter.toString());
                AppMethodBeat.o(54034);
                return null;
            } else {
                AppMethodBeat.o(54034);
                return null;
            }
        }
    }

    public static Method a(Object obj, String str, Class<?>... clsArr) {
        AppMethodBeat.i(54035);
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            if (cls == null) {
                AppMethodBeat.o(54035);
                return null;
            }
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                AppMethodBeat.o(54035);
                return declaredMethod;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(54035);
        return null;
    }
}
