package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c.g;
import com.tencent.smtt.sdk.TbsListener;

public class a {
    private static volatile g loB;
    private static volatile g loC;

    public static g wp(int i2) {
        AppMethodBeat.i(121389);
        if (i2 == 1) {
            g bCg = bCg();
            AppMethodBeat.o(121389);
            return bCg;
        }
        g bCf = bCf();
        AppMethodBeat.o(121389);
        return bCf;
    }

    private static g bCf() {
        AppMethodBeat.i(121390);
        if (loB == null) {
            synchronized (a.class) {
                try {
                    if (loB == null) {
                        g gVar = new g();
                        gVar.a(new b(302));
                        gVar.a(new c(303));
                        gVar.a(new d(TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_NULL));
                        gVar.a(new f());
                        gVar.a(new g());
                        loB = gVar;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121390);
                    throw th;
                }
            }
        }
        g gVar2 = loB;
        AppMethodBeat.o(121390);
        return gVar2;
    }

    private static g bCg() {
        AppMethodBeat.i(121391);
        if (loC == null) {
            synchronized (a.class) {
                try {
                    if (loC == null) {
                        g gVar = new g();
                        gVar.a(new b(262));
                        gVar.a(new c(263));
                        gVar.a(new d(268));
                        gVar.a(new f());
                        gVar.a(new g());
                        gVar.a(new e((byte) 0));
                        loC = gVar;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121391);
                    throw th;
                }
            }
        }
        g gVar2 = loC;
        AppMethodBeat.o(121391);
        return gVar2;
    }
}
