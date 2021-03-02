package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class e {
    private static boolean oKK = false;
    private static boolean oMj = false;
    static boolean oOE = false;
    private b.AbstractC0832b oJO = new b.AbstractC0832b() {
        /* class com.tencent.mm.plugin.backup.backuppcmodel.e.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.backup.b.b.AbstractC0832b
        public final void Ba(final int i2) {
            AppMethodBeat.i(21609);
            final HashSet hashSet = new HashSet();
            hashSet.addAll(e.this.oOw);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.backup.backuppcmodel.e.AnonymousClass5.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(21607);
                    for (b.c cVar : hashSet) {
                        cVar.Ba(i2);
                    }
                    AppMethodBeat.o(21607);
                }
            });
            if (e.this.oOx != null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.backup.backuppcmodel.e.AnonymousClass5.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(21608);
                        if (e.this.oOx != null) {
                            e.this.oOx.AZ(i2);
                        }
                        AppMethodBeat.o(21608);
                    }
                });
            }
            AppMethodBeat.o(21609);
        }

        @Override // com.tencent.mm.plugin.backup.b.b.AbstractC0832b
        public final void ceI() {
            AppMethodBeat.i(21610);
            h.INSTANCE.idkeyStat(400, 11, 1, false);
            h.INSTANCE.idkeyStat(400, 12, e.this.oMe == null ? 0 : Util.milliSecondsToNow(e.this.oMe.oJR) / 1000, false);
            h.INSTANCE.idkeyStat(400, 13, e.this.oMe == null ? 0 : e.this.oMe.cfe(), false);
            e.this.Bk(0);
            com.tencent.mm.plugin.backup.g.b.Bn(11);
            if (!e.this.oOz) {
                e.this.Bk(21);
            }
            AppMethodBeat.o(21610);
        }

        @Override // com.tencent.mm.plugin.backup.b.b.AbstractC0832b
        public final void ceJ() {
            AppMethodBeat.i(21611);
            Log.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", Boolean.FALSE);
            e.this.cancel(false);
            h.INSTANCE.idkeyStat(400, 120, 1, false);
            AppMethodBeat.o(21611);
        }
    };
    final i oLU = new i() {
        /* class com.tencent.mm.plugin.backup.backuppcmodel.e.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(21602);
            com.tencent.mm.plugin.backup.g.b.b(3, e.this.oLU);
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", str);
                o oVar = ((k) qVar).oQp;
                if (!b.cga().oIU.equals(oVar.ID)) {
                    Log.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
                    h.INSTANCE.idkeyStat(400, 118, 1, false);
                    b.cga().ceM().oJc = -5;
                    e.this.xI(-5);
                    AppMethodBeat.o(21602);
                    return;
                }
                b.cga().ceM().oJk = oVar.oTO;
                Log.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", Long.valueOf(oVar.oTO));
                bg.aVF();
                c.azQ().set(ar.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE);
                com.tencent.mm.plugin.backup.g.b.cgs();
                e.a(e.this);
                AppMethodBeat.o(21602);
                return;
            }
            Log.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
            h.INSTANCE.idkeyStat(400, 117, 1, false);
            b.cga().ceM().oJc = -5;
            e.this.xI(-5);
            AppMethodBeat.o(21602);
        }
    };
    LinkedList<String> oMc;
    private com.tencent.mm.plugin.backup.c.b oMd;
    com.tencent.mm.plugin.backup.c.c oMe;
    private long oMf = 0;
    private long oMg = 0;
    public boolean oOF = false;
    public boolean oOG = false;
    final i oOH = new i() {
        /* class com.tencent.mm.plugin.backup.backuppcmodel.e.AnonymousClass2 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(21603);
            com.tencent.mm.plugin.backup.g.b.b(11, e.this.oOH);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.backup.g.i iVar = (com.tencent.mm.plugin.backup.g.i) qVar;
                LinkedList<f.a> b2 = g.b(iVar.oQd.oTB, iVar.oQd.oTC);
                Log.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", Integer.valueOf(b2.size()));
                com.tencent.mm.plugin.backup.c.c cVar = e.this.oMe;
                b.cga().cgb();
                cVar.a(b2, b.cga().ceM().oJk, e.oKK);
                AppMethodBeat.o(21603);
                return;
            }
            Log.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
            h.INSTANCE.idkeyStat(400, 119, 1, false);
            e.this.cancel(false);
            b.cga().ceM().oJc = -5;
            e.this.xI(-5);
            AppMethodBeat.o(21603);
        }
    };
    private final b.d oOI = new b.d() {
        /* class com.tencent.mm.plugin.backup.backuppcmodel.e.AnonymousClass3 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.backup.g.b.d
        public final void a(boolean z, int i2, byte[] bArr, int i3) {
            AppMethodBeat.i(21605);
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            objArr[4] = Boolean.valueOf(e.oOE);
            Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]", objArr);
            if (!z || bArr == null) {
                if (1 == b.cga().cgb().oOk || 3 == b.cga().cgb().oOk) {
                    if (i2 == 10) {
                        com.tencent.mm.plugin.backup.i.f fVar = new com.tencent.mm.plugin.backup.i.f();
                        try {
                            fVar.parseFrom(bArr);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.BackupPcServer", e2, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
                        }
                        Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", Long.valueOf(fVar.oPN));
                        AppMethodBeat.o(21605);
                        return;
                    } else if (i2 == 5) {
                        Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
                        e.this.cancel(true);
                        b.cga().ceM().oJc = -100;
                        e.this.xI(-100);
                        h.INSTANCE.idkeyStat(400, 51, 1, false);
                        e.this.Bk(5);
                        AppMethodBeat.o(21605);
                        return;
                    } else if (i2 == 18) {
                        com.tencent.mm.plugin.backup.i.c cVar = new com.tencent.mm.plugin.backup.i.c();
                        try {
                            cVar.parseFrom(bArr);
                        } catch (Exception e3) {
                            Log.printErrStackTrace("MicroMsg.BackupPcServer", e3, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
                        }
                        Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", Integer.valueOf(cVar.oTl));
                        if (cVar.oTl == 9) {
                            int cgz = com.tencent.mm.plugin.backup.g.b.cgz();
                            if (cgz == 1) {
                                com.tencent.mm.plugin.backup.g.b.Bo(2);
                                Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                                e.this.Bk(20);
                                com.tencent.mm.plugin.backup.g.b.cgy();
                                b.cga().ceM().oJc = 14;
                                e.this.xI(14);
                                com.tencent.mm.plugin.backup.g.b.a(new b.AbstractC0847b() {
                                    /* class com.tencent.mm.plugin.backup.backuppcmodel.e.AnonymousClass3.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.backup.g.b.AbstractC0847b
                                    public final void jE(boolean z) {
                                        AppMethodBeat.i(21604);
                                        if (z) {
                                            Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
                                            com.tencent.mm.plugin.backup.g.b.Bo(0);
                                            AppMethodBeat.o(21604);
                                            return;
                                        }
                                        e.this.xI(b.cga().ceM().oJc);
                                        AppMethodBeat.o(21604);
                                    }
                                });
                                AppMethodBeat.o(21605);
                                return;
                            }
                            Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", Integer.valueOf(cgz));
                        }
                        AppMethodBeat.o(21605);
                        return;
                    } else if (i2 == 17) {
                        com.tencent.mm.plugin.backup.i.b bVar = new com.tencent.mm.plugin.backup.i.b();
                        try {
                            bVar.parseFrom(bArr);
                        } catch (Exception e4) {
                            Log.printErrStackTrace("MicroMsg.BackupPcServer", e4, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
                        }
                        Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", Integer.valueOf(bVar.oTl));
                        if (bVar.oTl == 10) {
                            int i4 = b.cga().ceM().oJc;
                            Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", Integer.valueOf(i4));
                            if (i4 == 12 || i4 == 14) {
                                e.this.cancel(true);
                                b.cga().cfw().stop();
                                b.cga().ceM().oJc = -4;
                                e.this.xI(-4);
                                h.INSTANCE.idkeyStat(400, 51, 1, false);
                                e.this.Bk(5);
                                long j2 = 0;
                                if (e.this.oMe.oJR != 0) {
                                    j2 = Util.milliSecondsToNow(e.this.oMe.oJR);
                                }
                                h.INSTANCE.a(13737, 3, Long.valueOf(e.this.oMe.cfe()), Long.valueOf(j2 / 1000), 1);
                                Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", Long.valueOf(e.this.oMe.cfe()), Long.valueOf(j2 / 1000));
                            }
                        }
                    }
                }
                AppMethodBeat.o(21605);
                return;
            }
            if (10011 == i2) {
                int i5 = b.cga().ceM().oJc;
                Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", Integer.valueOf(i5));
                switch (i5) {
                    case -21:
                    case -5:
                        b.cga().cfw().stop();
                        AppMethodBeat.o(21605);
                        return;
                    case -4:
                        e.this.cancel(true);
                        break;
                    case 1:
                    case 11:
                        b.cga().cfw().stop();
                        b.cga().ceM().oJc = -100;
                        e.this.xI(-100);
                        AppMethodBeat.o(21605);
                        return;
                    case 4:
                    case 12:
                    case 14:
                        if (!b.cga().cgb().oOo || e.oOE) {
                            Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
                            e.this.cancel(true);
                            b.cga().cfw().stop();
                            b.cga().ceM().oJc = -4;
                            e.this.xI(-4);
                            h.INSTANCE.idkeyStat(400, 9, 1, false);
                            e.this.Bk(3);
                            AppMethodBeat.o(21605);
                            return;
                        }
                        int cgz2 = com.tencent.mm.plugin.backup.g.b.cgz();
                        switch (cgz2) {
                            case 0:
                            case 2:
                                Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", Integer.valueOf(cgz2));
                                e.this.Bk(19);
                                e.this.oOz = true;
                                com.tencent.mm.plugin.backup.g.b.a(b.cga().cgb().oOt);
                                AppMethodBeat.o(21605);
                                return;
                            case 1:
                                Log.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", Integer.valueOf(cgz2));
                                break;
                        }
                        AppMethodBeat.o(21605);
                        return;
                    case 15:
                        b.cga().cfw().stop();
                        b.cga().ceM().oJc = -100;
                        e.this.xI(-100);
                        AppMethodBeat.o(21605);
                        return;
                }
            }
            AppMethodBeat.o(21605);
        }
    };
    public Set<b.c> oOw = new HashSet();
    public b.a oOx;
    private boolean oOz = false;

    public e() {
        AppMethodBeat.i(21612);
        AppMethodBeat.o(21612);
    }

    public static void cgl() {
        oOE = true;
    }

    public final void init() {
        AppMethodBeat.i(21613);
        Log.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
        oOE = false;
        this.oOz = false;
        com.tencent.mm.plugin.backup.g.b.a(this.oOI);
        this.oMe = new com.tencent.mm.plugin.backup.c.c(b.cga(), 1, this.oJO);
        AppMethodBeat.o(21613);
    }

    public final void cancel(boolean z) {
        AppMethodBeat.i(21614);
        Log.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", Boolean.valueOf(z), MMStack.getCaller());
        oOE = true;
        if (!z) {
            b.cga().cgb();
            c.cfF();
        }
        this.oMe.cancel();
        if (this.oMd != null) {
            this.oMd.cancel();
            this.oMd = null;
        }
        com.tencent.mm.plugin.backup.g.b.cgt();
        com.tencent.mm.plugin.backup.g.b.cgv();
        com.tencent.mm.plugin.backup.g.b.cgy();
        b.cga().ceO();
        AppMethodBeat.o(21614);
    }

    public final void G(LinkedList<String> linkedList) {
        AppMethodBeat.i(21615);
        this.oMc = linkedList;
        b.cga();
        if (b.ceR().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
            oMj = true;
        } else {
            oMj = false;
        }
        b.cga();
        this.oMf = b.ceR().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
        b.cga();
        this.oMg = b.ceR().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        b.cga();
        if (b.ceR().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
            oKK = true;
        } else {
            oKK = false;
        }
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Boolean.valueOf(oMj);
        objArr[2] = Boolean.valueOf(oKK);
        objArr[3] = Long.valueOf(this.oMf);
        objArr[4] = Long.valueOf(this.oMg);
        Log.i("MicroMsg.BackupPcServer", "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]", objArr);
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.TRUE);
        if (1 == b.cga().cgb().oOk) {
            b.cga();
            SharedPreferences.Editor edit = b.ceR().edit();
            edit.putString("BACKUP_PC_CHOOSE_SESSION", g.b("", ",", linkedList == null ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()])));
            edit.commit();
        }
        AppMethodBeat.o(21615);
    }

    public static void f(int i2, long j2, long j3, int i3) {
        AppMethodBeat.i(21616);
        Log.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3));
        if (i2 == 0) {
            j3 = 0;
            j2 = 0;
        }
        b.cga();
        SharedPreferences.Editor edit = b.ceR().edit();
        if (1 == b.cga().cgb().oOk) {
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", i2);
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", i3);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", j2);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", j3);
        }
        edit.commit();
        AppMethodBeat.o(21616);
    }

    public final void Bv(long j2) {
        int i2 = 3;
        AppMethodBeat.i(21617);
        Log.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
        com.tencent.mm.plugin.backup.g.b.a(3, this.oLU);
        k kVar = new k(b.cga().oIU);
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        bg.aVF();
        g.a(pLong, pLong2, c.getAccPath());
        if (!oKK) {
            bg.aVF();
            if (((Boolean) c.azQ().get(ar.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
        }
        kVar.a(j2, g.Bu(pLong2.value), i2);
        Log.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", Long.valueOf(j2), Integer.valueOf(i2));
        kVar.cgA();
        AppMethodBeat.o(21617);
    }

    public final void Bk(int i2) {
        long j2;
        long j3;
        long j4 = 0;
        AppMethodBeat.i(21618);
        if (this.oMe != null) {
            if (this.oMe.oJR != 0) {
                j4 = Util.milliSecondsToNow(this.oMe.oJR);
            }
            j2 = this.oMe.cfe();
            j3 = j4;
        } else {
            j2 = 0;
            j3 = 0;
        }
        h.INSTANCE.a(13737, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3 / 1000), 1, Integer.valueOf(b.cga().cgb().oOq));
        Log.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", 13737, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3 / 1000));
        AppMethodBeat.o(21618);
    }

    public final void ceK() {
        AppMethodBeat.i(21619);
        final HashSet hashSet = new HashSet();
        hashSet.addAll(this.oOw);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.backup.backuppcmodel.e.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(21606);
                for (b.c cVar : hashSet) {
                    cVar.ceK();
                }
                AppMethodBeat.o(21606);
            }
        });
        AppMethodBeat.o(21619);
    }

    public final void xI(int i2) {
        AppMethodBeat.i(21620);
        this.oJO.Ba(i2);
        AppMethodBeat.o(21620);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(21621);
        com.tencent.mm.plugin.backup.g.b.a(11, eVar.oOH);
        com.tencent.mm.plugin.backup.g.i iVar = new com.tencent.mm.plugin.backup.g.i(eVar.oMc, eVar.oMf, eVar.oMg);
        Log.i("MicroMsg.BackupPcServer", "backupPcSendRequestSession, chooseConvNames size[%d]", Integer.valueOf(eVar.oMc.size()));
        iVar.cgA();
        AppMethodBeat.o(21621);
    }
}
