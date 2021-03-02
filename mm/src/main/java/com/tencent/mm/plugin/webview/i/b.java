package com.tencent.mm.plugin.webview.i;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.d.l;
import com.tencent.mm.plugin.webview.k.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g;
import kotlin.g.b.ad;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;
import kotlin.t;

public final class b {
    private static final kotlin.f JcT = g.ah(a.JcV);
    public static final b JcU = new b();

    /* renamed from: com.tencent.mm.plugin.webview.i.b$b */
    public static final class C1959b extends q implements kotlin.g.a.b<String, Long> {
        final /* synthetic */ j JcW;
        final /* synthetic */ long ipR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1959b(j jVar, long j2) {
            super(1);
            this.JcW = jVar;
            this.ipR = j2;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Long invoke(String str) {
            AppMethodBeat.i(225160);
            Long valueOf = Long.valueOf(aZN(str));
            AppMethodBeat.o(225160);
            return valueOf;
        }

        public final long aZN(String str) {
            AppMethodBeat.i(225161);
            p.h(str, "$this$getRecord");
            long bO = this.JcW.bO(str, this.ipR) - this.ipR;
            if (bO > 0) {
                AppMethodBeat.o(225161);
                return bO;
            }
            AppMethodBeat.o(225161);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c extends q implements kotlin.g.a.b<Boolean, Integer> {
        public static final c JcX = new c();

        static {
            AppMethodBeat.i(182646);
            AppMethodBeat.o(182646);
        }

        c() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Boolean bool) {
            int i2;
            AppMethodBeat.i(182645);
            if (bool.booleanValue()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(182645);
            return valueOf;
        }

        public static int zg(boolean z) {
            return z ? 1 : 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d extends q implements kotlin.g.a.b<String, String> {
        final /* synthetic */ j JcW;
        final /* synthetic */ z.e JcY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(j jVar, z.e eVar) {
            super(1);
            this.JcW = jVar;
            this.JcY = eVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(String str) {
            AppMethodBeat.i(182647);
            String aXM = aXM(str);
            AppMethodBeat.o(182647);
            return aXM;
        }

        public final String aXM(String str) {
            AppMethodBeat.i(182648);
            p.h(str, "$this$getRecord");
            String sb = new StringBuilder().append(this.JcW.bO(str, this.JcY.SYF) - this.JcY.SYF).append(',').toString();
            AppMethodBeat.o(182648);
            return sb;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class e extends q implements kotlin.g.a.b<Boolean, Integer> {
        public static final e JcZ = new e();

        static {
            AppMethodBeat.i(82518);
            AppMethodBeat.o(82518);
        }

        e() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(Boolean bool) {
            int i2;
            AppMethodBeat.i(82517);
            if (bool.booleanValue()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(82517);
            return valueOf;
        }

        public static int zg(boolean z) {
            return z ? 1 : 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f extends q implements kotlin.g.a.b<String, Long> {
        final /* synthetic */ j JcW;
        final /* synthetic */ z.e JcY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(j jVar, z.e eVar) {
            super(1);
            this.JcW = jVar;
            this.JcY = eVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Long invoke(String str) {
            AppMethodBeat.i(82519);
            Long valueOf = Long.valueOf(aZN(str));
            AppMethodBeat.o(82519);
            return valueOf;
        }

        public final long aZN(String str) {
            AppMethodBeat.i(82520);
            p.h(str, "$this$getRecord");
            long bO = this.JcW.bO(str, this.JcY.SYF) - this.JcY.SYF;
            AppMethodBeat.o(82520);
            return bO;
        }
    }

    static {
        AppMethodBeat.i(82530);
        AppMethodBeat.o(82530);
    }

    private b() {
    }

    public static final void ago(int i2) {
        AppMethodBeat.i(82521);
        h.INSTANCE.n(1200, 0, (long) i2);
        AppMethodBeat.o(82521);
    }

    public static final void agp(int i2) {
        AppMethodBeat.i(82522);
        h.INSTANCE.n(1200, 1, (long) i2);
        AppMethodBeat.o(82522);
    }

    public static final void gdN() {
        AppMethodBeat.i(82523);
        h.INSTANCE.n(1200, 10, 1);
        AppMethodBeat.o(82523);
    }

    public static final void gdO() {
        AppMethodBeat.i(82524);
        h.INSTANCE.n(1200, 11, 1);
        AppMethodBeat.o(82524);
    }

    public static final void gdP() {
        AppMethodBeat.i(82525);
        h.INSTANCE.n(1200, 12, 1);
        AppMethodBeat.o(82525);
    }

    public static final void gdQ() {
        AppMethodBeat.i(82526);
        h.INSTANCE.n(1200, 100, 1);
        AppMethodBeat.o(82526);
    }

    public static final void gdR() {
        AppMethodBeat.i(82527);
        h.INSTANCE.n(1200, 101, 1);
        AppMethodBeat.o(82527);
    }

    public static final void gdS() {
        AppMethodBeat.i(82528);
        h.INSTANCE.n(1200, 102, 1);
        AppMethodBeat.o(82528);
    }

    public static /* synthetic */ void a(int i2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i3) {
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        AppMethodBeat.i(160475);
        if ((i3 & 4) != 0) {
            z6 = false;
        } else {
            z6 = z;
        }
        if ((i3 & 8) != 0) {
            z7 = false;
        } else {
            z7 = z2;
        }
        if ((i3 & 16) != 0) {
            z8 = false;
        } else {
            z8 = z3;
        }
        if ((i3 & 32) != 0) {
            z9 = false;
        } else {
            z9 = z4;
        }
        if ((i3 & 64) != 0) {
            z10 = false;
        } else {
            z10 = z5;
        }
        a(i2, str, z6, z7, z8, z9, z10, false);
        AppMethodBeat.o(160475);
    }

    public static final void a(int i2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 1;
        AppMethodBeat.i(160474);
        p.h(str, "url");
        StringBuilder sb = new StringBuilder();
        sb.append(i2).append(",");
        sb.append(com.tencent.mm.compatible.util.q.encode(str, ProtocolPackage.ServerEncoding)).append(",");
        String ahH = ((com.tencent.mm.plugin.brandservice.a.e) JcT.getValue()).ahH(str);
        if (ahH == null) {
            ahH = "";
        }
        sb.append(ahH).append(",");
        sb.append(z ? 1 : 0).append(",");
        if (z2) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        sb.append(i3).append(",");
        Uri parse = Uri.parse(str);
        p.g(parse, "Uri.parse(url)");
        sb.append(parse.getHost()).append(",");
        if (z3) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        sb.append(i4).append(",");
        if (z4) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        sb.append(i5).append(",");
        if (z5) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        sb.append(i6).append(",");
        if (!z6) {
            i7 = 0;
        }
        sb.append(i7);
        String sb2 = sb.toString();
        h.INSTANCE.kvStat(18919, sb2);
        Log.v("ReportWebPrefetchCTR", sb2);
        AppMethodBeat.o(160474);
    }

    public static final void ki(int i2, int i3) {
        AppMethodBeat.i(175657);
        k(0, (long) i2, i3);
        AppMethodBeat.o(175657);
    }

    public static final void kj(int i2, int i3) {
        AppMethodBeat.i(175659);
        k(2, (long) i2, i3);
        AppMethodBeat.o(175659);
    }

    public static final void kk(int i2, int i3) {
        AppMethodBeat.i(175660);
        k(6, (long) i2, i3);
        AppMethodBeat.o(175660);
    }

    public static final void agq(int i2) {
        AppMethodBeat.i(175661);
        k(7, 1, i2);
        AppMethodBeat.o(175661);
    }

    public static final void agr(int i2) {
        AppMethodBeat.i(175664);
        k(10, 1, i2);
        AppMethodBeat.o(175664);
    }

    public static final void ags(int i2) {
        AppMethodBeat.i(225162);
        k(3, 1, i2);
        AppMethodBeat.o(225162);
    }

    public static final void agt(int i2) {
        AppMethodBeat.i(225163);
        k(4, 1, i2);
        AppMethodBeat.o(225163);
    }

    public static final void agu(int i2) {
        AppMethodBeat.i(225164);
        k(5, 1, i2);
        AppMethodBeat.o(225164);
    }

    private static final void k(long j2, long j3, int i2) {
        AppMethodBeat.i(175668);
        h.INSTANCE.n(1281, j2, j3);
        switch (i2) {
            case 1:
                h.INSTANCE.n(1283, j2, j3);
                break;
            case 2:
                h.INSTANCE.n(1282, j2, j3);
                break;
            case 4:
                h.INSTANCE.n(1284, j2, j3);
                break;
            case 8:
                h.INSTANCE.n(1285, j2, j3);
                break;
            case 16:
                h.INSTANCE.n(1286, j2, j3);
                break;
            default:
                h.INSTANCE.n(1287, j2, j3);
                break;
        }
        Log.v("MicroMsg.WebViewPerformanceReporter", "reportByScene scene = " + i2 + ", key = " + j2 + ", value = " + j3);
        AppMethodBeat.o(175668);
    }

    public static final void b(j jVar, WebView webView) {
        int i2;
        int i3;
        int i4;
        int i5 = 4;
        int i6 = 2;
        int i7 = 1;
        AppMethodBeat.i(182649);
        p.h(jVar, "performanceHelper");
        p.h(webView, "webView");
        c cVar = c.JcX;
        z.e eVar = new z.e();
        eVar.SYF = jVar.JBP;
        d dVar = new d(jVar, eVar);
        StringBuilder sb = new StringBuilder();
        Uri parse = Uri.parse(jVar.ISo);
        p.g(parse, "Uri.parse(performanceHelper.initUrl)");
        sb.append(parse.getHost()).append(",");
        sb.append(com.tencent.mm.compatible.util.q.encode(jVar.ISo, ProtocolPackage.ServerEncoding)).append(",");
        if (jVar.JBJ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jVar.Jcu) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (jVar.JBL) {
            i4 = 4;
        } else {
            i4 = 0;
        }
        sb.append(i2 | i3 | i4).append(",");
        if (!jVar.Jct) {
            i7 = 0;
        }
        if (jVar.JBM.size() <= 0) {
            i6 = 0;
        }
        if (jVar.JBN.size() <= 0) {
            i5 = 0;
        }
        sb.append(i7 | i6 | i5).append(",");
        c cVar2 = c.JcX;
        sb.append(c.zg(jVar.Jcv)).append(",");
        sb.append(jVar.Jis).append(",");
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(",");
        sb.append(0).append(",");
        sb.append(dVar.aXM("pageAppear"));
        sb.append(dVar.aXM("onWebViewCreateStart"));
        sb.append(dVar.aXM("onWebViewCreateEnd"));
        sb.append(dVar.aXM("getA8KeyStart"));
        sb.append(dVar.aXM("getA8KeyEnd"));
        sb.append(dVar.aXM("clientLoadUrl"));
        sb.append(dVar.aXM("navigationStart"));
        sb.append(dVar.aXM("domainLookupStart"));
        sb.append(dVar.aXM("domainLookupEnd"));
        sb.append(dVar.aXM("connectStart"));
        sb.append(dVar.aXM("connectEnd"));
        sb.append(dVar.aXM("responseStart"));
        sb.append(dVar.aXM("responseEnd"));
        sb.append(jVar.JBJ ? new StringBuilder().append(jVar.JBK - eVar.SYF).append(',').toString() : dVar.aXM("domLoading"));
        sb.append(dVar.aXM("domInteractive"));
        sb.append(dVar.aXM("domContentLoadedEventStart"));
        sb.append(dVar.aXM("domContentLoadedEventEnd"));
        sb.append(dVar.aXM("loadEventStart"));
        sb.append(dVar.aXM("loadEventEnd"));
        sb.append(dVar.aXM("onTryBindServiceStart"));
        sb.append(dVar.aXM("onPostBindedEnd"));
        sb.append(dVar.aXM("onCreate"));
        sb.append(dVar.aXM("onUIInitEnd"));
        String sb2 = sb.toString();
        p.g(sb2, "StringBuilder().apply {\n…())\n\n        }.toString()");
        Log.i("WebViewPerformanceReporter", sb2);
        h.INSTANCE.kvStat(19471, sb2);
        if (l.gbo()) {
            c(jVar, webView);
        }
        AppMethodBeat.o(182649);
    }

    private static void c(j jVar, WebView webView) {
        o[] oVarArr;
        ad adVar;
        ad adVar2;
        AppMethodBeat.i(225165);
        long j2 = jVar.JBP;
        ArrayList arrayList = new ArrayList();
        C1959b bVar = new C1959b(jVar, j2);
        arrayList.add(0L);
        arrayList.add(Long.valueOf(bVar.aZN("pageAppear")));
        arrayList.add(Long.valueOf(bVar.aZN("onWebViewCreateStart")));
        arrayList.add(Long.valueOf(bVar.aZN("onWebViewCreateEnd")));
        arrayList.add(Long.valueOf(bVar.aZN("getA8KeyStart")));
        arrayList.add(Long.valueOf(bVar.aZN("getA8KeyEnd")));
        arrayList.add(Long.valueOf(bVar.aZN("clientLoadUrl")));
        arrayList.add(Long.valueOf(bVar.aZN("navigationStart")));
        arrayList.add(Long.valueOf(bVar.aZN("domainLookupStart")));
        arrayList.add(Long.valueOf(bVar.aZN("domainLookupEnd")));
        arrayList.add(Long.valueOf(bVar.aZN("connectStart")));
        arrayList.add(Long.valueOf(bVar.aZN("connectEnd")));
        arrayList.add(Long.valueOf(bVar.aZN("responseStart")));
        arrayList.add(Long.valueOf(bVar.aZN("responseEnd")));
        arrayList.add(Long.valueOf(bVar.aZN("domLoading")));
        arrayList.add(Long.valueOf(bVar.aZN("domInteractive")));
        arrayList.add(Long.valueOf(bVar.aZN("onTryBindServiceStart")));
        arrayList.add(Long.valueOf(bVar.aZN("onPostBindedEnd")));
        arrayList.add(Long.valueOf(bVar.aZN("onCreate")));
        arrayList.add(Long.valueOf(bVar.aZN("onUIInitEnd")));
        String str = "[" + kotlin.a.j.a(kotlin.a.j.b(arrayList, 20), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 63) + ']';
        String[][] strArr = jVar.JBI;
        if (strArr != null) {
            String[][] strArr2 = strArr;
            ArrayList arrayList2 = new ArrayList(strArr2.length);
            for (String[] strArr3 : strArr2) {
                arrayList2.add(s.U(strArr3[0], strArr3[1]));
            }
            Object[] array = arrayList2.toArray(new o[0]);
            if (array == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(225165);
                throw tVar;
            }
            oVarArr = (o[]) array;
        } else {
            oVarArr = null;
        }
        ad adVar3 = new ad(10);
        adVar3.add(s.U("section", "GetA8Key"));
        adVar3.add(s.U("preGetA8Key", String.valueOf(jVar.Jcu)));
        adVar3.add(s.U("preDns", String.valueOf(jVar.Jcv)));
        if (oVarArr == null) {
            oVarArr = new o[0];
            adVar = adVar3;
            adVar2 = adVar3;
        } else {
            adVar = adVar3;
            adVar2 = adVar3;
        }
        adVar.eS(oVarArr);
        adVar2.add(s.U("section", "Prefetch"));
        adVar2.add(s.U("prefetch", String.valueOf(jVar.Jct)));
        adVar2.add(s.U("prefetchJS", kotlin.a.j.a(jVar.JBM, "<br/>", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62)));
        adVar2.add(s.U("prefetchCSS", kotlin.a.j.a(jVar.JBN, "<br/>", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62)));
        adVar2.add(s.U("section", "Prefetch Headers"));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : jVar.JBO.entrySet()) {
            String key = entry.getKey();
            entry.getValue();
            if (key == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(225165);
                throw tVar2;
            }
            String obj = n.trim(key).toString();
            if (obj == null) {
                t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(225165);
                throw tVar3;
            }
            String lowerCase = obj.toLowerCase();
            p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (n.J(lowerCase, "x-wx-", false)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Object[] array2 = ae.cv(linkedHashMap).toArray(new o[0]);
        if (array2 == null) {
            t tVar4 = new t("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(225165);
            throw tVar4;
        }
        adVar2.eS(array2);
        j.a("['PageAppear', 'WebView', 'GetA8key', 'ClientLoadToNavStart', 'DomainLookUp', 'ConnectStart', 'Response', 'DomLoadingToInteractive', 'Invoker', 'WebViewUICreate']", str, webView, kotlin.a.j.listOf((Object[]) ((o[]) adVar2.toArray(new o[adVar2.dtS.size()]))));
        AppMethodBeat.o(225165);
    }

    static final class a extends q implements kotlin.g.a.a<com.tencent.mm.plugin.brandservice.a.e> {
        public static final a JcV = new a();

        static {
            AppMethodBeat.i(225159);
            AppMethodBeat.o(225159);
        }

        a() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.brandservice.a.e invoke() {
            AppMethodBeat.i(225158);
            com.tencent.mm.plugin.brandservice.a.e eVar = (com.tencent.mm.plugin.brandservice.a.e) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class);
            AppMethodBeat.o(225158);
            return eVar;
        }
    }

    public static final void a(j jVar, WebView webView) {
        AppMethodBeat.i(82529);
        p.h(jVar, "performanceHelper");
        p.h(webView, "webView");
        boolean z = jVar.Jcu;
        boolean z2 = jVar.Jcv;
        h hVar = h.INSTANCE;
        if (z) {
            hVar.n(1200, 2, 1);
        }
        if (z2) {
            hVar.n(1200, 3, 1);
        }
        z.e eVar = new z.e();
        eVar.SYF = jVar.JBP;
        e eVar2 = e.JcZ;
        f fVar = new f(jVar, eVar);
        StringBuilder sb = new StringBuilder();
        sb.append(fVar.aZN("onCreate")).append(",");
        sb.append(fVar.aZN("onUIInitEnd")).append(",");
        sb.append(fVar.aZN("onWebViewCreateStart")).append(",");
        sb.append(fVar.aZN("onWebViewCreateEnd")).append(",");
        sb.append(fVar.aZN("getA8KeyStart")).append(",");
        sb.append(fVar.aZN("getA8KeyEnd")).append(",");
        sb.append(fVar.aZN("onTryBindServiceStart")).append(",");
        sb.append(fVar.aZN("onPostBindedEnd")).append(",");
        sb.append("0,0,");
        sb.append(fVar.aZN("navigationStart")).append(",");
        sb.append(fVar.aZN("domLoading")).append(",");
        sb.append(fVar.aZN("domainLookupStart")).append(",");
        sb.append(fVar.aZN("domainLookupEnd")).append(",");
        sb.append(fVar.aZN("navigationStart")).append(",");
        sb.append(fVar.aZN("firstContentfulPaint")).append(",");
        sb.append(fVar.aZN("domContentLoadedEventStart")).append(",");
        sb.append(fVar.aZN("loadEventStart"));
        String sb2 = sb.toString();
        p.g(sb2, "StringBuilder().apply {\n…d())\n        }.toString()");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(com.tencent.mm.compatible.util.q.encode(jVar.ISo, ProtocolPackage.ServerEncoding)).append(",");
        Uri parse = Uri.parse(jVar.ISo);
        p.g(parse, "Uri.parse(performanceHelper.initUrl)");
        sb3.append(parse.getHost()).append(",");
        e eVar3 = e.JcZ;
        sb3.append(e.zg(jVar.Jcu)).append(",");
        e eVar4 = e.JcZ;
        sb3.append(e.zg(jVar.Jcv)).append(",");
        sb3.append(0).append(",");
        e eVar5 = e.JcZ;
        sb3.append(e.zg(jVar.Jct)).append(",");
        sb3.append(jVar.JBM.size() + jVar.JBN.size()).append(",");
        sb3.append(0).append(",");
        sb3.append(0).append(",");
        sb3.append(0).append(",");
        sb3.append(sb2);
        h.INSTANCE.kvStat(18497, sb3.toString());
        Log.v("MicroMsg.WebViewPerformanceReporter", "webview performance:\n".concat(String.valueOf(sb2)));
        a(jVar.Jis, jVar.ISo, false, true, jVar.Jcu, jVar.Jcv, jVar.Jct, 128);
        AppMethodBeat.o(82529);
    }

    public static final void a(j jVar, int i2) {
        AppMethodBeat.i(175658);
        p.h(jVar, "performanceHelper");
        if (jVar.Jcu) {
            k(1, 1, i2);
        }
        AppMethodBeat.o(175658);
    }
}
