package com.tencent.matrix.iocanary.b;

import com.tencent.matrix.g.c;
import com.tencent.matrix.report.d;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class a {
    private static volatile Object cUA;
    private final d.a cUB;
    public volatile boolean cUz;

    public a(d.a aVar) {
        this.cUB = aVar;
    }

    public final boolean Sx() {
        try {
            Class<?> cls = Class.forName("dalvik.system.CloseGuard");
            Class<?> cls2 = Class.forName("dalvik.system.CloseGuard$Reporter");
            Method declaredMethod = cls.getDeclaredMethod("getReporter", new Class[0]);
            Method declaredMethod2 = cls.getDeclaredMethod("setReporter", cls2);
            Method declaredMethod3 = cls.getDeclaredMethod("setEnabled", Boolean.TYPE);
            cUA = declaredMethod.invoke(null, new Object[0]);
            declaredMethod3.invoke(null, Boolean.TRUE);
            c.setEnabled(true);
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader == null) {
                return false;
            }
            declaredMethod2.invoke(null, Proxy.newProxyInstance(classLoader, new Class[]{cls2}, new b(this.cUB, cUA)));
            return true;
        } catch (Throwable th) {
            c.e("Matrix.CloseGuardHooker", "tryHook exp=%s", th);
            return false;
        }
    }

    public static boolean Sy() {
        try {
            Class<?> cls = Class.forName("dalvik.system.CloseGuard");
            Method declaredMethod = cls.getDeclaredMethod("setReporter", Class.forName("dalvik.system.CloseGuard$Reporter"));
            Method declaredMethod2 = cls.getDeclaredMethod("setEnabled", Boolean.TYPE);
            declaredMethod.invoke(null, cUA);
            declaredMethod2.invoke(null, Boolean.FALSE);
            c.setEnabled(false);
            return true;
        } catch (Throwable th) {
            c.e("Matrix.CloseGuardHooker", "tryHook exp=%s", th);
            return false;
        }
    }
}
