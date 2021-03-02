package android.support.v4.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class c {

    static class a {
        private static Method Fd;
        private static boolean Fe;
        private static Method Ff;
        private static boolean Fg;

        public static IBinder b(Bundle bundle, String str) {
            if (!Fe) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", String.class);
                    Fd = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                }
                Fe = true;
            }
            if (Fd != null) {
                try {
                    return (IBinder) Fd.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                    Fd = null;
                }
            }
            return null;
        }

        public static void a(Bundle bundle, String str, IBinder iBinder) {
            if (!Fg) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    Ff = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                }
                Fg = true;
            }
            if (Ff != null) {
                try {
                    Ff.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                    Ff = null;
                }
            }
        }
    }

    public static IBinder b(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return a.b(bundle, str);
    }

    public static void a(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            a.a(bundle, str, iBinder);
        }
    }
}
