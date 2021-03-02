package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.backup.g.j;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.aa;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.plugin.backup.i.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c implements b.d, b.d {
    private static boolean aMp = false;
    private static int ibG = 0;
    private static boolean oLE = false;
    String dGL;
    private boolean ifz = false;
    private Object lock = new Object();
    private long oJj = 0;
    private long oJl = 0;
    private long oJm = -1;
    public b.d oKF;
    private boolean oKK = false;
    public b.a oLA;
    private HashSet<String> oLB = new HashSet<>();
    private long oLC = 0;
    private long oLD = 0;
    private boolean oLF = true;
    private int oLG = 0;
    public boolean oLH = false;
    private boolean oLI = true;
    private boolean oLJ = true;
    private boolean oLK = false;
    private boolean oLL = false;
    private int oLM = 0;
    private int oLN;
    public String oLO;
    String oLP;
    int oLQ;
    private MTimerHandler oLR;
    final i oLS = new i() {
        /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(21300);
            bg.azz().b(595, c.this.oLS);
            d.Bb(22);
            b.cfv().ceM().oJc = 1;
            Intent className = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
            className.addFlags(335544320);
            className.putExtra("nofification_type", "backup_move_notification");
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(className);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/backup/backupmovemodel/BackupMoveRecoverServer$1", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            h.INSTANCE.idkeyStat(485, 41, 1, false);
            blq cgI = ((e) qVar).cgI();
            if (i2 == 0 && i3 == 0) {
                bg.aVF();
                if (!Util.nullAsNil((String) com.tencent.mm.model.c.azQ().get(2, (Object) null)).equals(cgI.KMF)) {
                    Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
                    b.cfv().ceM().oJc = -5;
                    c.this.Ba(-14);
                    AppMethodBeat.o(21300);
                    return;
                }
                b.cfv().oIU = cgI.ID;
                b.cfv().oIV = cgI.KML;
                b.cfv().oIW = cgI.KMM;
                com.tencent.mm.plugin.backup.g.b.a(c.this.oLX);
                b.cfv().ceN();
                com.tencent.mm.plugin.backup.g.b.a(b.cfv().cfy());
                com.tencent.mm.plugin.backup.g.b.a(b.cfv().cfw());
                com.tencent.mm.plugin.backup.g.b.Bb(2);
                com.tencent.mm.plugin.backup.g.b.a(c.this.oLY);
                String str2 = null;
                int i4 = 0;
                if (cgI.KMC > 0) {
                    adi first = cgI.KMD.getFirst();
                    str2 = first.LjZ;
                    i4 = first.Low.getFirst().intValue();
                } else {
                    Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd address convMsgCount is empty");
                }
                c cVar = c.this;
                cVar.oLO = cgI.KMG;
                cVar.oLP = str2;
                cVar.oLQ = i4;
                Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", Integer.valueOf(cgI.oUv), Integer.valueOf(cgI.Scene), cgI.KMG, str2, Integer.valueOf(i4));
                boolean unused = c.aMp = false;
                Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", str2, cgI.KMG, g.eE(MMApplicationContext.getContext()));
                int unused2 = c.ibG = 2;
                c.a(c.this, str2, i4);
                AppMethodBeat.o(21300);
                return;
            }
            Log.i("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info other error [%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (i2 == 4 && i3 == -2011) {
                Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnect info: INVALID URL");
            }
            bg.aVF();
            if (!Util.nullAsNil((String) com.tencent.mm.model.c.azQ().get(2, (Object) null)).equals(cgI.KMF)) {
                Log.e("MicroMsg.BackupMoveRecoverServer", "onGetConnectInfoEnd getConnectinfo not the same account");
                b.cfv().ceM().oJc = -14;
                c.this.Ba(-14);
                AppMethodBeat.o(21300);
                return;
            }
            b.cfv().ceM().oJc = -5;
            c.this.Ba(-5);
            AppMethodBeat.o(21300);
        }
    };
    private final i oLT = new i() {
        /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass6 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            boolean z;
            AppMethodBeat.i(21307);
            boolean unused = c.aMp = true;
            h.INSTANCE.idkeyStat(485, 42, 1, false);
            h.INSTANCE.a(11787, 0);
            com.tencent.mm.plugin.backup.g.b.b(1, c.this.oLT);
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
                com.tencent.mm.plugin.backup.g.a aVar = (com.tencent.mm.plugin.backup.g.a) qVar;
                if (aVar.oPi.Version < com.tencent.mm.plugin.backup.b.c.oIM) {
                    Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", Integer.valueOf(aVar.oPi.Version));
                    h.INSTANCE.idkeyStat(485, 104, 1, false);
                    b.cfv().ceM().oJc = -12;
                    c.this.Ba(-12);
                    AppMethodBeat.o(21307);
                    return;
                }
                int i4 = aVar.oPi.oUv;
                c cVar = c.this;
                if ((aVar.oPi.oUw & com.tencent.mm.plugin.backup.b.c.oIQ) == 0) {
                    z = false;
                } else {
                    z = true;
                }
                cVar.oLI = z;
                Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", Integer.valueOf(aVar.oPi.Version), Integer.valueOf(i4), Boolean.valueOf(c.this.oLI));
                if (i4 != com.tencent.mm.plugin.backup.b.c.oIO) {
                    if (c.cfA()) {
                        c.this.oLM = 3;
                    } else {
                        c.this.oLM = 1;
                    }
                    c.this.cfB();
                    c.this.oLK = false;
                    Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
                } else if (c.cfA()) {
                    c.this.oLK = true;
                    Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
                    c.this.oLM = 4;
                } else {
                    c.this.cfB();
                    c.this.oLK = false;
                    Log.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
                    c.this.oLM = 2;
                }
                c.g(c.this);
                com.tencent.mm.plugin.backup.g.b.a(3, c.this.oLU);
                k kVar = new k(b.cfv().oIU);
                kVar.a(0, g.Bu(0), 0);
                kVar.cgA();
                b.cfv().ceM().oJc = 22;
                c.this.Ba(22);
                AppMethodBeat.o(21307);
                return;
            }
            Log.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
            b.cfv().ceM().oJc = -5;
            c.this.Ba(-5);
            c.this.Be(3);
            AppMethodBeat.o(21307);
        }
    };
    private final i oLU = new i() {
        /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass7 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            boolean z;
            double d2;
            int i4;
            AppMethodBeat.i(21308);
            com.tencent.mm.plugin.backup.g.b.b(3, c.this.oLU);
            Log.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (i2 == 0 && i3 == 0) {
                k kVar = (k) qVar;
                o oVar = kVar.oQp;
                if (!b.cfv().oIU.equals(oVar.ID)) {
                    Log.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
                    b.cfv().ceM().oJc = -5;
                    c.this.Ba(-5);
                    AppMethodBeat.o(21308);
                    return;
                }
                b.cfv().ceM().oJk = oVar.oTO;
                c.this.dGL = kVar.oQp.oTR.oTH;
                if (kVar.oQp.oTR.oTK.toLowerCase().contains("ios")) {
                    c.this.oLN = 1;
                } else {
                    c.this.oLN = 2;
                }
                c.this.oJj = kVar.oQp.oTV;
                c.this.oLG = kVar.oQp.oTX;
                Log.i("MicroMsg.BackupMoveRecoverServer", "move recover backupMoveDevice[%d], totalCount[%d], totalSize[%d kb], and wait old mobile's pushData", Integer.valueOf(c.this.oLN), Long.valueOf(kVar.oQp.oTU), Long.valueOf(kVar.oQp.oTV / 1024));
                if (c.this.oLJ && c.this.oLI) {
                    h hVar = h.INSTANCE;
                    if (c.this.oLH || c.this.oLG == 1) {
                        i4 = 66;
                    } else {
                        i4 = 65;
                    }
                    hVar.idkeyStat(485, (long) i4, 1, false);
                }
                if (kVar.oQp.oTT == 3) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    c.this.oKK = true;
                    Log.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
                } else {
                    c.this.oKK = false;
                }
                PLong pLong = new PLong();
                PLong pLong2 = new PLong();
                bg.aVF();
                g.a(pLong, pLong2, com.tencent.mm.model.c.getAccPath());
                long j2 = c.this.oJj;
                if (((double) c.this.oJj) * 0.1d > 5.24288E8d) {
                    d2 = 5.24288E8d;
                } else {
                    d2 = ((double) c.this.oJj) * 0.1d;
                }
                long j3 = ((long) d2) + j2;
                c.this.oLV = j3;
                if (pLong2.value < j3) {
                    Log.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", Long.valueOf(pLong2.value), Long.valueOf(j3), Long.valueOf(c.this.oJj));
                    h.INSTANCE.a(11787, 5);
                    b.cfv().cfw().stop();
                    b.cfv().ceM().oJc = -13;
                    c.this.Ba(-13);
                    h.INSTANCE.idkeyStat(485, 5, 1, false);
                    AppMethodBeat.o(21308);
                    return;
                }
                c.this.oLC = Util.nowMilliSecond();
                com.tencent.mm.plugin.backup.g.b.cgs();
                AppMethodBeat.o(21308);
                return;
            }
            Log.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:".concat(String.valueOf(str)));
            b.cfv().ceM().oJc = -5;
            c.this.Ba(-5);
            AppMethodBeat.o(21308);
        }
    };
    public long oLV;
    private int oLW;
    b.c oLX = new b.c() {
        /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass12 */

        @Override // com.tencent.mm.plugin.backup.g.b.c
        public final void cfK() {
            AppMethodBeat.i(21313);
            Log.i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
            com.tencent.mm.plugin.backup.g.b.cgt();
            b.cfv().ceO();
            AppMethodBeat.o(21313);
        }
    };
    private final j.a oLY = new j.a() {
        /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.backup.g.j.a
        public final void cfI() {
            AppMethodBeat.i(21301);
            c.this.Ba(b.cfv().ceM().oJc);
            AppMethodBeat.o(21301);
        }

        @Override // com.tencent.mm.plugin.backup.g.j.a
        public final void Bf(int i2) {
            AppMethodBeat.i(21302);
            int i3 = b.cfv().ceM().oJc;
            if (i2 == 1) {
                if (i3 == 23) {
                    Log.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
                    b.cfv().ceM().oJc = 4;
                    c.this.Ba(4);
                    c.this.Be(8);
                    AppMethodBeat.o(21302);
                    return;
                }
            } else if (i2 == 0 && i3 == 4) {
                Log.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
                b.cfv().ceM().oJc = 23;
                c.this.Ba(23);
                c.this.Be(9);
            }
            AppMethodBeat.o(21302);
        }

        @Override // com.tencent.mm.plugin.backup.g.j.a
        public final void cfJ() {
            AppMethodBeat.i(21303);
            int i2 = b.cfv().ceM().oJc;
            Log.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", Integer.valueOf(i2));
            if (i2 == 23 || i2 == 4) {
                c.this.a(true, false, -4);
                h.INSTANCE.idkeyStat(485, 43, 1, false);
                c.this.Be(4);
                b.cfv().cfw().stop();
            }
            AppMethodBeat.o(21303);
        }
    };
    private com.tencent.mm.plugin.backup.c.d oLs;
    private long oLt = 0;
    private long oLu = 0;
    private long oLv = 0;
    private LinkedList<String> oLw = new LinkedList<>();
    private LinkedList<Long> oLx;
    private LinkedList<String> oLy;
    private LinkedList<Long> oLz;
    private long recvSize = 0;

    public c() {
        AppMethodBeat.i(21315);
        AppMethodBeat.o(21315);
    }

    static /* synthetic */ void a(c cVar, String str, int i2) {
        AppMethodBeat.i(21331);
        cVar.cw(str, i2);
        AppMethodBeat.o(21331);
    }

    static /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(21332);
        cVar.cfC();
        AppMethodBeat.o(21332);
    }

    public static boolean cfA() {
        AppMethodBeat.i(21316);
        boolean gzD = bg.aVF().aTt().gzD();
        AppMethodBeat.o(21316);
        return gzD;
    }

    public final void cfB() {
        AppMethodBeat.i(21317);
        Log.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
        this.oLB.clear();
        if (!g.oJv) {
            g.agw(g.ceZ());
            g.ceX();
        }
        AppMethodBeat.o(21317);
    }

    public final void a(boolean z, boolean z2, int i2) {
        boolean z3 = false;
        AppMethodBeat.i(21318);
        Log.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), MMStack.getCaller());
        if (!z) {
            cfF();
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
                AppMethodBeat.o(21318);
                throw th;
            }
        }
        if (z3 && i2 != 0) {
            b.cfv().ceM().oJc = i2;
            Ba(i2);
        }
        if (z2) {
            cfB();
        }
        com.tencent.mm.plugin.backup.g.b.cgt();
        com.tencent.mm.plugin.backup.g.b.cgv();
        b.cfv().ceO();
        b.cfv().cfw().oJB = null;
        AppMethodBeat.o(21318);
    }

    private void cw(String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(21319);
        b.cfv().cfw().connect(str, i2);
        com.tencent.mm.plugin.backup.g.b.a(1, this.oLT);
        try {
            if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
                z = false;
            }
            this.oLJ = z;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e2, "getInt", new Object[0]);
        }
        com.tencent.mm.plugin.backup.g.a aVar = new com.tencent.mm.plugin.backup.g.a(b.cfv().oIV, b.cfv().oIW, d.ceQ(), b.cfv().oIU, com.tencent.mm.plugin.backup.b.c.oIM, 22, cfA());
        aVar.A(this.oLJ, false);
        aVar.cgA();
        Log.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
        if (this.oLR == null) {
            this.oLR = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass5 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(21306);
                    if (!c.aMp) {
                        Log.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
                        if (c.this.oLR != null) {
                            c.this.oLR.stopTimer();
                        }
                        c.d(c.this);
                    }
                    AppMethodBeat.o(21306);
                    return true;
                }
            }, false);
        }
        this.oLR.startTimer(3000);
        AppMethodBeat.o(21319);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.backup.g.b.d
    public final void a(boolean z, final int i2, final byte[] bArr, final int i3) {
        AppMethodBeat.i(21321);
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        Log.i("MicroMsg.BackupMoveRecoverServer", "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d", objArr);
        if (z && 10011 == i2) {
            int i4 = b.cfv().ceM().oJc;
            Log.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify local disconnect, backupMoveState:%d", Integer.valueOf(i4));
            switch (i4) {
                case -21:
                case -13:
                case -5:
                    b.cfv().cfw().stop();
                    AppMethodBeat.o(21321);
                    return;
                case -4:
                    a(true, false, 0);
                    break;
                case 1:
                    b.cfv().cfw().stop();
                    if (!aMp) {
                        if (this.oLR != null) {
                            Log.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
                            this.oLR.stopTimer();
                        }
                        cfC();
                        AppMethodBeat.o(21321);
                        return;
                    }
                    b.cfv().ceM().oJc = -4;
                    Ba(-4);
                    AppMethodBeat.o(21321);
                    return;
                case 22:
                case 23:
                    a(true, false, -4);
                    b.cfv().cfw().stop();
                    h.INSTANCE.idkeyStat(485, 43, 1, false);
                    Be(4);
                    long j2 = 0;
                    if (this.oLC != 0) {
                        j2 = Util.milliSecondsToNow(this.oLC);
                    }
                    Log.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recvSize:%d, recoverCostTime:%d", Long.valueOf(this.oJj), Long.valueOf(this.recvSize), Long.valueOf(j2));
                    AppMethodBeat.o(21321);
                    return;
            }
            AppMethodBeat.o(21321);
        } else if (i2 == 9) {
            com.tencent.mm.plugin.backup.i.e eVar = (com.tencent.mm.plugin.backup.i.e) g.a(new com.tencent.mm.plugin.backup.i.e(), bArr);
            if (eVar == null) {
                Log.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", Integer.valueOf(Util.getLength(bArr)));
                AppMethodBeat.o(21321);
                return;
            }
            Log.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat req, req:%s ack:%d", eVar, Long.valueOf(eVar.oPN));
            f fVar = new f();
            fVar.oPN = eVar.oPN;
            try {
                Log.d("MicroMsg.BackupMoveRecoverServer", "onNotify send heartbeat resp");
                com.tencent.mm.plugin.backup.g.b.D(fVar.toByteArray(), 10, i3);
                AppMethodBeat.o(21321);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e2, "onNotify buf to BackupHeartBeatResponse err.", new Object[0]);
                AppMethodBeat.o(21321);
            }
        } else if (i2 == 10) {
            f fVar2 = (f) g.a(new f(), bArr);
            Object[] objArr2 = new Object[2];
            objArr2[0] = fVar2;
            objArr2[1] = Long.valueOf(fVar2 != null ? fVar2.oPN : -1);
            Log.i("MicroMsg.BackupMoveRecoverServer", "onNotify receive heartbeat response, resp:%s ack:%d", objArr2);
            AppMethodBeat.o(21321);
        } else {
            if (i2 == 5) {
                h.INSTANCE.idkeyStat(485, 51, 1, false);
                a(true, false, -100);
            }
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(21309);
                    if (i2 == 11) {
                        c.a(c.this, bArr, i3);
                        AppMethodBeat.o(21309);
                    } else if (i2 == 6) {
                        c.b(c.this, bArr, i3);
                        AppMethodBeat.o(21309);
                    } else if (i2 == 13) {
                        c.L(bArr, i3);
                        AppMethodBeat.o(21309);
                    } else if (i2 == 15) {
                        c.c(c.this, bArr, i3);
                        AppMethodBeat.o(21309);
                    } else if (i2 == 8) {
                        c.a(c.this, bArr);
                        AppMethodBeat.o(21309);
                    } else {
                        AppMethodBeat.o(21309);
                    }
                }
            });
            AppMethodBeat.o(21321);
        }
    }

    public final void jA(boolean z) {
        AppMethodBeat.i(21322);
        this.oLL = z;
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        b.cfv().cfw().oJB = new a.AbstractC0841a() {
            /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.backup.c.a.AbstractC0841a
            public final void b(int i2, int i3, byte[] bArr) {
                AppMethodBeat.i(21310);
                while (!c.this.ifz) {
                    try {
                        if (linkedBlockingQueue.offer(new a(i2, i3, bArr), 500, TimeUnit.MILLISECONDS)) {
                            break;
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse onBackupMoveRecoverDatapushCallback e:%s", e2.getMessage());
                    }
                }
                Log.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", Integer.valueOf(linkedBlockingQueue.size()));
                AppMethodBeat.o(21310);
            }
        };
        com.tencent.f.h.RTc.ba(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass10 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "startSendRequestSessionResponse.onNotifyWorker";
            }

            public final void run() {
                a aVar;
                AppMethodBeat.i(21311);
                while (!c.this.ifz && !c.oLE) {
                    try {
                        aVar = (a) linkedBlockingQueue.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e2) {
                        aVar = null;
                    }
                    Log.d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", Integer.valueOf(linkedBlockingQueue.size()), aVar);
                    if (aVar != null) {
                        c.this.a(aVar.dLQ, aVar.type, aVar.buf, aVar.jlm);
                    }
                }
                AppMethodBeat.o(21311);
            }
        });
        if (!this.oKK && !z) {
            LinkedList<String> linkedList = this.oLy;
            LinkedList<Long> linkedList2 = this.oLz;
            this.oLy = new LinkedList<>();
            this.oLz = new LinkedList<>();
            bg.aVF().aTr().a(this.dGL, linkedList, linkedList2, this.oLy, this.oLz);
        }
        com.tencent.mm.plugin.backup.i.j jVar = new com.tencent.mm.plugin.backup.i.j();
        jVar.oTB = this.oLy;
        jVar.oTC = this.oLz;
        try {
            Log.i("MicroMsg.BackupMoveRecoverServer", "send requestsession resp, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(jVar.oTB.size()), Integer.valueOf(jVar.oTC.size()));
            com.tencent.mm.plugin.backup.g.b.D(jVar.toByteArray(), 12, this.oLW);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e2, "buf to BackupRequestSessionResponse err.", new Object[0]);
        }
        com.tencent.mm.plugin.backup.g.b.cgu();
        if (this.oLK) {
            b.cfv().ceM().S(23, 1, this.oLw.size());
            this.oJj = b.cfv().ceM().oJj;
            this.recvSize = b.cfv().ceM().oJg;
            this.oLu = b.cfv().ceM().oJh;
            this.oLv = b.cfv().ceM().oJi;
            this.oJl = b.cfv().ceM().oJl;
            this.oJm = b.cfv().ceM().oJm;
        } else {
            b.cfv().ceM().a(23, 1, this.oLw.size(), 0, this.oJj, 0, 0);
            this.oJl = s.boW(com.tencent.mm.kernel.g.aAh().azO());
            b.cfv().ceM().oJl = this.oJl;
        }
        com.tencent.mm.plugin.backup.h.d.cgP().cgS();
        this.oJm = -1;
        com.tencent.f.h.RTc.ba(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass11 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "getMsgCount";
            }

            public final void run() {
                AppMethodBeat.i(21312);
                c.this.oJm = (long) com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().eiP();
                b.cfv().ceM().oJm = c.this.oJm;
                AppMethodBeat.o(21312);
            }
        });
        Ba(23);
        AppMethodBeat.o(21322);
    }

    private static void a(String str, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(21323);
        y yVar = new y();
        yVar.oUz = str;
        yVar.oUA = i2;
        yVar.oUC = i3;
        yVar.oUD = i4;
        yVar.oTW = i5;
        try {
            com.tencent.mm.plugin.backup.g.b.D(yVar.toByteArray(), 7, i6);
            AppMethodBeat.o(21323);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e2, "sendResp", new Object[0]);
            AppMethodBeat.o(21323);
        }
    }

    public final void Be(int i2) {
        AppMethodBeat.i(21324);
        long j2 = 0;
        if (this.oLC != 0) {
            j2 = Util.milliSecondsToNow(this.oLC);
        }
        h.INSTANCE.a(11789, 0, 0, 0, 0, 0, Integer.valueOf(i2), Integer.valueOf(this.oLN), Long.valueOf(this.recvSize / 1024), Long.valueOf(j2 / 1000), Long.valueOf(this.oJl / 1024), Integer.valueOf(this.oLM));
        Log.i("MicroMsg.BackupMoveRecoverServer", "backupMoveRecoverKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recvSize[%d KB], recoverCostTime[%d s], originDbSize[%d kb]", 11789, Integer.valueOf(i2), Long.valueOf(this.oJj / 1024), Long.valueOf(this.recvSize / 1024), Long.valueOf(j2 / 1000), Long.valueOf(this.oJl / 1024));
        AppMethodBeat.o(21324);
    }

    public final void cfD() {
        AppMethodBeat.i(21325);
        a(true, false, 28);
        b.cfv().cfw().stop();
        AppMethodBeat.o(21325);
    }

    public final void jz(boolean z) {
        int i2;
        AppMethodBeat.i(21326);
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
                    b.cfv().ceM().oJc = 26;
                    b.cfv().ceM().oJf = 0;
                    Ba(26);
                    com.tencent.mm.plugin.backup.h.d.cgP().cgS();
                    this.oLD = Util.nowMilliSecond();
                    this.oLs = new com.tencent.mm.plugin.backup.c.d(b.cfv(), 2, this, i2, false, new LinkedList(), new LinkedList());
                    this.oLs.jz(z);
                    h.INSTANCE.idkeyStat(485, 46, 1, false);
                    AppMethodBeat.o(21326);
                    return;
                }
                Log.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
            } finally {
                AppMethodBeat.o(21326);
            }
        }
    }

    public static String cfE() {
        AppMethodBeat.i(21327);
        String cgw = com.tencent.mm.plugin.backup.g.b.cgw();
        AppMethodBeat.o(21327);
        return cgw;
    }

    private static void cfF() {
        AppMethodBeat.i(21328);
        com.tencent.mm.plugin.backup.i.a aVar = new com.tencent.mm.plugin.backup.i.a();
        aVar.ID = b.cfv().oIU;
        try {
            Log.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
            com.tencent.mm.plugin.backup.g.b.N(aVar.toByteArray(), 5);
            AppMethodBeat.o(21328);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e2, "buf to BackupCancelRequest err.", new Object[0]);
            AppMethodBeat.o(21328);
        }
    }

    @Override // com.tencent.mm.plugin.backup.b.b.d
    public final void Ba(final int i2) {
        AppMethodBeat.i(21329);
        if (this.oKF != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(21304);
                    if (c.this.oKF != null) {
                        c.this.oKF.Ba(i2);
                    }
                    AppMethodBeat.o(21304);
                }
            });
        }
        if (this.oLA != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.backup.d.c.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(21305);
                    if (c.this.oLA != null) {
                        c.this.oLA.AZ(i2);
                    }
                    AppMethodBeat.o(21305);
                }
            });
        }
        AppMethodBeat.o(21329);
    }

    @Override // com.tencent.mm.plugin.backup.b.b.d
    public final void ceL() {
        AppMethodBeat.i(21330);
        long milliSecondsToNow = Util.milliSecondsToNow(this.oLD) / 1000;
        long j2 = b.cfv().ceM().oJn;
        h.INSTANCE.idkeyStat(485, 49, 1, false);
        h.INSTANCE.idkeyStat(485, 50, milliSecondsToNow, false);
        h.INSTANCE.idkeyStat(485, 72, j2, false);
        h.INSTANCE.idkeyStat(485, 52, this.recvSize / 1024, false);
        this.oLt = s.boW(com.tencent.mm.kernel.g.aAh().azO());
        h.INSTANCE.a(17868, 1, Long.valueOf(milliSecondsToNow), Long.valueOf(this.recvSize / 1024), Long.valueOf(this.oLu / 1024), Long.valueOf(this.oLv / 1024), Long.valueOf(this.oJl / 1024), Long.valueOf(this.oLt / 1024), Long.valueOf(this.oJm), Long.valueOf(j2));
        Log.i("MicroMsg.BackupMoveRecoverServer", "backupMoveMerge, errcode[%d], mergeTime[%d s], recvSize[%d KB], recvTextSize[%d KB], recvMediaSize[%d KB], originDbSize[%d kb], finishMergeDbSize[%d kb], originMsgCount[%d], mergeMsgCount[%d]", 1, Long.valueOf(milliSecondsToNow), Long.valueOf(this.recvSize / 1024), Long.valueOf(this.oLu / 1024), Long.valueOf(this.oLv / 1024), Long.valueOf(this.oJl / 1024), Long.valueOf(this.oLt / 1024), Long.valueOf(this.oJm), Long.valueOf(j2));
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.TRUE);
        Log.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS. mergeTime:%d, totalMsgCount:%d", Long.valueOf(milliSecondsToNow), Long.valueOf(j2));
        if (g.oJv) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            StringBuilder sb = new StringBuilder("\nMerge Info:\n");
            sb.append("mergeStartTime:").append(simpleDateFormat.format(new Date(this.oLD))).append("\n");
            sb.append("mergeTime:").append(milliSecondsToNow).append("\n");
            sb.append("totalMsgCount:").append(j2).append("\n");
            sb.append("recvSize:").append(this.recvSize / 1024).append(" kB\n");
            g.a(g.cfb(), "backupTestInfo.txt", sb.toString().getBytes());
        }
        if (!this.oKK) {
            LinkedList<n> gzF = bg.aVF().aTs().gzF();
            if (gzF.size() <= 0) {
                Log.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
            } else {
                Log.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
                bg.aVF().aTr().i(this.dGL, gzF);
            }
        }
        cfB();
        com.tencent.mm.plugin.backup.g.b.Bn(22);
        com.tencent.mm.plugin.backup.g.b.cgt();
        com.tencent.mm.plugin.backup.g.b.cgv();
        AppMethodBeat.o(21330);
    }

    class a {
        byte[] buf;
        boolean dLQ = false;
        int jlm;
        int type;

        a(int i2, int i3, byte[] bArr) {
            AppMethodBeat.i(21314);
            this.jlm = i2;
            this.type = i3;
            this.buf = (byte[]) bArr.clone();
            AppMethodBeat.o(21314);
        }
    }

    private void cfC() {
        AppMethodBeat.i(21320);
        String str = this.oLO;
        String str2 = this.oLP;
        String eE = g.eE(MMApplicationContext.getContext());
        Log.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", eE, str, str2, Integer.valueOf(ibG));
        if (eE == null || eE.equals("")) {
            h.INSTANCE.idkeyStat(485, 1, 1, false);
            h.INSTANCE.a(11787, 1);
            b.cfv().ceM().oJc = -1;
            Ba(-1);
            AppMethodBeat.o(21320);
        } else if (str == null || !str.equals(eE)) {
            h.INSTANCE.idkeyStat(485, 2, 1, false);
            h.INSTANCE.a(11787, 2);
            b.cfv().ceM().oJc = -2;
            Ba(-2);
            AppMethodBeat.o(21320);
        } else if (!g.agA(str2)) {
            h.INSTANCE.idkeyStat(485, 3, 1, false);
            h.INSTANCE.a(11787, 3);
            b.cfv().ceM().oJc = -3;
            Ba(-3);
            AppMethodBeat.o(21320);
        } else if (ibG <= 0) {
            b.cfv().ceM().oJc = -5;
            Ba(-5);
            h.INSTANCE.idkeyStat(485, 4, 1, false);
            h.INSTANCE.a(11787, 6);
            AppMethodBeat.o(21320);
        } else {
            ibG--;
            cw(this.oLP, this.oLQ);
            AppMethodBeat.o(21320);
        }
    }

    static /* synthetic */ void g(c cVar) {
        AppMethodBeat.i(231588);
        Log.i("MicroMsg.BackupMoveRecoverServer", "move recover init");
        oLE = false;
        cVar.oJl = 0;
        cVar.oJm = 0;
        cVar.oJj = 0;
        cVar.recvSize = 0;
        cVar.oLu = 0;
        cVar.oLv = 0;
        cVar.ifz = false;
        cVar.oLB.clear();
        cVar.oLF = true;
        AppMethodBeat.o(231588);
    }

    static /* synthetic */ void a(c cVar, byte[] bArr, int i2) {
        long count;
        AppMethodBeat.i(21335);
        if (b.cfv().ceM().oJc == -13) {
            Log.e("MicroMsg.BackupMoveRecoverServer", "requestSessionNotify receive requestSession request, but no enough space for recover, quit.");
            AppMethodBeat.o(21335);
            return;
        }
        com.tencent.mm.plugin.backup.i.i iVar = (com.tencent.mm.plugin.backup.i.i) g.a(new com.tencent.mm.plugin.backup.i.i(), bArr);
        if (iVar == null) {
            Log.e("MicroMsg.BackupMoveRecoverServer", "requestSessionNotify parseBuf failed:%d", Integer.valueOf(Util.getLength(bArr)));
            b.cfv().ceM().oJc = -21;
            cVar.Ba(-21);
            AppMethodBeat.o(21335);
            return;
        }
        Log.i("MicroMsg.BackupMoveRecoverServer", "requestSessionNotify receive requestSession request, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(iVar.oTB.size()), Integer.valueOf(iVar.oTC.size()));
        cVar.oLw = iVar.oTB;
        cVar.oLx = iVar.oTC;
        if (cVar.oLx.size() != cVar.oLw.size() * 2) {
            cfF();
            b.cfv().ceM().oJc = -21;
            cVar.Ba(-21);
            AppMethodBeat.o(21335);
            return;
        }
        cVar.oLW = i2;
        cVar.oLy = new LinkedList<>();
        cVar.oLz = new LinkedList<>();
        if (!cVar.oLK) {
            g.ceY();
            cVar.oLy.addAll(cVar.oLw);
            cVar.oLz.addAll(cVar.oLx);
            com.tencent.mm.storage.k aTr = bg.aVF().aTr();
            String str = cVar.dGL;
            String str2 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\"";
            Log.d("MicroMsg.BackupMoveTimeStorage", "getCountByDevice:".concat(String.valueOf(str2)));
            Cursor rawQuery = aTr.db.rawQuery(str2, null);
            if (rawQuery == null) {
                Log.e("MicroMsg.BackupMoveTimeStorage", "getCountByDevice failed, deviceid:%s", str);
                count = 0;
            } else {
                count = (long) rawQuery.getCount();
                rawQuery.close();
            }
            if (count > 0) {
                b.cfv().ceM().oJc = 52;
                cVar.Ba(52);
                AppMethodBeat.o(21335);
                return;
            }
            cVar.jA(true);
        } else {
            bg.aVF().aTs().a(cVar.oLw, cVar.oLx, cVar.oLy, cVar.oLz);
            cVar.jA(cVar.oLL);
        }
        cVar.Be(10);
        AppMethodBeat.o(21335);
    }

    static /* synthetic */ void b(c cVar, byte[] bArr, int i2) {
        boolean z;
        AppMethodBeat.i(231589);
        if (cVar.oLF) {
            cVar.oLF = false;
        }
        x xVar = (x) g.a(new x(), bArr);
        if (xVar == null) {
            Log.e("MicroMsg.BackupMoveRecoverServer", "dataPushNotify parseBuf failed:%d", Integer.valueOf(Util.getLength(bArr)));
            a("", 0, 0, 0, 1, i2);
            AppMethodBeat.o(231589);
            return;
        }
        Log.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recoverData id:%s, type:%d, start:%d, end:%d", xVar.oUz, Integer.valueOf(xVar.oUA), Integer.valueOf(xVar.oUC), Integer.valueOf(xVar.oUD));
        if (xVar.oUA == 1 && xVar.oTm != null) {
            String agx = g.agx(xVar.oUz);
            Log.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify text dataid:%s, dir:%s", xVar.oUz, agx);
            g.b(agx, xVar);
            cVar.recvSize += (long) xVar.oTm.zy.length;
            cVar.oLu += (long) xVar.oTm.zy.length;
        }
        if (xVar.oUA == 2) {
            String agy = g.agy(xVar.oUz);
            Log.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify datapush media dataid:%s, dir:%s", xVar.oUz, agy);
            g.a(agy, xVar);
            cVar.recvSize += (long) xVar.oTm.zy.length;
            cVar.oLv += (long) xVar.oTm.zy.length;
        }
        Log.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", Long.valueOf(cVar.recvSize), Long.valueOf(cVar.oJj));
        if (cVar.oJj < cVar.recvSize) {
            cVar.oJj = cVar.recvSize;
        }
        a(xVar.oUz, xVar.oUA, xVar.oUC, xVar.oUD, 0, i2);
        com.tencent.mm.plugin.backup.b.e ceM = b.cfv().ceM();
        long j2 = cVar.recvSize;
        long j3 = cVar.oLu;
        long j4 = cVar.oLv;
        double d2 = 0.0d;
        if (ceM.oJj != 0) {
            d2 = (double) (((j2 - ceM.oJg) * 100) / ceM.oJj);
        }
        ceM.oJg = j2;
        ceM.oJh = j3;
        ceM.oJi = j4;
        if (d2 >= 0.5d) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cVar.Ba(ceM.oJc);
        }
        AppMethodBeat.o(231589);
    }

    static /* synthetic */ void L(byte[] bArr, int i2) {
        AppMethodBeat.i(231590);
        af afVar = (af) g.a(new af(), bArr);
        if (afVar == null) {
            Log.e("MicroMsg.BackupMoveRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", Integer.valueOf(Util.getLength(bArr)));
            AppMethodBeat.o(231590);
            return;
        }
        ag agVar = new ag();
        agVar.oUR = afVar.oUR;
        agVar.oUT = afVar.oUT;
        agVar.oUS = afVar.oUS;
        agVar.oTx = afVar.oTx;
        try {
            com.tencent.mm.plugin.backup.g.b.D(agVar.toByteArray(), 14, i2);
            AppMethodBeat.o(231590);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e2, "buf to PacketSvrIDResponse err.", new Object[0]);
            AppMethodBeat.o(231590);
        }
    }

    static /* synthetic */ void c(c cVar, byte[] bArr, int i2) {
        int size;
        boolean z;
        AppMethodBeat.i(231591);
        z zVar = (z) g.a(new z(), bArr);
        if (zVar == null) {
            Log.e("MicroMsg.BackupMoveRecoverServer", "SendTagNotify PacketBackupDataTag parse failed:%d", Integer.valueOf(Util.getLength(bArr)));
            AppMethodBeat.o(231591);
            return;
        }
        Log.i("MicroMsg.BackupMoveRecoverServer", "tagReqNotify receive tag, MsgDataID:%s, NickName:%s, StartTime:%d, EndTime:%d", zVar.oUI, zVar.oUJ, Long.valueOf(zVar.oUG), Long.valueOf(zVar.oUH));
        cVar.oLB.add(zVar.oTx);
        if (!cVar.ifz) {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.TRUE);
            com.tencent.mm.plugin.backup.b.e ceM = b.cfv().ceM();
            int i3 = ceM.oJc;
            if (cVar.oLB.size() < cVar.oLw.size()) {
                size = cVar.oLB.size();
            } else {
                size = cVar.oLw.size();
            }
            ceM.a(i3, size, cVar.oLw.size(), cVar.recvSize, cVar.oJj, cVar.oLu, cVar.oLv);
            cVar.Ba(ceM.oJc);
            if (bg.aVF().aTt().biE(zVar.oUI) != null) {
                Log.i("MicroMsg.BackupMoveRecoverServer", "tagReqNotify the same tag has received, ignore. MsgDataID:%s", zVar.oUI);
            } else {
                l lVar = new l();
                lVar.field_msgListDataId = zVar.oUI;
                lVar.field_sessionName = zVar.oTx;
                Log.i("MicroMsg.BackupMoveRecoverServer", "tagReqNotify insert BackupRecoverMsgListDataIdStorage ret[%b], systemRowid[%d]", Boolean.valueOf(bg.aVF().aTt().insert(lVar)), Long.valueOf(lVar.systemRowid));
                com.tencent.mm.storage.o aTs = bg.aVF().aTs();
                String str = zVar.oTx;
                long j2 = zVar.oUG;
                long j3 = zVar.oUH;
                String str2 = "SELECT * FROM BackupTempMoveTime WHERE sessionName = \"" + str + "\"  AND startTime = " + j2 + " AND endTime = " + j3;
                Log.d("MicroMsg.BackupTempMoveTimeStorage", "isTempMoveTimeExist:".concat(String.valueOf(str2)));
                Cursor rawQuery = aTs.db.rawQuery(str2, null);
                if (rawQuery == null) {
                    Log.e("MicroMsg.BackupTempMoveTimeStorage", "isTempMoveTimeExist failed, sessionName[%s], startTime[%d], endTime[%d] ", str, Long.valueOf(j2), Long.valueOf(j3));
                    z = false;
                } else if (rawQuery.moveToNext()) {
                    rawQuery.close();
                    z = true;
                } else {
                    rawQuery.close();
                    z = false;
                }
                if (!z) {
                    n nVar = new n();
                    nVar.field_sessionName = zVar.oTx;
                    nVar.field_startTime = zVar.oUG;
                    nVar.field_endTime = zVar.oUH;
                    Log.i("MicroMsg.BackupMoveRecoverServer", "tagReqNotify insert BackupTempMoveTimeStorage ret[%b], systemRowid[%d]", Boolean.valueOf(bg.aVF().aTs().insert(nVar)), Long.valueOf(nVar.systemRowid));
                }
            }
            aa aaVar = new aa();
            aaVar.oTx = zVar.oTx;
            aaVar.oUG = zVar.oUG;
            aaVar.oUH = zVar.oUH;
            aaVar.oUI = zVar.oUI;
            try {
                Log.i("MicroMsg.BackupMoveRecoverServer", "tagReqNotify send tag resp");
                com.tencent.mm.plugin.backup.g.b.D(aaVar.toByteArray(), 16, i2);
                AppMethodBeat.o(231591);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e2, "tagReqNotify buf to PacketBackupDataTagResponse err.", new Object[0]);
                AppMethodBeat.o(231591);
            }
        } else {
            AppMethodBeat.o(231591);
        }
    }

    static /* synthetic */ void a(c cVar, byte[] bArr) {
        long j2;
        AppMethodBeat.i(231592);
        if (oLE) {
            Log.e("MicroMsg.BackupMoveRecoverServer", "finishReqNotify has already receive finishReq, return.");
            AppMethodBeat.o(231592);
            return;
        }
        oLE = true;
        Log.i("MicroMsg.BackupMoveRecoverServer", "finishReqNotify receive finishReq. hasReceiveFinishReq.");
        if (g.a(new com.tencent.mm.plugin.backup.i.d(), bArr) == null) {
            Log.e("MicroMsg.BackupMoveRecoverServer", "finishReqNotify buf to BackupFinishRequest error, buflen[%d]", Integer.valueOf(Util.getLength(bArr)));
        }
        b.cfv().cfw().oJB = null;
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.FALSE);
        com.tencent.mm.plugin.backup.g.b.cgt();
        com.tencent.mm.plugin.backup.g.b.cgv();
        b.cfv().ceM().a(24, cVar.oLB.size(), cVar.oLw.size(), cVar.recvSize, cVar.oJj, cVar.oLu, cVar.oLv);
        cVar.Ba(24);
        long milliSecondsToNow = Util.milliSecondsToNow(cVar.oLC);
        if (milliSecondsToNow != 0) {
            j2 = ((cVar.recvSize / 1024) * 1000) / milliSecondsToNow;
        } else {
            j2 = 0;
        }
        h.INSTANCE.idkeyStat(485, 45, 1, false);
        h.INSTANCE.idkeyStat(485, (long) ((cVar.oLH || cVar.oLG == 1) ? 68 : 67), 1, false);
        h.INSTANCE.idkeyStat(485, 61, milliSecondsToNow / 1000, false);
        h.INSTANCE.idkeyStat(485, 62, cVar.recvSize / 1024, false);
        h.INSTANCE.idkeyStat(485, (long) ((cVar.oLH || cVar.oLG == 1) ? 70 : 69), j2, false);
        h.INSTANCE.idkeyStat(485, 73, cVar.oLu / 1024, false);
        h.INSTANCE.idkeyStat(485, 74, cVar.oLv / 1024, false);
        cVar.Be(1);
        if (!cVar.oLK) {
            cVar.Be(2);
        }
        Log.i("MicroMsg.BackupMoveRecoverServer", "finishReqNotify recover success. recoverCostTime[%d s], recoverTotalSize[%d kb], recvSize[%d kb], recvTextSize[%d kb], recvMediaSize[%d kb]", Long.valueOf(milliSecondsToNow / 1000), Long.valueOf(cVar.oJj / 1024), Long.valueOf(cVar.recvSize / 1024), Long.valueOf(cVar.oLu / 1024), Long.valueOf(cVar.oLv / 1024));
        if (g.oJv) {
            s.ny(g.ceZ(), g.cfa());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            StringBuilder sb = new StringBuilder("\nMoveRecover Info:\n");
            sb.append("recoverStartTime:").append(simpleDateFormat.format(new Date(cVar.oLC))).append("\n");
            sb.append("recoverCostTime:").append(milliSecondsToNow).append("\n");
            sb.append("recvSize:").append(cVar.recvSize / 1024).append(" kB\n");
            sb.append("recvTextSize:").append(cVar.oLu / 1024).append(" kB\n");
            sb.append("recvMediaSize:").append(cVar.oLv / 1024).append(" kB\n");
            g.a(g.cfb(), "backupTestInfo.txt", sb.toString().getBytes());
        }
        AppMethodBeat.o(231592);
    }
}
