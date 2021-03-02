package com.tencent.matrix.iocanary.b;

public final class c {
    private static final c cUD = new c();
    private static volatile boolean cUE = true;
    private static volatile b cUF = new a((byte) 0);

    public interface b {
    }

    public static void setEnabled(boolean z) {
        cUE = z;
    }

    private c() {
    }

    static final class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
