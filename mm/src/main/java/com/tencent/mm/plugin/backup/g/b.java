package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.backup.g.h;
import com.tencent.mm.plugin.backup.g.j;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public abstract class b extends q {
    private static final MMHandler handler = new MMHandler(Looper.getMainLooper());
    static int oIY = -1;
    private static final Map<Integer, Set<i>> oPn = new HashMap();
    private static final LinkedHashMap<Integer, b> oPo = new LinkedHashMap<>();
    private static d oPp;
    static a oPq;
    private static f oPr = null;
    private static j oPs = null;
    private static g oPt = null;
    private static h oPu = null;
    private static int oPv = new Random(Util.nowMilliSecond()).nextInt(1147483648);
    private static c oPw = null;
    private PByteArray oPm = new PByteArray();

    public interface a {
        void l(int i2, byte[] bArr);

        int m(int i2, byte[] bArr);
    }

    /* renamed from: com.tencent.mm.plugin.backup.g.b$b  reason: collision with other inner class name */
    public interface AbstractC0847b {
        void jE(boolean z);
    }

    public interface c {
        void cfK();
    }

    public interface d {
        void a(boolean z, int i2, byte[] bArr, int i3);
    }

    public abstract void Bm(int i2);

    public abstract com.tencent.mm.bw.a cgq();

    public abstract com.tencent.mm.bw.a cgr();

    @Override // com.tencent.mm.ak.q
    public abstract int getType();

    public static void a(d dVar) {
        oPp = dVar;
    }

    public static void a(a aVar) {
        oPq = aVar;
    }

    public static void Bb(int i2) {
        oIY = i2;
    }

    public static int ceP() {
        return oIY;
    }

    public static void cgs() {
        if (oPr != null) {
            oPr.stop();
        }
        f fVar = new f();
        oPr = fVar;
        fVar.start(true);
    }

    public static void cgt() {
        if (oPr != null) {
            oPr.stop();
        }
    }

    public static void a(j.a aVar) {
        oPs = new j(aVar);
    }

    public static void cgu() {
        if (oPs != null) {
            j jVar = oPs;
            Log.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
            jVar.oQi = Util.nowMilliSecond();
            jVar.oQh = 0;
            jVar.oQf = 0;
            jVar.oQl.clear();
            jVar.oQk = 0;
            jVar.oQj = 0;
            for (int i2 = 0; i2 < 10; i2++) {
                jVar.oQl.offer(204800L);
            }
            jVar.oQm.startTimer(1000);
            return;
        }
        Log.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
    }

    public static void cgv() {
        if (oPs != null) {
            j jVar = oPs;
            Log.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
            jVar.oQm.stopTimer();
            jVar.oQk = 0;
        }
    }

    public static String cgw() {
        if (oPs == null) {
            return "0B";
        }
        String Bx = j.Bx(oPs.oQg);
        Log.i("MicroMsg.BackupSpeedCalculator", "getBackupSpeed[%s]", Bx);
        return Bx;
    }

    public static void cgx() {
        if (oPt == null) {
            oPt = new g();
        }
        g gVar = oPt;
        try {
            Log.i("MicroMsg.BackupLogManager", "start");
            g.init();
            if (gVar.oPT != null) {
                gVar.oPT.stopTimer();
                gVar.oPT = null;
            }
            g.startTime = Util.nowMilliSecond();
            g.oPR = gVar.Bw(g.startTime);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupLogManager", e2, "start exception", new Object[0]);
        }
    }

    public static void Bn(int i2) {
        if (oPt != null) {
            g gVar = oPt;
            try {
                Log.i("MicroMsg.BackupLogManager", "end backupMode[%d]", Integer.valueOf(i2));
                if (g.startTime == 0 || g.oPR == 0) {
                    Log.e("MicroMsg.BackupLogManager", "end is zero, startTime[%d], startLogSize[%d], skip report", Long.valueOf(g.startTime), Long.valueOf(g.oPR));
                    return;
                }
                g.endTime = Util.nowMilliSecond();
                g.oPS = gVar.K(g.startTime, g.endTime);
                Log.i("MicroMsg.BackupLogManager", "end, backupMode[%d], endTime[%d], startTime[%d], endLogSize[%d], startLogSize[%d]", Integer.valueOf(i2), Long.valueOf(g.endTime), Long.valueOf(g.startTime), Long.valueOf(g.oPS), Long.valueOf(g.oPR));
                if (g.oPS != 0 && g.oPS > g.oPR) {
                    gVar.a(i2, g.endTime - g.startTime, g.oPS - g.oPR, false);
                }
                g.init();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.BackupLogManager", e2, "end exception", new Object[0]);
            }
        }
    }

    public static void a(h.a aVar) {
        if (oPu == null) {
            Log.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
        } else if (!oPu.stopped) {
            Log.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
            return;
        } else {
            Log.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
        }
        h hVar = new h(aVar);
        oPu = hVar;
        Log.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
        h.index = 0;
        hVar.stopped = false;
        hVar.oPZ = 1;
        if (hVar.oPY != null) {
            hVar.oQa.startTimer(0);
        }
    }

    public static void cgy() {
        if (oPu != null) {
            oPu.oPZ = 0;
            h hVar = oPu;
            if (!hVar.stopped) {
                Log.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
                hVar.oQa.stopTimer();
                hVar.stopped = true;
            }
        }
    }

    public static int cgz() {
        if (oPu == null) {
            return 0;
        }
        return oPu.oPZ;
    }

    public static void Bo(int i2) {
        if (oPu != null) {
            oPu.oPZ = i2;
        }
    }

    public static void clear() {
        Log.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
        synchronized (oPo) {
            oPo.clear();
        }
        synchronized (oPn) {
            oPn.clear();
        }
    }

    public static void a(c cVar) {
        oPw = cVar;
    }

    public static void cfK() {
        if (oPw != null) {
            oPw.cfK();
        }
    }

    public boolean cgA() {
        try {
            byte[] byteArray = cgr().toByteArray();
            synchronized (oPo) {
                int cgC = cgC();
                com.tencent.mm.plugin.backup.f.j.a(byteArray, cgC, (short) getType(), this.oPm, oIY);
                if (oPq != null) {
                    oPq.l(cgC, this.oPm.value);
                }
                Log.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(cgC), Integer.valueOf(getType()), Integer.valueOf(this.oPm.value.length));
                oPo.put(Integer.valueOf(cgC), this);
            }
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupBaseScene", e2, "req to buf fail: " + e2.toString(), new Object[0]);
            return false;
        }
    }

    public final boolean cgB() {
        try {
            byte[] byteArray = cgr().toByteArray();
            synchronized (oPo) {
                int cgC = cgC();
                com.tencent.mm.plugin.backup.f.j.a(byteArray, cgC, (short) getType(), this.oPm, oIY);
                if (oPq != null) {
                    oPq.m(cgC, this.oPm.value);
                }
                Log.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(cgC), Integer.valueOf(getType()), Integer.valueOf(this.oPm.value.length));
                oPo.put(Integer.valueOf(cgC), this);
            }
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupBaseScene", e2, "req to buf fail: " + e2.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean N(byte[] bArr, int i2) {
        PByteArray pByteArray = new PByteArray();
        synchronized (oPo) {
            int cgC = cgC();
            com.tencent.mm.plugin.backup.f.j.a(bArr, cgC, (short) i2, pByteArray, oIY);
            if (oPq != null) {
                oPq.l(cgC, pByteArray.value);
            }
            Log.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", Integer.valueOf(cgC), Integer.valueOf(i2), Integer.valueOf(pByteArray.value.length));
        }
        return true;
    }

    public static boolean D(byte[] bArr, int i2, int i3) {
        PByteArray pByteArray = new PByteArray();
        com.tencent.mm.plugin.backup.f.j.a(bArr, i3, (short) i2, pByteArray, oIY);
        if (oPq != null) {
            oPq.l(i3, pByteArray.value);
        }
        Log.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(pByteArray.value.length));
        return true;
    }

    public static void b(boolean z, int i2, int i3, byte[] bArr) {
        b remove;
        Object valueOf;
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        Log.i("MicroMsg.BackupBaseScene", "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]", objArr);
        if (z) {
            try {
                Log.w("MicroMsg.BackupBaseScene", "callback error buf content : " + (bArr == null ? BuildConfig.COMMAND : new String(bArr)));
            } catch (Exception e2) {
            }
            b(z, i3, bArr, i2);
            return;
        }
        if (oPr != null) {
            oPr.cgJ();
            Log.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", Integer.valueOf(i3), Long.valueOf(Util.nowMilliSecond()));
        }
        synchronized (oPo) {
            remove = oPo.remove(Integer.valueOf(i2));
        }
        if (remove == null) {
            Log.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", Integer.valueOf(i3));
            if (remove == null && i3 == 16) {
                synchronized (oPo) {
                    Iterator it = new HashSet(oPo.keySet()).iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        b bVar = oPo.get(num);
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = num;
                        objArr2[1] = bVar;
                        if (bVar == null) {
                            valueOf = BuildConfig.COMMAND;
                        } else {
                            valueOf = Integer.valueOf(bVar.getType());
                        }
                        objArr2[2] = valueOf;
                        Log.d("MicroMsg.BackupBaseScene", "callback sceneMap seq:%d scene:%s type:%s", objArr2);
                        if (bVar != null && bVar.getType() == 15) {
                            oPo.remove(num);
                            try {
                                bVar.cgq().parseFrom(bArr);
                                bVar.Bm(i2);
                            } catch (Exception e3) {
                                bVar.q(3, -1, "buf to tagResp fail");
                                Log.printErrStackTrace("MicroMsg.BackupBaseScene", e3, "buf to tagResp error, type[%d], errMsg:%s ", Integer.valueOf(bVar.getType()), e3.toString());
                            }
                        }
                    }
                }
                return;
            }
            Log.i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            b(z, i3, bArr, i2);
        } else if (bArr == null) {
            try {
                throw new Exception("buf is null");
            } catch (Exception e4) {
                remove.q(3, -1, "buf to resq fail");
                Log.printErrStackTrace("MicroMsg.BackupBaseScene", e4, "%s ", e4.toString());
            }
        } else {
            remove.cgq().parseFrom(bArr);
            remove.Bm(i2);
        }
    }

    public static int cgC() {
        int i2 = oPv;
        oPv++;
        return i2;
    }

    public final void a(int i2, PByteArray pByteArray) {
        this.oPm = new PByteArray();
        this.oPm.value = pByteArray.value;
        synchronized (oPo) {
            oPo.put(Integer.valueOf(i2), this);
        }
    }

    public static void Bp(int i2) {
        if (oPs != null) {
            j jVar = oPs;
            jVar.oQh = ((long) i2) + jVar.oQh;
        }
    }

    private static void b(final boolean z, final int i2, final byte[] bArr, final int i3) {
        handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.g.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(21697);
                if (b.oPp != null) {
                    b.oPp.a(z, i2, bArr, i3);
                    AppMethodBeat.o(21697);
                    return;
                }
                Log.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
                AppMethodBeat.o(21697);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void q(final int i2, final int i3, final String str) {
        handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.g.b.AnonymousClass2 */

            public final void run() {
                Set set;
                AppMethodBeat.i(21698);
                synchronized (b.oPn) {
                    try {
                        set = (Set) b.oPn.get(Integer.valueOf(b.this.getType()));
                    } finally {
                        AppMethodBeat.o(21698);
                    }
                }
                if (set != null && set.size() > 0) {
                    HashSet<i> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (i iVar : hashSet) {
                        if (iVar != null && set.contains(iVar)) {
                            iVar.onSceneEnd(i2, i3, str, b.this);
                        }
                    }
                }
            }
        });
    }

    public static void a(int i2, i iVar) {
        synchronized (oPn) {
            if (!oPn.containsKey(Integer.valueOf(i2))) {
                oPn.put(Integer.valueOf(i2), new HashSet());
            }
            if (!oPn.get(Integer.valueOf(i2)).contains(iVar)) {
                oPn.get(Integer.valueOf(i2)).add(iVar);
            }
        }
    }

    public static void b(int i2, i iVar) {
        synchronized (oPn) {
            try {
                if (oPn.get(Integer.valueOf(i2)) != null) {
                    oPn.get(Integer.valueOf(i2)).remove(iVar);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", e2);
            }
        }
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        return 0;
    }

    public static void a(final AbstractC0847b bVar) {
        handler.postAtFrontOfQueue(new Runnable() {
            /* class com.tencent.mm.plugin.backup.g.b.AnonymousClass3 */

            public final void run() {
                int i2;
                int i3 = 0;
                AppMethodBeat.i(21699);
                synchronized (b.oPo) {
                    try {
                        long nowMilliSecond = Util.nowMilliSecond();
                        for (Map.Entry entry : b.oPo.entrySet()) {
                            if (entry != null) {
                                try {
                                    PByteArray pByteArray = ((b) entry.getValue()).oPm;
                                    if (pByteArray == null) {
                                        Log.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", entry.getKey());
                                    } else if (b.oPq != null) {
                                        b.oPq.m(((Integer) entry.getKey()).intValue(), pByteArray.value);
                                        Log.i("MicroMsg.BackupBaseScene", "resendSceneMap sceneSeq[%d], type[%d], sceneBuf[%d]", entry.getKey(), Integer.valueOf(((b) entry.getValue()).getType()), Integer.valueOf(pByteArray.value.length));
                                    } else {
                                        Log.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", entry.getKey(), Integer.valueOf(((b) entry.getValue()).getType()), Integer.valueOf(pByteArray.value.length));
                                    }
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.BackupBaseScene", e2, "req to buf fail: " + e2.toString(), new Object[0]);
                                }
                                i2 = i3 + 1;
                            } else {
                                i2 = i3;
                            }
                            if (i2 > 0 && i2 % 5 == 0) {
                                bVar.jE(false);
                            }
                            i3 = i2;
                        }
                        bVar.jE(true);
                        Log.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", Integer.valueOf(b.oPo.size()), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
                    } finally {
                        AppMethodBeat.o(21699);
                    }
                }
            }
        });
    }
}
