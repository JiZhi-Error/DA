package com.tencent.mm.plugin.soter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.j.c;
import com.tencent.soter.a.c.b;

public final class d implements a<c<Boolean, Boolean>, c<Boolean, Boolean>> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.vending.c.a
    public final /* synthetic */ c<Boolean, Boolean> call(c<Boolean, Boolean> cVar) {
        AppMethodBeat.i(192235);
        c<Boolean, Boolean> cVar2 = cVar;
        String aax = m.aax(1);
        String aay = m.aay(1);
        boolean bqh = com.tencent.soter.core.a.bqh(aay);
        boolean bqh2 = com.tencent.soter.core.a.bqh(aax);
        Log.i("MicroMsg.SoterProcessAuthkeyNameFunc", "need change authkey, new:[%s, %s], old:[%s, %s]", aay, Boolean.valueOf(bqh), aax, Boolean.valueOf(bqh2));
        if (!bqh && bqh2) {
            b.hlG().hlI().put(1, aax);
        } else if (bqh && bqh2) {
            Log.i("MicroMsg.SoterProcessAuthkeyNameFunc", "remove old ak");
            com.tencent.soter.core.a.dE(aax, false);
        }
        com.tencent.soter.core.a.dE(m.aax(2), false);
        com.tencent.soter.core.a.dE(m.aax(3), false);
        AppMethodBeat.o(192235);
        return cVar2;
    }
}
