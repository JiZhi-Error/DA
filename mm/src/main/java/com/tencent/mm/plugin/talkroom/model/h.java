package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class h {
    private static final int FPn = a.FPn;

    public static String bC(Context context, String str) {
        AppMethodBeat.i(29528);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(29528);
            return null;
        }
        bg.aVF();
        as Kn = c.aSN().Kn(str);
        if (Kn == null) {
            AppMethodBeat.o(29528);
            return null;
        } else if (!ab.Eq(str)) {
            String displayName = aa.getDisplayName(str);
            AppMethodBeat.o(29528);
            return displayName;
        } else if (Util.isNullOrNil(Kn.field_nickname)) {
            String string = context.getString(R.string.hkw);
            AppMethodBeat.o(29528);
            return string;
        } else {
            String arI = Kn.arI();
            AppMethodBeat.o(29528);
            return arI;
        }
    }
}
