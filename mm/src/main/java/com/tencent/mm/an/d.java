package com.tencent.mm.an;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bjz;
import com.tencent.mm.protocal.protobuf.bka;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d extends q implements m {
    public static long iSe = 0;
    private static Map<String, a> iSf = new HashMap();
    private i callback;
    private String iSg = "";
    private final com.tencent.mm.ak.d rr;
    int scene = 0;
    public long startTime = 0;

    static {
        AppMethodBeat.i(150429);
        AppMethodBeat.o(150429);
    }

    static class a {
        boolean iSh = false;
        long iSi = 0;
        long iSj = 0;
        long iSk = 0;

        a() {
        }

        public final String toString() {
            AppMethodBeat.i(150423);
            String format = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", Integer.valueOf(hashCode()), Boolean.valueOf(this.iSh), Long.valueOf(this.iSi), Long.valueOf(this.iSj), Long.valueOf(this.iSk));
            AppMethodBeat.o(150423);
            return format;
        }
    }

    protected d(int i2) {
        AppMethodBeat.i(150424);
        Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", Integer.valueOf(i2), Util.getStack());
        d.a aVar = new d.a();
        aVar.iLN = new bjz();
        aVar.iLO = new bka();
        aVar.uri = "/cgi-bin/micromsg-bin/getcdndns";
        aVar.funcId = 379;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.scene = i2;
        bjz bjz = (bjz) this.rr.iLK.iLR;
        bjz.LTp = "";
        bjz.Scene = i2;
        AppMethodBeat.o(150424);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150425);
        this.callback = iVar;
        com.tencent.mm.kernel.g.aAf();
        int uin = com.tencent.mm.kernel.a.getUin();
        if (uin == 0) {
            Log.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
            AppMethodBeat.o(150425);
            return -1;
        }
        if (iSe != ((long) uin)) {
            iSe = (long) uin;
            iSf.clear();
        }
        long nowSecond = Util.nowSecond();
        if (this.scene == 0) {
            this.iSg = Util.nullAs(baM(), "");
            a aVar = iSf.get(this.iSg);
            if (aVar == null) {
                aVar = new a();
                iSf.put(this.iSg, aVar);
                Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", aVar, this.iSg);
            }
            if (aVar.iSh) {
                aVar.iSi = nowSecond;
                aVar.iSj = nowSecond;
                aVar.iSk = 0;
            }
            Log.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", Long.valueOf(nowSecond - aVar.iSi), Long.valueOf(nowSecond - aVar.iSj), Long.valueOf(aVar.iSk));
            if (nowSecond > aVar.iSi && nowSecond - aVar.iSi < 10) {
                Log.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", Long.valueOf(nowSecond - aVar.iSi), aVar);
                AppMethodBeat.o(150425);
                return -1;
            } else if (nowSecond <= aVar.iSj || nowSecond - aVar.iSj >= 3600 || aVar.iSk < 90) {
                aVar.iSi = nowSecond;
                if (nowSecond < aVar.iSj || nowSecond - aVar.iSk > 3600) {
                    aVar.iSj = nowSecond;
                    aVar.iSk = 0;
                } else {
                    aVar.iSk++;
                }
            } else {
                Log.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", Long.valueOf(nowSecond - aVar.iSj), aVar);
                AppMethodBeat.o(150425);
                return -1;
            }
        } else {
            this.iSg = "";
            Iterator<a> it = iSf.values().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null) {
                        next.iSi = nowSecond;
                        if (nowSecond < next.iSj || nowSecond - next.iSk > 3600) {
                            next.iSj = nowSecond;
                            next.iSk = 0;
                        } else {
                            next.iSk++;
                        }
                    }
                }
            }
        }
        this.startTime = nowSecond;
        h.INSTANCE.idkeyStat(546, this.scene == 0 ? 0 : 1, 1, true);
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150425);
        return dispatch;
    }

    private static String baM() {
        String str;
        AppMethodBeat.i(150426);
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            AppMethodBeat.o(150426);
            return null;
        }
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            str = "wifi_" + NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
        } else {
            str = "mobile_" + NetStatusUtil.getNetTypeString(MMApplicationContext.getContext()) + "_" + NetStatusUtil.getISPCode(MMApplicationContext.getContext());
        }
        Log.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", str);
        if (str == null || str.length() < 2) {
            AppMethodBeat.o(150426);
            return null;
        }
        String format = String.format("%x", Integer.valueOf(str.hashCode()));
        StringBuilder sb = new StringBuilder();
        f.baN();
        String sb2 = sb.append(f.baO()).append(format).toString();
        AppMethodBeat.o(150426);
        return sb2;
    }

    private static CdnLogic.CdnInfoParams a(tb tbVar) {
        AppMethodBeat.i(150427);
        CdnLogic.CdnInfoParams cdnInfoParams = new CdnLogic.CdnInfoParams();
        cdnInfoParams.c2CretryIntervalMs = tbVar.Lbe;
        cdnInfoParams.c2CrwtimeoutMs = tbVar.Lbg;
        cdnInfoParams.c2CshowErrorDelayMs = tbVar.Lbc;
        cdnInfoParams.snsretryIntervalMs = tbVar.Lbf;
        cdnInfoParams.snsrwtimeoutMs = tbVar.Lbh;
        cdnInfoParams.snsshowErrorDelayMs = tbVar.Lbd;
        AppMethodBeat.o(150427);
        return cdnInfoParams;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(150428);
        Log.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + i3 + " errcode:" + i4);
        bka bka = (bka) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0 && bka.KQK != null) {
            String baM = baM();
            if (!Util.isNullOrNil(baM) && !Util.isNullOrNil(this.iSg) && !baM.equals(this.iSg)) {
                Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", baM, this.iSg);
                h.INSTANCE.idkeyStat(546, 6, 1, true);
            }
            iSf.clear();
            byte[] bArr2 = null;
            if (bka.KQN != null && bka.KQN.getILen() > 0) {
                Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", Integer.valueOf(bka.KQN.getILen()));
                bArr2 = z.a(bka.KQN);
            }
            byte[] bArr3 = null;
            if (bka.KQO != null && bka.KQO.getILen() > 0) {
                Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", Integer.valueOf(bka.KQO.getILen()));
                bArr3 = z.a(bka.KQO);
            }
            Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", bka.KQP);
            if (bka.KQP != null) {
                Log.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", Integer.valueOf(bka.KQP.rBx), bka.KQP.Lbo);
            }
            if (!f.baR().a(bka.KQK, bka.KQL, bka.KQM, bArr2, bArr3, bka.KQP)) {
                Log.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(150428);
                return;
            }
            Log.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", bka.KQR, bka.KQS, Integer.valueOf(bka.KQQ));
            if (!(bka.KQR == null || bka.KQS == null)) {
                CdnLogic.setCdnInfoParams(a(bka.KQR), a(bka.KQS), bka.KQQ);
            }
            if (bka.LTq == 1) {
                z = true;
            } else {
                z = false;
            }
            CdnLogic.setUseIPv6Cdn(z);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(150428);
            return;
        }
        h.INSTANCE.a(10769, Integer.valueOf(c.iSd), 0, Long.valueOf(this.startTime));
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Integer.valueOf(i4);
        objArr[2] = Boolean.valueOf(bka.KQK == null);
        Log.w("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd: [%d ,%d]  info is null :%b", objArr);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(150428);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 379;
    }
}
