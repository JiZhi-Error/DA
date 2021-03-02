package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public byte[] iBl;
    public long iBm = -1;

    public final int aSF() {
        if (this.iBl == null) {
            return -1;
        }
        return this.iBl.length;
    }

    public a() {
        AppMethodBeat.i(132228);
        if (aSG()) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.model.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(132227);
                    try {
                        if (a.aSG()) {
                            e.INSTANCE.idkeyStat(226, 1, 1, false);
                        }
                        AppMethodBeat.o(132227);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", Util.stackTraceToString(e2));
                        AppMethodBeat.o(132227);
                    }
                }
            }, 5000);
        }
        AppMethodBeat.o(132228);
    }

    public static boolean aSG() {
        AppMethodBeat.i(132229);
        if (com.tencent.mm.kernel.a.azj() || !g.aAc()) {
            AppMethodBeat.o(132229);
            return false;
        }
        int i2 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("AndroidUseWorkerAuthCache"), 0);
        g.aAi();
        g.aAf();
        int ch = i.ch(com.tencent.mm.kernel.a.getUin(), 100);
        boolean hasDebuger = CrashReportFactory.hasDebuger();
        g.aAi();
        g.aAf();
        Log.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", Boolean.valueOf(hasDebuger), Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(ch), Boolean.valueOf(g.aAf().azp()));
        if (hasDebuger) {
            AppMethodBeat.o(132229);
            return true;
        } else if (i2 > ch) {
            AppMethodBeat.o(132229);
            return true;
        } else {
            AppMethodBeat.o(132229);
            return false;
        }
    }

    public static void aSH() {
        AppMethodBeat.i(132230);
        if (!aSG()) {
            AppMethodBeat.o(132230);
            return;
        }
        try {
            g.aAi();
            a aVar = g.aAf().hpN;
            g.aAi();
            com.tencent.mm.network.e aZh = g.aAg().hqi.iMw.aZh();
            long nowMilliSecond = Util.nowMilliSecond();
            if (aZh == null) {
                Log.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
                e.INSTANCE.idkeyStat(226, 2, 1, false);
                AppMethodBeat.o(132230);
                return;
            }
            Log.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", Boolean.valueOf(aZh.aZb()), Integer.valueOf(aVar.aSF()));
            if (!aZh.aZb()) {
                e.INSTANCE.idkeyStat(226, 3, 1, false);
                Log.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
                AppMethodBeat.o(132230);
                return;
            }
            aVar.iBl = aZh.aZe();
            e.INSTANCE.idkeyStat(226, aVar.aSF() > 0 ? 4 : 5, 1, false);
            Log.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Integer.valueOf(aVar.aSF()), Long.valueOf(aVar.iBm));
            if (aVar.aSF() > 0) {
                e.INSTANCE.idkeyStat(226, 31 - (aVar.iBm > 5 ? 5 : aVar.iBm), 1, false);
                e.INSTANCE.a(11098, 2000, Long.valueOf(aVar.iBm));
                aVar.iBm = -1;
            }
            AppMethodBeat.o(132230);
        } catch (Throwable th) {
            Log.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", Util.stackTraceToString(th));
            AppMethodBeat.o(132230);
        }
    }

    public static void aSI() {
        AppMethodBeat.i(196994);
        try {
            g.aAi();
            if (g.aAf().hpN != null) {
                g.aAi();
                if (g.aAg().hqi.iMw != null) {
                    g.aAi();
                    a aVar = g.aAf().hpN;
                    g.aAi();
                    aVar.a(g.aAg().hqi.iMw.aZh());
                    AppMethodBeat.o(196994);
                    return;
                }
            }
            g.aAi();
            g.aAi();
            Log.i("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush but object is null [%s, %s]", g.aAf().hpN, g.aAg().hqi.iMw);
            AppMethodBeat.o(196994);
        } catch (Throwable th) {
            Log.e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", Util.stackTraceToString(th));
            AppMethodBeat.o(196994);
        }
    }

    private void a(com.tencent.mm.network.e eVar) {
        AppMethodBeat.i(196995);
        if (aSF() <= 0) {
            e.INSTANCE.idkeyStat(226, 11, 1, false);
            Log.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", toString());
            AppMethodBeat.o(196995);
            return;
        }
        int am = eVar.am(this.iBl);
        if (am != 0) {
            Log.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", Integer.valueOf(am));
            this.iBl = null;
            AppMethodBeat.o(196995);
            return;
        }
        this.iBm = 0;
        AppMethodBeat.o(196995);
    }
}
