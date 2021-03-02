package com.tencent.mm.ag;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

public final class l {
    public static int t(ca caVar) {
        AppMethodBeat.i(150131);
        if (caVar.dOQ()) {
            k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
            if (aD == null) {
                AppMethodBeat.o(150131);
                return 0;
            }
            int i2 = aD.type;
            AppMethodBeat.o(150131);
            return i2;
        }
        AppMethodBeat.o(150131);
        return 0;
    }

    public static int u(ca caVar) {
        int i2 = 0;
        AppMethodBeat.i(150132);
        try {
            if (caVar.dOQ()) {
                k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
                if (aD == null || TextUtils.isEmpty(aD.iyq)) {
                    AppMethodBeat.o(150132);
                    return i2;
                }
                i2 = Integer.parseInt(aD.iyq);
                AppMethodBeat.o(150132);
                return i2;
            }
        } catch (Exception e2) {
            Log.printInfoStack("AppMessageHelper", "", e2);
        }
        AppMethodBeat.o(150132);
        return i2;
    }
}
