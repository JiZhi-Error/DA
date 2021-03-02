package com.tencent.mm.plugin.sns.ui.widget;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static boolean kS(String str, String str2) {
        AppMethodBeat.i(203998);
        if (TextUtils.isEmpty(str) || !str.equals(str2)) {
            Log.d("SnsCardAdTagUtils", "should refresh adTag");
            AppMethodBeat.o(203998);
            return false;
        }
        Log.d("SnsCardAdTagUtils", "should not refresh adTag, show origin adTag");
        AppMethodBeat.o(203998);
        return true;
    }
}
