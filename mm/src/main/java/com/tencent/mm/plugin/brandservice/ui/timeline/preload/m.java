package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.__BATCH_RUN_OBJ;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.ad;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.bu;

public final class m {
    private static final String TAG = TAG;
    private static final String dkO = ToolsMpProcessIPCService.dkO;
    private static final AtomicBoolean dxh = new AtomicBoolean(false);
    private static final AtomicBoolean pCM = new AtomicBoolean(false);
    private static final MMKVSlotManager pCN = new MMKVSlotManager(u.coo(), 0, 2, null);
    private static final MMFileSlotManager pCO = new MMFileSlotManager("webcached", 0, 2, null);
    private static final l pCP = new l();
    private static final HashMap<Integer, Boolean> pCQ = new HashMap<>();
    private static final a pCR = new a();
    private static final kotlin.f pCS = kotlin.g.ah(g.pCX);
    private static final boolean pCT;
    public static final m pCU = new m();

    public static ConcurrentHashMap<String, ConcurrentLinkedDeque<kotlin.g.a.b<Bundle, x>>> cog() {
        AppMethodBeat.i(6707);
        ConcurrentHashMap<String, ConcurrentLinkedDeque<kotlin.g.a.b<Bundle, x>>> concurrentHashMap = (ConcurrentHashMap) pCS.getValue();
        AppMethodBeat.o(6707);
        return concurrentHashMap;
    }

