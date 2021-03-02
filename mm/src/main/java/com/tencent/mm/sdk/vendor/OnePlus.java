package com.tencent.mm.sdk.vendor;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class OnePlus {
    private static String TAG = "MicroMsg.Vendor.OnePlus";
    private static Boolean ifOnePlus = null;

    public static boolean isOnePlus() {
        AppMethodBeat.i(177603);
        if (ifOnePlus == null) {
            String str = Build.BRAND;
            Log.i(TAG, "Build.BRAND = %s", str);
            if (str.toLowerCase().contains("oneplus")) {
                ifOnePlus = Boolean.TRUE;
            } else {
                ifOnePlus = Boolean.FALSE;
            }
        }
        boolean booleanValue = ifOnePlus.booleanValue();
        AppMethodBeat.o(177603);
        return booleanValue;
    }
}
