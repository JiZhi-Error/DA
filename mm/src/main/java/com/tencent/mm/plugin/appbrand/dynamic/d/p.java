package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c.d;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;

public class p {
    private static volatile d lnI;
    private static volatile d lnJ;

    public static d wo(int i2) {
        AppMethodBeat.i(121345);
        if (i2 == 1) {
            d bCb = bCb();
            AppMethodBeat.o(121345);
            return bCb;
        }
        d bCa = bCa();
        AppMethodBeat.o(121345);
        return bCa;
    }

    private static d bCa() {
        AppMethodBeat.i(121346);
        if (lnI == null) {
            synchronized (p.class) {
                try {
                    if (lnI == null) {
                        d dVar = new d();
                        dVar.a(new l(312));
                        dVar.a(new d(TbsListener.ErrorCode.THROWABLE_QBSDK_INIT));
                        dVar.a(new e(TbsListener.ErrorCode.THROWABLE_QBSDK_INIT));
                        dVar.a(new b(305));
                        dVar.a(new c(TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE));
                        dVar.a(new k(309));
                        dVar.a(new j(TPNativePlayerInitConfig.INT_PIXEL_FORMAT));
                        dVar.a(new f(TPNativePlayerInitConfig.INT_WIDTH));
                        dVar.a(new o());
                        lnI = dVar;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121346);
                    throw th;
                }
            }
        }
        d dVar2 = lnI;
        AppMethodBeat.o(121346);
        return dVar2;
    }

    private static d bCb() {
        AppMethodBeat.i(121347);
        if (lnJ == null) {
            synchronized (p.class) {
                try {
                    if (lnJ == null) {
                        d dVar = new d();
                        dVar.a(new l(289));
                        dVar.a(new d(266));
                        dVar.a(new e(266));
                        dVar.a(new b(265));
                        dVar.a(new c(267));
                        dVar.a(new k(281));
                        dVar.a(new j(282));
                        dVar.a(new f(287));
                        dVar.a(new h());
                        dVar.a(new i());
                        dVar.a(new n());
                        dVar.a(new m());
                        dVar.a(new o());
                        dVar.a(new h());
                        dVar.a(new g());
                        dVar.a(new a());
                        lnJ = dVar;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121347);
                    throw th;
                }
            }
        }
        d dVar2 = lnJ;
        AppMethodBeat.o(121347);
        return dVar2;
    }
}
