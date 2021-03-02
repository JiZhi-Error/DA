package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Bundle;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.r;
import com.tencent.mm.b.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.l.c;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.LinkedList;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002:;B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007J(\u0010+\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0002J\"\u00102\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0002J\u0010\u00103\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020,H\u0002J\u0018\u00105\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u00106\u001a\u00020\u0018J\"\u00105\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u00106\u001a\u00020\u00182\b\u00107\u001a\u0004\u0018\u00010\u0007J \u00108\u001a\n 9*\u0004\u0018\u00010\u00070\u0007*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020$0#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001d\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020$0#¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic;", "", "()V", "PRELOAD_MAX_BYTES", "", "PRELOAD_MIN_BYTES", "TAG", "", "abTest", "", "getAbTest", "()Z", "abTest$delegate", "Lkotlin/Lazy;", "doingCache", "getDoingCache", "setDoingCache", "(Z)V", "fetchQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic$FetchData;", "getFetchQueue", "()Ljava/util/LinkedList;", "jsContextStatus", "", "getJsContextStatus", "()I", "setJsContextStatus", "(I)V", "lastManifestId", "getLastManifestId", "()Ljava/lang/String;", "setLastManifestId", "(Ljava/lang/String;)V", "lruList", "Lcom/tencent/mm/algorithm/MMLRUMap;", "Landroid/os/Bundle;", "getLruList", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "preloadLimiter", "Lcom/tencent/mm/modelbiz/MpDataLimiter;", "getPreloadLimiter", "()Lcom/tencent/mm/modelbiz/MpDataLimiter;", "cacheVideo", "", "data", "processName", "url", "position", "length", "cacheVideoInClientProcess", "doCacheVideo", "doFetch", "preloadVideo", "itemShowType", IssueStorage.COLUMN_EXT_INFO, "getLatest", "kotlin.jvm.PlatformType", "FetchData", "JsStatus", "plugin-brandservice_release"})
public final class e {
    private static final f pAG = g.ah(b.pAR);
    private static final r pAH = new r(BuildInfo.DEBUG ? 1000 : 600000);
    private static final LinkedList<a> pAI = new LinkedList<>();
    private static int pAJ = 1;
    private static String pAK = "";
    private static boolean pAL;
    private static final h<String, Bundle> pAM = new h<>(10);
    public static final e pAN = new e();

