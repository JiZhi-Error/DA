package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;

public final class ah {
    public static int hhy() {
        AppMethodBeat.i(72821);
        if (z.aUo()) {
            AppMethodBeat.o(72821);
            return R.string.ip1;
        }
        AppMethodBeat.o(72821);
        return R.string.ip2;
    }

    public static String hhz() {
        AppMethodBeat.i(72822);
        if (z.aUo()) {
            AppMethodBeat.o(72822);
            return "R";
        } else if (z.aUp()) {
            AppMethodBeat.o(72822);
            return "HK$";
        } else {
            AppMethodBeat.o(72822);
            return "¥";
        }
    }

    public static String hhA() {
        return "¥";
    }

    public static int hhB() {
        AppMethodBeat.i(72823);
        if (z.aUo()) {
            AppMethodBeat.o(72823);
            return R.layout.c_j;
        }
        AppMethodBeat.o(72823);
        return R.layout.c8p;
    }

    public static int hhC() {
        AppMethodBeat.i(72824);
        if (z.aUo()) {
            AppMethodBeat.o(72824);
            return R.string.i9s;
        }
        AppMethodBeat.o(72824);
        return R.string.i9p;
    }

    public static int hhD() {
        AppMethodBeat.i(72825);
        if (z.aUo()) {
            AppMethodBeat.o(72825);
            return R.layout.yx;
        }
        AppMethodBeat.o(72825);
        return R.layout.yw;
    }

    public static String kQ(Context context) {
        AppMethodBeat.i(72826);
        if (z.aUo()) {
            String string = context.getString(R.string.ipb);
            AppMethodBeat.o(72826);
            return string;
        }
        String string2 = context.getString(R.string.ipa);
        AppMethodBeat.o(72826);
        return string2;
    }

    public static int hhE() {
        AppMethodBeat.i(214334);
        if (z.aUo()) {
            AppMethodBeat.o(214334);
            return R.string.b6s;
        }
        AppMethodBeat.o(214334);
        return R.string.b6r;
    }

    public static int hhF() {
        AppMethodBeat.i(72827);
        if (z.aUo()) {
            AppMethodBeat.o(72827);
            return R.string.iam;
        }
        AppMethodBeat.o(72827);
        return R.string.ial;
    }
}
