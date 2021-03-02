package com.tencent.mm.plugin.account.security.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class f {
    public static void p(boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(125527);
        if (!g.aAc()) {
            AppMethodBeat.o(125527);
            return;
        }
        int aUe = z.aUe();
        if (z) {
            i2 = aUe | 16384;
        } else {
            i2 = aUe & -16385;
        }
        g.aAh().azQ().set(40, Integer.valueOf(i2));
        if (z2) {
            bfx bfx = new bfx();
            bfx.LPB = 28;
            bfx.BsD = z ? 1 : 2;
            ((l) g.af(l.class)).aSM().d(new k.a(23, bfx));
            a.jRu.WZ();
        }
        AppMethodBeat.o(125527);
    }

    public static String dD(Context context) {
        AppMethodBeat.i(125528);
        if (context == null) {
            if (ChannelUtil.isNokiaAol) {
                String string = MMApplicationContext.getContext().getString(R.string.g_v);
                AppMethodBeat.o(125528);
                return string;
            }
            String string2 = MMApplicationContext.getContext().getString(R.string.g_u);
            AppMethodBeat.o(125528);
            return string2;
        } else if (ChannelUtil.isNokiaAol) {
            String string3 = context.getString(R.string.g_v);
            AppMethodBeat.o(125528);
            return string3;
        } else {
            String string4 = context.getString(R.string.g_u);
            AppMethodBeat.o(125528);
            return string4;
        }
    }

    public static String boP() {
        AppMethodBeat.i(125529);
        String str = Build.MANUFACTURER + "-" + Build.MODEL;
        AppMethodBeat.o(125529);
        return str;
    }
}
