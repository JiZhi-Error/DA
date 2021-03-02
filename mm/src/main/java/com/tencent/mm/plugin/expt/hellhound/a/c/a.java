package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bfq;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    a() {
    }

    public static void mi(boolean z) {
        AppMethodBeat.i(122026);
        bfq cPw = cPw();
        if (cPw == null) {
            cPw = new bfq();
        }
        cPw.LPl = z;
        Log.d("HABBYGE-MALI.FrontBackDao", "logout8EventFromAdd: %b", Boolean.valueOf(cPw.LPl));
        a(cPw);
        AppMethodBeat.o(122026);
    }

    public static void Hi(int i2) {
        AppMethodBeat.i(122027);
        bfq cPw = cPw();
        if (cPw == null) {
            cPw = new bfq();
        }
        cPw.LPh = i2;
        a(cPw);
        AppMethodBeat.o(122027);
    }

    static void a(bfq bfq) {
        AppMethodBeat.i(122028);
        try {
            b.o("hell_fntbck_pter_mmkv_key", bfq.toByteArray());
            AppMethodBeat.o(122028);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FrontBackDao", e2, "writeBackFrontBack", new Object[0]);
            AppMethodBeat.o(122028);
        }
    }

    public static bfq cPw() {
        AppMethodBeat.i(122029);
        byte[] bytes = b.getBytes("hell_fntbck_pter_mmkv_key");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(122029);
            return null;
        }
        bfq bfq = new bfq();
        try {
            bfq.parseFrom(bytes);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FrontBackDao", e2, "_doReadFrontBack parse", new Object[0]);
            bfq = null;
        }
        AppMethodBeat.o(122029);
        return bfq;
    }
}
