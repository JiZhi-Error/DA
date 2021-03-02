package com.google.a;

/* access modifiers changed from: package-private */
public final class e {
    private static final Class<?> bNe = bY("libcore.io.Memory");
    private static final boolean bNf = (bY("org.robolectric.Robolectric") != null);

    static boolean yM() {
        return bNe != null && !bNf;
    }

    private static <T> Class<T> bY(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
