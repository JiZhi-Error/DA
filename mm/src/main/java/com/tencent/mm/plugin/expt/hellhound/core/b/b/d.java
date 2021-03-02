package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class d {
    public static String cOi() {
        AppMethodBeat.i(169276);
        bfi cOj = cOj();
        if (cOj == null) {
            AppMethodBeat.o(169276);
            return null;
        }
        String str = cOj.LOU;
        AppMethodBeat.o(169276);
        return str;
    }

    public static bfi cOj() {
        AppMethodBeat.i(169277);
        byte[] bytes = b.getBytes("hell_mmkv_fbm__");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(169277);
            return null;
        }
        bfi bfi = new bfi();
        try {
            bfi.parseFrom(bytes);
            AppMethodBeat.o(169277);
            return bfi;
        } catch (IOException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", e2, "FragmentFrontBack, _read, crash: %s", e2.getMessage());
            AppMethodBeat.o(169277);
            return null;
        }
    }

    public static void a(bfi bfi) {
        AppMethodBeat.i(169278);
        if (bfi == null) {
            AppMethodBeat.o(169278);
            return;
        }
        try {
            b.o("hell_mmkv_fbm__", bfi.toByteArray());
            AppMethodBeat.o(169278);
        } catch (IOException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FragmentFrontBackMonitor", e2, "HellMsgQDao, _write, crash: %s", e2.getMessage());
            AppMethodBeat.o(169278);
        }
    }
}
