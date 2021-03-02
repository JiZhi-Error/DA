package com.tencent.mm.plugin.sns.waid;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.waid.WaidProvider;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class c {
    public static void a(WaidProvider.a aVar, String str) {
        AppMethodBeat.i(204056);
        if (!b.flv()) {
            Log.e("ad.waid.WaidReporter", "reportPkg isWxEnvInitDone==false");
            AppMethodBeat.o(204056);
            return;
        }
        if (!(aVar == null || aVar.FgS == null || aVar.FgS.length <= 1)) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < aVar.FgS.length; i2++) {
                    sb.append(aVar.FgS[i2]);
                    if (i2 != aVar.FgS.length - 1) {
                        sb.append("|");
                    }
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("rawCallPkg", aVar.FgR);
                jSONObject.put("callPkgType", aVar.FgT);
                jSONObject.put("pkgsFromUid", sb.toString());
                jSONObject.put("queryPkg", str);
                String aRB = aRB(jSONObject.toString());
                Log.i("ad.waid.WaidReporter", "reportPkg data=".concat(String.valueOf(aRB)));
                h.INSTANCE.a(18666, 2002, aRB);
                AppMethodBeat.o(204056);
                return;
            } catch (Throwable th) {
                Log.e("ad.waid.WaidReporter", "reportPkg exp=" + android.util.Log.getStackTraceString(th));
            }
        }
        AppMethodBeat.o(204056);
    }

    static String aRB(String str) {
        AppMethodBeat.i(204057);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(204057);
            return "";
        }
        String replace = str.replace(",", ";");
        AppMethodBeat.o(204057);
        return replace;
    }
}