    public static final class f extends kotlin.g.b.q implements kotlin.g.a.m<c, kf, x> {
        final /* synthetic */ List pCW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(List list) {
            super(2);
            this.pCW = list;
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(c cVar, kf kfVar) {
            int i2;
            String str;
            Integer num = null;
            AppMethodBeat.i(6660);
            c cVar2 = cVar;
            kf kfVar2 = kfVar;
            kotlin.g.b.p.h(cVar2, "result");
            kotlin.g.b.p.h(kfVar2, "response");
            if (cVar2.isSuccess) {
                m mVar = m.pCU;
                String str2 = m.TAG;
                StringBuilder sb = new StringBuilder("response.AppMsgContextList size:");
                LinkedList<fn> linkedList = kfVar2.KOA;
                Log.i(str2, sb.append(linkedList != null ? Integer.valueOf(linkedList.size()) : null).toString());
                com.tencent.mm.plugin.webview.h.d dVar = new com.tencent.mm.plugin.webview.h.d();
                dVar.startTime = cVar2.start;
                List list = this.pCW;
                if (list != null) {
                    num = Integer.valueOf(list.size());
                }
                dVar.gVP = num.intValue();
                LinkedList<fn> linkedList2 = kfVar2.KOA;
                if (linkedList2 != null) {
                    for (T t : linkedList2) {
                        if (t == null || (str = t.Url) == null || !UrlExKt.isMpUrl(str)) {
                            m mVar2 = m.pCU;
                            Log.e(m.TAG, "batchSyncAppMsgContext no Url response");
                        } else {
                            m mVar3 = m.pCU;
                            String str3 = m.TAG;
                            StringBuilder append = new StringBuilder("appMsgContext url:").append(t.Url).append(" content:");
                            String str4 = t.iAc;
                            Log.v(str3, append.append(str4 != null ? str4.length() : 0).append(" clientCacheTime:").append(t.KIQ).append(" forceUrl:").append(t.KIR).append(" lastModifyTime:").append(t.KIS).append(" noNeedUpdate:").append(t.KIT).toString());
                            m mVar4 = m.pCU;
                            a cof = m.cof();
                            String str5 = t.Url;
                            kotlin.g.b.p.g(str5, "Url");
                            cof.a(str5, t);
                            com.tencent.mm.plugin.brandservice.b.g gVar = com.tencent.mm.plugin.brandservice.b.g.pnw;
                            String str6 = t.Url;
                            kotlin.g.b.p.g(str6, "Url");
                            if (com.tencent.mm.plugin.brandservice.b.g.ahK(str6)) {
                                String str7 = t.Url;
                                kotlin.g.b.p.g(str7, "Url");
                                com.tencent.mm.plugin.brandservice.b.g gVar2 = com.tencent.mm.plugin.brandservice.b.g.pnw;
                                c.fg(str7, com.tencent.mm.plugin.brandservice.b.g.U(t.KIV, t.Brl, t.KIW));
                            }
                            if (!cVar2.pBY) {
                                if (t.KIT) {
                                    dVar.gdL();
                                    com.tencent.mm.plugin.webview.h.a.pl(31);
                                } else {
                                    dVar.gdK();
                                    com.tencent.mm.plugin.webview.h.a.pl(32);
                                }
                                dVar.agj(t.computeSize());
                            }
                            m mVar5 = m.pCU;
                            Log.d(m.TAG, "terry trace: preloaded " + t.Url);
                        }
                    }
                }
                dVar.report();
            } else {
                m mVar6 = m.pCU;
                Log.w(m.TAG, "terry trace: preloaded fail");
            }
            if (!cVar2.pBY) {
                com.tencent.mm.plugin.webview.h.a.pl(23);
                com.tencent.mm.plugin.webview.h.a.kh(26, this.pCW.size());
                if (cVar2.isSuccess) {
                    i2 = 24;
                } else {
                    i2 = 25;
                }
                com.tencent.mm.plugin.webview.h.a.pl(i2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(6660);
            return xVar;
        }
    }

    public static final class i<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<Bundle, IPCVoid> {
        public static final i pCZ = new i();

        static {
            AppMethodBeat.i(195624);
            AppMethodBeat.o(195624);
        }

        i() {
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(195623);
            Bundle bundle2 = bundle;
            int i2 = bundle2.getInt("openScene", 10000);
            String string = bundle2.getString(DownloadInfo.NETTYPE, "unknown");
            kotlin.g.b.p.g(string, DownloadInfo.NETTYPE);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.a(i2, string, new int[0]);
            AppMethodBeat.o(195623);
        }
    }

    public static final class j extends kotlin.g.b.q implements kotlin.g.a.q<WeakReference<Object>, c, fn, x> {
        public static final j pDa = new j();

        static {
            AppMethodBeat.i(6664);
            AppMethodBeat.o(6664);
        }

        j() {
            super(3);
        }

        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(WeakReference<Object> weakReference, c cVar, fn fnVar) {
            AppMethodBeat.i(6663);
            kotlin.g.b.p.h(weakReference, "<anonymous parameter 0>");
            kotlin.g.b.p.h(cVar, "<anonymous parameter 1>");
            kotlin.g.b.p.h(fnVar, "<anonymous parameter 2>");
            x xVar = x.SXb;
            AppMethodBeat.o(6663);
            return xVar;
        }
    }

    public static final class k extends kotlin.g.b.q implements kotlin.g.a.m<c, kf, x> {
        final /* synthetic */ String pDb;
        final /* synthetic */ kotlin.g.a.q pDc;
        final /* synthetic */ WeakReference pDd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(String str, kotlin.g.a.q qVar, WeakReference weakReference) {
            super(2);
            this.pDb = str;
            this.pDc = qVar;
            this.pDd = weakReference;
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(c cVar, kf kfVar) {
            int i2;
            Boolean bool = null;
            AppMethodBeat.i(6665);
            c cVar2 = cVar;
            kf kfVar2 = kfVar;
            kotlin.g.b.p.h(cVar2, "result");
            kotlin.g.b.p.h(kfVar2, "response");
            if (cVar2.isSuccess) {
                LinkedList<fn> linkedList = kfVar2.KOA;
                if (linkedList != null) {
                    ArrayList arrayList = new ArrayList();
                    for (T t : linkedList) {
                        T t2 = t;
                        String str = t2 != null ? t2.Url : null;
                        if (!(str == null || str.length() == 0)) {
                            arrayList.add(t);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    fn fnVar = !arrayList2.isEmpty() ? (fn) arrayList2.get(0) : null;
                    if (fnVar != null) {
                        m mVar = m.pCU;
                        Log.i(m.TAG, "[findAppMsgContext] url:%s", this.pDb);
                        if (!cVar2.pBY) {
                            m mVar2 = m.pCU;
                            a cof = m.cof();
                            String str2 = fnVar.Url;
                            kotlin.g.b.p.g(str2, "appMsgContext.Url");
                            cof.a(str2, fnVar);
                            com.tencent.mm.plugin.webview.h.d dVar = new com.tencent.mm.plugin.webview.h.d();
                            dVar.startTime = cVar2.start;
                            dVar.endTime = cVar2.boX;
                            dVar.gVP = 1;
                            if (fnVar.KIT) {
                                dVar.gdL();
                                com.tencent.mm.plugin.webview.h.a.pl(31);
                            } else {
                                dVar.gdK();
                                com.tencent.mm.plugin.webview.h.a.pl(32);
                            }
                            dVar.agj(fnVar.computeSize());
                            dVar.report();
                        }
                        this.pDc.d(this.pDd, cVar2, fnVar);
                        bool = Boolean.TRUE;
                    }
                }
                if (!kotlin.g.b.p.j(bool, Boolean.TRUE)) {
                    cVar2.isSuccess = false;
                    this.pDc.d(this.pDd, cVar2, new fn());
                }
            } else {
                this.pDc.d(this.pDd, cVar2, new fn());
            }
            if (!cVar2.pBY) {
                com.tencent.mm.plugin.webview.h.a.pl(20);
                com.tencent.mm.plugin.webview.h.a.pl(26);
                if (cVar2.isSuccess) {
                    i2 = 24;
                } else {
                    i2 = 25;
                }
                com.tencent.mm.plugin.webview.h.a.pl(i2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(6665);
            return xVar;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.m$m */
    public static final class C0889m<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCInteger, IPCVoid> {
        public static final C0889m pDe = new C0889m();

        static {
            AppMethodBeat.i(195626);
            AppMethodBeat.o(195626);
        }

        C0889m() {
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCInteger iPCInteger, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(195625);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.pGQ;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.DH(iPCInteger.value);
            AppMethodBeat.o(195625);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class n<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        public static final n pDf = new n();

        static {
            AppMethodBeat.i(195628);
            AppMethodBeat.o(195628);
        }

        n() {
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(195627);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c.aij(iPCString.value);
            AppMethodBeat.o(195627);
        }
    }

    public static final class o extends kotlin.g.b.q implements kotlin.g.a.b<Bundle, x> {
        final /* synthetic */ kotlin.g.a.m nzd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(kotlin.g.a.m mVar) {
            super(1);
            this.nzd = mVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bundle bundle) {
            AppMethodBeat.i(6677);
            Bundle bundle2 = bundle;
            kotlin.g.b.p.h(bundle2, LocaleUtil.ITALIAN);
            m mVar = m.pCU;
            m.a(bundle2, this.nzd);
            x xVar = x.SXb;
            AppMethodBeat.o(6677);
            return xVar;
        }
    }

    public static final class p<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ kotlin.g.a.m nzd;

        p(kotlin.g.a.m mVar) {
            this.nzd = mVar;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(6678);
            Bundle bundle = (Bundle) obj;
            m mVar = m.pCU;
            kotlin.g.b.p.g(bundle, "bundle");
            m.a(bundle, this.nzd);
            AppMethodBeat.o(6678);
        }
    }

    public static final class s extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ boolean pDj;
        final /* synthetic */ String pDk;
        final /* synthetic */ dei pDl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(boolean z, String str, dei dei) {
            super(0);
            this.pDj = z;
            this.pDk = str;
            this.pDl = dei;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(6681);
            String bAa = bAa();
            AppMethodBeat.o(6681);
            return bAa;
        }

        public final String bAa() {
            if (this.pDj) {
                switch (this.pDl.iwc) {
                    case 5:
                        return "brandservice";
                }
            }
            return this.pDk;
        }
    }

    public static final class t extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ boolean pDj;
        final /* synthetic */ dei pDl;
        final /* synthetic */ String pDm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(boolean z, String str, dei dei) {
            super(0);
            this.pDj = z;
            this.pDm = str;
            this.pDl = dei;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(6682);
            String bAa = bAa();
            AppMethodBeat.o(6682);
            return bAa;
        }

        public final String bAa() {
            if (!this.pDj || this.pDl.iwc != 5) {
                return this.pDm;
            }
            return ".ui.timeline.video.BizVideoDetailUI";
        }
    }

    public static final class u extends kotlin.g.b.q implements kotlin.g.a.b<ActivityManager.RunningAppProcessInfo, Boolean> {
        public static final u pDn = new u();

        static {
            AppMethodBeat.i(6684);
            AppMethodBeat.o(6684);
        }

        u() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
            AppMethodBeat.i(6683);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 = runningAppProcessInfo;
            kotlin.g.b.p.h(runningAppProcessInfo2, LocaleUtil.ITALIAN);
            String str = runningAppProcessInfo2.processName;
            m mVar = m.pCU;
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(str, m.dkO));
            AppMethodBeat.o(6683);
            return valueOf;
        }
    }

    public static final class v<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<Intent, IPCVoid> {
        public static final v pDo = new v();

        static {
            AppMethodBeat.i(195630);
            AppMethodBeat.o(195630);
        }

        v() {
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Intent intent, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(195629);
            Intent intent2 = intent;
            kotlin.g.b.p.g(intent2, "intent");
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a.ai(intent2);
            AppMethodBeat.o(195629);
        }
    }

    static {
        AppMethodBeat.i(6685);
        AppMethodBeat.o(6685);
    }

    private m() {
    }

    public static final /* synthetic */ int Dv(int i2) {
        AppMethodBeat.i(6721);
        int Dt = Dt(i2);
        AppMethodBeat.o(6721);
        return Dt;
    }

    public static final /* synthetic */ int Dw(int i2) {
        AppMethodBeat.i(6723);
        int Du = Du(i2);
        AppMethodBeat.o(6723);
        return Du;
    }

    public static final /* synthetic */ void a(m mVar, int i2) {
        AppMethodBeat.i(195639);
        Do(i2);
        AppMethodBeat.o(195639);
    }

    public static final /* synthetic */ void a(m mVar, Bundle bundle, kotlin.g.a.b bVar) {
        AppMethodBeat.i(195638);
        a(bundle, bVar);
        AppMethodBeat.o(195638);
    }

    public static final /* synthetic */ void a(m mVar, List list, int i2, int i3) {
        AppMethodBeat.i(6724);
        mVar.b(list, i2, i3, 2);
        AppMethodBeat.o(6724);
    }

    public static final /* synthetic */ Object b(List list, int i2, Object obj) {
        AppMethodBeat.i(6722);
        Object a2 = a(list, i2, obj);
        AppMethodBeat.o(6722);
        return a2;
    }

    public static final /* synthetic */ boolean b(fn fnVar, int i2) {
        AppMethodBeat.i(6718);
        boolean a2 = a(fnVar, i2);
        AppMethodBeat.o(6718);
        return a2;
    }

    public static MMKVSlotManager cod() {
        return pCN;
    }

    public static MMFileSlotManager coe() {
        return pCO;
    }

    public static final void run(int i2) {
        AppMethodBeat.i(6686);
        if (pCM.get()) {
            AppMethodBeat.o(6686);
            return;
        }
        pCM.set(true);
        if (i2 == 10000) {
            com.tencent.mm.cr.d.hiy();
            Do(i2);
            pCM.set(false);
            AppMethodBeat.o(6686);
            return;
        }
        Looper.myQueue().addIdleHandler(new q(i2));
        AppMethodBeat.o(6686);
    }

    public static final class q implements MessageQueue.IdleHandler {
        final /* synthetic */ int pmo;

        q(int i2) {
            this.pmo = i2;
        }

        public final boolean queueIdle() {
            AppMethodBeat.i(6679);
            Looper.myQueue().removeIdleHandler(this);
            com.tencent.mm.cr.d.hiy();
            m.a(m.pCU, this.pmo);
            m mVar = m.pCU;
            m.pCM.set(false);
            AppMethodBeat.o(6679);
            return false;
        }
    }

    private static void Do(int i2) {
        AppMethodBeat.i(6687);
        Log.i(TAG, "start in preCreate");
        aE(i2, f.getNetWorkType());
        Dq(-1);
        coh();
        clear();
        AppMethodBeat.o(6687);
    }

    private static void clear() {
        AppMethodBeat.i(6688);
        a.col();
        Log.i(TAG, "clear() isOk:true");
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.coR();
        AppMethodBeat.o(6688);
    }

    public static final void Dp(int i2) {
        AppMethodBeat.i(6689);
        Dq(i2);
        AppMethodBeat.o(6689);
    }

    private static void Dq(int i2) {
        AppMethodBeat.i(6690);
        j.a aVar = j.pCC;
        if (!j.a.cnU()) {
            AppMethodBeat.o(6690);
            return;
        }
        String str = dkO;
        kotlin.g.b.p.g(str, "PROCESS_NAME");
        com.tencent.mm.ipcinvoker.a.a(str, new IPCInteger(i2), C0889m.pDe, null);
        AppMethodBeat.o(6690);
    }

    private static void aE(int i2, String str) {
        AppMethodBeat.i(6691);
        kotlin.g.b.p.h(str, DownloadInfo.NETTYPE);
        String str2 = MainProcessIPCService.dkO;
        kotlin.g.b.p.g(str2, "MainProcessIPCService.PROCESS_NAME");
        Bundle bundle = new Bundle();
        bundle.putInt("openScene", i2);
        bundle.putString(DownloadInfo.NETTYPE, str);
        com.tencent.mm.ipcinvoker.a.a(str2, bundle, i.pCZ, null);
        AppMethodBeat.o(6691);
    }

    public static /* synthetic */ boolean a(Context context, String str, int i2, int i3, int i4, Intent intent, int i5, b.a aVar, boolean z, int i6) {
        Intent intent2;
        int i7;
        b.a aVar2;
        AppMethodBeat.i(195632);
        if ((i6 & 64) != 0) {
            intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
        } else {
            intent2 = intent;
        }
        if ((i6 & 128) != 0) {
            i7 = -1;
        } else {
            i7 = i5;
        }
        if ((i6 & 256) != 0) {
            aVar2 = new b.a();
            aVar2.success = true;
        } else {
            aVar2 = aVar;
        }
        boolean a2 = a(context, str, i2, i3, i4, intent2, i7, aVar2, (i6 & 512) != 0 ? true : z);
        AppMethodBeat.o(195632);
        return a2;
    }

    public static final boolean a(Context context, String str, int i2, int i3, int i4, Intent intent, int i5, b.a aVar, boolean z) {
        int i6;
        int i7;
        AppMethodBeat.i(195631);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str, "rawUrl");
        kotlin.g.b.p.h(intent, "intent");
        kotlin.g.b.p.h(aVar, "result");
        if (kotlin.n.n.aL(str)) {
            aVar.success = false;
            aVar.message = "invalid url";
            AppMethodBeat.o(195631);
            return false;
        } else if (!UrlExKt.isMpUrl(str)) {
            aVar.success = false;
            aVar.message = "invalid host";
            AppMethodBeat.o(195631);
            return false;
        } else if (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(context)) {
            Log.i(TAG, "Block mp rawUrl %s", str);
            aVar.success = false;
            aVar.message = "mp url currently blocked";
            AppMethodBeat.o(195631);
            return false;
        } else {
            if (i2 == -1) {
                fn ail = pCR.ail(str);
                i6 = ail != null ? ail.iAb : i2;
            } else {
                i6 = i2;
            }
            boolean z2 = i6 == 5 && !z.gsK();
            int Dr = Dr(i6);
            if (Dr == -1) {
                aVar.success = false;
                aVar.message = "invalid itemShowType:".concat(String.valueOf(i6));
                AppMethodBeat.o(195631);
                return false;
            }
            int sessionId = ab.getSessionId();
            String urlParam = UrlExKt.getUrlParam(str, "scene");
            if (urlParam != null) {
                if (new kotlin.n.k("\\d+").aJ(urlParam)) {
                    i3 = Integer.parseInt(urlParam);
                }
            }
            String urlParam2 = UrlExKt.getUrlParam(str, "subscene");
            if (urlParam2 != null) {
                if (new kotlin.n.k("\\d+").aJ(urlParam2)) {
                    i4 = Integer.parseInt(urlParam2);
                }
            }
            intent.putExtra(e.p.OzA, i6);
            intent.putExtra(e.p.Ozv, sessionId);
            intent.putExtra(e.p.Ozw, i3);
            intent.putExtra(e.p.Ozx, i4);
            intent.putExtra(e.p.OzB, i5);
            int intExtra = intent.getIntExtra("geta8key_scene", 0);
            dei dei = new dei();
            dei.id = sessionId;
            dei.url = str;
            dei.iwc = i6;
            dei.pCV = Dr;
            dei.pmM = i3;
            dei.pHw = i4;
            dei.MJq = intExtra;
            dei.pCb = i6 != i2;
            boolean a2 = pCU.a(context, intent, dei, z2, aVar, z);
            if (a2) {
                if (i5 != -1 && (context instanceof MMActivity) && i5 == 1) {
                    ((MMActivity) context).overridePendingTransition(R.anim.dq, R.anim.dp);
                }
                switch (i3) {
                    case 0:
                        i7 = 2;
                        break;
                    case 1:
                        i7 = 3;
                        break;
                    case 2:
                        i7 = 0;
                        break;
                    case 90:
                        i7 = 1;
                        break;
                    default:
                        i7 = -1;
                        break;
                }
                com.tencent.mm.plugin.webview.h.a.agh(i7);
            }
            AppMethodBeat.o(195631);
            return a2;
        }
    }

    static /* synthetic */ int Ds(int i2) {
        AppMethodBeat.i(6695);
        int Dr = Dr(i2);
        AppMethodBeat.o(6695);
        return Dr;
    }

    private static int Dr(int i2) {
        AppMethodBeat.i(195633);
        com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
        if (bVar == null || !bVar.CQ(i2)) {
            switch (i2) {
                case 0:
                    if (CR(102)) {
                        AppMethodBeat.o(195633);
                        return 5;
                    }
                    AppMethodBeat.o(195633);
                    return 0;
                case 10:
                    if (CR(102)) {
                        AppMethodBeat.o(195633);
                        return 5;
                    }
                    AppMethodBeat.o(195633);
                    return 4;
                default:
                    AppMethodBeat.o(195633);
                    return -1;
            }
        } else if (CR(102)) {
            AppMethodBeat.o(195633);
            return 5;
        } else {
            AppMethodBeat.o(195633);
            return 4;
        }
    }

    private static String a(String str, boolean z, Intent intent) {
        AppMethodBeat.i(6696);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        intent.putExtra("bizEnterId", currentTimeMillis);
        String appendUrlParam = z ? UrlExKt.appendUrlParam(str, "isNativePage", "2") : str;
        if (!kotlin.n.n.a((CharSequence) str, (CharSequence) "clicktime", false)) {
            appendUrlParam = UrlExKt.appendUrlParam(appendUrlParam, "clicktime", String.valueOf(currentTimeMillis));
        }
        if (!kotlin.n.n.a((CharSequence) str, (CharSequence) "enterid", false)) {
            appendUrlParam = UrlExKt.appendUrlParam(appendUrlParam, "enterid", String.valueOf(currentTimeMillis));
        }
        AppMethodBeat.o(6696);
        return appendUrlParam;
    }

    private final boolean a(Context context, Intent intent, dei dei, boolean z, b.a aVar, boolean z2) {
        String str;
        boolean z3;
        Intent intent2;
        AppMethodBeat.i(195634);
        eic DE = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.DE(dei.pCV);
        if (DE == null && (dei.iwc == 0 || dei.iwc == -1)) {
            Log.e(TAG, "tmplParams is null");
            aVar.success = false;
            aVar.message = "not support tmplType=" + dei + ".tmplType";
            AppMethodBeat.o(195634);
            return false;
        }
        Log.i(TAG, "summer hardcoder biz startPerformance [%s][%s]", 902, Integer.valueOf(WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, TAG)));
        if (DE == null) {
            String str2 = dei.url;
            kotlin.g.b.p.g(str2, "session.url");
            intent.putExtra("rawUrl", UrlExKt.appendStats(a(str2, z, intent), dei));
            kotlin.g.b.p.g(intent.putExtra(e.p.OzD, true), "intent.putExtra(Constant…wUI.KTmplForeceUrl, true)");
        } else {
            dei.hFF = DE.hFF;
            com.tencent.mm.plugin.webview.h.a.gH(DE.reportId, 104);
            String str3 = dei.url;
            kotlin.g.b.p.g(str3, "session.url");
            fn cI = cI(str3, dei.pCV);
            if (!(cI == null || (str = cI.KIR) == null)) {
                if (!kotlin.n.n.aL(str)) {
                    if (cI.KIY) {
                        z3 = false;
                    } else {
                        z3 = z;
                    }
                    if (cI.KIY || dei.iwc == 0) {
                        intent2 = new Intent();
                        intent2.putExtra(e.p.Ozw, dei.pmM);
                    } else {
                        intent.putExtra(e.p.OzD, true);
                        intent2 = intent;
                    }
                    String str4 = cI.KIR;
                    kotlin.g.b.p.g(str4, "appMsgContext.ForceUrl");
                    String a2 = a(UrlExKt.appendStats(str4, dei), z3, intent2);
                    Log.i(TAG, "appMsgContext forceUrl:%s", a2);
                    intent2.putExtra("rawUrl", a2);
                    if (z2) {
                        a(context, intent2, dei, z3, "webview", ".ui.tools.WebViewUI");
                    }
                    com.tencent.mm.plugin.webview.h.a.gH(DE.reportId, 107);
                    aVar.success = true;
                    aVar.message = "has forceUrl=".concat(String.valueOf(a2));
                    AppMethodBeat.o(195634);
                    return true;
                }
            }
            String str5 = dei.url;
            kotlin.g.b.p.g(str5, "session.url");
            dei.url = a(str5, z, intent);
            intent.putExtra("rawUrl", dei.url);
            dei.MJr = true;
            eib DC = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.DC(DE.pCV);
            dei.MJt = u.d(DC);
            boolean j2 = kotlin.g.b.p.j(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix(), "mptmpl://");
            dei.MJu = u.d(DC) && j2;
            dei.MJv = u.d(DC) && !j2;
            if (cI == null || !n.b(cI)) {
                String str6 = dei.url;
                kotlin.g.b.p.g(str6, "session.url");
                a(context, str6, dei, j.pDa);
            } else {
                dei.MJs = true;
                Log.i(TAG, "set contentId:%s", c.a(cI));
            }
        }
        String str7 = e.p.Ozr;
        j.a aVar2 = j.pCC;
        intent.putExtra(str7, j.a.cnU());
        intent.putExtra(e.p.Ozs, System.currentTimeMillis());
        intent.putExtra(e.p.Ozu, dei.url);
        intent.putExtra(e.p.Ozq, DE != null ? DE.toByteArray() : null);
        intent.putExtra(e.p.OzC, dei.toByteArray());
        intent.putExtra(e.p.Ozz, Process.myPid());
        try {
            intent.putExtra(e.p.Ozy, f.c(context, u.pDn));
            if (z2) {
                if (dei.MJs) {
                    try {
                        kotlin.g.b.p.h(intent, "intent");
                        String str8 = dkO;
                        kotlin.g.b.p.g(str8, "PROCESS_NAME");
                        com.tencent.mm.ipcinvoker.a.a(str8, intent, v.pDo, null);
                    } catch (Throwable th) {
                        Log.i(TAG, "updateWebview ex " + th.getMessage());
                    }
                }
                a(context, intent, dei, z, "brandservice", ".ui.timeline.preload.ui.TmplWebViewTooLMpUI");
            }
            if (DE != null) {
                com.tencent.mm.plugin.webview.h.a.gH(DE.reportId, 106);
                com.tencent.mm.plugin.webview.h.a.agi(100);
                if (dei.MJt) {
                    com.tencent.mm.plugin.webview.h.a.gH(DE.reportId, 231);
                    com.tencent.mm.plugin.webview.h.a.agi(110);
                }
            }
            AppMethodBeat.o(195634);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(195634);
            return false;
        }
    }

    private static void a(Context context, Intent intent, dei dei, boolean z, String str, String str2) {
        AppMethodBeat.i(195635);
        s sVar = new s(z, str, dei);
        t tVar = new t(z, str2, dei);
        if (dei.iwc == 5) {
            intent.putExtra("screen_orientation", 1);
        }
        com.tencent.mm.br.c.b(context, sVar.bAa(), tVar.bAa(), intent);
        AppMethodBeat.o(195635);
    }

    public static final class l extends HashMap<Integer, String> {
        l() {
            AppMethodBeat.i(6666);
            put(1, "100463");
            put(3, "100486");
            AppMethodBeat.o(6666);
        }

        public final /* bridge */ boolean containsKey(Object obj) {
            AppMethodBeat.i(6669);
            if (!(obj instanceof Integer)) {
                AppMethodBeat.o(6669);
                return false;
            }
            boolean containsKey = super.containsKey((Integer) obj);
            AppMethodBeat.o(6669);
            return containsKey;
        }

        public final /* bridge */ boolean containsValue(Object obj) {
            AppMethodBeat.i(6667);
            if (!(obj instanceof String)) {
                AppMethodBeat.o(6667);
                return false;
            }
            boolean containsValue = super.containsValue((String) obj);
            AppMethodBeat.o(6667);
            return containsValue;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final /* bridge */ String get(Object obj) {
            AppMethodBeat.i(6670);
            if (!(obj instanceof Integer)) {
                AppMethodBeat.o(6670);
                return null;
            }
            String str = (String) super.get((Integer) obj);
            AppMethodBeat.o(6670);
            return str;
        }

        @Override // java.util.Map, java.util.HashMap
        public final /* bridge */ String getOrDefault(Object obj, String str) {
            AppMethodBeat.i(6668);
            if (!(obj != null ? obj instanceof Integer : true)) {
                AppMethodBeat.o(6668);
                return str;
            }
            String str2 = (String) super.getOrDefault((Integer) obj, str);
            AppMethodBeat.o(6668);
            return str2;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final /* bridge */ String remove(Object obj) {
            AppMethodBeat.i(6671);
            if (!(obj instanceof Integer)) {
                AppMethodBeat.o(6671);
                return null;
            }
            String str = (String) super.remove((Integer) obj);
            AppMethodBeat.o(6671);
            return str;
        }

        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            boolean z = true;
            AppMethodBeat.i(6672);
            if (obj != null ? obj instanceof Integer : true) {
                if (obj2 != null) {
                    z = obj2 instanceof String;
                }
                if (z) {
                    boolean remove = super.remove((Integer) obj, (String) obj2);
                    AppMethodBeat.o(6672);
                    return remove;
                }
            }
            AppMethodBeat.o(6672);
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final /* bridge */ Set<Map.Entry<Integer, String>> entrySet() {
            AppMethodBeat.i(6673);
            Set<Map.Entry<Integer, String>> entrySet = super.entrySet();
            AppMethodBeat.o(6673);
            return entrySet;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final /* bridge */ Set<Integer> keySet() {
            AppMethodBeat.i(6674);
            Set<Integer> keySet = super.keySet();
            AppMethodBeat.o(6674);
            return keySet;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
        public final /* bridge */ Collection<String> values() {
            AppMethodBeat.i(6675);
            Collection<String> values = super.values();
            AppMethodBeat.o(6675);
            return values;
        }

        public final /* bridge */ int size() {
            AppMethodBeat.i(6676);
            int size = super.size();
            AppMethodBeat.o(6676);
            return size;
        }
    }

    public static final boolean CR(int i2) {
        boolean z = true;
        AppMethodBeat.i(6699);
        if (com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class) != null) {
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IBizTeenModeService::class.java)");
            if (!((com.tencent.mm.api.q) af).Vu()) {
                AppMethodBeat.o(6699);
                return false;
            }
        }
        if (i2 == 102) {
            AppMethodBeat.o(6699);
            return false;
        } else if (pCQ.containsKey(Integer.valueOf(i2))) {
            Boolean bool = pCQ.get(Integer.valueOf(i2));
            if (bool == null) {
                kotlin.g.b.p.hyc();
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(6699);
            return booleanValue;
        } else {
            j.a aVar = j.pCC;
            if (j.a.coc() || (!BuildInfo.IS_FLAVOR_RED && !BuildInfo.DEBUG)) {
                try {
                    HashMap<Integer, Boolean> hashMap = pCQ;
                    Integer valueOf = Integer.valueOf(i2);
                    switch (i2) {
                        case 1:
                            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_biz_timeline, 0) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 2:
                            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_chat, 0) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 3:
                            z = (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_forward, 0) & 1) != 0;
                            break;
                        case 4:
                            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_sns, 0) & 1) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 5:
                            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_jsapi, 0) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 6:
                            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_mpprofile, 0) & 1) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 7:
                            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_search, 0) & 1) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 13:
                            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_forward, 0) & 2) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 14:
                            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_sns, 0) & 2) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 16:
                            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_mpprofile, 0) & 2) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 20:
                            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_mpprocess, 0) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 23:
                            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_forward, 0) & 4) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 24:
                            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_sns, 0) & 4) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 26:
                            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_mpprofile, 0) & 4) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 101:
                            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mpfastload_android_tmpl_zip, 0) & 1) == 0) {
                                z = false;
                                break;
                            }
                            break;
                        case 102:
                            z = false;
                            break;
                        default:
                            z = false;
                            break;
                    }
                    hashMap.put(valueOf, Boolean.valueOf(z));
                } catch (Exception e2) {
                    pCQ.put(Integer.valueOf(i2), Boolean.FALSE);
                    Log.printErrStackTrace(TAG, e2, "canPreloadIn", new Object[0]);
                }
                if (pCQ.containsKey(Integer.valueOf(i2))) {
                    Boolean bool2 = pCQ.get(Integer.valueOf(i2));
                    if (bool2 == null) {
                        kotlin.g.b.p.hyc();
                    }
                    kotlin.g.b.p.g(bool2, "isPreloadOpen[openScene]!!");
                    boolean booleanValue2 = bool2.booleanValue();
                    AppMethodBeat.o(6699);
                    return booleanValue2;
                }
                AppMethodBeat.o(6699);
                return false;
            }
            Integer valueOf2 = Integer.valueOf(i2);
            j.a aVar2 = j.pCC;
            pCQ.put(valueOf2, Boolean.valueOf(k.cdi().getBoolean("preload_use", true)));
            Boolean bool3 = pCQ.get(Integer.valueOf(i2));
            if (bool3 == null) {
                kotlin.g.b.p.hyc();
            }
            boolean booleanValue3 = bool3.booleanValue();
            AppMethodBeat.o(6699);
            return booleanValue3;
        }
    }

    public static a cof() {
        return pCR;
    }

    private static fn cI(String str, int i2) {
        AppMethodBeat.i(6700);
        if (kotlin.n.n.aL(str)) {
            Log.e(TAG, "[findAppMsgContextInCache] url is null, return");
            AppMethodBeat.o(6700);
            return null;
        } else if (pCR.cJ(str, i2)) {
            fn ail = pCR.ail(str);
            AppMethodBeat.o(6700);
            return ail;
        } else {
            AppMethodBeat.o(6700);
            return null;
        }
    }

    public final void a(Object obj, String str, dei dei, kotlin.g.a.q<? super WeakReference<Object>, ? super c, ? super fn, x> qVar) {
        boolean z = false;
        AppMethodBeat.i(195636);
        kotlin.g.b.p.h(obj, "context");
        kotlin.g.b.p.h(str, "url");
        kotlin.g.b.p.h(dei, "session");
        kotlin.g.b.p.h(qVar, "callback");
        WeakReference weakReference = new WeakReference(obj);
        c cVar = new c(false, System.currentTimeMillis(), System.currentTimeMillis(), false, (byte) 0);
        j.a aVar = j.pCC;
        if (j.a.cnW()) {
            cVar.isSuccess = true;
            qVar.d(weakReference, cVar, new fn());
            AppMethodBeat.o(195636);
        } else if (kotlin.n.n.aL(str) || !UrlExKt.isMpUrl(str)) {
            qVar.d(weakReference, cVar, new fn());
            AppMethodBeat.o(195636);
        } else {
            fn cI = cI(str, dei.pCV);
            String str2 = TAG;
            StringBuilder sb = new StringBuilder("getAppMsgContext ");
            if (cI == null) {
                z = true;
            }
            Log.d(str2, sb.append(z).toString());
            if (cI != null) {
                cVar.isSuccess = true;
                cVar.bGq = true;
                qVar.d(weakReference, cVar, cI);
                AppMethodBeat.o(195636);
                return;
            }
            String appendStats = UrlExKt.appendStats(str, dei);
            LinkedList linkedList = new LinkedList();
            linkedList.add(new d(appendStats, dei.pCV));
            a(this, linkedList, dei.pCV, new k(appendStats, qVar, weakReference));
            AppMethodBeat.o(195636);
        }
    }

    public static final class c {
        public boolean bGq;
        public long boX;
        public boolean isSuccess;
        public boolean pBY;
        public long start;

        private c(boolean z, long j2, long j3, boolean z2) {
            this.isSuccess = z;
            this.start = j2;
            this.boX = j3;
            this.pBY = z2;
            this.bGq = false;
        }

        public /* synthetic */ c(boolean z, long j2, long j3, boolean z2, byte b2) {
            this(z, j2, j3, z2);
        }
    }

    private static boolean a(fn fnVar, int i2) {
        LinkedList<eib> linkedList;
        AppMethodBeat.i(6702);
        eib DC = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.DC(i2);
        String str = fnVar.KIR;
        if (!(str == null || kotlin.n.n.aL(str))) {
            AppMethodBeat.o(6702);
            return true;
        }
        if (u.a(DC) && (linkedList = fnVar.KIZ) != null) {
            for (T t2 : linkedList) {
                Log.v(TAG, "checkDataVerVaild: " + t2.oUv + ' ' + DC.oUv + ' ' + t2.Nhq + ' ' + DC.Nhq);
                if (t2.oUv == DC.oUv && kotlin.g.b.p.j(t2.Nhq, DC.Nhq)) {
                    Log.v(TAG, "checkDataVerVaild: " + t2.Version + " tmplInfo:" + DC.Version);
                    if (t2.Version >= DC.Version) {
                        AppMethodBeat.o(6702);
                        return true;
                    }
                    AppMethodBeat.o(6702);
                    return false;
                }
            }
        }
        AppMethodBeat.o(6702);
        return false;
    }

    private final void b(List<d> list, int i2, int i3, int i4) {
        AppMethodBeat.i(6703);
        j.a aVar = j.pCC;
        if (!j.a.cnV()) {
            AppMethodBeat.o(6703);
            return;
        }
        a(list, i2, i3, i4, new f(list));
        AppMethodBeat.o(6703);
    }

    private static /* synthetic */ void a(m mVar, List list, int i2, kotlin.g.a.m mVar2) {
        AppMethodBeat.i(195637);
        mVar.a(list, i2, 0, 0, mVar2);
        AppMethodBeat.o(195637);
    }

    private final void a(List<d> list, int i2, int i3, int i4, kotlin.g.a.m<? super c, ? super kf, x> mVar) {
        AppMethodBeat.i(6704);
        Bundle bundle = new Bundle();
        List<d> list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().url);
        }
        bundle.putStringArrayList("urls", new ArrayList<>(arrayList));
        List<d> list3 = list;
        ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(list3, 10));
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(it2.next().pCV));
        }
        bundle.putIntegerArrayList("tmplTypes", new ArrayList<>(arrayList2));
        bundle.putInt("openScene", i2);
        bundle.putInt("strip", i3);
        bundle.putInt("stripType", i4);
        com.tencent.mm.kernel.b.h azG = com.tencent.mm.kernel.g.aAe().azG();
        kotlin.g.b.p.g(azG, "MMKernel.process().current()");
        if (azG.aBb()) {
            a(bundle, new o(mVar));
            AppMethodBeat.o(6704);
            return;
        }
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, bundle, b.class, new p(mVar));
        AppMethodBeat.o(6704);
    }

    private static void a(Bundle bundle, kotlin.g.a.b<? super Bundle, x> bVar) {
        AppMethodBeat.i(6706);
        long currentTimeMillis = System.currentTimeMillis();
        long currentTimeMillis2 = System.currentTimeMillis() % 100;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("urls");
        if (stringArrayList != null && stringArrayList.size() == 1) {
            String str = stringArrayList.get(0);
            kotlin.g.b.p.g(str, "urls[0]");
            String aib = c.aib(str);
            if (cog().containsKey(aib)) {
                ConcurrentLinkedDeque<kotlin.g.a.b<Bundle, x>> concurrentLinkedDeque = cog().get(aib);
                if (concurrentLinkedDeque != null) {
                    concurrentLinkedDeque.add(bVar);
                }
                Log.v(TAG, "terry trace cgi mounted:" + aib + '#' + currentTimeMillis2);
                AppMethodBeat.o(6706);
                return;
            }
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("tmplTypes");
        int i2 = bundle.getInt("openScene");
        int i3 = bundle.getInt("strip", 0);
        int i4 = bundle.getInt("stripType", 0);
        LinkedList linkedList = new LinkedList();
        if (stringArrayList != null) {
            int size = stringArrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                String str2 = stringArrayList.get(i5);
                if (!(str2 == null || str2.length() == 0)) {
                    String str3 = stringArrayList.get(i5);
                    kotlin.g.b.p.g(str3, "urls[i]");
                    String str4 = str3;
                    if (integerArrayList == null) {
                        kotlin.g.b.p.hyc();
                    }
                    Integer num = integerArrayList.get(i5);
                    kotlin.g.b.p.g(num, "tmplTypes!![i]");
                    linkedList.add(new d(str4, num.intValue()));
                    String str5 = stringArrayList.get(i5);
                    kotlin.g.b.p.g(str5, "urls[i]");
                    String aib2 = c.aib(str5);
                    cog().put(aib2, new ConcurrentLinkedDeque<>());
                    Log.v(TAG, "terry trace cgi send:" + aib2 + '#' + currentTimeMillis2);
                }
            }
        }
        aa.a(a(linkedList, i2, i3, i4).aXF(), new r(currentTimeMillis, currentTimeMillis2, bVar, stringArrayList));
        AppMethodBeat.o(6706);
    }

    public static final class r implements aa.a {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ long pDg;
        final /* synthetic */ long pDh;
        final /* synthetic */ ArrayList pDi;

        r(long j2, long j3, kotlin.g.a.b bVar, ArrayList arrayList) {
            this.pDg = j2;
            this.pDh = j3;
            this.gWe = bVar;
            this.pDi = arrayList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x00e7  */
        @Override // com.tencent.mm.ak.aa.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int a(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.d r12, com.tencent.mm.ak.q r13) {
            /*
            // Method dump skipped, instructions count: 329
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.r.a(int, int, java.lang.String, com.tencent.mm.ak.d, com.tencent.mm.ak.q):int");
        }
    }

    public static final class b implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {

        static final class a extends kotlin.g.b.q implements kotlin.g.a.b<Bundle, x> {
            final /* synthetic */ com.tencent.mm.ipcinvoker.d kFf;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(com.tencent.mm.ipcinvoker.d dVar) {
                super(1);
                this.kFf = dVar;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Bundle bundle) {
                AppMethodBeat.i(6646);
                Bundle bundle2 = bundle;
                kotlin.g.b.p.h(bundle2, LocaleUtil.ITALIAN);
                try {
                    this.kFf.bn(bundle2);
                } catch (Exception e2) {
                    m mVar = m.pCU;
                    Log.printErrStackTrace(m.TAG, e2, "ipc invoke callback", new Object[0]);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(6646);
                return xVar;
            }
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(6647);
            Bundle bundle2 = bundle;
            kotlin.g.b.p.h(bundle2, "bundle");
            kotlin.g.b.p.h(dVar, "callback");
            m.a(m.pCU, bundle2, new a(dVar));
            AppMethodBeat.o(6647);
        }
    }

    private static d.a a(Iterable<d> iterable, int i2, int i3, int i4) {
        int i5;
        AppMethodBeat.i(6708);
        ke keVar = new ke();
        keVar.pLm = f.getNetWorkType();
        keVar.KOx = u.con();
        keVar.KOw = new LinkedList<>();
        keVar.KOy = i3;
        keVar.KOz = i4;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(iterable, 10));
        for (d dVar : iterable) {
            String str = dVar.url;
            int i6 = dVar.pCV;
            don don = new don();
            don.Url = str;
            don.KIS = 0;
            don.Scene = i2;
            fn ail = pCR.ail(str);
            if (ail != null) {
                don.KIS = ail.KIS;
                if (!a(ail, i6)) {
                    don.KIS = 0;
                }
            }
            arrayList.add(don);
        }
        keVar.KOw.addAll(arrayList);
        Log.i(TAG, "[batchSyncAppMsgContext]urlList ReqInfoList:%d", Integer.valueOf(keVar.KOw.size()));
        Log.d(TAG, "[batchSyncAppMsgContext]urlList:%s", iterable);
        d.a aVar = new d.a();
        aVar.sG(2594);
        aVar.MB("/cgi-bin/mmbiz-bin/batchgetappmsg");
        aVar.sI(0);
        aVar.sJ(0);
        aVar.c(keVar);
        aVar.d(new kf());
        switch (i2) {
            case 0:
                i5 = 35;
                break;
            case 90:
                i5 = 34;
                break;
            default:
                i5 = 35;
                break;
        }
        com.tencent.mm.plugin.webview.h.a.kh(i5, keVar.KOw.size());
        AppMethodBeat.o(6708);
        return aVar;
    }

    private static <T extends List<? extends C>, C> C a(T t2, int i2, C c2) {
        AppMethodBeat.i(6709);
        if (t2.size() > i2) {
            C c3 = (C) t2.get(i2);
            AppMethodBeat.o(6709);
            return c3;
        }
        AppMethodBeat.o(6709);
        return c2;
    }

    private static int Dt(int i2) {
        switch (i2) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    private static int Du(int i2) {
        switch (i2) {
            case 0:
            case 92:
                return 2;
            case 1:
                return 13;
            case 2:
                return 14;
            case 126:
                return 6;
            default:
                return 0;
        }
    }

    public static void aii(String str) {
        AppMethodBeat.i(6710);
        kotlin.g.b.p.h(str, "url");
        Log.d(TAG, "removePreload %s", str);
        kotlin.g.b.p.h(str, "url");
        String ahX = c.ahX(str);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) pCN.findSlot(ahX);
        if (multiProcessMMKV != null) {
            multiProcessMMKV.removeValueForKey(ahX);
            multiProcessMMKV.removeValueForKey(c.aib(str));
        }
        AppMethodBeat.o(6710);
    }

    public static final void a(String str, int i2, int i3, Object... objArr) {
        AppMethodBeat.i(6711);
        kotlin.g.b.p.h(str, "url");
        kotlin.g.b.p.h(objArr, NativeProtocol.WEB_DIALOG_PARAMS);
        if (pCT) {
            AppMethodBeat.o(6711);
            return;
        }
        ad adVar = new ad(3);
        adVar.add(str);
        adVar.add(Integer.valueOf(i2));
        adVar.eS(objArr);
        ArrayList ac = kotlin.a.j.ac(adVar.toArray(new Object[adVar.dtS.size()]));
        String str2 = ArrayList.class.getCanonicalName() + '_' + "addToPreload";
        synchronized (__BATCH_RUN_OBJ.INSTANCE) {
            try {
                bu buVar = __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(str2);
                if (buVar != null) {
                    buVar.a((CancellationException) null);
                }
                HashMap<String, Queue<?>> batchData = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
                if (!batchData.containsKey(str2)) {
                    batchData.put(str2, new LinkedList());
                }
                Queue<?> queue = batchData.get(str2);
                if (queue == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.util.LinkedList<T>");
                    AppMethodBeat.o(6711);
                    throw tVar;
                }
                ((LinkedList) queue).add(ac);
            } catch (Throwable th) {
                AppMethodBeat.o(6711);
                throw th;
            }
        }
        __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().put(str2, kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new e(1000, str2, null, i3), 2));
        AppMethodBeat.o(6711);
    }

    public static final void k(List<String[]> list, int i2) {
        LinkedList linkedList;
        AppMethodBeat.i(6712);
        kotlin.g.b.p.h(list, "items");
        if (pCT) {
            AppMethodBeat.o(6712);
        } else if (!CR(Du(i2))) {
            AppMethodBeat.o(6712);
        } else {
            int Dm = c.Dm(i2);
            ArrayList arrayList = new ArrayList();
            for (String[] strArr : list) {
                int parseInt = Integer.parseInt(strArr[2]);
                LinkedList linkedList2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(Long.parseLong(strArr[0]), strArr[1]).iAd;
                if (parseInt > 0) {
                    kotlin.g.b.p.g(linkedList2, LocaleUtil.ITALIAN);
                    linkedList = kotlin.a.j.b(linkedList2, parseInt);
                } else {
                    linkedList = linkedList2;
                }
                kotlin.a.j.a((Collection) arrayList, linkedList);
            }
            ArrayList<com.tencent.mm.ag.v> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
            for (com.tencent.mm.ag.v vVar : arrayList2) {
                String str = vVar.url;
                if (str == null) {
                    str = "";
                }
                arrayList3.add(new d(str, Dr(vVar.type)));
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : arrayList3) {
                d dVar = (d) obj;
                String str2 = dVar.url;
                if (!(!UrlExKt.isMpUrl(str2) || pCR.cJ(str2, dVar.pCV))) {
                    arrayList4.add(obj);
                }
            }
            ArrayList arrayList5 = arrayList4;
            int max = Math.max(arrayList5.size() - Dm, 0);
            List<d> b2 = kotlin.a.j.b(arrayList5, Dm);
            if (!b2.isEmpty()) {
                pCU.b(b2, i2, max, 1);
                if (Log.getLogLevel() == 0) {
                    String str3 = TAG;
                    StringBuilder append = new StringBuilder("preloadData preloadByInfoIdAndBuffer toStrip:").append(Dm).append(" strip:").append(max).append(" dispatch:");
                    List<d> list2 = b2;
                    ArrayList arrayList6 = new ArrayList(kotlin.a.j.a(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList6.add(c.aib(it.next().url));
                    }
                    Log.v(str3, append.append(arrayList6).toString());
                }
            }
            AppMethodBeat.o(6712);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void j(java.util.List<? extends java.util.List<java.lang.String>> r14, int r15) {
        /*
        // Method dump skipped, instructions count: 531
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.j(java.util.List, int):void");
    }

    private static void coh() {
        AppMethodBeat.i(6714);
        String str = MainProcessIPCService.dkO;
        kotlin.g.b.p.g(str, "MainProcessIPCService.PROCESS_NAME");
        com.tencent.mm.ipcinvoker.a.a(str, null, h.pCY, null);
        AppMethodBeat.o(6714);
    }

    public static final void aij(String str) {
        AppMethodBeat.i(6715);
        kotlin.g.b.p.h(str, "url");
        String str2 = MainProcessIPCService.dkO;
        kotlin.g.b.p.g(str2, "MainProcessIPCService.PROCESS_NAME");
        com.tencent.mm.ipcinvoker.a.a(str2, new IPCString(str), n.pDf, null);
        AppMethodBeat.o(6715);
    }

    public static long aik(String str) {
        AppMethodBeat.i(6716);
        kotlin.g.b.p.h(str, "url");
        String aic = c.aic(str);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) pCN.findSlot(aic);
        if (multiProcessMMKV != null) {
            long j2 = multiProcessMMKV.getLong(aic, 0);
            AppMethodBeat.o(6716);
            return j2;
        }
        AppMethodBeat.o(6716);
        return 0;
    }

    public static final class a {
        private final String TAG = "MicroMsg.Preload.BizAppMsgContextCache";

        public final boolean cJ(String str, int i2) {
            AppMethodBeat.i(6638);
            kotlin.g.b.p.h(str, "url");
            fn ail = ail(str);
            if (ail == null) {
                AppMethodBeat.o(6638);
                return false;
            }
            m mVar = m.pCU;
            int Ds = m.Ds((ail != null ? Integer.valueOf(ail.iAb) : null).intValue());
            if (Ds != -1) {
                i2 = Ds;
            }
            boolean c2 = c(ail, i2);
            if (!c2) {
                Log.d(this.TAG, "init invalid:" + c.ahX(str));
            }
            AppMethodBeat.o(6638);
            return c2;
        }

        public final fn ail(String str) {
            Object obj;
            byte[] decodeBytes;
            AppMethodBeat.i(6639);
            kotlin.g.b.p.h(str, "url");
            String ahX = c.ahX(str);
            m mVar = m.pCU;
            MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) m.cod().findSlot(ahX);
            if (multiProcessMMKV != null) {
                if (multiProcessMMKV.containsKey(ahX) && (decodeBytes = multiProcessMMKV.decodeBytes(ahX)) != null) {
                    if (!(decodeBytes.length == 0)) {
                        try {
                            Object newInstance = fn.class.newInstance();
                            ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                            obj = (com.tencent.mm.bw.a) newInstance;
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                        }
                    }
                }
                obj = null;
            } else {
                obj = null;
            }
            fn fnVar = (fn) obj;
            if (fnVar != null) {
                fnVar.Url = str;
                Log.i(this.TAG, "found:" + ahX + " last modify:" + fnVar.KIS);
                AppMethodBeat.o(6639);
                return fnVar;
            }
            Log.i(this.TAG, "not found:".concat(String.valueOf(ahX)));
            AppMethodBeat.o(6639);
            return null;
        }

        private final boolean c(fn fnVar, int i2) {
            boolean z;
            AppMethodBeat.i(6640);
            if (fnVar == null) {
                Log.v(this.TAG, "checkValid: null");
                AppMethodBeat.o(6640);
                return false;
            }
            m mVar = m.pCU;
            if (!m.b(fnVar, i2)) {
                Log.v(this.TAG, "checkValid: invalid version:data(" + fnVar.KIU + ')');
                AppMethodBeat.o(6640);
                return false;
            }
            j.a aVar = j.pCC;
            if (j.a.cnX()) {
                Log.i(this.TAG, "checkValid: debug to expire");
            } else {
                String str = fnVar.Url;
                kotlin.g.b.p.g(str, "appMsgContext.Url");
                String aic = c.aic(str);
                m mVar2 = m.pCU;
                MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) m.cod().findSlot(aic);
                if (multiProcessMMKV != null) {
                    z = f.a(multiProcessMMKV, aic, ((long) fnVar.KIQ) * 1000);
                } else {
                    z = true;
                }
                if (z) {
                    Log.i(this.TAG, "checkValid: expire for " + fnVar.KIQ);
                    AppMethodBeat.o(6640);
                    return false;
                }
            }
            AppMethodBeat.o(6640);
            return true;
        }

        public final void a(String str, fn fnVar) {
            AppMethodBeat.i(6641);
            kotlin.g.b.p.h(str, "url");
            if (fnVar != null) {
                String str2 = fnVar.iAc;
                if (!(str2 == null || kotlin.n.n.aL(str2))) {
                    String ahX = c.ahX(str);
                    String str3 = fnVar.iAc;
                    try {
                        fn fnVar2 = new fn();
                        fnVar2.parseFrom(fnVar.toByteArray());
                        fnVar2.iAc = null;
                        byte[] byteArray = fnVar2.toByteArray();
                        m mVar = m.pCU;
                        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) m.cod().getSlot();
                        multiProcessMMKV.encode(ahX, byteArray);
                        m mVar2 = m.pCU;
                        com.tencent.mm.vfs.o H = c.H(c.a(m.coe(), c.aib(str)));
                        kotlin.g.b.p.g(str3, "content");
                        Charset charset = kotlin.n.d.UTF_8;
                        kotlin.g.b.p.h(H, "$this$writeText");
                        kotlin.g.b.p.h(str3, "text");
                        kotlin.g.b.p.h(charset, "charset");
                        byte[] bytes = str3.getBytes(charset);
                        kotlin.g.b.p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                        com.tencent.mm.vfs.p.b(H, bytes);
                        f.b(multiProcessMMKV, c.aic(str));
                    } catch (IOException e2) {
                        Log.printErrStackTrace(this.TAG, e2, "save ".concat(String.valueOf(ahX)), new Object[0]);
                    }
                    Log.i(this.TAG, "saveInfo " + ahX + " last modify:" + fnVar.KIS);
                    AppMethodBeat.o(6641);
                    return;
                }
            }
            Log.e(this.TAG, "save fail, appMsgContext is null");
            AppMethodBeat.o(6641);
        }

        public static boolean col() {
            AppMethodBeat.i(6642);
            m mVar = m.pCU;
            m.cod().verifyAllSlot();
            AppMethodBeat.o(6642);
            return true;
        }
    }

    public static final class d {
        final int pCV;
        final String url;

        public d(String str, int i2) {
            kotlin.g.b.p.h(str, "url");
            AppMethodBeat.i(6650);
            this.url = str;
            this.pCV = i2;
            AppMethodBeat.o(6650);
        }
    }

    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<ConcurrentHashMap<String, ConcurrentLinkedDeque<kotlin.g.a.b<? super Bundle, ? extends x>>>> {
        public static final g pCX = new g();

        static {
            AppMethodBeat.i(6662);
            AppMethodBeat.o(6662);
        }

        g() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ConcurrentHashMap<String, ConcurrentLinkedDeque<kotlin.g.a.b<? super Bundle, ? extends x>>> invoke() {
            AppMethodBeat.i(6661);
            ConcurrentHashMap<String, ConcurrentLinkedDeque<kotlin.g.a.b<? super Bundle, ? extends x>>> concurrentHashMap = new ConcurrentHashMap<>();
            AppMethodBeat.o(6661);
            return concurrentHashMap;
        }
    }

    public static final class e extends kotlin.d.b.a.j implements kotlin.g.a.m<ai, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ long $delay;
        final /* synthetic */ String $key;
        Object L$0;
        int label;
        private ai p$;
        final /* synthetic */ int pmv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(long j2, String str, kotlin.d.d dVar, int i2) {
            super(2, dVar);
            this.$delay = j2;
            this.$key = str;
            this.pmv = i2;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(6658);
            kotlin.g.b.p.h(dVar, "completion");
            e eVar = new e(this.$delay, this.$key, dVar, this.pmv);
            eVar.p$ = (ai) obj;
            AppMethodBeat.o(6658);
            return eVar;
        }

        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(6659);
            Object invokeSuspend = ((e) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(6659);
            return invokeSuspend;
        }

        /* JADX WARNING: Removed duplicated region for block: B:132:0x036e  */
        /* JADX WARNING: Removed duplicated region for block: B:175:0x0348 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0271  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0281  */
        @Override // kotlin.d.b.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
            // Method dump skipped, instructions count: 1054
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class h<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        public static final h pCY = new h();

        static {
            AppMethodBeat.i(195622);
            AppMethodBeat.o(195622);
        }

        h() {
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(195621);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c.coh();
            AppMethodBeat.o(195621);
        }
    }

    public static final /* synthetic */ void a(Bundle bundle, kotlin.g.a.m mVar) {
        Object obj;
        AppMethodBeat.i(6720);
        boolean z = bundle.getBoolean("success");
        c cVar = new c(z, bundle.getLong("start"), bundle.getLong("end"), bundle.getBoolean("mount"), (byte) 0);
        if (z) {
            kf kfVar = new kf();
            kfVar.parseFrom(bundle.getByteArray("response"));
            if (cVar.pBY) {
                Log.v(TAG, "cgi mount");
                LinkedList<fn> linkedList = kfVar.KOA;
                ArrayList arrayList = new ArrayList();
                for (T t2 : linkedList) {
                    T t3 = t2;
                    String str = t3 != null ? t3.Url : null;
                    if (!(str == null || str.length() == 0)) {
                        arrayList.add(t2);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it.next();
                    String str2 = ((fn) next).Url;
                    kotlin.g.b.p.g(str2, "appMsgContext.Url");
                    if (kotlin.g.b.p.j(c.aib(str2), bundle.getString("id"))) {
                        obj = next;
                        break;
                    }
                }
                linkedList.clear();
                linkedList.add((fn) obj);
            }
            mVar.invoke(cVar, kfVar);
            AppMethodBeat.o(6720);
            return;
        }
        mVar.invoke(cVar, new kf());
        AppMethodBeat.o(6720);
    }
}
