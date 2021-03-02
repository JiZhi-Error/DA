package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.concurrent.ConcurrentHashMap;

public interface h {
    b b(a aVar);

    void b(c cVar);

    public static class b {
        public ca dCM;
        public boolean iMb;

        public b(ca caVar, boolean z) {
            this.dCM = caVar;
            this.iMb = z;
        }
    }

    public static class a {
        public de heO;
        public boolean iLV = false;
        public boolean iLW = false;
        public boolean iLX = false;
        public long iLY = 0;
        public boolean iLZ = false;
        public Object iMa;
        public int what;

        public a(de deVar, boolean z, boolean z2, boolean z3) {
            this.heO = deVar;
            this.iLV = z;
            this.iLW = z2;
            this.iLX = z3;
        }

        public a(de deVar, boolean z, long j2) {
            this.heO = deVar;
            this.iLV = true;
            this.iLW = false;
            this.iLX = z;
            this.iLY = j2;
        }

        public a(de deVar, Object obj) {
            this.heO = deVar;
            this.iLZ = true;
            this.iMa = obj;
        }

        public final String toString() {
            AppMethodBeat.i(43002);
            String format = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", Integer.valueOf(hashCode()), Boolean.valueOf(this.iLV), Boolean.valueOf(this.iLW), Boolean.valueOf(this.iLX), Long.valueOf(this.iLY));
            AppMethodBeat.o(43002);
            return format;
        }
    }

    public static class c {
        public ca dTX;
        public de heO;
        public Object iMc;
        public Object iMd;
        public String iMe;
        public String iMf;

        public c(ca caVar) {
            this.dTX = caVar;
        }

        public c(de deVar, Object obj, Object obj2) {
            this.heO = deVar;
            this.iMc = obj;
            this.iMd = obj2;
        }
    }

    public static class d {
        private static ConcurrentHashMap<Object, h> iLS = new ConcurrentHashMap<>();

        static {
            AppMethodBeat.i(43006);
            AppMethodBeat.o(43006);
        }

        public static void a(Object obj, h hVar) {
            AppMethodBeat.i(43003);
            Log.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", obj, hVar);
            iLS.put(obj, hVar);
            AppMethodBeat.o(43003);
        }

        public static void b(Object obj, h hVar) {
            AppMethodBeat.i(43004);
            Log.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", obj, hVar);
            iLS.remove(obj);
            AppMethodBeat.o(43004);
        }

        public static h ck(Object obj) {
            AppMethodBeat.i(43005);
            h hVar = iLS.get(obj);
            AppMethodBeat.o(43005);
            return hVar;
        }
    }
}
