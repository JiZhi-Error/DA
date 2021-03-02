package com.tencent.mm.plugin.wenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public static boolean gkd() {
        int i2;
        AppMethodBeat.i(30670);
        String str = d.aXu().Fu("100352").gzz().get("Close");
        if (!Util.isNullOrNil(str)) {
            i2 = Util.getInt(str, 0);
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            AppMethodBeat.o(30670);
            return true;
        }
        AppMethodBeat.o(30670);
        return false;
    }
}
