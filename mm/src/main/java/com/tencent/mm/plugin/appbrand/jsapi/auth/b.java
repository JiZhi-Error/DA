package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.f.i.h;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "mConcurrentMaxCount", "", "(I)V", "mInFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "mTaskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "cleanup", "", "dispatch", "task", "dispatchNext", "execute", ProviderConstants.API_PATH, "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "schedule", "Companion", "luggage-wechat-full-sdk_release"})
public final class b implements c {
    private static final HashMap<String, b> lFh = new HashMap<>();
    private static final c lFi = C0629b.lFk;
    @Deprecated
    public static final a lFj = new a((byte) 0);
    private final LinkedBlockingQueue<h> lFe = new LinkedBlockingQueue<>();
    private final AtomicInteger lFf = new AtomicInteger(0);
    private final int lFg;

    public static final c U(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(50443);
        c U = a.U(appBrandRuntime);
        AppMethodBeat.o(50443);
        return U;
    }

    public b(int i2) {
        AppMethodBeat.i(50439);
        this.lFg = i2;
        AppMethodBeat.o(50439);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion;", "", "()V", "DUMMY_IMPL", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "TAG", "", "gAppIdToQueueMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lkotlin/collections/HashMap;", "obtainByRuntime", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c U(AppBrandRuntime appBrandRuntime) {
            b bVar;
            AppMethodBeat.i(50434);
            if (appBrandRuntime == null) {
                c cVar = b.lFi;
                AppMethodBeat.o(50434);
                return cVar;
            }
            synchronized (b.lFh) {
                try {
                    a unused = b.lFj;
                    b bVar2 = (b) b.lFh.get(appBrandRuntime.getAppId());
                    bVar = bVar2 != null ? bVar2 : (c) new C0628a(appBrandRuntime).invoke();
                } finally {
                    AppMethodBeat.o(50434);
                }
            }
            return bVar;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.b$a$a  reason: collision with other inner class name */
        public static final class C0628a extends q implements kotlin.g.a.a<b> {
            final /* synthetic */ AppBrandRuntime lFl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0628a(AppBrandRuntime appBrandRuntime) {
                super(0);
                this.lFl = appBrandRuntime;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ b invoke() {
                AppBrandGlobalSystemConfig appBrandGlobalSystemConfig;
                AppMethodBeat.i(50433);
                com.tencent.mm.plugin.appbrand.config.l OT = this.lFl.OT();
                if (!(OT instanceof AppBrandSysConfigLU)) {
                    OT = null;
                }
                AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) OT;
                b bVar = new b((appBrandSysConfigLU == null || (appBrandGlobalSystemConfig = appBrandSysConfigLU.czd) == null) ? 10 : appBrandGlobalSystemConfig.ldn);
                a unused = b.lFj;
                b.lFh.put(this.lFl.getAppId(), bVar);
                this.lFl.brl().a(new c.a(this) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.auth.b.a.C0628a.AnonymousClass1 */
                    final /* synthetic */ C0628a lFm;

                    {
                        this.lFm = r1;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.a.c.a
                    public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
                        AppMethodBeat.i(50432);
                        if (bVar == com.tencent.mm.plugin.appbrand.a.b.DESTROYED) {
                            a unused = b.lFj;
                            synchronized (b.lFh) {
                                try {
                                    a unused2 = b.lFj;
                                    b bVar2 = (b) b.lFh.remove(this.lFm.lFl.getAppId());
                                    if (bVar2 != null) {
                                        b.b(bVar2);
                                        x xVar = x.SXb;
                                    }
                                } finally {
                                    AppMethodBeat.o(50432);
                                }
                            }
                            return;
                        }
                        AppMethodBeat.o(50432);
                    }
                });
                AppMethodBeat.o(50433);
                return bVar;
            }
        }
    }

    static {
        AppMethodBeat.i(50440);
        AppMethodBeat.o(50440);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", ProviderConstants.API_PATH, "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "execute"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.b$b  reason: collision with other inner class name */
    static final class C0629b implements c {
        public static final C0629b lFk = new C0629b();

        static {
            AppMethodBeat.i(50431);
            AppMethodBeat.o(50431);
        }

        C0629b() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.c
        public final void a(i iVar, d dVar, JSONObject jSONObject, int i2) {
            AppMethodBeat.i(230068);
            p.h(iVar, ProviderConstants.API_PATH);
            p.h(dVar, "component");
            p.h(jSONObject, "data");
            a unused = b.lFj;
            Log.e("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dummy execute name[" + iVar.getName() + "], callbackId[" + i2 + "], appId[" + dVar.getAppId() + ']');
            AppMethodBeat.o(230068);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.c
    public final void a(i iVar, d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(230069);
        p.h(iVar, ProviderConstants.API_PATH);
        p.h(dVar, "component");
        p.h(jSONObject, "data");
        String str = "name[" + iVar.getName() + "], callbackId[" + i2 + "], appId[" + dVar.getAppId() + ']';
        c cVar = new c(this, dVar, iVar, jSONObject, i2, str);
        Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dispatch ".concat(String.valueOf(str)));
        jSONObject.put("queueLength", this.lFe.size());
        a(cVar);
        AppMethodBeat.o(230069);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$execute$task$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
    public static final class c implements h {
        final /* synthetic */ String $key;
        final /* synthetic */ b lFn;
        final /* synthetic */ d lFo;
        final /* synthetic */ i lFp;
        final /* synthetic */ JSONObject lFq;
        final /* synthetic */ int lyo;

        c(b bVar, d dVar, i iVar, JSONObject jSONObject, int i2, String str) {
            this.lFn = bVar;
            this.lFo = dVar;
            this.lFp = iVar;
            this.lFq = jSONObject;
            this.lyo = i2;
            this.$key = str;
        }

        public final void run() {
            AppMethodBeat.i(50436);
            if (this.lFo.isRunning()) {
                this.lFp.a(this.lFo, this.lFq, this.lyo, new a(new a(this)));
                AppMethodBeat.o(50436);
                return;
            }
            b.a(this.lFn);
            AppMethodBeat.o(50436);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onAuthResult"})
        static final class a implements e {
            final /* synthetic */ c lFr;

            a(c cVar) {
                this.lFr = cVar;
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.e
            public final void bEE() {
                AppMethodBeat.i(50435);
                a unused = b.lFj;
                Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "execute() done, " + this.lFr.$key);
                b.a(this.lFr.lFn);
                AppMethodBeat.o(50435);
            }
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return this.$key;
        }
    }

    private final void a(h hVar) {
        AppMethodBeat.i(183053);
        while (this.lFf.incrementAndGet() > this.lFg) {
            this.lFe.offer(hVar);
            if (this.lFf.decrementAndGet() >= this.lFg) {
                AppMethodBeat.o(183053);
                return;
            }
            h poll = this.lFe.poll();
            if (poll == null) {
                AppMethodBeat.o(183053);
                return;
            }
            hVar = poll;
        }
        Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "schedule " + hVar.getKey());
        hVar.run();
        AppMethodBeat.o(183053);
    }

    public static final /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(50441);
        bVar.lFf.decrementAndGet();
        h poll = bVar.lFe.poll();
        if (poll != null) {
            bVar.a(poll);
            AppMethodBeat.o(50441);
            return;
        }
        AppMethodBeat.o(50441);
    }

    public static final /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(50442);
        bVar.lFe.clear();
        AppMethodBeat.o(50442);
    }
}
