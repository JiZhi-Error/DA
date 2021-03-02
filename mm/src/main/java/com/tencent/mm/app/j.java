package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class j {

    public enum a {
        NONE(0),
        dkQ(1),
        dkR(2);
        
        public final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(200795);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(200795);
            return aVar;
        }

        static {
            AppMethodBeat.i(200796);
            AppMethodBeat.o(200796);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    public static class b {
        public final int dkT;
        public String dkU;
        public String dkV;
        public String dkW;
        public int dkX;
        public int dkY;
        public String dkZ;
        public int dla;
        public String dlb;
        public int dlc;
        public String fileId;
        public String fileKey;
        public String md5;
        public int mediaType;
        public long msgId;

        /* synthetic */ b(int i2, a aVar, byte b2) {
            this(i2, aVar);
        }

        private b(int i2, a aVar) {
            this.dkU = "";
            this.dkV = "";
            this.msgId = 0;
            this.mediaType = a.NONE.value;
            this.dkW = "";
            this.dkX = 0;
            this.dkY = 0;
            this.dkZ = "";
            this.dla = 0;
            this.fileId = "";
            this.fileKey = "";
            this.md5 = "";
            this.dlb = "";
            this.dlc = 0;
            this.dkT = i2;
            this.mediaType = aVar.value;
        }
    }

    public static b a(a aVar) {
        AppMethodBeat.i(200797);
        b bVar = new b(1, aVar, (byte) 0);
        AppMethodBeat.o(200797);
        return bVar;
    }

    public static b b(a aVar) {
        AppMethodBeat.i(200798);
        b bVar = new b(2, aVar, (byte) 0);
        AppMethodBeat.o(200798);
        return bVar;
    }

    public static b c(a aVar) {
        AppMethodBeat.i(200799);
        b bVar = new b(3, aVar, (byte) 0);
        AppMethodBeat.o(200799);
        return bVar;
    }

    private static String gc(String str) {
        AppMethodBeat.i(200801);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(200801);
        } else {
            try {
                str = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
                AppMethodBeat.o(200801);
            } catch (UnsupportedEncodingException e2) {
                AppMethodBeat.o(200801);
            }
        }
        return str;
    }

    public static void a(b bVar) {
        AppMethodBeat.i(200800);
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.dkT).append(',').append(Util.nullAsNil(bVar.dkU)).append(',').append(Util.nullAsNil(bVar.dkV)).append(',').append(bVar.msgId).append(',').append(bVar.mediaType).append(',').append(Util.nullAsNil(gc(bVar.dkW))).append(',').append(bVar.dkX).append(',').append(bVar.dkY).append(',').append(Util.nullAsNil(gc(bVar.dkZ))).append(',').append(bVar.dla).append(',').append(Util.nullAsNil(bVar.fileId)).append(',').append(Util.nullAsNil(bVar.fileKey)).append(',').append(Util.nullAsNil(bVar.md5)).append(',').append(Util.nullAsNil(gc(bVar.dlb))).append(',').append(bVar.dlc);
        String sb2 = sb.toString();
        Log.i("MicroMsg.ExportMediaReporter", "[+] Report content: %s", sb2);
        e.INSTANCE.a(20966, sb2, true, true);
        AppMethodBeat.o(200800);
    }
}
