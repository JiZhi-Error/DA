package com.tencent.mm.plugin.appbrand.launching;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.x;
import com.tencent.mm.plugin.appbrand.launching.y;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.o;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001f !B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J°\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0004\u0012\u00020\u00060\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u00132\u001c\b\u0002\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00060\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor;", "", "()V", "TAG", "", "waitForPkgList", "", "appId", "version", "", "versionType", "requestedModuleNames", "", "pickedModuleInfoList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaWidgetInfo;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "onSuccess", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "onProgress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "onError", "Lkotlin/Function2;", "forceNoEncrypt", "", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "reporter", "Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "IReporter", "InnerBatchGetDownloadCgiExecutor", "InnerBatchProgressEmitter", "plugin-appbrand-integration_release"})
public final class l {
    public static final l mSI = new l();

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$IReporter;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$IReporter;", "onAllPkgDownloaded", "", "onPkgDownloadError", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "plugin-appbrand-integration_release"})
    public interface a extends x.c {

        @kotlin.l(hxD = {1, 1, 16})
        /* renamed from: com.tencent.mm.plugin.appbrand.launching.l$a$a  reason: collision with other inner class name */
        public static final class C0739a {
            public static void a(x.d dVar, x.e eVar) {
                AppMethodBeat.i(228619);
                p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                p.h(eVar, "response");
                p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                p.h(eVar, "response");
                AppMethodBeat.o(228619);
            }
        }

        void a(x.d dVar);

