package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ag;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class b extends c {
    private static int wPp = 7200;
    public String mac;
    private String ssid;

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void dNu() {
        AppMethodBeat.i(24844);
        d.a aVar = new d.a();
        aVar.iLN = new ag();
        aVar.iLO = new ah();
        aVar.uri = "/cgi-bin/mmo2o-bin/apcheck";
        aVar.funcId = 1744;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24844);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1744;
    }

    public b(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(24845);
        dNu();
        this.ssid = str2;
        this.mac = str;
        LinkedList<ei> linkedList = new LinkedList<>();
        ei eiVar = new ei();
        eiVar.ssid = str2;
        eiVar.mac = str;
        eiVar.gNm = i2;
        linkedList.add(eiVar);
        ag agVar = (ag) this.rr.iLK.iLR;
        agVar.KCO = h.b.wMW.dMy();
        agVar.KCw = linkedList;
        agVar.KCP = m.dMM();
        agVar.KCQ = i3;
        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", str, str2, Integer.valueOf(i2));
        AppMethodBeat.o(24845);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void a(int i2, int i3, int i4, String str) {
        AppMethodBeat.i(24846);
        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (!(this.rr == null || this.rr.iLL.iLR == null)) {
            h.b.wMW.a((ah) this.rr.iLL.iLR);
            if (m.gB(i3, i4) || m.gC(i3, i4)) {
                ah ahVar = (ah) this.rr.iLL.iLR;
                int i5 = ahVar.KCT;
                boolean z = ahVar.KCS;
                if (!(i5 == 0 || i5 == i.a.wMX.getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
                    i.a.wMX.dU("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", i5);
                }
                if (z) {
                    i.a.wMX.at("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
                }
            }
        }
        c aya = j.dNn().aya(this.ssid);
        boolean z2 = false;
        if (aya == null) {
            z2 = true;
            aya = new c();
            aya.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
        }
        if (i3 == 0 && i4 == 0) {
            ah ahVar2 = (ah) this.rr.iLL.iLR;
            aya.field_ssid = this.ssid;
            aya.field_showUrl = ahVar2.KCE;
            dyj dyj = ahVar2.KCF;
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
            aya.field_action = ahVar2.KCD;
            aya.field_verifyResult = 1;
            aya.field_connectState = -1;
            if (ahVar2.KCN <= 0) {
                ahVar2.KCN = wPp;
            }
            aya.field_expiredTime = Util.nowSecond() + ((long) ahVar2.KCN);
            aya.field_mac = this.mac;
            if (z2) {
                Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(j.dNn().insert(aya)));
            } else {
                Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", Boolean.valueOf(j.dNn().update(aya, new String[0])));
            }
            j.dNn().ayb(this.ssid);
            AppMethodBeat.o(24846);
            return;
        }
        Log.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", this.ssid);
        if (!z2) {
            Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", this.ssid, Boolean.valueOf(j.dNn().delete(aya, new String[0])));
        }
        AppMethodBeat.o(24846);
    }
}
