package com.tencent.mm.ap;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* access modifiers changed from: package-private */
public final class c implements Runnable {
    private static long iTF = 0;
    int iTE = 0;
    private d iTG = null;
    a iTH = new a();
    private long iTI = 0;
    long iTJ = 0;
    long iTK = 0;
    String iTL = null;
    private String iTM = null;
    boolean iTN = false;

    c() {
        AppMethodBeat.i(132530);
        if (this.iTL == null) {
            this.iTL = com.tencent.mm.loader.j.b.aKB() + "ProcessDetector";
            o oVar = new o(this.iTL);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
        }
        if (MMApplicationContext.isMMProcess()) {
            this.iTM = this.iTL + "/mm";
            AppMethodBeat.o(132530);
            return;
        }
        if (MMApplicationContext.isPushProcess()) {
            this.iTM = this.iTL + "/push";
        }
        AppMethodBeat.o(132530);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x02ab, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.ActiveDetector.ProcessDetector", "process detector thread interrupt.thread id:%s", java.lang.Integer.valueOf(android.os.Process.myTid()));
        java.lang.Thread.currentThread().interrupt();
        r14.iTN = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0354, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0355, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ObjectUtil", "Write close exception:" + r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0371, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0372, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.ActiveDetector.ProcessDetector", "%s,write exception:" + r0.getMessage(), r14.iTM);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x03b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x03ba, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ObjectUtil", "Write close exception:" + r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x03e4, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x03e5, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.ObjectUtil", "Write close exception:" + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0406, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x02aa A[ExcHandler: InterruptedException (e java.lang.InterruptedException), Splitter:B:18:0x01cc] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x03b4 A[SYNTHETIC, Splitter:B:75:0x03b4] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x03da A[SYNTHETIC, Splitter:B:82:0x03da] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x03dd A[EDGE_INSN: B:97:0x03dd->B:84:0x03dd ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 1035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ap.c.run():void");
    }

    private static void a(a aVar) {
        AppMethodBeat.i(132532);
        if (aVar == null) {
            AppMethodBeat.o(132532);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            for (d dVar : aVar.iTO) {
                if (dVar != null) {
                    if (currentTimeMillis - dVar.endTime < 259200000) {
                        break;
                    }
                    aVar.iTO.remove(dVar);
                } else {
                    aVar.iTO.remove(dVar);
                }
            }
            for (C0259c cVar : aVar.iTP) {
                if (cVar != null) {
                    if (currentTimeMillis - cVar.time < 259200000) {
                        break;
                    }
                    aVar.iTP.remove(cVar);
                } else {
                    aVar.iTP.remove(cVar);
                }
            }
            for (C0259c cVar2 : aVar.iTQ) {
                if (cVar2 != null) {
                    if (currentTimeMillis - cVar2.time < 259200000) {
                        break;
                    }
                    aVar.iTQ.remove(cVar2);
                } else {
                    aVar.iTQ.remove(cVar2);
                }
            }
            a(currentTimeMillis, aVar.iTR);
            a(currentTimeMillis, aVar.iTS);
            a(currentTimeMillis, aVar.iTT);
            a(currentTimeMillis, aVar.iTU);
            a(currentTimeMillis, aVar.iTV);
            a(currentTimeMillis, aVar.iTW);
            a(currentTimeMillis, aVar.iTX);
            a(currentTimeMillis, aVar.iTY);
            a(currentTimeMillis, aVar.iTZ);
            a(currentTimeMillis, aVar.iUa);
            a(currentTimeMillis, aVar.iUb);
            a(currentTimeMillis, aVar.iUc);
            a(currentTimeMillis, aVar.iUd);
            a(currentTimeMillis, aVar.iUe);
            a(currentTimeMillis, aVar.iUf);
            a(currentTimeMillis, aVar.iUg);
            a(currentTimeMillis, aVar.iUh);
            a(currentTimeMillis, aVar.iUi);
            a(currentTimeMillis, aVar.iUj);
            a(currentTimeMillis, aVar.iUk);
            AppMethodBeat.o(132532);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ActiveDetector.ProcessDetector", e2, "check data exception.", new Object[0]);
            AppMethodBeat.o(132532);
        }
    }

