package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.c.d;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.network.d;
import com.tencent.mm.network.x;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.lucky.a.a;
import com.tencent.mm.plugin.sns.model.a.c;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.bp;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public abstract class b extends c {
    private static HashSet<String> DPK = new HashSet<>();
    protected long DPA = -1;
    protected long DPB = -1;
    protected long DPC = -1;
    protected String DPD = "";
    protected PString DPE = new PString();
    protected int DPF;
    protected long DPG;
    protected long DPH;
    protected long DPI;
    protected int DPJ = 0;
    private Map<String, List<String>> DPL;
    int DPM = 0;
    protected c.a DPr;
    protected n DPs = null;
    protected a DPt = null;
    private String DPu = "";
    private String DPv = "";
    private String DPw = "";
    private int DPx = 0;
    protected int DPy = 0;
    private long DPz = -1;
    private int cnR = 0;
    private long dnsCostTime = -1;
    protected cnb ebR = null;
    private String host = "";
    private int jDL = -1;
    private int retCode = -1;

    public abstract boolean K(InputStream inputStream);

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public abstract boolean fbX();

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.model.a.c
    public abstract int getMediaType();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // com.tencent.mm.pluginsdk.model.n, com.tencent.mm.plugin.sns.model.a.c
    public final /* synthetic */ Integer doInBackground(String[] strArr) {
        return fbZ();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // com.tencent.mm.pluginsdk.model.n
    public final /* synthetic */ void onProgressUpdate(Integer[] numArr) {
        Integer[] numArr2 = numArr;
        if (numArr2 != null && numArr2.length != 0) {
            Log.i("MicroMsg.SnsCdnDownloadBase", "responeTotalLen:%d, downloadlen:%d ", Integer.valueOf(this.DPJ), numArr2[0]);
        }
    }

    public b(c.a aVar, a aVar2) {
        super(aVar, aVar2);
        this.DPr = aVar;
        this.DPt = aVar2;
        if (aVar2 != null) {
            this.ebR = aVar2.DIq;
            DPK.add(aVar2.DIp);
            aVar2.init();
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public boolean fbW() {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public String aPI(String str) {
        return str;
    }

    public x a(x xVar) {
        return xVar;
    }

    protected static boolean a(int i2, long j2, PString pString) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j2 < 1000) {
            return false;
        }
        pString.value += String.format("ts=%d&size=%d|", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i2));
        return true;
    }

    private void fbY() {
        String str;
        int i2;
        Log.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", this.DPE.value);
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
        com.tencent.mm.storage.c Fu = d.aXu().Fu(str);
        if (Fu.isValid()) {
            i2 = Util.getInt(Fu.gzz().get("needUploadData"), 1);
            str2 = Fu.field_expId;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            m mVar = new m();
            mVar.n("20ImgSize", this.DPM + ",");
            mVar.n("21NetType", (NetStatusUtil.isWifi(MMApplicationContext.getContext()) ? 1 : 0) + ",");
            mVar.n("22DelayTime", (this.DPz - this.DPA) + ",");
            mVar.n("23RetCode", this.retCode + ",");
            mVar.n("24DnsCostTime", this.dnsCostTime + ",");
            mVar.n("25ConnectCostTime", this.DPA + ",");
            mVar.n("26SendCostTime", ",");
            mVar.n("27WaitResponseCostTime", this.DPH + ",");
            mVar.n("28ReceiveCostTime", this.DPB + ",");
            mVar.n("29ClientAddrIP", this.DPv + ",");
            mVar.n("30ServerAddrIP", this.DPw + ",");
            mVar.n("31dnstype", this.jDL + ",");
            mVar.n("32signal", NetStatusUtil.getStrength(MMApplicationContext.getContext()) + ",");
            mVar.n("33host", this.host + ",");
            mVar.n("34MediaType", mediaType + ",");
            mVar.n("35X_Errno", this.DPx + ",");
            mVar.n("36MaxPackageSize", this.DPF + ",");
            mVar.n("37MaxPackageTimeStamp", this.DPG + ",");
            mVar.n("38PackageRecordList", this.DPE.value + ",");
            mVar.n("39ExpLayerId", str + ",");
            mVar.n("40ExpId", str2 + ",");
            mVar.n("41FeedId", ",");
            Log.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + mVar.abW());
            h.INSTANCE.a(13480, mVar);
            if (this.retCode != 200) {
                h.INSTANCE.a(14071, mVar);
            }
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final boolean a(bp bpVar, String str, long j2, String str2) {
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

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final Integer fbZ() {
        String str;
        boolean z;
        g.aAi();
        if (!g.aAh().isSDCardAvailable() || this.DPt == null) {
            dP(false);
            return 2;
        }
        if (fbW()) {
            String str2 = this.DPt.DIl + this.DPt.fbV();
            Log.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", str2);
            s.deleteFile(str2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.DPC = System.currentTimeMillis();
        Log.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.DPt.mediaId + " " + this.DPt.DPm + " type " + this.DPt.DPo);
        s.boN(this.DPt.getPath());
        bp bpVar = this.DPt.DPp;
        String str3 = "";
        if (bpVar == null) {
            str3 = "";
            bpVar = bp.Oqt;
        } else if (bpVar.equals(bp.Oqm)) {
            str3 = "album_friend";
        } else if (bpVar.equals(bp.Oqn)) {
            str3 = "album_self";
        } else if (bpVar.equals(bp.Oqo)) {
            str3 = "album_stranger";
        } else if (bpVar.equals(bp.Oqp)) {
            str3 = "profile_friend";
        } else if (bpVar.equals(bp.Oqq)) {
            str3 = "profile_stranger";
        } else if (bpVar.equals(bp.Oqr)) {
            str3 = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
        } else if (bpVar.equals(bp.Oql)) {
            str3 = "timeline";
        }
        if (!Util.isNullOrNil(str3)) {
            str3 = "&scene=".concat(String.valueOf(str3));
        }
        String format = String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s", Integer.valueOf(com.tencent.mm.protocal.d.KyO), p.getString(aj.fav()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(NetStatusUtil.getStrength(MMApplicationContext.getContext())), str3);
        this.DPt.url = aPI(this.DPt.url);
        this.dnsCostTime = Util.nowMilliSecond();
        String str4 = this.DPt.DPn ? "SnsSightDomainList" : "SnsAlbumDomainList";
        String str5 = this.DPt.DPn ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime";
        String value = com.tencent.mm.n.h.aqJ().getValue(str4);
        long j2 = (long) com.tencent.mm.n.h.aqJ().getInt(str5, 0);
        Log.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", Boolean.valueOf(this.DPt.DPn), Boolean.valueOf(this.DPt.DPm), value, Long.valueOf(j2));
        if (j2 <= 0) {
            j2 = 259200;
        }
        boolean a2 = a(bpVar, this.DPt.url, j2, value);
        d.b bVar = new d.b(this.DPt.url, a2);
        this.dnsCostTime = Util.milliSecondsToNow(this.dnsCostTime);
        try {
            if (Util.isNullOrNil(bVar.ip)) {
                str = InetAddress.getByName(bVar.host).getHostAddress();
            } else {
                str = bVar.ip;
            }
        } catch (Exception e2) {
            str = "-";
        }
        Log.i("MicroMsg.SnsCdnDownloadBase", "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]", format, this.DPt.url, this.DPt.mediaId, Integer.valueOf(bVar.jDL), str, this.DPt.url, Integer.valueOf(this.DPt.DPo), Boolean.valueOf(a2), bpVar.toString());
        this.DPy = 1;
        x a3 = a(bVar, format);
        Object[] objArr = new Object[5];
        objArr[0] = bVar.ip;
        if (a3 != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(this.DPy);
        objArr[3] = Boolean.valueOf(bVar.jDO);
        objArr[4] = bVar.jDN;
        Log.i("MicroMsg.SnsCdnDownloadBase", "[sns ip strategy]connect ip:%s, result:%b, canRetry(X-RtFlag):%d, isDC(cold ip):%b, url:%s", objArr);
        int i2 = 2;
        if (a3 != null) {
            i2 = b(a3);
        }
        Log.i("MicroMsg.SnsCdnDownloadBase", "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d", Long.valueOf(Util.milliSecondsToNow(currentTimeMillis)), Long.valueOf(this.DPz), this.DPt.mediaId, this.DPt.url, Integer.valueOf(this.DPM));
        return Integer.valueOf(i2);
    }

    private x a(d.b bVar, String str) {
        try {
            this.DPw = bVar.ip;
            this.jDL = bVar.jDL;
            this.DPA = Util.nowMilliSecond();
            x a2 = com.tencent.mm.network.d.a(this.DPt.url, bVar);
            a2.setRequestMethod("GET");
            a2.setRequestProperty("referer", str);
            if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsDownloadHttpKeep"), 0) > 0) {
                Log.i("MicroMsg.SnsCdnDownloadBase", "header Connection close ");
                a2.setRequestProperty("Connection", "close");
            }
            a2.setConnectTimeout(25000);
            a2.setReadTimeout(25000);
            x a3 = a(a2);
            this.DPL = a3.getHeaderFields();
            List<String> list = this.DPL.get("X-ClientIp");
            if (list != null && list.size() > 0) {
                this.DPv = list.get(0);
            }
            List<String> list2 = this.DPL.get("X-ServerIp");
            if (list2 != null && list2.size() > 0) {
                this.DPu = list2.get(0);
            }
            List<String> list3 = this.DPL.get("X-ErrNo");
            if (list3 != null && list3.size() > 0) {
                this.DPx = Util.safeParseInt(list3.get(0));
            }
            List<String> list4 = this.DPL.get("X-RtFlag");
            if (list4 != null && list4.size() > 0) {
                this.DPy = Util.safeParseInt(list4.get(0));
            }
            try {
                this.retCode = a3.getResponseCode();
                this.host = a3.url.getHost();
                if (this.retCode == 200 || this.retCode == 206) {
                    aM(a3.getHeaderFields());
                    if (!c(a3)) {
                        h.INSTANCE.idkeyStat(22, 62, 1, true);
                        Log.e("MicroMsg.SnsCdnDownloadBase", "checkHttpConnection failed! nocache mediaId : " + this.DPt.mediaId);
                        dP(false);
                        return null;
                    }
                    this.DPA = Util.milliSecondsToNow(this.DPA);
                    List<String> list5 = this.DPL.get("Content-Length");
                    if (list5 != null && list5.size() > 0) {
                        this.DPJ = Util.safeParseInt(list5.get(0));
                    }
                    Log.i("MicroMsg.SnsCdnDownloadBase", "ip: url %s client ip %s server ip %s svrlen %d %d", this.DPt.url, this.DPv, this.DPu, Integer.valueOf(this.DPJ), Integer.valueOf(this.DPx));
                    return a3;
                }
                aM(a3.getHeaderFields());
                if (this.DPt.DPn) {
                    if (this.retCode >= 400 && this.retCode < 500) {
                        h.INSTANCE.idkeyStat(22, 78, 1, true);
                    } else if (this.retCode >= 500 && this.retCode < 600) {
                        h.INSTANCE.idkeyStat(22, 79, 1, true);
                    }
                } else if (this.retCode >= 400 && this.retCode < 500) {
                    h.INSTANCE.idkeyStat(22, 56, 1, true);
                } else if (this.retCode >= 500 && this.retCode < 600) {
                    h.INSTANCE.idkeyStat(22, 57, 1, true);
                }
                if (this.DPt.DPm) {
                    h.INSTANCE.idkeyStat(150, 14, 1, true);
                }
                Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.DPt.mediaId + " " + this.DPt.url + " " + this.retCode);
                dP(false);
                return null;
            } catch (SocketTimeoutException e2) {
                this.retCode = 1;
                dP(false);
                String message = e2.getMessage();
                if (this.DPt.DPn) {
                    h.INSTANCE.idkeyStat(22, 77, 1, true);
                } else {
                    h.INSTANCE.idkeyStat(22, 55, 1, true);
                }
                if (this.DPt.DPm) {
                    h.INSTANCE.idkeyStat(150, 14, 1, true);
                }
                Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! socket timeout mediaId : " + this.DPt.mediaId + " " + this.DPt.url + " msg:" + message);
                return null;
            } catch (Exception e3) {
                dP(false);
                String message2 = e3.getMessage();
                if (this.DPt.DPm) {
                    h.INSTANCE.idkeyStat(150, 14, 1, true);
                }
                Log.e("MicroMsg.SnsCdnDownloadBase", "GprsSetting.checkHttpConnection failed! mediaId : " + this.DPt.mediaId + " " + this.DPt.url + " msg:" + message2);
                return null;
            }
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e4, "connect fail : " + e4.getMessage(), new Object[0]);
            this.retCode = 2;
            dP(false);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a5 A[SYNTHETIC, Splitter:B:26:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00be A[SYNTHETIC, Splitter:B:34:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int b(com.tencent.mm.network.x r10) {
        /*
        // Method dump skipped, instructions count: 224
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.a.b.b(com.tencent.mm.network.x):int");
    }

    private static void aM(Map<String, List<String>> map) {
        if (map != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : map.keySet()) {
                    List<String> list = map.get(str);
                    if (list != null) {
                        stringBuffer.append(str + ":");
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            stringBuffer.append(it.next() + "|");
                        }
                        stringBuffer.append(";");
                    }
                }
                Log.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", stringBuffer.toString());
            } catch (Exception e2) {
            }
        }
    }

    private static boolean c(x xVar) {
        try {
            List<String> list = xVar.getHeaderFields().get("cache-control");
            if (list == null || list.size() == 0) {
                return true;
            }
            if (Util.isNullOrNil(list.toString()) || !list.toString().contains("no-cache")) {
                return true;
            }
            return list.toString().contains("no-cache") ? false : false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e2, "", new Object[0]);
            return false;
        }
    }

    private static long aPJ(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            String[] split = str.split("\\.");
            return Util.getLong(split[3], 0) + (16777216 * Util.getLong(split[0], 0)) + (65536 * Util.getLong(split[1], 0)) + (256 * Util.getLong(split[2], 0));
        } catch (Exception e2) {
            return 0;
        }
    }

    private void dP(boolean z) {
        if (this.DPt == null || !this.DPt.DPn) {
            if (!z) {
                h.INSTANCE.idkeyStat(22, 52, 1, true);
            } else {
                h.INSTANCE.idkeyStat(22, 53, this.DPz, true);
            }
            h.INSTANCE.idkeyStat(22, 51, 1, true);
        } else {
            if (!z) {
                h.INSTANCE.idkeyStat(22, 74, 1, true);
            } else {
                h.INSTANCE.idkeyStat(22, 75, this.DPz, true);
            }
            h.INSTANCE.idkeyStat(22, 73, 1, true);
        }
        if (this.DPt != null && this.DPt.DPm && !z && !r.b(this.DPs)) {
            h.INSTANCE.idkeyStat(150, 66, 1, true);
        }
        this.cnR = this.DPM;
        int i2 = NetStatusUtil.isWifi(MMApplicationContext.getContext()) ? 1 : 0;
        int strength = NetStatusUtil.getStrength(MMApplicationContext.getContext());
        Object[] objArr = new Object[11];
        objArr[0] = Integer.valueOf(this.jDL);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(strength);
        objArr[3] = Long.valueOf(this.dnsCostTime);
        objArr[4] = Long.valueOf(this.DPA);
        objArr[5] = Long.valueOf(this.DPB);
        objArr[6] = Long.valueOf(this.DPz);
        objArr[7] = this.DPu;
        objArr[8] = this.DPw;
        objArr[9] = this.DPv;
        objArr[10] = this.DPt == null ? "" : this.DPt.url;
        Log.v("MicroMsg.SnsCdnDownloadBase", "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]", objArr);
        int netType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
        int i3 = 0;
        if (this.DPt != null) {
            i3 = this.DPt.DPo == 4 ? 1 : 0;
        }
        Log.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", Integer.valueOf(this.retCode), Integer.valueOf(this.cnR), Integer.valueOf(netType), Integer.valueOf(i3), Integer.valueOf(this.DPx));
        h hVar = h.INSTANCE;
        Object[] objArr2 = new Object[19];
        objArr2[0] = this.DPt == null ? "" : this.DPt.url;
        objArr2[1] = Long.valueOf(aPJ(this.DPw));
        objArr2[2] = Long.valueOf(z ? this.DPz : 0);
        objArr2[3] = "";
        objArr2[4] = Integer.valueOf(i2);
        objArr2[5] = Long.valueOf(this.dnsCostTime);
        objArr2[6] = Long.valueOf(this.DPA);
        objArr2[7] = 0;
        objArr2[8] = 0;
        objArr2[9] = Long.valueOf(this.DPB);
        objArr2[10] = Long.valueOf(aPJ(this.DPv));
        objArr2[11] = Long.valueOf(aPJ(this.DPu));
        objArr2[12] = Integer.valueOf(this.jDL);
        objArr2[13] = Integer.valueOf(strength);
        objArr2[14] = Integer.valueOf(this.retCode);
        objArr2[15] = Integer.valueOf(this.cnR);
        objArr2[16] = Integer.valueOf(netType);
        objArr2[17] = Integer.valueOf(i3);
        objArr2[18] = Integer.valueOf(this.DPx);
        hVar.a(10736, objArr2);
        boolean isConnected = NetStatusUtil.isConnected(MMApplicationContext.getContext());
        Log.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + isConnected + " urlIp: " + this.DPD);
        if (!z && !Util.isNullOrNil(this.DPD) && isConnected) {
            com.tencent.mm.network.d.reportFailIp(this.DPD);
        }
        fbY();
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.DPt != null) {
            Log.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", num, this.DPt.url, this.DPt.mediaId, Integer.valueOf(this.cnR), Integer.valueOf(DPK.size()));
            DPK.remove(this.DPt.DIp);
            if (this.DPt.DPm && num.intValue() != 2) {
                bd.fF(this.DPt.mediaId, this.DPt.mediaType);
                fca();
            } else if (!this.DPt.DPm && this.DPt.DPo == 4) {
                aj.faL().kf(this.DPt.mediaId, this.DPt.getPath() + r.j(this.ebR));
            }
            this.DPr.a(num.intValue(), this.ebR, this.DPt.DPo, this.DPt.DPm, this.DPt.DIp, this.cnR, -1, true);
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final void fca() {
        int i2 = 0;
        if (!aj.isInValid()) {
            System.currentTimeMillis();
            if (this.DPt.DDH.DEs == 4) {
                Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
                this.DPs = a.kd(this.DPt.getPath() + r.e(this.ebR), this.DPt.getPath() + r.g(this.ebR));
                aj.faL().a(this.DPt.mediaId, this.DPs, this.DPt.DDH.DEs);
            } else if (this.DPt.DDH.DEs == 5) {
                Log.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
                this.DPs = a.kd(this.DPt.getPath() + r.e(this.ebR), this.DPt.getPath() + r.h(this.ebR));
                aj.faL().a(this.DPt.mediaId, this.DPs, this.DPt.DDH.DEs);
            } else if (this.DPt.DDH.list.size() <= 1) {
                aj.faL().a(this.DPt.mediaId, this.DPs, this.DPt.DDH.DEs);
            } else {
                aj.faL().a(this.DPt.mediaId, this.DPs, 0);
                LinkedList linkedList = new LinkedList();
                while (i2 < this.DPt.DDH.list.size() && i2 < 4) {
                    cnb cnb = this.DPt.DDH.list.get(i2);
                    n aOZ = aj.faL().aOZ(cnb.Id);
                    if (r.b(aOZ)) {
                        linkedList.add(aOZ);
                        Log.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + aOZ + " " + cnb.Id);
                        i2++;
                    } else {
                        return;
                    }
                }
                this.DPs = n.H(r.z(linkedList, aj.fbb()));
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
            }
            aj.faL().aOY(str);
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.n, com.tencent.mm.plugin.sns.model.a.c
    public final ExecutorService eGk() {
        return aj.fay();
    }
}
