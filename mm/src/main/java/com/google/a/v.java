package com.google.a;

final class v {
    private static final s<?> bUm = new u();
    private static final s<?> bUn = Gf();

    private static s<?> Gf() {
        try {
            return (s) Class.forName("com.google.a.t").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            return null;
        }
    }

    static s<?> Gg() {
        return bUm;
    }

    static s<?> Gh() {
        if (bUn != null) {
            return bUn;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
