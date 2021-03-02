package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class c implements j {
    private int IDn;
    private Map<String, String> IDo = new HashMap();

    public c() {
        AppMethodBeat.i(116549);
        AppMethodBeat.o(116549);
    }

    @Override // com.tencent.mm.plugin.websearch.api.j
    public final void afn(int i2) {
        this.IDn = i2;
    }

    @Override // com.tencent.mm.plugin.websearch.api.j
    public final int fXx() {
        return this.IDn;
    }

    @Override // com.tencent.mm.plugin.websearch.api.j
    public final void cL(int i2, String str) {
        AppMethodBeat.i(116550);
        cfy cfy = new cfy();
        cfy.MlF = i2;
        cfy.MlM = (int) (System.currentTimeMillis() / 1000);
        cfy.oTz = 1;
        cfy.MlG = new b(str.getBytes());
        d.a aVar = new d.a();
        aVar.iLN = new ch();
        aVar.iLO = new ci();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.funcId = 1802;
        d aXF = aVar.aXF();
        ch chVar = (ch) aXF.iLK.iLR;
        cfx cfx = new cfx();
        cfx.hid = com.tencent.mm.protocal.d.KyJ;
        cfx.hie = com.tencent.mm.protocal.d.KyI;
        cfx.hif = com.tencent.mm.protocal.d.KyL;
        cfx.hig = com.tencent.mm.protocal.d.KyM;
        cfx.hih = LocaleUtil.getApplicationLanguage();
        cfx.LOF = (int) (System.currentTimeMillis() / 1000);
        chVar.KGA = cfx;
        chVar.KGB.add(cfy);
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.plugin.websearch.c.AnonymousClass1 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(116548);
                Log.d("WebSearchService", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (!(i2 == 0 && i3 == 0)) {
                    h.INSTANCE.idkeyStat(457, 1, 1, false);
                }
                AppMethodBeat.o(116548);
                return 0;
            }
        });
        AppMethodBeat.o(116550);
    }

    @Override // com.tencent.mm.plugin.websearch.api.j
    public final void lF(String str, String str2) {
        AppMethodBeat.i(116552);
        this.IDo.put(str, str2);
        AppMethodBeat.o(116552);
    }

    @Override // com.tencent.mm.plugin.websearch.api.j
    public final String aWW(String str) {
        AppMethodBeat.i(116553);
        String str2 = this.IDo.get(str);
        AppMethodBeat.o(116553);
        return str2;
    }

    @Override // com.tencent.mm.plugin.websearch.api.j
    public final String fXy() {
        AppMethodBeat.i(116551);
        String afw = ai.afw(3);
        AppMethodBeat.o(116551);
        return afw;
    }
}
