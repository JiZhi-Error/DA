package com.google.a;

/* access modifiers changed from: package-private */
public final class q {
    static final Class<?> bUf = FZ();

    private static Class<?> FZ() {
        try {
            return Class.forName("com.google.a.p");
        } catch (ClassNotFoundException e2) {
            return null;
        }
    }

    public static r Ga() {
        if (bUf != null) {
            try {
                return (r) bUf.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e2) {
            }
        }
        return r.bUj;
    }
}
