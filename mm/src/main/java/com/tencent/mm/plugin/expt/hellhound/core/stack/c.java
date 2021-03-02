package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static bo cNK() {
        AppMethodBeat.i(121879);
        bo cNL = cNL();
        if (cNL == null) {
            cNL = new bo();
            a(cNL);
        }
        AppMethodBeat.o(121879);
        return cNL;
    }

    public static void a(bo boVar) {
        AppMethodBeat.i(121880);
        if (boVar == null) {
            AppMethodBeat.o(121880);
            return;
        }
        byte[] bArr = null;
        try {
            bArr = boVar.toByteArray();
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.ActivityStackDao", e2, "ActivityStackDao write", new Object[0]);
        }
        b.o("hell_astackd_mmkv_key", bArr);
        AppMethodBeat.o(121880);
    }

    private static bo cNL() {
        AppMethodBeat.i(121881);
        byte[] bytes = b.getBytes("hell_astackd_mmkv_key");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(121881);
            return null;
        }
        bo boVar = new bo();
        try {
            boVar.parseFrom(bytes);
            AppMethodBeat.o(121881);
            return boVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.ActivityStackDao", e2, "ActivityStackDao read", new Object[0]);
            AppMethodBeat.o(121881);
            return null;
        }
    }
}
