package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.a;
import java.io.IOException;

public final class k extends a<bvi, d> {
    private static k yUJ;

    /* Return type fixed from 'com.tencent.mm.protocal.protobuf.dpc' to match base method */
    @Override // com.tencent.mm.wallet_core.c.a
    public final /* synthetic */ bvi efb() {
        AppMethodBeat.i(65168);
        bvi efa = efa();
        AppMethodBeat.o(65168);
        return efa;
    }

    public static k eeZ() {
        AppMethodBeat.i(65165);
        if (yUJ == null) {
            yUJ = new k();
        }
        k kVar = yUJ;
        AppMethodBeat.o(65165);
        return kVar;
    }

    @Override // com.tencent.mm.wallet_core.c.a
    public final void b(c.a<bvi> aVar) {
        AppMethodBeat.i(182454);
        Log.i("MicroMsg.GetShowSourceAsyncLoader", "errType: %s, errCode: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType));
        if (aVar.errType == 0 && aVar.errCode == 0 && ((bvi) aVar.iLC).dDN == 0) {
            try {
                g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_SNAPSHOT_STRING_SYNC, new String(((bvi) aVar.iLC).toByteArray(), org.apache.commons.a.a.ISO_8859_1));
                AppMethodBeat.o(182454);
                return;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(182454);
    }

    private static bvi efa() {
        AppMethodBeat.i(65167);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_SNAPSHOT_STRING_SYNC, "");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(65167);
            return null;
        }
        try {
            bvi bvi = (bvi) new bvi().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
            AppMethodBeat.o(65167);
            return bvi;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", e2, "", new Object[0]);
            AppMethodBeat.o(65167);
            return null;
        }
    }
}
