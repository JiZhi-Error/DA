package com.tencent.mm.plugin.fts;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.PriorityBlockingQueue;

public final class g implements m {
    a wTJ = new a();

    public g() {
        AppMethodBeat.i(52559);
        AppMethodBeat.o(52559);
    }

    @Override // com.tencent.mm.plugin.fts.a.m
    public final boolean isStart() {
        AppMethodBeat.i(52560);
        if (this.wTJ == null || !this.wTJ.isAlive()) {
            AppMethodBeat.o(52560);
            return false;
        }
        AppMethodBeat.o(52560);
        return true;
    }

    public final void quit() {
        AppMethodBeat.i(52561);
        if (this.wTJ == null || !this.wTJ.isAlive()) {
            AppMethodBeat.o(52561);
            return;
        }
        this.wTJ.quit();
        try {
            this.wTJ.join();
        } catch (InterruptedException e2) {
        }
        this.wTJ = null;
        Log.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon quited.");
        AppMethodBeat.o(52561);
    }

    @Override // com.tencent.mm.plugin.fts.a.m
    public final com.tencent.mm.plugin.fts.a.a.a a(int i2, com.tencent.mm.plugin.fts.a.a.a aVar) {
        AppMethodBeat.i(52562);
        if (this.wTJ == null) {
            AppMethodBeat.o(52562);
            return null;
        }
        aVar.mPriority = i2;
        a aVar2 = this.wTJ;
        if (!aVar2.wTM) {
            int priority = aVar.getPriority();
            aVar2.wTL.put(aVar);
            if (aVar2.wTN == null) {
                aVar2.Nh(priority);
            } else if (priority < aVar2.wTK) {
                aVar2.interrupt();
                aVar2.Nh(priority);
            }
        }
        AppMethodBeat.o(52562);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public class a extends Thread {
        private int mTid = 0;
        int wTK = Integer.MAX_VALUE;
        PriorityBlockingQueue<com.tencent.mm.plugin.fts.a.a.a> wTL = new PriorityBlockingQueue<>();
        volatile boolean wTM = false;
        com.tencent.mm.plugin.fts.a.a.a wTN;
        private boolean wTO;
        Runnable wTP;
        boolean wTQ = false;

        public a() {
            super("SearchDaemon");
            AppMethodBeat.i(52554);
            AppMethodBeat.o(52554);
        }

        /* access modifiers changed from: package-private */
        public final synchronized void Nh(int i2) {
            AppMethodBeat.i(52555);
            if (this.wTK == i2 || !isAlive()) {
                AppMethodBeat.o(52555);
            } else {
                if (i2 < 0 && this.wTK >= 0) {
                    Process.setThreadPriority(this.mTid, -8);
                } else if (i2 >= 0 && this.wTK < 0) {
                    Process.setThreadPriority(this.mTid, this.wTO ? 10 : 0);
                }
                this.wTK = i2;
                AppMethodBeat.o(52555);
            }
        }

        public final synchronized void quit() {
            AppMethodBeat.i(52556);
            this.wTM = true;
            interrupt();
            AppMethodBeat.o(52556);
        }

        public final synchronized void pt(boolean z) {
            int i2 = 0;
            synchronized (this) {
                AppMethodBeat.i(52557);
                if (this.wTO == z) {
                    AppMethodBeat.o(52557);
                } else {
                    this.wTO = z;
                    if (this.wTK >= 0 && isAlive() && this.mTid != 0) {
                        if (this.wTO) {
                            i2 = 10;
                        }
                        try {
                            Process.setThreadPriority(this.mTid, i2);
                            Log.i("MicroMsg.FTS.FTSTaskDaemon", "*** Switch priority: " + (this.wTO ? "foreground" : "background"));
                            AppMethodBeat.o(52557);
                        } catch (SecurityException e2) {
                            Log.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e2, "setLowPriorityMode failed, tid=%d, p=%d", Integer.valueOf(this.mTid), Integer.valueOf(i2));
                        }
                    }
                    AppMethodBeat.o(52557);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x015f  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x01e8 A[SYNTHETIC, Splitter:B:63:0x01e8] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 848
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.g.a.run():void");
        }
    }
}
