package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;

public final class b {
    private static int mEX;
    private static int mEY;
    public SnsInfo DsC;
    public int Dus;
    public int Dut;
    public long Duu;
    public long Duv;

    public static int getScreenHeight() {
        AppMethodBeat.i(202030);
        if (mEY == 0) {
            try {
                int[] ha = ap.ha(MMApplicationContext.getContext());
                mEX = ha[0];
                mEY = ha[1];
            } catch (Throwable th) {
                Log.e("AdExposureParams", "getScreenHeight exp=" + th.toString());
            }
        }
        int i2 = mEY;
        AppMethodBeat.o(202030);
        return i2;
    }

    public static int getScreenWidth() {
        AppMethodBeat.i(202031);
        if (mEX == 0) {
            try {
                int[] ha = ap.ha(MMApplicationContext.getContext());
                mEX = ha[0];
                mEY = ha[1];
            } catch (Throwable th) {
                Log.e("AdExposureParams", "getScreenWidth exp=" + th.toString());
            }
        }
        int i2 = mEX;
        AppMethodBeat.o(202031);
        return i2;
    }

    public static int eXn() {
        AppMethodBeat.i(202032);
        boolean z = false;
        try {
            z = ao.isDarkMode();
        } catch (Throwable th) {
            Log.e("AdExposureParams", "getDarkModeStatus exp=" + th.toString());
        }
        if (z) {
            AppMethodBeat.o(202032);
            return 2;
        }
        AppMethodBeat.o(202032);
        return 1;
    }
}
