package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.plugin.backup.i.c;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.i;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.l;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class d implements b.d {
    private static boolean oLE = false;
    private static boolean oOv = false;
    private boolean ifz = false;
    private Object lock = new Object();
    private long oJj = 0;
    private boolean oKK = false;
    private HashSet<String> oLB = new HashSet<>();
    private long oLC = 0;
    private long oLD = 0;
    private com.tencent.mm.plugin.backup.c.d oLs;
    LinkedList<String> oLw;
    LinkedList<Long> oLx;
    private final b.d oOA = new b.d() {
        /* class com.tencent.mm.plugin.backup.backuppcmodel.d.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.backup.g.b.d
        public final void a(boolean z, final int i2, final byte[] bArr, final int i3) {
            AppMethodBeat.i(21580);
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]", objArr);
            if (z && 10011 == i2) {
                d.a(d.this);
                AppMethodBeat.o(21580);
            } else if (i2 == 5) {
                Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
                d.this.a(true, false, -100);
                h.INSTANCE.idkeyStat(400, 52, 1, false);
                d.this.Bk(5);
                AppMethodBeat.o(21580);
            } else {
                int i4 = b.cga().cgb().oOk;
                if (2 != i4 && 4 != i4) {
                    Log.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", Integer.valueOf(b.cga().cgb().oOk));
                    AppMethodBeat.o(21580);
                } else if (i2 == 10) {
                    f fVar = (f) g.a(new f(), bArr);
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Long.valueOf(fVar != null ? fVar.oPN : -1);
                    Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]", objArr2);
                    AppMethodBeat.o(21580);
                } else if (i2 == 18) {
                    c cVar = new c();
                    try {
                        cVar.parseFrom(bArr);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
                    }
                    Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", Integer.valueOf(cVar.oTl));
                    if (cVar.oTl == 9) {
                        int cgz = com.tencent.mm.plugin.backup.g.b.cgz();
                        if (cgz == 1) {
                            com.tencent.mm.plugin.backup.g.b.Bo(2);
                            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                            d.this.Bk(20);
                            com.tencent.mm.plugin.backup.g.b.cgy();
                            b.cga().ceM().oJc = 23;
                            d.this.Ba(23);
                            com.tencent.mm.plugin.backup.g.b.Bo(0);
                            AppMethodBeat.o(21580);
                            return;
                        }
                        Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", Integer.valueOf(cgz));
                    }
                    AppMethodBeat.o(21580);
                } else if (i2 == 17) {
                    com.tencent.mm.plugin.backup.i.b bVar = new com.tencent.mm.plugin.backup.i.b();
                    try {
                        bVar.parseFrom(bArr);
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e3, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
                    }
                    Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", Integer.valueOf(bVar.oTl));
                    if (bVar.oTl == 10) {
                        int i5 = b.cga().ceM().oJc;
                        Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", Integer.valueOf(i5));
                        if (i5 == 22 || i5 == 23) {
                            d.this.a(true, false, -4);
                            b.cga().cfw().stop();
                            h.INSTANCE.idkeyStat(400, 52, 1, false);
                            d.this.Bk(5);
                            long j2 = 0;
                            if (d.this.oLC != 0) {
                                j2 = Util.milliSecondsToNow(d.this.oLC);
                            }
                            h.INSTANCE.a(13737, 3, Long.valueOf(d.this.oJj), Long.valueOf(j2), 2);
                            Log.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", Long.valueOf(d.this.oJj), Long.valueOf(j2));
                        }
                    }
                    AppMethodBeat.o(21580);
                } else {
                    bg.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.backup.backuppcmodel.d.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(21579);
                            if (i2 == 3) {
                                d.a(d.this, bArr, i3);
                                AppMethodBeat.o(21579);
                            } else if (i2 == 11) {
                                d.b(d.this, bArr, i3);
                                AppMethodBeat.o(21579);
                            } else if (i2 == 6) {
                                d.c(d.this, bArr, i3);
                                AppMethodBeat.o(21579);
                            } else if (i2 == 13) {
                                d.M(bArr, i3);
                                AppMethodBeat.o(21579);
                            } else if (i2 == 15) {
                                d.d(d.this, bArr, i3);
                                AppMethodBeat.o(21579);
                            } else if (i2 == 8) {
                                d.a(d.this, bArr);
                                AppMethodBeat.o(21579);
                            } else {
                                AppMethodBeat.o(21579);
                            }
                        }
                    });
                    AppMethodBeat.o(21580);
                }
            }
        }
    };
    public Set<b.c> oOw = new HashSet();
    public b.a oOx;
    private long oOy = 0;
    private boolean oOz = false;
    private long recvSize = 0;

    public d() {
        AppMethodBeat.i(21584);
        AppMethodBeat.o(21584);
    }

    public static void cgj() {
        oOv = true;
    }

    public final void init() {
        AppMethodBeat.i(21585);
        Log.i("MicroMsg.BackupPcRecoverServer", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        this.oOz = false;
        oOv = false;
        oLE = false;
        com.tencent.mm.plugin.backup.g.b.a(this.oOA);
        this.oJj = 0;
        this.recvSize = 0;
        this.ifz = false;
        this.oKK = false;
        this.oLB.clear();
        AppMethodBeat.o(21585);
    }

    public static boolean cfA() {
        AppMethodBeat.i(21586);
        boolean gzD = bg.aVF().aTt().gzD();
        AppMethodBeat.o(21586);
        return gzD;
    }

    public final void cfB() {
        AppMethodBeat.i(21587);
        Log.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
        this.oLB.clear();
        if (!g.oJv) {
            g.agw(g.ceZ());
        }
        AppMethodBeat.o(21587);
    }

    public final void a(boolean z, boolean z2, int i2) {
        boolean z3 = false;
        AppMethodBeat.i(21588);
        Log.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", Boolean.valueOf(z), Boolean.valueOf(z2), MMStack.getCaller());
        oOv = true;
        if (!z) {
            b.cga().cgb();
            c.cfF();
        }
        synchronized (this.lock) {
            try {
                this.ifz = true;
                if (this.oLs == null || !this.oLs.oKz) {
                    z3 = true;
                } else {
                    this.oLs.x(z2, i2);
                }
                this.oLs = null;
            } catch (Throwable th) {
                AppMethodBeat.o(21588);
                throw th;
            }
        }
        if (z3 && i2 != 0) {
            b.cga().ceM().oJc = i2;
            Ba(i2);
        }
        if (z2) {
            cfB();
        }
        com.tencent.mm.plugin.backup.g.b.cgt();
        com.tencent.mm.plugin.backup.g.b.cgv();
        com.tencent.mm.plugin.backup.g.b.cgy();
        b.cga().ceO();
        AppMethodBeat.o(21588);
    }

    public final void Bk(int i2) {
        AppMethodBeat.i(21589);
        long j2 = 0;
        if (this.oLC != 0) {
            j2 = Util.milliSecondsToNow(this.oLC);
        }
        h.INSTANCE.a(13737, Integer.valueOf(i2), Long.valueOf(this.oJj / 1024), Long.valueOf(j2 / 1000), 2, Integer.valueOf(b.cga().cgb().oOq));
        Log.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", 13737, Integer.valueOf(i2), Long.valueOf(this.oJj / 1024), Long.valueOf(j2 / 1000));
        AppMethodBeat.o(21589);
    }

    private static void a(String str, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(21590);
        y yVar = new y();
        yVar.oUz = str;
        yVar.oUA = i2;
        yVar.oUC = i3;
        yVar.oUD = i4;
        yVar.oTW = i5;
        try {
            com.tencent.mm.plugin.backup.g.b.D(yVar.toByteArray(), 7, i6);
            AppMethodBeat.o(21590);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "sendResp", new Object[0]);
            AppMethodBeat.o(21590);
        }
    }

    private static void g(int i2, int i3, long j2) {
        AppMethodBeat.i(21591);
        o oVar = new o();
        oVar.ID = b.cga().oIU;
        oVar.oTW = i2;
        oVar.oTR = g.Bu(j2);
        try {
            Log.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", Integer.valueOf(i2));
            com.tencent.mm.plugin.backup.g.b.D(oVar.toByteArray(), 4, i3);
            AppMethodBeat.o(21591);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "buf to BackupStartRequest err.", new Object[0]);
            AppMethodBeat.o(21591);
        }
    }

    public final void cgk() {
        int i2;
        AppMethodBeat.i(21592);
        synchronized (this.lock) {
            try {
                if (this.oLs == null || !this.oLs.oKz) {
                    if (this.oLs != null) {
                        this.oLs.x(false, 0);
                    }
                    if (this.oLB == null || this.oLB.size() <= 0) {
                        i2 = bg.aVF().aTt().gzE();
                    } else {
                        i2 = this.oLB.size();
                    }
                    b.cga().ceM().S(26, 1, i2);
                    Ba(26);
                    if (this.oLw == null) {
                        this.oLw = new LinkedList<>();
                    }
                    if (this.oLx == null) {
                        this.oLx = new LinkedList<>();
                    }
                    com.tencent.mm.plugin.backup.h.d.cgP().cgS();
                    this.oLD = Util.nowMilliSecond();
                    com.tencent.mm.plugin.backup.h.d.cgP().cgS();
                    this.oLs = new com.tencent.mm.plugin.backup.c.d(b.cga(), 1, this, i2, this.oKK, this.oLw, this.oLx);
                    this.oLs.jz(false);
                    h.INSTANCE.idkeyStat(400, 24, 1, false);
                    AppMethodBeat.o(21592);
                    return;
                }
                Log.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
            } finally {
                AppMethodBeat.o(21592);
            }
        }
    }

    @Override // com.tencent.mm.plugin.backup.b.b.d
    public final void Ba(final int i2) {
        AppMethodBeat.i(21593);
        final HashSet hashSet = new HashSet();
        hashSet.addAll(this.oOw);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.backup.backuppcmodel.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(21582);
                for (b.c cVar : hashSet) {
                    cVar.Ba(i2);
                }
                AppMethodBeat.o(21582);
            }
        });
        if (this.oOx != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.backup.backuppcmodel.d.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(21583);
                    if (d.this.oOx != null) {
                        d.this.oOx.AZ(i2);
                    }
                    AppMethodBeat.o(21583);
                }
            });
        }
        AppMethodBeat.o(21593);
    }

    @Override // com.tencent.mm.plugin.backup.b.b.d
    public final void ceL() {
        AppMethodBeat.i(21594);
        cfB();
        h.INSTANCE.idkeyStat(400, 27, 1, false);
        h.INSTANCE.idkeyStat(400, 28, Util.milliSecondsToNow(this.oLD) / 1000, false);
        com.tencent.mm.plugin.backup.g.b.Bn(12);
        com.tencent.mm.plugin.backup.g.b.cgt();
        com.tencent.mm.plugin.backup.g.b.cgv();
        AppMethodBeat.o(21594);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(21595);
        int i2 = b.cga().ceM().oJc;
        Log.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify local disconnect, backupPcState[%d], isRecoverFinish[%b]", Integer.valueOf(i2), Boolean.valueOf(oOv));
        switch (i2) {
            case -21:
            case -13:
            case -5:
                b.cga().cfw().stop();
                AppMethodBeat.o(21595);
                return;
            case -4:
                dVar.a(true, false, 0);
                break;
            case 1:
            case 21:
                b.cga().cfw().stop();
                b.cga().ceM().oJc = -100;
                dVar.Ba(-100);
                AppMethodBeat.o(21595);
                return;
            case 4:
            case 22:
            case 23:
                if (!b.cga().cgb().oOo || oOv) {
                    Log.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify not support reconnect, disconnect");
                    dVar.a(true, false, -4);
                    b.cga().cfw().stop();
                    h.INSTANCE.idkeyStat(400, 17, 1, false);
                    dVar.Bk(3);
                    AppMethodBeat.o(21595);
                    return;
                }
                int cgz = com.tencent.mm.plugin.backup.g.b.cgz();
                switch (cgz) {
                    case 0:
                    case 2:
                        Log.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify startBackupReconnectHandler, reconnectState[%d]", Integer.valueOf(cgz));
                        dVar.Bk(19);
                        dVar.oOz = true;
                        com.tencent.mm.plugin.backup.g.b.a(b.cga().cgb().oOt);
                        AppMethodBeat.o(21595);
                        return;
                    case 1:
                        Log.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify already start reconnect, state[%d]", Integer.valueOf(cgz));
                        break;
                }
                AppMethodBeat.o(21595);
                return;
            case 27:
                b.cga().cfw().stop();
                b.cga().ceM().oJc = -100;
                dVar.Ba(-100);
                AppMethodBeat.o(21595);
                return;
        }
        AppMethodBeat.o(21595);
    }

    static /* synthetic */ void a(d dVar, byte[] bArr, int i2) {
        String str;
        double d2;
        AppMethodBeat.i(21596);
        n nVar = (n) g.a(new n(), bArr);
        if (nVar == null || !b.cga().oIU.equals(nVar.ID)) {
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(Util.getLength(bArr));
            if (nVar != null) {
                str = nVar.ID;
            } else {
                str = "buf is null";
            }
            objArr[1] = str;
            objArr[2] = b.cga().oIU;
            Log.e("MicroMsg.BackupPcRecoverServer", "startRequestNotify BackupStartRequest parseBuf:%d failed or wrong id[%s,%s]", objArr);
            g(1, i2, 0);
            dVar.a(false, false, -5);
            h.INSTANCE.idkeyStat(400, 121, 1, false);
            AppMethodBeat.o(21596);
            return;
        }
        b.cga().ceM().oJk = nVar.oTO;
        if (nVar.oTT == 3) {
            dVar.oKK = true;
            h.INSTANCE.idkeyStat(400, 36, 1, false);
            Log.i("MicroMsg.BackupPcRecoverServer", "isQuickBackup!!!");
        }
        long j2 = nVar.oTS;
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        bg.aVF();
        g.a(pLong, pLong2, com.tencent.mm.model.c.getAccPath());
        long j3 = pLong2.value;
        if (((double) j2) * 0.1d > 5.24288E8d) {
            d2 = 5.24288E8d;
        } else {
            d2 = ((double) j2) * 0.1d;
        }
        long j4 = (j3 - ((long) d2)) / 1048576;
        dVar.oLC = Util.nowMilliSecond();
        Log.i("MicroMsg.BackupPcRecoverServer", "startRequestNotify time:%d SessionCount:%d, MsgCount:%d, DataSize:%d validSize:%d", Long.valueOf(dVar.oLC), Long.valueOf(nVar.oTP), Long.valueOf(nVar.oTQ), Long.valueOf(j2), Long.valueOf(j4));
        if (j4 >= j2) {
            g(0, i2, j4);
            com.tencent.mm.plugin.backup.g.b.cgs();
            AppMethodBeat.o(21596);
            return;
        }
        Log.e("MicroMsg.BackupPcRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d", Long.valueOf(j4), Long.valueOf(j2));
        g(2, i2, j4);
        a cfw = b.cga().cfw();
        if (cfw.oJA == null) {
            cfw.stop();
        } else {
            cfw.oJA.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.backup.c.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(21213);
                    a.this.stop();
                    AppMethodBeat.o(21213);
                }
            }, 10);
        }
        b.cga().ceM().oJc = -13;
        dVar.Ba(-13);
        h.INSTANCE.idkeyStat(400, 6, 1, false);
        h.INSTANCE.a(13736, 5, 0, 0, 2, Integer.valueOf(b.cga().cgb().oOq));
        AppMethodBeat.o(21596);
    }

    static /* synthetic */ void b(d dVar, byte[] bArr, int i2) {
        AppMethodBeat.i(21597);
        i iVar = (i) g.a(new i(), bArr);
        if (iVar == null) {
            Log.e("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify parseBuf failed:%d", Integer.valueOf(Util.getLength(bArr)));
            b.cga().ceM().oJc = -21;
            dVar.Ba(-21);
            AppMethodBeat.o(21597);
            return;
        }
        dVar.oLw = iVar.oTB;
        dVar.oLx = iVar.oTC;
        if (dVar.oLx.size() != dVar.oLw.size() * 2) {
            dVar.a(false, false, -21);
            h.INSTANCE.idkeyStat(400, 119, 1, false);
            AppMethodBeat.o(21597);
            return;
        }
        b.cga().ceM().S(23, 1, dVar.oLw.size());
        dVar.Ba(23);
        LinkedList<String> linkedList = new LinkedList<>();
        LinkedList<Long> linkedList2 = new LinkedList<>();
        bg.aVF().aTs().a(dVar.oLw, dVar.oLx, linkedList, linkedList2);
        j jVar = new j();
        jVar.oTB = linkedList;
        jVar.oTC = linkedList2;
        com.tencent.mm.plugin.backup.g.b.cgu();
        try {
            Log.i("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify send requestsession resp, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(dVar.oLw.size()), Integer.valueOf(linkedList2.size()));
            com.tencent.mm.plugin.backup.g.b.D(jVar.toByteArray(), 12, i2);
            AppMethodBeat.o(21597);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "BackupRequestSessionResponse to buf err.", new Object[0]);
            AppMethodBeat.o(21597);
        }
    }

    static /* synthetic */ void c(d dVar, byte[] bArr, int i2) {
        AppMethodBeat.i(21598);
        x xVar = (x) g.a(new x(), bArr);
        if (xVar == null) {
            Log.e("MicroMsg.BackupPcRecoverServer", "dataPushNotify parseBuf failed:%d", Integer.valueOf(Util.getLength(bArr)));
            a("", 0, 0, 0, 1, i2);
            AppMethodBeat.o(21598);
            return;
        }
        Log.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive recoverData id:%s, type:%d, start:%d, end:%d, isCancel:%b", xVar.oUz, Integer.valueOf(xVar.oUA), Integer.valueOf(xVar.oUC), Integer.valueOf(xVar.oUD), Boolean.valueOf(dVar.ifz));
        if (!dVar.ifz) {
            if (!(b.cga().oJa == null || xVar.oTm == null)) {
                xVar.oTm = new com.tencent.mm.bw.b(AesEcb.aesCryptEcb(xVar.oTm.zy, b.cga().oJa, false, xVar.oUD == xVar.oUB));
            }
            if (xVar.oUA == 1 && xVar.oTm != null) {
                String agx = g.agx(xVar.oUz);
                Log.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive datapush text dataid:%s, dir:%s", xVar.oUz, agx);
                g.b(agx, xVar);
                dVar.recvSize += (long) xVar.oTm.zy.length;
            }
            if (xVar.oUA == 2) {
                String agy = g.agy(xVar.oUz);
                Log.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive datapush media dataid:%s, dir:%s", xVar.oUz, agy);
                g.a(agy, xVar);
                dVar.recvSize += (long) xVar.oTm.zy.length;
            }
            Log.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", Long.valueOf(dVar.recvSize), Long.valueOf(dVar.oJj));
            if (dVar.oJj < dVar.recvSize) {
                dVar.oJj = dVar.recvSize;
            }
            a(xVar.oUz, xVar.oUA, xVar.oUC, xVar.oUD, 0, i2);
        }
        AppMethodBeat.o(21598);
    }

    static /* synthetic */ void M(byte[] bArr, int i2) {
        AppMethodBeat.i(21599);
        af afVar = (af) g.a(new af(), bArr);
        if (afVar == null) {
            Log.e("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", Integer.valueOf(Util.getLength(bArr)));
            AppMethodBeat.o(21599);
            return;
        }
        ag agVar = new ag();
        agVar.oUR = afVar.oUR;
        agVar.oUT = afVar.oUT;
        agVar.oUS = afVar.oUS;
        agVar.oTx = afVar.oTx;
        try {
            Log.i("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify send SvrID resp");
            com.tencent.mm.plugin.backup.g.b.D(agVar.toByteArray(), 14, i2);
            AppMethodBeat.o(21599);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "PacketSvrIDResponse to buf err.", new Object[0]);
            AppMethodBeat.o(21599);
        }
    }

    static /* synthetic */ void d(d dVar, byte[] bArr, int i2) {
        int size;
        AppMethodBeat.i(21600);
        z zVar = (z) g.a(new z(), bArr);
        if (zVar == null) {
            Log.e("MicroMsg.BackupPcRecoverServer", "SendTagNotify PacketBackupDataTag parse failed:%d", Integer.valueOf(Util.getLength(bArr)));
            AppMethodBeat.o(21600);
            return;
        }
        Log.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify receive tagReq, MsgDataID:%s, BakChatName:%s, StartTime:%d, EndTime:%d,  NickName:%s, isCancel:%b", zVar.oUI, zVar.oTx, Long.valueOf(zVar.oUG), Long.valueOf(zVar.oUH), zVar.oUJ, Boolean.valueOf(dVar.ifz));
        dVar.oLB.add(zVar.oTx);
        if (!dVar.ifz) {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.TRUE);
            e ceM = b.cga().ceM();
            e ceM2 = b.cga().ceM();
            int i3 = ceM.oJc;
            if (dVar.oLB.size() < dVar.oLw.size()) {
                size = dVar.oLB.size();
            } else {
                size = dVar.oLw.size();
            }
            ceM2.S(i3, size, dVar.oLw.size());
            dVar.Ba(ceM.oJc);
            if (bg.aVF().aTt().biE(zVar.oUI) != null) {
                Log.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify the same tag has received, ignore. MsgDataID:%s", zVar.oUI);
            } else {
                l lVar = new l();
                lVar.field_msgListDataId = zVar.oUI;
                lVar.field_sessionName = zVar.oTx;
                Log.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify insert BackupRecoverMsgListDataIdStorage ret[%b], systemRowid[%d]", Boolean.valueOf(bg.aVF().aTt().insert(lVar)), Long.valueOf(lVar.systemRowid));
                com.tencent.mm.storage.n nVar = new com.tencent.mm.storage.n();
                nVar.field_sessionName = zVar.oTx;
                nVar.field_startTime = zVar.oUG;
                nVar.field_endTime = zVar.oUH;
                Log.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify insert BackupTempMoveTimeStorage ret[%b], systemRowid[%d]", Boolean.valueOf(bg.aVF().aTs().insert(nVar)), Long.valueOf(nVar.systemRowid));
            }
            aa aaVar = new aa();
            aaVar.oTx = zVar.oTx;
            aaVar.oUG = zVar.oUG;
            aaVar.oUH = zVar.oUH;
            aaVar.oUI = zVar.oUI;
            try {
                Log.i("MicroMsg.BackupPcRecoverServer", "tagReqNotify send tag resp");
                com.tencent.mm.plugin.backup.g.b.D(aaVar.toByteArray(), 16, i2);
                AppMethodBeat.o(21600);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "tagReqNotify buf to PacketBackupDataTagResponse err.", new Object[0]);
                AppMethodBeat.o(21600);
            }
        } else {
            AppMethodBeat.o(21600);
        }
    }

    static /* synthetic */ void a(d dVar, byte[] bArr) {
        AppMethodBeat.i(21601);
        Log.i("MicroMsg.BackupPcRecoverServer", "finishReqNotify receive finishReq. hasReceiveFinishReq[%b]", Boolean.valueOf(oLE));
        if (oLE) {
            Log.e("MicroMsg.BackupPcRecoverServer", "finishReqNotify has receive finishReq, return.");
            AppMethodBeat.o(21601);
            return;
        }
        oLE = true;
        if (g.a(new com.tencent.mm.plugin.backup.i.d(), bArr) == null) {
            Log.e("MicroMsg.BackupPcRecoverServer", "finishReqNotify buf to BackupFinishRequest error, buflen[%d]", Integer.valueOf(Util.getLength(bArr)));
        }
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.FALSE);
        com.tencent.mm.plugin.backup.g.b.cgt();
        com.tencent.mm.plugin.backup.g.b.cgv();
        oOv = true;
        b.cga().ceM().S(24, dVar.oLB.size(), dVar.oLw.size());
        dVar.Ba(24);
        h.INSTANCE.idkeyStat(400, 19, 1, false);
        dVar.oOy = Util.nowMilliSecond();
        long j2 = dVar.oOy - dVar.oLC;
        h.INSTANCE.idkeyStat(400, 20, j2 / 1000, false);
        h.INSTANCE.idkeyStat(400, 21, dVar.oJj / 1024, false);
        dVar.Bk(0);
        if (!dVar.oOz) {
            dVar.Bk(21);
        }
        Log.i("MicroMsg.BackupPcRecoverServer", "finishReqNotify recover success. hasEnterReconnect[%b], recoverCostTime[%d s], recoverStartTime[%d], recoverEndTime[%d], recoverTotalSize[%d kb]", Boolean.valueOf(dVar.oOz), Long.valueOf(j2 / 1000), Long.valueOf(dVar.oLC), Long.valueOf(dVar.oOy), Long.valueOf(dVar.oJj / 1024));
        AppMethodBeat.o(21601);
    }
}
