package com.tencent.mm.plugin.appbrand.openmaterial.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ng;
import com.tencent.mm.g.b.a.ny;
import com.tencent.mm.g.b.a.nz;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;
import kotlin.m;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010/\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001dJ\u000e\u00103\u001a\u0002012\u0006\u00102\u001a\u00020\u001dJ\u0006\u00104\u001a\u000201J\u0006\u00105\u001a\u000201J\u000e\u00106\u001a\u0002012\u0006\u00107\u001a\u00020 J\u0006\u00108\u001a\u000201J\u000e\u00109\u001a\u0002012\u0006\u00102\u001a\u00020\u001dJ\u000e\u0010:\u001a\u0002012\u0006\u00102\u001a\u00020\u001dR\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0014\u0010\nR#\u0010\u0016\u001a\n \u000f*\u0004\u0018\u00010\u00170\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R#\u0010!\u001a\n \u000f*\u0004\u0018\u00010\"0\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010\f\u001a\u0004\b)\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\n \u000f*\u0004\u0018\u00010(0(X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "", "scene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;)V", "appBrandBottomSheetShownNum", "", "getAppBrandBottomSheetShownNum", "()J", "appBrandBottomSheetShownNum$delegate", "Lkotlin/Lazy;", "appBrandExposureReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_exposeStruct;", "kotlin.jvm.PlatformType", "getAppBrandExposureReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_exposeStruct;", "appBrandExposureReporter$delegate", "appBrandListPageShownNum", "getAppBrandListPageShownNum", "appBrandListPageShownNum$delegate", "bottomSheetActionReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/WeChat_use_weapp_openStruct;", "getBottomSheetActionReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/WeChat_use_weapp_openStruct;", "bottomSheetActionReporter$delegate", "bottomSheetExposedAppBrands", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "Lkotlin/collections/HashSet;", "bottomSheetListPageEntranceExposed", "", "listPageActionReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_clickStruct;", "getListPageActionReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_clickStruct;", "listPageActionReporter$delegate", "listPageExposedAppBrands", "myTag", "", "getMyTag", "()Ljava/lang/String;", "myTag$delegate", "getScene", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "sessionId", "convertScene4Report", "onBottomSheetAppBrandClick", "", "openMaterialModel", "onBottomSheetAppBrandExposure", "onBottomSheetListPageEntranceExposure", "onBottomSheetMoreClick", "onBottomSheetShow", "isGrid", "onLaunchListPageDirectly", "onListPageAppBrandClick", "onListPageAppBrandExposure", "plugin-appbrand-integration_release"})
public final class a {
    public final com.tencent.mm.plugin.appbrand.openmaterial.model.b nkA;
    public final AppBrandOpenMaterialCollection nkx;
    private final kotlin.f nlT = g.a(k.NONE, new f(this));
    private final kotlin.f nlU = g.a(k.NONE, new d(this));
    public final kotlin.f nlV = g.a(k.NONE, new e(this));
    private final kotlin.f nlW = g.a(k.NONE, new b(this));
    private final kotlin.f nlX = g.a(k.NONE, new C0760a(this));
    public final kotlin.f nlY = g.a(k.NONE, new c(this));
    public final HashSet<AppBrandOpenMaterialModel> nlZ = new HashSet<>();
    public final HashSet<AppBrandOpenMaterialModel> nma = new HashSet<>();
    public boolean nmb;
    final String sessionId = ad.JX("OpenMaterial#" + this.nkA.name());

    public final String bQh() {
        AppMethodBeat.i(229197);
        String str = (String) this.nlT.getValue();
        AppMethodBeat.o(229197);
        return str;
    }

    public final ng bQi() {
        AppMethodBeat.i(229198);
        ng ngVar = (ng) this.nlU.getValue();
        AppMethodBeat.o(229198);
        return ngVar;
    }

    public final nz bQj() {
        AppMethodBeat.i(229199);
        nz nzVar = (nz) this.nlW.getValue();
        AppMethodBeat.o(229199);
        return nzVar;
    }

    public final long bQk() {
        AppMethodBeat.i(229200);
        long longValue = ((Number) this.nlX.getValue()).longValue();
        AppMethodBeat.o(229200);
        return longValue;
    }

    public a(com.tencent.mm.plugin.appbrand.openmaterial.model.b bVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
        p.h(bVar, "scene");
        p.h(appBrandOpenMaterialCollection, "openMaterialCollection");
        AppMethodBeat.i(229203);
        this.nkA = bVar;
        this.nkx = appBrandOpenMaterialCollection;
        AppMethodBeat.o(229203);
    }

    public final void bQl() {
        AppMethodBeat.i(229201);
        Log.i(bQh(), "onBottomSheetMoreClick");
        bQi().xE(3).xF(d(this.nkA)).xG(bQk()).xH(0).bfK();
        AppMethodBeat.o(229201);
    }

    public static long d(com.tencent.mm.plugin.appbrand.openmaterial.model.b bVar) {
        AppMethodBeat.i(229202);
        switch (b.$EnumSwitchMapping$0[bVar.ordinal()]) {
            case 1:
                AppMethodBeat.o(229202);
                return 1;
            case 2:
                AppMethodBeat.o(229202);
                return 2;
            case 3:
                AppMethodBeat.o(229202);
                return 3;
            case 4:
                AppMethodBeat.o(229202);
                return 4;
            default:
                m mVar = new m();
                AppMethodBeat.o(229202);
                throw mVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ a nmc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar) {
            super(0);
            this.nmc = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(229196);
            String str = "MicroMsg.AppBrand.AppBrandOpenMaterialReporterImpl#" + this.nmc.sessionId;
            AppMethodBeat.o(229196);
            return str;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/autogen/mmdata/rpt/WeChat_use_weapp_openStruct;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<ng> {
        final /* synthetic */ a nmc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(0);
            this.nmc = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ng invoke() {
            AppMethodBeat.i(229194);
            ng Aq = new ng().Aq(this.nmc.sessionId);
            AppMethodBeat.o(229194);
            return Aq;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_clickStruct;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<ny> {
        final /* synthetic */ a nmc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar) {
            super(0);
            this.nmc = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ny invoke() {
            AppMethodBeat.i(229195);
            ny Be = new ny().Be(this.nmc.sessionId);
            AppMethodBeat.o(229195);
            return Be;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_exposeStruct;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<nz> {
        final /* synthetic */ a nmc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.nmc = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ nz invoke() {
            AppMethodBeat.i(229192);
            nz Bh = new nz().Bh(this.nmc.sessionId);
            AppMethodBeat.o(229192);
            return Bh;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.openmaterial.b.a$a  reason: collision with other inner class name */
    static final class C0760a extends q implements kotlin.g.a.a<Long> {
        final /* synthetic */ a nmc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0760a(a aVar) {
            super(0);
            this.nmc = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(229191);
            Long valueOf = Long.valueOf((long) this.nmc.nkx.nlE.size());
            AppMethodBeat.o(229191);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Long> {
        final /* synthetic */ a nmc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(0);
            this.nmc = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(229193);
            Long valueOf = Long.valueOf((long) this.nmc.nkx.nlF.size());
            AppMethodBeat.o(229193);
            return valueOf;
        }
    }
}
