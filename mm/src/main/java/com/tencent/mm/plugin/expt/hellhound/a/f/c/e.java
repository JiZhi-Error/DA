package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.sdk.platformtools.Log;

public final class e {
    public static void a(dvh dvh) {
        AppMethodBeat.i(122152);
        try {
            b.o("mkv_k_hellsionpgcldc", dvh.toByteArray());
            AppMethodBeat.o(122152);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageCloudConfigDao", e2, "HellSessionPageCloudConfigDao writeBack", new Object[0]);
            AppMethodBeat.o(122152);
        }
    }

    public static dvh cQt() {
        AppMethodBeat.i(122153);
        byte[] bytes = b.getBytes("mkv_k_hellsionpgcldc");
        if (bytes == null || bytes.length <= 0) {
            Log.e("HABBYGE-MALI.HellSessionPageCloudConfigDao", "HellSessionPageCloudConfigDao read(): NULL");
            AppMethodBeat.o(122153);
            return null;
        }
        dvh dvh = new dvh();
        try {
            dvh.parseFrom(bytes);
            AppMethodBeat.o(122153);
            return dvh;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionPageCloudConfigDao", e2, "HellSessionPageCloudConfigDao read", new Object[0]);
            AppMethodBeat.o(122153);
            return null;
        }
    }
}
