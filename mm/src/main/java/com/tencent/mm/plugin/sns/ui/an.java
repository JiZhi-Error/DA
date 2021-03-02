package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.g.b.a.iq;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;

public final class an {
    HashMap<String, Integer> Euo = null;
    j Eup;
    a Euq;
    int Eur;
    private int Eus = 0;
    long Eut;
    private long Euu;
    private long Euv;
    private int Euw;
    private b Eux;
    private final Object Euy = new Object();
    final String TAG = ("MicroMsg.OnlineVideoViewHelper[" + hashCode() + ']');
    private boolean clear = false;
    private String dHp;
    private cnb ebR;
    long gqR;
    private int iXu;
    int jcu;
    String jpT;
    String jpU;
    int jpV = 0;
    int jpW = 0;
    int jpY;
    int jpZ;
    boolean jqb;
    int jqc = 0;
    private int jqd;
    boolean jqe = false;
    boolean jqf = false;
    int progress;

    public interface a {
        void Zz(int i2);

        void aT(int i2, boolean z);

        void bgW();

        void cq(String str, boolean z);

        boolean fgn();

        int getPlayErrorCode();

        int getPlayVideoDuration();

        int getPlayVideoDurationByResume();

        c getRptStruct();

        int getUiStayTime();
    }

    public static class c {
        public long EtT = 0;
        public String dRP = "";
        public String dRS = "";
        public String filePath = "";
        public int scene = 0;
        public String sessionId = "";
    }

    /* access modifiers changed from: package-private */
    public static class b {
        int EuA;
        int jqm;
        int jqn;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public an(a aVar) {
        AppMethodBeat.i(98119);
        this.Euq = aVar;
        this.Eup = new j();
        this.Euo = new HashMap<>();
        this.Eux = new b((byte) 0);
        this.Eux.jqm = h.aqJ().getInt("SnsVideoPreloadSec", 5);
        this.Eux.jqn = h.aqJ().getInt("SnsVideoDownloadSec", 1);
        this.Eux.EuA = h.aqJ().getInt("SnsVideoFullDownloadPercent", 101);
        Log.i(this.TAG, "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", Integer.valueOf(this.Eux.jqm), Integer.valueOf(this.Eux.jqn), Integer.valueOf(this.Eux.EuA));
        reset();
        this.clear = false;
        AppMethodBeat.o(98119);
    }

    public final void clear() {
        AppMethodBeat.i(98120);
        Log.i(this.TAG, "clear");
        this.clear = true;
        reset();
        synchronized (this.Euy) {
            try {
                this.Euq = null;
            } catch (Throwable th) {
                AppMethodBeat.o(98120);
                throw th;
            }
        }
        this.Eup = null;
        AppMethodBeat.o(98120);
    }

    private void reset() {
        AppMethodBeat.i(98121);
        this.jpT = "";
        this.jpZ = -1;
        this.jqc = 0;
        this.jpY = 0;
        this.Eus = 0;
        this.jpW = 0;
        this.jpV = 0;
        this.jqb = false;
        this.jqe = false;
        this.jqf = false;
        this.Euo.clear();
        this.ebR = null;
        this.iXu = 0;
        this.dHp = null;
        if (this.Eux != null) {
            this.jqd = this.Eux.jqm;
        }
        this.Eut = 0;
        this.gqR = 0;
        this.Euw = 0;
        this.Euv = 0;
        this.Euu = 0;
        AppMethodBeat.o(98121);
    }

    public final boolean a(cnb cnb, int i2, String str, boolean z, int i3) {
        AppMethodBeat.i(98122);
        if (this.clear) {
            AppMethodBeat.o(98122);
            return false;
        }
        this.ebR = cnb;
        this.iXu = i2;
        this.dHp = str;
        this.jpU = ay.E(cnb);
        this.jpT = ay.cs(i2, cnb.Url);
        if (Util.isNullOrNil(this.jpU) || Util.isNullOrNil(this.jpT)) {
            AppMethodBeat.o(98122);
            return false;
        }
        Log.i(this.TAG, "start online download video %s isPlayMode %b", this.jpT, Boolean.valueOf(z));
        aj.faM().a(cnb, i2, str, z, true, i3);
        this.jpV = 1;
        this.gqR = Util.nowMilliSecond();
        vn(z);
        AppMethodBeat.o(98122);
        return true;
    }

