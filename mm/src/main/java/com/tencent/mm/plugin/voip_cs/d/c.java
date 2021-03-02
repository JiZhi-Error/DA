package com.tencent.mm.plugin.voip_cs.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c {
    private static int HsM = 0;
    public static final int wfQ = a.fromDPToPix(MMApplicationContext.getContext(), 4);
    public static final int zSD = a.fromDPToPix(MMApplicationContext.getContext(), 230);
    public static final int zSd = a.fromDPToPix(MMApplicationContext.getContext(), 3);
    public static final int zSe = a.fromDPToPix(MMApplicationContext.getContext(), 8);
    public static final int zSf = a.fromDPToPix(MMApplicationContext.getContext(), 10);
    public static final int zSh = a.fromDPToPix(MMApplicationContext.getContext(), 14);
    public static final int zSl = a.fromDPToPix(MMApplicationContext.getContext(), 30);
    public static final int zSn = a.fromDPToPix(MMApplicationContext.getContext(), 32);
    public static final int zSv = a.fromDPToPix(MMApplicationContext.getContext(), 76);
    public static final int zSy = a.fromDPToPix(MMApplicationContext.getContext(), 96);

    static {
        AppMethodBeat.i(125492);
        AppMethodBeat.o(125492);
    }

    public static int hI(Context context) {
        AppMethodBeat.i(125491);
        if (HsM == 0) {
            HsM = a.jo(context);
        }
        int i2 = HsM;
        AppMethodBeat.o(125491);
        return i2;
    }
}
