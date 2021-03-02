package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.nj;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001J$\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandServiceWCScriptReporter;", "", "()V", "TAG", "", "reportEvaluateResult", "", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "scriptInfo", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", StateEvent.ProcessResult.SUCCEED, "", "startTimeMs", "", "endTimeMs", "extraParams", "reportJSError", "message", "stackTrace", "plugin-appbrand-integration_release"})
public final class k {
    public static final k nHq = new k();

    static {
        AppMethodBeat.i(51009);
        AppMethodBeat.o(51009);
    }

    private k() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c1, code lost:
        if (r11.equals("WAServiceMainContext.js") != false) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c3, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandServiceWCScriptReporter", "reportEvaluateResult, service_lib_script[" + r11 + "], succeed[" + r15 + ']');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ee, code lost:
        if (r13.getRuntime() == null) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f0, code lost:
        if (r15 == false) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f2, code lost:
        com.tencent.mm.plugin.appbrand.keylogger.c.a(r13.getAppId(), com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch.stepInjectJSWAMainContext, "", r16, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0102, code lost:
        com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
        com.tencent.mm.plugin.appbrand.report.quality.c.a(r13, r11, r14.czA, r16, r18, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0116, code lost:
        switch(r11.hashCode()) {
            case -979125780: goto L_0x0274;
            case 2071195020: goto L_0x0254;
            default: goto L_0x0119;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0119, code lost:
        r3 = new kotlin.r(0, 0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x012e, code lost:
        r4 = r3.first.intValue();
        r5 = r3.second.intValue();
        r2 = r3.SWY.intValue();
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(370, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x014d, code lost:
        if (r15 == false) goto L_0x0297;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x014f, code lost:
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(370, r2);
        com.tencent.matrix.trace.core.AppMethodBeat.o(175210);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x023b, code lost:
        if (r11.equals("WAService.js") != false) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x023f, code lost:
        com.tencent.mm.plugin.appbrand.keylogger.c.a(r13.getAppId(), com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch.stepInjectJSWAMainContext, "", "", r16, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x025b, code lost:
        if (r11.equals("WAService.js") == false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x025d, code lost:
        r3 = new kotlin.r(5, 6, 7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x027b, code lost:
        if (r11.equals("WAServiceMainContext.js") == false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x027d, code lost:
        r3 = new kotlin.r(61, 62, 63);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0297, code lost:
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(370, r5);
        com.tencent.mm.plugin.appbrand.report.i.cf(r13.getAppId(), 24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02ab, code lost:
        if (r13.getRuntime() == null) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02ad, code lost:
        r2 = r13.getRuntime();
        kotlin.g.b.p.g(r2, "runtime");
        r2 = r2.bsB().leE.pkgVersion;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02c3, code lost:
        if (r13.getRuntime() == null) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02c5, code lost:
        r3 = r13.getRuntime();
        kotlin.g.b.p.g(r3, "runtime");
        r3 = r3.bsB().bAb();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02d7, code lost:
        com.tencent.mm.plugin.appbrand.report.i.b(r13.getAppId(), r2, r3, 370, r5);
        com.tencent.matrix.trace.core.AppMethodBeat.o(175210);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02e8, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02ea, code lost:
        r3 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.plugin.appbrand.service.c r13, com.tencent.luggage.sdk.b.a.d.a r14, boolean r15, long r16, long r18, java.lang.Object r20) {
        /*
        // Method dump skipped, instructions count: 984
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.report.k.a(com.tencent.mm.plugin.appbrand.service.c, com.tencent.luggage.sdk.b.a.d$a, boolean, long, long, java.lang.Object):void");
    }

    public static final void b(c cVar, String str, String str2) {
        AppMethodBeat.i(51008);
        p.h(cVar, "service");
        QualitySessionRuntime aeU = b.aeU(cVar.getAppId());
        if (aeU != null) {
            nj njVar = new nj();
            njVar.At(aeU.appId);
            njVar.xI((long) aeU.nLk);
            njVar.xJ((long) aeU.nJE);
            njVar.ajp();
            njVar.Au(str);
            njVar.Av(str2);
            ICommLibReader bqZ = cVar.bqZ();
            if (bqZ == null) {
                p.hyc();
            }
            njVar.Aw(bqZ.bvb());
            njVar.xK((long) aeU.apptype);
            njVar.xL((long) aeU.nLx.get());
            ag bsz = cVar.bsz();
            p.g(bsz, "page");
            String url = bsz.getURL();
            String bRm = bsz.bRm();
            p.g(bRm, "page.urlWithQuery");
            int length = url.length();
            if (bRm == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(51008);
                throw tVar;
            }
            String substring = bRm.substring(length);
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            njVar.Ax(url);
            njVar.Ay(substring);
            njVar.bfK();
            AppMethodBeat.o(51008);
            return;
        }
        AppMethodBeat.o(51008);
    }
}
