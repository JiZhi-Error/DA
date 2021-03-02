package com.tencent.mm.plugin.appbrand.report;

import android.content.res.Resources;
import android.os.Build;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.fcm;
import com.tencent.mm.protocal.protobuf.fcq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.vending.g.d;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0016H\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandIDKeyBatchReportNew;", "Lcom/tencent/mm/plugin/appbrand/report/WxaCgiIDKeyBatchReportProtocol;", "()V", "BATCH_RECORD_COUNT_MAX", "", "BATCH_REPORT_INTERVAL_MS", "", "CGI_URL", "", "TAG", "batchReportBufferQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/WxaAppRecord;", "batchReportTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timerGuard", "", "reportNow", "", "reason", "stopTimer", "startTimer", "", "appId", "runtimeEnterScene", "writeIDKeyData", "data", "plugin-appbrand-integration_release"})
public final class d implements x {
    private static final long nGA = TimeUnit.SECONDS.toMillis(30);
    private static final LinkedList<fcq> nGB = new LinkedList<>();
    private static MTimerHandler nGC = null;
    private static final Object nGD = new Object();
    public static final d nGE = new d();
    private static final String nGy = nGy;
    private static final int nGz = 50;

    static {
        AppMethodBeat.i(229301);
        AppMethodBeat.o(229301);
    }

    private d() {
    }

    @Override // com.tencent.mm.plugin.appbrand.report.x
    public final void a(fcq fcq) {
        int size;
        MTimerHandler mTimerHandler;
        AppMethodBeat.i(229299);
        Log.i("Luggage.AppBrandIDKeyBatchReportNew", "writeIDKeyData type:" + fcq.oUv);
        synchronized (nGB) {
            try {
                nGB.addLast(fcq);
                size = nGB.size();
            } finally {
                AppMethodBeat.o(229299);
            }
        }
        if (size >= nGz) {
            aB("writeIDKeyData", true);
            AppMethodBeat.o(229299);
            return;
        }
        synchronized (nGD) {
            try {
                if (nGC == null || ((mTimerHandler = nGC) != null && mTimerHandler.stopped())) {
                    MTimerHandler mTimerHandler2 = new MTimerHandler("Luggage.AppBrandIDKeyBatchReportNew", (MTimerHandler.CallBack) new c(), true);
                    long j2 = nGA;
                    mTimerHandler2.startTimer(j2, j2);
                    nGC = mTimerHandler2;
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(229299);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.report.x
    public final void ce(String str, int i2) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/appbrand/report/AppBrandIDKeyBatchReportNew$startTimer$1$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-appbrand-integration_release"})
    public static final class c implements MTimerHandler.CallBack {
        c() {
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(229298);
            d dVar = d.nGE;
            boolean aB = d.aB("onTimerExpired", false);
            AppMethodBeat.o(229298);
            return aB;
        }
    }

    public static boolean aB(String str, boolean z) {
        LinkedList linkedList;
        boolean z2;
        AppMethodBeat.i(229300);
        p.h(str, "reason");
        if (z) {
            synchronized (nGD) {
                try {
                    MTimerHandler mTimerHandler = nGC;
                    if (mTimerHandler != null) {
                        mTimerHandler.stopTimer();
                    }
                    nGC = null;
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(229300);
                    throw th;
                }
            }
        }
        synchronized (nGB) {
            try {
                linkedList = new LinkedList(nGB);
                nGB.clear();
            } catch (Throwable th2) {
                AppMethodBeat.o(229300);
                throw th2;
            }
        }
        Log.i("Luggage.AppBrandIDKeyBatchReportNew", "reportNow, reason=" + str + ", reportList.size=" + linkedList.size());
        if (linkedList.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.o(229300);
            return false;
        }
        fcl fcl = new fcl();
        dnf dnf = new dnf();
        dnf.oUj = Build.MANUFACTURER;
        dnf.MQy = 2;
        dnf.hid = com.tencent.mm.protocal.d.KyJ;
        dnf.hie = com.tencent.mm.protocal.d.KyI;
        Resources resources = MMApplicationContext.getResources();
        p.g(resources, "MMApplicationContext.getResources()");
        dnf.Dqw = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = MMApplicationContext.getResources();
        p.g(resources2, "MMApplicationContext.getResources()");
        dnf.MQz = resources2.getDisplayMetrics().heightPixels;
        dnf.hif = com.tencent.mm.protocal.d.KyL;
        dnf.hig = com.tencent.mm.protocal.d.KyM;
        Resources resources3 = MMApplicationContext.getResources();
        p.g(resources3, "MMApplicationContext.getResources()");
        Locale locale = resources3.getConfiguration().locale;
        p.g(locale, "MMApplicationContext.get…es().configuration.locale");
        dnf.pLl = locale.getLanguage();
        fcl.Nyq = dnf;
        fcl.Nyp.addAll(linkedList);
        ((com.tencent.mm.plugin.appbrand.networking.c) e.M(com.tencent.mm.plugin.appbrand.networking.c.class)).a(nGy, fcl, fcm.class).a(new a(str, linkedList)).a(new b(str, linkedList));
        AppMethodBeat.o(229300);
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onInterrupt"})
    public static final class b<T> implements d.a<Object> {
        final /* synthetic */ String nGF;
        final /* synthetic */ LinkedList nGG;

        b(String str, LinkedList linkedList) {
            this.nGF = str;
            this.nGG = linkedList;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(229297);
            Log.e("Luggage.AppBrandIDKeyBatchReportNew", "reportNow, reason=" + this.nGF + ", reportList.size=" + this.nGG.size() + ", cgi error " + (obj != null ? obj.toString() : null));
            d dVar = d.nGE;
            synchronized (d.nGB) {
                try {
                    d dVar2 = d.nGE;
                    d.nGB.addAll(this.nGG);
                } catch (Throwable th) {
                    AppMethodBeat.o(229297);
                    throw th;
                }
            }
            this.nGG.clear();
            AppMethodBeat.o(229297);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/WxaAppIDKeyBatchReportResponse;", "kotlin.jvm.PlatformType", "onTerminate"})
    public static final class a<T> implements d.b<fcm> {
        final /* synthetic */ String nGF;
        final /* synthetic */ LinkedList nGG;

        a(String str, LinkedList linkedList) {
            this.nGF = str;
            this.nGG = linkedList;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.g.d.b
        public final /* synthetic */ void bz(fcm fcm) {
            AppMethodBeat.i(229296);
            Log.i("Luggage.AppBrandIDKeyBatchReportNew", "reportNow, reason=" + this.nGF + ", reportList.size=" + this.nGG.size() + ", cgi back ok");
            this.nGG.clear();
            AppMethodBeat.o(229296);
        }
    }
}
