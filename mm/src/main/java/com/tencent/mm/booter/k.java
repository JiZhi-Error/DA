package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class k {
    public static void run() {
        AppMethodBeat.i(19890);
        int i2 = h.aqJ().getInt("EnableForgroundService", 0);
        bg.aVF();
        int ch = i.ch(c.getUin(), 101);
        boolean z = CrashReportFactory.hasDebuger() || (i2 > 0 && ch >= 0 && ch <= i2);
        if (!z) {
            z = d.KyR;
        }
        if (!z) {
            z = CrashReportFactory.hasDebuger();
        }
        if (ChannelUtil.channelId == 1) {
            z = false;
        }
        MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", z).commit();
        Log.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", Integer.valueOf(ch), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(d.KyR), Integer.valueOf(ChannelUtil.channelId));
        AppMethodBeat.o(19890);
    }
}
