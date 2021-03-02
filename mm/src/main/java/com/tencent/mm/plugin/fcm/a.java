package com.tencent.mm.plugin.fcm;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class a {
    private static final String[] tnA = {"Hi3751V811", "IdeaHub"};
    private static final String[] tny = {"A53", "A53m", "A53t", "A33m", "A33", "A33t", "R7Plust", "R7Plus", "A59t", "A59s", "A59m", "R9PlustA", "R9PlusmA", "R9PlustmA", "R9tm", "R9m", "R9km", "A37t", "A37m", "R7sPlus", "R7Plusm", "A53", "A51kc", "A51", "A30"};
    private static final String[] tnz = {"V1950A", "V1955A"};

    private static boolean cXe() {
        int i2;
        AppMethodBeat.i(192521);
        MultiProcessMMKV multiProcessMMKV = MultiProcessMMKV.getDefault();
        if (multiProcessMMKV == null || (i2 = multiProcessMMKV.getInt("fcm_last_anr_record", 0)) == 0) {
            AppMethodBeat.o(192521);
            return false;
        } else if (i2 == d.KyO) {
            AppMethodBeat.o(192521);
            return true;
        } else {
            AppMethodBeat.o(192521);
            return false;
        }
    }

    public static void asz(String str) {
        MultiProcessMMKV multiProcessMMKV;
        AppMethodBeat.i(192522);
        if (!TextUtils.isEmpty(str) && str.contains("com.google.android.gms.common.internal.BaseGmsClient") && str.contains("android.os.BinderProxy.transactNative(Native Method)") && (multiProcessMMKV = MultiProcessMMKV.getDefault()) != null) {
            multiProcessMMKV.encode("fcm_last_anr_record", d.KyO);
        }
        AppMethodBeat.o(192522);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean fj(android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 398
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fcm.a.fj(android.content.Context):boolean");
    }
}
