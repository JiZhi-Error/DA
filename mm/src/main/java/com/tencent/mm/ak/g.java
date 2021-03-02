package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public interface g extends h {

    public static class b {
        public rx iLT;
        public String iLU;
    }

    int atA();

    int atz();

    public static class a {
        private static ConcurrentHashMap<Object, g> iLS = new ConcurrentHashMap<>();

        static {
            AppMethodBeat.i(43001);
            AppMethodBeat.o(43001);
        }

        public static void a(g gVar) {
            AppMethodBeat.i(42998);
            Log.i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", Integer.valueOf(gVar.atz()), Integer.valueOf(gVar.atA()));
            iLS.put(Integer.valueOf(gVar.atA()), gVar);
            h.d.a(Integer.valueOf(gVar.atz()), gVar);
            AppMethodBeat.o(42998);
        }

        public static void b(g gVar) {
            AppMethodBeat.i(42999);
            Log.i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", Integer.valueOf(gVar.atz()), Integer.valueOf(gVar.atA()));
            iLS.remove(Integer.valueOf(gVar.atA()));
            h.d.b(Integer.valueOf(gVar.atz()), gVar);
            AppMethodBeat.o(42999);
        }

        public static g cj(Object obj) {
            AppMethodBeat.i(43000);
            g gVar = iLS.get(obj);
            AppMethodBeat.o(43000);
            return gVar;
        }
    }
}
