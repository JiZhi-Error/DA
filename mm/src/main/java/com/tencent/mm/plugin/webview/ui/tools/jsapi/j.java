package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j {
    public static void a(f fVar, String str, n nVar) {
        AppMethodBeat.i(212020);
        if (fVar == null) {
            AppMethodBeat.o(212020);
            return;
        }
        try {
            Bundle j2 = fVar.j(145, null);
            if (j2 == null) {
                AppMethodBeat.o(212020);
                return;
            }
            String[] stringArray = j2.getStringArray("key_webview_apbrand_jsapi_report_args");
            if (stringArray == null || stringArray.length != 19) {
                AppMethodBeat.o(212020);
                return;
            }
            stringArray[10] = str;
            stringArray[11] = b(str, nVar);
            stringArray[12] = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(b(nVar, "isSuccess")) ? "1" : "2";
            stringArray[13] = b(nVar, "permissionValue");
            stringArray[14] = b(nVar, "jsapiErrorCode");
            h.INSTANCE.a(14993, k(stringArray));
            AppMethodBeat.o(212020);
        } catch (Exception e2) {
            Log.e("kv_14993", String.valueOf(e2));
            AppMethodBeat.o(212020);
        }
    }

    private static String b(String str, n nVar) {
        AppMethodBeat.i(212021);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1008737020:
                if (str.equals("getBrandWCPayRequest")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                String obj = nVar.params.get("package").toString();
                AppMethodBeat.o(212021);
                return obj;
            default:
                AppMethodBeat.o(212021);
                return "";
        }
    }

    private static String aeL(String str) {
        AppMethodBeat.i(82064);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(82064);
            return "";
        }
        try {
            String nullAsNil = Util.nullAsNil(q.encode(str));
            AppMethodBeat.o(82064);
            return nullAsNil;
        } catch (Exception e2) {
            AppMethodBeat.o(82064);
            return "";
        }
    }

    private static Object[] k(Object[] objArr) {
        AppMethodBeat.i(82065);
        if (objArr == null || objArr.length <= 0) {
            Object[] objArr2 = new Object[0];
            AppMethodBeat.o(82065);
            return objArr2;
        }
        Object[] objArr3 = new Object[objArr.length];
        int length = objArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            if (obj == null) {
                obj = "";
            } else if ((obj instanceof String) && (((String) obj).contains(",") || ((String) obj).contains(FilePathGenerator.ANDROID_DIR_SEP))) {
                obj = aeL((String) obj);
            }
            objArr3[i3] = String.valueOf(obj);
            i2++;
            i3++;
        }
        AppMethodBeat.o(82065);
        return objArr3;
    }

    private static String b(n nVar, String str) {
        AppMethodBeat.i(212022);
        if (nVar.ISg == null || !nVar.ISg.containsKey(str)) {
            AppMethodBeat.o(212022);
            return "";
        }
        String valueOf = String.valueOf(nVar.ISg.get(str));
        AppMethodBeat.o(212022);
        return valueOf;
    }
}
