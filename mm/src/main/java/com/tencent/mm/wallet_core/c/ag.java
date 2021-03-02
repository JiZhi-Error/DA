package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag {
    public static boolean bH(Intent intent) {
        AppMethodBeat.i(163884);
        if (intent == null) {
            AppMethodBeat.o(163884);
            return false;
        }
        int intExtra = intent.getIntExtra("key_pay_reslut_type", 0);
        if (intExtra == 1000) {
            Log.i("MicroMsg.WalletPayUtil", "onActivityResult isCanFinish %s %s", Integer.valueOf(intExtra), Util.getStack().toString());
            AppMethodBeat.o(163884);
            return true;
        }
        AppMethodBeat.o(163884);
        return false;
    }

    public static boolean bI(Intent intent) {
        AppMethodBeat.i(163885);
        if (intent == null) {
            AppMethodBeat.o(163885);
            return false;
        }
        int intExtra = intent.getIntExtra("key_pay_reslut_type", 0);
        if (intExtra == 1001) {
            Log.i("MicroMsg.WalletPayUtil", "onActivityResult isCanIgnore %s %s", Integer.valueOf(intExtra), Util.getStack().toString());
            AppMethodBeat.o(163885);
            return true;
        }
        AppMethodBeat.o(163885);
        return false;
    }

    public static String aR(Context context, int i2) {
        String aI;
        AppMethodBeat.i(163886);
        switch (i2) {
            case 1:
                aI = a.aI(context, R.string.iio);
                break;
            case 2:
                aI = a.aI(context, R.string.iit);
                break;
            case 3:
                aI = a.aI(context, R.string.iiu);
                break;
            case 4:
                aI = a.aI(context, R.string.iiv);
                break;
            case 5:
                aI = a.aI(context, R.string.iiw);
                break;
            case 6:
                aI = a.aI(context, R.string.iix);
                break;
            case 7:
                aI = a.aI(context, R.string.iiy);
                break;
            case 8:
                aI = a.aI(context, R.string.iiz);
                break;
            case 9:
                aI = a.aI(context, R.string.ij0);
                break;
            case 10:
                aI = a.aI(context, R.string.iip);
                break;
            case 11:
                aI = a.aI(context, R.string.iiq);
                break;
            case 12:
                aI = a.aI(context, R.string.iir);
                break;
            case 13:
                aI = a.aI(context, R.string.iis);
                break;
            default:
                aI = "";
                break;
        }
        AppMethodBeat.o(163886);
        return aI;
    }

    public static int aqj(int i2) {
        switch (i2) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
            default:
                return 3;
        }
    }
}
