package com.google.a;

import com.google.a.x;
import java.lang.reflect.Field;

final class bt {
    private static final Class<?> bYW = Hs();
    private static final cb<?, ?> bYX = bG(false);
    private static final cb<?, ?> bYY = bG(true);
    private static final cb<?, ?> bYZ = new ce();

    public static void I(Class<?> cls) {
        if (!ab.class.isAssignableFrom(cls) && bYW != null && !bYW.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static cb<?, ?> Hp() {
        return bYX;
    }

    public static cb<?, ?> Hq() {
        return bYY;
    }

    public static cb<?, ?> Hr() {
        return bYZ;
    }

    private static cb<?, ?> bG(boolean z) {
        try {
            Class<?> Ht = Ht();
            if (Ht == null) {
                return null;
            }
            return (cb) Ht.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> Hs() {
        try {
            return Class.forName("com.google.a.ac");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> Ht() {
        try {
            return Class.forName("com.google.a.cf");
        } catch (Throwable th) {
            return null;
        }
    }

    static Object d(Class<?> cls, String str) {
        try {
            Field[] declaredFields = Class.forName(cls.getName() + "$" + g(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return ch.b(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private static String g(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ('a' <= charAt && charAt <= 'z') {
                if (z) {
                    sb.append((char) (charAt - ' '));
                } else {
                    sb.append(charAt);
                }
                z = false;
            } else if ('A' > charAt || charAt > 'Z') {
                if ('0' <= charAt && charAt <= '9') {
                    sb.append(charAt);
                }
                z = true;
            } else {
                if (i2 != 0 || z) {
                    sb.append(charAt);
                } else {
                    sb.append((char) (charAt + ' '));
                }
                z = false;
            }
        }
        return sb.toString();
    }

    static boolean o(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void a(ap apVar, T t, T t2, long j2) {
        ch.a(t, j2, apVar.m(ch.k(t, j2), ch.k(t2, j2)));
    }

    static <T, FT extends x.a<FT>> void a(s<FT> sVar, T t, T t2) {
        x<FT> an = sVar.an(t2);
        if (!an.bUB.isEmpty()) {
            sVar.ao(t).a(an);
        }
    }

    static <T, UT, UB> void a(cb<UT, UB> cbVar, T t, T t2) {
        cbVar.p(t, cbVar.q(cbVar.aw(t), cbVar.aw(t2)));
    }
}
