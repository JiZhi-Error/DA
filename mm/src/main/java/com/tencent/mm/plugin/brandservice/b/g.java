package com.tencent.mm.plugin.brandservice.b;

import android.os.Looper;
import android.util.Base64;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.al.r;
import com.tencent.mm.g.a.w;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.f;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0006J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006J\u001c\u0010\u001a\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b2\u0006\u0010\u0018\u001a\u00020\u0006J\u001c\u0010\u001c\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b2\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004J\u001e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0004J,\u0010&\u001a\u00020\u00112\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic;", "", "()V", "TAG", "", "defaultRefreshIntervalSec", "", "doingGetAppMsgRelatedInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getUrl", "Ljava/util/Queue;", "", "lastGetId", "", "limiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getAppMsgRelatedInfo", "", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgUrlInfo;", "scene", "url", "itemShowType", "openScene", "reqType", "getAppMsgRelatedInfoForAppMsg", "Lcom/tencent/mm/message/AppMsgUrlReqInfo;", "getAppMsgRelatedInfoForBizMsg", "getAppMsgRelatedInfoId", "getFakeLongUrl", "bizUin", "mid", "idx", "getMaxUrlCount", "getRefreshIntervalSec", "isShortUrl", "", "processAppMsgRelatedInfo", "relatedInfoList", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "urlInfoList", "AppMsgRelatedInfoOp", "plugin-brandservice_release"})
public final class g {
    public static final String TAG = TAG;
    private static final ConcurrentHashMap<String, Integer> pns = new ConcurrentHashMap<>();
    private static final r pnt = new r();
    public static long pnu;
    public static Queue<List<Object>> pnv = new LinkedList();
    public static final g pnw = new g();

    static {
        AppMethodBeat.i(6512);
        AppMethodBeat.o(6512);
    }

    private g() {
    }

    public static String ahJ(String str) {
        AppMethodBeat.i(6506);
        p.h(str, "url");
        String str2 = "_mpdata_" + com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.aie(str);
        AppMethodBeat.o(6506);
        return str2;
    }

    public static boolean ahK(String str) {
        AppMethodBeat.i(6507);
        p.h(str, "url");
        String[] strArr = {"__biz", "mid", "idx"};
        for (int i2 = 0; i2 < 3; i2++) {
            if (UrlExKt.getUrlParam(str, strArr[i2]) == null) {
                AppMethodBeat.o(6507);
                return true;
            }
        }
        AppMethodBeat.o(6507);
        return false;
    }

