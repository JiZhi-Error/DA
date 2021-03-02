package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;

public final class a {
    public static String[] q(String[] strArr) {
        AppMethodBeat.i(193717);
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2] == null || !strArr[i2].startsWith("data:image/")) {
                strArr2[i2] = strArr[i2];
            } else {
                strArr2[i2] = abv(strArr[i2]);
            }
        }
        AppMethodBeat.o(193717);
        return strArr2;
    }

    public static String[] a(String[] strArr, String[] strArr2) {
        AppMethodBeat.i(193718);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (!(strArr[i2] == null || strArr2[i2] == null || strArr[i2].equals(strArr2[i2]))) {
                arrayList.add(strArr[i2]);
            }
        }
        String[] strArr3 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        AppMethodBeat.o(193718);
        return strArr3;
    }

    public static void r(String[] strArr) {
        AppMethodBeat.i(193719);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            try {
                s.deleteFile(strArr[i2]);
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(193719);
    }

    private static String abv(String str) {
        AppMethodBeat.i(193720);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(193720);
            return "";
        }
        String abx = abx(abw(str));
        AppMethodBeat.o(193720);
        return abx;
    }

    private static String abw(String str) {
        AppMethodBeat.i(193721);
        String trim = str.substring(str.indexOf("base64,") + 7).trim();
        AppMethodBeat.o(193721);
        return trim;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        if (0 != 0) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076 A[SYNTHETIC, Splitter:B:22:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d A[ExcHandler: all (r1v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:10:0x0057] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String abx(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ac.a.abx(java.lang.String):java.lang.String");
    }
}
