package com.google.a;

final class bh {
    private static final be bYF = Hk();
    private static final be bYG = new bg();

    static be Hi() {
        return bYF;
    }

    static be Hj() {
        return bYG;
    }

    private static be Hk() {
        try {
            return (be) Class.forName("com.google.a.bf").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            return null;
        }
    }
}
