package com.tencent.mm.plugin.expt.hellhound.core.stack;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eih;

public final class h {
    public static boolean a(eih eih, eih eih2) {
        AppMethodBeat.i(121912);
        if (eih == null || eih2 == null) {
            AppMethodBeat.o(121912);
            return false;
        } else if (TextUtils.isEmpty(eih.activityName) || TextUtils.isEmpty(eih2.activityName)) {
            AppMethodBeat.o(121912);
            return false;
        } else {
            boolean equals = eih.activityName.equals(eih2.activityName);
            AppMethodBeat.o(121912);
            return equals;
        }
    }
}
