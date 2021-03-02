package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.i.d;
import com.tencent.mm.i.e;
import com.tencent.mm.i.f;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.e.b;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.xwalk.core.XWalkFeature;

public abstract class c extends n<String, Integer, Integer> {
    private static HashSet<String> DPK = new HashSet<>();
    int DPM = 0;
    protected SparseArray<com.tencent.mm.memory.n> DPN = new SparseArray<>();
    protected a DPr;
    protected com.tencent.mm.memory.n DPs = null;
    protected a DPt = null;
    private long dnsCostTime = -1;
    protected cnb ebR = null;
    private String host = "";
    private int jDL = -1;

    public interface a {
        void a(int i2, cnb cnb, int i3, boolean z, String str, int i4, int i5, boolean z2);
    }

    public abstract boolean fbX();

    /* access modifiers changed from: protected */
    public abstract int getMediaType();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // com.tencent.mm.pluginsdk.model.n
    public /* synthetic */ Integer doInBackground(String[] strArr) {
        return fbZ();
    }

    public static boolean aPK(String str) {
        if (!DPK.contains(r.cr(1, str)) && !DPK.contains(r.cr(5, str))) {
            return false;
        }
        return true;
    }

    public c(a aVar, a aVar2) {
        this.DPr = aVar;
        this.DPt = aVar2;
        if (aVar2 != null) {
            this.ebR = aVar2.DIq;
            DPK.add(aVar2.DIp);
            aVar2.init();
        }
    }

    public boolean fbW() {
        return true;
    }

    public String aPI(String str) {
        return str;
    }

    public String b(String str, cnb cnb) {
        return str;
    }

    public boolean YM(int i2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void c(d dVar) {
        String str;
        int i2;
        int i3;
        int i4;
        int mediaType = getMediaType();
        String str2 = "";
        switch (mediaType) {
            case 1:
                str = "100105";
                break;
            case 2:
                str = "100106";
                break;
            case 3:
                str = "100100";
                break;
            default:
                return;
        }
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu(str);
        if (Fu.isValid()) {
            i2 = Util.getInt(Fu.gzz().get("needUploadData"), 1);
            str2 = Fu.field_expId;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            if (this.DPt.DPo == 8) {
                i3 = 1;
            } else if (this.DPt.DPo == 6 || this.DPt.DPo == 4) {
                i3 = 2;
            } else if (this.DPt.DPo == 5) {
                i3 = 4;
            } else if (this.DPt.DPo == 2 || this.DPt.DPo == 1 || this.DPt.DPo == 3) {
                i3 = 0;
            } else {
                i3 = 5;
            }
            m mVar = new m();
            mVar.n("20ImgSize", dVar.field_fileLength + ",");
            StringBuilder sb = new StringBuilder();
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            mVar.n("21NetType", sb.append(i4).append(",").toString());
            mVar.n("22DelayTime", dVar.field_delayTime + ",");
            mVar.n("23RetCode", dVar.field_retCode + ",");
            mVar.n("24DnsCostTime", dVar.field_dnsCostTime + ",");
            mVar.n("25ConnectCostTime", dVar.field_connectCostTime + ",");
            mVar.n("26SendCostTime", ",");
            mVar.n("27WaitResponseCostTime", dVar.field_waitResponseCostTime + ",");
            mVar.n("28ReceiveCostTime", dVar.field_receiveCostTime + ",");
            mVar.n("29ClientAddrIP(uint)", dVar.field_clientHostIP + ",");
            mVar.n("30ServerAddrIP(uint)", dVar.field_serverHostIP + ",");
            mVar.n("31dnstype", this.jDL + ",");
            mVar.n("32signal(int)", NetStatusUtil.getStrength(MMApplicationContext.getContext()) + ",");
            mVar.n("33host(string)", this.host + ",");
            mVar.n("34MediaType", mediaType + ",");
            mVar.n("35X_Errno(string)", dVar.field_xErrorNo + ",");
            mVar.n("36MaxPackageSize", ",");
            mVar.n("37MaxPackageTimeStamp", ",");
            mVar.n("38PackageRecordList", ",");
            mVar.n("39ExpLayerId", str + ",");
            mVar.n("40ExpId", str2 + ",");
            mVar.n("41FeedId", ",");
            mVar.n("42BizType", i3 + ",");
            mVar.n("43CSeqCheck(uint)", dVar.field_cSeqCheck + ",");
            mVar.n("44isPrivate(uint)", (dVar.field_usePrivateProtocol ? 1 : 0) + ",");
            Log.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + mVar.abW());
            h.INSTANCE.a(13480, mVar);
            if (dVar.field_retCode != 200 && dVar.field_retCode != 0) {
                h.INSTANCE.a(14071, mVar);
            }
        }
    }

