package com.tencent.mm.bn;

import com.tencent.mars.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.ebz;
import com.tencent.mm.protocal.protobuf.ecb;
import com.tencent.mm.protocal.protobuf.ecc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.utils.TbsLog;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class a extends q implements m {
    private i heq;
    private int jGA;
    private int jGB;
    private ebz jGC;
    private ebz jGD;
    private String jGE;
    private b jGx;
    private int jGy;
    private int jGz;
    private d rr = null;

    public a(b bVar, int i2, int i3, int i4, int i5, ebz ebz, ebz ebz2, String str) {
        AppMethodBeat.i(20678);
        this.jGx = bVar;
        this.jGy = i2;
        this.jGz = i3;
        this.jGA = i4;
        this.jGB = i5;
        this.jGC = ebz;
        this.jGD = ebz2;
        this.jGE = str;
        d.a aVar = new d.a();
        aVar.iLN = new ecb();
        aVar.iLO = new ecc();
        aVar.funcId = a.C0691a.CTRL_INDEX;
        aVar.uri = "/cgi-bin/micromsg-bin/speedtestreport";
        aVar.iLP = TbsLog.TBSLOG_CODE_SDK_SELF_MODE;
        aVar.respCmdId = 1000000996;
        aVar.newExtFlag = 0;
        aVar.transferHeader = null;
        this.rr = aVar.aXF();
        AppMethodBeat.o(20678);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return a.C0691a.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        boolean z;
        AppMethodBeat.i(20679);
        this.heq = iVar;
        ecb ecb = (ecb) this.rr.iLK.iLR;
        ecb.Mpw = this.jGx;
        ecb.Ncf = this.jGy;
        ecb.Ncg = this.jGz;
        ecb.Nch = this.jGA;
        ecb.Nci = this.jGB;
        ecb.Nck = this.jGC;
        ecb.Ncj = this.jGD;
        if ("dual".equals(this.jGE)) {
            String str = ecb.Ncj.ip;
            if (str == null || str.length() <= 0 || str.contains(".")) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                ecb.Nck.ip = bku();
                Log.d("MicroMsg.MMNewSpeedTest", "local stack is dual ip is " + ecb.Nck.ip);
            }
        }
        switch (PlatformComm.C2Java.getNetInfo()) {
            case -1:
                ecb.Ncc = "NONET";
                break;
            case 0:
            default:
                ecb.Ncc = "NONET";
                break;
            case 1:
                ecb.Ncc = "WIFI";
                PlatformComm.WifiInfo curWifiInfo = PlatformComm.C2Java.getCurWifiInfo();
                if (curWifiInfo == null) {
                    ecb.Ncd = "unknown_netinfo";
                    break;
                } else {
                    ecb.Ncd = curWifiInfo.ssid;
                    break;
                }
            case 2:
                switch (PlatformComm.C2Java.getStatisticsNetType()) {
                    case 2:
                        ecb.Ncc = "EDGE";
                        break;
                    case 3:
                        ecb.Ncc = "2G";
                        break;
                    case 4:
                        ecb.Ncc = "3G";
                        break;
                    case 5:
                        ecb.Ncc = "4G";
                        break;
                    default:
                        ecb.Ncc = "EDGE";
                        break;
                }
                PlatformComm.SIMInfo curSIMInfo = PlatformComm.C2Java.getCurSIMInfo();
                if (curSIMInfo == null) {
                    ecb.Ncd = "unknown_netinfo";
                    break;
                } else {
                    ecb.Ncd = curSIMInfo.ispCode;
                    break;
                }
        }
        ahc dMM = com.tencent.mm.plugin.freewifi.m.dMM();
        ecb.Nce = "device info:" + dMM.deviceBrand + " " + dMM.deviceModel + " " + dMM.osName + " " + dMM.osVersion;
        Log.d("MicroMsg.MMNewSpeedTest", new StringBuilder("speed test ").append(ecb.Nce).append(",networktype: ").append(ecb.Ncc).append(",network_info: ").append(ecb.Ncd).append(",conn_time: ").append(ecb.Ncf).append(",conn_retcode: ").append(ecb.Ncg).append(",trans_time: ").append(ecb.Nch).append(",trans_time: ").append(ecb.Nci).append(",cookie: ").append(ecb.Mpw.toString()).append(",cookie size: ").append(ecb.Mpw.zy.length).append(",size: ").append(ecb.computeSize()).append(",client ip: ").append(ecb.Nck.ip).append(",client port: ").append(ecb.Nck.port).append(",server ip: ").append(ecb.Ncj.ip).append(",server port: ").append(ecb.Ncj.port).toString());
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20679);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20680);
        Log.d("MicroMsg.MMNewSpeedTest", "ErrType:" + i3 + "   errCode:" + i4);
        if (i4 == 0 && i3 == 0) {
            h.INSTANCE.dN(c.CTRL_INDEX, 26);
        } else {
            h.INSTANCE.dN(c.CTRL_INDEX, 27);
        }
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20680);
    }

    private static String bku() {
        String str;
        AppMethodBeat.i(20681);
        String str2 = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        str = str2;
                        break;
                    }
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (nextElement instanceof Inet6Address) {
                        str = nextElement.getHostAddress().toString();
                        break;
                    }
                }
                str2 = str;
            }
            AppMethodBeat.o(20681);
        } catch (Exception e2) {
            AppMethodBeat.o(20681);
        }
        return str2;
    }
}
