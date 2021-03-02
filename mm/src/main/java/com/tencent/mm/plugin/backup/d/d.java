package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.d.e;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.j;
import com.tencent.mm.plugin.backup.i.a;
import com.tencent.mm.plugin.backup.i.e;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.i;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d {
    private static boolean oKK = false;
    private static boolean oMj = false;
    public byte[] bitmapData;
    public b.AbstractC0832b oJO = new b.AbstractC0832b() {
        /* class com.tencent.mm.plugin.backup.d.d.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.backup.b.b.AbstractC0832b
        public final void Ba(final int i2) {
            AppMethodBeat.i(21341);
            if (d.this.oKF != null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.backup.d.d.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(21340);
                        if (d.this.oKF != null) {
                            d.this.oKF.Ba(i2);
                        }
                        AppMethodBeat.o(21340);
                    }
                });
            }
            AppMethodBeat.o(21341);
        }

        @Override // com.tencent.mm.plugin.backup.b.b.AbstractC0832b
        public final void ceI() {
            AppMethodBeat.i(21342);
            b.cfv();
            b.ceR().edit().putStringSet("BACKUP_SELECT_SESSION_LIST", null);
            com.tencent.mm.plugin.backup.g.b.Bn(21);
            AppMethodBeat.o(21342);
        }

        @Override // com.tencent.mm.plugin.backup.b.b.AbstractC0832b
        public final void ceJ() {
            AppMethodBeat.i(21343);
            d.this.cancel(false);
            AppMethodBeat.o(21343);
        }
    };
    public b.d oKF;
    public boolean oLH = false;
    public b.c oLX = new b.c() {
        /* class com.tencent.mm.plugin.backup.d.d.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.backup.g.b.c
        public final void cfK() {
            AppMethodBeat.i(21344);
            Log.i("MicroMsg.BackupMoveServer", "stopCallback ");
            com.tencent.mm.plugin.backup.g.b.cgt();
            b.cfv().ceO();
            AppMethodBeat.o(21344);
        }
    };
    public final j.a oLY = new j.a() {
        /* class com.tencent.mm.plugin.backup.d.d.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.backup.g.j.a
        public final void cfI() {
            AppMethodBeat.i(21345);
            d.this.xI(b.cfv().ceM().oJc);
            AppMethodBeat.o(21345);
        }

        @Override // com.tencent.mm.plugin.backup.g.j.a
        public final void Bf(int i2) {
            AppMethodBeat.i(21346);
            int i3 = b.cfv().ceM().oJc;
            if (i2 == 1) {
                if (i3 == 14) {
                    Log.i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
                    b.cfv().ceM().oJc = 4;
                    d.this.xI(4);
                    AppMethodBeat.o(21346);
                    return;
                }
            } else if (i2 == 0 && i3 == 4) {
                Log.i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
                b.cfv().ceM().oJc = 14;
                d.this.xI(14);
            }
            AppMethodBeat.o(21346);
        }

        @Override // com.tencent.mm.plugin.backup.g.j.a
        public final void cfJ() {
            AppMethodBeat.i(21347);
            int i2 = b.cfv().ceM().oJc;
            Log.e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", Integer.valueOf(i2));
            if (i2 == 14 || i2 == 4) {
                d.this.cancel(true);
                b.cfv().cfw().stop();
                b.cfv().ceM().oJc = -4;
                d.this.xI(-4);
            }
            AppMethodBeat.o(21347);
        }
    };
    private LinkedList<String> oMc;
    private com.tencent.mm.plugin.backup.c.b oMd;
    public c oMe;
    private long oMf = 0;
    private long oMg = 0;
    public boolean oMh = false;
    public int oMi = 0;
    private int oMk;
    private int oMl;
    private int oMm = 0;
    public final b.d oMn = new b.d() {
        /* class com.tencent.mm.plugin.backup.d.d.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.backup.g.b.d
        public final void a(boolean z, int i2, byte[] bArr, int i3) {
            int size;
            AppMethodBeat.i(21339);
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify isLocal:%b type:%d seq:%d buf:%d", objArr);
            if (z && bArr != null && 10011 == i2) {
                int i4 = b.cfv().ceM().oJc;
                Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify local disconnect, backupMoveState:%d", Integer.valueOf(i4));
                switch (i4) {
                    case -23:
                    case -21:
                    case -5:
                        b.cfv().cfw().stop();
                        break;
                    case -4:
                        d.this.cancel(true);
                        break;
                    case 1:
                        b.cfv().cfw().stop();
                        b.cfv().ceM().oJc = -100;
                        d.this.xI(-100);
                        break;
                    case 12:
                    case 14:
                        d.this.cancel(true);
                        b.cfv().cfw().stop();
                        b.cfv().ceM().oJc = -4;
                        d.this.xI(-4);
                        h.INSTANCE.idkeyStat(485, 24, 1, false);
                        if (!(d.this.oMe == null || d.this.oMe.oJR == 0)) {
                            Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", Long.valueOf(d.this.oMe.cfe()), Long.valueOf(Util.milliSecondsToNow(d.this.oMe.oJR) / 1000));
                            break;
                        }
                }
            }
            if (i2 == 1) {
                v vVar = (v) g.a(new v(), bArr);
                if (vVar == null) {
                    Log.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", Integer.valueOf(Util.getLength(bArr)));
                    b.cfv().ceM().oJc = -5;
                    d.this.xI(-5);
                    AppMethodBeat.o(21339);
                    return;
                }
                if (Util.isNullOrNil(b.cfv().oIU)) {
                    b.cfv().oIU = vVar.ID;
                }
                if (!vVar.ID.equals(b.cfv().oIU)) {
                    Log.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", b.cfv().oIU, vVar.ID);
                    d.this.cancel(false);
                    b.cfv().ceM().oJc = -5;
                    d.this.xI(-5);
                    AppMethodBeat.o(21339);
                    return;
                }
                Log.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", vVar.ID, Integer.valueOf(vVar.oUu));
                if (vVar.oUu == 0) {
                    if (!b.cfv().oIV.equals(new String(l.d(vVar.oTm.zy, com.tencent.mm.plugin.backup.b.d.ceQ())))) {
                        d.Bg(i3);
                        b.cfv().ceM().oJc = -5;
                        d.this.xI(-5);
                    }
                    if (vVar.Version < com.tencent.mm.plugin.backup.b.c.oIM) {
                        Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify old move, version:%d", Integer.valueOf(vVar.Version));
                        h.INSTANCE.idkeyStat(485, 103, 1, false);
                        b.cfv().ceM().oJc = -12;
                        d.this.xI(-12);
                        AppMethodBeat.o(21339);
                        return;
                    }
                    Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify start move");
                    d.this.oMl = i3;
                    if (vVar.oUv == com.tencent.mm.plugin.backup.b.c.oIO) {
                        boolean cfL = d.cfL();
                        Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify client resume move! isResumeDataExist:%b", Boolean.valueOf(cfL));
                        if (cfL) {
                            b.cfv().cfx().oMi = com.tencent.mm.plugin.backup.b.c.oIO;
                            d.this.G(null);
                            d.this.jB(false);
                            AppMethodBeat.o(21339);
                            return;
                        }
                    }
                    b.cfv().cfx().oMi = com.tencent.mm.plugin.backup.b.c.oIN;
                    if (d.oMj || d.oKK) {
                        if (d.oMj && d.oKK && (vVar.oUw & com.tencent.mm.plugin.backup.b.c.oIR) == 0 && (vVar.oUw & com.tencent.mm.plugin.backup.b.c.oIS) == 0) {
                            b.cfv().ceM().oJc = -31;
                            d.this.xI(-31);
                            d.this.oMm = 1;
                            AppMethodBeat.o(21339);
                            return;
                        } else if (d.oMj && (vVar.oUw & com.tencent.mm.plugin.backup.b.c.oIR) == 0) {
                            b.cfv().ceM().oJc = -32;
                            d.this.xI(-32);
                            d.this.oMm = 2;
                            AppMethodBeat.o(21339);
                            return;
                        } else if (d.oKK && (vVar.oUw & com.tencent.mm.plugin.backup.b.c.oIS) == 0) {
                            b.cfv().ceM().oJc = -33;
                            d.this.xI(-33);
                            d.this.oMm = 3;
                            AppMethodBeat.o(21339);
                            return;
                        }
                    }
                    d.this.jB(false);
                    AppMethodBeat.o(21339);
                    return;
                }
                if (vVar.oUu == 1) {
                    if (!b.cfv().oIW.equals(new String(l.d(vVar.oTm.zy, com.tencent.mm.plugin.backup.b.d.ceQ())))) {
                        Log.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                        b.cfv().ceM().oJc = -5;
                        d.this.xI(-5);
                    }
                    Log.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
                    b.cfv().ceM().oJc = 2;
                    d.this.xI(2);
                }
                AppMethodBeat.o(21339);
            } else if (i2 == 3) {
                n nVar = (n) g.a(new n(), bArr);
                if (nVar == null) {
                    Log.e("MicroMsg.BackupMoveServer", "startReq parseBuf failed:%d", Integer.valueOf(Util.getLength(bArr)));
                } else if (nVar.oTR != null) {
                    String str = nVar.oTR.oTI;
                    Object[] objArr2 = new Object[1];
                    if (str == null) {
                        str = "";
                    }
                    objArr2[0] = str;
                    Log.i("MicroMsg.BackupMoveServer", "startReq new device is %s", objArr2);
                }
                d.this.oMk = i3;
                if (b.cfv().cfz().oLj) {
                    d.this.cfM();
                    AppMethodBeat.o(21339);
                    return;
                }
                d.this.oMh = true;
                AppMethodBeat.o(21339);
            } else if (i2 == 9) {
                e eVar = (e) g.a(new e(), bArr);
                if (eVar == null) {
                    Log.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", Integer.valueOf(Util.getLength(bArr)));
                    AppMethodBeat.o(21339);
                    return;
                }
                Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive heartbeatReq,req:%s ack:%d", eVar, Long.valueOf(eVar.oPN));
                f fVar = (f) g.a(new f(), bArr);
                fVar.oPN = eVar.oPN;
                try {
                    Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify send heartbeatResp");
                    com.tencent.mm.plugin.backup.g.b.D(fVar.toByteArray(), 10, i3);
                    AppMethodBeat.o(21339);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "onBackupMoveServerNotify buf to BackupHeartBeatResponse err.", new Object[0]);
                    AppMethodBeat.o(21339);
                }
            } else if (i2 == 10) {
                try {
                    new f().parseFrom(bArr);
                    AppMethodBeat.o(21339);
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.BackupMoveServer", e3, "onBackupMoveServerNotify heartbeatResp parse from buf error.", new Object[0]);
                    AppMethodBeat.o(21339);
                }
            } else if (i2 == 5) {
                Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify receive command cancel");
                d.this.cancel(true);
                b.cfv().ceM().oJc = -100;
                d.this.xI(-100);
                AppMethodBeat.o(21339);
            } else {
                if (i2 == 12) {
                    com.tencent.mm.plugin.backup.i.j jVar = (com.tencent.mm.plugin.backup.i.j) g.a(new com.tencent.mm.plugin.backup.i.j(), bArr);
                    if (jVar == null) {
                        Log.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", Integer.valueOf(Util.getLength(bArr)));
                        b.cfv().ceM().oJc = -5;
                        d.this.xI(-5);
                        AppMethodBeat.o(21339);
                        return;
                    }
                    LinkedList<f.a> b2 = g.b(jVar.oTB, jVar.oTC);
                    Object[] objArr3 = new Object[1];
                    if (b2 == null) {
                        size = -1;
                    } else {
                        size = b2.size();
                    }
                    objArr3[0] = Integer.valueOf(size);
                    Log.i("MicroMsg.BackupMoveServer", "onBackupMoveServerNotify backup receive requestsession response. backupSessionList:%d ", objArr3);
                    if (b2 == null) {
                        Log.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
                        d.cfF();
                        b.cfv().ceM().oJc = -21;
                        d.this.xI(-21);
                        AppMethodBeat.o(21339);
                        return;
                    }
                    com.tencent.mm.plugin.backup.g.b.cgs();
                    if (d.this.oMe == null || d.this.oMe.oJN) {
                        d.this.oMe = new c(b.cfv(), 2, d.this.oJO);
                    }
                    d.this.oMe.jy(false);
                    d.this.oMe.a(b2, b.cfv().ceM().oJk, d.oKK);
                }
                AppMethodBeat.o(21339);
            }
        }
    };
    public e oMo = new e(new e.a() {
        /* class com.tencent.mm.plugin.backup.d.d.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.backup.d.e.a
        public final void n(int i2, byte[] bArr) {
            AppMethodBeat.i(21348);
            if (bArr != null) {
                d.this.bitmapData = bArr;
            }
            d.this.xI(i2);
            AppMethodBeat.o(21348);
        }
    }, b.cfv().ceM());

    public d() {
        AppMethodBeat.i(21349);
        AppMethodBeat.o(21349);
    }

    public final void a(b.d dVar) {
        AppMethodBeat.i(21350);
        if (dVar.equals(this.oKF)) {
            this.oKF = null;
        }
        AppMethodBeat.o(21350);
    }

    public final void cancel(boolean z) {
        AppMethodBeat.i(21351);
        Log.e("MicroMsg.BackupMoveServer", "cancel BackupMoveServer CANCEL, Caller:%s", MMStack.getCaller());
        if (!z) {
            cfF();
        }
        if (this.oMe != null) {
            this.oMe.cancel();
        }
        if (this.oMd != null) {
            this.oMd.cancel();
            this.oMd = null;
        }
        Log.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
        com.tencent.mm.plugin.backup.g.b.cgt();
        com.tencent.mm.plugin.backup.g.b.cgv();
        b.cfv().ceO();
        AppMethodBeat.o(21351);
    }

    public static boolean cfL() {
        AppMethodBeat.i(231593);
        b.cfv();
        Set<String> stringSet = b.ceR().getStringSet("BACKUP_SELECT_SESSION_LIST", null);
        if (stringSet == null || stringSet.size() <= 0) {
            AppMethodBeat.o(231593);
            return false;
        }
        AppMethodBeat.o(231593);
        return true;
    }

    public final void G(LinkedList<String> linkedList) {
        AppMethodBeat.i(231594);
        this.oMc = new LinkedList<>();
        if (Util.isNullOrNil(linkedList)) {
            b.cfv();
            this.oMc.addAll(b.ceR().getStringSet("BACKUP_SELECT_SESSION_LIST", new HashSet()));
        } else {
            b.cfv();
            SharedPreferences.Editor edit = b.ceR().edit();
            HashSet hashSet = new HashSet();
            hashSet.addAll(linkedList);
            edit.putStringSet("BACKUP_SELECT_SESSION_LIST", hashSet);
            edit.commit();
            this.oMc.addAll(hashSet);
        }
        b.cfv();
        if (b.ceR().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
            oMj = true;
        } else {
            oMj = false;
        }
        b.cfv();
        this.oMf = b.ceR().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
        b.cfv();
        this.oMg = b.ceR().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        b.cfv();
        if (b.ceR().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
            oKK = true;
        } else {
            oKK = false;
        }
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Long.valueOf(this.oMf);
        objArr[2] = Long.valueOf(this.oMg);
        objArr[3] = Boolean.valueOf(oKK);
        Log.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", objArr);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.TRUE);
        AppMethodBeat.o(231594);
    }

    public static void e(int i2, long j2, long j3, int i3) {
        AppMethodBeat.i(21352);
        Log.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3));
        if (i2 == 0) {
            j3 = 0;
            j2 = 0;
        }
        b.cfv();
        SharedPreferences.Editor edit = b.ceR().edit();
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", i2);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", j2);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", j3);
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", i3);
        edit.commit();
        AppMethodBeat.o(21352);
    }

    public final void xI(int i2) {
        AppMethodBeat.i(21353);
        this.oJO.Ba(i2);
        AppMethodBeat.o(21353);
    }

    public final void jB(boolean z) {
        AppMethodBeat.i(21354);
        if (z) {
            switch (this.oMm) {
                case 1:
                    oMj = false;
                    oKK = false;
                    this.oMf = 0;
                    this.oMg = 0;
                    break;
                case 2:
                    oMj = false;
                    this.oMf = 0;
                    this.oMg = 0;
                    break;
                case 3:
                    oKK = false;
                    break;
            }
        }
        b.cfv().ceN();
        w wVar = new w();
        wVar.oUu = 0;
        wVar.ID = b.cfv().oIU;
        wVar.Version = com.tencent.mm.plugin.backup.b.c.oIM;
        wVar.oTW = 0;
        wVar.oUv = this.oMi;
        wVar.oTm = new com.tencent.mm.bw.b(l.e(b.cfv().oIW.getBytes(), com.tencent.mm.plugin.backup.b.d.ceQ()));
        if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
            wVar.oUw |= com.tencent.mm.plugin.backup.b.c.oIQ;
        }
        wVar.oUw |= com.tencent.mm.plugin.backup.b.c.oIR;
        wVar.oUw |= com.tencent.mm.plugin.backup.b.c.oIS;
        try {
            Log.i("MicroMsg.BackupMoveServer", "continueAuth send authSuccessResp.");
            com.tencent.mm.plugin.backup.g.b.D(wVar.toByteArray(), 2, this.oMl);
            AppMethodBeat.o(21354);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "continueAuth buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
            AppMethodBeat.o(21354);
        }
    }

    public final void cfM() {
        AppMethodBeat.i(21355);
        Log.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
        this.oMh = false;
        b.cfv().ceM().oJc = 12;
        xI(12);
        com.tencent.mm.plugin.backup.h.d.cgP().cgS();
        if (this.oMc == null) {
            AppMethodBeat.o(21355);
            return;
        }
        Log.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", Integer.valueOf(this.oMc.size()));
        o oVar = new o();
        oVar.ID = b.cfv().oIU;
        oVar.oTU = (long) this.oMc.size();
        oVar.oTV = b.cfv().cfz().cfu();
        oVar.oTW = 0;
        oVar.oTX = this.oLH ? com.tencent.mm.plugin.backup.b.c.oIL : com.tencent.mm.plugin.backup.b.c.oIK;
        if (oKK) {
            oVar.oTT = 3;
        }
        m mVar = new m();
        mVar.oTH = q.aoG();
        mVar.oTI = Build.MANUFACTURER;
        mVar.oTJ = Build.MODEL;
        mVar.oTK = "Android";
        mVar.oTL = Build.VERSION.RELEASE;
        mVar.oTM = com.tencent.mm.protocal.d.KyO;
        mVar.oTN = 0;
        Log.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", Integer.valueOf(com.tencent.mm.protocal.d.KyO));
        oVar.oTR = mVar;
        try {
            com.tencent.mm.plugin.backup.g.b.D(oVar.toByteArray(), 4, this.oMk);
            J(this.oMf, this.oMg);
            AppMethodBeat.o(21355);
        } catch (IOException e2) {
            Log.e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
            Log.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "", new Object[0]);
            AppMethodBeat.o(21355);
        }
    }

    private void J(long j2, long j3) {
        AppMethodBeat.i(21356);
        Log.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", Integer.valueOf(this.oMc.size()), Long.valueOf(j2), Long.valueOf(j3));
        i iVar = new i();
        iVar.oTB = this.oMc;
        iVar.oTC = new LinkedList<>();
        Iterator<String> it = this.oMc.iterator();
        while (it.hasNext()) {
            it.next();
            iVar.oTC.add(Long.valueOf(j2));
            iVar.oTC.add(Long.valueOf(j3));
        }
        try {
            Log.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", Integer.valueOf(this.oMc.size()));
            com.tencent.mm.plugin.backup.g.b.N(iVar.toByteArray(), 11);
            AppMethodBeat.o(21356);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
            AppMethodBeat.o(21356);
        }
    }

    public static void cfF() {
        AppMethodBeat.i(21357);
        a aVar = new a();
        aVar.ID = b.cfv().oIU;
        try {
            Log.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
            com.tencent.mm.plugin.backup.g.b.N(aVar.toByteArray(), 5);
            AppMethodBeat.o(21357);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "buf to BackupCancelRequest err.", new Object[0]);
            AppMethodBeat.o(21357);
        }
    }

    public static String cfN() {
        AppMethodBeat.i(21358);
        String cgw = com.tencent.mm.plugin.backup.g.b.cgw();
        AppMethodBeat.o(21358);
        return cgw;
    }

    static /* synthetic */ void Bg(int i2) {
        AppMethodBeat.i(21359);
        w wVar = new w();
        wVar.oUu = 0;
        wVar.ID = b.cfv().oIU;
        wVar.oTW = 1;
        Log.e("MicroMsg.BackupMoveServer", "get authReq step 0, but hello failed");
        try {
            Log.d("MicroMsg.BackupMoveServer", "sendFailAuthResponse send authFailResp.");
            com.tencent.mm.plugin.backup.g.b.D(wVar.toByteArray(), 2, i2);
            AppMethodBeat.o(21359);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "sendFailAuthResponse buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
            AppMethodBeat.o(21359);
        }
    }
}