    public static String U(int i2, int i3, int i4) {
        AppMethodBeat.i(6508);
        String str = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP;
        String str2 = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + FilePathGenerator.ANDROID_DIR_SEP;
        try {
            String valueOf = String.valueOf(i2);
            Charset charset = d.UTF_8;
            if (valueOf == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(6508);
                throw tVar;
            }
            byte[] bytes = valueOf.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 2);
            p.g(encodeToString, "Base64.encodeToString(\"$…eArray(), Base64.NO_WRAP)");
            str2 = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(str, "__biz", encodeToString), "mid", String.valueOf(i3)), "idx", String.valueOf(i4));
            AppMethodBeat.o(6508);
            return str2;
        } catch (Exception e2) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/model/MPDataLogic$AppMsgRelatedInfoOp;", "", "()V", "get", "Lcom/tencent/mm/message/AppMsgRelatedInfo;", "url", "", "save", "", "relatedInfo", "plugin-brandservice_release"})
    public static final class a {
        public static final a pnx = new a();

        static {
            AppMethodBeat.i(6500);
            AppMethodBeat.o(6500);
        }

        private a() {
        }

        public static com.tencent.mm.ag.p ahL(String str) {
            AppMethodBeat.i(6498);
            if (str == null) {
                AppMethodBeat.o(6498);
                return null;
            }
            g gVar = g.pnw;
            String ahJ = g.ahJ(str);
            MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) com.tencent.mm.al.t.iOP.findSlot(ahJ);
            if (multiProcessMMKV != null) {
                ga gaVar = new ga();
                byte[] decodeBytes = multiProcessMMKV.decodeBytes(ahJ);
                if (Util.isNullOrNil(decodeBytes)) {
                    AppMethodBeat.o(6498);
                    return null;
                }
                try {
                    gaVar.parseFrom(decodeBytes);
                    com.tencent.mm.ag.p pVar = gaVar.KJP;
                    if (pVar != null) {
                        pVar.Url = str;
                    }
                    if (Log.getLogLevel() == 0) {
                        g gVar2 = g.pnw;
                        Log.v(g.TAG, "found:" + ahJ + " last modify:" + gaVar.lastUpdateTime);
                    }
                    com.tencent.mm.ag.p pVar2 = gaVar.KJP;
                    AppMethodBeat.o(6498);
                    return pVar2;
                } catch (IOException e2) {
                    g gVar3 = g.pnw;
                    Log.printErrStackTrace(g.TAG, e2, "get:".concat(String.valueOf(ahJ)), new Object[0]);
                }
            }
            AppMethodBeat.o(6498);
            return null;
        }

        public static void a(com.tencent.mm.ag.p pVar) {
            AppMethodBeat.i(6499);
            p.h(pVar, "relatedInfo");
            try {
                ga gaVar = new ga();
                gaVar.KJP = pVar;
                gaVar.lastUpdateTime = System.currentTimeMillis();
                byte[] byteArray = gaVar.toByteArray();
                MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) com.tencent.mm.al.t.iOP.getSlot();
                if (multiProcessMMKV != null) {
                    multiProcessMMKV.encode(gaVar.KJP.izX, byteArray);
                    AppMethodBeat.o(6499);
                    return;
                }
                AppMethodBeat.o(6499);
            } catch (Exception e2) {
                g gVar = g.pnw;
                Log.e(g.TAG, "save ex " + e2.getMessage());
                AppMethodBeat.o(6499);
            }
        }
    }

    public static void j(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(6509);
        p.h(str, "url");
        f.b(bn.TUK, ba.hMW(), new b(System.currentTimeMillis(), str, i2, i4, 2, i3, null), 2);
        AppMethodBeat.o(6509);
    }

    public static void b(LinkedList<gg> linkedList, int i2) {
        AppMethodBeat.i(6510);
        p.h(linkedList, "items");
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(6510);
            return;
        }
        nj njVar = new nj();
        pnt.duration = clK() * 1000;
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (!pns.contains(t.izX)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            String str = ((gg) obj).izX;
            r rVar = pnt;
            p.g(str, "id");
            if (!rVar.contains(str)) {
                arrayList2.add(obj);
            }
        }
        int decodeInt = MultiProcessMMKV.getMMKV(TAG).decodeInt("BizAppMsgRelatedInfoMaxUrlCount", 10);
        Log.v(TAG, "maxUrlCount = ".concat(String.valueOf(decodeInt)));
        njVar.KSM.addAll(j.b(arrayList2, Math.max(decodeInt, 2)));
        if (Util.isNullOrNil(njVar.KSM)) {
            AppMethodBeat.o(6510);
            return;
        }
        Log.i(TAG, "getAppMsgRelatedInfo size=" + njVar.KSM.size());
        njVar.Scene = i2;
        LinkedList<gg> linkedList2 = njVar.KSM;
        p.g(linkedList2, "req.UrlInfo");
        for (T t2 : linkedList2) {
            pns.put(t2.izX, 1);
            r rVar2 = pnt;
            String str2 = t2.izX;
            p.g(str2, "info.ClientId");
            rVar2.add(str2);
            if (Log.getLogLevel() == 0) {
                Log.v(TAG, "getAppMsgRelatedInfo url=" + t2.Url + ", clientId=" + t2.izX);
            }
        }
        d.a aVar = new d.a();
        aVar.c(njVar);
        aVar.d(new nk());
        aVar.MB("/cgi-bin/mmbiz-bin/timeline/bizappmsgrelatedinfo");
        aVar.sG(2864);
        aVar.sI(0);
        aVar.sJ(0);
        IPCRunCgi.a(aVar.aXF(), new c(njVar, i2));
        AppMethodBeat.o(6510);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    public static final class c implements IPCRunCgi.a {
        final /* synthetic */ int $scene;
        final /* synthetic */ nj pnA;

        c(nj njVar, int i2) {
            this.pnA = njVar;
            this.$scene = i2;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(6505);
            g gVar = g.pnw;
            Log.i(g.TAG, "getAppMsgRelatedInfo errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
            LinkedList<gg> linkedList = this.pnA.KSM;
            p.g(linkedList, "req.UrlInfo");
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                g gVar2 = g.pnw;
                g.pns.remove(it.next().izX);
            }
            if (i2 == 0 && i3 == 0) {
                p.g(dVar, "rr");
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizAppMsgRelatedInfoResp");
                    AppMethodBeat.o(6505);
                    throw tVar;
                }
                final nk nkVar = (nk) aYK;
                g gVar3 = g.pnw;
                MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(g.TAG);
                mmkv.encode("BizAppMsgRelatedInfoRefreshIntervalSec", nkVar.KSO);
                com.tencent.mm.plugin.brandservice.ui.b.a.pMl = nkVar.KSO;
                mmkv.encode("BizAppMsgRelatedInfoMaxUrlCount", nkVar.KSP);
                if (Util.isNullOrNil(nkVar.KSN)) {
                    g gVar4 = g.pnw;
                    Log.w(g.TAG, "getAppMsgRelatedInfo RelatedInfo is empty");
                    AppMethodBeat.o(6505);
                    return;
                }
                h.RTc.b(new Runnable(this) {
                    /* class com.tencent.mm.plugin.brandservice.b.g.c.AnonymousClass1 */
                    final /* synthetic */ c pnB;

                    {
                        this.pnB = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(6504);
                        g gVar = g.pnw;
                        LinkedList<com.tencent.mm.ag.p> linkedList = nkVar.KSN;
                        p.g(linkedList, "response.RelatedInfo");
                        LinkedList<gg> linkedList2 = this.pnB.pnA.KSM;
                        p.g(linkedList2, "req.UrlInfo");
                        g.a(linkedList, linkedList2, this.pnB.$scene);
                        AppMethodBeat.o(6504);
                    }
                }, "getAppMsgRelatedInfo");
                AppMethodBeat.o(6505);
                return;
            }
            AppMethodBeat.o(6505);
        }
    }

    public static int clK() {
        int i2 = 300;
        AppMethodBeat.i(6511);
        int decodeInt = MultiProcessMMKV.getMMKV(TAG).decodeInt("BizAppMsgRelatedInfoRefreshIntervalSec", 300);
        Log.v(TAG, "refreshIntervalSec = ".concat(String.valueOf(decodeInt)));
        int min = Math.min(decodeInt, (int) LocalCache.TIME_DAY);
        if (min > 0) {
            i2 = min;
        }
        AppMethodBeat.o(6511);
        return i2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.brandservice.model.MPDataLogic$getAppMsgRelatedInfo$1", f = "MPDataLogic.kt", hxM = {FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend")
    public static final class b extends kotlin.d.b.a.j implements m<ai, kotlin.d.d<? super x>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ String mkH;
        private ai p$;
        final /* synthetic */ int pmn;
        final /* synthetic */ int pmo;
        final /* synthetic */ int pms;
        final /* synthetic */ long pny;
        final /* synthetic */ int pnz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(long j2, String str, int i2, int i3, int i4, int i5, kotlin.d.d dVar) {
            super(2, dVar);
            this.pny = j2;
            this.mkH = str;
            this.pmn = i2;
            this.pms = i3;
            this.pnz = i4;
            this.pmo = i5;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(6502);
            p.h(dVar, "completion");
            b bVar = new b(this.pny, this.mkH, this.pmn, this.pms, this.pnz, this.pmo, dVar);
            bVar.p$ = (ai) obj;
            AppMethodBeat.o(6502);
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(6503);
            Object invokeSuspend = ((b) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(6503);
            return invokeSuspend;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b8, code lost:
            r0 = com.tencent.mm.plugin.brandservice.b.g.pnw;
            com.tencent.mm.sdk.platformtools.Log.v(com.tencent.mm.plugin.brandservice.b.g.TAG, "getAppMsgRelatedInfo size:" + r1.size());
            r1 = new java.util.ArrayList();
            r5 = kotlin.a.j.m(r1).iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ed, code lost:
            if (r5.hasNext() == false) goto L_0x010f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ef, code lost:
            r2 = r5.next();
            r0 = (java.util.List) r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f6, code lost:
            if (r0 == null) goto L_0x010d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fe, code lost:
            if ((r0.get(0) instanceof java.lang.String) == false) goto L_0x010d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0100, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0101, code lost:
            if (r0 == false) goto L_0x00e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0103, code lost:
            r1.add(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x010d, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x010f, code lost:
            r5 = new java.util.HashSet();
            r2 = new java.util.ArrayList();
            r6 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0125, code lost:
            if (r6.hasNext() == false) goto L_0x0150;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0127, code lost:
            r1 = r6.next();
            r0 = ((java.util.List) r1).get(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0132, code lost:
            if (r0 != null) goto L_0x0140;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0134, code lost:
            r0 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.o(6501);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x013f, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x014a, code lost:
            if (r5.add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.aib((java.lang.String) r0)) == false) goto L_0x0121;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x014c, code lost:
            r2.add(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0150, code lost:
            r0 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0157, code lost:
            if (r0.isEmpty() != false) goto L_0x023e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0159, code lost:
            r5 = new java.util.LinkedList();
            r1 = new java.util.ArrayList();
            r6 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x016f, code lost:
            if (r6.hasNext() == false) goto L_0x0196;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0171, code lost:
            r2 = r6.next();
            r0 = ((java.util.List) r2).get(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x017c, code lost:
            if (r0 != null) goto L_0x018a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x017e, code lost:
            r0 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.o(6501);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0189, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0190, code lost:
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt.isMpArticleUrl((java.lang.String) r0) == false) goto L_0x016b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0192, code lost:
            r1.add(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0196, code lost:
            r2 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x01a2, code lost:
            if (r2.hasNext() == false) goto L_0x0237;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x01a4, code lost:
            r1 = (java.util.List) r2.next();
            r6 = new com.tencent.mm.protocal.protobuf.gg();
            r0 = r1.get(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x01b4, code lost:
            if (r0 != null) goto L_0x01c2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x01b6, code lost:
            r0 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.o(6501);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x01c1, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x01c2, code lost:
            r6.Url = (java.lang.String) r0;
            r0 = com.tencent.mm.plugin.brandservice.b.g.pnw;
            r0 = r6.Url;
            kotlin.g.b.p.g(r0, "appMsgUrlInfo.Url");
            r6.izX = com.tencent.mm.plugin.brandservice.b.g.ahJ(r0);
            r0 = r1.get(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x01da, code lost:
            if (r0 != null) goto L_0x01e8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x01dc, code lost:
            r0 = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
            com.tencent.matrix.trace.core.AppMethodBeat.o(6501);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e7, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x01e8, code lost:
            r6.iAb = ((java.lang.Integer) r0).intValue();
            r6.ReqType = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x01f8, code lost:
            if (r1.size() <= r10.pnz) goto L_0x0232;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x01fa, code lost:
            r0 = r1.get(r10.pnz);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0200, code lost:
            if (r0 != null) goto L_0x020e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0202, code lost:
            r0 = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
            com.tencent.matrix.trace.core.AppMethodBeat.o(6501);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x020d, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0214, code lost:
            if (((java.lang.Integer) r0).intValue() <= 0) goto L_0x0232;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0216, code lost:
            r0 = r1.get(r10.pnz);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x021c, code lost:
            if (r0 != null) goto L_0x022a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x021e, code lost:
            r0 = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
            com.tencent.matrix.trace.core.AppMethodBeat.o(6501);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0229, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x022a, code lost:
            r6.ReqType = ((java.lang.Integer) r0).intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0232, code lost:
            r5.add(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x0237, code lost:
            r0 = com.tencent.mm.plugin.brandservice.b.g.pnw;
            com.tencent.mm.plugin.brandservice.b.g.b(r5, r10.pmo);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x023e, code lost:
            r0 = kotlin.x.SXb;
            com.tencent.matrix.trace.core.AppMethodBeat.o(6501);
         */
        @Override // kotlin.d.b.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
            // Method dump skipped, instructions count: 590
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.b.g.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final /* synthetic */ void a(LinkedList linkedList, LinkedList linkedList2, int i2) {
        Object obj;
        boolean z;
        AppMethodBeat.i(6513);
        Log.i(TAG, "getAppMsgRelatedInfo RelatedInfo size=" + linkedList.size());
        Iterator it = linkedList.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            com.tencent.mm.ag.p pVar = (com.tencent.mm.ag.p) it.next();
            if (!Util.isNullOrNil(pVar.Url)) {
                Iterator it2 = linkedList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it2.next();
                    if (Util.isEqual(pVar.izX, ((gg) next).izX)) {
                        obj = next;
                        break;
                    }
                }
                gg ggVar = (gg) obj;
                if (ggVar != null) {
                    String str = ggVar.Url;
                    p.g(str, "urlInfo.Url");
                    if (ahK(str)) {
                        String str2 = ggVar.Url;
                        p.g(str2, "urlInfo.Url");
                        String str3 = pVar.Url;
                        p.g(str3, "relatedInfo.Url");
                        com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.fg(str2, str3);
                    }
                    String str4 = ggVar.Url;
                    p.g(str4, "urlInfo.Url");
                    pVar.izX = ahJ(str4);
                    r rVar = pnt;
                    String str5 = pVar.izX;
                    p.g(str5, "relatedInfo.ClientId");
                    rVar.add(str5);
                    a aVar = a.pnx;
                    if (!com.tencent.mm.plugin.brandservice.ui.b.c.b(a.ahL(ggVar.Url), pVar)) {
                        a aVar2 = a.pnx;
                        a.a(pVar);
                        if (pVar.izY != null) {
                            if (pVar.izY.izV == 1) {
                                a aVar3 = a.pmT;
                                String str6 = ggVar.Url;
                                p.g(str6, "urlInfo.Url");
                                aVar3.cE(str6, ggVar.iAb);
                                z2 = true;
                            } else {
                                a aVar4 = a.pmT;
                                if (a.ahI(ggVar.Url)) {
                                    Log.d(TAG, "url pay status: not pay url=" + ggVar.Url);
                                    a aVar5 = a.pmT;
                                    String str7 = ggVar.Url;
                                    p.g(str7, "urlInfo.Url");
                                    a.aH(str7, false);
                                }
                            }
                        }
                        z = true;
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
            }
        }
        if (z2) {
            w wVar = new w();
            wVar.dCO.scene = i2;
            EventCenter.instance.asyncPublish(wVar, Looper.getMainLooper());
        }
        AppMethodBeat.o(6513);
    }
}
