package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p {
    public static n a(Context context, int i2) {
        AppMethodBeat.i(221702);
        f fVar = null;
        if (i2 == 2 || i2 == 4 || i2 == 4 || i2 == 6 || i2 == 3) {
            TXCLog.e("TXSDKUtil", "create player error not support type : ".concat(String.valueOf(i2)));
        } else {
            fVar = new f(context);
        }
        AppMethodBeat.o(221702);
        return fVar;
    }

    public static String a() {
        return "";
    }
}
