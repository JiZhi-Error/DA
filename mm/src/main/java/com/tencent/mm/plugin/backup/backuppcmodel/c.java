package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.backup.g.h;
import com.tencent.mm.plugin.backup.g.j;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class c {
    private static boolean aMp = false;
    private static int ibG = 2;
    private MTimerHandler oLR;
    final i oLS = new i() {
        /* class com.tencent.mm.plugin.backup.backuppcmodel.c.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(21558);
            bg.azz().b(595, c.this.oLS);
            if (i2 == 0 && i3 == 0) {
                blq cgI = ((e) qVar).cgI();
                bg.aVF();
                if (!Util.nullAsNil((String) com.tencent.mm.model.c.azQ().get(2, (Object) null)).equals(cgI.KMF)) {
                    Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
                    b.cga().ceM().oJc = -5;
                    b.cga().cgc().xI(-5);
                    h.INSTANCE.idkeyStat(400, 112, 1, false);
                    AppMethodBeat.o(21558);
                } else if (cgI.KMD == null || cgI.KMD.size() <= 0 || cgI.KMD.getFirst() == null) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(cgI.KMC);
                    objArr[1] = cgI.KMD == null ? BuildConfig.COMMAND : new StringBuilder().append(cgI.KMD.size()).toString();
                    Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]", objArr);
                    b.cga().ceM().oJc = -5;
                    b.cga().cgc().xI(-5);
                    h.INSTANCE.idkeyStat(400, 113, 1, false);
                    AppMethodBeat.o(21558);
                } else {
                    adi first = cgI.KMD.getFirst();
                    String str2 = first.LjZ;
                    int intValue = first.Low.getFirst().intValue();
                    c cVar = c.this;
                    cVar.oOl = cgI.KMG;
                    cVar.oOm = str2;
                    cVar.oOn = intValue;
                    Log.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", Integer.valueOf(cgI.oUv), Integer.valueOf(cgI.Scene), cgI.KMG, str2, Integer.valueOf(intValue));
                    b.cga().oIU = cgI.ID;
                    b.cga().oIV = cgI.KML;
                    b.cga().oIW = cgI.KMM;
                    b.cga().oJa = cgI.KLU.getBufferToBytes();
                    c.b(c.this);
                    AppMethodBeat.o(21558);
                }
            } else {
                Log.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
                h.INSTANCE.idkeyStat(400, 111, 1, false);
                if (i2 == 4 && i3 == -2011) {
                    Log.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
                }
                b.cga().ceM().oJc = -5;
                b.cga().cgc().xI(-5);
                AppMethodBeat.o(21558);
            }
        }
    };
    private final i oLT = new i() {
        /* class com.tencent.mm.plugin.backup.backuppcmodel.c.AnonymousClass3 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            boolean z;
            boolean z2;
            boolean z3;
            b bVar;
            AppMethodBeat.i(21560);
            boolean unused = c.aMp = true;
            h.INSTANCE.a(13736, 0, c.this.oOl, g.eE(MMApplicationContext.getContext()), 0, Integer.valueOf(b.cga().cgb().oOq));
            com.tencent.mm.plugin.backup.g.b.b(1, c.this.oLT);
            if (i2 == 0 && i3 == 0) {
                a aVar = (a) qVar;
                if ((aVar.oPi.oUw & com.tencent.mm.plugin.backup.b.c.oIR) == 0) {
                    z = false;
                } else {
                    z = true;
                }
                if ((aVar.oPi.oUw & com.tencent.mm.plugin.backup.b.c.oIS) == 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if ((aVar.oPi.oUw & com.tencent.mm.plugin.backup.b.c.oIT) == 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                Log.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
                if (z3) {
                    if (aVar.oPi.oUy == null) {
                        bVar = null;
                    } else {
                        bVar = aVar.oPi.oUy;
                    }
                    if (bVar != null) {
                        c.this.a(true, bVar);
                        b.cga().cgc().oOF = z;
                        b.cga().cgc().oOG = z2;
                        AppMethodBeat.o(21560);
                        return;
                    }
                    Log.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
                }
                c.this.a(false, null);
                b.cga().cgc().oOF = z;
                b.cga().cgc().oOG = z2;
                AppMethodBeat.o(21560);
                return;
            }
            Log.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
            switch (i3) {
                case -3:
                    h.INSTANCE.idkeyStat(400, 115, 1, false);
                    break;
                case -2:
                default:
                    h.INSTANCE.idkeyStat(400, 116, 1, false);
                    break;
                case -1:
                    h.INSTANCE.idkeyStat(400, 114, 1, false);
                    break;
            }
            h.INSTANCE.a(13737, 1, 0, 0, 0, Integer.valueOf(c.this.oOq));
            b.cga().ceM().oJc = -5;
            b.cga().cgc().xI(-5);
            AppMethodBeat.o(21560);
        }
    };
    b.c oLX = new b.c() {
        /* class com.tencent.mm.plugin.backup.backuppcmodel.c.AnonymousClass8 */

        @Override // com.tencent.mm.plugin.backup.g.b.c
        public final void cfK() {
            AppMethodBeat.i(21568);
            Log.i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
            com.tencent.mm.plugin.backup.g.b.cgt();
            b.cga().ceO();
            AppMethodBeat.o(21568);
        }
    };
    private final j.a oLY = new j.a() {
        /* class com.tencent.mm.plugin.backup.backuppcmodel.c.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.backup.g.j.a
        public final void cfI() {
            AppMethodBeat.i(21563);
            int i2 = b.cga().cgb().oOk;
            if (1 == i2 || 3 == i2) {
                b.cga().cgc().xI(b.cga().ceM().oJc);
                AppMethodBeat.o(21563);
                return;
            }
            if (2 == i2 || 4 == i2) {
                b.cga().cgd().Ba(b.cga().ceM().oJc);
            }
            AppMethodBeat.o(21563);
        }

        @Override // com.tencent.mm.plugin.backup.g.j.a
        public final void Bf(int i2) {
            AppMethodBeat.i(21564);
            int i3 = b.cga().ceM().oJc;
            if (i2 == 1) {
                if ((1 == c.this.oOk || 3 == c.this.oOk) && i3 == 14) {
                    Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
                    b.cga().ceM().oJc = 4;
                    b.cga().cgc().xI(4);
                    AppMethodBeat.o(21564);
                    return;
                } else if ((2 == c.this.oOk || 4 == c.this.oOk) && i3 == 23) {
                    Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
                    b.cga().ceM().oJc = 4;
                    b.cga().cgd().Ba(4);
                    AppMethodBeat.o(21564);
                    return;
                }
            } else if (i2 == 0 && i3 == 4) {
                Log.i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
                if (1 == c.this.oOk || 3 == c.this.oOk) {
                    b.cga().ceM().oJc = 14;
                    b.cga().cgc().xI(14);
                    AppMethodBeat.o(21564);
                    return;
                } else if (2 == c.this.oOk || 4 == c.this.oOk) {
                    b.cga().ceM().oJc = 23;
                    b.cga().cgd().Ba(23);
                }
            }
            AppMethodBeat.o(21564);
        }

        @Override // com.tencent.mm.plugin.backup.g.j.a
        public final void cfJ() {
            AppMethodBeat.i(21565);
            int i2 = b.cga().ceM().oJc;
            Log.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", Integer.valueOf(i2));
            int i3 = b.cga().cgb().oOk;
            if ((1 == i3 || 3 == i3) && (i2 == 14 || i2 == 4)) {
                b.cga().cfw().stop();
                b.cga().cgc().cancel(true);
                h.INSTANCE.idkeyStat(400, 9, 1, false);
                b.cga().cgc().Bk(18);
                b.cga().ceM().oJc = -4;
                b.cga().cgc().xI(-4);
                AppMethodBeat.o(21565);
                return;
            }
            if ((2 == i3 || 4 == i3) && (i2 == 23 || i2 == 4)) {
                b.cga().cfw().stop();
                b.cga().cgd().a(true, false, -4);
                h.INSTANCE.idkeyStat(400, 17, 1, false);
                b.cga().cgd().Bk(18);
            }
            AppMethodBeat.o(21565);
        }
    };
    public int oOk = 0;
    public String oOl;
    String oOm;
    int oOn;
    boolean oOo;
    private com.tencent.mm.bw.b oOp;
    public int oOq;
    public boolean oOr = true;
    private final b.d oOs = new b.d() {
        /* class com.tencent.mm.plugin.backup.backuppcmodel.c.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.backup.g.b.d
        public final void a(boolean z, int i2, byte[] bArr, int i3) {
            AppMethodBeat.i(21561);
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]", objArr);
            if (!z || bArr == null) {
                if (i2 == 17) {
                    com.tencent.mm.plugin.backup.i.b bVar = new com.tencent.mm.plugin.backup.i.b();
                    try {
                        bVar.parseFrom(bArr);
                        Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", Integer.valueOf(bVar.oTl));
                        switch (bVar.oTl) {
                            case 1:
                                c.a(c.this, 1, i3);
                                break;
                            case 3:
                                c.b(c.this, 3, i3);
                                break;
                            case 5:
                                bg.aVF();
                                if (((Boolean) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                                    b.cga();
                                    String string = b.ceR().getString("BACKUP_PC_CHOOSE_SESSION", null);
                                    if (string != null) {
                                        Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
                                        h.INSTANCE.idkeyStat(400, 29, 1, false);
                                        c.this.oOk = 3;
                                        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(g.eQ(string, ",")));
                                        b.cga().cgc().init();
                                        b.cga().cgc().G(linkedList);
                                        c.eS(5, i3);
                                        b.cga().cgc().ceK();
                                        c.this.Bj(6);
                                        e cgc = b.cga().cgc();
                                        d.cgP().cgS();
                                        cgc.Bv((long) cgc.oMc.size());
                                        break;
                                    } else {
                                        Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
                                        c.a(c.this, 5, i3);
                                        break;
                                    }
                                } else {
                                    Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
                                    c.a(c.this, 5, i3);
                                    break;
                                }
                            case 7:
                                bg.aVF();
                                if (((Boolean) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                                    b.cga().cgd();
                                    if (d.cfA()) {
                                        Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
                                        h.INSTANCE.idkeyStat(400, 30, 1, false);
                                        c.this.oOk = 4;
                                        b.cga().cgd().init();
                                        c.eS(7, i3);
                                        b.cga().cgc().ceK();
                                        c.this.Bj(8);
                                        break;
                                    } else {
                                        Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
                                        c.b(c.this, 7, i3);
                                        break;
                                    }
                                } else {
                                    Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
                                    c.b(c.this, 7, i3);
                                    break;
                                }
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e2, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
                    }
                }
                if (i2 == 5) {
                    Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
                    h.INSTANCE.a(13737, 5, 0, 0, 0, Integer.valueOf(b.cga().cgb().oOq));
                    b.cga().ceM().oJc = -100;
                    b.cga().cgc().xI(-100);
                    AppMethodBeat.o(21561);
                    return;
                }
                AppMethodBeat.o(21561);
                return;
            }
            if (10011 == i2) {
                int i4 = b.cga().ceM().oJc;
                Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]", Integer.valueOf(i4));
                switch (i4) {
                    case 1:
                        if (!c.aMp) {
                            if (c.this.oLR != null) {
                                Log.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.");
                                c.this.oLR.stopTimer();
                            }
                            c.d(c.this);
                            AppMethodBeat.o(21561);
                            return;
                        }
                        b.cga().cfw().stop();
                        b.cga().ceM().oJc = -4;
                        b.cga().cgc().xI(-4);
                        AppMethodBeat.o(21561);
                        return;
                    case -100:
                    case -21:
                    case -5:
                        b.cga().cfw().stop();
                        break;
                }
            }
            AppMethodBeat.o(21561);
        }
    };
    public final h.a oOt = new h.a() {
        /* class com.tencent.mm.plugin.backup.backuppcmodel.c.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.backup.g.h.a
        public final void cgh() {
            AppMethodBeat.i(21566);
            Log.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
            if (b.cga().ceM().oJc != 5) {
                b.cga().ceM().oJc = 5;
                int i2 = b.cga().cgb().oOk;
                if (1 == i2 || 3 == i2) {
                    b.cga().cgc().xI(5);
                } else if (2 == i2 || 4 == i2) {
                    b.cga().cgd().Ba(5);
                }
            }
            c.this.Bj(9);
            AppMethodBeat.o(21566);
        }

        @Override // com.tencent.mm.plugin.backup.g.h.a
        public final void cgi() {
            AppMethodBeat.i(21567);
            int i2 = c.this.oOk;
            Log.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", Integer.valueOf(i2));
            if (1 == i2 || 3 == i2) {
                b.cga().cgc();
                e.cgl();
                b.cga().cgc().cancel(true);
                b.cga().cfw().stop();
                b.cga().ceM().oJc = -4;
                b.cga().cgc().xI(-4);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 9, 1, false);
                b.cga().cgc().Bk(3);
                AppMethodBeat.o(21567);
                return;
            }
            if (2 == i2 || 4 == i2) {
                b.cga().cgd();
                d.cgj();
                b.cga().cgd().a(true, false, -4);
                b.cga().cfw().stop();
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 17, 1, false);
                b.cga().cgd().Bk(3);
            }
            AppMethodBeat.o(21567);
        }
    };

    public c() {
        AppMethodBeat.i(21569);
        AppMethodBeat.o(21569);
    }

    public final void a(boolean z, com.tencent.mm.bw.b bVar) {
        this.oOo = z;
        this.oOp = bVar;
    }

    private void cgf() {
        AppMethodBeat.i(21570);
        b.cga().cfw().connect(this.oOm, this.oOn);
        com.tencent.mm.plugin.backup.g.b.clear();
        com.tencent.mm.plugin.backup.g.b.a(1, this.oLT);
        a aVar = new a(b.cga().oIV, b.cga().oIW, com.tencent.mm.plugin.backup.b.d.ceQ(), b.cga().oIU, 0, 1, false);
        aVar.A(true, true);
        aVar.oPh.oUx = 1;
        aVar.cgA();
        Log.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
        if (this.oLR == null) {
            this.oLR = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.backup.backuppcmodel.c.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(21559);
                    if (!c.aMp) {
                        Log.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
                        if (c.this.oLR != null) {
                            c.this.oLR.stopTimer();
                        }
                        c.d(c.this);
                    }
                    AppMethodBeat.o(21559);
                    return true;
                }
            }, false);
        }
        this.oLR.startTimer(3000);
        AppMethodBeat.o(21570);
    }

    public static String cgg() {
        AppMethodBeat.i(21571);
        String cgw = com.tencent.mm.plugin.backup.g.b.cgw();
        AppMethodBeat.o(21571);
        return cgw;
    }

    public final void Bj(int i2) {
        AppMethodBeat.i(21572);
        Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", Integer.valueOf(i2));
        com.tencent.mm.plugin.backup.i.b bVar = new com.tencent.mm.plugin.backup.i.b();
        bVar.oTl = i2;
        if (i2 == 9) {
            bVar.oTm = this.oOp;
        }
        try {
            com.tencent.mm.plugin.backup.g.b.N(bVar.toByteArray(), 17);
            AppMethodBeat.o(21572);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e2, "BackupCommandRequest to buf err.", new Object[0]);
            AppMethodBeat.o(21572);
        }
    }

    public static void eS(int i2, int i3) {
        AppMethodBeat.i(21573);
        Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", Integer.valueOf(i2));
        com.tencent.mm.plugin.backup.i.c cVar = new com.tencent.mm.plugin.backup.i.c();
        cVar.oTl = i2;
        try {
            com.tencent.mm.plugin.backup.g.b.D(cVar.toByteArray(), 18, i3);
            AppMethodBeat.o(21573);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e2, "BackupCommandResponse to buf err.", new Object[0]);
            AppMethodBeat.o(21573);
        }
    }

    public static void cfF() {
        AppMethodBeat.i(21574);
        Log.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
        com.tencent.mm.plugin.backup.i.a aVar = new com.tencent.mm.plugin.backup.i.a();
        aVar.ID = b.cga().oIU;
        try {
            com.tencent.mm.plugin.backup.g.b.N(aVar.toByteArray(), 5);
            AppMethodBeat.o(21574);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e2, "BackupCancelRequest to buf err.", new Object[0]);
            AppMethodBeat.o(21574);
        }
    }

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(21575);
        com.tencent.mm.plugin.backup.g.b.Bb(1);
        b.cga().ceN();
        com.tencent.mm.plugin.backup.g.b.a(cVar.oLX);
        com.tencent.mm.plugin.backup.g.b.a(cVar.oOs);
        com.tencent.mm.plugin.backup.g.b.a(b.cga().cfw());
        com.tencent.mm.plugin.backup.g.b.a(cVar.oLY);
        b.cga().ceM().oJc = 1;
        Intent className = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_notification");
        Context context = MMApplicationContext.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(className);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcProcessMgr", "startConnectPc", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcProcessMgr", "startConnectPc", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        aMp = false;
        Log.i("MicroMsg.BackupPcProcessMgr", "startConnectPc, PC ip:%s, PC wifi:%s, Phone wifi:%s", cVar.oOm, cVar.oOl, g.eE(MMApplicationContext.getContext()));
        ibG = 2;
        cVar.cgf();
        AppMethodBeat.o(21575);
    }

    static /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(21576);
        String str = cVar.oOl;
        String str2 = cVar.oOm;
        String eE = g.eE(MMApplicationContext.getContext());
        b.cga().cfw().stop();
        Log.e("MicroMsg.BackupPcProcessMgr", "tryConnectFailed thisWifiName:%s, pcWifiName:%s, pcIpAddress:%s, tryCount:%d", eE, str, str2, Integer.valueOf(ibG));
        if (eE == null || eE.equals("")) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 1, 1, false);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13736, 1, str, eE, 0, Integer.valueOf(b.cga().cgb().oOq));
            b.cga().ceM().oJc = -1;
            b.cga().cgc().xI(-1);
            AppMethodBeat.o(21576);
        } else if (str == null || !str.equals(eE)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 2, 1, false);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13736, 2, str, eE, 0, Integer.valueOf(b.cga().cgb().oOq));
            b.cga().ceM().oJc = -2;
            b.cga().cgc().xI(-2);
            AppMethodBeat.o(21576);
        } else if (!g.agA(str2)) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 3, 1, false);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13736, 3, str, eE, 0, Integer.valueOf(b.cga().cgb().oOq));
            b.cga().ceM().oJc = -3;
            b.cga().cgc().xI(-3);
            AppMethodBeat.o(21576);
        } else if (ibG <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(400, 63, 1, false);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13736, 6, str, eE, 0, Integer.valueOf(b.cga().cgb().oOq));
            b.cga().ceM().oJc = -5;
            b.cga().cgc().xI(-5);
            AppMethodBeat.o(21576);
        } else {
            ibG--;
            cVar.cgf();
            AppMethodBeat.o(21576);
        }
    }

    static /* synthetic */ void a(c cVar, int i2, int i3) {
        AppMethodBeat.i(21577);
        Log.i("MicroMsg.BackupPcProcessMgr", "newBackup, command[%d]", Integer.valueOf(i2));
        cVar.oOk = 1;
        b.cga().oIX = null;
        b.cga().cgc().init();
        e cgc = b.cga().cgc();
        Log.i("MicroMsg.BackupPcServer", "clearContinueBackupData.");
        cgc.oMe.jy(false);
        eS(i2, i3);
        b.cga().cgc().ceK();
        AppMethodBeat.o(21577);
    }

    static /* synthetic */ void b(c cVar, int i2, int i3) {
        AppMethodBeat.i(21578);
        Log.i("MicroMsg.BackupPcProcessMgr", "newRecover, command[%d]", Integer.valueOf(i2));
        cVar.oOk = 2;
        b.cga().oIX = null;
        b.cga().cgd().init();
        b.cga().cgd().cfB();
        eS(i2, i3);
        d cgd = b.cga().cgd();
        HashSet hashSet = new HashSet();
        hashSet.addAll(cgd.oOw);
        MMHandlerThread.postToMainThread(new Runnable(hashSet) {
            /* class com.tencent.mm.plugin.backup.backuppcmodel.d.AnonymousClass2 */
            final /* synthetic */ Set oOD;

            {
                this.oOD = r2;
            }

            public final void run() {
                AppMethodBeat.i(21581);
                for (b.c cVar : this.oOD) {
                    cVar.ceK();
                }
                AppMethodBeat.o(21581);
            }
        });
        AppMethodBeat.o(21578);
    }
}
