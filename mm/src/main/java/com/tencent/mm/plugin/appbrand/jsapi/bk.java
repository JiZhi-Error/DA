package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Build;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bk extends ab<d> {
    private static final int CTRL_INDEX = 97;
    private static final String NAME = "getPublicLibVersion";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(d dVar, JSONObject jSONObject) {
        AppMethodBeat.i(147135);
        d dVar2 = dVar;
        if (!dVar2.isRunning()) {
            String h2 = h("fail js context not running", null);
            AppMethodBeat.o(147135);
            return h2;
        }
        String n = n("ok", d(dVar2));
        AppMethodBeat.o(147135);
        return n;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> d(d dVar) {
        boolean z = true;
        AppMethodBeat.i(147134);
        HashMap hashMap = new HashMap();
        AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) dVar.av(AppBrandSysConfigLU.class);
        hashMap.put("appDebug", Boolean.valueOf(appBrandSysConfigLU.leE.kNW != 0));
        hashMap.put("appMd5", Util.nullAsNil(appBrandSysConfigLU.leE.md5));
        hashMap.put("appVersion", Integer.valueOf(appBrandSysConfigLU.leE.pkgVersion));
        ICommLibReader bqZ = dVar.bqZ();
        if (bqZ != null) {
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) bqZ.bve();
            if (wxaPkgWrappingInfo.kNW == 0) {
                z = false;
            }
            hashMap.put("libDebug", Boolean.valueOf(z));
            hashMap.put("libMd5", Util.nullAsNil(wxaPkgWrappingInfo.md5));
            hashMap.put("libVersion", Integer.valueOf(wxaPkgWrappingInfo.pkgVersion));
        }
        hashMap.put("system", "android");
        hashMap.put("systemVersion", Integer.valueOf(Build.VERSION.SDK_INT));
        AppMethodBeat.o(147134);
        return hashMap;
    }
}
