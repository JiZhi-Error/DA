package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.b.p;
import com.tencent.mm.co.f;
import com.tencent.mm.g.a.abc;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.launching.v;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;

public final class i extends c<bwc> {
    public final d rr;

    public i(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(44238);
        d.a aVar = new d.a();
        aVar.funcId = 1718;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
        bwb bwb = new bwb();
        bwb.dNI = str;
        if (i3 != 12) {
            bwb.MbW = str2;
        }
        bwb.MbX = str3;
        bwb.Lcr = i2;
        bwb.MbZ = i3;
        if (i2 == 1) {
            try {
                bwb.MbY = new p(h.FE(((t) n.W(t.class)).bU(str, i2)).optLong("dev_key")).intValue();
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", e2);
            }
        }
        aVar.iLN = bwb;
        aVar.iLO = new bwc();
        d aXF = aVar.aXF();
        this.rr = aXF;
        c(aXF);
        Log.d("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "appid:%s,module_name:%s,code_type:%d,package type:%s", str, str2, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(44238);
    }

    public final bwb bvi() {
        return (bwb) this.rr.iLK.iLR;
    }

    @Override // com.tencent.mm.ak.c
    public final synchronized f<c.a<bwc>> aYI() {
        f<_Ret> b2;
        AppMethodBeat.i(44239);
        final long nowMilliSecond = Util.nowMilliSecond();
        f<c.a<bwc>> a2 = v.a(this);
        if (a2 == null) {
            a2 = super.aYI();
        }
        b2 = a2.b(new a<c.a<bwc>, c.a<bwc>>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.i.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ c.a<bwc> call(c.a<bwc> aVar) {
                AppMethodBeat.i(44237);
                c.a<bwc> aVar2 = aVar;
                abc abc = new abc();
                abc.eir.eis = i.this;
                abc.eir.eiq = nowMilliSecond;
                abc.eir.dcl = Util.nowMilliSecond();
                abc.eir.eip = aVar2;
                EventCenter.instance.publish(abc);
                AppMethodBeat.o(44237);
                return aVar2;
            }
        });
        AppMethodBeat.o(44239);
        return b2;
    }
}
