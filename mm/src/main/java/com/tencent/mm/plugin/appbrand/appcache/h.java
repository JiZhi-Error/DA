package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.co.f;
import com.tencent.mm.g.a.abb;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;

public class h extends b<byz> {
    private static a kKr = null;
    public final d rr;

    public interface a {
        f<c.a<byz>> a(h hVar);
    }

    public static void a(a aVar) {
        kKr = aVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private h(java.lang.String r4, int r5, java.lang.String r6, int r7) {
        /*
            r3 = this;
            r2 = 90541(0x161ad, float:1.26875E-40)
            com.tencent.mm.protocal.protobuf.byy r0 = new com.tencent.mm.protocal.protobuf.byy
            r0.<init>()
            r0.KXD = r5
            r0.dNI = r4
            r0.Mef = r6
            r0.MbZ = r7
            r1 = 0
            r0.Meg = r1
            r3.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.h.<init>(java.lang.String, int, java.lang.String, int):void");
    }

    public h(byy byy) {
        this(byy, 1139, "/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl");
    }

    public h(byy byy, int i2, String str) {
        super(byy.dNI, null);
        AppMethodBeat.i(90542);
        d.a aVar = new d.a();
        aVar.funcId = i2;
        aVar.uri = str;
        aVar.iLN = byy;
        aVar.iLO = new byz();
        d aXF = aVar.aXF();
        this.rr = aXF;
        c(aXF);
        AppMethodBeat.o(90542);
    }

    public h(String str, int i2, String str2, int i3, byte b2) {
        this(str, i2, str2, i3);
    }

    public final byy bvg() {
        return (byy) this.rr.iLK.iLR;
    }

    @Override // com.tencent.mm.plugin.appbrand.networking.b, com.tencent.mm.ak.c
    public final synchronized f<c.a<byz>> aYI() {
        f<_Ret> b2;
        AppMethodBeat.i(90543);
        final long nowMilliSecond = Util.nowMilliSecond();
        a aVar = kKr;
        f<c.a<byz>> a2 = aVar != null ? aVar.a(this) : null;
        if (a2 == null) {
            a2 = super.aYI();
        }
        b2 = a2.b(new com.tencent.mm.vending.c.a<c.a<byz>, c.a<byz>>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.h.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ c.a<byz> call(c.a<byz> aVar) {
                AppMethodBeat.i(90539);
                c.a<byz> aVar2 = aVar;
                abb abb = new abb();
                abb.ein.eio = h.this;
                abb.ein.eiq = nowMilliSecond;
                abb.ein.dcl = Util.nowMilliSecond();
                abb.ein.eip = aVar2;
                EventCenter.instance.publish(abb);
                AppMethodBeat.o(90539);
                return aVar2;
            }
        });
        AppMethodBeat.o(90543);
        return b2;
    }

    public final int bvh() {
        return ((byy) this.rr.iLK.iLR).MbZ;
    }
}
