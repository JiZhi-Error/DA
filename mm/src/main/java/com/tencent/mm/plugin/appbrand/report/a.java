package com.tencent.mm.plugin.appbrand.report;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0012\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0013JA\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0012\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u0015H\u0007J\u0016\u0010\u001b\u001a\u00020\u0015*\u00020\u001c2\b\b\u0002\u0010\u001a\u001a\u00020\u0015H\u0003J\u0016\u0010\u001d\u001a\u00020\u000f*\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\nH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandCrossProcessSafeReporter;", "", "()V", "DEFAULT_REPORT_INTERVAL", "", "H", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "MSG_REPORT", "", "TAG", "", "reportCacheList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportStruct;", "kvStat", "", "logID", "vals", "", "(I[Ljava/lang/Object;)V", "isReportNow", "", "isImportant", "ignoreFreqLimit", "(IZZZ[Ljava/lang/Object;)V", "reportAll", "sync", "reportIPC", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "reportMM", "scene", "plugin-appbrand-integration_release"})
public final class a {
    private static final MMHandler mQp = new MMHandler("AppBrandCrossProcessSafeReporter$H", C0791a.nFY);
    private static final LinkedList<eq> nFV = new LinkedList<>();
    private static final int nFW;
    public static final a nFX;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "data", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "invoke"})
    public static final class b<InputType, ResultType> implements k<ep, IPCVoid> {
        public static final b nFZ = new b();

        static {
            AppMethodBeat.i(229288);
            AppMethodBeat.o(229288);
        }

        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCVoid invoke(ep epVar) {
            AppMethodBeat.i(229287);
            a aVar = a.nFX;
            a.a(epVar, "ipcInvokeMMSync");
            IPCVoid iPCVoid = IPCVoid.hnE;
            AppMethodBeat.o(229287);
            return iPCVoid;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/protocal/protobuf/AppBrandCrossProcessKVReportListStruct;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    public static final class c<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<ep, IPCVoid> {
        public static final c nGa = new c();

        static {
            AppMethodBeat.i(229290);
            AppMethodBeat.o(229290);
        }

        c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(ep epVar, d<IPCVoid> dVar) {
            AppMethodBeat.i(229289);
            a aVar = a.nFX;
            a.a(epVar, "ipcInvokeMM");
            AppMethodBeat.o(229289);
        }
    }

    static {
        AppMethodBeat.i(51002);
        a aVar = new a();
        nFX = aVar;
        nFW = aVar.hashCode();
        AppMethodBeat.o(51002);
    }

    private a() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    /* renamed from: com.tencent.mm.plugin.appbrand.report.a$a  reason: collision with other inner class name */
    static final class C0791a implements MMHandler.Callback {
        public static final C0791a nFY = new C0791a();

        static {
            AppMethodBeat.i(229286);
            AppMethodBeat.o(229286);
        }

        C0791a() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(229285);
            int i2 = message.what;
            a aVar = a.nFX;
            if (i2 == a.nFW) {
                a.bUe();
            }
            AppMethodBeat.o(229285);
            return true;
        }
    }

    public static /* synthetic */ void bUe() {
        AppMethodBeat.i(229292);
        iA(false);
        AppMethodBeat.o(229292);
    }

    public static final void iA(boolean z) {
        ep epVar;
        AppMethodBeat.i(229291);
        synchronized (nFV) {
            try {
                epVar = new ep();
                epVar.gCs.addAll(nFV);
                nFV.clear();
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(229291);
                throw th;
            }
        }
        a(epVar, z);
        AppMethodBeat.o(229291);
    }

    private static boolean a(ep epVar, boolean z) {
        AppMethodBeat.i(229293);
        LinkedList<eq> linkedList = epVar.gCs;
        if (linkedList == null || linkedList.isEmpty()) {
            AppMethodBeat.o(229293);
            return false;
        }
        if (z) {
            com.tencent.mm.ipcinvoker.wx_extension.b.a.a(epVar, b.nFZ);
        } else {
            com.tencent.mm.ipcinvoker.wx_extension.b.a.a(epVar, c.nGa, null);
        }
        AppMethodBeat.o(229293);
        return true;
    }

    public static void a(int i2, boolean z, boolean z2, boolean z3, Object... objArr) {
        AppMethodBeat.i(229294);
        p.h(objArr, "vals");
        if (MMApplicationContext.isMainProcess()) {
            h hVar = h.INSTANCE;
            String u = h.u(Arrays.copyOf(objArr, objArr.length));
            h hVar2 = h.INSTANCE;
            h.c(i2, u, z, z3);
            AppMethodBeat.o(229294);
            return;
        }
        ep epVar = null;
        synchronized (nFV) {
            try {
                LinkedList<eq> linkedList = nFV;
                eq eqVar = new eq();
                eqVar.KAy = i2;
                h hVar3 = h.INSTANCE;
                eqVar.value = h.u(Arrays.copyOf(objArr, objArr.length));
                eqVar.Cyr = z;
                eqVar.CxY = z2;
                eqVar.Cys = z3;
                linkedList.add(eqVar);
                if (nFV.size() >= 1000) {
                    ep epVar2 = new ep();
                    epVar2.gCs.addAll(nFV);
                    nFV.clear();
                    epVar = epVar2;
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(229294);
            }
        }
        if (epVar == null || !a(epVar, false)) {
            if (!mQp.hasMessages(nFW)) {
                mQp.sendEmptyMessageDelayed(nFW, 10000);
            }
            return;
        }
        mQp.removeMessages(nFW);
        mQp.sendEmptyMessageDelayed(nFW, 10000);
        AppMethodBeat.o(229294);
    }

    public final void a(int i2, Object... objArr) {
        AppMethodBeat.i(51001);
        p.h(objArr, "vals");
        a(i2, false, false, false, Arrays.copyOf(objArr, objArr.length));
        AppMethodBeat.o(51001);
    }

    public static final /* synthetic */ void a(ep epVar, String str) {
        LinkedList<eq> linkedList;
        AppMethodBeat.i(229295);
        if (epVar != null) {
            linkedList = epVar.gCs;
        } else {
            linkedList = null;
        }
        List<eq> list = linkedList;
        if (list == null) {
            list = v.SXr;
        }
        if (Log.getLogLevel() <= 1) {
            Log.d("MicroMsg.AppBrandCrossProcessSafeReporter", "reportMM scene:" + str + ", size:" + list.size());
        }
        for (eq eqVar : list) {
            try {
                h hVar = h.INSTANCE;
                h.c(eqVar.KAy, eqVar.value, eqVar.Cyr, eqVar.Cys);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandCrossProcessSafeReporter", "reportMM logid=" + eqVar.KAy + ", e=" + e2);
            }
        }
        AppMethodBeat.o(229295);
    }
}