    public boolean a(bp bpVar, String str, long j2, String str2) {
        if (str == null) {
            return false;
        }
        try {
            return (bpVar == null || str2 == null || str2.indexOf(new URL(str).getHost()) == -1 || bpVar.hXs == 0 || Util.secondsToNow((long) bpVar.hXs) <= j2) ? false : true;
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", e2.getMessage());
            return false;
        }
    }

    public Integer fbZ() {
        final e eVar;
        int i2;
        c.C1718c cVar;
        g.aAi();
        if (!g.aAh().isSDCardAvailable() || this.DPt == null) {
            return 2;
        }
        if (fbW()) {
            if (9 == this.DPt.DPo) {
                for (int i3 = 0; i3 < this.DPt.DEw.size(); i3++) {
                    cnb valueAt = this.DPt.DEw.valueAt(i3);
                    String str = ar.ki(aj.getAccSnsPath(), valueAt.Id) + r.n(valueAt);
                    Log.i("MicroMsg.SnsCdnDownloadBase", "pennqin, delete sns thumb: [%s].", str);
                    s.deleteFile(str);
                }
            } else {
                String str2 = this.DPt.DIl + this.DPt.fbV();
                Log.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", str2);
                s.deleteFile(str2);
            }
        }
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            com.tencent.mm.plugin.sns.model.c faJ = aj.faJ();
            String str3 = this.DPt.mediaId;
            if (!Util.isNullOrNil(str3)) {
                cVar = faJ.DGP.get(str3);
            } else {
                cVar = null;
            }
            if (cVar != null && !cVar.DGU) {
                cVar.setStartTime(currentTimeMillis);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsCdnDownloadBase", "exception msg: %s.", e2.getMessage());
        }
        int i4 = 0;
        if (this.DPt.DEw != null) {
            i4 = this.DPt.DEw.size();
        }
        Log.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap pack.mediaId: " + this.DPt.mediaId + " pack.mediaObjs.size: " + i4 + " pack.snsId: " + this.DPt.dRS + " pack.isthumb: " + this.DPt.DPm + " type: " + this.DPt.DPo);
        bp bpVar = this.DPt.DPp;
        String str4 = "";
        if (bpVar == null) {
            str4 = "";
        } else if (bpVar.equals(bp.Oqm)) {
            str4 = "album_friend";
        } else if (bpVar.equals(bp.Oqn)) {
            str4 = "album_self";
        } else if (bpVar.equals(bp.Oqo)) {
            str4 = "album_stranger";
        } else if (bpVar.equals(bp.Oqp)) {
            str4 = "profile_friend";
        } else if (bpVar.equals(bp.Oqq)) {
            str4 = "profile_stranger";
        } else if (bpVar.equals(bp.Oqr)) {
            str4 = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
        } else if (bpVar.equals(bp.Oql)) {
            str4 = "timeline";
        }
        if (!Util.isNullOrNil(str4)) {
            str4 = "&scene=".concat(String.valueOf(str4));
        }
        String format = String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s", Integer.valueOf(com.tencent.mm.protocal.d.KyO), p.getString(aj.fav()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(NetStatusUtil.getStrength(MMApplicationContext.getContext())), str4);
        if (9 == this.DPt.DPo) {
            this.DPt.url = b(this.DPt.url, this.DPt.DEw.get(0));
        } else {
            this.DPt.url = aPI(this.DPt.url);
        }
        this.dnsCostTime = Util.nowMilliSecond();
        String str5 = this.DPt.DPn ? "SnsSightDomainList" : "SnsAlbumDomainList";
        String str6 = this.DPt.DPn ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime";
        String value = com.tencent.mm.n.h.aqJ().getValue(str5);
        long j2 = (long) com.tencent.mm.n.h.aqJ().getInt(str6, 0);
        Log.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", Boolean.valueOf(this.DPt.DPn), Boolean.valueOf(this.DPt.DPm), value, Long.valueOf(j2));
        if (j2 <= 0) {
            j2 = 259200;
        }
        boolean a2 = a(bpVar, this.DPt.url, j2, value);
        this.dnsCostTime = Util.milliSecondsToNow(this.dnsCostTime);
        if (9 == this.DPt.DPo) {
            f fVar = new f();
            ((e) fVar).taskName = "task_SnsCdnDownloadBase_1";
            for (int i5 = 0; i5 < this.DPt.DEw.size(); i5++) {
                s.boN(ar.ki(aj.getAccSnsPath(), this.DPt.DEw.valueAt(i5).Id));
            }
            eVar = fVar;
        } else {
            s.boN(this.DPt.getPath());
            eVar = new e();
            eVar.taskName = "task_SnsCdnDownloadBase_2";
        }
        if (a(eVar, a2, format)) {
            if (this.DPt != null && this.DPt.DPn) {
                b.a(eVar, this.ebR);
            }
            eVar.gqy = new g.a() {
                /* class com.tencent.mm.plugin.sns.model.a.c.AnonymousClass1 */

                @Override // com.tencent.mm.i.g.a
                public final int a(String str, int i2, com.tencent.mm.i.c cVar, final d dVar, boolean z) {
                    boolean fbX;
                    final int i3;
                    AppMethodBeat.i(96067);
                    if (c.this.DPt == null) {
                        Log.e("MicroMsg.SnsCdnDownloadBase", "pack is null.");
                        AppMethodBeat.o(96067);
                        return 0;
                    }
                    if (dVar != null) {
                        if (dVar.field_retCode != 0) {
                            Log.e("MicroMsg.SnsCdnDownloadBase", "download err, retCode: %d reqDownType: %d.", Integer.valueOf(dVar.field_retCode), Integer.valueOf(c.this.DPt.DPo));
                            com.tencent.mm.network.d.reportFailIp(dVar.field_serverIP);
                            if (9 == c.this.DPt.DPo) {
                                CdnLogic.BatchSnsReqImageData[] batchSnsReqImageDataArr = dVar.gqo;
                                if (batchSnsReqImageDataArr == null || batchSnsReqImageDataArr.length <= 0) {
                                    h.INSTANCE.dN(XWalkFeature.INTERFACE_SHOW_HIDE, 14);
                                    Log.e("MicroMsg.SnsCdnDownloadBase", "download error, totally re-download by single.");
                                    f fVar = (f) eVar;
                                    fVar.cBY = fVar.gqw;
                                    for (CdnLogic.BatchSnsReqImageData batchSnsReqImageData : fVar.gqo) {
                                        int i4 = batchSnsReqImageData.picIndex;
                                        aj.faJ().a(c.this.DPt.DEw.get(i4), 1, c.this.DPt.DDI.get(i4), c.this.DPt.DPp, fVar.dRS);
                                        Log.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", Integer.valueOf(i4));
                                    }
                                    i3 = 2;
                                } else {
                                    h.INSTANCE.dN(XWalkFeature.INTERFACE_SHOW_HIDE, 12);
                                    f fVar2 = (f) eVar;
                                    Log.e("MicroMsg.SnsCdnDownloadBase", "download err, taskInfo2 need inc counter, before: %d, inc: %d, count: %d.", Integer.valueOf(fVar2.cBY), Integer.valueOf(batchSnsReqImageDataArr.length), Integer.valueOf(fVar2.gqw));
                                    fVar2.cBY += batchSnsReqImageDataArr.length;
                                    for (CdnLogic.BatchSnsReqImageData batchSnsReqImageData2 : batchSnsReqImageDataArr) {
                                        if (batchSnsReqImageData2.retry) {
                                            int i5 = batchSnsReqImageData2.picIndex;
                                            aj.faJ().a(c.this.DPt.DEw.get(i5), 1, c.this.DPt.DDI.get(i5), c.this.DPt.DPp, fVar2.dRS);
                                            Log.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", Integer.valueOf(i5));
                                        }
                                    }
                                    i3 = 2;
                                }
                            } else {
                                i3 = 2;
                            }
                        } else {
                            Log.d("MicroMsg.SnsCdnDownloadBase", "download succ, type: %d.", Integer.valueOf(c.this.DPt.DPo));
                            c.this.DPM = (int) dVar.field_fileLength;
                            if (9 == c.this.DPt.DPo) {
                                f fVar3 = (f) eVar;
                                fVar3.cBY++;
                                Log.d("MicroMsg.SnsCdnDownloadBase", "download succ, counter++, res: %d, count: %d.", Integer.valueOf(fVar3.cBY), Integer.valueOf(fVar3.gqw));
                                fbX = c.this.YM(dVar.index);
                            } else {
                                fbX = c.this.fbX();
                            }
                            if (!fbX) {
                                i3 = 2;
                            } else {
                                i3 = c.this.DPt.DPm ? 3 : 1;
                            }
                        }
                        c.this.c(dVar);
                        a aVar = c.this.DPt;
                        if (aVar != null) {
                            try {
                                if (aVar.DIq != null && aVar.DIq.isAd) {
                                    int aOe = k.aOe(aVar.DIp);
                                    Log.i("SnsAdUtil", "reportAdPicCDNDownload, result=" + dVar.field_retCode + ", requestKey=" + aVar.DIp + ", reqDownType=" + aVar.DPo + ", url=" + aVar.url);
                                    if (aOe == 1 || aOe == 5) {
                                        if (dVar.field_retCode == 0) {
                                            k.c(0, 0, 1, aVar.url);
                                        } else {
                                            k.c(1, 0, 1, aVar.url);
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                Log.e("SnsAdUtil", "reportAdPicCDNDownload, exp=" + th.toString());
                            }
                        }
                        aj.dRd().post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.model.a.c.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(96066);
                                if (9 != c.this.DPt.DPo) {
                                    c.DPK.remove(c.this.DPt.DIp);
                                } else if (((f) eVar).alN()) {
                                    c.DPK.remove(c.this.DPt.DIp);
                                }
                                Log.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", Integer.valueOf(i3), c.this.DPt.url, c.this.DPt.mediaId, Long.valueOf(dVar.field_fileLength), Integer.valueOf(c.DPK.size()));
                                if (!c.this.DPt.DPm || i3 == 2) {
                                    if (!c.this.DPt.DPm && (c.this.DPt.DPo == 4 || c.this.DPt.DPo == 6)) {
                                        aj.faL().kf(c.this.DPt.mediaId, c.this.DPt.getPath() + r.j(c.this.ebR));
                                    }
                                } else if (9 == c.this.DPt.DPo) {
                                    bd.fF(c.this.DPt.DEw.get(dVar.index).Id, c.this.DPt.mediaType);
                                    c.this.YN(dVar.index);
                                } else {
                                    bd.fF(c.this.DPt.mediaId, c.this.DPt.mediaType);
                                    c.this.fca();
                                }
                                if (9 == c.this.DPt.DPo) {
                                    cnb cnb = c.this.DPt.DEw.get(dVar.index);
                                    f fVar = (f) eVar;
                                    if (fVar.alN() && !fVar.gqx) {
                                        fVar.gqx = true;
                                        long milliSecondsToNow = Util.milliSecondsToNow(currentTimeMillis);
                                        Log.d("MicroMsg.SnsCdnDownloadBase", "group download, feed cost: %d.", Long.valueOf(milliSecondsToNow));
                                        h.INSTANCE.n(1040, 3, milliSecondsToNow);
                                        h.INSTANCE.dN(XWalkFeature.INTERFACE_SHOW_HIDE, 4);
                                        h.INSTANCE.n(1040, 9, milliSecondsToNow);
                                        h.INSTANCE.n(1040, 10, (long) fVar.gqw);
                                    }
                                    c.this.DPr.a(i3, cnb, c.this.DPt.DPo, c.this.DPt.DPm, c.this.DPt.DIp, (int) dVar.field_fileLength, dVar.index, fVar.alN());
                                    AppMethodBeat.o(96066);
                                    return;
                                }
                                if (1 == c.this.DPt.DPo) {
                                    com.tencent.mm.plugin.sns.model.c faJ = aj.faJ();
                                    if (faJ.DGQ.remove(c.this.DPt.mediaId)) {
                                        long milliSecondsToNow2 = Util.milliSecondsToNow(currentTimeMillis);
                                        Log.d("MicroMsg.SnsCdnDownloadBase", "single download cost: %d.", Long.valueOf(milliSecondsToNow2));
                                        h.INSTANCE.n(1040, 6, milliSecondsToNow2);
                                        h.INSTANCE.dN(XWalkFeature.INTERFACE_SHOW_HIDE, 7);
                                    }
                                }
                                if (c.this.DPt.DPo == 4) {
                                    Log.i("MicroMsg.SnsCdnDownloadBase", "sight download cost=" + Util.milliSecondsToNow(currentTimeMillis) + ", mediaId=" + c.this.DPt.mediaId);
                                }
                                c.this.DPr.a(i3, c.this.ebR, c.this.DPt.DPo, c.this.DPt.DPm, c.this.DPt.DIp, (int) dVar.field_fileLength, -1, true);
                                AppMethodBeat.o(96066);
                            }
                        });
                    } else if (cVar != null) {
                        float f2 = ((float) cVar.field_finishedLength) / ((float) cVar.field_toltalLength);
                        if (c.this.DPt.DPq < f2) {
                            c.this.DPt.DPq = f2;
                            Log.d("MicroMsg.SnsCdnDownloadBase", "Download sns image type: %d, mediaId: %s, progress: %f, url: %s", Integer.valueOf(c.this.DPt.DPo), str, Float.valueOf(f2), c.this.DPt.url);
                        }
                    }
                    if (i2 != 0) {
                        Log.e("MicroMsg.SnsCdnDownloadBase", "task build error! startRet: %d, type: %d.", Integer.valueOf(i2), Integer.valueOf(c.this.DPt.DPo));
                        if (9 == c.this.DPt.DPo) {
                            h.INSTANCE.dN(XWalkFeature.INTERFACE_SHOW_HIDE, 13);
                            c.DPK.remove(c.this.DPt.DIp);
                            c.this.DPr.a(2, null, c.this.DPt.DPo, c.this.DPt.DPm, c.this.DPt.DIp, -1, -1, true);
                            f fVar4 = (f) eVar;
                            for (CdnLogic.BatchSnsReqImageData batchSnsReqImageData3 : fVar4.gqo) {
                                int i6 = batchSnsReqImageData3.picIndex;
                                aj.faJ().a(c.this.DPt.DEw.get(i6), 1, c.this.DPt.DDI.get(i6), c.this.DPt.DPp, fVar4.dRS);
                                Log.i("MicroMsg.SnsCdnDownloadBase", "group download err, retry single download. index: %d.", Integer.valueOf(i6));
                            }
                        }
                    }
                    AppMethodBeat.o(96067);
                    return 0;
                }

                @Override // com.tencent.mm.i.g.a
                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                @Override // com.tencent.mm.i.g.a
                public final byte[] f(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (com.tencent.mm.an.f.baQ().b(eVar, -1)) {
                Log.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
                i2 = 1;
                return Integer.valueOf(i2);
            }
            Log.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
        }
        i2 = 2;
        return Integer.valueOf(i2);
    }

    private boolean a(e eVar, boolean z, String str) {
        String str2;
        try {
            this.host = new URL(this.DPt.url).getHost();
            ArrayList arrayList = new ArrayList();
            this.jDL = com.tencent.mm.network.d.a(this.host, false, arrayList);
            ArrayList arrayList2 = new ArrayList();
            int a2 = com.tencent.mm.network.d.a(this.host, true, arrayList2);
            if (9 == this.DPt.DPo) {
                eVar.field_mediaId = this.DPt.dRS + "_" + this.DPt.DPo;
                if (eVar instanceof f) {
                    f fVar = (f) eVar;
                    fVar.dRS = this.DPt.dRS;
                    fVar.gqv = this.DPt.size;
                    fVar.gqw = this.DPt.DEw.size();
                    fVar.gqo = new CdnLogic.BatchSnsReqImageData[fVar.gqw];
                    for (int i2 = 0; i2 < fVar.gqw; i2++) {
                        int keyAt = this.DPt.DEw.keyAt(i2);
                        cnb cnb = this.DPt.DEw.get(keyAt);
                        CdnLogic.BatchSnsReqImageData batchSnsReqImageData = new CdnLogic.BatchSnsReqImageData();
                        String str3 = cnb.Msz;
                        if (Util.isNullOrNil(str3) && cnb.oUv == 2) {
                            str3 = cnb.Url;
                        }
                        batchSnsReqImageData.url = b(str3, cnb);
                        batchSnsReqImageData.picIndex = keyAt;
                        batchSnsReqImageData.totalFileSize = 0;
                        batchSnsReqImageData.decryptKey = cnb.MsR;
                        batchSnsReqImageData.imageCachePath = s.k(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.n(cnb), false);
                        batchSnsReqImageData.fileKey = cnb.Id + "_" + this.DPt.DPo;
                        fVar.gqo[i2] = batchSnsReqImageData;
                    }
                }
            } else {
                eVar.field_mediaId = this.DPt.mediaId + "_" + this.DPt.DPo;
                eVar.gqq = this.DPt.getPath() + this.DPt.fbV();
                if (this.DPt.DIq != null) {
                    if (this.DPt.DPm) {
                        str2 = this.DPt.DIq.MsR;
                    } else {
                        str2 = this.DPt.DIq.MsO;
                    }
                    eVar.snsCipherKey = str2;
                }
            }
            eVar.url = this.DPt.url;
            eVar.host = this.host;
            eVar.referer = str;
            eVar.gqr = ef(arrayList);
            eVar.gqs = ef(arrayList2);
            eVar.gqt = this.jDL;
            eVar.gqu = a2;
            eVar.isColdSnsData = z;
            eVar.signalQuality = new StringBuilder().append(NetStatusUtil.getStrength(MMApplicationContext.getContext())).toString();
            eVar.snsScene = this.DPt.DPp.tag;
            if (this.DPt.DPo == 8) {
                eVar.fuQ = 3;
                eVar.appType = 109;
                eVar.fileType = 20204;
            } else if (this.DPt.DPo == 6 || this.DPt.DPo == 4) {
                eVar.fuQ = 3;
                eVar.appType = 105;
                eVar.fileType = CdnLogic.kMediaTypeAdVideo;
            } else if (this.DPt.DPo == 5) {
                eVar.fuQ = 3;
                eVar.appType = 150;
                eVar.fileType = 20250;
            } else if (this.DPt.DPo == 2 || this.DPt.DPo == 1 || this.DPt.DPo == 3 || this.DPt.DPo == 9) {
                eVar.fuQ = 3;
                eVar.appType = 100;
                eVar.fileType = 20201;
                if (this.DPt.DPo == 1 && ((this.DPt.url.startsWith("http://wxapp.tc.qq.com") || this.DPt.url.startsWith("https://wxapp.tc.qq.com")) && ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_download_wxapp_entry, 1) == 1)) {
                    eVar.fuQ = 3;
                    eVar.appType = 150;
                    eVar.fileType = 20201;
                }
            }
            Log.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d taskInfo:%s", Integer.valueOf(this.DPt.DPo), eVar);
            return true;
        } catch (MalformedURLException e2) {
            Log.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e2, "", new Object[0]);
            Log.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:".concat(String.valueOf(e2)));
            return false;
        }
    }

