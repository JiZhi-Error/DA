package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class m {
    private static String yUM = null;
    private static IListener<bp> yUN = new IListener<bp>() {
        /* class com.tencent.mm.plugin.luckymoney.model.m.AnonymousClass1 */

        {
            AppMethodBeat.i(160801);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(160801);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(65169);
            bp bpVar2 = bpVar;
            if (bpVar2.dEN != null && bpVar2.dEN.dEO == 53) {
                Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "luckyMoney resource file update, type: %s, subType: %s, filePath: %s", Integer.valueOf(bpVar2.dEN.dEO), Integer.valueOf(bpVar2.dEN.subType), bpVar2.dEN.filePath);
                if (!Util.isNullOrNil(bpVar2.dEN.filePath) && s.YS(bpVar2.dEN.filePath)) {
                    m.aq(bpVar2.dEN.filePath, bpVar2.dEN.dEO, bpVar2.dEN.subType);
                }
            }
            AppMethodBeat.o(65169);
            return false;
        }
    };

    static {
        AppMethodBeat.i(65175);
        AppMethodBeat.o(65175);
    }

    public static void unInit() {
        AppMethodBeat.i(65171);
        Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "unInit");
        EventCenter.instance.removeListener(yUN);
        AppMethodBeat.o(65171);
    }

    public static void efc() {
        AppMethodBeat.i(65172);
        o oVar = new o(b.aKJ() + "wallet/luckyMoneyEffect/");
        Log.d("MicroMsg.LuckMoneyEffectResourceMgr", "no media");
        if (oVar.isDirectory() && oVar.exists()) {
            Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "delete unused files: %s", Boolean.valueOf(s.dy(aa.z(oVar.mUri), true)));
        }
        AppMethodBeat.o(65172);
    }

    static /* synthetic */ void aq(final String str, final int i2, final int i3) {
        AppMethodBeat.i(65173);
        Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "start saveEffectResource %s %s %s", str, Integer.valueOf(i2), Integer.valueOf(i3));
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.luckymoney.model.m.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(65170);
                m.ar(str, i2, i3);
                AppMethodBeat.o(65170);
            }
        }, "LuckMoneyEffectResourceMgr_saveEffectResource");
        AppMethodBeat.o(65173);
    }

    static /* synthetic */ void ar(String str, int i2, int i3) {
        AppMethodBeat.i(65174);
        try {
            long currentTicks = Util.currentTicks();
            String str2 = yUM + i3;
            Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "on saveEffectResource: %s %s %s %s", str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
            s.fW(str, str2);
            Log.i("MicroMsg.LuckMoneyEffectResourceMgr", "saveEffectResource used %s", Long.valueOf(Util.ticksToNow(currentTicks)));
            AppMethodBeat.o(65174);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.LuckMoneyEffectResourceMgr", e2, "saveEffectResourceImpl error: %s", e2.getMessage());
            AppMethodBeat.o(65174);
        }
    }
}
