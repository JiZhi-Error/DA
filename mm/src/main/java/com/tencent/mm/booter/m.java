package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;

public final class m {
    public static void run() {
        AppMethodBeat.i(19897);
        int i2 = h.aqJ().getInt("EnableFlockMultiProcSPProb", 0);
        bg.aVF();
        int ch = i.ch(c.getUin(), 101);
        boolean z = CrashReportFactory.hasDebuger() || (i2 > 0 && ch >= 0 && ch <= i2);
        MultiProcSharedPreferences.DynamicConfigStorage.setValue(MultiProcSharedPreferences.DynamicConfigStorage.PREF_KEY_IS_ENABLE_MULTIPROC_SP, z);
        Log.i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", Integer.valueOf(ch), Integer.valueOf(i2), Boolean.valueOf(z));
        AppMethodBeat.o(19897);
    }
}
