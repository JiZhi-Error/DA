package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.a;
import java.io.IOException;

public final class r extends a<ddt, k> {
    /* Return type fixed from 'com.tencent.mm.protocal.protobuf.dpc' to match base method */
    @Override // com.tencent.mm.wallet_core.c.a
    public final /* synthetic */ ddt efb() {
        AppMethodBeat.i(68458);
        ddt fMS = fMS();
        AppMethodBeat.o(68458);
        return fMS;
    }

    @Override // com.tencent.mm.wallet_core.c.a
    public final void b(c.a<ddt> aVar) {
        AppMethodBeat.i(182498);
        Log.i("MicroMsg.CgiPlanIndexAsyncLoader", "errType: %s, errCode: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType));
        if (((k) this.iLD).scene == 2) {
            AppMethodBeat.o(182498);
            return;
        }
        if (aVar.errType == 0 && aVar.errCode == 0 && ((ddt) aVar.iLC).pTZ == 0) {
            try {
                ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_LQT_PLAN_ADD_CACHE_STRING_SYNC, new String(((ddt) aVar.iLC).toByteArray(), org.apache.commons.a.a.ISO_8859_1));
                AppMethodBeat.o(182498);
                return;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(182498);
    }

    private ddt fMS() {
        AppMethodBeat.i(68457);
        if (((k) this.iLD).scene == 2) {
            AppMethodBeat.o(68457);
            return null;
        }
        String str = (String) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_LQT_PLAN_ADD_CACHE_STRING_SYNC, "");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(68457);
            return null;
        }
        try {
            ddt ddt = (ddt) new ddt().parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
            AppMethodBeat.o(68457);
            return ddt;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.CgiPlanIndexAsyncLoader", e2, "", new Object[0]);
            AppMethodBeat.o(68457);
            return null;
        }
    }
}
