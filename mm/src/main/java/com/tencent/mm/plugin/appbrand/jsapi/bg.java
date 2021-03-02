package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bg extends ab<d> {
    public static final int CTRL_INDEX = 466;
    public static final String NAME = "getMenuButtonBoundingClientRect";
    private static boolean lzG = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(d dVar, JSONObject jSONObject) {
        AppMethodBeat.i(139842);
        String c2 = c(dVar);
        AppMethodBeat.o(139842);
        return c2;
    }

    public static void hi(boolean z) {
        lzG = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c(com.tencent.mm.plugin.appbrand.d r11) {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.bg.c(com.tencent.mm.plugin.appbrand.d):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public ag j(s sVar) {
        AppMethodBeat.i(177248);
        ag agVar = (ag) sVar.M(ag.class);
        AppMethodBeat.o(177248);
        return agVar;
    }

    private Map<String, Object> l(s sVar) {
        AppMethodBeat.i(182225);
        ag j2 = j(sVar);
        if (j2 == null) {
            Log.e("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] NULL IMenuButtonLayoutPropertiesService", sVar.getAppId());
            AppMethodBeat.o(182225);
            return null;
        }
        int k = k(sVar);
        ag.b bXN = j2.bXN();
        ag.a No = j2.No();
        int i2 = ai.n(sVar)[0];
        int i3 = bXN.width;
        int i4 = bXN.height;
        int i5 = k + No.top;
        int i6 = i2 - No.right;
        Map<String, Object> l = l(new Rect(i6 - i3, i5, i6, i4 + i5));
        Log.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getBoundingRectFallback with appId[%s] return %s", sVar.getAppId(), l);
        AppMethodBeat.o(182225);
        return l;
    }

    private static Map<String, Object> l(Rect rect) {
        AppMethodBeat.i(182226);
        rect.left = g.zB(rect.left);
        rect.top = g.zB(rect.top);
        rect.right = g.zB(rect.right);
        rect.bottom = g.zB(rect.bottom);
        HashMap hashMap = new HashMap(6);
        hashMap.put("left", Integer.valueOf(rect.left));
        hashMap.put("top", Integer.valueOf(rect.top));
        hashMap.put("right", Integer.valueOf(rect.right));
        hashMap.put("bottom", Integer.valueOf(rect.bottom));
        hashMap.put("width", Integer.valueOf(rect.width()));
        hashMap.put("height", Integer.valueOf(rect.height()));
        AppMethodBeat.o(182226);
        return hashMap;
    }

    private static int k(s sVar) {
        AppMethodBeat.i(182224);
        c.C0789c statusBar = sVar.kEb.getStatusBar();
        if (statusBar == null || 8 == statusBar.visibility) {
            AppMethodBeat.o(182224);
            return 0;
        }
        int i2 = statusBar.height;
        AppMethodBeat.o(182224);
        return i2;
    }
}
