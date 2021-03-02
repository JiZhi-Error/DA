package com.tencent.mm.plugin.lite.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URLDecoder;

public final class b {
    public static String[] bM(String str, boolean z) {
        String str2 = null;
        AppMethodBeat.i(198952);
        String[] strArr = new String[2];
        if (z) {
            try {
                str = URLDecoder.decode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            } catch (Exception e2) {
                Log.printErrStackTrace("LiteAppUtils", e2, "", new Object[0]);
            }
        }
        String[] split = str.split("\\?");
        if (split.length > 1) {
            strArr[0] = split[0];
            str2 = split[1];
        } else if (str.contains("=")) {
            strArr[0] = null;
            str2 = split[0];
        } else {
            strArr[0] = split[0];
        }
        i iVar = new i();
        if (str2 != null) {
            String[] split2 = str2.split("&");
            for (String str3 : split2) {
                String[] split3 = str3.split("=");
                if (split3 != null && split3.length >= 2) {
                    iVar.h(split3[0].trim(), split3[1].trim());
                }
            }
        }
        strArr[1] = iVar.toString();
        AppMethodBeat.o(198952);
        return strArr;
    }
}
