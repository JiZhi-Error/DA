package com.tencent.mm.plugin.soter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.soter.a.f.e;

public final class c implements a<Boolean, com.tencent.mm.vending.j.c<Boolean, Boolean>> {
    private b jSi = null;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.vending.c.a
    public final /* synthetic */ Boolean call(com.tencent.mm.vending.j.c<Boolean, Boolean> cVar) {
        e gVar;
        AppMethodBeat.i(130881);
        final com.tencent.mm.vending.j.c<Boolean, Boolean> cVar2 = cVar;
        Log.v("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc call");
        if (!((Boolean) cVar2.get(0)).booleanValue()) {
            Log.i("MicroMsg.SoterPrepareAskFunc", "alvinluo not need prepare ask, return");
            Boolean bool = (Boolean) cVar2.get(1);
            AppMethodBeat.o(130881);
            return bool;
        }
        this.jSi = g.hdx();
        if (com.tencent.soter.a.a.hlC()) {
            if (com.tencent.mm.kernel.g.aAc()) {
                gVar = new f();
            } else {
                gVar = new com.tencent.mm.plugin.soter.b.g();
            }
            Log.v("MicroMsg.SoterPrepareAskFunc", "alvinluo has ask: %b", Boolean.valueOf(com.tencent.soter.core.a.hlm()));
            this.jSi.hdw();
            com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b<com.tencent.soter.a.b.c>() {
                /* class com.tencent.mm.plugin.soter.e.c.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
                @Override // com.tencent.soter.a.b.b
                public final /* synthetic */ void a(com.tencent.soter.a.b.c cVar) {
                    AppMethodBeat.i(130880);
                    com.tencent.soter.a.b.c cVar2 = cVar;
                    Log.i("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc onResult errCode: %d, errMsg: %s", Integer.valueOf(cVar2.errCode), cVar2.errMsg);
                    if (cVar2.isSuccess()) {
                        c.this.jSi.G(cVar2.get(1));
                        if (!c.fmc()) {
                            h.INSTANCE.dN(1104, 29);
                        }
                        if (!c.fmd()) {
                            h.INSTANCE.dN(1104, 30);
                        }
                        c.vF(true);
                        c.vG(true);
                    } else {
                        if (cVar2.errCode == 1003) {
                            c.vG(false);
                        }
                        if (cVar2.errCode == 4) {
                            c.vF(false);
                        }
                        com.tencent.mm.plugin.soter.d.a.n(1, cVar2.errCode, 1);
                        c.this.jSi.ej(g.P(Integer.valueOf(cVar2.errCode), cVar2.errMsg));
                    }
                    if (com.tencent.soter.core.a.hlf() == 1) {
                        com.tencent.mm.plugin.soter.d.a.n(1, -2, 1);
                        AppMethodBeat.o(130880);
                        return;
                    }
                    com.tencent.mm.plugin.soter.d.a.n(1, -3, 1);
                    AppMethodBeat.o(130880);
                }
            }, false, gVar);
            Log.v("MicroMsg.SoterPrepareAskFunc", "alvinluo prepareask isNeedSaveDeviceInfo: %b", cVar2.get(1));
            Boolean bool2 = (Boolean) cVar2.get(1);
            AppMethodBeat.o(130881);
            return bool2;
        }
        Boolean bool3 = Boolean.FALSE;
        AppMethodBeat.o(130881);
        return bool3;
    }

    static /* synthetic */ boolean fmc() {
        AppMethodBeat.i(130882);
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_IS_LAST_UPLOAD_ASK_SUCCESS_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(130882);
        return booleanValue;
    }

    static /* synthetic */ boolean fmd() {
        AppMethodBeat.i(130883);
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_IS_LAST_GEN_ASK_SUCCESS_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(130883);
        return booleanValue;
    }

    static /* synthetic */ void vF(boolean z) {
        AppMethodBeat.i(130884);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_IS_LAST_GEN_ASK_SUCCESS_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.o(130884);
    }

    static /* synthetic */ void vG(boolean z) {
        AppMethodBeat.i(130885);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_IS_LAST_UPLOAD_ASK_SUCCESS_BOOLEAN_SYNC, Boolean.valueOf(z));
        AppMethodBeat.o(130885);
    }
}
