package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\u0016¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/WxLiveShoppingExtranData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "clickScene", "", "getClickScene", "()I", "setClickScene", "(I)V", "clickid", "", "getClickid", "()[B", "setClickid", "([B)V", "extraData", "getExtraData", "setExtraData", "(Ljava/lang/String;)V", "isPreRender", "setPreRender", "openMode", "getOpenMode", "setOpenMode", "productId", "", "getProductId", "()J", "setProductId", "(J)V", "shopExtraData", "getShopExtraData", "setShopExtraData", "toJsonString", "toString", "plugin-finder_release"})
public final class x implements d {
    private final String TAG = "WxLiveShoppingExtranData";
    private String dSJ = "";
    public long uko;
    public int ukp;
    private String ukq = "";
    public String ukr = "";
    public int uks;
    public byte[] ukt;

    public final void atG(String str) {
        AppMethodBeat.i(246290);
        p.h(str, "<set-?>");
        this.dSJ = str;
        AppMethodBeat.o(246290);
    }

    public final void atH(String str) {
        AppMethodBeat.i(246291);
        p.h(str, "<set-?>");
        this.ukq = str;
        AppMethodBeat.o(246291);
    }

    @Override // com.tencent.mm.plugin.appbrand.api.d
    public final String bua() {
        String str;
        AppMethodBeat.i(246292);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("extraData", this.dSJ);
            jSONObject.put("productId", this.uko);
            jSONObject.put("isPreRender", this.ukp);
            jSONObject.put("openMode", this.ukq);
            String str2 = this.ukr;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("shopExtraData", str2);
            str = jSONObject.toString();
            p.g(str, "obj.toString()");
        } catch (JSONException e2) {
            Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            str = "{}";
        }
        AppMethodBeat.o(246292);
        return str;
    }

    public final String toString() {
        AppMethodBeat.i(246293);
        String bua = bua();
        AppMethodBeat.o(246293);
        return bua;
    }
}