    public final boolean fgw() {
        AppMethodBeat.i(98123);
        if (!Util.isNullOrNil(this.jpT)) {
            boolean z = this.jpV == 3;
            Log.i(this.TAG, "stop online download video %s isFinish %b percent %d", this.jpT, Boolean.valueOf(z), Integer.valueOf(this.Eur));
            aj.faM().q(this.jpT, fgC());
            if (this.Eur >= this.Eux.EuA && !z) {
                aj.faM().a(this.ebR, this.iXu, this.dHp, false, false, 36);
            }
            fgD();
        } else {
            fgE();
        }
        AppMethodBeat.o(98123);
        return true;
    }

    public final boolean aQW(String str) {
        AppMethodBeat.i(98124);
        boolean isEqual = Util.isEqual(this.jpT, str);
        AppMethodBeat.o(98124);
        return isEqual;
    }

    public final boolean ub(int i2) {
        int i3;
        boolean z;
        an anVar;
        AppMethodBeat.i(98125);
        if (this.clear) {
            AppMethodBeat.o(98125);
            return false;
        }
        if (this.jpZ != -1) {
            i3 = this.jpZ;
        } else {
            i3 = i2;
        }
        boolean z2 = true;
        Log.i(this.TAG, "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.jqc), Integer.valueOf(this.jpY), Integer.valueOf(this.jpW), Integer.valueOf(this.jpV), this.jpT, Long.valueOf(this.Euu - this.gqR), Boolean.valueOf(this.jqe));
        if (this.Euq == null) {
            Log.i(this.TAG, "ui is null, checkTimer false");
            AppMethodBeat.o(98125);
            return false;
        }
        switch (this.jpV) {
            case 1:
                if (!uc(i3)) {
                    fgz();
                    z2 = false;
                } else {
                    fgB();
                    if (this.jqe) {
                        ZC(i3);
                        fgA();
                    } else {
                        Log.i(this.TAG, "prepare cdnMediaId [%s]", this.jpT);
                        if (this.jpW == 5) {
                            this.jpW = 1;
                        }
                        vm(true);
                        this.jqe = true;
                    }
                }
                ZC(i3);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (a(i3, pInt, pInt2)) {
                    if (iJ(pInt.value, pInt2.value)) {
                        this.jqc = Math.max(this.jqc, pInt2.value);
                        z2 = true;
                        break;
                    }
                } else {
                    Log.d(this.TAG, "can not calc download.");
                    o.bhk();
                    e.r(this.jpT, 0, -1);
                    break;
                }
                break;
            case 2:
                Log.w(this.TAG, "download error.");
                break;
            case 3:
                fgB();
                if (!this.jqe) {
                    if (this.jpW == 5) {
                        this.jpW = 1;
                    }
                    vm(false);
                    this.jqe = true;
                    break;
                } else {
                    if (this.jqb) {
                        if (this.jpZ != -1) {
                            ZB(this.jpZ);
                            this.jpZ = -1;
                            z = false;
                            anVar = this;
                        } else if (fgx()) {
                            z = false;
                            anVar = this;
                        } else {
                            z = true;
                            anVar = this;
                        }
                        anVar.jqb = z;
                    }
                    this.jpW = 3;
                    ZC(i3);
                    break;
                }
            default:
                Log.w(this.TAG, "check time default.");
                break;
        }
        AppMethodBeat.o(98125);
        return z2;
    }

    private boolean fgx() {
        boolean z;
        AppMethodBeat.i(98126);
        synchronized (this.Euy) {
            try {
                if (this.Euq != null) {
                    z = this.Euq.fgn();
                } else {
                    z = true;
                    AppMethodBeat.o(98126);
                }
            } finally {
                AppMethodBeat.o(98126);
            }
        }
        return z;
    }

    private void ZB(int i2) {
        AppMethodBeat.i(98127);
        synchronized (this.Euy) {
            try {
                if (this.Euq != null) {
                    this.Euq.aT(i2, true);
                }
            } finally {
                AppMethodBeat.o(98127);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void vm(boolean z) {
        AppMethodBeat.i(98128);
        synchronized (this.Euy) {
            try {
                if (this.Euq != null) {
                    this.Euq.cq(this.jpU, z);
                }
            } finally {
                AppMethodBeat.o(98128);
            }
        }
    }

    private void ZC(int i2) {
        AppMethodBeat.i(203352);
        synchronized (this.Euy) {
            try {
                if (this.Euq != null) {
                    this.Euq.Zz(i2);
                }
            } finally {
                AppMethodBeat.o(203352);
            }
        }
    }

    private boolean a(int i2, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(98129);
        pInt.value = Math.max(i2, this.jqc);
        if (this.jpW == 1) {
            pInt.value = i2;
            pInt2.value = pInt.value + this.jqd;
        }
        if (this.jpW == 2) {
            pInt.value = i2 - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = pInt.value + this.jqd + 8;
        }
        if (this.jpW == 3 || this.jpW == 4) {
            pInt.value = this.jqc;
            pInt2.value = this.jqd + i2 + 1 + this.Eux.jqn;
        }
        if (pInt2.value >= this.jpY + 1) {
            pInt2.value = this.jpY + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + this.Eux.jqn;
            AppMethodBeat.o(98129);
            return false;
        }
        Log.i(this.TAG, "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i2), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd));
        AppMethodBeat.o(98129);
        return true;
    }

    private boolean uc(int i2) {
        boolean z = false;
        AppMethodBeat.i(98130);
        if (this.jpV == 3) {
            AppMethodBeat.o(98130);
            return true;
        } else if (this.jqc - i2 > 1 || this.jqc >= this.jpY) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            try {
                if (this.Eup.a(i2, i2 + 1, pInt, pInt2) && !(z = o.bhk().isVideoDataAvailable(this.jpT, pInt.value, pInt2.value))) {
                    this.jqc = i2;
                }
            } catch (Exception e2) {
                Log.e(this.TAG, "check video data error: " + e2.toString());
            }
            AppMethodBeat.o(98130);
            return z;
        } else {
            AppMethodBeat.o(98130);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean iJ(int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 279
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.an.iJ(int, int):boolean");
    }

    /* access modifiers changed from: package-private */
    public final void fgy() {
        AppMethodBeat.i(98132);
        Log.i(this.TAG, "play offline video %s ", this.jpT);
        fgB();
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.an.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(98118);
                if (an.this.Euq != null) {
                    an.this.vm(false);
                }
                AppMethodBeat.o(98118);
            }
        });
        AppMethodBeat.o(98132);
    }

    private void fgz() {
        AppMethodBeat.i(98133);
        this.jqb = true;
        if (this.jqc > 0) {
            Log.i(this.TAG, "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", this.jpT, Integer.valueOf(this.Eus), Integer.valueOf(this.jpW));
            this.Euv = Util.nowMilliSecond();
            if (!(this.jpW == 2 || this.jpW == 4)) {
                this.jqd += this.Eux.jqm;
                this.jqd = Math.min(this.jqd, 60);
                this.Eus++;
                this.jpW = 4;
            }
            this.Euq.bgW();
            AppMethodBeat.o(98133);
        } else if (this.jpZ == -1) {
            this.jpW = 1;
            AppMethodBeat.o(98133);
        } else {
            this.jpW = 2;
            AppMethodBeat.o(98133);
        }
    }

    private void fgA() {
        boolean z = false;
        AppMethodBeat.i(98134);
        if (this.jqb) {
            if (this.Eus == 0 && this.Euu == 0) {
                fgB();
            } else if (this.Euv > 0) {
                this.Euw = (int) (((long) this.Euw) + Util.milliSecondsToNow(this.Euv));
            }
            Log.i(this.TAG, "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", Integer.valueOf(this.Eus), Integer.valueOf(this.Euw), this.jpT);
            this.jpW = 3;
            if (this.jpZ != -1) {
                ZB(this.jpZ);
                this.jpZ = -1;
                this.jqb = false;
                AppMethodBeat.o(98134);
                return;
            }
            if (!fgx()) {
                z = true;
            }
            this.jqb = z;
            AppMethodBeat.o(98134);
            return;
        }
        if (this.jpW != 3) {
            Log.i(this.TAG, "start to play video playStatus[%d]", Integer.valueOf(this.jpW));
            this.jpW = fgx() ? 3 : this.jpW;
        }
        AppMethodBeat.o(98134);
    }

    /* access modifiers changed from: package-private */
    public final void fgB() {
        AppMethodBeat.i(98135);
        if (this.Euu == 0) {
            this.Euu = Util.nowMilliSecond();
        }
        AppMethodBeat.o(98135);
    }

    private Object[] fgC() {
        int i2;
        AppMethodBeat.i(98136);
        Object[] objArr = new Object[14];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        String str = "";
        long j2 = 0;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        synchronized (this.Euy) {
            try {
                if (this.Euq != null) {
                    i3 = this.Euq.getPlayVideoDuration();
                    i4 = this.Euq.getUiStayTime();
                    i5 = this.Euq.getPlayErrorCode();
                    i6 = this.Euq.getRptStruct().scene;
                    str = this.Euq.getRptStruct().sessionId;
                    j2 = this.Euq.getRptStruct().EtT;
                    str2 = this.Euq.getRptStruct().dRS;
                    str3 = this.Euq.getRptStruct().dRP;
                    str4 = this.Euq.getRptStruct().filePath;
                    i2 = this.Euq.getPlayVideoDurationByResume();
                } else {
                    i2 = 0;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(98136);
                throw th;
            }
        }
        objArr[0] = Integer.valueOf(i3);
        if (this.Euu <= 0) {
            this.Euu = Util.nowMilliSecond();
        }
        int i7 = (int) (this.Euu - this.gqR);
        if (i7 <= 0) {
            i7 = 0;
        }
        objArr[1] = Integer.valueOf(i7);
        if (this.Eut <= 0) {
            this.Eut = Util.nowMilliSecond();
        }
        int i8 = (int) (this.Eut - this.gqR);
        if (i8 <= 0) {
            i8 = 0;
        }
        objArr[2] = Integer.valueOf(i8);
        objArr[3] = Integer.valueOf(this.Eus);
        if (this.Eus > 0) {
            if (this.Euw == 0) {
                this.Euw = (int) (((long) this.Euw) + Util.milliSecondsToNow(this.Euv));
            }
            objArr[4] = Integer.valueOf(this.Euw / this.Eus);
        } else {
            objArr[4] = 0;
        }
        objArr[5] = Integer.valueOf(i4);
        objArr[6] = Integer.valueOf(i5);
        objArr[7] = Integer.valueOf(i6);
        objArr[8] = str;
        objArr[9] = Long.valueOf(j2);
        objArr[10] = str2;
        objArr[11] = str3;
        objArr[12] = str4;
        objArr[13] = Integer.valueOf(i2);
        AppMethodBeat.o(98136);
        return objArr;
    }

    private static void vn(boolean z) {
        AppMethodBeat.i(98137);
        if (z) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 201, 1, false);
            AppMethodBeat.o(98137);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 202, 1, false);
        AppMethodBeat.o(98137);
    }

    private static void fgD() {
        AppMethodBeat.i(98138);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 203, 1, false);
        AppMethodBeat.o(98138);
    }

    public final void fgE() {
        AppMethodBeat.i(98139);
        Object[] fgC = fgC();
        PInt pInt = new PInt();
        new PInt().value = 0;
        pInt.value = 0;
        int iOSNetType = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
        int intValue = ((Integer) fgC[1]).intValue();
        int intValue2 = ((Integer) fgC[2]).intValue();
        int intValue3 = ((Integer) fgC[3]).intValue();
        int intValue4 = ((Integer) fgC[4]).intValue();
        int intValue5 = ((Integer) fgC[5]).intValue();
        int intValue6 = ((Integer) fgC[6]).intValue();
        int intValue7 = ((Integer) fgC[7]).intValue();
        int intValue8 = ((Long) fgC[9]).intValue();
        long intValue9 = (long) (((Integer) fgC[13]).intValue() * 1000);
        long boW = s.boW((String) fgC[12]);
        iq iqVar = new iq();
        iqVar.eJb = (long) iOSNetType;
        iqVar.eoV = 0;
        iqVar.eoW = 0;
        iqVar.eKb = boW;
        iqVar.wo((String) fgC[10]);
        iqVar.wn((String) fgC[11]);
        iqVar.eJH = intValue9;
        iqVar.eKd = (long) intValue;
        iqVar.eKe = (long) intValue2;
        iqVar.eKf = (long) intValue3;
        iqVar.eGx = (long) intValue4;
        iqVar.eKy = (long) intValue5;
        iqVar.eKz = intValue6;
        iqVar.ePv = intValue7;
        iqVar.wp((String) fgC[8]);
        iqVar.ePx = intValue8;
        iqVar.bfK();
        AppMethodBeat.o(98139);
    }
}
