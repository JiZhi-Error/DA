package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class b {
    public static synchronized void a(duz duz) {
        synchronized (b.class) {
            AppMethodBeat.i(122128);
            try {
                com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mkv_k_hellsscld", duz.toByteArray());
                AppMethodBeat.o(122128);
            } catch (Exception e2) {
                Log.printErrStackTrace("HABBYGE-MALI.HellSessionCloudConfigDao", e2, "HellSessionCloudConfigDao writeBack", new Object[0]);
                AppMethodBeat.o(122128);
            }
        }
    }

    public static synchronized duz cQl() {
        duz duz;
        synchronized (b.class) {
            AppMethodBeat.i(122129);
            byte[] bytes = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mkv_k_hellsscld");
            if (bytes == null || bytes.length <= 0) {
                Log.e("HABBYGE-MALI.HellSessionCloudConfigDao", "HellSessionCloudConfigDao read(): NULL");
                AppMethodBeat.o(122129);
                duz = null;
            } else {
                duz = new duz();
                try {
                    duz.parseFrom(bytes);
                    AppMethodBeat.o(122129);
                } catch (IOException e2) {
                    Log.printErrStackTrace("HABBYGE-MALI.HellSessionCloudConfigDao", e2, "SessionConfigCloud read", new Object[0]);
                    AppMethodBeat.o(122129);
                    duz = null;
                }
            }
        }
        return duz;
    }
}
