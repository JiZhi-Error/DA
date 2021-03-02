package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.e;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;

public final class o {
    HashMap<String, Integer> Euo = new HashMap<>();
    j Eup;
    int Eur;
    int Eus = 0;
    long Eut;
    long Euu;
    private long Euv;
    private int Euw;
    j PBI;
    a PBJ;
    String filename;
    long gqR;
    int jpV = 0;
    int jpW = 0;
    int jpY;
    int jpZ;
    boolean jqb;
    int jqc = 0;
    private int jqd;
    boolean jqe = false;
    boolean jqf = false;
    int kKK;
    String mediaId;

    /* access modifiers changed from: package-private */
    public static class a {
        int EuA;
        int PBL;
        int jqm;
        int jqn;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public o(com.tencent.mm.ui.chatting.gallery.j r10) {
        /*
        // Method dump skipped, instructions count: 234
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.o.<init>(com.tencent.mm.ui.chatting.gallery.j):void");
    }

    public final void reset() {
        AppMethodBeat.i(36395);
        this.mediaId = "";
        this.filename = "";
        this.jpZ = -1;
        this.Eur = 0;
        this.kKK = 0;
        this.jqc = 0;
        this.jpY = 0;
        this.Eus = 0;
        this.jpW = 0;
        this.jpV = 0;
        this.jqb = false;
        this.jqe = false;
        this.jqf = false;
        this.Euo.clear();
        if (this.PBJ != null) {
            this.jqd = this.PBJ.jqm;
        }
        this.Eut = 0;
        this.gqR = 0;
        this.Euw = 0;
        this.Euv = 0;
        this.Euu = 0;
        AppMethodBeat.o(36395);
    }

    public final boolean c(ca caVar, s sVar) {
        AppMethodBeat.i(36396);
        if (caVar.cWK()) {
            h hVar = new h();
            hVar.taskName = "task_OnlineVideoUIHelper";
            hVar.field_mediaId = c.a("downvideo", sVar.createTime, sVar.getUser(), sVar.getFileName());
            hVar.url = sVar.jsw.iyZ;
            hVar.gqU = 1;
            hVar.gqP = 7;
            hVar.concurrentCount = 4;
            hVar.filename = sVar.getFileName();
            com.tencent.mm.modelvideo.o.bhj();
            hVar.field_fullpath = t.Qw(sVar.getFileName());
            hVar.gqT = sVar.iKP;
            this.mediaId = hVar.field_mediaId;
            this.kKK = hVar.gqT;
            this.filename = sVar.getFileName();
            this.jpV = 1;
            this.jpY = 0;
            com.tencent.mm.modelvideo.o.bhk().a(hVar, com.tencent.mm.modelvideo.o.bho().bhG());
            this.gqR = Util.nowMilliSecond();
            Log.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", this.mediaId, this.filename, Long.valueOf(this.gqR));
            AppMethodBeat.o(36396);
            return true;
        }
        AppMethodBeat.o(36396);
        return false;
    }

    public final void gTi() {
        AppMethodBeat.i(36398);
        Log.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
        boolean z = this.jpV == 3;
        this.jpV = 0;
        if (!Util.isNullOrNil(this.mediaId)) {
            if (z) {
                gTk();
            } else if (this.Eur >= this.PBJ.EuA) {
                Log.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", Integer.valueOf(this.Eur), Integer.valueOf(this.PBJ.EuA));
                u.az(this.filename, 2);
                gTn();
            }
            com.tencent.mm.modelvideo.o.bhk().m(this.mediaId, fgC());
            gTm();
        }
        AppMethodBeat.o(36398);
    }

    public final boolean isStreaming() {
        AppMethodBeat.i(36399);
        if (Util.isNullOrNil(this.mediaId) || !(this.jpV == 1 || this.jpV == 3)) {
            AppMethodBeat.o(36399);
            return false;
        }
        AppMethodBeat.o(36399);
        return true;
    }

    public final boolean aQW(String str) {
        AppMethodBeat.i(36400);
        boolean isEqual = Util.isEqual(str, this.mediaId);
        AppMethodBeat.o(36400);
        return isEqual;
    }

    /* access modifiers changed from: package-private */
    public final void fgy() {
        AppMethodBeat.i(36401);
        Log.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", this.filename);
        fgB();
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.gallery.o.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(36393);
                if (o.this.PBI != null) {
                    o.this.PBI.cq(o.this.filename, false);
                }
                AppMethodBeat.o(36393);
            }
        });
        AppMethodBeat.o(36401);
    }

    public final boolean bL(int i2, boolean z) {
        boolean z2;
        AppMethodBeat.i(36402);
        switch (this.jpV) {
            case 1:
                this.jpW = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                a(i2, pInt, pInt2);
                if (!o(pInt.value, pInt2.value, true)) {
                    this.jpZ = i2;
                    this.jqb = true;
                    this.PBI.bgW();
                    z2 = false;
                    break;
                } else {
                    this.jpZ = -1;
                    this.jqb = false;
                    this.jqc = pInt2.value;
                    this.jpW = 3;
                }
            case 3:
                this.PBI.aT(i2, z);
            case 2:
            default:
                z2 = true;
                break;
        }
        Log.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", Integer.valueOf(i2), Integer.valueOf(this.jpV), Integer.valueOf(this.jpW));
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 4, 1, false);
        AppMethodBeat.o(36402);
        return z2;
    }

    public final boolean ub(int i2) {
        int i3;
        o oVar;
        boolean z;
        int i4;
        o oVar2;
        boolean z2;
        o oVar3;
        boolean z3 = false;
        boolean z4 = true;
        AppMethodBeat.i(36403);
        if (this.jpZ != -1) {
            i3 = this.jpZ;
        } else {
            i3 = i2;
        }
        Log.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.jqc), Integer.valueOf(this.jpY), Integer.valueOf(this.jpV), Long.valueOf(this.Euu - this.gqR), Boolean.valueOf(this.jqe));
        switch (this.jpV) {
            case 1:
                if (!uc(i3)) {
                    this.jqb = true;
                    if (this.jqc > 0) {
                        Log.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.Eus + " playStatus : " + this.jpW);
                        this.Euv = Util.nowMilliSecond();
                        if (!(this.jpW == 2 || this.jpW == 4)) {
                            this.jqd += this.PBJ.jqm;
                            this.jqd = Math.min(this.jqd, 60);
                            this.Eus++;
                            this.jpW = 4;
                        }
                        this.PBI.bgW();
                    } else if (this.jpZ == -1) {
                        this.jpW = 1;
                    } else {
                        this.jpW = 2;
                    }
                    z = false;
                } else {
                    if (this.Eus == 0 && this.Euu == 0) {
                        fgB();
                    }
                    if (this.jqe) {
                        this.PBI.bna(this.filename);
                        if (this.jqb) {
                            if (this.Eus == 0 && this.Euu == 0) {
                                fgB();
                            } else if (this.Euv > 0) {
                                this.Euw = (int) (((long) this.Euw) + Util.milliSecondsToNow(this.Euv));
                            }
                            Log.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", Integer.valueOf(this.Eus), Integer.valueOf(this.Euw));
                            if (this.jpZ != -1) {
                                this.PBI.aT(this.jpZ, true);
                                this.jpZ = -1;
                                z2 = false;
                                oVar3 = this;
                            } else if (this.PBI.fgn()) {
                                z2 = false;
                                oVar3 = this;
                            } else {
                                z2 = true;
                                oVar3 = this;
                            }
                            oVar3.jqb = z2;
                            i4 = 3;
                            oVar2 = this;
                        } else {
                            if (this.jpW != 3) {
                                Log.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", Integer.valueOf(this.jpW));
                                if (this.PBI.fgn()) {
                                    i4 = 3;
                                    oVar2 = this;
                                } else {
                                    i4 = this.jpW;
                                    oVar2 = this;
                                }
                            }
                            z = true;
                        }
                        oVar2.jpW = i4;
                        z = true;
                    } else {
                        Log.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", this.filename);
                        this.PBI.cq(this.filename, true);
                        this.jqe = true;
                        z = true;
                    }
                }
                this.PBI.anl(i3);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (a(i3, pInt, pInt2)) {
                    if (o(pInt.value, pInt2.value, false)) {
                        this.jqc = Math.max(this.jqc, pInt2.value);
                        break;
                    }
                } else {
                    Log.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
                }
                z4 = z;
                break;
            case 3:
                fgB();
                if (!this.jqe) {
                    this.PBI.cq(this.filename, false);
                    this.jqe = true;
                    break;
                } else {
                    if (this.jqb) {
                        if (this.jpZ != -1) {
                            this.PBI.aT(this.jpZ, true);
                            this.jpZ = -1;
                            oVar = this;
                        } else if (this.PBI.fgn()) {
                            oVar = this;
                        } else {
                            z3 = true;
                            oVar = this;
                        }
                        oVar.jqb = z3;
                    }
                    this.PBI.anl(i3);
                    break;
                }
        }
        AppMethodBeat.o(36403);
        return z4;
    }

    public final boolean uc(int i2) {
        Exception e2;
        boolean z;
        AppMethodBeat.i(36404);
        if (this.jpV == 3) {
            AppMethodBeat.o(36404);
            return true;
        } else if (this.jqc - i2 > 2 || this.jqc >= this.jpY) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            try {
                if (this.Eup.a(i2, i2 + 2, pInt, pInt2)) {
                    z = com.tencent.mm.modelvideo.o.bhk().isVideoDataAvailable(this.mediaId, pInt.value, pInt2.value);
                    if (!z) {
                        try {
                            this.jqc = i2;
                        } catch (Exception e3) {
                            e2 = e3;
                            Log.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e2, "", new Object[0]);
                            Log.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e2.toString());
                            AppMethodBeat.o(36404);
                            return z;
                        }
                    }
                } else {
                    z = false;
                }
            } catch (Exception e4) {
                e2 = e4;
                z = false;
                Log.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e2, "", new Object[0]);
                Log.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e2.toString());
                AppMethodBeat.o(36404);
                return z;
            }
            AppMethodBeat.o(36404);
            return z;
        } else {
            AppMethodBeat.o(36404);
            return false;
        }
    }

    private boolean a(int i2, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(36405);
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
            pInt2.value = this.jqd + i2 + 2 + this.PBJ.jqn;
        }
        if (pInt2.value >= this.jpY + 1) {
            pInt2.value = this.jpY + 1;
        }
        if (pInt2.value <= pInt.value) {
            pInt2.value = pInt.value + this.PBJ.jqn;
            AppMethodBeat.o(36405);
            return false;
        }
        Log.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i2), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd));
        AppMethodBeat.o(36405);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean o(int r12, int r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.o.o(int, int, boolean):boolean");
    }

    public final void gTj() {
        AppMethodBeat.i(36407);
        String str = this.mediaId + 0 + "_-1";
        if (!this.Euo.containsKey(str)) {
            Log.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", this.mediaId);
            com.tencent.mm.modelvideo.o.bhk();
            e.r(this.mediaId, 0, -1);
            this.Euo.put(str, 0);
            gTp();
        }
        this.jpW = 5;
        AppMethodBeat.o(36407);
    }

    /* access modifiers changed from: package-private */
    public final void gTk() {
        AppMethodBeat.i(36408);
        com.tencent.mm.modelvideo.o.bhj();
        if (r.isH265Video(t.Qw(this.filename))) {
            Log.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", this.filename);
            if (u.QR(this.filename)) {
                gTq();
            }
        }
        AppMethodBeat.o(36408);
    }

    /* access modifiers changed from: package-private */
    public final void fgB() {
        AppMethodBeat.i(36409);
        if (this.Euu == 0) {
            this.Euu = Util.nowMilliSecond();
        }
        AppMethodBeat.o(36409);
    }

    /* access modifiers changed from: package-private */
    public final Object[] fgC() {
        AppMethodBeat.i(36410);
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.PBI.getPlayVideoDuration());
        if (this.Euu <= 0) {
            this.Euu = Util.nowMilliSecond();
        }
        int i2 = (int) (this.Euu - this.gqR);
        if (i2 <= 0) {
            i2 = 0;
        }
        objArr[1] = Integer.valueOf(i2);
        if (this.Eut <= 0) {
            this.Eut = Util.nowMilliSecond();
        }
        int i3 = (int) (this.Eut - this.gqR);
        if (i3 <= 0) {
            i3 = 0;
        }
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(this.Eus);
        if (this.Eus > 0) {
            if (this.Euw == 0) {
                this.Euw = (int) (((long) this.Euw) + Util.milliSecondsToNow(this.Euv));
            }
            objArr[4] = Integer.valueOf(this.Euw / this.Eus);
        } else {
            objArr[4] = 0;
        }
        objArr[5] = Integer.valueOf(this.PBI.getUiStayTime());
        objArr[6] = Integer.valueOf(this.PBI.tnb);
        AppMethodBeat.o(36410);
        return objArr;
    }

    private static void gTl() {
        AppMethodBeat.i(36411);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 1, 1, false);
        AppMethodBeat.o(36411);
    }

    private static void gTm() {
        AppMethodBeat.i(36412);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 2, 1, false);
        AppMethodBeat.o(36412);
    }

    private static void gTn() {
        AppMethodBeat.i(36413);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 10, 1, false);
        AppMethodBeat.o(36413);
    }

    private static void gTo() {
        AppMethodBeat.i(36414);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 17, 1, false);
        AppMethodBeat.o(36414);
    }

    private void gTp() {
        AppMethodBeat.i(36415);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 24, 1, false);
        Log.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", Integer.valueOf(hashCode()), this.filename);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13836, 303, Long.valueOf(Util.nowSecond()), "");
        AppMethodBeat.o(36415);
    }

    private static void gTq() {
        AppMethodBeat.i(36416);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 134, 1, false);
        AppMethodBeat.o(36416);
    }

    public final boolean bnc(String str) {
        int i2;
        AppMethodBeat.i(36397);
        com.tencent.mm.modelcontrol.e.baZ();
        if (!com.tencent.mm.modelcontrol.e.bbk()) {
            AppMethodBeat.o(36397);
            return false;
        }
        reset();
        s QN = u.QN(str);
        if (QN == null || (i2 = QN.iKP) >= this.PBJ.PBL) {
            u.aA(str, 1);
            n.bhh();
            com.tencent.mm.modelvideo.o.bhk();
            h Oe = e.Oe(str);
            if (Oe == null) {
                AppMethodBeat.o(36397);
                return false;
            }
            this.mediaId = Oe.field_mediaId;
            this.kKK = Oe.gqT;
            this.filename = str;
            this.jpV = 1;
            this.jpY = 0;
            com.tencent.mm.modelvideo.o.bhk().a(Oe, com.tencent.mm.modelvideo.o.bho().bhG());
            this.gqR = Util.nowMilliSecond();
            gTl();
            Log.i("MicroMsg.OnlineVideoUIHelper", "download online video.[%s, %s] start time[%d]", this.mediaId, str, Long.valueOf(this.gqR));
            AppMethodBeat.o(36397);
            return true;
        }
        Log.i("MicroMsg.OnlineVideoUIHelper", "video size[%d] less than config size[%d], do not stream video", Integer.valueOf(i2), Integer.valueOf(this.PBJ.PBL));
        u.b(QN, 9);
        gTo();
        AppMethodBeat.o(36397);
        return false;
    }
}
