package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.openmaterial.a;
import com.tencent.mm.plugin.appbrand.openmaterial.a.b;
import com.tencent.mm.plugin.appbrand.openmaterial.a.d;
import com.tencent.mm.plugin.appbrand.openmaterial.c;
import com.tencent.mm.plugin.appbrand.openmaterial.g;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0017J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialService;", "Lcom/tencent/mm/plugin/appbrand/service/IAppBrandOpenMaterialService;", "()V", "TAG", "", "enhanceBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "fetchOpenMaterials", "", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "fetchOpenMaterialsCallback", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IFetchOpenMaterialsCallback;", "fetchOpenMaterialsQuickly", "getOpenMaterialBottomSheetFactory", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IFactory;", "isEnabled", "", "isSupport", "mimeType", "restoreOpenMaterialCollection", "saveOpenMaterialCollection", "plugin-appbrand-integration_release"})
public final class b implements i {
    public static final b nkM = new b();

    static {
        AppMethodBeat.i(229097);
        AppMethodBeat.o(229097);
    }

    private b() {
    }

    @Override // com.tencent.mm.plugin.appbrand.service.i
    public final boolean c(com.tencent.mm.plugin.appbrand.openmaterial.model.b bVar) {
        int i2;
        AppMethodBeat.i(229089);
        p.h(bVar, "openMaterialScene");
        com.tencent.mm.plugin.expt.b.b bVar2 = (com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class);
        if (bVar2 != null) {
            i2 = bVar2.a(b.a.clicfg_appbrand_open_material2, 0);
        } else {
            i2 = 0;
        }
        Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialService", "isEnabled, enabledFlattenVals: ".concat(String.valueOf(i2)));
        boolean isEnabled = bVar.isEnabled(i2);
        Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialService", "isEnabled(" + bVar + "): " + isEnabled);
        AppMethodBeat.o(229089);
        return isEnabled;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.i
    public final boolean adl(String str) {
        AppMethodBeat.i(229090);
        p.h(str, "mimeType");
        Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "isSupport, mimeType: ".concat(String.valueOf(str)));
        d dVar = d.nly;
        boolean contains = d.contains(str);
        AppMethodBeat.o(229090);
        return contains;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.i
    public final void a(MaterialModel materialModel, i iVar) {
        AppMethodBeat.i(229091);
        p.h(materialModel, "materialModel");
        p.h(iVar, "fetchOpenMaterialsCallback");
        Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "fetchOpenMaterials, materialModel: ".concat(String.valueOf(materialModel)));
        b.a aVar = com.tencent.mm.plugin.appbrand.openmaterial.a.b.nlq;
        b.a.bQe().a(materialModel, iVar);
        AppMethodBeat.o(229091);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.i
    public final AppBrandOpenMaterialCollection a(MaterialModel materialModel) {
        AppMethodBeat.i(229092);
        p.h(materialModel, "materialModel");
        Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "fetchOpenMaterialsQuickly, materialModel: ".concat(String.valueOf(materialModel)));
        b.a aVar = com.tencent.mm.plugin.appbrand.openmaterial.a.b.nlq;
        AppBrandOpenMaterialCollection a2 = b.a.bQe().a(materialModel);
        AppMethodBeat.o(229092);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.i
    public final g.a bQa() {
        AppMethodBeat.i(229093);
        Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "getOpenMaterialBottomSheetFactory");
        a.C0756a aVar = a.nkB;
        AppMethodBeat.o(229093);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.i
    public final h a(com.tencent.mm.plugin.appbrand.openmaterial.model.b bVar, Context context, e eVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection, g gVar, j jVar) {
        h hVar;
        j jVar2;
        k kVar;
        j jVar3;
        AppMethodBeat.i(229094);
        p.h(bVar, "openMaterialScene");
        p.h(context, "context");
        p.h(eVar, "bottomSheet");
        p.h(appBrandOpenMaterialCollection, "openMaterialCollection");
        Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialService", "enhanceBottomSheet, openMaterialCollection: ".concat(String.valueOf(appBrandOpenMaterialCollection)));
        c.a aVar = c.nkP;
        p.h(bVar, "openMaterialScene");
        p.h(context, "context");
        p.h(eVar, "bottomSheet");
        p.h(appBrandOpenMaterialCollection, "openMaterialCollection");
        if (d.eg(context)) {
            if (eVar.hbo() == 0) {
                Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, create GridBottomSheetEnhanceLogic");
                if (jVar == null) {
                    jVar3 = j.nlj;
                    p.g(jVar3, "ILaunchAppBrandExecutor.DEFAULT");
                } else {
                    jVar3 = jVar;
                }
                kVar = new e(bVar, context, eVar, appBrandOpenMaterialCollection, gVar, jVar3);
            } else {
                Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, create ListBottomSheetEnhanceLogic");
                if (jVar == null) {
                    jVar2 = j.nlj;
                    p.g(jVar2, "ILaunchAppBrandExecutor.DEFAULT");
                } else {
                    jVar2 = jVar;
                }
                kVar = new k(bVar, context, eVar, appBrandOpenMaterialCollection, gVar, jVar2);
            }
            hVar = kVar;
        } else {
            Log.i("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "create, context is invalid, use dummy");
            hVar = h.nli;
            p.g(hVar, "IEnhanceBottomSheetController.DUMMY");
        }
        hVar.a(h.a.ENABLE);
        AppMethodBeat.o(229094);
        return hVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.i
    public final boolean a(MaterialModel materialModel, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
        AppMethodBeat.i(229095);
        p.h(materialModel, "materialModel");
        p.h(appBrandOpenMaterialCollection, "openMaterialCollection");
        com.tencent.mm.plugin.appbrand.openmaterial.a.e eVar = com.tencent.mm.plugin.appbrand.openmaterial.a.e.nlz;
        boolean b2 = com.tencent.mm.plugin.appbrand.openmaterial.a.e.b(materialModel, appBrandOpenMaterialCollection);
        AppMethodBeat.o(229095);
        return b2;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.i
    public final AppBrandOpenMaterialCollection b(MaterialModel materialModel) {
        AppMethodBeat.i(229096);
        p.h(materialModel, "materialModel");
        com.tencent.mm.plugin.appbrand.openmaterial.a.e eVar = com.tencent.mm.plugin.appbrand.openmaterial.a.e.nlz;
        AppBrandOpenMaterialCollection g2 = com.tencent.mm.plugin.appbrand.openmaterial.a.e.g(materialModel);
        AppMethodBeat.o(229096);
        return g2;
    }
}
