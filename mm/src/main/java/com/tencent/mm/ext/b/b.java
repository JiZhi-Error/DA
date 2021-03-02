package com.tencent.mm.ext.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static boolean oppohasCutOut(Context context) {
        AppMethodBeat.i(197904);
        if (context == null) {
            AppMethodBeat.o(197904);
            return false;
        }
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        AppMethodBeat.o(197904);
        return hasSystemFeature;
    }
}
