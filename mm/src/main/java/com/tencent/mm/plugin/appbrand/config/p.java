package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.fct;
import com.tencent.mm.protocal.protobuf.fcv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.c;
import java.util.Objects;

public final class p extends b<fcv> {
    final d rr;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r3 = 44853(0xaf35, float:6.2852E-41)
            r0 = 0
            com.tencent.mm.protocal.protobuf.acc r1 = new com.tencent.mm.protocal.protobuf.acc
            r1.<init>()
            r2 = 1
            r1.LmG = r2
            r4.<init>(r5, r6, r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.p.<init>(java.lang.String, java.lang.String):void");
    }

    public p(String str, String str2, String str3, acc acc) {
        super(str2, str);
        com.tencent.mm.bw.b Xp;
        String nullAsNil;
        AppMethodBeat.i(226464);
        d.a aVar = new d.a();
        fct fct = new fct();
        fct.Mmv = str;
        if (Util.isNullOrNil(str)) {
            WxaAttributes e2 = n.buC().e(str2, "syncVersion");
            if (e2 == null) {
                nullAsNil = "";
            } else {
                nullAsNil = Util.nullAsNil(e2.field_syncVersion);
            }
            Xp = new com.tencent.mm.bw.b(nullAsNil.getBytes());
        } else {
            Xp = n.buC().Xp(str);
        }
        fct.KSW = Xp;
        fct.NyI = str2;
        fct.Mmu = str3;
        fct.NyJ = 0;
        fct.KOF = (acc) Objects.requireNonNull(acc);
        aVar.iLN = fct;
        aVar.iLO = new fcv();
        aVar.funcId = 1151;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
        d aXF = aVar.aXF();
        this.rr = aXF;
        c(aXF);
        Log.i("MicroMsg.CgiWxaAttrSync", "<init> hash:%d, username:%s, appId:%s, cleanUpdate:%b, instanceId:%s, scene:%d, source:%s", Integer.valueOf(hashCode()), str, str2, Boolean.FALSE, str3, 0, a.a(acc));
        AppMethodBeat.o(226464);
    }

    @Override // com.tencent.mm.plugin.appbrand.networking.b
    public final f<c.a<fcv>> bAe() {
        AppMethodBeat.i(226465);
        if (!com.tencent.mm.plugin.appbrand.networking.a.eA(((fct) this.rr.iLK.iLR).NyI, ((fct) this.rr.iLK.iLR).Mmv)) {
            f<c.a<fcv>> c2 = g.c(new c.a<c.a<fcv>>() {
                /* class com.tencent.mm.plugin.appbrand.config.p.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.vending.g.c.a
                public final /* synthetic */ c.a<fcv> call() {
                    AppMethodBeat.i(226463);
                    c.a a2 = c.a.a(4, -2, "", null, null, p.this);
                    AppMethodBeat.o(226463);
                    return a2;
                }
            });
            AppMethodBeat.o(226465);
            return c2;
        }
        AppMethodBeat.o(226465);
        return null;
    }
}
