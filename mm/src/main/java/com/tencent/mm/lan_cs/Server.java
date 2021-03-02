package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Server {
    public static a hvv;

    public interface a {
        void aBy();

        void onConnect(String str, int i2);

        void onRecv(String str, int i2, byte[] bArr);

        void qm(int i2);
    }

    public static class Java2C {
        public static native int send(String str, int i2, byte[] bArr);

        private static native Object[] start();

        public static native void stop();

        public static /* synthetic */ Object[] access$000() {
            AppMethodBeat.i(133663);
            Object[] start = start();
            AppMethodBeat.o(133663);
            return start;
        }
    }

    public static class C2Java {
        public static void onSend(String str, int i2, int i3) {
            AppMethodBeat.i(133659);
            if (Server.hvv != null) {
                Server.hvv.qm(i3);
            }
            AppMethodBeat.o(133659);
        }

        public static void onRecv(String str, int i2, byte[] bArr) {
            AppMethodBeat.i(133660);
            if (Server.hvv != null) {
                Server.hvv.onRecv(str, i2, bArr);
            }
            AppMethodBeat.o(133660);
        }

        public static void onConnect(String str, int i2) {
            AppMethodBeat.i(133661);
            if (Server.hvv != null) {
                Server.hvv.onConnect(str, i2);
            }
            AppMethodBeat.o(133661);
        }

        public static void onDisconnect(String str, int i2) {
            AppMethodBeat.i(133662);
            if (Server.hvv != null) {
                Server.hvv.aBy();
            }
            AppMethodBeat.o(133662);
        }
    }
}