    private static boolean cnF() {
        AppMethodBeat.i(195591);
        boolean booleanValue = ((Boolean) pAG.getValue()).booleanValue();
        AppMethodBeat.o(195591);
        return booleanValue;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.brandservice.ui.timeline.preload.BizVideoPreloadLogic$preloadVideo$1", f = "BizVideoPreloadLogic.kt", hxM = {}, m = "invokeSuspend")
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.e$e  reason: collision with other inner class name */
    public static final class C0887e extends j implements m<ai, kotlin.d.d<? super x>, Object> {
        int label;
        final /* synthetic */ String mkH;
        private ai p$;
        final /* synthetic */ String pAW;
        final /* synthetic */ int pmn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0887e(String str, int i2, String str2, kotlin.d.d dVar) {
            super(2, dVar);
            this.mkH = str;
            this.pmn = i2;
            this.pAW = str2;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(195589);
            p.h(dVar, "completion");
            C0887e eVar = new C0887e(this.mkH, this.pmn, this.pAW, dVar);
            eVar.p$ = (ai) obj;
            AppMethodBeat.o(195589);
            return eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(195590);
            Object invokeSuspend = ((C0887e) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(195590);
            return invokeSuspend;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.e$e$a */
        public static final class a extends q implements kotlin.g.a.b<String, x> {
            public static final a pAX = new a();

            static {
                AppMethodBeat.i(195580);
                AppMethodBeat.o(195580);
            }

            a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(String str) {
                AppMethodBeat.i(195579);
                p.h(str, LocaleUtil.ITALIAN);
                Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo JsStatus.INIT_END");
                e eVar = e.pAN;
                e.Dn(3);
                e.a(e.pAN);
                x xVar = x.SXb;
                AppMethodBeat.o(195579);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.e$e$b */
        public static final class b extends q implements kotlin.g.a.b<com.tencent.mm.plugin.ad.a, Integer> {
            public static final b pAY = new b();

            static {
                AppMethodBeat.i(195582);
                AppMethodBeat.o(195582);
            }

            b() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Integer invoke(com.tencent.mm.plugin.ad.a aVar) {
                int i2;
                AppMethodBeat.i(195581);
                com.tencent.mm.plugin.ad.a aVar2 = aVar;
                p.h(aVar2, "manifest");
                String str = aVar2.ICt.LQV;
                p.g(str, "manifest.manifest.ManifestUrl");
                String aWU = com.tencent.mm.plugin.ad.e.aWU(str);
                e eVar = e.pAN;
                if (!Util.isNullOrNil(e.cnI())) {
                    e eVar2 = e.pAN;
                    if (!(!p.j(e.cnI(), aWU))) {
                        e eVar3 = e.pAN;
                        i2 = e.cnH();
                        Integer valueOf = Integer.valueOf(i2);
                        AppMethodBeat.o(195581);
                        return valueOf;
                    }
                }
                e eVar4 = e.pAN;
                e.aig(aWU);
                i2 = 1;
                Integer valueOf2 = Integer.valueOf(i2);
                AppMethodBeat.o(195581);
                return valueOf2;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<no name provided>", "", "path", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.e$e$c */
        public static final class c extends q implements kotlin.g.a.b<String, String> {
            public static final c pAZ = new c();

            static {
                AppMethodBeat.i(195584);
                AppMethodBeat.o(195584);
            }

            c() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ String invoke(String str) {
                AppMethodBeat.i(195583);
                String str2 = str;
                p.h(str2, "path");
                String boY = s.boY(str2);
                AppMethodBeat.o(195583);
                return boY;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<no name provided>", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "url", "", "tmpl", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.e$e$e  reason: collision with other inner class name */
        public static final class C0888e extends q implements m<String, eic, com.tencent.mm.plugin.ad.a> {
            final /* synthetic */ z.f pBb;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0888e(z.f fVar) {
                super(2);
                this.pBb = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ com.tencent.mm.plugin.ad.a invoke(String str, eic eic) {
                AppMethodBeat.i(195587);
                String str2 = str;
                p.h(str2, "url");
                p.h(eic, "tmpl");
                bhd bhd = new bhd();
                bhd.xut = c.getPath(str2);
                bhd.LQV = this.pBb.SYG.pkK;
                bhc bhc = new bhc();
                bhc.LQP = c.getHost(str2);
                bhc.LQU.add(bhd);
                com.tencent.mm.plugin.ad.a aVar = new com.tencent.mm.plugin.ad.a(bhc, bhd, false, 60);
                AppMethodBeat.o(195587);
                return aVar;
            }
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            String str;
            String str2 = null;
            AppMethodBeat.i(195588);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    d dVar = d.pBa;
                    z.f fVar = new z.f();
                    fVar.SYG = null;
                    try {
                        fVar.SYG = (T) ((eic) dVar.invoke());
                        if (fVar.SYG != null) {
                            T t = fVar.SYG;
                            if (s.YS(t != null ? t.Nhr : null)) {
                                try {
                                    c cVar = c.pAZ;
                                    com.tencent.mm.plugin.ad.a aVar2 = (com.tencent.mm.plugin.ad.a) new C0888e(fVar).invoke(this.mkH, fVar.SYG);
                                    e eVar = e.pAN;
                                    e.cnG().add(new a(this.mkH, this.pmn, this.pAW, aVar2));
                                    e eVar2 = e.pAN;
                                    e.Dn(((Number) b.pAY.invoke(aVar2)).intValue());
                                    e eVar3 = e.pAN;
                                    switch (e.cnH()) {
                                        case 1:
                                            Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo JsStatus.SHOULD_INIT");
                                            T t2 = fVar.SYG;
                                            String str3 = t2 != null ? t2.Nhr : null;
                                            p.g(str3, "tmplParams?.initFilePath");
                                            String str4 = (String) cVar.invoke(str3);
                                            if (str4 != null) {
                                                e eVar4 = e.pAN;
                                                e.Dn(2);
                                                y yVar = y.pFf;
                                                y.b(aVar2, str4, a.pAX);
                                                break;
                                            }
                                            break;
                                        case 2:
                                            Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo jsStatus.INIT_ING");
                                            break;
                                        case 3:
                                            e.a(e.pAN);
                                            break;
                                    }
                                    StringBuilder sb = new StringBuilder("[TRACE_VIDEO_PRELOAD] tmplParams initFilePath = ");
                                    T t3 = fVar.SYG;
                                    if (t3 == null || (str = t3.Nhr) == null) {
                                        str = "";
                                    }
                                    StringBuilder append = sb.append(str).append(", WebComponent.info = ");
                                    c.b bVar = com.tencent.mm.plugin.webview.l.c.JDf;
                                    Log.d("MicroMsg.BizVideoPreloadLogic", append.append(c.b.ejA()).toString());
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(195588);
                                    return xVar;
                                } catch (Exception e2) {
                                    x xVar2 = x.SXb;
                                    AppMethodBeat.o(195588);
                                    return xVar2;
                                }
                            }
                        }
                        StringBuilder sb2 = new StringBuilder("[TRACE_VIDEO_PRELOAD] preloadVideo ");
                        T t4 = fVar.SYG;
                        if (t4 != null) {
                            str2 = t4.Nhr;
                        }
                        Log.i("MicroMsg.BizVideoPreloadLogic", sb2.append(str2).append(" not exist").toString());
                        x xVar3 = x.SXb;
                        AppMethodBeat.o(195588);
                        return xVar3;
                    } catch (Exception e3) {
                        Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadVideo exception = ".concat(String.valueOf(e3)));
                        x xVar4 = x.SXb;
                        AppMethodBeat.o(195588);
                        return xVar4;
                    }
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(195588);
                    throw illegalStateException;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<no name provided>", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.e$e$d */
        public static final class d extends q implements kotlin.g.a.a<eic> {
            public static final d pBa = new d();

            static {
                AppMethodBeat.i(195586);
                AppMethodBeat.o(195586);
            }

            d() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ eic invoke() {
                AppMethodBeat.i(195585);
                if (!com.tencent.mm.plugin.biz.b.c.ckw()) {
                    eib DC = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.DC(6);
                    eic eic = new eic();
                    eic.Nhr = u.b(DC) + "videoPrefetcher.js";
                    eic.pkK = DC.KUA;
                    eic.version = DC.Version;
                    AppMethodBeat.o(195585);
                    return eic;
                }
                eic eic2 = new eic();
                eic2.pCV = 6;
                eic2.version = (int) (System.currentTimeMillis() / 1000);
                eic2.Nhr = com.tencent.mm.plugin.biz.b.c.ckv();
                eic2.pkK = com.tencent.mm.plugin.biz.b.c.ckv();
                AppMethodBeat.o(195585);
                return eic2;
            }
        }
    }

    static {
        AppMethodBeat.i(195597);
        com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().hQ(cnF());
        String str = ToolsMpProcessIPCService.dkO;
        p.g(str, "ToolsMpProcessIPCService.PROCESS_NAME");
        Bundle bundle = new Bundle();
        bundle.putBoolean("abTest", cnF());
        com.tencent.mm.ipcinvoker.a.a(str, bundle, AnonymousClass1.pAO, null);
        String str2 = Appbrand0IPCService.dkO;
        p.g(str2, "Appbrand0IPCService.PROCESS_NAME");
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("abTest", cnF());
        com.tencent.mm.ipcinvoker.a.a(str2, bundle2, AnonymousClass2.pAP, null);
        AppMethodBeat.o(195597);
    }

    private e() {
    }

    public static final /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(195598);
        eVar.cnJ();
        AppMethodBeat.o(195598);
    }

    public static final /* synthetic */ void a(e eVar, String str) {
        AppMethodBeat.i(195600);
        eVar.aih(str);
        AppMethodBeat.o(195600);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/BizVideoPreloadLogic$FetchData;", "", "url", "", "itemShowType", "", IssueStorage.COLUMN_EXT_INFO, "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "(Ljava/lang/String;)V", "getItemShowType", "()I", "setItemShowType", "(I)V", "getManifest", "()Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "setManifest", "(Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;)V", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-brandservice_release"})
    public static final class a {
        String extInfo;
        int iwc;
        com.tencent.mm.plugin.ad.a pAQ;
        String url;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
            if (kotlin.g.b.p.j(r3.pAQ, r4.pAQ) != false) goto L_0x0032;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 195569(0x2fbf1, float:2.7405E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0032
                boolean r0 = r4 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.a
                if (r0 == 0) goto L_0x0037
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.e$a r4 = (com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.a) r4
                java.lang.String r0 = r3.url
                java.lang.String r1 = r4.url
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0037
                int r0 = r3.iwc
                int r1 = r4.iwc
                if (r0 != r1) goto L_0x0037
                java.lang.String r0 = r3.extInfo
                java.lang.String r1 = r4.extInfo
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0037
                com.tencent.mm.plugin.ad.a r0 = r3.pAQ
                com.tencent.mm.plugin.ad.a r1 = r4.pAQ
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0037
            L_0x0032:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0036:
                return r0
            L_0x0037:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0036
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(195568);
            String str = this.url;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.iwc) * 31;
            String str2 = this.extInfo;
            int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
            com.tencent.mm.plugin.ad.a aVar = this.pAQ;
            if (aVar != null) {
                i2 = aVar.hashCode();
            }
            int i3 = hashCode2 + i2;
            AppMethodBeat.o(195568);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(195567);
            String str = "FetchData(url=" + this.url + ", itemShowType=" + this.iwc + ", extInfo=" + this.extInfo + ", manifest=" + this.pAQ + ")";
            AppMethodBeat.o(195567);
            return str;
        }

        public a(String str, int i2, String str2, com.tencent.mm.plugin.ad.a aVar) {
            p.h(str, "url");
            p.h(aVar, "manifest");
            AppMethodBeat.i(195566);
            this.url = str;
            this.iwc = i2;
            this.extInfo = str2;
            this.pAQ = aVar;
            AppMethodBeat.o(195566);
        }
    }

    public static LinkedList<a> cnG() {
        return pAI;
    }

    public static void Dn(int i2) {
        pAJ = i2;
    }

    public static int cnH() {
        return pAJ;
    }

    public static void aig(String str) {
        AppMethodBeat.i(195592);
        p.h(str, "<set-?>");
        pAK = str;
        AppMethodBeat.o(195592);
    }

    public static String cnI() {
        return pAK;
    }

    public static void F(String str, int i2, String str2) {
        AppMethodBeat.i(195593);
        if (!cnF()) {
            AppMethodBeat.o(195593);
        } else if (str == null) {
            AppMethodBeat.o(195593);
        } else if (!UrlExKt.isMpArticleUrl(str)) {
            AppMethodBeat.o(195593);
        } else if (i2 >= 0 || !Util.isNullOrNil(str2)) {
            String ahX = c.ahX(str);
            if (pAH.contains(ahX)) {
                Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] preloadLimiter contains id = ".concat(String.valueOf(ahX)));
                AppMethodBeat.o(195593);
                return;
            }
            pAH.add(ahX);
            kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new C0887e(str, i2, str2, null), 2);
            AppMethodBeat.o(195593);
        } else {
            AppMethodBeat.o(195593);
        }
    }

    private final synchronized void cnJ() {
        AppMethodBeat.i(195594);
        if (Util.isNullOrNil(pAI) || pAJ != 3) {
            Log.i("MicroMsg.BizVideoPreloadLogic", "doFetch fetchQueue null, jsContextStatus = " + pAJ);
            AppMethodBeat.o(195594);
        } else {
            a poll = pAI.poll();
            if (poll != null) {
                Log.i("MicroMsg.BizVideoPreloadLogic", "doFetch fetchData = ".concat(String.valueOf(poll)));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("itemShowType", poll.iwc);
                jSONObject.put("preloadType", 0);
                if (!Util.isNullOrNil(poll.extInfo)) {
                    try {
                        jSONObject.put(IssueStorage.COLUMN_EXT_INFO, new JSONObject(poll.extInfo));
                    } catch (Exception e2) {
                    }
                }
                jSONObject.put("scene", 90);
                Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] doFetch url = " + poll.url);
                y yVar = y.pFf;
                com.tencent.mm.plugin.ad.a aVar = poll.pAQ;
                String jSONObject2 = jSONObject.toString();
                p.g(jSONObject2, "json.toString()");
                y.a(aVar, "fetch", kotlin.a.j.listOf((Object[]) new String[]{poll.url, jSONObject2}), d.pAV);
                AppMethodBeat.o(195594);
            } else {
                AppMethodBeat.o(195594);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void c(String str, String str2, long j2, long j3) {
        AppMethodBeat.i(195595);
        if (Util.isNullOrNil(str2)) {
            Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo url error");
            AppMethodBeat.o(195595);
        } else {
            String aaV = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().aaV(str2);
            if (pAM.get(aaV) != null) {
                Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo lruList contains");
                AppMethodBeat.o(195595);
            } else {
                h<String, Bundle> hVar = pAM;
                Bundle bundle = new Bundle();
                bundle.putString("url", str2);
                bundle.putLong("position", j2);
                bundle.putLong("length", j3);
                hVar.put(aaV, bundle);
                Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideo lruList.size = " + pAM.size() + ", position=" + j2 + ", length=" + j3 + ", url=" + str2);
                if (!pAL) {
                    aih(str);
                }
                AppMethodBeat.o(195595);
            }
        }
    }

    private final synchronized void aih(String str) {
        AppMethodBeat.i(195596);
        if (pAM.size() <= 0) {
            Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] doCacheVideo lruList is empty");
            pAL = false;
            AppMethodBeat.o(195596);
        } else {
            pAL = true;
            z.f fVar = new z.f();
            Set<String> keySet = pAM.keySet();
            p.g(keySet, "this.keySet()");
            String str2 = (String) kotlin.a.j.g(keySet);
            if (str2 == null) {
                AppMethodBeat.o(195596);
            } else {
                T t = (T) ((Bundle) pAM.get(str2));
                if (t == null) {
                    AppMethodBeat.o(195596);
                } else {
                    fVar.SYG = t;
                    pAM.remove(str2);
                    kotlinx.coroutines.f.b(bn.TUK, (kotlin.d.f) null, new c(str, fVar, null), 3);
                    AppMethodBeat.o(195596);
                }
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        public static final b pAR = new b();

        static {
            AppMethodBeat.i(195571);
            AppMethodBeat.o(195571);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(195570);
            com.tencent.mm.plugin.expt.b.b bVar = (com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
            if ((bVar == null || bVar.a(b.a.clicfg_open_timeline_video_preload, 0) != 1) && !BuildInfo.IS_FLAVOR_RED && !BuildInfo.DEBUG && !WeChatEnvironment.hasDebugger()) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(195570);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.brandservice.ui.timeline.preload.BizVideoPreloadLogic$doCacheVideo$2", f = "BizVideoPreloadLogic.kt", hxM = {276}, m = "invokeSuspend")
    public static final class c extends j implements m<ai, kotlin.d.d<? super x>, Object> {
        Object L$0;
        int label;
        private ai p$;
        final /* synthetic */ String pAS;
        final /* synthetic */ z.f pAT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, z.f fVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.pAS = str;
            this.pAT = fVar;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(195575);
            p.h(dVar, "completion");
            c cVar = new c(this.pAS, this.pAT, dVar);
            cVar.p$ = (ai) obj;
            AppMethodBeat.o(195575);
            return cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(195576);
            Object invokeSuspend = ((c) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(195576);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(195574);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ai aiVar = this.p$;
                    com.tencent.mm.ipcinvoker.a.a(this.pAS, this.pAT.SYG, AnonymousClass1.pAU, null);
                    this.L$0 = aiVar;
                    this.label = 1;
                    if (au.a(1000, this) == aVar) {
                        AppMethodBeat.o(195574);
                        return aVar;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(195574);
                    throw illegalStateException;
            }
            e.a(e.pAN, this.pAS);
            x xVar = x.SXb;
            AppMethodBeat.o(195574);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<String, x> {
        public static final d pAV = new d();

        static {
            AppMethodBeat.i(195578);
            AppMethodBeat.o(195578);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(195577);
            e.a(e.pAN);
            x xVar = x.SXb;
            AppMethodBeat.o(195577);
            return xVar;
        }
    }

    public static final /* synthetic */ void s(String str, long j2, long j3) {
        AppMethodBeat.i(195599);
        if (j2 < 0 || j3 <= 0) {
            Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideoInClientProcess params invalid position=" + j2 + ", length=" + j3);
            AppMethodBeat.o(195599);
            return;
        }
        long f2 = com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().f(str, j2, j3);
        Log.i("MicroMsg.BizVideoPreloadLogic", "[TRACE_VIDEO_PRELOAD] cacheVideoInClientProcess cacheByte = " + f2 + ", length = " + j3 + ", url = " + str);
        if (f2 <= 0) {
            com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE().o(str, j2, j3);
        }
        AppMethodBeat.o(195599);
    }
}
