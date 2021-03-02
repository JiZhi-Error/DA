package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.jsapi.w.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.dqf;
import com.tencent.mm.protocal.protobuf.dqg;
import com.tencent.mm.protocal.protobuf.fed;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001:\u0005*+,-.B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u0010\u001b\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J.\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue;", "", "()V", "PER_SLICE_SIZE_LIMIT", "", "REPORT_PERIOD_INTERVAL", "REQUEST_DIAGNOSE_ID", "REQUEST_DIAGNOSE_KEY_BATCH_COUNT", "REQUEST_DIAGNOSE_KEY_BATCH_SUCCESS_COUNT", "REQUEST_DIAGNOSE_KEY_DEQUEUE", "REQUEST_DIAGNOSE_KEY_ENQUEUE", "REQUEST_DIAGNOSE_KEY_UPLOADED", "TAG", "", "attachedRuntimes", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "Lkotlin/collections/HashSet;", "bufferQueue", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "lastDoCgiTick", "periodTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "detachCaller", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "doCgi", "queue", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "reason", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "enqueueReportData", "id", "", "type", "content", DownloadInfo.PRIORITY, "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "mayReportOnForeground", "triggerReport", "BufferQueue", "BufferQueueAIO", "CGIReason", "Entry", "IBufferQueue", "plugin-appbrand-integration_release"})
final class h {
    private static final long mpk = TimeUnit.MINUTES.toMillis(5);
    private static final MTimerHandler mpl = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) g.mpF, true);
    private static final HashSet<q> mpm = new HashSet<>();
    private static final b mpn = new b();
    private static long mpo;
    public static final h mpp = new h();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "", "(Ljava/lang/String;I)V", "TIMER_PERIOD", "REACH_SLICE_LIMIT", "RUNTIME_KILLED", "IMMEDIATE", "plugin-appbrand-integration_release"})
    public enum c {
        TIMER_PERIOD,
        REACH_SLICE_LIMIT,
        RUNTIME_KILLED,
        IMMEDIATE;

        static {
            AppMethodBeat.i(50680);
            AppMethodBeat.o(50680);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(50682);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(50682);
            return cVar;
        }
    }

    static {
        AppMethodBeat.i(50694);
        AppMethodBeat.o(50694);
    }

    private h() {
    }

    public static final /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(228506);
        hVar.bIA();
        AppMethodBeat.o(228506);
    }

    public static final /* synthetic */ void a(h hVar, c cVar) {
        AppMethodBeat.i(228505);
        hVar.a(cVar);
        AppMethodBeat.o(228505);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class g implements MTimerHandler.CallBack {
        public static final g mpF = new g();

        static {
            AppMethodBeat.i(50690);
            AppMethodBeat.o(50690);
        }

        g() {
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(50689);
            h.a(h.mpp, c.TIMER_PERIOD);
            AppMethodBeat.o(50689);
            return true;
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.d dVar, int i2, int i3, String str, c.EnumC0721c cVar) {
        AppMethodBeat.i(50691);
        p.h(dVar, "component");
        p.h(str, "content");
        p.h(cVar, DownloadInfo.PRIORITY);
        synchronized (mpm) {
            try {
                HashSet<q> hashSet = mpm;
                AppBrandRuntime runtime = dVar.getRuntime();
                if (runtime == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
                    AppMethodBeat.o(50691);
                    throw tVar;
                }
                boolean add = hashSet.add((q) runtime);
                if (add && mpm.size() == 1) {
                    mpl.startTimer(mpk);
                }
                if (add) {
                    AppBrandRuntime runtime2 = dVar.getRuntime();
                    p.g(runtime2, "component.runtime");
                    runtime2.brl().a(new f(dVar));
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(50691);
            }
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(1074, 0);
        synchronized (this) {
            try {
                mpn.a(new d(i2, i3, str, cVar, dVar));
                switch (i.haE[cVar.ordinal()]) {
                    case 1:
                        mpp.a(mpn.bIC(), c.IMMEDIATE);
                        break;
                    default:
                        a[] aVarArr = mpn.mpv;
                        ArrayList arrayList = new ArrayList(aVarArr.length);
                        for (a aVar : aVarArr) {
                            arrayList.add(Long.valueOf(aVar.size()));
                        }
                        if (j.C(arrayList) >= 65536) {
                            mpp.a(mpn.bIC(), c.REACH_SLICE_LIMIT);
                            break;
                        }
                        break;
                }
                x xVar2 = x.SXb;
            } finally {
                AppMethodBeat.o(50691);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "onRunningStateChanged", "com/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$enqueueReportData$1$1"})
    public static final class f implements c.a {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d mpE;

        f(com.tencent.mm.plugin.appbrand.d dVar) {
            this.mpE = dVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.a.c.a
        public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
            AppMethodBeat.i(50688);
            if (bVar == null) {
                AppMethodBeat.o(50688);
                return;
            }
            switch (i.$EnumSwitchMapping$0[bVar.ordinal()]) {
                case 1:
                    h.a(h.mpp, c.RUNTIME_KILLED);
                    h hVar = h.mpp;
                    h.f(this.mpE);
                    AppMethodBeat.o(50688);
                    return;
                case 2:
                    h.a(h.mpp);
                    break;
            }
            AppMethodBeat.o(50688);
        }
    }

    private final void a(c cVar) {
        AppMethodBeat.i(50692);
        a(mpn.bIC(), cVar);
        AppMethodBeat.o(50692);
    }

    private final synchronized void bIA() {
        AppMethodBeat.i(228504);
        if (mpo > 0 && Util.ticksToNow(mpo) >= mpk) {
            a(c.TIMER_PERIOD);
        }
        AppMethodBeat.o(228504);
    }

    private final synchronized void a(List<d> list, c cVar) {
        AppMethodBeat.i(50693);
        mpl.startTimer(mpk);
        mpo = Util.currentTicks();
        Log.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "doCgi queue.size=" + list.size() + ", reason=" + cVar.name());
        List<d> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            AppMethodBeat.o(50693);
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1074, 1, (long) list.size());
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(1074, 4);
            d.a aVar = new d.a();
            aVar.MB("/cgi-bin/mmbiz-bin/wxartrappsvr/route");
            aVar.sG(2946);
            dqf dqf = new dqf();
            for (T t : list) {
                LinkedList<fed> linkedList = dqf.MTn;
                fed fed = new fed();
                fed.type = t.type;
                fed.Lqh = com.tencent.mm.bw.b.bfZ(t.content);
                fed.dNI = t.appId;
                linkedList.add(fed);
            }
            aVar.c(dqf);
            aVar.d(new dqg());
            IPCRunCgi.a(aVar.aXF(), new e(list));
            AppMethodBeat.o(50693);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    public static final class e implements IPCRunCgi.a {
        final /* synthetic */ List mpC;

        e(List list) {
            this.mpC = list;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(50687);
            Log.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "onCgiBack, errType=" + i2 + ", errCode=" + i3 + ", errMsg=" + str);
            final WeakHashMap weakHashMap = new WeakHashMap();
            AnonymousClass1 r2 = new m<com.tencent.mm.plugin.appbrand.jsapi.f, d, x>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.w.h.e.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(com.tencent.mm.plugin.appbrand.jsapi.f fVar, d dVar) {
                    AppMethodBeat.i(50685);
                    a(fVar, dVar);
                    x xVar = x.SXb;
                    AppMethodBeat.o(50685);
                    return xVar;
                }

                public final void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, d dVar) {
                    AppMethodBeat.i(50686);
                    p.h(dVar, "entry");
                    if (fVar != null) {
                        LinkedList linkedList = (LinkedList) weakHashMap.get(fVar);
                        if (linkedList == null) {
                            LinkedList linkedList2 = new LinkedList();
                            weakHashMap.put(fVar, linkedList2);
                            linkedList = linkedList2;
                        }
                        linkedList.addLast(dVar);
                    }
                    AppMethodBeat.o(50686);
                }
            };
            if (i2 == 0 && i3 == 0) {
                for (d dVar2 : this.mpC) {
                    r2.a(dVar2.NN(), dVar2);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1074, 2, (long) this.mpC.size());
                com.tencent.mm.plugin.report.service.h.INSTANCE.F(1074, 5);
            } else {
                int i4 = 0;
                for (d dVar3 : this.mpC) {
                    h hVar = h.mpp;
                    if (!h.mpn.a(dVar3)) {
                        r2.a(dVar3.NN(), dVar3);
                    } else {
                        i4++;
                    }
                }
                if (i4 > 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1074, 0, (long) i4);
                }
            }
            Set<Map.Entry> entrySet = weakHashMap.entrySet();
            p.g(entrySet, "component2EntryMap.entries");
            for (Map.Entry entry : entrySet) {
                com.tencent.mm.plugin.appbrand.jsapi.f fVar = (com.tencent.mm.plugin.appbrand.jsapi.f) entry.getKey();
                if (fVar != null) {
                    s g2 = new c.b().g(fVar);
                    HashMap hashMap = new HashMap();
                    hashMap.put("errcode", Integer.valueOf(i2 == 0 ? i3 : -9999));
                    hashMap.put("errmsg", str);
                    Object value = entry.getValue();
                    p.g(value, "entry.value");
                    Iterable<d> iterable = (Iterable) value;
                    ArrayList arrayList = new ArrayList(j.a(iterable, 10));
                    for (d dVar4 : iterable) {
                        arrayList.add(Long.valueOf((long) dVar4.content.length()));
                    }
                    hashMap.put("dataSize", Long.valueOf(j.C(arrayList)));
                    Object value2 = entry.getValue();
                    p.g(value2, "entry.value");
                    Iterable<d> iterable2 = (Iterable) value2;
                    ArrayList arrayList2 = new ArrayList(j.a(iterable2, 10));
                    for (d dVar5 : iterable2) {
                        arrayList2.add(Integer.valueOf(dVar5.id));
                    }
                    hashMap.put("idList", new JSONArray((Collection) j.p(arrayList2)));
                    g2.L(hashMap).bEo();
                }
            }
            AppMethodBeat.o(50687);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "", "id", "", "type", "content", "", DownloadInfo.PRIORITY, "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(IILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "appId", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "componentRef", "Ljava/lang/ref/WeakReference;", "componentRef$annotations", "()V", "getContent", "getId", "()I", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "triedCount", "getTriedCount", "setTriedCount", "(I)V", "getType", "plugin-appbrand-integration_release"})
    public static final class d {
        final String appId;
        final String content;
        private final WeakReference<com.tencent.mm.plugin.appbrand.jsapi.f> dps;
        final int id;
        int mpB;
        final c.EnumC0721c mps;
        final int type;

        public d(int i2, int i3, String str, c.EnumC0721c cVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
            p.h(str, "content");
            p.h(cVar, DownloadInfo.PRIORITY);
            p.h(fVar, "component");
            AppMethodBeat.i(50684);
            this.id = i2;
            this.type = i3;
            this.content = str;
            this.mps = cVar;
            this.dps = new WeakReference<>(fVar);
            String appId2 = fVar.getAppId();
            p.g(appId2, "component.appId");
            this.appId = appId2;
            AppMethodBeat.o(50684);
        }

        public final com.tencent.mm.plugin.appbrand.jsapi.f NN() {
            AppMethodBeat.i(50683);
            com.tencent.mm.plugin.appbrand.jsapi.f fVar = this.dps.get();
            AppMethodBeat.o(50683);
            return fVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "()V", "typedQueues", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "poll", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "bytes", "", "push", "", "entry", "size", "plugin-appbrand-integration_release"})
    public static final class b {
        final a[] mpv = {new a(c.EnumC0721c.IMMEDIATE, 3), new a(c.EnumC0721c.HIGH, 3), new a(c.EnumC0721c.LOW, 1)};

        public b() {
            AppMethodBeat.i(50679);
            AppMethodBeat.o(50679);
        }

        public final boolean a(d dVar) {
            AppMethodBeat.i(50677);
            p.h(dVar, "entry");
            a[] aVarArr = this.mpv;
            for (a aVar : aVarArr) {
                if (aVar.mps == dVar.mps) {
                    boolean a2 = aVar.a(dVar);
                    AppMethodBeat.o(50677);
                    return a2;
                }
            }
            AppMethodBeat.o(50677);
            return false;
        }

        public final List<d> bIC() {
            AppMethodBeat.i(50678);
            LinkedList linkedList = new LinkedList();
            long j2 = 0;
            a[] aVarArr = this.mpv;
            for (a aVar : aVarArr) {
                long size = aVar.size();
                linkedList.addAll(aVar.Bh(65536 - j2));
                j2 += size - aVar.size();
            }
            LinkedList linkedList2 = linkedList;
            AppMethodBeat.o(50678);
            return linkedList2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", DownloadInfo.PRIORITY, "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "requestTryCountLimit", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;I)V", "bytesCount", "", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "queueImpl", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "getRequestTryCountLimit", "()I", "poll", "", "_bytes", "push", "", "entry", "size", "Companion", "plugin-appbrand-integration_release"})
    public static final class a {
        @Deprecated
        public static final C0722a mpu = new C0722a((byte) 0);
        private final LinkedList<d> mpq = new LinkedList<>();
        private long mpr;
        final c.EnumC0721c mps;
        private final int mpt;

        static {
            AppMethodBeat.i(50676);
            AppMethodBeat.o(50676);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.w.h$a$a  reason: collision with other inner class name */
        static final class C0722a {
            private C0722a() {
            }

            public /* synthetic */ C0722a(byte b2) {
                this();
            }
        }

        public a(c.EnumC0721c cVar, int i2) {
            p.h(cVar, DownloadInfo.PRIORITY);
            AppMethodBeat.i(50675);
            this.mps = cVar;
            this.mpt = i2;
            AppMethodBeat.o(50675);
        }

        public final List<d> Bh(long j2) {
            long j3;
            v vVar;
            AppMethodBeat.i(50674);
            synchronized (this.mpq) {
                try {
                    if (this.mpq.isEmpty()) {
                        vVar = v.SXr;
                    } else {
                        if (j2 < 0) {
                            j3 = (long) this.mpq.peekFirst().content.length();
                        } else {
                            j3 = j2;
                        }
                        LinkedList linkedList = new LinkedList();
                        long j4 = j3;
                        while (!this.mpq.isEmpty() && j4 > 0) {
                            d pollFirst = this.mpq.pollFirst();
                            d dVar = pollFirst;
                            dVar.mpB++;
                            j4 -= (long) dVar.content.length();
                            linkedList.addLast(pollFirst);
                        }
                        this.mpr -= j3 - j4;
                        if (this.mpr < 0) {
                            Log.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "[" + this.mps.name() + "] poll(" + j3 + ") final bytesCount becomes minus");
                            this.mpr = 0;
                        }
                        vVar = linkedList;
                        AppMethodBeat.o(50674);
                    }
                } finally {
                    AppMethodBeat.o(50674);
                }
            }
            return vVar;
        }

        public final long size() {
            long j2;
            synchronized (this.mpq) {
                j2 = this.mpr;
            }
            return j2;
        }

        public final boolean a(d dVar) {
            AppMethodBeat.i(50673);
            p.h(dVar, "entry");
            if (dVar.mpB > this.mpt) {
                Log.e("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", "push reach TryCountLimit priority[" + this.mps.name() + "], entry[" + dVar.appId + ", " + dVar.id + ", " + dVar.type + ']');
                AppMethodBeat.o(50673);
                return false;
            }
            synchronized (this.mpq) {
                try {
                    this.mpq.addLast(dVar);
                    this.mpr += (long) dVar.content.length();
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(50673);
                    throw th;
                }
            }
            AppMethodBeat.o(50673);
            return true;
        }
    }

    public static final /* synthetic */ void f(com.tencent.mm.plugin.appbrand.d dVar) {
        AppMethodBeat.i(50696);
        synchronized (mpm) {
            try {
                HashSet<q> hashSet = mpm;
                AppBrandRuntime runtime = dVar.getRuntime();
                if (runtime == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
                    AppMethodBeat.o(50696);
                    throw tVar;
                }
                hashSet.remove((q) runtime);
                if (mpm.size() == 0) {
                    mpl.stopTimer();
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(50696);
            }
        }
    }
}
