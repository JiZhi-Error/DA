package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/WeAppNativeExtraDataWeUse;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "showOrderEntrance", "", "redDotTypeList", "", "(I[I)V", "TAG", "", "getRedDotTypeList", "()[I", "getShowOrderEntrance", "()I", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toJsonString", "toString", "plugin-appbrand-integration_release"})
public final class k implements d {
    private final String TAG = "MicroMsg.AppBrand.WeAppNativeExtraDataWeUse";
    private final int ofY = 1;
    private final int[] ofZ = null;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (kotlin.g.b.p.j(r3.ofZ, r4.ofZ) != false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 180717(0x2c1ed, float:2.53238E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x001e
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.ui.recommend.k
            if (r0 == 0) goto L_0x0023
            com.tencent.mm.plugin.appbrand.ui.recommend.k r4 = (com.tencent.mm.plugin.appbrand.ui.recommend.k) r4
            int r0 = r3.ofY
            int r1 = r4.ofY
            if (r0 != r1) goto L_0x0023
            int[] r0 = r3.ofZ
            int[] r1 = r4.ofZ
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0023
        L_0x001e:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0022:
            return r0
        L_0x0023:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.ui.recommend.k.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(180716);
        int i2 = this.ofY * 31;
        int[] iArr = this.ofZ;
        int hashCode = (iArr != null ? Arrays.hashCode(iArr) : 0) + i2;
        AppMethodBeat.o(180716);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.appbrand.api.d
    public final String bua() {
        String str;
        AppMethodBeat.i(180714);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showOrderEntrance", this.ofY);
            if (this.ofZ != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 : this.ofZ) {
                    jSONArray.put(i2);
                }
                jSONObject.put("redDotTypeList", jSONArray);
            }
            str = jSONObject.toString();
            p.g(str, "obj.toString()");
        } catch (Throwable th) {
            Log.printErrStackTrace(this.TAG, th, "toJsonString", new Object[0]);
            str = "{}";
        }
        AppMethodBeat.o(180714);
        return str;
    }

    public final String toString() {
        AppMethodBeat.i(180715);
        String bua = bua();
        AppMethodBeat.o(180715);
        return bua;
    }
}
