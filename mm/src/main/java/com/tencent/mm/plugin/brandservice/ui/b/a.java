package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.z;

public final class a {
    public static int pMl = g.clK();
    private static long pMm = 43200000;
    private static long pMn = 0;
    private static boolean pMo = false;

    static {
        AppMethodBeat.i(6235);
        g gVar = g.pnw;
        AppMethodBeat.o(6235);
    }

    public static void BR(long j2) {
        pMm = j2;
    }

    public static long crd() {
        if (pMm <= 0) {
            pMm = 43200000;
        }
        return pMm;
    }

    public static void BS(long j2) {
        pMn = j2;
    }

    public static boolean a(z zVar, v vVar) {
        as Kn;
        AppMethodBeat.i(6233);
        if (zVar == null) {
            AppMethodBeat.o(6233);
            return false;
        }
        zVar.NQk = f.ahR(zVar.field_talker);
        if (vVar != null && (vVar.type == 5 || vVar.type == 7 || vVar.type == 10 || vVar.type == 8)) {
            AppMethodBeat.o(6233);
            return true;
        } else if (zVar.iE(1)) {
            Log.d("MicroMsg.BizTimeLineConfigUtil", "biz flag %d return true, bizClientMsgId:%s", Integer.valueOf(zVar.field_bitFlag), zVar.field_bizClientMsgId);
            AppMethodBeat.o(6233);
            return true;
        } else if (DV(2) && zVar.NQk) {
            AppMethodBeat.o(6233);
            return true;
        } else if (!DV(1) || (Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(zVar.field_talker)) == null || !Kn.arE()) {
            AppMethodBeat.o(6233);
            return false;
        } else {
            AppMethodBeat.o(6233);
            return true;
        }
    }

    public static void cre() {
        AppMethodBeat.i(6234);
        pMo = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_biz_timeline_digest_show, 0) == 1;
        if (MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizTimeLineShowDigest", 0) == 1) {
            Log.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest force show");
            pMo = true;
        }
        Log.i("MicroMsg.BizTimeLineConfigUtil", "alvinluo initBizTimeLineShowDigest: %b", Boolean.valueOf(pMo));
        AppMethodBeat.o(6234);
    }

    public static boolean crf() {
        return pMo;
    }

    public static boolean crg() {
        return true;
    }

    public static boolean DV(int i2) {
        return (pMn & ((long) i2)) != 0;
    }
}
