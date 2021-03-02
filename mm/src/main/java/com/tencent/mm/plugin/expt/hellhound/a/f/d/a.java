package com.tencent.mm.plugin.expt.hellhound.a.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    static synchronized void a(cbl cbl) {
        synchronized (a.class) {
            AppMethodBeat.i(122169);
            if (cbl == null) {
                AppMethodBeat.o(122169);
            } else {
                b(cbl);
                AppMethodBeat.o(122169);
            }
        }
    }

    public static synchronized cbl cQH() {
        cbl cQI;
        synchronized (a.class) {
            AppMethodBeat.i(122170);
            cQI = cQI();
            if (cQI == null) {
                cQI = new cbl();
                b(cQI);
            }
            AppMethodBeat.o(122170);
        }
        return cQI;
    }

    private static void b(cbl cbl) {
        AppMethodBeat.i(122171);
        try {
            b.o("mmkv_key_hell_PFLOW", cbl.toByteArray());
            AppMethodBeat.o(122171);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellPageFlowDao", e2, "HellPageFlowDao.writeBack crash: %s", e2.getMessage());
            AppMethodBeat.o(122171);
        }
    }

    private static cbl cQI() {
        AppMethodBeat.i(122172);
        byte[] bytes = b.getBytes("mmkv_key_hell_PFLOW");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(122172);
            return null;
        }
        cbl cbl = new cbl();
        try {
            cbl.parseFrom(bytes);
            AppMethodBeat.o(122172);
            return cbl;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellPageFlowDao", e2, "HellPageFlowDao.read crash: %s", e2.getMessage());
            AppMethodBeat.o(122172);
            return null;
        }
    }

    public static synchronized void reset() {
        synchronized (a.class) {
            AppMethodBeat.i(122173);
            long currentTimeMillis = System.currentTimeMillis();
            b.o("mmkv_key_hell_PFLOW", new byte[0]);
            Log.i("HABBYGE-MALI.HellPageFlowDao", "HellPageFlowDao-reset-time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(122173);
        }
    }
}
