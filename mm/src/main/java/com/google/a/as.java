package com.google.a;

final class as {
    private static final ap bYh = Hd();
    private static final ap bYi = new ar();

    static ap Hb() {
        return bYh;
    }

    static ap Hc() {
        return bYi;
    }

    private static ap Hd() {
        try {
            return (ap) Class.forName("com.google.a.aq").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            return null;
        }
    }
}
