package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.dvo;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class h {
    public static void a(dvo dvo) {
        AppMethodBeat.i(122167);
        try {
            b.o("mkv_k_hellsubascld", dvo.toByteArray());
            AppMethodBeat.o(122167);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", e2, "HellSessionUBACloudConfigDao writeBack", new Object[0]);
            AppMethodBeat.o(122167);
        }
    }

    public static dvo cQz() {
        AppMethodBeat.i(122168);
        byte[] bytes = b.getBytes("mkv_k_hellsubascld");
        if (bytes == null || bytes.length <= 0) {
            Log.e("HABBYGE-MALI.HellSessionUBACloudConfigDao", "HellSessionUBACloudConfigDao read(): NULL");
            AppMethodBeat.o(122168);
            return null;
        }
        dvo dvo = new dvo();
        try {
            dvo.parseFrom(bytes);
            AppMethodBeat.o(122168);
            return dvo;
        } catch (IOException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionUBACloudConfigDao", e2, "SessionUBACloudConfig read", new Object[0]);
            AppMethodBeat.o(122168);
            return null;
        }
    }
}