    private static void a(long j2, List<b> list) {
        AppMethodBeat.i(132533);
        for (b bVar : list) {
            if (bVar != null) {
                if (j2 - bVar.iUl < 259200000) {
                    break;
                }
                list.remove(bVar);
            } else {
                list.remove(bVar);
            }
        }
        AppMethodBeat.o(132533);
    }

    private static long bbs() {
        AppMethodBeat.i(132534);
        if (iTF == 0) {
            iTF = Util.getLong(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_android_process_detect_time", "5", false, true), 5) * 60 * 1000;
        }
        long j2 = iTF;
        AppMethodBeat.o(132534);
        return j2;
    }

    public static class d implements Serializable {
        long endTime = 0;
        boolean iTy = true;
        boolean iTz = false;
        long iUn = 0;
        int networkStatus = 0;
        int pid = 0;
        long startTime = 0;

        /* access modifiers changed from: package-private */
        public final void b(int i2, long j2, long j3, int i3) {
            AppMethodBeat.i(132527);
            this.pid = i2;
            if (this.startTime <= 0) {
                this.startTime = j2;
                this.iUn = cl.aWy();
            }
            this.endTime = j3;
            this.networkStatus = i3;
            AppMethodBeat.o(132527);
        }

        static d c(int i2, long j2, long j3, int i3) {
            AppMethodBeat.i(132528);
            d dVar = new d();
            dVar.pid = i2;
            dVar.startTime = j2;
            dVar.endTime = j3;
            dVar.networkStatus = i3;
            AppMethodBeat.o(132528);
            return dVar;
        }

        public final String toString() {
            AppMethodBeat.i(132529);
            String format = String.format("pid:%s,startServerTime:%s,startTime:%s,endTime:%s,normalExecute:%s,changedNetworkStatus:%s,networkStatus:%s", Integer.valueOf(this.pid), a.Av(this.iUn), a.Av(this.startTime), a.Av(this.endTime), Boolean.valueOf(this.iTy), Boolean.valueOf(this.iTz), Integer.valueOf(this.networkStatus));
            AppMethodBeat.o(132529);
            return format;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ap.c$c  reason: collision with other inner class name */
    public static class C0259c implements Serializable {
        long iTx = 0;
        long iUm;
        long time = 0;
        int type = 0;

        C0259c(long j2, long j3, int i2, long j4) {
            this.iTx = j2;
            this.time = j3;
            this.type = i2;
            this.iUm = j4;
        }

        public final String toString() {
            AppMethodBeat.i(132526);
            String format = String.format("serverTime:%s,time:%s,type:%s,recvTime:%s", a.Av(this.iTx), a.Av(this.time), Integer.valueOf(this.type), Long.valueOf(this.iUm));
            AppMethodBeat.o(132526);
            return format;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements Serializable {
        long iTB = 0;
        long iTC = 0;
        long iTD = 0;
        long iTx = 0;
        long iUl = 0;
        int msgType = 0;
        int pid = 0;
        String username = "";

        b(int i2, long j2, long j3, long j4, long j5, long j6, String str, int i3) {
            this.pid = i2;
            this.iTx = j2;
            this.iUl = j3;
            this.iTB = j4;
            this.iTC = j5;
            this.iTD = j6;
            this.username = str;
            this.msgType = i3;
        }

        public final String toString() {
            AppMethodBeat.i(132525);
            String format = String.format("pid:%s, server time:%s, client time:%s, msg server time:%s, intervalTime:%s, msg server id:%s username:%s, msgType:%s", Integer.valueOf(this.pid), a.Av(this.iTx), a.Av(this.iUl), a.Av(this.iTB), Long.valueOf(this.iTC), Long.valueOf(this.iTD), this.username, Integer.valueOf(this.msgType));
            AppMethodBeat.o(132525);
            return format;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements Serializable {
        final List<d> iTO = new CopyOnWriteArrayList();
        final List<C0259c> iTP = new CopyOnWriteArrayList();
        final List<C0259c> iTQ = new CopyOnWriteArrayList();
        final List<b> iTR = new CopyOnWriteArrayList();
        final List<b> iTS = new CopyOnWriteArrayList();
        final List<b> iTT = new CopyOnWriteArrayList();
        final List<b> iTU = new CopyOnWriteArrayList();
        final List<b> iTV = new CopyOnWriteArrayList();
        final List<b> iTW = new CopyOnWriteArrayList();
        final List<b> iTX = new CopyOnWriteArrayList();
        final List<b> iTY = new CopyOnWriteArrayList();
        final List<b> iTZ = new CopyOnWriteArrayList();
        final List<b> iUa = new CopyOnWriteArrayList();
        final List<b> iUb = new CopyOnWriteArrayList();
        final List<b> iUc = new CopyOnWriteArrayList();
        final List<b> iUd = new CopyOnWriteArrayList();
        final List<b> iUe = new CopyOnWriteArrayList();
        final List<b> iUf = new CopyOnWriteArrayList();
        final List<b> iUg = new CopyOnWriteArrayList();
        final List<b> iUh = new CopyOnWriteArrayList();
        final List<b> iUi = new CopyOnWriteArrayList();
        final List<b> iUj = new CopyOnWriteArrayList();
        final List<b> iUk = new CopyOnWriteArrayList();

        a() {
            AppMethodBeat.i(132524);
            AppMethodBeat.o(132524);
        }
    }

    private static void b(a aVar) {
        AppMethodBeat.i(132535);
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ProcessInfo <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        if (aVar.iTO.size() > 0) {
            sb.append("processStatusList:\n");
            for (d dVar : aVar.iTO) {
                sb.append("\t").append(dVar).append("\n");
            }
        }
        if (aVar.iTP.size() > 0) {
            sb.append("sendInterProcessList:\n");
            for (C0259c cVar : aVar.iTP) {
                sb.append("\t").append(cVar).append("\n");
            }
        }
        if (aVar.iTQ.size() > 0) {
            sb.append("receiveInterProcessList:\n");
            for (C0259c cVar2 : aVar.iTQ) {
                sb.append("\t").append(cVar2).append("\n");
            }
        }
        sb.append(">>>>>>>>>>>>>>>>>>>>> foreground <<<<<<<<<<<<<<<<<<<<<\n");
        a(sb, aVar.iTR, "foregroundDelayed2sMsgList");
        a(sb, aVar.iTS, "foregroundDelayed5sMsgList");
        a(sb, aVar.iTT, "foregroundDelayed10sMsgList");
        a(sb, aVar.iTU, "foregroundDelayed30sMsgList");
        a(sb, aVar.iTV, "foregroundDelayed1minMsgList");
        a(sb, aVar.iTW, "foregroundDelayed3minMsgList");
        a(sb, aVar.iTX, "foregroundDelayed5minMsgList");
        a(sb, aVar.iTY, "foregroundDelayed10minMsgList");
        a(sb, aVar.iTZ, "foregroundDelayed30minMsgList");
        a(sb, aVar.iUa, "foregroundDelayed1hMsgList");
        sb.append(">>>>>>>>>>>>>>>>>>>>> background <<<<<<<<<<<<<<<<<<<<<\n");
        a(sb, aVar.iUb, "backgroundDelayed2sMsgList");
        a(sb, aVar.iUc, "backgroundDelayed5sMsgList");
        a(sb, aVar.iUd, "backgroundDelayed10sMsgList");
        a(sb, aVar.iUe, "backgroundDelayed30sMsgList");
        a(sb, aVar.iUf, "backgroundDelayed1minMsgList");
        a(sb, aVar.iUg, "backgroundDelayed3minMsgList");
        a(sb, aVar.iUh, "backgroundDelayed5minMsgList");
        a(sb, aVar.iUi, "backgroundDelayed10minMsgList");
        a(sb, aVar.iUj, "backgroundDelayed30minMsgList");
        a(sb, aVar.iUk, "backgroundDelayed1hMsgList");
        sb.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Log.i("MicroMsg.ActiveDetector.ProcessDetector", "printProcessInfoAndReport()\n".concat(String.valueOf(sb)));
        AppMethodBeat.o(132535);
    }

    private static boolean a(StringBuilder sb, List<b> list, String str) {
        AppMethodBeat.i(132536);
        if (list.size() > 0) {
            sb.append(str).append("[").append(list.size()).append("]:\n");
            for (b bVar : list) {
                sb.append("\t").append(bVar).append("\n");
            }
            AppMethodBeat.o(132536);
            return true;
        }
        AppMethodBeat.o(132536);
        return false;
    }
}
