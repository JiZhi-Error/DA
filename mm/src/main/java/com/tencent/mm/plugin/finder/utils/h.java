package com.tencent.mm.plugin.finder.utils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {
    public static String awf(String str) {
        AppMethodBeat.i(241812);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(241812);
            return "";
        }
        String substring = str.substring(0, Math.min(4, str.length()));
        AppMethodBeat.o(241812);
        return substring;
    }
}
