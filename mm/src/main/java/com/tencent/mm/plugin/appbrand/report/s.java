package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class s {
    private static String aeL(String str) {
        AppMethodBeat.i(48072);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(48072);
            return "";
        }
        try {
            String nullAsNil = Util.nullAsNil(q.encode(str));
            AppMethodBeat.o(48072);
            return nullAsNil;
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.ReportUtil", "safeEncode, given %s, e %s", str, e2);
            AppMethodBeat.o(48072);
            return "";
        }
    }

    public static Object[] k(Object... objArr) {
        AppMethodBeat.i(48073);
        if (objArr == null || objArr.length <= 0) {
            Object[] objArr2 = new Object[0];
            AppMethodBeat.o(48073);
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
            } else if ((obj instanceof String) && ((String) obj).contains(",")) {
                obj = aeL((String) obj);
            }
            objArr3[i3] = String.valueOf(obj);
            i2++;
            i3++;
        }
        AppMethodBeat.o(48073);
        return objArr3;
    }
}
