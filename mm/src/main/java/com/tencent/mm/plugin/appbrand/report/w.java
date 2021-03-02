package com.tencent.mm.plugin.appbrand.report;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b*\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/WeAppLaunchOpenSdkAdTracer;", "", "()V", "SNS_TIMELINE_AD_SCENES", "", "", "[Ljava/lang/Integer;", "TAG", "", "mMapInstanceId2TraceKey", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMapInstanceId2TraceKey", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mMapInstanceId2TraceKey$delegate", "Lkotlin/Lazy;", "onColdLaunchExecuted", "", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "onInstanceIdGenerated", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "onWarmLaunchExecuted", "reportKV", "value", "getAndRemove", "key", "plugin-appbrand-integration_release"})
public final class w {
    private static final f nHX = g.ah(a.nIa);
    private static final Integer[] nHY = {1084, 1046, 1045};
    public static final w nHZ = new w();

    static {
        AppMethodBeat.i(51033);
        AppMethodBeat.o(51033);
    }

    private w() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
        if (kotlin.a.e.contains(r4, r0 != null ? java.lang.Integer.valueOf(r0.scene) : null) != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.report.w.b(com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel, java.lang.String):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ String nIb;
        final /* synthetic */ z.f nId;

        c(String str, z.f fVar) {
            this.nIb = str;
            this.nId = fVar;
        }

        public final void run() {
            AppMethodBeat.i(51031);
            w wVar = w.nHZ;
            w.bUA().encode(this.nIb, (String) this.nId.SYG);
            w wVar2 = w.nHZ;
            String a2 = org.apache.commons.b.g.a(new String[]{this.nId.SYG, "", this.nIb, "1"}, ",");
            p.g(a2, "StringUtils.join(arrayOf…                  ), \",\")");
            w.aeM(a2);
            AppMethodBeat.o(51031);
        }
    }

    public static void h(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(51035);
        p.h(appBrandInitConfigWC, "initConfig");
        QualitySession qualitySession = appBrandInitConfigWC.ldW;
        String str = qualitySession != null ? qualitySession.kEY : null;
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            h.RTc.b(new d(str, appBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
        }
        AppMethodBeat.o(51035);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ String nIb;
        final /* synthetic */ AppBrandInitConfigWC nIc;

        d(String str, AppBrandInitConfigWC appBrandInitConfigWC) {
            this.nIb = str;
            this.nIc = appBrandInitConfigWC;
        }

        public final void run() {
            AppMethodBeat.i(51032);
            w wVar = w.nHZ;
            String a2 = w.a(w.bUA(), this.nIb);
            String str = a2;
            if (!(str == null || str.length() == 0)) {
                String NB = this.nIc.NB();
                w wVar2 = w.nHZ;
                String a3 = org.apache.commons.b.g.a(new String[]{a2, NB, this.nIb, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL}, ",");
                p.g(a3, "StringUtils.join(arrayOf…                  ), \",\")");
                w.aeM(a3);
            }
            AppMethodBeat.o(51032);
        }
    }

    public static void i(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(51036);
        p.h(appBrandInitConfigWC, "initConfig");
        QualitySession qualitySession = appBrandInitConfigWC.ldW;
        String str = qualitySession != null ? qualitySession.kEY : null;
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            h.RTc.b(new b(str, appBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
        }
        AppMethodBeat.o(51036);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ String nIb;
        final /* synthetic */ AppBrandInitConfigWC nIc;

        b(String str, AppBrandInitConfigWC appBrandInitConfigWC) {
            this.nIb = str;
            this.nIc = appBrandInitConfigWC;
        }

        public final void run() {
            AppMethodBeat.i(51030);
            w wVar = w.nHZ;
            String a2 = w.a(w.bUA(), this.nIb);
            String str = a2;
            if (!(str == null || str.length() == 0)) {
                String NB = this.nIc.NB();
                w wVar2 = w.nHZ;
                String a3 = org.apache.commons.b.g.a(new String[]{a2, NB, this.nIb, "2"}, ",");
                p.g(a3, "StringUtils.join(arrayOf…                  ), \",\")");
                w.aeM(a3);
            }
            AppMethodBeat.o(51030);
        }
    }

    public static final /* synthetic */ MultiProcessMMKV bUA() {
        AppMethodBeat.i(51037);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) nHX.getValue();
        AppMethodBeat.o(51037);
        return multiProcessMMKV;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final a nIa = new a();

        static {
            AppMethodBeat.i(51029);
            AppMethodBeat.o(51029);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(51028);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("MicroMsg.WeAppLaunchOpenSdkAdTracer", 2);
            AppMethodBeat.o(51028);
            return mmkv;
        }
    }

    public static final /* synthetic */ void aeM(String str) {
        AppMethodBeat.i(51038);
        Log.i("MicroMsg.WeAppLaunchOpenSdkAdTracer", "reportKV key[18460] value[" + str + ']');
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(18460, str);
        AppMethodBeat.o(51038);
    }

    public static final /* synthetic */ String a(MultiProcessMMKV multiProcessMMKV, String str) {
        AppMethodBeat.i(51039);
        String decodeString = multiProcessMMKV.decodeString(str, null);
        if (decodeString != null) {
            multiProcessMMKV.removeValueForKey(str);
            AppMethodBeat.o(51039);
            return decodeString;
        }
        AppMethodBeat.o(51039);
        return null;
    }
}
