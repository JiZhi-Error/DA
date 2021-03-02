package com.tencent.matrix.g;

import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class f {
    public static <T> T a(Class<?> cls, String str, Object obj) {
        return (T) new e(cls, str).get(obj);
    }

    public static <T> T b(Object obj, String str, T t) {
        if (obj == null) {
            return t;
        }
        try {
            Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(obj.getClass(), str);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (Exception e2) {
            c.e("Matrix.ReflectUtils", e2.toString() + "isHard=%s\n%s", Boolean.TRUE, d.g(e2));
            return t;
        }
    }

    private static Method a(Object obj, boolean z, String str, Class<?>... clsArr) {
        if (z) {
            try {
                Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(obj.getClass(), str, clsArr);
                method.setAccessible(true);
                return method;
            } catch (Exception e2) {
                c.e("Matrix.ReflectUtils", e2.toString() + "isHard=%s\n%s", Boolean.TRUE, d.g(e2));
            }
        } else {
            try {
                Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Exception e3) {
                c.e("Matrix.ReflectUtils", e3.toString() + "isHard=%s\n%s", Boolean.FALSE, d.g(e3));
            }
        }
        return null;
    }

    public static Method c(Object obj, String str, Class<?>... clsArr) {
        return a(obj, Build.VERSION.SDK_INT <= 29, str, clsArr);
    }
}