        void bNs();
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
    static final class d extends q implements kotlin.g.a.b<x.e, kotlin.x> {
        final /* synthetic */ x.d kQl;
        final /* synthetic */ kotlin.g.a.b lza;
        final /* synthetic */ ConcurrentSkipListSet mSO;
        final /* synthetic */ b mSP;
        final /* synthetic */ c mSQ;
        final /* synthetic */ HashSet mSR;
        final /* synthetic */ h mSS;
        final /* synthetic */ a mST;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ConcurrentSkipListSet concurrentSkipListSet, x.d dVar, b bVar, c cVar, HashSet hashSet, h hVar, kotlin.g.a.b bVar2, a aVar) {
            super(1);
            this.mSO = concurrentSkipListSet;
            this.kQl = dVar;
            this.mSP = bVar;
            this.mSQ = cVar;
            this.mSR = hashSet;
            this.mSS = hVar;
            this.lza = bVar2;
            this.mST = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(x.e eVar) {
            AppMethodBeat.i(228622);
            x.e eVar2 = eVar;
            p.h(eVar2, "response");
            boolean add = this.mSO.add(eVar2.mUo);
            Log.i("MicroMsg.AppBrand.BatchGetCodePkgExecutor", "waitForPkg " + this.kQl + " onSuccess(" + eVar2.mUo.pkgVersion() + '|' + eVar2.mUp + ") added(" + add + ')');
            if (add) {
                if (eVar2.mUp == x.f.CACHED) {
                    b bVar = this.mSP;
                    bVar.mSJ--;
                    bVar.bNt();
                }
                c cVar = this.mSQ;
                x.d dVar = this.kQl;
                p.g(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                String pkgPath = eVar2.mUo.pkgPath();
                p.g(pkgPath, "response.pkgInfo.pkgPath()");
                cVar.a(dVar, pkgPath);
                if (this.mSO.size() == this.mSR.size()) {
                    this.mSS.dead();
                    this.lza.invoke(j.p(this.mSO));
                    a aVar = this.mST;
                    if (aVar != null) {
                        aVar.bNs();
                    }
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(228622);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "err", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "errMsg", "", "invoke"})
    static final class e extends q implements m<x.a, String, kotlin.x> {
        final /* synthetic */ x.d kQl;
        final /* synthetic */ h mSS;
        final /* synthetic */ a mST;
        final /* synthetic */ AtomicBoolean mSU;
        final /* synthetic */ m mSV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(h hVar, x.d dVar, AtomicBoolean atomicBoolean, m mVar, a aVar) {
            super(2);
            this.mSS = hVar;
            this.kQl = dVar;
            this.mSU = atomicBoolean;
            this.mSV = mVar;
            this.mST = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(x.a aVar, String str) {
            AppMethodBeat.i(228623);
            x.a aVar2 = aVar;
            String str2 = str;
            p.h(aVar2, "err");
            this.mSS.dead();
            Log.e("MicroMsg.AppBrand.BatchGetCodePkgExecutor", "waitForPkg " + this.kQl + " onError(" + aVar2 + ' ' + str2 + "), stack=" + android.util.Log.getStackTraceString(new Throwable()));
            if (!this.mSU.getAndSet(true)) {
                this.mSV.invoke(Integer.valueOf(aVar2.code), str2);
                this.mSU.set(true);
            }
            a aVar3 = this.mST;
            if (aVar3 != null) {
                x.d dVar = this.kQl;
                p.g(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                aVar3.a(dVar);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(228623);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "progress", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "invoke"})
    static final class f extends q implements kotlin.g.a.b<WxaPkgLoadProgress, kotlin.x> {
        final /* synthetic */ x.d kQl;
        final /* synthetic */ c mSQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(c cVar, x.d dVar) {
            super(1);
            this.mSQ = cVar;
            this.kQl = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(WxaPkgLoadProgress wxaPkgLoadProgress) {
            AppMethodBeat.i(228624);
            WxaPkgLoadProgress wxaPkgLoadProgress2 = wxaPkgLoadProgress;
            p.h(wxaPkgLoadProgress2, "progress");
            c cVar = this.mSQ;
            x.d dVar = this.kQl;
            p.g(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            cVar.a(dVar, wxaPkgLoadProgress2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(228624);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "kotlin.jvm.PlatformType", "o2", "compare"})
    static final class g<T> implements Comparator<IPkgInfo> {
        public static final g mSW = new g();

        static {
            AppMethodBeat.i(228626);
            AppMethodBeat.o(228626);
        }

        g() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
        @Override // java.util.Comparator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ int compare(com.tencent.mm.plugin.appbrand.appcache.IPkgInfo r5, com.tencent.mm.plugin.appbrand.appcache.IPkgInfo r6) {
            /*
            // Method dump skipped, instructions count: 127
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.l.g.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    static {
        AppMethodBeat.i(180492);
        AppMethodBeat.o(180492);
    }

    private l() {
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$waitForPkgList$qualityReportListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/KV14609ReportEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
    public static final class h extends IListener<lf> {
        final /* synthetic */ String kPQ;
        final /* synthetic */ int kQC;
        final /* synthetic */ int kQh;
        final /* synthetic */ QualitySession mSX;

        h(String str, int i2, int i3, QualitySession qualitySession) {
            this.kPQ = str;
            this.kQC = i2;
            this.kQh = i3;
            this.mSX = qualitySession;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lf lfVar) {
            lf.a aVar;
            kv_14609 kv_14609;
            AppMethodBeat.i(180490);
            lf lfVar2 = lfVar;
            if (lfVar2 != null && (aVar = lfVar2.dQt) != null && (kv_14609 = aVar.dQu) != null && p.j(this.kPQ, kv_14609.appId) && this.kQC == kv_14609.mVo && this.kQh == kv_14609.brf()) {
                com.tencent.mm.plugin.appbrand.report.quality.g.a(kv_14609, this.mSX);
            }
            AppMethodBeat.o(180490);
            return false;
        }
    }

    public static void a(String str, int i2, int i3, List<String> list, Map<String, ? extends WxaAttributes.WxaWidgetInfo> map, QualitySession qualitySession, kotlin.g.a.b<? super List<? extends IPkgInfo>, kotlin.x> bVar, kotlin.g.a.b<? super WxaPkgLoadProgress, kotlin.x> bVar2, m<? super Integer, ? super String, kotlin.x> mVar, boolean z, acc acc, a aVar) {
        int i4;
        AppMethodBeat.i(228627);
        p.h(str, "appId");
        p.h(list, "requestedModuleNames");
        p.h(map, "pickedModuleInfoList");
        p.h(qualitySession, "reportQualitySession");
        p.h(bVar, "onSuccess");
        p.h(bVar2, "onProgress");
        p.h(mVar, "onError");
        p.h(acc, "cgiCommRequestSource");
        h hVar = new h(str, i2, i3, qualitySession);
        hVar.alive();
        HashSet hashSet = new HashSet();
        for (String str2 : list) {
            WxaAttributes.WxaWidgetInfo wxaWidgetInfo = (WxaAttributes.WxaWidgetInfo) map.get(str2);
            if (wxaWidgetInfo == null) {
                IllegalStateException illegalStateException = new IllegalStateException(("Invalid ModuleName(" + str2 + ')').toString());
                AppMethodBeat.o(228627);
                throw illegalStateException;
            }
            int i5 = wxaWidgetInfo.packageType;
            if (j.a.vP(i3)) {
                i4 = i2;
            } else {
                i4 = 0;
            }
            hashSet.add(new x.d(str, str2, i5, i3, new x.g.b(i4), z));
            v vVar = wxaWidgetInfo.lhk;
            if (vVar == null) {
                vVar = v.SXr;
            }
            for (WxaAttributes.WxaPluginCodeInfo wxaPluginCodeInfo : vVar) {
                p.g(wxaPluginCodeInfo, "plugin");
                hashSet.add(o.a(wxaPluginCodeInfo));
            }
        }
        if (hashSet.size() <= 0) {
            IllegalStateException illegalStateException2 = new IllegalStateException("RequestPkgInfoList.size==0".toString());
            AppMethodBeat.o(228627);
            throw illegalStateException2;
        }
        b bVar3 = new b(hashSet.size(), acc);
        c cVar = new c(bVar2);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentSkipListSet concurrentSkipListSet = new ConcurrentSkipListSet(g.mSW);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            x.d dVar = (x.d) it.next();
            x.b bVar4 = x.mTR;
            p.g(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            x.b.a(dVar, new d(concurrentSkipListSet, dVar, bVar3, cVar, hashSet, hVar, bVar, aVar), new e(hVar, dVar, atomicBoolean, mVar, aVar), new f(cVar, dVar), bVar3, acc, aVar, 32);
        }
        AppMethodBeat.o(228627);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchProgressEmitter;", "", "onProgress", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgLoadProgress;", "", "(Lkotlin/jvm/functions/Function1;)V", "progressMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Request;", "Lkotlin/collections/HashMap;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "progress", "onReady", "filePath", "", "plugin-appbrand-integration_release"})
    static final class c {
        private final HashMap<x.d, WxaPkgLoadProgress> mSM = new HashMap<>();
        private final kotlin.g.a.b<WxaPkgLoadProgress, kotlin.x> mSN;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.g.a.b<? super com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress, kotlin.x> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(kotlin.g.a.b<? super WxaPkgLoadProgress, kotlin.x> bVar) {
            p.h(bVar, "onProgress");
            AppMethodBeat.i(180486);
            this.mSN = bVar;
            AppMethodBeat.o(180486);
        }

        public final void a(x.d dVar, WxaPkgLoadProgress wxaPkgLoadProgress) {
            WxaPkgLoadProgress wxaPkgLoadProgress2;
            AppMethodBeat.i(180484);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(wxaPkgLoadProgress, "progress");
            synchronized (this.mSM) {
                try {
                    this.mSM.put(dVar, wxaPkgLoadProgress);
                    long j2 = 0;
                    long j3 = 0;
                    Collection<WxaPkgLoadProgress> values = this.mSM.values();
                    p.g(values, "progressMap.values");
                    Iterator<T> it = values.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            T next = it.next();
                            if (next == null) {
                                wxaPkgLoadProgress2 = null;
                                break;
                            } else {
                                j2 += Math.max(next.kNs, 0L);
                                j3 += Math.max(next.kNt, 0L);
                            }
                        } else {
                            wxaPkgLoadProgress2 = new WxaPkgLoadProgress(j3 <= 0 ? 0 : kotlin.h.a.cR((((float) j2) / ((float) j3)) * 100.0f), j2, j3);
                        }
                    }
                } finally {
                    AppMethodBeat.o(180484);
                }
            }
            if (wxaPkgLoadProgress2 != null) {
                this.mSN.invoke(wxaPkgLoadProgress2);
            }
        }

        public final void a(x.d dVar, String str) {
            AppMethodBeat.i(180485);
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(str, "filePath");
            if (this.mSM.size() > 0) {
                long boW = s.boW(str);
                a(dVar, new WxaPkgLoadProgress(100, boW, boW));
            }
            AppMethodBeat.o(180485);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ^\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\t2\u001a\u0010\u0018\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\u0004\u0012\u00020\u000e0\u000b2 \u0010\u0019\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000e0\u000f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R§\u0001\u0010\u0007\u001a\u0001\u0012\u0004\u0012\u00020\t\u0012B\u0012@\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000e0\u000f0\nj\u0002`\u00110\bjL\u0012\u0004\u0012\u00020\t\u0012B\u0012@\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000e0\u000f0\nj\u0002`\u0011`\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/BatchGetCodePkgExecutor$InnerBatchGetDownloadCgiExecutor;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor;", "maxPossibleRequestCount", "", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "(ILcom/tencent/mm/protocal/protobuf/CommRequestSource;)V", "requestMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/IGetDownloadUrlCgiExecutor$LocalUnifiedGetDownloadUrlRequest;", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "", "Lkotlin/Function3;", "", "Lcom/tencent/mm/plugin/appbrand/launching/CgiCallbackPair;", "Lkotlin/collections/HashMap;", "scene", "decreasePossibleRequestCount", "fireAllRequestsIfNeed", "waitForDownloadUrl", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "onSuccess", "onError", "plugin-appbrand-integration_release"})
    static final class b implements y {
        final HashMap<y.b, o<kotlin.g.a.b<bmm[], kotlin.x>, kotlin.g.a.q<Integer, Integer, String, kotlin.x>>> lQW = new HashMap<>();
        int mSJ;
        private final acc mSK;
        private int scene;

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "batchResp", "Lcom/tencent/mm/protocal/protobuf/BatchGetDownloadUrlResponse;", "invoke"})
        public static final class a extends q implements kotlin.g.a.b<kn, kotlin.x> {
            final /* synthetic */ b mSL;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(1);
                this.mSL = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(kn knVar) {
                AppMethodBeat.i(180479);
                kn knVar2 = knVar;
                p.h(knVar2, "batchResp");
                Set<Map.Entry<y.b, o<kotlin.g.a.b<bmm[], kotlin.x>, kotlin.g.a.q<Integer, Integer, String, kotlin.x>>>> entrySet = this.mSL.lQW.entrySet();
                p.g(entrySet, "requestMap.entries");
                for (T t : entrySet) {
                    y.b bVar = (y.b) o.e(t);
                    A a2 = ((o) o.f(t)).first;
                    p.g(bVar, "req");
                    bmm[] a3 = o.a(knVar2, bVar);
                    if (a3 == null) {
                        p.hyc();
                    }
                    a2.invoke(a3);
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(180479);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.appbrand.launching.l$b$b  reason: collision with other inner class name */
        public static final class C0740b extends q implements kotlin.g.a.q<Integer, Integer, String, kotlin.x> {
            final /* synthetic */ b mSL;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0740b(b bVar) {
                super(3);
                this.mSL = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ kotlin.x d(Integer num, Integer num2, String str) {
                AppMethodBeat.i(180480);
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                String str2 = str;
                Collection<o<kotlin.g.a.b<bmm[], kotlin.x>, kotlin.g.a.q<Integer, Integer, String, kotlin.x>>> values = this.mSL.lQW.values();
                p.g(values, "requestMap.values");
                Iterator<T> it = values.iterator();
                while (it.hasNext()) {
                    it.next().second.d(Integer.valueOf(intValue), Integer.valueOf(intValue2), str2);
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(180480);
                return xVar;
            }
        }

        public b(int i2, acc acc) {
            p.h(acc, "cgiCommRequestSource");
            AppMethodBeat.i(228621);
            this.mSJ = i2;
            this.mSK = acc;
            AppMethodBeat.o(228621);
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.y
        public final void a(y.b bVar, kotlin.g.a.b<? super bmm[], kotlin.x> bVar2, kotlin.g.a.q<? super Integer, ? super Integer, ? super String, kotlin.x> qVar, int i2, acc acc) {
            AppMethodBeat.i(228620);
            p.h(bVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(bVar2, "onSuccess");
            p.h(qVar, "onError");
            p.h(acc, "cgiCommRequestSource");
            this.scene = i2;
            this.lQW.put(bVar, new o<>(bVar2, qVar));
            bNt();
            AppMethodBeat.o(228620);
        }

        public final void bNt() {
            AppMethodBeat.i(180482);
            if (this.mSJ != this.lQW.size()) {
                AppMethodBeat.o(180482);
            } else if (this.lQW.size() <= 0) {
                AppMethodBeat.o(180482);
            } else {
                v.mTG.a(new LinkedList(this.lQW.keySet()), new a(this), new C0740b(this), this.scene, this.mSK);
                AppMethodBeat.o(180482);
            }
        }
    }
}
