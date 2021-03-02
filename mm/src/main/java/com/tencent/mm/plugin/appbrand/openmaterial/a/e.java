package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/OpenMaterialsStorage;", "", "()V", "remove", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "save", "", "openMaterialCollection", "plugin-appbrand-integration_release"})
public final class e {
    public static final e nlz = new e();

    static {
        AppMethodBeat.i(229156);
        AppMethodBeat.o(229156);
    }

    private e() {
    }

    public static boolean b(MaterialModel materialModel, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
        String jSONObject;
        String jSONObject2;
        AppMethodBeat.i(229154);
        p.h(materialModel, "materialModel");
        p.h(appBrandOpenMaterialCollection, "openMaterialCollection");
        Log.i("MicroMsg.AppBrand.OpenMaterialsStorage", "save, materialModel: ".concat(String.valueOf(materialModel)));
        JSONObject h2 = f.h(materialModel);
        if (h2 == null || (jSONObject = h2.toString()) == null) {
            AppMethodBeat.o(229154);
            return false;
        }
        p.g(jSONObject, "materialModel.serialize(…oString() ?: return false");
        JSONObject a2 = f.a(appBrandOpenMaterialCollection);
        if (a2 == null || (jSONObject2 = a2.toString()) == null) {
            AppMethodBeat.o(229154);
            return false;
        }
        p.g(jSONObject2, "openMaterialCollection.s…oString() ?: return false");
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ == null || VQ.putString(jSONObject, jSONObject2) == null) {
            AppMethodBeat.o(229154);
            return false;
        }
        AppMethodBeat.o(229154);
        return true;
    }

    public static AppBrandOpenMaterialCollection g(MaterialModel materialModel) {
        String jSONObject;
        String string;
        AppBrandOpenMaterialCollection j2;
        AppMethodBeat.i(229155);
        p.h(materialModel, "materialModel");
        Log.i("MicroMsg.AppBrand.OpenMaterialsStorage", "remove, materialModel: ".concat(String.valueOf(materialModel)));
        JSONObject h2 = f.h(materialModel);
        if (h2 == null || (jSONObject = h2.toString()) == null) {
            AppBrandOpenMaterialCollection j3 = AppBrandOpenMaterialCollection.j(materialModel);
            p.g(j3, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
            AppMethodBeat.o(229155);
            return j3;
        }
        p.g(jSONObject, "materialModel.serialize(…tion.dummy(materialModel)");
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ == null || (string = VQ.getString(jSONObject, null)) == null) {
            AppBrandOpenMaterialCollection j4 = AppBrandOpenMaterialCollection.j(materialModel);
            p.g(j4, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
            AppMethodBeat.o(229155);
            return j4;
        }
        p.g(string, "AppBrandProcessSharedMMK…tion.dummy(materialModel)");
        try {
            j2 = f.at(new JSONObject(string));
            if (j2 == null) {
                j2 = AppBrandOpenMaterialCollection.j(materialModel);
                p.g(j2, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "remove#OpenMaterialsStorage, fail since ".concat(String.valueOf(e2)));
            j2 = AppBrandOpenMaterialCollection.j(materialModel);
            p.g(j2, "AppBrandOpenMaterialColl…tion.dummy(materialModel)");
        }
        AppMethodBeat.o(229155);
        return j2;
    }
}
