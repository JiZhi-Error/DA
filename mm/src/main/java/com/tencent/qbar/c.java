package com.tencent.qbar;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.WxQbarNative;
import java.util.Iterator;
import java.util.List;

public final class c {
    public static int RJA = 2;
    public static int RJB = 1;
    public static int RJC = 2;
    public static int RJD = 3;
    public static c RJE = new c();
    public static c RJF = new c();
    public static int RJy = 0;
    public static int RJz = 1;
    private Object CCt = new Object();
    public long CHf = 0;
    private boolean CHh = false;
    private int Cpn = -1;
    private long RJG = 0;
    public int RJH = 0;
    private long RJI = 0;
    private Point RJJ = null;
    private String RJK;
    private String RJL;
    private String RJM;
    private int RJN;
    private String RJO;
    private int RJP;
    private int RJQ = 0;
    private int RJR;
    public int RJS = 0;
    public float RJT = 1.0f;
    public long RJU = 0;
    int RJV = 0;
    boolean RJW;
    private List<QbarNative.QBarCodeDetectInfo> RJX;
    private int RJY = 0;
    private int RJZ = 0;
    private int dBa = 0;
    private int dLS = 0;
    public float decodeScale;
    public int detectTime;
    private int pyramidLv;
    private int retryCount = 0;
    public String scaleList;
    public int srTime;
    private boolean vtY = false;

    public c() {
        AppMethodBeat.i(91141);
        AppMethodBeat.o(91141);
    }

    static {
        AppMethodBeat.i(91151);
        AppMethodBeat.o(91151);
    }

    public final void Ov(long j2) {
        AppMethodBeat.i(91142);
        Log.i("MicroMsg.QBarEngineReporter", "addScanTime: %s", Long.valueOf(j2));
        this.RJG += j2;
        AppMethodBeat.o(91142);
    }

    public final void hkg() {
        AppMethodBeat.i(91143);
        Log.i("MicroMsg.QBarEngineReporter", "markScanSuccess");
        this.CHh = true;
        AppMethodBeat.o(91143);
    }

    public final void hkh() {
        AppMethodBeat.i(91144);
        Log.i("MicroMsg.QBarEngineReporter", "addScanFrame, current scan frame: %s", Integer.valueOf(this.RJH));
        this.RJH++;
        AppMethodBeat.o(91144);
    }

    public final void aqw(int i2) {
        AppMethodBeat.i(91145);
        Log.i("MicroMsg.QBarEngineReporter", "setScanScene, scene: %s", Integer.valueOf(i2));
        this.Cpn = i2;
        AppMethodBeat.o(91145);
    }

