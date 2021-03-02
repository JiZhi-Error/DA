package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class i<C extends f> extends ab<C> {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(C c2, JSONObject jSONObject) {
        AppMethodBeat.i(137670);
        String n = n("ok", a(c2));
        AppMethodBeat.o(137670);
        return n;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> a(C c2) {
        AppMethodBeat.i(137671);
        HashMap hashMap = new HashMap();
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        hashMap.put("abi", Build.CPU_ABI);
        hashMap.put("system", "Android " + Build.VERSION.RELEASE);
        DisplayMetrics displayMetrics = c2.getContext().getResources().getDisplayMetrics();
        hashMap.put("pixelRatio", Float.valueOf(displayMetrics.density));
        hashMap.put("screenWidth", Integer.valueOf(g.zB(displayMetrics.widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(g.zB(displayMetrics.heightPixels)));
        AppMethodBeat.o(137671);
        return hashMap;
    }
}
