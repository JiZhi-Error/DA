package com.tencent.mm.lan_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SmartServer {

    public static class ServerFileInfo {
        public int betweenRequestTimeoutMs = -1;
        public String cgi = null;
        public String filePath = null;
        public int fileType = 0;
        public int idleTimeoutMs = -1;
        public int totalSendTimeoutMs = -1;
    }

    public static class Java2C {
        public static native void addFileInfo(ServerFileInfo serverFileInfo);

        public static native int removeFileInfo(String str);

        private static native Object[] startSmartServer();

        public static native void stopSmartServer();

        static /* synthetic */ Object[] access$000() {
            AppMethodBeat.i(133664);
            Object[] startSmartServer = startSmartServer();
            AppMethodBeat.o(133664);
            return startSmartServer;
        }
    }

    public static class C2Java {
        public static void onSendProgressChange(String str, long j2, long j3) {
        }

        public static void onSendSucc(String str) {
        }

        public static void onSendFail(String str, int i2) {
        }
    }
}
