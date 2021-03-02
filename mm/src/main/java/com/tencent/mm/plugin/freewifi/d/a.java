package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ae;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.dho;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a extends c {
    private static int wPp = 7200;
    private int dJY;
    private String mac;
    private String ssid;

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void dNu() {
        AppMethodBeat.i(24839);
        d.a aVar = new d.a();
        aVar.iLN = new ae();
        aVar.iLO = new af();
        aVar.uri = "/cgi-bin/micromsg-bin/apauth";
        aVar.funcId = 640;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24839);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 640;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7) {
        AppMethodBeat.i(24840);
        dNu();
        this.ssid = str2;
        this.mac = str3;
        ae aeVar = (ae) this.rr.iLK.iLR;
        String decode = URLDecoder.decode(str5);
        aeVar.OpCode = 0;
        aeVar.URL = str;
        aeVar.SSID = str2;
        aeVar.KCt = str4;
        aeVar.KCu = decode;
        aeVar.KCv = str6;
        aeVar.KCx = i2;
        aeVar.KCy = str7;
        LinkedList<ei> linkedList = new LinkedList<>();
        ei eiVar = new ei();
        eiVar.ssid = str2;
        eiVar.mac = str3;
        linkedList.add(eiVar);
        aeVar.KCw = linkedList;
        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", str, str2, str4, str3, str5, decode, str6);
        AppMethodBeat.o(24840);
    }

    public a(String str, String str2, String str3, int i2, int i3, String str4) {
        AppMethodBeat.i(24841);
        dNu();
        this.ssid = str3;
        this.mac = str2;
        this.dJY = 1;
        LinkedList<ei> linkedList = new LinkedList<>();
        ei eiVar = new ei();
        eiVar.ssid = str3;
        eiVar.mac = str2;
        eiVar.gNm = i2;
        linkedList.add(eiVar);
        ae aeVar = (ae) this.rr.iLK.iLR;
        aeVar.OpCode = 1;
        aeVar.KCw = linkedList;
        aeVar.URL = str;
        aeVar.KCx = i3;
        aeVar.KCy = str4;
        aeVar.KCA = m.axO("MicroMsg.FreeWifi.NetSceneAPAuth");
        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", 1, str2, str3, Integer.valueOf(i2));
        AppMethodBeat.o(24841);
    }

    public a(String str, int i2, String str2) {
        AppMethodBeat.i(24842);
        dNu();
        this.dJY = 4;
        ae aeVar = (ae) this.rr.iLK.iLR;
        aeVar.OpCode = 4;
        aeVar.URL = str;
        aeVar.KCx = i2;
        aeVar.KCy = str2;
        aeVar.KCz = m.dMK();
        aeVar.KCw = new LinkedList<>();
        ei eiVar = new ei();
        eiVar.ssid = m.axM("MicroMsg.FreeWifi.NetSceneAPAuth");
        eiVar.mac = m.axN("MicroMsg.FreeWifi.NetSceneAPAuth");
        aeVar.KCw.add(eiVar);
        aeVar.KCA = m.axO("MicroMsg.FreeWifi.NetSceneAPAuth");
        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", Integer.valueOf(aeVar.KCz), eiVar.ssid, eiVar.mac);
        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", 4, str);
        AppMethodBeat.o(24842);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void a(int i2, int i3, int i4, String str) {
        AppMethodBeat.i(24843);
        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(this.dJY));
        switch (this.dJY) {
            case 0:
                if (i3 == 0 && i4 == 0) {
                    c aya = j.dNn().aya(this.ssid);
                    Object[] objArr = new Object[2];
                    objArr[0] = this.ssid;
                    objArr[1] = Boolean.valueOf(aya == null);
                    Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get freewifi by ssid :%s, is wifi info = null ? %b", objArr);
                    boolean z = false;
                    if (aya == null) {
                        z = true;
                        aya = new c();
                        aya.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
                    }
                    aya.field_wifiType = 1;
                    af afVar = (af) this.rr.iLL.iLR;
                    dyj dyj = afVar.KCF;
                    if (dyj != null) {
                        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", dyj.MXX, dyj.MXY, dyj.MXZ);
                        aya.field_showWordCn = dyj.MXY;
                        aya.field_showWordEn = dyj.MXX;
                        aya.field_showWordTw = dyj.MXZ;
                    } else {
                        aya.field_showWordCn = MMApplicationContext.getContext().getResources().getString(R.string.diu);
                        aya.field_showWordEn = MMApplicationContext.getContext().getResources().getString(R.string.diu);
                        aya.field_showWordTw = MMApplicationContext.getContext().getResources().getString(R.string.diu);
                    }
                    aya.field_action = afVar.KCD;
                    aya.field_verifyResult = 1;
                    aya.field_connectState = -1;
                    if (afVar.KCN <= 0) {
                        afVar.KCN = wPp;
                    }
                    aya.field_expiredTime = Util.nowSecond() + ((long) afVar.KCN);
                    aya.field_showUrl = afVar.KCE;
                    aya.field_action = afVar.KCD;
                    aya.field_ssid = this.ssid;
                    aya.field_mac = this.mac;
                    aya.field_wifiType = 1;
                    if (z) {
                        boolean insert = j.dNn().insert(aya);
                        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(insert));
                        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", this.ssid, Boolean.valueOf(insert), Integer.valueOf(afVar.KCC), Integer.valueOf(afVar.KCD), afVar.KCE);
                        AppMethodBeat.o(24843);
                        return;
                    }
                    Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", this.ssid, Boolean.valueOf(j.dNn().update(aya, new String[0])), Integer.valueOf(afVar.KCC), Integer.valueOf(afVar.KCD), afVar.KCE);
                    AppMethodBeat.o(24843);
                    return;
                }
            case 1:
                c aya2 = j.dNn().aya(this.ssid);
                boolean z2 = false;
                if (aya2 == null) {
                    z2 = true;
                    aya2 = new c();
                    aya2.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
                }
                if (i3 != 0 || i4 != 0) {
                    Log.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", this.ssid);
                    if (!z2) {
                        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", this.ssid, Boolean.valueOf(j.dNn().delete(aya2, new String[0])));
                        break;
                    }
                } else {
                    af afVar2 = (af) this.rr.iLL.iLR;
                    aya2.field_ssid = this.ssid;
                    aya2.field_showUrl = afVar2.KCE;
                    dyj dyj2 = afVar2.KCF;
                    Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", this.ssid, Integer.valueOf(afVar2.KCC), Integer.valueOf(afVar2.KCD), afVar2.KCE);
                    if (dyj2 != null) {
                        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", dyj2.MXX, dyj2.MXY, dyj2.MXZ);
                        aya2.field_showWordCn = dyj2.MXY;
                        aya2.field_showWordEn = dyj2.MXX;
                        aya2.field_showWordTw = dyj2.MXZ;
                    } else {
                        aya2.field_showWordCn = MMApplicationContext.getContext().getResources().getString(R.string.diu);
                        aya2.field_showWordEn = MMApplicationContext.getContext().getResources().getString(R.string.diu);
                        aya2.field_showWordTw = MMApplicationContext.getContext().getResources().getString(R.string.diu);
                    }
                    aya2.field_action = afVar2.KCD;
                    aya2.field_verifyResult = 1;
                    aya2.field_connectState = -1;
                    if (afVar2.KCN <= 0) {
                        afVar2.KCN = wPp;
                    }
                    aya2.field_expiredTime = Util.nowSecond() + ((long) afVar2.KCN);
                    aya2.field_mac = this.mac;
                    if (z2) {
                        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(j.dNn().insert(aya2)));
                    } else {
                        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(j.dNn().update(aya2, new String[0])));
                    }
                    j.dNn().ayb(this.ssid);
                    AppMethodBeat.o(24843);
                    return;
                }
                break;
        }
        AppMethodBeat.o(24843);
    }

    public final String dNv() {
        af afVar = (af) this.rr.iLL.iLR;
        if (afVar != null) {
            return afVar.KCB;
        }
        return null;
    }

    public final dho dNw() {
        af afVar = (af) this.rr.iLL.iLR;
        if (afVar != null) {
            return afVar.KCI;
        }
        return null;
    }

    public final boolean dNx() {
        af afVar = (af) this.rr.iLL.iLR;
        if (afVar == null || afVar.KCJ == null) {
            return false;
        }
        return afVar.KCJ.KCz == 1;
    }

    public final bfr dNy() {
        af afVar = (af) this.rr.iLL.iLR;
        if (afVar != null) {
            return afVar.KCJ;
        }
        return null;
    }

    public final String getOpenId() {
        af afVar = (af) this.rr.iLL.iLR;
        if (afVar != null) {
            return afVar.KCL;
        }
        return null;
    }

    public final String ahV() {
        af afVar = (af) this.rr.iLL.iLR;
        if (afVar != null) {
            return afVar.KCM;
        }
        return null;
    }

    public final ih dNz() {
        af afVar = (af) this.rr.iLL.iLR;
        if (afVar != null) {
            return afVar.KCK;
        }
        return null;
    }
}