    public final void mr(int i2, int i3) {
        AppMethodBeat.i(91146);
        Log.i("MicroMsg.QBarEngineReporter", "setScanResolution, width: %s, height: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.RJJ = new Point(i2, i3);
        AppMethodBeat.o(91146);
    }

    public final void Ow(long j2) {
        AppMethodBeat.i(91147);
        Log.i("MicroMsg.QBarEngineReporter", "setScanSuccessTime: %s,", Long.valueOf(j2));
        this.RJI = j2;
        AppMethodBeat.o(91147);
    }

    public final void a(String str, String str2, String str3, WxQbarNative.QBarReportMsg qBarReportMsg, int i2, List<WxQbarNative.QBarReportMsg> list) {
        AppMethodBeat.i(91148);
        this.RJK = str;
        this.RJL = str2;
        this.RJM = str3;
        this.dBa = i2;
        this.RJP = 0;
        if (qBarReportMsg != null) {
            this.RJN = qBarReportMsg.qrcodeVersion;
            this.pyramidLv = qBarReportMsg.pyramidLv;
            this.RJO = qBarReportMsg.binaryMethod;
            this.scaleList = qBarReportMsg.scaleList;
            this.decodeScale = qBarReportMsg.decodeScale;
            this.detectTime = qBarReportMsg.detectTime;
            this.srTime = qBarReportMsg.srTime;
        }
        this.RJY = 0;
        this.RJZ = 0;
        if (list != null) {
            for (WxQbarNative.QBarReportMsg qBarReportMsg2 : list) {
                if (qBarReportMsg2.inWhiteList) {
                    this.RJY++;
                } else if (qBarReportMsg2.inBlackList) {
                    this.RJZ++;
                }
            }
        }
        Log.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s, resultSize %d, isFilterResult %d,scaleList %s,decodeScale %f,detectTime %d,srTime %d, whiteListHit %d, blackListHit %d", str, str2, str3, Integer.valueOf(this.RJN), Integer.valueOf(this.pyramidLv), this.RJO, Integer.valueOf(i2), 0, this.scaleList, Float.valueOf(this.decodeScale), Integer.valueOf(this.detectTime), Integer.valueOf(this.srTime), Integer.valueOf(this.RJY), Integer.valueOf(this.RJZ));
        AppMethodBeat.o(91148);
    }

    public final void aqx(int i2) {
        if (this.RJR != 2) {
            this.RJR = i2;
        }
    }

    public final void setTabType(int i2) {
        AppMethodBeat.i(176205);
        Log.i("MicroMsg.QBarEngineReporter", "alvinluo setReportTabType tabType: %d", Integer.valueOf(i2));
        this.dLS = i2;
        AppMethodBeat.o(176205);
    }

    public final void bUV() {
        String str;
        int i2;
        String str2;
        int i3;
        AppMethodBeat.i(91149);
        synchronized (this.CCt) {
            try {
                if (this.vtY) {
                    Log.i("MicroMsg.QBarEngineReporter", "doReport, already report");
                    return;
                }
                Object[] objArr = new Object[21];
                objArr[0] = Integer.valueOf(this.RJH);
                objArr[1] = Long.valueOf(this.RJG);
                objArr[2] = Long.valueOf(this.RJI);
                objArr[3] = Integer.valueOf(this.Cpn);
                objArr[4] = this.RJJ;
                objArr[5] = Integer.valueOf(this.retryCount);
                objArr[6] = Boolean.valueOf(this.CHh);
                objArr[7] = this.RJK;
                objArr[8] = this.RJL;
                objArr[9] = this.RJM;
                objArr[10] = Integer.valueOf(this.RJN);
                objArr[11] = Integer.valueOf(this.pyramidLv);
                objArr[12] = this.RJO;
                objArr[13] = Integer.valueOf(!Util.isNullOrNil(this.RJL) ? this.RJL.length() : 0);
                objArr[14] = new StringBuilder().append(this.RJQ).toString();
                objArr[15] = Integer.valueOf(this.RJR);
                objArr[16] = Integer.valueOf(this.dLS);
                objArr[17] = Integer.valueOf(this.RJS);
                objArr[18] = Long.valueOf(this.RJU);
                objArr[19] = Float.valueOf(this.RJT);
                objArr[20] = Integer.valueOf(this.RJV);
                Log.i("MicroMsg.QBarEngineReporter", "doReport, scanTotalFrames: %s, totalScanTime: %s, scanSuccessTime: %s, scanScene: %s, scanResolution: %s, retryCount: %s, scanSuccess: %s, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s,dataContentLen: %d,zoomLog: %s,lightMode: %d, tabType: %d,zoomCount: %s, zoomLastCostTime: %s, totalZoomFactor: %s, waitingFrame: %s", objArr);
                if (this.RJJ != null) {
                    str = this.RJJ.x + "x" + this.RJJ.y;
                } else {
                    str = "";
                }
                String str3 = "";
                if (!this.CHh && this.RJX != null) {
                    i2 = this.RJX.size();
                    Log.i("MicroMsg.QBarEngineReporter", "doReport possibleResults %d", Integer.valueOf(i2));
                    Iterator<QbarNative.QBarCodeDetectInfo> it = this.RJX.iterator();
                    int i4 = 0;
                    while (true) {
                        str2 = str3;
                        if (!it.hasNext()) {
                            break;
                        }
                        QbarNative.QBarCodeDetectInfo next = it.next();
                        if (i4 < this.RJX.size() - 1) {
                            str3 = str2 + next.prob + "|";
                        } else {
                            str3 = str2 + next.prob;
                        }
                        i4++;
                    }
                } else {
                    str2 = str3;
                    i2 = 0;
                }
                h hVar = h.INSTANCE;
                Object[] objArr2 = new Object[35];
                objArr2[0] = Integer.valueOf(this.RJH);
                objArr2[1] = Long.valueOf(this.RJG);
                objArr2[2] = Long.valueOf(this.RJI);
                objArr2[3] = Integer.valueOf(this.Cpn);
                objArr2[4] = str;
                objArr2[5] = Integer.valueOf(this.retryCount);
                objArr2[6] = Integer.valueOf(this.CHh ? 0 : 1);
                objArr2[7] = this.RJK;
                objArr2[8] = "";
                objArr2[9] = this.RJM;
                objArr2[10] = Integer.valueOf(this.RJN);
                objArr2[11] = Integer.valueOf(this.pyramidLv);
                objArr2[12] = this.RJO;
                if (!Util.isNullOrNil(this.RJL)) {
                    i3 = this.RJL.length();
                } else {
                    i3 = 0;
                }
                objArr2[13] = Integer.valueOf(i3);
                objArr2[14] = new StringBuilder().append(this.RJQ).toString();
                objArr2[15] = Integer.valueOf(this.RJR);
                objArr2[16] = Integer.valueOf(this.RJW ? 1 : 0);
                objArr2[17] = 0;
                objArr2[18] = a.getVersion();
                objArr2[19] = Integer.valueOf(this.dBa);
                objArr2[20] = Integer.valueOf(this.RJP);
                objArr2[21] = Integer.valueOf(i2);
                objArr2[22] = str2;
                objArr2[23] = this.scaleList;
                objArr2[24] = Integer.valueOf((int) (this.decodeScale * 10.0f));
                objArr2[25] = Integer.valueOf(this.detectTime);
                objArr2[26] = Integer.valueOf(this.srTime);
                objArr2[27] = Integer.valueOf(this.RJY);
                objArr2[28] = Integer.valueOf(this.RJZ);
                objArr2[29] = Integer.valueOf(this.dLS);
                objArr2[30] = Integer.valueOf(this.dBa);
                objArr2[31] = Integer.valueOf(this.RJS);
                objArr2[32] = Long.valueOf(this.RJU);
                objArr2[33] = Integer.valueOf((int) (this.RJT * 100.0f));
                objArr2[34] = Integer.valueOf(this.RJV);
                hVar.a(13233, objArr2);
                this.vtY = true;
                AppMethodBeat.o(91149);
            } finally {
                AppMethodBeat.o(91149);
            }
        }
    }

    public final void reset() {
        AppMethodBeat.i(91150);
        synchronized (this.CCt) {
            try {
                this.RJG = 0;
                this.CHh = false;
                this.RJH = 0;
                this.Cpn = -1;
                this.RJJ = null;
                this.retryCount = 0;
                this.RJK = "";
                this.RJL = "";
                this.RJM = "";
                this.RJN = 0;
                this.pyramidLv = 0;
                this.RJO = "";
                this.RJI = 0;
                this.vtY = false;
                this.RJQ = 0;
                this.RJR = 0;
                this.RJW = false;
                this.dBa = 0;
                this.RJP = 0;
                this.RJX = null;
                this.scaleList = "";
                this.decodeScale = 0.0f;
                this.detectTime = 0;
                this.srTime = 0;
                this.RJY = 0;
                this.RJZ = 0;
                this.dLS = 0;
                this.CHf = 0;
                this.RJS = 0;
                this.RJU = 0;
                this.RJV = 0;
                Log.i("MicroMsg.QBarEngineReporter", "reset");
            } finally {
                AppMethodBeat.o(91150);
            }
        }
    }
}
