package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.recovery.util.Util;

class SnsTextUtil {
    SnsTextUtil() {
    }

    static String getReceiverText(Context context, String str, String str2) {
        AppMethodBeat.i(18718);
        String displayName = f.getDisplayName(str);
        if (displayName != null && displayName.length() > 10) {
            displayName = displayName.substring(0, 10) + context.getString(R.string.ip7);
        }
        if (Util.isNullOrNil(str2)) {
            str2 = displayName;
        } else if (!Util.isNullOrNil(displayName)) {
            str2 = displayName + "(" + f.bps(str2) + ")";
        }
        AppMethodBeat.o(18718);
        return str2;
    }
}
