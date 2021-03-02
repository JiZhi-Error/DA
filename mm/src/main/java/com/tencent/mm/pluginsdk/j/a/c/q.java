package com.tencent.mm.pluginsdk.j.a.c;

import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class q {
    public final t Kak;
    public final n Kal;
    public final i Kam;
    private volatile MMHandler dgG;
    public final MMHandler handler;
    public final boolean lsb;

    /* synthetic */ q(byte b2) {
        this();
    }

    public static final class a {
        private static final q Kan = new q((byte) 0);

        static {
            AppMethodBeat.i(152057);
            AppMethodBeat.o(152057);
        }
    }

    private q() {
        AppMethodBeat.i(152059);
        this.dgG = null;
        r.init();
        this.Kak = t.goc();
        if (this.Kak == null) {
            this.lsb = false;
            this.Kal = null;
            this.handler = null;
            this.Kam = null;
            AppMethodBeat.o(152059);
            return;
        }
        this.lsb = true;
        this.handler = new MMHandler("ResDownloader-EventThread");
        this.Kam = new i(cyh());
        this.Kal = new n("ResDownloader-EventThread", this.Kam);
        AppMethodBeat.o(152059);
    }

    public final void aj(Runnable runnable) {
        AppMethodBeat.i(152060);
        cyh().postToWorker(new b(runnable, (byte) 0));
        AppMethodBeat.o(152060);
    }

    public final MMHandler cyh() {
        AppMethodBeat.i(184269);
        if (this.dgG == null) {
            this.dgG = new MMHandler("ResDownloader-WorkerThread");
            this.dgG.setLogging(false);
        }
        MMHandler mMHandler = this.dgG;
        AppMethodBeat.o(184269);
        return mMHandler;
    }

    static n.a c(l lVar) {
        AppMethodBeat.i(152062);
        Log.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
        int hashCode = lVar.avy().hashCode();
        for (g gVar : r.gob()) {
            Log.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", gVar.getClass().getSimpleName(), gVar.avy());
            if (gVar.avy().hashCode() == hashCode) {
                n.a c2 = gVar.c(lVar);
                AppMethodBeat.o(152062);
                return c2;
            }
        }
        AppMethodBeat.o(152062);
        return null;
    }

    public final void h(s sVar) {
        boolean z;
        AppMethodBeat.i(152063);
        if (this.lsb) {
            long nowMilliSecond = Util.nowMilliSecond();
            if (this.Kak.beg(sVar.field_urlKey) != null) {
                this.Kak.i(sVar);
                z = false;
            } else {
                this.Kak.j(sVar);
                z = true;
            }
            Log.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", sVar.field_urlKey, Boolean.valueOf(z), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
        }
        AppMethodBeat.o(152063);
    }

    public final s beg(String str) {
        boolean z = false;
        AppMethodBeat.i(152064);
        if (this.lsb) {
            long nowMilliSecond = Util.nowMilliSecond();
            s beg = this.Kak.beg(str);
            Object[] objArr = new Object[3];
            objArr[0] = str;
            if (beg != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Long.valueOf(Util.milliSecondsToNow(nowMilliSecond));
            Log.i("MicroMsg.ResDownloaderCore", "doQuery: urlKey = %s, ret = %b, cost = %d", objArr);
            AppMethodBeat.o(152064);
            return beg;
        }
        AppMethodBeat.o(152064);
        return null;
    }

    public final int d(l lVar) {
        AppMethodBeat.i(152065);
        if (!this.lsb) {
            AppMethodBeat.o(152065);
            return -1;
        } else if (Util.isNullOrNil(lVar.url)) {
            Log.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", lVar.JYs);
            AppMethodBeat.o(152065);
            return 3;
        } else {
            Log.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", lVar.JYs);
            int b2 = this.Kal.b(lVar);
            AppMethodBeat.o(152065);
            return b2;
        }
    }

    public final boolean beh(String str) {
        AppMethodBeat.i(152066);
        if (!this.lsb) {
            AppMethodBeat.o(152066);
            return false;
        } else if (this.Kal.bec(str) || this.Kal.bed(str)) {
            AppMethodBeat.o(152066);
            return true;
        } else {
            AppMethodBeat.o(152066);
            return false;
        }
    }

    public final void Zb(String str) {
        AppMethodBeat.i(152067);
        if (this.lsb) {
            this.Kal.bef(str);
        }
        AppMethodBeat.o(152067);
    }

    public static class b implements Runnable {
        private final Runnable dQN;

        /* synthetic */ b(Runnable runnable, byte b2) {
            this(runnable);
        }

        private b(Runnable runnable) {
            this.dQN = runnable;
        }

        public final void run() {
            AppMethodBeat.i(152058);
            if (!(Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) && Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
            if (this.dQN != null) {
                this.dQN.run();
            }
            AppMethodBeat.o(152058);
        }
    }
}
