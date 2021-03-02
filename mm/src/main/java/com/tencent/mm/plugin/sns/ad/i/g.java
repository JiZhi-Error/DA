package com.tencent.mm.plugin.sns.ad.i;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.IntentUtil;

public final class g extends IntentUtil {
    public static double h(Bundle bundle, String str) {
        double d2 = 0.0d;
        AppMethodBeat.i(202359);
        if (bundle == null) {
            AppMethodBeat.o(202359);
        } else {
            try {
                d2 = bundle.getDouble(str, 0.0d);
            } catch (Throwable th) {
            }
            AppMethodBeat.o(202359);
        }
        return d2;
    }
}
