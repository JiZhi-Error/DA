package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.biq;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class f extends c {
    private static int wPp = 7200;
    private String mac;
    private String ssid;

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void dNu() {
        AppMethodBeat.i(24854);
        d.a aVar = new d.a();
        aVar.iLN = new bip();
        aVar.iLO = new biq();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
        aVar.funcId = 1726;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24854);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1726;
    }

    public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(24855);
        dNu();
        this.ssid = str;
        this.mac = str2;
        ei eiVar = new ei();
        eiVar.mac = str2;
        eiVar.ssid = str;
        bip bip = (bip) this.rr.iLK.iLR;
        bip.appId = str3;
        bip.wPN = str4;
        bip.wPO = str5;
        bip.extend = str6;
        bip.dmc = str7;
        bip.sign = str8;
        bip.LSI = eiVar;
        AppMethodBeat.o(24855);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void a(int i2, int i3, int i4, String str) {
        AppMethodBeat.i(24856);
        c aya = j.dNn().aya(this.ssid);
        boolean z = false;
        if (aya == null) {
            z = true;
            aya = new c();
            aya.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
        }
        if (i3 == 0 && i4 == 0) {
            biq biq = (biq) this.rr.iLL.iLR;
            aya.field_ssid = this.ssid;
            aya.field_showUrl = biq.KCE;
            dyj dyj = biq.KCF;
            if (dyj != null) {
                Log.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", dyj.MXX, dyj.MXY, dyj.MXZ);
                aya.field_showWordCn = dyj.MXY;
                aya.field_showWordEn = dyj.MXX;
                aya.field_showWordTw = dyj.MXZ;
            } else {
                aya.field_showWordCn = MMApplicationContext.getContext().getResources().getString(R.string.diu);
                aya.field_showWordEn = MMApplicationContext.getContext().getResources().getString(R.string.diu);
                aya.field_showWordTw = MMApplicationContext.getContext().getResources().getString(R.string.diu);
            }
            aya.field_action = biq.KCD;
            aya.field_verifyResult = 1;
            aya.field_connectState = -1;
            if (biq.KCN <= 0) {
                biq.KCN = wPp;
            }
            aya.field_expiredTime = Util.nowSecond() + ((long) biq.KCN);
            aya.field_mac = this.mac;
            if (z) {
                Log.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", Boolean.valueOf(j.dNn().insert(aya)));
            } else {
                Log.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", Boolean.valueOf(j.dNn().update(aya, new String[0])));
            }
            j.dNn().ayb(this.ssid);
            AppMethodBeat.o(24856);
            return;
        }
        Log.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", this.ssid);
        if (!z) {
            Log.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", this.ssid, Boolean.valueOf(j.dNn().delete(aya, new String[0])));
        }
        AppMethodBeat.o(24856);
    }

    public final ih dNz() {
        return ((biq) this.rr.iLL.iLR).wRL;
    }
}
