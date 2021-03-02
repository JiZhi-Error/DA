package com.tencent.mm.plugin.expt.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gw;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.plugin.expt.hellhound.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class e {
    private static e sKu;

    private e() {
    }

    public static e cRy() {
        AppMethodBeat.i(122389);
        if (sKu == null) {
            sKu = new e();
        }
        e eVar = sKu;
        AppMethodBeat.o(122389);
        return eVar;
    }

    public final void a(gw gwVar) {
        AppMethodBeat.i(122390);
        if (gwVar == null) {
            AppMethodBeat.o(122390);
            return;
        }
        int i2 = (int) gwVar.erY;
        if (i2 == e.a.MMAppMgr_Activated.value || i2 == e.a.MMAppMgr_Deactivated.value) {
            a(b.a.clicfg_weixin_mm_app_mgr, gwVar);
            if (a.cRq()) {
                gwVar.bfK();
            }
        }
        if (i2 == e.a.MMLifeCall_OnResume.value || i2 == e.a.MMLifeCall_OnPause.value) {
            a(b.a.clicfg_weixin_mm_life_call, gwVar);
            if (a.cRr()) {
                gwVar.bfK();
            }
        }
        if ((i2 == e.a.MMActivity_Back2Front.value || i2 == e.a.MMActivity_Front2Back.value) && a.cNo() && a.cNp()) {
            a(b.a.clicfg_weixin_mm_hell_hound, gwVar);
            if (a.cRs()) {
                gwVar.bfK();
            }
        }
        AppMethodBeat.o(122390);
    }

    private void a(b.a aVar, gw gwVar) {
        AppMethodBeat.i(122391);
        if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(122391);
            return;
        }
        long currentTicks = Util.currentTicks();
        int b2 = a.b(aVar);
        if (b2 <= 0) {
            AppMethodBeat.o(122391);
            return;
        }
        MultiProcessMMKV VQ = VQ();
        if (VQ == null) {
            AppMethodBeat.o(122391);
            return;
        }
        String str = VQ.getString(aVar.name(), "") + "|" + gwVar.uL(";");
        long j2 = VQ.getLong(aVar.name() + "_rpttime", 0);
        if ((str.length() >= b2 || Util.secondsToNow(j2) > 3600) && gwVar.erY % 2 == 0) {
            VQ.putLong(aVar.name() + "_rpttime", Util.nowSecond());
            VQ.putString(aVar.name(), "");
            h.INSTANCE.kvStat(16562, str);
            if (aVar == b.a.clicfg_weixin_mm_hell_hound) {
                arh(str);
            }
        } else {
            VQ.putString(aVar.name(), str);
        }
        Log.v("MicroMsg.MMPageReporter", "handle merge cost[%d]", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(122391);
    }

    private static MultiProcessMMKV VQ() {
        AppMethodBeat.i(122392);
        int azs = com.tencent.mm.kernel.a.azs();
        if (azs == 0) {
            AppMethodBeat.o(122392);
            return null;
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(azs + "_WxPageFlowMerge");
        AppMethodBeat.o(122392);
        return mmkv;
    }

    private void arh(final String str) {
        AppMethodBeat.i(122393);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.expt.g.e.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:45:0x011c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 503
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.g.e.AnonymousClass1.run():void");
            }
        }, "report_weixin_app_time");
        AppMethodBeat.o(122393);
    }
}
