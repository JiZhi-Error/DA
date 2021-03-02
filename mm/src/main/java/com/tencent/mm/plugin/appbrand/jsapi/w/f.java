package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Pattern;
import org.apache.commons.b.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class f extends d {
    public static final int CTRL_INDEX = 63;
    public static final String NAME = "reportKeyValue";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        String str;
        AppMethodBeat.i(46750);
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46750);
            return;
        }
        int optInt = jSONObject.optInt("version", -1);
        l lVar = (l) fVar.av(l.class);
        if (lVar == null) {
            Log.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            fVar.i(i2, h("fail:interrupted", null));
            AppMethodBeat.o(46750);
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                int optInt2 = jSONObject2.optInt("key");
                String optString = jSONObject2.optString("value");
                if (optInt2 > 0 && !Util.isNullOrNil(optString)) {
                    if (optInt2 == 15496) {
                        try {
                            String[] split = optString.split(Pattern.quote(","));
                            boolean z = false;
                            int[] iArr = {17, 11, 9, 2};
                            for (int i4 = 0; i4 < 4; i4++) {
                                int i5 = iArr[i4];
                                String str2 = split[i5];
                                if (Util.nullAsNil(str2).length() > 1024) {
                                    split[i5] = str2.substring(0, 1024);
                                    z = true;
                                }
                            }
                            if (z) {
                                str = g.a(split, ",");
                            } else {
                                str = optString;
                            }
                            optString = str;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.JsApiReportKeyValue", "modify 15496 too large string-fields, e=%s", e2);
                        }
                    }
                    if (optInt >= 2) {
                        QualitySessionRuntime aeU = b.aeU(fVar.getAppId());
                        if (aeU == null) {
                            fVar.i(i2, h("fail NULL QualitySystem instance", null));
                            AppMethodBeat.o(46750);
                            return;
                        }
                        Log.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", Integer.valueOf(optInt2), fVar.getAppId(), Integer.valueOf(lVar.leE.pkgVersion), Integer.valueOf(lVar.leE.kNW + 1), optString);
                        a.nFX.a(optInt2, aeU.kEY, aeU.appId, Integer.valueOf(aeU.nLk), Integer.valueOf(aeU.nJE), Integer.valueOf(aeU.apptype), optString);
                    } else {
                        Log.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", Integer.valueOf(optInt2), fVar.getAppId(), Integer.valueOf(lVar.leE.pkgVersion), Integer.valueOf(lVar.leE.kNW + 1), optString);
                        if (optInt2 == 15496) {
                            h.INSTANCE.a(optInt2, fVar.getAppId(), Integer.valueOf(lVar.leE.pkgVersion), Integer.valueOf(lVar.leE.kNW + 1), optString);
                        } else {
                            a.nFX.a(optInt2, fVar.getAppId(), Integer.valueOf(lVar.leE.pkgVersion), Integer.valueOf(lVar.leE.kNW + 1), optString);
                        }
                    }
                }
            } catch (Exception e3) {
                Log.e("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", e3.getMessage());
            }
        }
        fVar.i(i2, h("ok", null));
        AppMethodBeat.o(46750);
    }
}
