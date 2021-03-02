package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.openmaterial.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getContext", "()Landroid/content/Context;", "getOpenMaterialCollection", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "getOpenMaterialReporter", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "dead", "", "requireOpenMaterialBottomSheet", "Companion", "plugin-appbrand-integration_release"})
public abstract class c implements h {
    public static final a nkP = new a((byte) 0);
    final Context context;
    final e hOv;
    private g nkO;
    final AppBrandOpenMaterialCollection nkx;
    private final j nky;
    final com.tencent.mm.plugin.appbrand.openmaterial.b.a nkz;

    public c(b bVar, Context context2, e eVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection, g gVar, j jVar) {
        p.h(bVar, "openMaterialScene");
        p.h(context2, "context");
        p.h(eVar, "bottomSheet");
        p.h(appBrandOpenMaterialCollection, "openMaterialCollection");
        p.h(jVar, "launchAppBrandExecutor");
        this.context = context2;
        this.hOv = eVar;
        this.nkx = appBrandOpenMaterialCollection;
        this.nkO = gVar;
        this.nky = jVar;
        AppBrandOpenMaterialCollection appBrandOpenMaterialCollection2 = this.nkx;
        boolean z = this.hOv.hbo() == 0;
        p.h(bVar, "scene");
        p.h(appBrandOpenMaterialCollection2, "openMaterialCollection");
        com.tencent.mm.plugin.appbrand.openmaterial.b.a aVar = new com.tencent.mm.plugin.appbrand.openmaterial.b.a(bVar, appBrandOpenMaterialCollection2);
        Log.i(aVar.bQh(), "onBottomSheetShow, isGrid: ".concat(String.valueOf(z)));
        aVar.bQi().xE(z ? 1 : 5).xF(com.tencent.mm.plugin.appbrand.openmaterial.b.a.d(aVar.nkA)).xG(aVar.bQk()).xH(0).bfK();
        this.nkz = aVar;
        if (this.context instanceof MMFragmentActivity) {
            ((MMFragmentActivity) this.context).keep(this);
        } else {
            Log.e("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "<init>, context is not lifecycle keeper");
        }
    }

    @Override // com.tencent.mm.vending.e.a
    public void dead() {
        Log.d("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "dead");
        g gVar = this.nkO;
        if (gVar != null) {
            gVar.hide();
        }
        g gVar2 = this.nkO;
        if (gVar2 != null) {
            gVar2.dead();
        }
    }

    /* access modifiers changed from: protected */
    public final g bQb() {
        g gVar = this.nkO;
        if (gVar != null) {
            return gVar;
        }
        a.C0756a aVar = a.nkB;
        g a2 = a.C0756a.a(this.context, this.hOv, this.nkx, this.nky, this.nkz);
        this.nkO = a2;
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
