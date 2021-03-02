package com.google.a;

final class aa implements av {
    private static final aa bVW = new aa();

    private aa() {
    }

    public static aa Gl() {
        return bVW;
    }

    @Override // com.google.a.av
    public final boolean C(Class<?> cls) {
        return ab.class.isAssignableFrom(cls);
    }

    @Override // com.google.a.av
    public final au D(Class<?> cls) {
        if (!ab.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (au) ab.F(cls.asSubclass(ab.class)).Gq();
        } catch (Exception e2) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e2);
        }
    }
}
