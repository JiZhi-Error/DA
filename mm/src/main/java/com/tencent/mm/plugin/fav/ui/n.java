package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class n {
    public static String W(Context context, int i2) {
        AppMethodBeat.i(106957);
        if (i2 <= 0) {
            String string = context.getString(R.string.cd3, 0);
            AppMethodBeat.o(106957);
            return string;
        }
        int i3 = i2 / 60;
        int i4 = i2 % 60;
        if (i3 == 0) {
            String string2 = context.getString(R.string.cd3, Integer.valueOf(i4));
            AppMethodBeat.o(106957);
            return string2;
        }
        String string3 = context.getString(R.string.cd2, Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(106957);
        return string3;
    }

    public static boolean asr(String str) {
        AppMethodBeat.i(106958);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(106958);
            return false;
        } else if (!str.equals(MMApplicationContext.getContext().getResources().getString(R.string.el9))) {
            AppMethodBeat.o(106958);
            return true;
        } else {
            AppMethodBeat.o(106958);
            return false;
        }
    }

    public static String X(Context context, int i2) {
        AppMethodBeat.i(106959);
        String str = "[" + context.getResources().getString(i2) + "]";
        AppMethodBeat.o(106959);
        return str;
    }
}