    private static String[] ef(List<String> list) {
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = list.get(i2);
        }
        return strArr;
    }

    public final void fcb() {
        if (this.DPt != null) {
            Log.i("MicroMsg.SnsCdnDownloadBase", "checkCdnPath: %s", Boolean.valueOf(s.boN(this.DPt.getPath())));
        }
    }

    public void onPostExecute(Integer num) {
        super.onPostExecute((Object) num);
    }

    public void fca() {
        int i2 = 0;
        if (!aj.isInValid()) {
            System.currentTimeMillis();
            if (this.DPt.DDH.DEs == 4) {
                Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
                this.DPs = com.tencent.mm.plugin.sns.lucky.a.a.kd(this.DPt.getPath() + r.e(this.ebR), this.DPt.getPath() + r.g(this.ebR));
                aj.faL().a(this.DPt.mediaId, this.DPs, this.DPt.DDH.DEs);
            } else if (this.DPt.DDH.DEs == 5) {
                Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
                this.DPs = com.tencent.mm.plugin.sns.lucky.a.a.kd(this.DPt.getPath() + r.e(this.ebR), this.DPt.getPath() + r.h(this.ebR));
                aj.faL().a(this.DPt.mediaId, this.DPs, this.DPt.DDH.DEs);
            } else if (this.DPt.DDH.list.size() <= 1) {
                aj.faL().a(this.DPt.mediaId, this.DPs, this.DPt.DDH.DEs);
            } else {
                aj.faL().a(this.DPt.mediaId, this.DPs, 0);
                LinkedList linkedList = new LinkedList();
                while (i2 < this.DPt.DDH.list.size() && i2 < 4) {
                    cnb cnb = this.DPt.DDH.list.get(i2);
                    com.tencent.mm.memory.n aOZ = aj.faL().aOZ(cnb.Id);
                    if (r.b(aOZ)) {
                        linkedList.add(aOZ);
                        Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + aOZ + " " + cnb.Id);
                        i2++;
                    } else {
                        return;
                    }
                }
                this.DPs = com.tencent.mm.memory.n.H(r.z(linkedList, aj.fbb()));
                Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.DPt.DDH.dPI + " " + this.DPs);
                aj.faL().a(this.DPt.DDH.dPI, this.DPs, this.DPt.DDH.DEs);
            }
            String str = null;
            if (this.DPt.DDH.DEs == 0) {
                str = "0-" + this.DPt.DDH.dPI;
            } else if (this.DPt.DDH.DEs == 1) {
                str = "1-" + this.DPt.DDH.dPI;
            } else if (this.DPt.DDH.DEs == 4) {
                str = "4-" + this.DPt.DDH.dPI;
            } else if (this.DPt.DDH.DEs == 5) {
                str = "5-" + this.DPt.DDH.dPI;
            } else if (this.DPt.DDH.DEs == 3) {
                str = r.cq(3, this.DPt.DDH.dPI);
            }
            aj.faL().aOY(str);
        }
    }

    public final void YN(int i2) {
        String str;
        if (!aj.isInValid()) {
            com.tencent.mm.plugin.sns.data.n nVar = this.DPt.DDI.get(i2);
            Log.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode index: %d decodeType: %d.", Integer.valueOf(i2), Integer.valueOf(nVar.DEs));
            aj.faL().a(this.DPt.DEw.get(i2).Id, this.DPN.get(i2), nVar.DEs);
            if (nVar.DEs == 0) {
                str = r.cq(0, nVar.dPI);
            } else {
                str = null;
            }
            Log.i("MicroMsg.SnsCdnDownloadBase", "thumbAddDecode cacheName: %s.", str);
            aj.faL().aOY(str);
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.n
    public ExecutorService eGk() {
        return aj.fay();
    }
}
