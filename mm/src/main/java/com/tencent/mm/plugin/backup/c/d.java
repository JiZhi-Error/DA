package com.tencent.mm.plugin.backup.c;

import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.DatabaseUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private static int oKH = 0;
    private static int oKI = 1;
    private static int oKJ = 2;
    private static boolean oKK = false;
    private boolean ifz;
    private Object lock = new Object();
    private final int oIY;
    private final com.tencent.mm.plugin.backup.b.d oJP;
    private long oJn = 0;
    private final HashMap<String, String> oKA = bg.aVF().aTt().gzC();
    private HashSet<String> oKB = new HashSet<>();
    private final int oKC;
    private final long oKD;
    private long oKE;
    private b.d oKF;
    private int oKG = oKH;
    private HashMap<String, Pair<Long, Long>> oKL;
    private a oKM;
    private boolean oKN;
    private int oKO;
    public boolean oKz = false;

    static /* synthetic */ int a(d dVar, String str, HashMap hashMap, Pair pair, String str2, PString pString, PBool pBool) {
        AppMethodBeat.i(21268);
        int a2 = dVar.a(str, hashMap, pair, str2, pString, pBool);
        AppMethodBeat.o(21268);
        return a2;
    }

    static /* synthetic */ long k(d dVar) {
        long j2 = dVar.oKE;
        dVar.oKE = 1 + j2;
        return j2;
    }

    static /* synthetic */ void p(d dVar) {
        AppMethodBeat.i(21270);
        dVar.cfi();
        AppMethodBeat.o(21270);
    }

    public d(com.tencent.mm.plugin.backup.b.d dVar, int i2, b.d dVar2, int i3, boolean z, LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        AppMethodBeat.i(21258);
        this.oJP = dVar;
        this.oIY = i2;
        this.oKF = dVar2;
        this.oKC = i3;
        oKK = z;
        this.oKD = DatabaseUtils.longForQuery(bg.aVF().aTt().iFy.gFH(), "SELECT COUNT(*) FROM BackupRecoverMsgListDataId", null);
        this.oKL = c(linkedList, linkedList2);
        this.oKB.clear();
        this.oKE = 0;
        Log.i("MicroMsg.BackupRecoverMerger", "BackupRecoverMerger, msgListDataIdHashMap[%d], backupMode[%d], totalMsgList[%d], totalSession[%d], isQuickBackup[%b]", Integer.valueOf(this.oKA.size()), Integer.valueOf(i2), Long.valueOf(this.oKD), Integer.valueOf(i3), Boolean.valueOf(z));
        AppMethodBeat.o(21258);
    }

    private static HashMap<String, Pair<Long, Long>> c(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        AppMethodBeat.i(21259);
        HashMap<String, Pair<Long, Long>> hashMap = new HashMap<>();
        Iterator<Long> it = linkedList2.iterator();
        Iterator<String> it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            if (it.hasNext()) {
                long longValue = it.next().longValue();
                if (longValue == 0) {
                    longValue = Long.MIN_VALUE;
                }
                if (!it.hasNext()) {
                    break;
                }
                long longValue2 = it.next().longValue();
                if (longValue2 == 0) {
                    longValue2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
                }
                hashMap.put(next, new Pair<>(Long.valueOf(longValue), Long.valueOf(longValue2)));
            }
        }
        AppMethodBeat.o(21259);
        return hashMap;
    }

    public final void jz(final boolean z) {
        AppMethodBeat.i(21260);
        if (cfh()) {
            Log.e("MicroMsg.BackupRecoverMerger", "Already start merge, return.");
            AppMethodBeat.o(21260);
            return;
        }
        Log.i("MicroMsg.BackupRecoverMerger", "startMerge");
        this.oJn = 0;
        CrashReportFactory.setBackupMerge(true);
        this.oJP.ceN();
        bg.getNotification().dh(true);
        this.oKG = oKI;
        if (this.oIY == 1) {
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.TRUE);
        } else if (this.oIY == 2) {
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.TRUE);
        }
        Log.i("MicroMsg.BackupRecoverMerger", "startMergeImpl start, mergeState[%d], totalMsgList[%d], msgListDataIdHashMap[%d]", Integer.valueOf(this.oKG), Long.valueOf(this.oKD), Integer.valueOf(this.oKA.size()));
        h.RTc.ba(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.backup.c.d.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "BackupRecoverMerger";
            }

            public final void run() {
                int size;
                long j2;
                long j3;
                AppMethodBeat.i(21256);
                e.reset();
                e.cfp();
                if (g.oJv && z && s.YS(g.cfa()) && s.dC(g.cfa(), false) != null) {
                    g.agw(g.ceZ());
                    s.ny(g.cfa(), g.ceZ());
                }
                HashMap hashMap = new HashMap();
                String str = (String) com.tencent.mm.plugin.backup.h.d.cgP().cgQ().azQ().get(2, (Object) null);
                for (String str2 : d.this.oKA.keySet()) {
                    long nowMilliSecond = Util.nowMilliSecond();
                    d.cfk();
                    a b2 = d.b(d.this);
                    if (com.tencent.mm.plugin.backup.h.d.cgP().cgQ().hqK != null) {
                        b2.oKR = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().hqK.beginTransaction(Thread.currentThread().getId());
                        b2.hjE = true;
                    }
                    String str3 = g.agx(str2) + str2;
                    try {
                        long a2 = (long) d.a(d.this, str3, hashMap, new Pair(new PLong(-1), new PLong(-1)), str, new PString(), new PBool());
                        if (a2 < 0) {
                            Log.e("MicroMsg.BackupRecoverMerger", "msgListMsgCount error, msgListMsgCount:%d, itemPath:%s", Long.valueOf(a2), str3);
                        }
                        if (d.this.ifz) {
                            Log.e("MicroMsg.BackupRecoverMerger", "startMergeImpl cancel, msgDataId[%s], transferMsgList[%d], totalMsgList[%d], transferSessions[%d], totalSession[%d]", str2, Long.valueOf(d.this.oKE), Long.valueOf(d.this.oKD), Integer.valueOf(d.this.oKB.size()), Integer.valueOf(d.this.oKC));
                            d.b(d.this).end();
                            d.cfl();
                            com.tencent.mm.plugin.backup.h.c.h(hashMap);
                            d.a(d.this, d.this.oKN, d.this.oKO);
                            AppMethodBeat.o(21256);
                            return;
                        }
                        d.this.oJn += a2;
                        d.this.oKB.add(d.this.oKA.get(str2));
                        d.k(d.this);
                        d.this.oJP.ceM().oJc = 26;
                        e ceM = d.this.oJP.ceM();
                        if (d.this.oKE > d.this.oKD) {
                            j3 = 100;
                        } else {
                            j3 = (d.this.oKE * 100) / d.this.oKD;
                        }
                        ceM.oJf = (int) j3;
                        d.this.Bc(26);
                        d.b(d.this).end();
                        d.cfl();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e2) {
                        }
                        Log.i("MicroMsg.BackupRecoverMerger", "startMergeImpl msgDataId[%s] merge finish, transferMsgList[%d], transferSessions[%d], msgListMsgCount:%d, receiveMsgCount:%d, costTime:%d", str2, Long.valueOf(d.this.oKE), Integer.valueOf(d.this.oKB.size()), Long.valueOf(a2), Long.valueOf(d.this.oJn), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.BackupRecoverMerger", e3, "startMergeImpl MMThread.run():", new Object[0]);
                        if (CrashReportFactory.hasDebuger()) {
                            AppMethodBeat.o(21256);
                            throw e3;
                        }
                        d.b(d.this).end();
                    }
                }
                d.this.oJP.ceM().oJn = d.this.oJn;
                e ceM2 = d.this.oJP.ceM();
                if (d.this.oKB.size() > d.this.oKC) {
                    size = d.this.oKC;
                } else {
                    size = d.this.oKB.size();
                }
                ceM2.oJd = size;
                d.this.oJP.ceM().oJe = d.this.oKC;
                e ceM3 = d.this.oJP.ceM();
                if (d.this.oKE > d.this.oKD) {
                    j2 = 100;
                } else {
                    j2 = (d.this.oKE * 100) / d.this.oKD;
                }
                ceM3.oJf = (int) j2;
                d.this.Bc(30);
                com.tencent.mm.plugin.backup.h.c.h(hashMap);
                Log.i("MicroMsg.BackupRecoverMerger", "startMergeImpl buildConversation finish! transferMsgList[%d], totalMsgList[%d], transferSession[%d], totalSession[%d]", Long.valueOf(d.this.oKE), Long.valueOf(d.this.oKD), Integer.valueOf(d.this.oKB.size()), Integer.valueOf(d.this.oKC));
                d.b(d.this).end();
                if (d.this.oKG != d.oKJ) {
                    d.this.oKG = d.oKJ;
                    d.cfj();
                    if (d.this.oIY == 1) {
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.FALSE);
                    } else if (d.this.oIY == 2) {
                        bg.aVF();
                        c.azQ().set(ar.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.FALSE);
                    }
                    if (d.this.oKF != null) {
                        d.this.oKF.ceL();
                    }
                    d.this.oJP.ceM().S(27, d.this.oKB.size() > d.this.oKC ? d.this.oKC : d.this.oKB.size(), d.this.oKC);
                    d.this.Bc(27);
                    g.ceY();
                    if (!g.oJv) {
                        g.agw(g.ceZ());
                        g.ceX();
                    }
                    d.this.oKG = d.oKH;
                    d.p(d.this);
                    bg.getNotification().dh(false);
                    d.this.oJP.ceO();
                }
                Log.appenderFlush();
                AppMethodBeat.o(21256);
            }
        });
        AppMethodBeat.o(21260);
    }

    private synchronized boolean cfh() {
        boolean z = true;
        synchronized (this) {
            if (!this.oKz) {
                this.oKz = true;
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x026c, code lost:
        ((com.tencent.mm.pointers.PLong) r21.first).value = r8;
        ((com.tencent.mm.pointers.PLong) r21.second).value = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x027c, code lost:
        r7.setCreateTime(r8);
        r7.setFlag(r3.KMX);
        r7.setType(r3.oUv);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0289, code lost:
        if (r11 == false) goto L_0x0309;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x028b, code lost:
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x028c, code lost:
        r7.nv(r4);
        r7.Cy(r10.value);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0294, code lost:
        if (r11 == false) goto L_0x030b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0296, code lost:
        r4 = r3.KMN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0298, code lost:
        r7.setStatus(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02a3, code lost:
        if (r20.get(r10.value) != null) goto L_0x02b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02a5, code lost:
        r20.put(r10.value, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02b1, code lost:
        if (r11 != false) goto L_0x02d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02b6, code lost:
        if (r3.KMN != 3) goto L_0x02d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02b8, code lost:
        r20.put(r10.value, java.lang.Integer.valueOf(com.tencent.mm.sdk.platformtools.Util.nullAs(r20.get(r10.value), 0) + 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02d4, code lost:
        r4 = com.tencent.mm.plugin.backup.f.c.cfW().Bh(r3.oUv);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02de, code lost:
        if (r4 != null) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02e0, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BackupMsgLogic", "recoverMsg unknown type");
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02ec, code lost:
        r8 = ((long) r3.KMO) * 1000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02f4, code lost:
        r8 = ((com.tencent.mm.pointers.PLong) r21.second).value + 1;
        ((com.tencent.mm.pointers.PLong) r21.second).value = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0309, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x030b, code lost:
        r4 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x030d, code lost:
        r4.a(r22, r3, r7);
        r4 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0333, code lost:
        r4 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0337, code lost:
        r10 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0028, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d3, code lost:
        if (com.tencent.mm.plugin.backup.c.d.oKK == false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d8, code lost:
        if (r3.oUv != 1) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00de, code lost:
        if (r24.value == false) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e0, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e1, code lost:
        if (r6 == false) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e3, code lost:
        if (r4 == null) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e5, code lost:
        r4 = r4.field_talker;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e7, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f9, code lost:
        r9 = r3.KHl.MTo;
        r8 = r3.KHm.MTo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0105, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r9) != false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010b, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r8) == false) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010d, code lost:
        r10 = new java.lang.Object[2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0117, code lost:
        if (r9 != null) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0119, code lost:
        r9 = com.tencent.mm.loader.BuildConfig.COMMAND;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        r10[0] = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011f, code lost:
        if (r8 != null) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0121, code lost:
        r8 = com.tencent.mm.loader.BuildConfig.COMMAND;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0124, code lost:
        r10[1] = r8;
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.BackupMsgLogic", "recoverMsg userName null, fromUserName[%s], toUserName[%s]", r10);
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0131, code lost:
        if (r22.equals(r9) != false) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0133, code lost:
        r4 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013d, code lost:
        if (r4.uin != 0) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013f, code lost:
        r4 = new com.tencent.mm.model.b();
        com.tencent.matrix.trace.core.AppMethodBeat.o(21261);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0149, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014b, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.BackupRecoverMerger", r4, "recoverMsgLists recoverMsg err", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015f, code lost:
        if (r4.oQB.has(r9) == false) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0161, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0163, code lost:
        if (r23 == null) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x016d, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r23.value) == false) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016f, code lost:
        if (r23 != null) goto L_0x0333;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0171, code lost:
        r4 = new com.tencent.mm.pointers.PString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0176, code lost:
        if (r11 == false) goto L_0x01cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0178, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0179, code lost:
        r4.value = r7;
        r7 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSN().Kn(r4.value);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0197, code lost:
        if (com.tencent.mm.plugin.backup.b.g.cfd().contains(r4.value) != false) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0199, code lost:
        if (r7 == null) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01a1, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r7.field_username) != false) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a7, code lost:
        if (r7.gBM() == false) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01a9, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.BackupMsgLogic", "recoverMsg hit the blockList: " + r4.value);
        r24.value = true;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01c9, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01cc, code lost:
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ce, code lost:
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01d5, code lost:
        if (r3.Brn != 0) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01d9, code lost:
        if (r3.Brl == 0) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01db, code lost:
        r3.Brn = (long) r3.Brl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01e6, code lost:
        if (r3.Brn == 0) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01e8, code lost:
        r7 = com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().aJ(r10.value, r3.Brn);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0202, code lost:
        if (r7.field_msgId == 0) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0204, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BackupMsgLogic", "recoverMsg msg exist, type[%d], from[%s], to[%s]", java.lang.Integer.valueOf(r3.oUv), r9, r8);
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0222, code lost:
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.BackupMsgLogic", "recoverMsg drop the item server id < 0");
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x022e, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BackupMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", java.lang.Integer.valueOf(r3.oUv), r9, r8);
        r7.yF(r3.Brn);
        r7.yH((long) r3.KMV);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x025c, code lost:
        if (r3.KMW == 0) goto L_0x02ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x025e, code lost:
        r8 = r3.KMW;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x026a, code lost:
        if (r8 == ((com.tencent.mm.pointers.PLong) r21.first).value) goto L_0x02f4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(java.lang.String r19, java.util.HashMap<java.lang.String, java.lang.Integer> r20, android.util.Pair<com.tencent.mm.pointers.PLong, com.tencent.mm.pointers.PLong> r21, java.lang.String r22, com.tencent.mm.pointers.PString r23, com.tencent.mm.pointers.PBool r24) {
        /*
        // Method dump skipped, instructions count: 827
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.c.d.a(java.lang.String, java.util.HashMap, android.util.Pair, java.lang.String, com.tencent.mm.pointers.PString, com.tencent.mm.pointers.PBool):int");
    }

    private static List<is> k(String str, List<is> list) {
        is l;
        String str2;
        AppMethodBeat.i(231586);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = null;
        for (is isVar : list) {
            if (isVar.oUv == 49) {
                if (k.b.HD(isVar.KHn.MTo) == null) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Long.valueOf(isVar.Brn);
                    if (isVar.KHn.MTo == null) {
                        str2 = BuildConfig.COMMAND;
                    } else {
                        str2 = isVar.KHn.MTo;
                    }
                    objArr[1] = str2;
                    Log.e("MicroMsg.BackupRecoverMerger", "checkPatMsg error content null. msgid:%d, content:%s", objArr);
                } else if (k.b.HD(isVar.KHn.MTo).type == 62) {
                    if (linkedList2 == null) {
                        linkedList2 = new LinkedList();
                    }
                    linkedList2.add(isVar);
                }
            }
            if (linkedList2 != null && !linkedList2.isEmpty()) {
                is l2 = l(str, linkedList2);
                if (l2 != null) {
                    linkedList.add(l2);
                }
                linkedList2 = null;
            }
            linkedList.add(isVar);
        }
        if (!(linkedList2 == null || linkedList2.isEmpty() || (l = l(str, linkedList2)) == null)) {
            linkedList.add(l);
        }
        AppMethodBeat.o(231586);
        return linkedList;
    }

    private static is l(String str, List<is> list) {
        AppMethodBeat.i(231587);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(231587);
            return null;
        }
        is isVar = list.get(0);
        czg czg = new czg();
        czg.gnh = str;
        for (is isVar2 : list) {
            czg boC = com.tencent.mm.util.e.boC(isVar2.KHn.MTo);
            Log.d("MicroMsg.BackupRecoverMerger", "find %s pat record in msg", isVar2.KIz);
            czg.yVw.addAll(boC.yVw);
        }
        k.b bVar = new k.b();
        com.tencent.mm.plugin.patmsg.a.a aVar = new com.tencent.mm.plugin.patmsg.a.a();
        aVar.ARl = czg;
        bVar.a(aVar);
        bVar.type = 62;
        bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
        bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
        dqi dqi = new dqi();
        dqi.bhy(Util.nullAs(k.b.a(bVar, "", null), ""));
        isVar.KHn = dqi;
        AppMethodBeat.o(231587);
        return isVar;
    }

    public final void x(boolean z, int i2) {
        AppMethodBeat.i(21262);
        synchronized (this.lock) {
            try {
                Log.i("MicroMsg.BackupRecoverMerger", "cancel, needClearContinueRecoverData[%b], mergeState[%d], updateState[%d]", Boolean.valueOf(z), Integer.valueOf(this.oKG), Integer.valueOf(i2));
                this.ifz = true;
            } catch (Throwable th) {
                AppMethodBeat.o(21262);
                throw th;
            }
        }
        this.oKN = z;
        this.oKO = i2;
        bg.getNotification().dh(false);
        this.oJP.ceO();
        AppMethodBeat.o(21262);
    }

    private synchronized void cfi() {
        this.oKz = false;
    }

    public final void Bc(int i2) {
        AppMethodBeat.i(21263);
        if (this.oKF != null) {
            this.oKF.Ba(i2);
        }
        AppMethodBeat.o(21263);
    }

    public static void cfj() {
        AppMethodBeat.i(21264);
        Log.i("MicroMsg.BackupRecoverMerger", "backupFinishMerge");
        EventCenter.instance.publish(new ca());
        EventCenter.instance.publish(new ae());
        com.tencent.mm.plugin.backup.h.a cgR = com.tencent.mm.plugin.backup.h.d.cgP().cgR();
        cgR.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.h.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(21742);
                Iterator<C0849a> it = a.this.oQt.iterator();
                while (it.hasNext()) {
                    C0849a next = it.next();
                    if (next.type == 2 && next.obj != null && (next.obj instanceof String)) {
                        String str = (String) next.obj;
                        Log.d("MicroMsg.BackupRecoverDelayData", "getContact:".concat(String.valueOf(str)));
                        ay.a.iDq.aL(str, "");
                    } else if (next.type == 1 && next.obj != null && (next.obj instanceof String)) {
                        ao.eAR().bdF((String) next.obj);
                    }
                }
                a.this.oQt.clear();
                AppMethodBeat.o(21742);
            }
        });
        bg.aVF();
        c.aSQ().eiI();
        EventCenter.instance.publish(new ur());
        CrashReportFactory.setBackupMerge(false);
        AppMethodBeat.o(21264);
    }

    public static void cfk() {
        AppMethodBeat.i(21265);
        com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().aEs("BACKUP_MERGE_LOCK");
        AppMethodBeat.o(21265);
    }

    public static void cfl() {
        AppMethodBeat.i(21266);
        com.tencent.mm.plugin.backup.h.d.cgP().cgQ().aSQ().aEt("BACKUP_MERGE_LOCK");
        AppMethodBeat.o(21266);
    }

    /* access modifiers changed from: package-private */
    public class a {
        boolean hjE;
        long oKR;

        private a() {
            this.oKR = -1;
            this.hjE = false;
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        public final void end() {
            AppMethodBeat.i(21257);
            if (this.hjE && com.tencent.mm.plugin.backup.h.d.cgP().cgQ().hqK != null) {
                com.tencent.mm.plugin.backup.h.d.cgP().cgQ().hqK.endTransaction(this.oKR);
                this.hjE = false;
            }
            AppMethodBeat.o(21257);
        }
    }

    static /* synthetic */ a b(d dVar) {
        AppMethodBeat.i(21267);
        if (dVar.oKM == null) {
            dVar.oKM = new a(dVar, (byte) 0);
        }
        a aVar = dVar.oKM;
        AppMethodBeat.o(21267);
        return aVar;
    }

    static /* synthetic */ void a(d dVar, boolean z, int i2) {
        AppMethodBeat.i(21269);
        if (dVar.oKG == oKI || dVar.oKG == oKH) {
            if (dVar.oKG == oKI) {
                cfj();
            }
            dVar.oKG = oKJ;
            if (z) {
                if (dVar.oIY == 1) {
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_BACKUP_PC_MERGERING_BOOLEAN, Boolean.FALSE);
                } else if (dVar.oIY == 2) {
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_BACKUP_MOVE_MERGERING_BOOLEAN, Boolean.FALSE);
                }
                g.ceY();
                g.agw(g.ceZ());
                if (!g.oJv) {
                    g.ceX();
                }
            }
            Log.i("MicroMsg.BackupRecoverMerger", "cancel and restart sync");
            if (i2 != 0) {
                dVar.oJP.ceM().oJc = i2;
                dVar.Bc(i2);
            }
            dVar.oKG = oKH;
            dVar.cfi();
            dVar.oJP.ceO();
        }
        AppMethodBeat.o(21269);
    }
}
