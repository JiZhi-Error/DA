package android.support.v4.d;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class b {
    private static Method Of;
    private static Method Og;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Og = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            try {
                Class<?> cls = Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    Of = cls.getMethod("getScript", String.class);
                    Og = cls.getMethod("addLikelySubtags", String.class);
                }
            } catch (Exception e3) {
                Of = null;
                Og = null;
            }
        }
    }

    public static String b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) Og.invoke(null, locale)).getScript();
            } catch (IllegalAccessException | InvocationTargetException e2) {
                return locale.getScript();
            }
        } else {
            String c2 = c(locale);
            if (c2 != null) {
                return getScript(c2);
            }
            return null;
        }
    }

    private static String getScript(String str) {
        try {
            if (Of != null) {
                return (String) Of.invoke(null, str);
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
        }
        return null;
    }

    private static String c(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (Og != null) {
                return (String) Og.invoke(null, locale2);
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
        }
        return locale2;
    }
}
