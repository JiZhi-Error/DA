package com.tencent.mm.plugin.appbrand.launching.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0007J\u001a\u0010\u0017\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0003J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J(\u0010\u001d\u001a\u00020\u000b2\u001e\u0010\u001e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u001fj\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u0001`!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter;", "", "()V", "REPORT_TEEN_MODE_TAG", "", "TAG", "collectionSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$InfoWrapper;", "Lkotlin/collections/HashMap;", "addCollection", "", ch.COL_USERNAME, "versionType", "", "checkRemovedCollection", "getAllCollectionList", "getKey", "getNicknameAsync", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "removeCollection", "reportRemoveCollection", "reportTeenModeToast", "runTask", "runnable", "Ljava/lang/Runnable;", "updateCollectionSet", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;", "Lkotlin/collections/ArrayList;", "InfoWrapper", "plugin-appbrand-integration_release"})
public final class a {
    private static HashMap<String, C0737a> mZu = new HashMap<>();
    public static final a mZv = new a();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<WxaAttributes, x> {
        final /* synthetic */ String hLl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(1);
            this.hLl = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(WxaAttributes wxaAttributes) {
            AppMethodBeat.i(228777);
            WxaAttributes wxaAttributes2 = wxaAttributes;
            p.h(wxaAttributes2, "info");
            Log.d("MicroMsg.AppBrandTeenModeReporter", "reportRemoveCollection username: %s, nickname: %s", this.hLl, wxaAttributes2.field_nickname);
            h.INSTANCE.a(20911, 2, this.hLl, wxaAttributes2.field_nickname);
            x xVar = x.SXb;
            AppMethodBeat.o(228777);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
    static final class g extends q implements kotlin.g.a.b<WxaAttributes, x> {
        final /* synthetic */ String hLl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(1);
            this.hLl = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(WxaAttributes wxaAttributes) {
            AppMethodBeat.i(228778);
            WxaAttributes wxaAttributes2 = wxaAttributes;
            p.h(wxaAttributes2, "info");
            Log.d("MicroMsg.AppBrandTeenModeReporter", "reportTeenModeToast username: %s, nickname: %s", this.hLl, wxaAttributes2.field_nickname);
            h.INSTANCE.a(20912, 2, 10, this.hLl, wxaAttributes2.field_nickname);
            x xVar = x.SXb;
            AppMethodBeat.o(228778);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(228787);
        AppMethodBeat.o(228787);
    }

    private a() {
    }

    public static final /* synthetic */ void ac(Runnable runnable) {
        AppMethodBeat.i(228788);
        v(runnable);
        AppMethodBeat.o(228788);
    }

    public static final /* synthetic */ void acp(String str) {
        AppMethodBeat.i(228791);
        acn(str);
        AppMethodBeat.o(228791);
    }

    public static final /* synthetic */ void bZ(String str, int i2) {
        AppMethodBeat.i(228789);
        bX(str, i2);
        AppMethodBeat.o(228789);
    }

    public static final void init() {
        AppMethodBeat.i(228779);
        u uVar = (u) n.W(u.class);
        if (uVar != null) {
            uVar.add(c.mZw);
        }
        ag agVar = (ag) com.tencent.mm.kernel.g.af(ag.class);
        if (agVar != null) {
            agVar.add(d.mZy);
        }
        v(e.mZA);
        AppMethodBeat.o(228779);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class c implements MStorage.IOnStorageChange {
        public static final c mZw = new c();

        static {
            AppMethodBeat.i(228770);
            AppMethodBeat.o(228770);
        }

        c() {
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            Integer num;
            Object obj = null;
            AppMethodBeat.i(228769);
            Object[] objArr = new Object[3];
            objArr[0] = str;
            if (mStorageEventData != null) {
                num = Integer.valueOf(mStorageEventData.eventId);
            } else {
                num = null;
            }
            objArr[1] = num;
            if (mStorageEventData != null) {
                obj = mStorageEventData.obj;
            }
            objArr[2] = obj;
            Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo starAppStorage onNotifyChanged event: %s, eventId: %s, eventData.obj: %s", objArr);
            if (mStorageEventData == null || mStorageEventData.eventId != 2) {
                if (mStorageEventData == null) {
                    AppMethodBeat.o(228769);
                    return;
                } else if (mStorageEventData.eventId == 5 && (mStorageEventData.obj instanceof u.a)) {
                    Object obj2 = mStorageEventData.obj;
                    if (obj2 == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appusage.AppBrandStarAppStorage.AppBrandStarAppRecord");
                        AppMethodBeat.o(228769);
                        throw tVar;
                    }
                    a aVar = a.mZv;
                    a.ac(new b((u.a) obj2));
                }
            } else if (mStorageEventData.obj instanceof u.a) {
                Object obj3 = mStorageEventData.obj;
                if (obj3 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appusage.AppBrandStarAppStorage.AppBrandStarAppRecord");
                    AppMethodBeat.o(228769);
                    throw tVar2;
                }
                a aVar2 = a.mZv;
                a.ac(new RunnableC0738a((u.a) obj3));
                AppMethodBeat.o(228769);
                return;
            }
            AppMethodBeat.o(228769);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.launching.f.a$c$a  reason: collision with other inner class name */
        static final class RunnableC0738a implements Runnable {
            final /* synthetic */ u.a mZx;

            RunnableC0738a(u.a aVar) {
                this.mZx = aVar;
            }

            public final void run() {
                AppMethodBeat.i(228767);
                a aVar = a.mZv;
                a.bZ(this.mZx.field_username, this.mZx.field_versionType);
                AppMethodBeat.o(228767);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ u.a mZx;

            b(u.a aVar) {
                this.mZx = aVar;
            }

            public final void run() {
                AppMethodBeat.i(228768);
                a aVar = a.mZv;
                a.ca(this.mZx.field_username, this.mZx.field_versionType);
                a.acp(this.mZx.field_username);
                AppMethodBeat.o(228768);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class d implements MStorage.IOnStorageChange {
        public static final d mZy = new d();

        static {
            AppMethodBeat.i(228774);
            AppMethodBeat.o(228774);
        }

        d() {
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            Object obj = null;
            AppMethodBeat.i(228773);
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = mStorageEventData != null ? Integer.valueOf(mStorageEventData.eventId) : null;
            if (mStorageEventData != null) {
                obj = mStorageEventData.obj;
            }
            objArr[2] = obj;
            Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo collectionStorage onNotifyChanged event: %s, eventId: %s, eventData.obj: %s", objArr);
            if (mStorageEventData != null) {
                if (mStorageEventData.eventId == 3 && p.j(str, MStorageEventData.EventType.BATCH) && mStorageEventData.obj == null) {
                    a aVar = a.mZv;
                    a.ac(AnonymousClass1.mZz);
                }
                AppMethodBeat.o(228773);
                return;
            }
            AppMethodBeat.o(228773);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        public static final e mZA = new e();

        static {
            AppMethodBeat.i(228776);
            AppMethodBeat.o(228776);
        }

        e() {
        }

        public final void run() {
            AppMethodBeat.i(228775);
            a aVar = a.mZv;
            a.bOm();
            AppMethodBeat.o(228775);
        }
    }

    private static void I(ArrayList<AppBrandRecentTaskInfo> arrayList) {
        AppMethodBeat.i(228780);
        mZu.clear();
        if (arrayList != null) {
            for (T t : arrayList) {
                if (t != null) {
                    String str = ((AppBrandRecentTaskInfo) t).username;
                    if (!(str == null || str.length() == 0)) {
                        Log.i("MicroMsg.AppBrandTeenModeReporter", "getAllCollectionList info: %s, %d", ((AppBrandRecentTaskInfo) t).username, Integer.valueOf(((AppBrandRecentTaskInfo) t).iOo));
                        bX(((AppBrandRecentTaskInfo) t).username, ((AppBrandRecentTaskInfo) t).iOo);
                    }
                }
            }
            AppMethodBeat.o(228780);
            return;
        }
        AppMethodBeat.o(228780);
    }

    private static void bX(String str, int i2) {
        AppMethodBeat.i(228781);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(228781);
            return;
        }
        String bY = bY(str, i2);
        C0737a aVar = new C0737a();
        aVar.setUsername(str);
        aVar.iOo = i2;
        mZu.put(bY, aVar);
        Log.i("MicroMsg.AppBrandTeenModeReporter", "addCollection %s, %d, %d", str, Integer.valueOf(i2), Integer.valueOf(mZu.size()));
        AppMethodBeat.o(228781);
    }

    private static String bY(String str, int i2) {
        AppMethodBeat.i(228782);
        String str2 = str + ',' + i2;
        AppMethodBeat.o(228782);
        return str2;
    }

    private static final void acn(String str) {
        AppMethodBeat.i(228783);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(228783);
            return;
        }
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        if (!((com.tencent.mm.plugin.teenmode.a.b) af).Vt()) {
            AppMethodBeat.o(228783);
            return;
        }
        e(str, new f(str));
        AppMethodBeat.o(228783);
    }

    public static final void aco(String str) {
        AppMethodBeat.i(228784);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(228784);
            return;
        }
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        if (!((com.tencent.mm.plugin.teenmode.a.b) af).Vt()) {
            AppMethodBeat.o(228784);
            return;
        }
        e(str, new g(str));
        AppMethodBeat.o(228784);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$getNicknameAsync$1", "Lcom/tencent/mm/plugin/appbrand/service/IWeAppInfoService$IGetWeAppInfoCallback;", "onGetWeAppInfo", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "plugin-appbrand-integration_release"})
    public static final class b implements q.a {
        final /* synthetic */ kotlin.g.a.b gWe;

        b(kotlin.g.a.b bVar) {
            this.gWe = bVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.service.q.a
        public final void b(WxaAttributes wxaAttributes) {
            AppMethodBeat.i(228766);
            if (wxaAttributes == null) {
                AppMethodBeat.o(228766);
                return;
            }
            this.gWe.invoke(wxaAttributes);
            AppMethodBeat.o(228766);
        }
    }

    private static void e(String str, kotlin.g.a.b<? super WxaAttributes, x> bVar) {
        AppMethodBeat.i(228785);
        ((com.tencent.mm.plugin.appbrand.service.q) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(str, new b(bVar));
        AppMethodBeat.o(228785);
    }

    private static void v(Runnable runnable) {
        AppMethodBeat.i(228786);
        com.tencent.f.h.RTc.e(runnable, "AppBrandTeenModeReporter");
        AppMethodBeat.o(228786);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeReporter$InfoWrapper;", "", "()V", ch.COL_USERNAME, "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "versionType", "", "getVersionType", "()I", "setVersionType", "(I)V", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.launching.f.a$a  reason: collision with other inner class name */
    public static final class C0737a {
        int iOo;
        String username = "";

        public final void setUsername(String str) {
            AppMethodBeat.i(228765);
            p.h(str, "<set-?>");
            this.username = str;
            AppMethodBeat.o(228765);
        }
    }

    public static final /* synthetic */ void ca(String str, int i2) {
        AppMethodBeat.i(228790);
        String str2 = str;
        if (!(str2 == null || str2.length() == 0)) {
            mZu.remove(bY(str, i2));
            Log.i("MicroMsg.AppBrandTeenModeReporter", "removeCollection %s, %d, %d", str, Integer.valueOf(i2), Integer.valueOf(mZu.size()));
        }
        AppMethodBeat.o(228790);
    }

    public static final /* synthetic */ void bOl() {
        Integer num = null;
        AppMethodBeat.i(228792);
        u uVar = (u) n.W(u.class);
        ArrayList<AppBrandRecentTaskInfo> b2 = uVar != null ? uVar.b(Integer.MAX_VALUE, ag.a.ASC) : null;
        Object[] objArr = new Object[1];
        if (b2 != null) {
            num = Integer.valueOf(b2.size());
        }
        objArr[0] = num;
        Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo checkRemovedCollection allCollection: %d", objArr);
        if (b2 != null) {
            for (T t : b2) {
                String str = ((AppBrandRecentTaskInfo) t).username;
                p.g(str, "info.username");
                String bY = bY(str, ((AppBrandRecentTaskInfo) t).iOo);
                Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo checkRemovedCollection key: %s", bY);
                if (mZu.containsKey(bY)) {
                    mZu.remove(bY);
                }
            }
        }
        for (Map.Entry<String, C0737a> entry : mZu.entrySet()) {
            Log.i("MicroMsg.AppBrandTeenModeReporter", "alvinluo checkRemovedCollection needRemove key: %s", entry.getKey());
            acn(entry.getValue().username);
        }
        I(b2);
        AppMethodBeat.o(228792);
    }

    public static final /* synthetic */ void bOm() {
        AppMethodBeat.i(228793);
        u uVar = (u) n.W(u.class);
        I(uVar != null ? uVar.b(Integer.MAX_VALUE, ag.a.ASC) : null);
        AppMethodBeat.o(228793);
    }
}
