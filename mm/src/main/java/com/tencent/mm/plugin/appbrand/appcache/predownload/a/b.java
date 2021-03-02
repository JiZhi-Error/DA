package com.tencent.mm.plugin.appbrand.appcache.predownload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kq;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.d;
import com.tencent.mm.plugin.appbrand.launching.x;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.stubs.logger.Log;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001a\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/action/ActionGetNormalPkg;", "", "record", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/CmdGetCodePersistentInfo;", "onComplete", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/CmdGetCodePersistentInfo;Lkotlin/jvm/functions/Function0;)V", "isRetryAction", "", "reportId", "", "LOG", "level", "message", "", "reportResult", "isSuccess", "start", "Companion", "plugin-appbrand-integration_release"})
public final class b {
    @Deprecated
    public static final a kPE = new a((byte) 0);
    public final boolean kPB;
    public final com.tencent.mm.plugin.appbrand.appcache.predownload.e.c kPC;
    private final kotlin.g.a.a<x> kPD;
    public final int reportId = this.kPC.field_reportId;

    static {
        AppMethodBeat.i(228037);
        AppMethodBeat.o(228037);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.predownload.a.b$b  reason: collision with other inner class name */
    public static final class C0548b extends q implements kotlin.g.a.b<x.e, kotlin.x> {
        final /* synthetic */ b kPF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0548b(b bVar) {
            super(1);
            this.kPF = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(x.e eVar) {
            AppMethodBeat.i(228032);
            p.h(eVar, LocaleUtil.ITALIAN);
            b.a(this.kPF, "onSuccess");
            ((d) n.W(d.class)).delete(this.kPF.kPC, new String[0]);
            com.tencent.mm.plugin.appbrand.appcache.predownload.d.a aVar = (com.tencent.mm.plugin.appbrand.appcache.predownload.d.a) n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class);
            String str = this.kPF.kPC.field_appId;
            int i2 = this.kPF.kPC.field_version;
            int i3 = this.kPF.kPC.field_packageType;
            String str2 = this.kPF.kPC.field_packageKey;
            int i4 = this.kPF.kPC.field_reportId;
            com.tencent.mm.plugin.appbrand.appcache.predownload.d.b bVar = new com.tencent.mm.plugin.appbrand.appcache.predownload.d.b();
            bVar.field_appId = str;
            bVar.field_version = i2;
            bVar.field_packageType = i3;
            bVar.field_packageKey = str2;
            bVar.field_reportId = i4;
            boolean z = aVar.get(bVar, new String[0]);
            bVar.field_source = 1;
            bVar.field_hitCount = 0;
            if (z) {
                aVar.update(bVar, new String[0]);
            } else {
                aVar.insert(bVar);
            }
            b.a(this.kPF, true);
            this.kPF.kPD.invoke();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(228032);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "error", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$ERROR;", "message", "", "invoke"})
    public static final class c extends q implements m<x.a, String, kotlin.x> {
        final /* synthetic */ b kPF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar) {
            super(2);
            this.kPF = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(x.a aVar, String str) {
            AppMethodBeat.i(228033);
            x.a aVar2 = aVar;
            p.h(aVar2, "error");
            b.b(this.kPF, "onError(" + aVar2 + ", " + str + ')');
            if (x.a.CGI_GET_URL_FAILED == aVar2) {
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar3 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.dN(this.kPF.reportId, this.kPF.kPB ? 50 : 49);
            } else {
                b.a(this.kPF, false);
            }
            this.kPF.kPD.invoke();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(228033);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/action/ActionGetNormalPkg$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(com.tencent.mm.plugin.appbrand.appcache.predownload.e.c cVar, kotlin.g.a.a<kotlin.x> aVar) {
        p.h(cVar, "record");
        p.h(aVar, "onComplete");
        AppMethodBeat.i(228036);
        this.kPC = cVar;
        this.kPD = aVar;
        this.kPB = this.kPC.field_retriedCount > 0;
        AppMethodBeat.o(228036);
    }

    public static final /* synthetic */ void b(b bVar, String str) {
        AppMethodBeat.i(228039);
        bVar.X(6, str);
        AppMethodBeat.o(228039);
    }

    static /* synthetic */ void a(b bVar, String str) {
        AppMethodBeat.i(228035);
        bVar.X(4, str);
        AppMethodBeat.o(228035);
    }

    private final void X(int i2, String str) {
        AppMethodBeat.i(228034);
        Log.printFormat(i2, "MicroMsg.AppBrand.PreDownload.ActionGetNormalPkg", "appId:" + this.kPC.field_appId + ", packageKey:" + this.kPC.field_packageKey + ", packageType:" + this.kPC.field_packageType + ", version:" + this.kPC.field_version + ", " + str, new Object[0]);
        AppMethodBeat.o(228034);
    }

    public static final /* synthetic */ void a(b bVar, boolean z) {
        int i2;
        AppMethodBeat.i(228038);
        if (z) {
            i2 = bVar.kPB ? 52 : 47;
        } else {
            i2 = bVar.kPB ? 53 : 48;
        }
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.dN(bVar.reportId, i2);
        kq kqVar = new kq();
        kqVar.ya(((com.tencent.mm.plugin.appbrand.appstorage.b) n.W(com.tencent.mm.plugin.appbrand.appstorage.b.class)).VI(bVar.kPC.field_appId));
        kqVar.yb(bVar.kPC.field_appId);
        kqVar.tO((long) bVar.kPC.field_version);
        kqVar.aiw();
        kqVar.tP((long) g.getNetworkType());
        kqVar.tQ((long) (z ? 1 : 0));
        kqVar.tR((long) bVar.kPC.field_retriedCount);
        kqVar.tS(bVar.kPC.field_cmdSequence);
        kqVar.tT((long) bVar.kPC.field_reportId);
        kqVar.tU((long) bVar.kPC.field_packageType);
        kqVar.yc(bVar.kPC.field_packageKey);
        kqVar.bfK();
        AppMethodBeat.o(228038);
    }
}
