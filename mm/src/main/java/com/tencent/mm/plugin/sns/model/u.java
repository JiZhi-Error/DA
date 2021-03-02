package com.tencent.mm.plugin.sns.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.e.c;
import com.tencent.mm.plugin.sns.ad.timeline.b.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.e;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;

public final class u extends q implements m {
    private long DIK = 0;
    private String DIL = "";
    private long DIg = 0;
    public int DIi = 0;
    public int DIj = 0;
    public int akb = 0;
    public i callback;
    private d rr;
    final int sourceType;

    public u() {
        int i2;
        AppMethodBeat.i(95619);
        d.a aVar = new d.a();
        aVar.iLN = new ebd();
        aVar.iLO = new ebe();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
        aVar.funcId = 718;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            i2 = 1;
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            i2 = 3;
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            i2 = 4;
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        this.sourceType = 2;
        ebd ebd = (ebd) this.rr.iLK.iLR;
        ebd.MYL = i2;
        ebd.MZh = 0;
        int fbw = aj.faE().fbw();
        this.DIg = aj.faO().g(0L, fbw, true);
        ebd.Nau = this.DIg;
        int a2 = d.a(this.DIg, 0, "@__weixintimtline");
        ebd.Nav = a2;
        this.DIK = aj.faO().g(0L, 1, true);
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.DIK);
        ebd.Naw = this.DIK;
        l aQr = aj.faS().aQr("@__weixintimtline");
        this.DIL = aQr == null ? "" : aQr.field_md5;
        if (this.DIL == null) {
            this.DIL = "";
        }
        ebd.MZg = this.DIL;
        if (aQr == null || aQr.field_adsession == null) {
            ebd.MYJ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        } else {
            Log.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", aQr.field_adsession);
            ebd.MYJ = new SKBuiltinBuffer_t().setBuffer(aQr.field_adsession);
        }
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + fbw + " min:" + this.DIg + " ReqTime:" + ebd.Nav + " nettype: " + i2);
        Log.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", r.Jb(this.DIg), Integer.valueOf(a2));
        AppMethodBeat.o(95619);
    }

    private void a(ebe ebe, String str) {
        SnsInfo JJ;
        boolean z;
        AppMethodBeat.i(95620);
        an.a("@__weixintimtline", this.sourceType, ebe.KOH, str);
        this.DIg = ebe.KOH.getLast().Id;
        d.f("@__weixintimtline", ebe.KOH.getFirst().Id, this.DIg, ebe.NaG);
        Iterator<SnsObject> it = ebe.KOH.iterator();
        while (it.hasNext()) {
            SnsObject next = it.next();
            if (!(next.NoChange != 0 || (JJ = aj.faO().JJ(next.Id)) == null || JJ.getTimeLine() == null)) {
                LinkedList<cnb> linkedList = JJ.getTimeLine().ContentObj.LoV;
                if (JJ.isAd() || !be.fiv()) {
                    for (cnb cnb : linkedList) {
                        b(cnb, linkedList.size() <= 1);
                    }
                } else {
                    String snsId = JJ.getSnsId();
                    if (linkedList != null && linkedList.size() > 0) {
                        int size = linkedList.size();
                        if (1 == size) {
                            cnb cnb2 = linkedList.get(0);
                            Log.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with single media, media type: %s.", Integer.valueOf(cnb2.oUv));
                            b(cnb2, true);
                        } else {
                            SparseArray<cnb> sparseArray = new SparseArray<>();
                            SparseArray<n> sparseArray2 = new SparseArray<>();
                            for (int i2 = 0; i2 < size; i2++) {
                                cnb cnb3 = linkedList.get(i2);
                                if (6 == cnb3.oUv) {
                                    Log.w("MicroMsg.NetSceneSnsPreTimeLine", "img batch download contains video, snsId: %s, mediaId: %s.", snsId, cnb3.Id);
                                    b(cnb3, false);
                                } else {
                                    String e2 = r.e(cnb3);
                                    String ki = ar.ki(aj.getAccSnsPath(), cnb3.Id);
                                    if (s.YS(ki + e2) || s.YS(ki + r.l(cnb3)) || s.YS(ki + r.m(cnb3))) {
                                        Log.i("MicroMsg.NetSceneSnsPreTimeLine", "mediaExist exist:%s.", cnb3.Id);
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (!z) {
                                        n nVar = new n(cnb3);
                                        nVar.DEs = 0;
                                        nVar.dPI = cnb3.Id;
                                        sparseArray2.put(i2, nVar);
                                        sparseArray.put(i2, cnb3);
                                    }
                                }
                            }
                            if (sparseArray.size() > 0) {
                                Log.i("MicroMsg.NetSceneSnsPreTimeLine", "deal with batch img.");
                                aj.faJ().a(snsId, sparseArray, sparseArray2, bp.Oql, size);
                            }
                        }
                    }
                }
                if (JJ.getTypeFlag() == 15 && (!JJ.isAd() || a.n(JJ))) {
                    aj.faM().G(JJ);
                    try {
                        h.INSTANCE.a(14388, Long.valueOf(next.Id), 4, JJ.getTimeLine().ContentObj.LoV.get(0).Url, 0);
                    } catch (Exception e3) {
                    }
                }
            }
        }
        aj.faM().fbO();
        AppMethodBeat.o(95620);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        int size;
        AppMethodBeat.i(95621);
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        ebe ebe = (ebe) ((d) sVar).iLL.iLR;
        if (sVar.getRespObj().getRetCode() == 207 || sVar.getRespObj().getRetCode() == 0) {
            if (ebe.MZl != null) {
                Log.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + ebe.MZl.Naq + " " + ebe.MZl.Nap);
                int i5 = ebe.MZl.Naq;
                com.tencent.mm.plugin.sns.c.a.DCT = i5;
                if (i5 <= 0) {
                    com.tencent.mm.plugin.sns.c.a.DCT = Integer.MAX_VALUE;
                }
                aq.NSd = ebe.MZl.Nap;
            }
            this.DIi = ebe.MZk;
            this.DIj = ebe.xuw;
            Log.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + ebe.MZk + " , objCount:  " + ebe.MvM + " cflag : " + ebe.xuw);
            this.akb = ebe.MvM;
            String Jc = r.Jc(0);
            if (!ebe.KOH.isEmpty()) {
                StringBuilder append = new StringBuilder("respone size ").append(ebe.KOH.size()).append(" Max ").append(ebe.KOH.getFirst().Id).append(" ").append(r.Jb(ebe.KOH.getFirst().Id)).append("  respone min  ").append(ebe.KOH.getLast().Id).append(" ").append(r.Jb(ebe.KOH.getLast().Id)).append(" adCount=");
                if (ebe.NaI == null) {
                    size = 0;
                } else {
                    size = ebe.NaI.size();
                }
                Log.i("MicroMsg.NetSceneSnsPreTimeLine", append.append(size).toString());
            } else {
                Log.i("MicroMsg.NetSceneSnsPreTimeLine", " respone is Empty, adCount=" + (ebe.NaI == null ? 0 : ebe.NaI.size()));
            }
            c.c(ebe.NaM, ebe.NaL, 1);
            this.akb = ebe.MvM;
            if (this.DIL.equals(ebe.MZg)) {
                this.DIg = aj.faO().g(0L, this.DIi, true);
                Log.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", Long.valueOf(this.DIg));
                z.aPb("@__weixintimtline");
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(95621);
                return;
            }
            aj.faS().g("@__weixintimtline", ebe.MZg, z.a(ebe.MYJ));
            Log.i("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + ebe.KOH.size() + " adsize : " + ebe.NaH);
            for (int i6 = 0; i6 < ebe.NaI.size(); i6++) {
                ds dsVar = ebe.NaI.get(i6);
                StringBuilder sb = new StringBuilder();
                if (!(dsVar == null || dsVar.KHH == null)) {
                    sb.append(z.a(dsVar.KHH));
                }
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                if (!(dsVar == null || dsVar.KHG == null)) {
                    sb2.append(z.a(dsVar.KHG.MYI));
                    sb3.append(z.b(dsVar.KHG.MYH.ObjectDesc));
                }
                Log.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + sb.toString());
                Log.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + sb2.toString());
                Log.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + sb3.toString() + APLogFileUtil.SEPARATOR_LINE);
                long j2 = 0;
                String str2 = "";
                try {
                    String sb4 = sb.toString();
                    str2 = sb2.toString();
                    if (!Util.isNullOrNil(sb4, str2)) {
                        if (!(dsVar == null || dsVar.KHG == null || dsVar.KHG.MYH == null)) {
                            j2 = Util.nullAsNil(Long.valueOf(dsVar.KHG.MYH.Id));
                        }
                        com.tencent.mm.plugin.sns.data.i.d(j2, sb4, str2);
                    }
                } catch (Throwable th) {
                    Log.e("MicroMsg.NetSceneSnsPreTimeLine", "reportAdPullException: " + th.toString());
                }
                final String str3 = dsVar.KHG.MYH.Username;
                if (!Util.isNullOrNil(str3)) {
                    boolean aOd = k.aOd(str2);
                    Log.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate contact:" + str3 + ", isUsePreferedInfo=" + aOd + ", snsId=" + r.Jc(j2));
                    if (!aOd) {
                        ay.a.iDq.aL(str3, "");
                        com.tencent.f.h.RTc.o(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.model.u.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(95618);
                                Log.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate avatar:" + str3);
                                com.tencent.mm.aj.c.Mf(str3);
                                p.aYD().Mh(str3);
                                AppMethodBeat.o(95618);
                            }
                        }, 10000);
                    }
                }
                e.a(dsVar);
            }
            a.a(ebe.NaI, ebe.KOH, false, -1);
            j.d(ebe.NaI, false);
            if (ebe.NaH == 0) {
                Log.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", Integer.valueOf(ebe.NaJ));
                a.e(ebe.NaK, ebe.KOH);
                a.bo(ebe.NaK);
            }
            LinkedList<Long> linkedList = new LinkedList<>();
            Iterator<SnsObject> it = ebe.KOH.iterator();
            while (it.hasNext()) {
                linkedList.add(Long.valueOf(it.next().Id));
            }
            wh whVar = new wh();
            whVar.ecr.ecs = linkedList;
            EventCenter.instance.publish(whVar);
            if (sVar.getRespObj().getRetCode() == 207) {
                if (ebe.KOH.isEmpty()) {
                    aj.faO().feP();
                } else {
                    aj.faO().aQu(r.Jc(ebe.KOH.getFirst().Id));
                    aj.faO().aQt(r.Jc(ebe.KOH.getLast().Id));
                    a(ebe, Jc);
                    j.br(ebe.KOH);
                }
                z.aPb("@__weixintimtline");
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(95621);
                return;
            }
            if (ebe.KOH.isEmpty()) {
                aj.faO().feP();
            } else {
                a(ebe, Jc);
                j.br(ebe.KOH);
            }
            z.aPb("@__weixintimtline");
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95621);
            return;
        }
        z.aPb("@__weixintimtline");
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95621);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 718;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(95622);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95622);
        return dispatch;
    }

    private static void b(cnb cnb, boolean z) {
        int i2 = 1;
        AppMethodBeat.i(95623);
        if (cnb == null) {
            AppMethodBeat.o(95623);
            return;
        }
        String e2 = r.e(cnb);
        int i3 = z ? 1 : 0;
        String ki = ar.ki(aj.getAccSnsPath(), cnb.Id);
        if (s.YS(ki + e2) || s.YS(ki + r.l(cnb)) || s.YS(ki + r.m(cnb))) {
            Log.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", cnb.Id);
            AppMethodBeat.o(95623);
            return;
        }
        Log.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", cnb.Id);
        n nVar = new n(cnb);
        nVar.DEs = i3;
        nVar.dPI = cnb.Id;
        c faJ = aj.faJ();
        if (cnb.oUv == 6) {
            i2 = 5;
        }
        faJ.a(cnb, i2, nVar, bp.Oql);
        AppMethodBeat.o(95623);
    }
}
