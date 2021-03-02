package com.tencent.mm.plugin.appbrand.openmaterial.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialNativeExtraData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "mimeType", "", "materialPath", "materialName", "materialSize", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getMaterialName", "()Ljava/lang/String;", "getMaterialPath", "getMaterialSize", "()I", "getMimeType", "toJsonString", "Companion", "plugin-appbrand-integration_release"})
public final class a implements d {
    public static final C0762a nlL = new C0762a((byte) 0);
    public final String mimeType;
    public final String nlI;
    private final String nlJ;
    private final int nlK;

    static {
        AppMethodBeat.i(229187);
        AppMethodBeat.o(229187);
    }

    public static final a adn(String str) {
        AppMethodBeat.i(229188);
        a adn = C0762a.adn(str);
        AppMethodBeat.o(229188);
        return adn;
    }

    public a(String str, String str2, String str3, int i2) {
        p.h(str, "mimeType");
        p.h(str2, "materialPath");
        p.h(str3, "materialName");
        AppMethodBeat.i(229185);
        this.mimeType = str;
        this.nlI = str2;
        this.nlJ = str3;
        this.nlK = i2;
        AppMethodBeat.o(229185);
    }

    public /* synthetic */ a(String str, String str2) {
        this(str, str2, "", 0);
        AppMethodBeat.i(229186);
        AppMethodBeat.o(229186);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialNativeExtraData$Companion;", "", "()V", "fromJsonString", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialNativeExtraData;", "jsonStr", "", "parseMimeType", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.openmaterial.model.a$a  reason: collision with other inner class name */
    public static final class C0762a {
        private C0762a() {
        }

        public /* synthetic */ C0762a(byte b2) {
            this();
        }

        public static a adn(String str) {
            a aVar;
            AppMethodBeat.i(229183);
            p.h(str, "jsonStr");
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("mimeType");
                String string2 = jSONObject.getString("materialPath");
                String optString = jSONObject.optString("materialName", "");
                int optInt = jSONObject.optInt("materialSize", 0);
                p.g(string, "mimeType");
                p.g(string2, "materialPath");
                p.g(optString, "materialName");
                aVar = new a(string, string2, optString, optInt);
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialNativeExtraData", "fromJsonString fail since ".concat(String.valueOf(e2)));
                aVar = null;
            }
            AppMethodBeat.o(229183);
            return aVar;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.api.d
    public final String bua() {
        String str;
        AppMethodBeat.i(229184);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mimeType", this.mimeType);
            jSONObject.put("materialPath", this.nlI);
            jSONObject.put("materialName", this.nlJ);
            jSONObject.put("materialSize", this.nlK);
            str = jSONObject.toString();
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialNativeExtraData", "toJsonString fail since ".concat(String.valueOf(e2)));
            str = "{}";
        }
        AppMethodBeat.o(229184);
        return str;
    }

    public static final String ado(String str) {
        AppMethodBeat.i(229189);
        if (str != null) {
            a adn = C0762a.adn(str);
            if (adn != null) {
                String str2 = adn.mimeType;
                AppMethodBeat.o(229189);
                return str2;
            }
            AppMethodBeat.o(229189);
            return null;
        }
        AppMethodBeat.o(229189);
        return null;
    }
}
