package com.tencent.mm.plugin.webview.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import java.util.Map;

public final class a {
    public static final String[] VgJ = {"cache", "publicCache"};

    public static boolean a(n nVar, f fVar) {
        AppMethodBeat.i(211023);
        if (fVar == null || nVar == null || TextUtils.isEmpty(nVar.mhO)) {
            AppMethodBeat.o(211023);
            return false;
        }
        String[] strArr = VgJ;
        for (String str : strArr) {
            if (str.equalsIgnoreCase(nVar.mhO)) {
                fVar.a(nVar, str + ":not in white list", (Map<String, Object>) null);
                AppMethodBeat.o(211023);
                return true;
            }
        }
        AppMethodBeat.o(211023);
        return false;
    }
}
