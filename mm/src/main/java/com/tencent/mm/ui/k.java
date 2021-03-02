package com.tencent.mm.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class k {
    public static void a(final Activity activity, final int i2, final int i3, String str) {
        AppMethodBeat.i(33284);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.ui.k.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(33283);
                Activity activity = activity;
                int i2 = i2;
                int i3 = i3;
                Log.i("MicroMsg.LauncherUI.HomeUtil", "clickFlowStat index:%d op:%d %s", Integer.valueOf(i3), Integer.valueOf(i2), Util.getStack());
                if (i3 >= 0) {
                    String str = "MainUI";
                    if (i3 == 1) {
                        str = "AddressUI";
                    }
                    if (i3 == 2) {
                        str = "FindMoreFriendUI";
                    }
                    if (i3 == 3) {
                        str = "MoreTabUI";
                    }
                    d.d(i2, str, ((activity.hashCode() / 16) * 16) + i3);
                }
                AppMethodBeat.o(33283);
            }
        }, str);
        AppMethodBeat.o(33284);
    }
}
