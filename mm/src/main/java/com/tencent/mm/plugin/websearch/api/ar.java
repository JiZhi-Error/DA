package com.tencent.mm.plugin.websearch.api;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.g.b.a.eo;
import com.tencent.mm.g.b.a.er;
import com.tencent.mm.g.b.a.nh;
import com.tencent.mm.g.b.a.nm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class ar {
    private static a IFr = new a();

    public static class a {
        int IEj;
        long IFs;
        long IFt;
        long dtZ;
        int scene;
        boolean vtY = true;
        long zMI;
    }

    public static void cN(int i2, String str) {
        AppMethodBeat.i(117765);
        e.INSTANCE.kvStat(i2, str);
        AppMethodBeat.o(117765);
    }

    public static void a(int i2, String str, boolean z, boolean z2, int i3) {
        int i4;
        AppMethodBeat.i(117766);
        if (z) {
            i4 = 3;
        } else if (z2) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        e.INSTANCE.a(12042, Integer.valueOf(i2), 1, Integer.valueOf(i4), Integer.valueOf(i3), Util.nullAs(str, "").replace(",", " "));
        AppMethodBeat.o(117766);
    }

    static {
        AppMethodBeat.i(117790);
        AppMethodBeat.o(117790);
    }

    public static void afz(int i2) {
        AppMethodBeat.i(117767);
        IFr.scene = i2;
        IFr.IEj = 1;
        IFr.IFs = System.currentTimeMillis();
        IFr.IFt = 0;
        IFr.zMI = System.currentTimeMillis();
        IFr.dtZ = 0;
        IFr.vtY = false;
        Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "initReport %d %d", Integer.valueOf(i2), 1);
        AppMethodBeat.o(117767);
    }

    public static void fYm() {
        AppMethodBeat.i(117768);
        IFr.IFs = System.currentTimeMillis();
        Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "startH5Report %s", Long.valueOf(IFr.IFs));
        AppMethodBeat.o(117768);
    }

    public static void fYn() {
        AppMethodBeat.i(117769);
        IFr.IFt += System.currentTimeMillis() - IFr.IFs;
        Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopH5Report %s", Long.valueOf(IFr.IFt));
        AppMethodBeat.o(117769);
    }

    public static void fYo() {
        AppMethodBeat.i(117770);
        IFr.dtZ += System.currentTimeMillis() - IFr.zMI;
        Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "stopTotalReport %s", Long.valueOf(IFr.dtZ));
        AppMethodBeat.o(117770);
    }

    public static void fYp() {
        AppMethodBeat.i(117771);
        a aVar = IFr;
        if (!aVar.vtY) {
            e.INSTANCE.a(12044, Integer.valueOf(aVar.scene), Integer.valueOf(aVar.IEj), Long.valueOf(aVar.IFt / 1000), Long.valueOf(aVar.dtZ / 1000));
            aVar.vtY = true;
        }
        Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportTime");
        AppMethodBeat.o(117771);
    }

    public static void afA(int i2) {
        AppMethodBeat.i(117772);
        Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchVisit %d", Integer.valueOf(i2));
        e.INSTANCE.a(12041, Integer.valueOf(i2), Integer.valueOf(ai.aft(0)));
        AppMethodBeat.o(117772);
    }

    public static void a(int i2, int i3, String str, int i4, int i5, String str2, int i6) {
        AppMethodBeat.i(117773);
        Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), str2, Integer.valueOf(i6));
        e.INSTANCE.a(12098, Integer.valueOf(i2), Integer.valueOf(ai.aft(0)), Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i5), str2, Integer.valueOf(i6));
        AppMethodBeat.o(117773);
    }

    public static void q(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(117774);
        er erVar = new er();
        erVar.eqv = erVar.x("Query", str.replace(',', ' '), true);
        erVar.eEp = (long) i2;
        erVar.esI = (long) i3;
        erVar.erW = (long) i4;
        erVar.eEq = 0;
        erVar.bfK();
        Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "report12639 %s", erVar.abW().replace(APLogFileUtil.SEPARATOR_LINE, " "));
        AppMethodBeat.o(117774);
    }

    public static void N(int i2, int i3, String str) {
        AppMethodBeat.i(117775);
        b(i2, i3, str, "", "");
        AppMethodBeat.o(117775);
    }

    public static void b(int i2, int i3, String str, String str2, String str3) {
        AppMethodBeat.i(258825);
        Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportGlobalTabClick type:%s, scene:%s, searchId:%s, isTabGuide:%s,sessionId:%s, redDotMsgId:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.FALSE, str2, str3);
        e.INSTANCE.a(12845, Integer.valueOf(i2), 0, Integer.valueOf(i3), str, 0, str2, str3);
        AppMethodBeat.o(258825);
    }

    public static void jU(String str, String str2) {
        AppMethodBeat.i(258826);
        Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "kvReportFTSExpose sessionId:%s, exposeInfo:%s", str, str2);
        e.INSTANCE.a(22369, str, str2);
        AppMethodBeat.o(258826);
    }

    public static void cO(int i2, String str) {
        AppMethodBeat.i(117777);
        e.INSTANCE.a(12070, Integer.valueOf(i2), Integer.valueOf(ai.aft(0)), str, 4, 0, "", 1, 0);
        AppMethodBeat.o(117777);
    }

    public static void h(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(117778);
        e.INSTANCE.a(13809, Integer.valueOf(i2), str, str2, 0, Integer.valueOf(i3));
        AppMethodBeat.o(117778);
    }

    public static void a(int i2, String str, String str2, int i3, int i4, int i5) {
        AppMethodBeat.i(117779);
        e.INSTANCE.a(13810, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Integer.valueOf(i4), 0, Integer.valueOf(i5));
        AppMethodBeat.o(117779);
    }

    public static final void afB(int i2) {
        AppMethodBeat.i(117780);
        Log.v("MicroMsg.WebSearch.WebSearchReportLogic", "reportIdKey649 %d", Integer.valueOf(i2));
        e.INSTANCE.idkeyStat(649, (long) i2, 1, true);
        AppMethodBeat.o(117780);
    }

    public static final void kb(int i2, int i3) {
        AppMethodBeat.i(117781);
        if (i2 == 21) {
            e.INSTANCE.idkeyStat(649, (long) i3, 1, true);
        }
        AppMethodBeat.o(117781);
    }

    public static void kc(int i2, int i3) {
        AppMethodBeat.i(117782);
        O(i2, i3, "");
        AppMethodBeat.o(117782);
    }

    public static void O(int i2, int i3, String str) {
        AppMethodBeat.i(117783);
        a(i2, i3, 0, 0, str);
        AppMethodBeat.o(117783);
    }

    public static void aK(int i2, int i3, int i4) {
        AppMethodBeat.i(117784);
        a(i2, 3, i3, i4, "");
        AppMethodBeat.o(117784);
    }

    public static void a(int i2, int i3, int i4, int i5, String str) {
        int aft;
        AppMethodBeat.i(117785);
        if (i2 == 21) {
            aft = ai.aft(1);
        } else {
            aft = ai.aft(0);
        }
        e.INSTANCE.a(14457, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(aft), Integer.valueOf(i4), Integer.valueOf(i5), str);
        AppMethodBeat.o(117785);
    }

    public static void a(eiq eiq, int i2, int i3, int i4, long j2, String str) {
        char c2;
        int i5;
        AppMethodBeat.i(117787);
        if (eiq == null) {
            eiq = new eiq();
            eiq.msgId = "";
            eiq.NhO = 0;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("reddotreport=1");
        stringBuffer.append("&reddotid=");
        stringBuffer.append(Util.nullAsNil(eiq.msgId));
        stringBuffer.append("&reddotts=");
        stringBuffer.append(eiq.NhO);
        stringBuffer.append("&nettype=");
        stringBuffer.append(ai.ait());
        stringBuffer.append("&optype=");
        stringBuffer.append(i2);
        stringBuffer.append("&reddottype=");
        stringBuffer.append(i3);
        stringBuffer.append("&reddotcnt=");
        stringBuffer.append(i4);
        stringBuffer.append("&reddotconsumets=");
        stringBuffer.append(j2);
        stringBuffer.append("&notshowreason=");
        stringBuffer.append(str);
        stringBuffer.append("&reddotseq=");
        stringBuffer.append(eiq.jlm);
        if (i2 == 100 || i2 == 101 || i2 == 102 || i2 == 108) {
            if (!Util.isNullOrNil((String) g.aAh().azQ().get(68377, (Object) null))) {
                c2 = 1;
            } else {
                c2 = 0;
            }
            if (o.DCO != null) {
                i5 = o.DCO.ctM();
            } else {
                i5 = 0;
            }
            if (i5 > 0) {
                stringBuffer.append("&snsreddottype=2&snsreddotcnt=").append(i5);
            } else if (c2 > 0) {
                stringBuffer.append("&snsreddottype=1&snsreddotcnt=0");
            } else {
                stringBuffer.append("&snsreddottype=0&snsreddotcnt=0");
            }
        }
        Log.i("MicroMsg.TopStory", "reportTopStoryRedDot 16399 %s", stringBuffer.toString());
        doc doc = new doc();
        doc.MRe = stringBuffer.toString();
        g.azz().a(new ad(doc), 0);
        AppMethodBeat.o(117787);
    }

    public static void b(int i2, int i3, String str, String str2, boolean z) {
        AppMethodBeat.i(117788);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("recnondocreport=1");
        stringBuffer.append("&type=51");
        stringBuffer.append("&content=");
        stringBuffer.append(i2).append("|").append(i3).append("|").append(Util.nullAsNil(str)).append("|").append(z ? 1 : 0);
        stringBuffer.append("&searchid=");
        stringBuffer.append(Util.nullAsNil(str2));
        Log.i("MicroMsg.TopStory", "reportTopStoryRedDot 14791 %s", stringBuffer.toString());
        doc doc = new doc();
        doc.MRe = stringBuffer.toString();
        g.azz().a(new ad(doc), 0);
        AppMethodBeat.o(117788);
    }

    public static void a(String str, long j2, int i2, int i3, String str2, int i4) {
        char c2;
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(117789);
        if (!Util.isNullOrNil((String) g.aAh().azQ().get(68377, (Object) null))) {
            c2 = 1;
        } else {
            c2 = 0;
        }
        if (o.DCO != null) {
            i5 = o.DCO.ctM();
        } else {
            i5 = 0;
        }
        if (i5 > 0) {
            i7 = 2;
            i6 = i5;
        } else if (c2 > 0) {
            i6 = 0;
            i7 = 1;
        } else {
            i6 = 0;
            i7 = 0;
        }
        String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", str, Long.valueOf(j2), ai.ait(), 201, Integer.valueOf(i2), Integer.valueOf(i3), 0L, str2, Integer.valueOf(i7), Integer.valueOf(i6), Integer.valueOf(i4));
        Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "reportTopStoryRedDotKv 16654: ".concat(String.valueOf(format)));
        e.INSTANCE.kvStat(16654, format);
        AppMethodBeat.o(117789);
    }

    public static void a(int i2, String str, int i3, int i4, String str2, String str3, String str4, int i5, String str5, long j2, long j3) {
        AppMethodBeat.i(187864);
        eo eoVar = new eo();
        eoVar.ejA = (long) i2;
        eoVar.eno = eoVar.x("RequestId", str, true);
        eoVar.erW = (long) i3;
        eoVar.eDQ = (long) i4;
        eoVar.eDR = eoVar.x("HitWordList", str2, true);
        eoVar.eDS = eoVar.x("HitWordVersion", str3, true);
        eoVar.enr = eoVar.x("MsgId", str4, true);
        eoVar.ens = eoVar.x("MsgFromUsername", "", true);
        eoVar.eDT = (long) i5;
        eoVar.enu = eoVar.x("ChatRoomID", str5, true);
        eoVar.eiR = j2;
        eoVar.eDU = j3;
        eoVar.bfK();
        a(eoVar);
        AppMethodBeat.o(187864);
    }

    public static void o(long j2, long j3, long j4) {
        AppMethodBeat.i(187865);
        nm nmVar = new nm();
        nmVar.fgG = j2;
        nmVar.eiR = j3;
        nmVar.erY = j4;
        nmVar.bfK();
        a(nmVar);
        AppMethodBeat.o(187865);
    }

    public static void afC(final int i2) {
        AppMethodBeat.i(187866);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.websearch.api.ar.AnonymousClass1 */

            public final void run() {
                int i2 = 0;
                AppMethodBeat.i(187863);
                int[] iArr = {1, 0, 5, 6, 3};
                if (i2 == -1) {
                    if (cl.aWA() - g.aAh().azQ().a(ar.a.USERINFO_LAST_REPORT_H5VERSION_TIME_LONG, 0) > Util.MILLSECONDS_OF_DAY) {
                        while (i2 < 5) {
                            nh nhVar = new nh();
                            nhVar.erY = (long) (i2 + 1);
                            nhVar.fgr = (long) ai.aft(iArr[i2]);
                            nhVar.bfK();
                            ar.a(nhVar);
                            i2++;
                        }
                        g.aAh().azQ().set(ar.a.USERINFO_LAST_REPORT_H5VERSION_TIME_LONG, Long.valueOf(cl.aWA()));
                    }
                    AppMethodBeat.o(187863);
                    return;
                }
                while (i2 < 5) {
                    if (iArr[i2] == i2) {
                        nh nhVar2 = new nh();
                        nhVar2.erY = (long) (i2 + 1);
                        nhVar2.fgr = (long) ai.aft(iArr[i2]);
                        nhVar2.bfK();
                        ar.a(nhVar2);
                        AppMethodBeat.o(187863);
                        return;
                    }
                    i2++;
                }
                AppMethodBeat.o(187863);
            }
        }, "WebSearchThread");
        AppMethodBeat.o(187866);
    }

    public static void a(com.tencent.mm.plugin.report.a aVar) {
        AppMethodBeat.i(187867);
        Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "report%s %s", Integer.valueOf(aVar.getId()), aVar.abW().replace(APLogFileUtil.SEPARATOR_LINE, " "));
        AppMethodBeat.o(187867);
    }
}
