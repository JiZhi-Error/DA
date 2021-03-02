package com.tencent.mm.plugin.fts.ui;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.plugin.fts.ui.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.util.c;
import java.util.ArrayList;

public final class l {
    public static void ao(int i2, long j2) {
        AppMethodBeat.i(112010);
        Log.v("MicroMsg.FTS.FTSReportLogic", "reportIDKey: type=%d time=%d", Integer.valueOf(i2), Long.valueOf(j2));
        switch (i2) {
            case 0:
            case 3:
            case 6:
            case 9:
            case 12:
                IDKey iDKey = new IDKey();
                iDKey.SetID(79);
                iDKey.SetKey(i2 + 1);
                iDKey.SetValue((long) ((int) j2));
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(79);
                iDKey2.SetKey(i2 + 2);
                iDKey2.SetValue(1);
                ArrayList<IDKey> arrayList = new ArrayList<>();
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                h.INSTANCE.b(arrayList, false);
                break;
        }
        AppMethodBeat.o(112010);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(112011);
        if (Util.isNullOrNil(bVar.query)) {
            AppMethodBeat.o(112011);
            return;
        }
        b.a aVar = b.a.clicfg_wanet_search;
        c cVar = c.QYz;
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, c.hdd());
        long j2 = bVar.xeh - bVar.xaI;
        if (j2 < 0) {
            j2 = 0;
        }
        Object[] objArr = new Object[13];
        objArr[0] = Long.valueOf(bVar.xej);
        objArr[1] = Long.valueOf(e.wVm);
        objArr[2] = bVar.query;
        objArr[3] = bVar.dPD();
        objArr[4] = Integer.valueOf(bVar.xeD ? 2 : 1);
        objArr[5] = Integer.valueOf(bVar.xeE > 0 ? 1 : 0);
        objArr[6] = bVar.dPC();
        objArr[7] = bVar.dPG();
        objArr[8] = Long.valueOf(j2);
        objArr[9] = Integer.valueOf(a2);
        objArr[10] = Integer.valueOf(bVar.xeB);
        objArr[11] = bVar.dPE();
        objArr[12] = bVar.dPF();
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
        Log.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", 17510, format);
        h.INSTANCE.kvStat(17510, format);
        AppMethodBeat.o(112011);
    }

    public static void c(String str, boolean z, int i2, int i3) {
        AppMethodBeat.i(112012);
        a(str, z, i2, i3, new com.tencent.mm.plugin.fts.ui.c.b());
        AppMethodBeat.o(112012);
    }

    public static void a(String str, boolean z, int i2, int i3, com.tencent.mm.plugin.fts.ui.c.b bVar) {
        int i4;
        AppMethodBeat.i(112013);
        if (z) {
            i4 = 3;
        } else if (i2 > 0) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        a(str, i4, i3, bVar);
        AppMethodBeat.o(112013);
    }

    private static void a(String str, int i2, int i3, com.tencent.mm.plugin.fts.ui.c.b bVar) {
        int i4;
        AppMethodBeat.i(112014);
        switch (i3) {
            case -15:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                i4 = 2;
                break;
            case -14:
            case -13:
            case -12:
            case -11:
            case -10:
            case -9:
            case -8:
            case -7:
            case -6:
            default:
                i4 = 0;
                break;
            case 0:
                i4 = 1;
                break;
        }
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s,%s,%s", str, Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(bVar.xek), Integer.valueOf(bVar.xen), Integer.valueOf(bVar.xer), 0, 0, Long.valueOf(e.wVm), Integer.valueOf(bVar.xem), Integer.valueOf(bVar.xeo), 0, Long.valueOf(System.currentTimeMillis()), 0, Long.valueOf(e.wVm), Long.valueOf(bVar.xej));
        Log.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", 11062, format);
        h.INSTANCE.kvStat(11062, format);
        AppMethodBeat.o(112014);
    }

    public static void b(com.tencent.mm.plugin.fts.ui.c.b bVar) {
        AppMethodBeat.i(112015);
        String str = bVar.query;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(112015);
            return;
        }
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d,%s,%s", str, 3, 1, Integer.valueOf(bVar.xek), Integer.valueOf(bVar.xen), Integer.valueOf(bVar.xer), 0, 0, Long.valueOf(e.wVm), Integer.valueOf(bVar.xem), Integer.valueOf(bVar.xeo), 0, Long.valueOf(System.currentTimeMillis()), 0, Long.valueOf(e.wVm));
        Log.i("MicroMsg.FTS.FTSReportLogic", "reportKvQuery %d %s", 16050, format);
        h.INSTANCE.kvStat(16050, format);
        AppMethodBeat.o(112015);
    }

    public static void a(a aVar, com.tencent.mm.plugin.fts.ui.c.b bVar) {
        int i2;
        String str;
        AppMethodBeat.i(112016);
        int i3 = 1;
        int i4 = aVar.wXL;
        int i5 = aVar.wXM;
        String str2 = aVar.wXN;
        long j2 = aVar.wXO;
        String bCR = aVar.bCR();
        int w = w(aVar.wXQ, aVar.wXR, aVar.dOL());
        if (aVar.rjr != -8) {
            switch (aVar.qcr) {
                case 1:
                    i2 = 3;
                    break;
                case 2:
                    i2 = 4;
                    break;
                case 3:
                    i2 = 10;
                    break;
                case 4:
                    i2 = 5;
                    break;
                case 5:
                    i2 = 11;
                    break;
                case 6:
                    i2 = 12;
                    break;
                case 7:
                    if (!aVar.wXP) {
                        i2 = 9;
                        break;
                    } else {
                        i2 = 8;
                        break;
                    }
                case 8:
                    if (aVar.rjr == -5) {
                        i2 = 16;
                        i3 = 2;
                        break;
                    } else if (aVar.rjr == -3) {
                        i2 = 4;
                        i3 = 2;
                        break;
                    } else if (aVar.rjr == -4) {
                        i2 = 3;
                        i3 = 2;
                        break;
                    } else if (aVar.rjr == -1) {
                        i2 = 12;
                        i3 = 2;
                        break;
                    } else if (aVar.rjr == -2) {
                        i2 = 11;
                        i3 = 2;
                        break;
                    } else if (aVar.rjr == -15) {
                        i2 = 21;
                        i3 = 2;
                        break;
                    } else if (aVar.rjr == -6) {
                        i2 = 10;
                        i3 = 2;
                        break;
                    } else if (aVar.rjr == -13) {
                        i2 = 19;
                        i3 = 2;
                        break;
                    } else if (aVar.rjr == -7) {
                        i2 = 5;
                        i3 = 2;
                        break;
                    } else if (aVar.rjr == -20) {
                        if (aVar.wXQ != 2) {
                            i2 = 25;
                            i3 = 2;
                            break;
                        } else {
                            i2 = 26;
                            i3 = 2;
                            break;
                        }
                    } else {
                        AppMethodBeat.o(112016);
                        return;
                    }
                case 9:
                    m mVar = new m();
                    String str3 = aVar.wWd.wWB;
                    if (str3 != null) {
                        str3 = str3.replaceAll(",", " ");
                    }
                    mVar.n("20KeyWordId", str3 + ",");
                    mVar.n("21ViewType", "1,");
                    mVar.n("22OpType", "2,");
                    mVar.n("23ResultCount", ",");
                    mVar.n("24ClickPos", aVar.wXM + ",");
                    mVar.n("25ClickAppUserName", aVar.info + ",");
                    Log.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", mVar.abW());
                    h.INSTANCE.a(13963, mVar);
                    i2 = 19;
                    break;
                case 10:
                    i2 = 20;
                    break;
                case 11:
                default:
                    AppMethodBeat.o(112016);
                    return;
                case 12:
                    i2 = 22;
                    break;
                case 13:
                    i2 = 21;
                    break;
                case 14:
                    if (aVar.wXQ != 2) {
                        i2 = 25;
                        break;
                    } else {
                        i2 = 26;
                        break;
                    }
            }
        } else {
            int i6 = 0;
            switch (aVar.qcr) {
                case 1:
                    i6 = 3;
                    break;
                case 2:
                    i6 = 4;
                    break;
                case 3:
                    i6 = 10;
                    break;
                case 4:
                    i6 = 5;
                    break;
                case 9:
                    i6 = 19;
                    break;
            }
            i2 = 2;
            bCR = i6 + "$" + bCR;
        }
        if (aVar instanceof q) {
            q qVar = (q) aVar;
            boolean Zx = qVar.contact.Zx();
            long j3 = qVar.lqW.timestamp / 1000;
            long j4 = qVar.lqW.wXe;
            az bjY = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(qVar.username);
            int i7 = 0;
            if (bjY != null) {
                i7 = bjY.field_unReadCount;
            } else {
                Log.w("MicroMsg.FTS.FTSReportLogic", "10991 conv null");
            }
            Object[] objArr = new Object[6];
            objArr[0] = Long.valueOf(j3);
            objArr[1] = 0;
            objArr[2] = Long.valueOf(j4);
            objArr[3] = Integer.valueOf(Zx ? 1 : 0);
            objArr[4] = Integer.valueOf(i7);
            objArr[5] = 0;
            str = String.format("%s,%s,%s,%s,%s,%s", objArr);
        } else {
            str = "0,0,0,0,0,0";
        }
        long currentTimeMillis = System.currentTimeMillis() - bVar.xeh;
        if (currentTimeMillis < 0 || bVar.xeh == 0) {
            currentTimeMillis = 0;
        }
        boolean z = !bVar.xeC.equals(aVar.wWd.wWB);
        Object[] objArr2 = new Object[46];
        objArr2[0] = Integer.valueOf(aVar.mve);
        objArr2[1] = Integer.valueOf(i2);
        objArr2[2] = Integer.valueOf(i4);
        objArr2[3] = Integer.valueOf(i3);
        objArr2[4] = Integer.valueOf(i5);
        objArr2[5] = Util.nullAs(str2, "");
        objArr2[6] = Long.valueOf(j2);
        objArr2[7] = Integer.valueOf(w);
        objArr2[8] = 0;
        objArr2[9] = Integer.valueOf(aVar.bCS());
        objArr2[10] = Integer.valueOf(Nt(aVar.dOK()));
        objArr2[11] = bCR;
        objArr2[12] = Long.valueOf(currentTimeMillis);
        objArr2[13] = Integer.valueOf(bVar.xel);
        objArr2[14] = Integer.valueOf(bVar.xem);
        objArr2[15] = Integer.valueOf(bVar.xen);
        objArr2[16] = Integer.valueOf(bVar.xeo);
        objArr2[17] = Integer.valueOf(bVar.xep);
        objArr2[18] = Integer.valueOf(bVar.favCount);
        objArr2[19] = 0;
        objArr2[20] = Integer.valueOf(bVar.xeq);
        objArr2[21] = Integer.valueOf(bVar.xer);
        objArr2[22] = Long.valueOf(e.wVm);
        objArr2[23] = aVar.wWd.wWB;
        objArr2[24] = 0;
        objArr2[25] = 0;
        objArr2[26] = Integer.valueOf(bVar.dPA());
        objArr2[27] = "";
        objArr2[28] = "";
        objArr2[29] = "";
        objArr2[30] = 1;
        objArr2[31] = Integer.valueOf(z ? 1 : 0);
        objArr2[32] = str;
        objArr2[33] = "";
        objArr2[34] = "";
        objArr2[35] = "";
        objArr2[36] = "";
        objArr2[37] = "";
        objArr2[38] = "";
        objArr2[39] = "";
        objArr2[40] = "";
        objArr2[41] = "";
        objArr2[42] = Long.valueOf(e.wVm);
        objArr2[43] = Long.valueOf(e.wVn);
        objArr2[44] = "";
        objArr2[45] = aVar.getAppId();
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", objArr2);
        Log.d("MicroMsg.FTS.FTSReportLogic", "10991 report home page click: %d, %s", 10991, format);
        h.INSTANCE.kvStat(10991, format);
        AppMethodBeat.o(112016);
    }

    public static void a(String str, int i2, int i3, com.tencent.mm.plugin.fts.ui.c.b bVar, int i4) {
        int i5;
        AppMethodBeat.i(112017);
        int i6 = i2 + 1;
        long currentTimeMillis = System.currentTimeMillis() - bVar.xeh;
        if (currentTimeMillis < 0 || bVar.xeh == 0) {
            currentTimeMillis = 0;
        }
        boolean z = !bVar.xeC.equals(str);
        Object[] objArr = new Object[46];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Integer.valueOf(i4);
        objArr[2] = Integer.valueOf(i6);
        objArr[3] = 0;
        objArr[4] = 0;
        objArr[5] = "";
        objArr[6] = "";
        objArr[7] = 0;
        objArr[8] = 0;
        objArr[9] = 0;
        objArr[10] = 0;
        objArr[11] = "";
        objArr[12] = Long.valueOf(currentTimeMillis);
        objArr[13] = Integer.valueOf(bVar.xel);
        objArr[14] = Integer.valueOf(bVar.xem);
        objArr[15] = Integer.valueOf(bVar.xen);
        objArr[16] = Integer.valueOf(bVar.xeo);
        objArr[17] = Integer.valueOf(bVar.xep);
        objArr[18] = Integer.valueOf(bVar.favCount);
        objArr[19] = 0;
        objArr[20] = Integer.valueOf(bVar.xeq);
        objArr[21] = Integer.valueOf(bVar.xer);
        objArr[22] = Long.valueOf(e.wVm);
        objArr[23] = str;
        objArr[24] = 0;
        objArr[25] = 0;
        objArr[26] = Integer.valueOf(bVar.dPA());
        objArr[27] = "";
        objArr[28] = "";
        objArr[29] = "";
        objArr[30] = 1;
        if (z) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        objArr[31] = Integer.valueOf(i5);
        objArr[32] = "0,0,0,0,0,0";
        objArr[33] = "";
        objArr[34] = "";
        objArr[35] = "";
        objArr[36] = "";
        objArr[37] = "";
        objArr[38] = "";
        objArr[39] = "";
        objArr[40] = "";
        objArr[41] = "";
        objArr[42] = Long.valueOf(e.wVm);
        objArr[43] = Long.valueOf(bVar.xej);
        objArr[44] = "";
        objArr[45] = "";
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
        Log.d("MicroMsg.FTS.FTSReportLogic", "10991 reportWebSearch click: %d, %s", 10991, format);
        h.INSTANCE.kvStat(10991, format);
        AppMethodBeat.o(112017);
    }

    private static int w(int i2, int i3, boolean z) {
        if (z) {
            return 15;
        }
        if (i2 == 131072) {
            switch (i3) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                case 9:
                case 10:
                case 12:
                case 13:
                case 14:
                default:
                    return 0;
                case 11:
                    return 8;
                case 15:
                    return 16;
                case 16:
                    return 10;
                case 17:
                case 18:
                    return 9;
            }
        } else if (i2 == 131075) {
            switch (i3) {
                case 1:
                case 5:
                    return 12;
                case 2:
                case 6:
                    return 13;
                case 3:
                case 7:
                    return 14;
                case 29:
                case 30:
                case 31:
                case 32:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                    return 11;
                default:
                    return 0;
            }
        } else if (i2 == 131081) {
            return 19;
        } else {
            if (i2 == 65536) {
                return 17;
            }
            return 0;
        }
    }

    private static int Nt(int i2) {
        switch (i2) {
            case 29:
                return 1;
            case 30:
                return 2;
            case 31:
                return 3;
            case 32:
                return 4;
            case 33:
            default:
                return 0;
            case 34:
                return 5;
            case 35:
            case 36:
                return 6;
            case 37:
                return 16;
        }
    }

    public static void a(a aVar, com.tencent.mm.plugin.fts.ui.c.a aVar2) {
        int i2;
        String str;
        AppMethodBeat.i(112018);
        int i3 = aVar.wXL;
        String str2 = aVar.wXN;
        long j2 = aVar.wXO;
        int w = w(aVar.wXQ, aVar.wXR, aVar.dOL());
        switch (aVar.qcr) {
            case 1:
                i2 = 3;
                break;
            case 2:
                i2 = 4;
                break;
            case 3:
                i2 = 10;
                break;
            case 4:
                i2 = 5;
                break;
            case 5:
                i2 = 11;
                break;
            case 6:
                i2 = 12;
                break;
            case 7:
            case 8:
            case 11:
            case 12:
            default:
                AppMethodBeat.o(112018);
                return;
            case 9:
                m mVar = new m();
                String str3 = aVar.wWd.wWB;
                if (str3 != null) {
                    str3 = str3.replaceAll(",", " ");
                }
                mVar.n("20KeyWordId", str3 + ",");
                mVar.n("21ViewType", "2,");
                mVar.n("22OpType", "2,");
                mVar.n("23ResultCount", ",");
                mVar.n("24ClickPos", aVar.wXM + ",");
                mVar.n("25ClickAppUserName", aVar.info + ",");
                Log.i("MicroMsg.FTS.FTSReportLogic", "report oreh LocalSearchWeApp(13963), %s", mVar.abW());
                h.INSTANCE.a(13963, mVar);
                i2 = 19;
                break;
            case 10:
                i2 = 20;
                break;
            case 13:
                i2 = 21;
                break;
        }
        if (aVar instanceof q) {
            q qVar = (q) aVar;
            boolean Zx = qVar.contact.Zx();
            long j3 = qVar.lqW.timestamp / 1000;
            long j4 = qVar.lqW.wXe;
            az bjY = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(qVar.username);
            int i4 = 0;
            if (bjY != null) {
                i4 = bjY.field_unReadCount;
            } else {
                Log.w("MicroMsg.FTS.FTSReportLogic", "11310 conv null");
            }
            Object[] objArr = new Object[6];
            objArr[0] = Long.valueOf(j3);
            objArr[1] = 0;
            objArr[2] = Long.valueOf(j4);
            objArr[3] = Integer.valueOf(Zx ? 1 : 0);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = 0;
            str = String.format("%s,%s,%s,%s,%s,%s", objArr);
        } else {
            str = "0,0,0,0,0,0";
        }
        long currentTimeMillis = System.currentTimeMillis() - aVar2.xeh;
        if (currentTimeMillis < 0 || aVar2.xeh == 0) {
            currentTimeMillis = 0;
        }
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", Integer.valueOf(aVar.mve), Integer.valueOf(i2), Integer.valueOf(i3), Util.nullAs(str2, ""), Long.valueOf(j2), Integer.valueOf(w), Integer.valueOf(aVar.bCS()), Integer.valueOf(Nt(aVar.dOK())), aVar.bCR(), Long.valueOf(currentTimeMillis), Integer.valueOf(aVar2.xei), str, "", "", "", "", "", "", "", "", "", Long.valueOf(e.wVm), Long.valueOf(aVar2.xej));
        Log.d("MicroMsg.FTS.FTSReportLogic", "report detail page click 11310: %s", format);
        h.INSTANCE.kvStat(11310, format);
        AppMethodBeat.o(112018);
    }

    public static final void pv(boolean z) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(112019);
        Object[] objArr = new Object[2];
        objArr[0] = 13970;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[1] = Integer.valueOf(i2);
        Log.v("MicroMsg.FTS.FTSReportLogic", "reportFTSCreateChatroom: %d %d", objArr);
        h hVar = h.INSTANCE;
        Object[] objArr2 = new Object[1];
        if (!z) {
            i3 = 0;
        }
        objArr2[0] = Integer.valueOf(i3);
        hVar.a(13970, objArr2);
        AppMethodBeat.o(112019);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int a(com.tencent.mm.plugin.fts.a.d.a.a r9) {
        /*
        // Method dump skipped, instructions count: 210
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.ui.l.a(com.tencent.mm.plugin.fts.a.d.a.a):int");
    }

    public static final void a(String str, int i2, int i3, int i4, com.tencent.mm.plugin.fts.ui.c.b bVar, int i5, String str2, String str3, String str4) {
        int i6;
        AppMethodBeat.i(112020);
        long currentTimeMillis = System.currentTimeMillis() - bVar.xeh;
        if (currentTimeMillis < 0 || bVar.xeh == 0) {
            currentTimeMillis = 0;
        }
        boolean z = !bVar.xeC.equals(str);
        Object[] objArr = new Object[46];
        objArr[0] = Integer.valueOf(i4);
        objArr[1] = Integer.valueOf(i5);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = 0;
        objArr[5] = "";
        objArr[6] = "";
        objArr[7] = 0;
        objArr[8] = 0;
        objArr[9] = 0;
        objArr[10] = 0;
        objArr[11] = str2;
        objArr[12] = Long.valueOf(currentTimeMillis);
        objArr[13] = Integer.valueOf(bVar.xel);
        objArr[14] = Integer.valueOf(bVar.xem);
        objArr[15] = Integer.valueOf(bVar.xen);
        objArr[16] = Integer.valueOf(bVar.xeo);
        objArr[17] = Integer.valueOf(bVar.xep);
        objArr[18] = Integer.valueOf(bVar.favCount);
        objArr[19] = 0;
        objArr[20] = Integer.valueOf(bVar.xeq);
        objArr[21] = Integer.valueOf(bVar.xer);
        objArr[22] = Long.valueOf(e.wVm);
        objArr[23] = str;
        objArr[24] = 0;
        objArr[25] = 0;
        objArr[26] = Integer.valueOf(bVar.dPA());
        objArr[27] = "";
        objArr[28] = "";
        objArr[29] = "";
        objArr[30] = 1;
        if (z) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        objArr[31] = Integer.valueOf(i6);
        objArr[32] = "0,0,0,0,0,0";
        objArr[33] = "";
        objArr[34] = "";
        objArr[35] = "";
        objArr[36] = "";
        objArr[37] = "";
        objArr[38] = "";
        objArr[39] = "";
        objArr[40] = "";
        objArr[41] = "";
        objArr[42] = Long.valueOf(e.wVm);
        objArr[43] = Long.valueOf(bVar.xej);
        objArr[44] = str3;
        objArr[45] = str4;
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
        Log.d("MicroMsg.FTS.FTSReportLogic", "10991 reportPardusResultClick click: %d, %s", 10991, format);
        h.INSTANCE.kvStat(10991, format);
        AppMethodBeat.o(112020);
    }

    public static String ayQ(String str) {
        AppMethodBeat.i(112022);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(112022);
            return "";
        }
        String replaceAll = str.replaceAll("<em class=\"highlight\">", "").replaceAll("</em>", "");
        AppMethodBeat.o(112022);
        return replaceAll;
    }

    public static void N(long j2, int i2) {
        AppMethodBeat.i(112023);
        Log.d("MicroMsg.FTS.FTSReportLogic", "reportWebSearchPardusStatus 18201 %s %d", Long.valueOf(j2), Integer.valueOf(i2));
        com.tencent.mm.plugin.report.e.INSTANCE.a(18201, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(112023);
    }
}
