package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Client {
    public static a hvu;

    public static class Java2C {
        public static native void disconnect();

        public static native int send(String str, int i2, byte[] bArr);
    }

    public interface a {
        void aBy();

        void onRecv(String str, int i2, byte[] bArr);
    }

    public static class C2Java {
        public static void onRecv(String str, int i2, byte[] bArr) {
            AppMethodBeat.i(133657);
            if (Client.hvu != null) {
                Client.hvu.onRecv(str, i2, bArr);
            }
            AppMethodBeat.o(133657);
        }

        public static void onDisconnect(String str, int i2) {
            AppMethodBeat.i(133658);
            if (Client.hvu != null) {
                Client.hvu.aBy();
            }
            AppMethodBeat.o(133658);
        }
    }
}
