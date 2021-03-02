package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.a;
import java.io.IOException;

public final class q extends a<dbs, CgiLqtPlanIndex> {
    /* Return type fixed from 'com.tencent.mm.protocal.protobuf.dpc' to match base method */
    @Override // com.tencent.mm.wallet_core.c.a
    public final /* synthetic */ dbs efb() {
        AppMethodBeat.i(68455);
        dbs fMR = fMR();
        AppMethodBeat.o(68455);
        return fMR;
    }

    @Override // com.tencent.mm.wallet_core.c.a
    public final void b(c.a<dbs> aVar) {
        AppMethodBeat.i(182497);
        Log.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType));
        if (aVar.errType == 0 && aVar.errCode == 0 && ((dbs) aVar.iLC).pTZ == 0) {
            try {
                g.aAh().azQ().set(ar.a.USERINFO_LQT_PLAN_INDEX_CACHE_STRING_SYNC, new String(((dbs) aVar.iLC).toByteArray(), org.apache.commons.a.a.ISO_8859_1));
                AppMethodBeat.o(182497);
                return;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(182497);
    }

    private static dbs fMR() {
        AppMethodBeat.i(68454);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_LQT_PLAN_INDEX_CACHE_STRING_SYNC, "");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(68454);
            return null;
        }
        try {
            dbs dbs = (dbs) new dbs().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
            AppMethodBeat.o(68454);
            return dbs;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e2, "", new Object[0]);
            AppMethodBeat.o(68454);
            return null;
        }
    }
}
