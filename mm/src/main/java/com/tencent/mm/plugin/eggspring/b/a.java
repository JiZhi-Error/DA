package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.t.a.g;
import com.tencent.mm.t.a.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/cgi/GetCouponCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetSnsAdCouponCardResp;", "appId", "", "stockId", "uxInfo", "compId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "plugin-eggspring_release"})
public final class a extends c<h> {
    public a(String str, String str2, String str3, String str4) {
        p.h(str, "appId");
        p.h(str2, "stockId");
        p.h(str3, "uxInfo");
        p.h(str4, "compId");
        AppMethodBeat.i(194564);
        g gVar = new g();
        gVar.appId = str;
        gVar.gTp = str2;
        gVar.uxInfo = str3;
        gVar.gTq = str4;
        d.a aVar = new d.a();
        aVar.c(gVar);
        aVar.d(new h());
        aVar.sI(0);
        aVar.sJ(0);
        aVar.MB("/cgi-bin/mmoc-bin/adplayinfo/send_ad_coupon");
        aVar.sG(4743);
        c(aVar.aXF());
        AppMethodBeat.o(194564);
    }
}
