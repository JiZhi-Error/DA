package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u0017H\u0002\u001a\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001d\u001a\u00020\u0019H\u0002\u001a\u000e\u0010\u001e\u001a\u0004\u0018\u00010\u0013*\u00020\u0015H\u0002\u001a\u000e\u0010\u001e\u001a\u0004\u0018\u00010\u0013*\u00020\u0011H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"MATERIAL_MODEL_KEY_MATERIAL_PATH", "", "MATERIAL_MODEL_KEY_MIME_TYPE", "OPEN_MATERIAL_MODEL_KEY_APP_ID", "OPEN_MATERIAL_MODEL_KEY_APP_NAME", "OPEN_MATERIAL_MODEL_KEY_CATEGORIES", "OPEN_MATERIAL_MODEL_KEY_ENTER_PATH", "OPEN_MATERIAL_MODEL_KEY_FUNCTION_DESC", "OPEN_MATERIAL_MODEL_KEY_FUNCTION_NAME", "OPEN_MATERIAL_MODEL_KEY_ICON_URL", "OPEN_MATERIAL_MODEL_KEY_MATERIAL_MODEL", "OPEN_MATERIAL_MODEL_KEY_OPEN_MATERIAL_DETAIL_MODELS", "OPEN_MATERIAL_MODEL_KEY_OPEN_MATERIAL_MODELS", "OPEN_MATERIAL_MODEL_KEY_SCORE", "OPEN_MATERIAL_MODEL_KEY_VERSION_TYPE", "TAG", "deserializeMaterialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "jsonObj", "Lorg/json/JSONObject;", "deserializeOpenMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "deserializeOpenMaterialDetailModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "deserializeOpenMaterialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "serializeOpenMaterialDetailModel", "openMaterialDetailModel", "serializeOpenMaterialModel", "openMaterialModel", "serialize", "plugin-appbrand-integration_release"})
public final class f {
    static final JSONObject h(MaterialModel materialModel) {
        JSONObject jSONObject;
        AppMethodBeat.i(229157);
        try {
            jSONObject = new JSONObject();
            jSONObject.put("mimeType", materialModel.mimeType);
            jSONObject.put("materialPath", materialModel.nlI);
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "serialize#MaterialModel, fail since ".concat(String.valueOf(e2)));
            jSONObject = null;
        }
        AppMethodBeat.o(229157);
        return jSONObject;
    }

    private static final MaterialModel aq(JSONObject jSONObject) {
        MaterialModel materialModel;
        AppMethodBeat.i(229158);
        try {
            materialModel = MaterialModel.eB(jSONObject.getString("mimeType"), jSONObject.getString("materialPath"));
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "deserializeMaterialModel, fail since ".concat(String.valueOf(e2)));
            materialModel = null;
        }
        AppMethodBeat.o(229158);
        return materialModel;
    }

    private static final JSONObject a(AppBrandOpenMaterialModel appBrandOpenMaterialModel) {
        JSONObject jSONObject;
        AppMethodBeat.i(229159);
        try {
            jSONObject = new JSONObject();
            jSONObject.put("appId", appBrandOpenMaterialModel.appId);
            jSONObject.put("versionType", appBrandOpenMaterialModel.iOo);
            jSONObject.put("enterPath", appBrandOpenMaterialModel.kHw);
            jSONObject.put("iconUrl", appBrandOpenMaterialModel.iconUrl);
            jSONObject.put("functionName", appBrandOpenMaterialModel.nlH);
            jSONObject.put("appName", appBrandOpenMaterialModel.appName);
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "serializeOpenMaterialModel, fail since ".concat(String.valueOf(e2)));
            jSONObject = null;
        }
        AppMethodBeat.o(229159);
        return jSONObject;
    }

    private static final AppBrandOpenMaterialModel ar(JSONObject jSONObject) {
        AppBrandOpenMaterialModel appBrandOpenMaterialModel;
        boolean z;
        AppMethodBeat.i(229160);
        try {
            String string = jSONObject.getString("appId");
            int i2 = jSONObject.getInt("versionType");
            String string2 = jSONObject.getString("enterPath");
            String optString = jSONObject.optString("iconUrl");
            p.g(optString, LocaleUtil.ITALIAN);
            if (optString.length() == 0) {
                optString = null;
            }
            String string3 = jSONObject.getString("functionName");
            String optString2 = jSONObject.optString("appName");
            p.g(optString2, LocaleUtil.ITALIAN);
            if (optString2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                optString2 = null;
            }
            appBrandOpenMaterialModel = new AppBrandOpenMaterialModel(string, i2, string2, optString, string3);
            appBrandOpenMaterialModel.appName = optString2;
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "deserializeOpenMaterialModel, fail since ".concat(String.valueOf(e2)));
            appBrandOpenMaterialModel = null;
        }
        AppMethodBeat.o(229160);
        return appBrandOpenMaterialModel;
    }

    private static final JSONObject a(AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel) {
        JSONObject jSONObject;
        AppMethodBeat.i(229161);
        try {
            JSONObject a2 = a((AppBrandOpenMaterialModel) appBrandOpenMaterialDetailModel);
            if (a2 != null) {
                JSONArray jSONArray = new JSONArray();
                List<String> list = appBrandOpenMaterialDetailModel.lgE;
                p.g(list, "openMaterialDetailModel.categories");
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                a2.put("categories", jSONArray);
                a2.put(FirebaseAnalytics.b.SCORE, Float.valueOf(appBrandOpenMaterialDetailModel.score));
                a2.put("functionDesc", appBrandOpenMaterialDetailModel.nlG);
                jSONObject = a2;
            } else {
                jSONObject = null;
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "serializeOpenMaterialDetailModel, fail since ".concat(String.valueOf(e2)));
            jSONObject = null;
        }
        AppMethodBeat.o(229161);
        return jSONObject;
    }

    private static final AppBrandOpenMaterialDetailModel as(JSONObject jSONObject) {
        AppBrandOpenMaterialDetailModel appBrandOpenMaterialDetailModel;
        AppMethodBeat.i(229162);
        try {
            AppBrandOpenMaterialModel ar = ar(jSONObject);
            if (ar != null) {
                JSONArray jSONArray = jSONObject.getJSONArray("categories");
                kotlin.k.f mY = j.mY(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(kotlin.a.j.a(mY, 10));
                Iterator it = mY.iterator();
                while (it.hasNext()) {
                    Object obj = jSONArray.get(((ab) it).nextInt());
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(229162);
                        throw tVar;
                    }
                    arrayList.add((String) obj);
                }
                appBrandOpenMaterialDetailModel = new AppBrandOpenMaterialDetailModel(ar.appId, ar.iOo, ar.kHw, ar.iconUrl, ar.nlH, arrayList, (float) jSONObject.getDouble(FirebaseAnalytics.b.SCORE), jSONObject.getString("functionDesc"));
                appBrandOpenMaterialDetailModel.appName = ar.appName;
            } else {
                appBrandOpenMaterialDetailModel = null;
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "deserializeOpenMaterialDetailModel, fail since ".concat(String.valueOf(e2)));
            appBrandOpenMaterialDetailModel = null;
        }
        AppMethodBeat.o(229162);
        return appBrandOpenMaterialDetailModel;
    }

    static final JSONObject a(AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
        JSONObject jSONObject;
        AppMethodBeat.i(229163);
        try {
            JSONObject jSONObject2 = new JSONObject();
            MaterialModel materialModel = appBrandOpenMaterialCollection.nlD;
            p.g(materialModel, "materialModel");
            jSONObject2.put("materialModel", h(materialModel));
            JSONArray jSONArray = new JSONArray();
            List<AppBrandOpenMaterialModel> list = appBrandOpenMaterialCollection.nlE;
            p.g(list, "appBrandOpenMaterialModels");
            for (T t : list) {
                p.g(t, "openMaterialModel");
                jSONArray.put(a((AppBrandOpenMaterialModel) t));
            }
            jSONObject2.put("appBrandOpenMaterialModels", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            List<AppBrandOpenMaterialDetailModel> list2 = appBrandOpenMaterialCollection.nlF;
            p.g(list2, "appBrandOpenMaterialDetailModels");
            for (T t2 : list2) {
                p.g(t2, "openMaterialDetailModel");
                jSONArray2.put(a((AppBrandOpenMaterialDetailModel) t2));
            }
            jSONObject2.put("appBrandOpenMaterialDetailModels", jSONArray2);
            jSONObject = jSONObject2;
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "serialize#AppBrandOpenMaterialCollection, fail since ".concat(String.valueOf(e2)));
            jSONObject = null;
        }
        AppMethodBeat.o(229163);
        return jSONObject;
    }

    static final AppBrandOpenMaterialCollection at(JSONObject jSONObject) {
        AppBrandOpenMaterialCollection appBrandOpenMaterialCollection;
        AppMethodBeat.i(229164);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("materialModel");
            p.g(jSONObject2, "jsonObj.getJSONObject(OP…MODEL_KEY_MATERIAL_MODEL)");
            MaterialModel aq = aq(jSONObject2);
            if (aq == null) {
                p.hyc();
            }
            JSONArray jSONArray = jSONObject.getJSONArray("appBrandOpenMaterialModels");
            kotlin.k.f mY = j.mY(0, jSONArray.length());
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(mY, 10));
            Iterator it = mY.iterator();
            while (it.hasNext()) {
                Object obj = jSONArray.get(((ab) it).nextInt());
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type org.json.JSONObject");
                    AppMethodBeat.o(229164);
                    throw tVar;
                }
                arrayList.add(ar((JSONObject) obj));
            }
            ArrayList arrayList2 = arrayList;
            JSONArray jSONArray2 = jSONObject.getJSONArray("appBrandOpenMaterialDetailModels");
            kotlin.k.f mY2 = j.mY(0, jSONArray2.length());
            ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(mY2, 10));
            Iterator it2 = mY2.iterator();
            while (it2.hasNext()) {
                Object obj2 = jSONArray2.get(((ab) it2).nextInt());
                if (obj2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type org.json.JSONObject");
                    AppMethodBeat.o(229164);
                    throw tVar2;
                }
                arrayList3.add(as((JSONObject) obj2));
            }
            appBrandOpenMaterialCollection = new AppBrandOpenMaterialCollection(aq, arrayList2, arrayList3);
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.OpenMaterialsStorage", "deserializeOpenMaterialCollection, fail since ".concat(String.valueOf(e2)));
            appBrandOpenMaterialCollection = null;
        }
        AppMethodBeat.o(229164);
        return appBrandOpenMaterialCollection;
    }
}
