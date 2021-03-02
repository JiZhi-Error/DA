package com.tencent.mm.plugin.remittance.model;

import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ri;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.wallet_core.c.j;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class i extends q implements m, j {
    public int Bbl;
    public ri CoB;
    public String CoC;
    public gl CoD = null;
    private com.tencent.mm.ak.i callback;
    private d hJu;

    public final void a(gl glVar) {
        int i2 = 1;
        this.CoD = glVar;
        rh rhVar = (rh) this.hJu.iLK.iLR;
        if (glVar.dKn.dKp != 1) {
            i2 = 0;
        }
        rhVar.KYn = i2;
    }

    public i(String str, String str2, int i2, String str3, String str4, int i3, int i4, String str5, String str6, int i5, int i6, String str7, anr anr, String str8, int i7, String str9, String str10, String str11, String str12, String str13, int i8, int i9, String str14) {
        AppMethodBeat.i(163811);
        d.a aVar = new d.a();
        aVar.iLN = new rh();
        aVar.iLO = new ri();
        aVar.funcId = 1633;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        e flM = com.tencent.mm.plugin.soter.d.d.flM();
        String str15 = flM.FhU;
        String str16 = flM.hFF;
        this.CoC = str9;
        this.Bbl = i3;
        this.hJu = aVar.aXF();
        rh rhVar = (rh) this.hJu.iLK.iLR;
        rhVar.CpJ = str;
        rhVar.KYg = URLDecoder.decode(str2);
        rhVar.scene = i2;
        rhVar.KYh = str3;
        rhVar.CpD = str4;
        rhVar.KHQ = i3;
        rhVar.channel = i4;
        rhVar.CpE = str5;
        rhVar.CpK = str6;
        rhVar.CpI = i5;
        rhVar.KYo = str13;
        rhVar.KYq = i9;
        rhVar.jTz = str7;
        rhVar.KHW = str14;
        if (anr != null) {
            rhVar.KHP = anr;
        }
        rhVar.KYa = str8;
        rhVar.Coi = i7;
        if (i6 == 1) {
            WifiInfo wifiInfo = NetStatusUtil.getWifiInfo(MMApplicationContext.getContext());
            if (wifiInfo != null) {
                rhVar.KYi = wifiInfo.getBSSID();
            } else {
                Log.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
            }
            rhVar.KYj = 0;
        }
        rhVar.FhU = str15;
        rhVar.hFF = str16;
        rhVar.KYl = t.fQI().fRo();
        g.af(a.class);
        rhVar.KYk = false;
        rhVar.KYm = str9;
        rhVar.CpG = str10;
        rhVar.nickname = str11;
        rhVar.KYp = i8;
        rhVar.Cpg = str12;
        Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", str9);
        Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3), str2, Integer.valueOf(i6), a.a(anr), str9, str13, Integer.valueOf(i9), Integer.valueOf(i8), str14);
        AppMethodBeat.o(163811);
    }

    public i(String str, String str2, int i2, String str3, String str4, int i3, int i4, String str5, String str6, int i5, int i6, String str7, anr anr, String str8, int i7, String str9, String str10, String str11, String str12, String str13, int i8, int i9, String str14, String str15, String str16) {
        AppMethodBeat.i(174416);
        d.a aVar = new d.a();
        aVar.iLN = new rh();
        aVar.iLO = new ri();
        aVar.funcId = 1633;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fplaceorder";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        e flM = com.tencent.mm.plugin.soter.d.d.flM();
        String str17 = flM.FhU;
        String str18 = flM.hFF;
        this.CoC = str9;
        this.Bbl = i3;
        this.hJu = aVar.aXF();
        rh rhVar = (rh) this.hJu.iLK.iLR;
        rhVar.CpJ = str;
        rhVar.KYg = URLDecoder.decode(str2);
        rhVar.scene = i2;
        rhVar.KYh = str3;
        rhVar.CpD = str4;
        rhVar.KHQ = i3;
        rhVar.channel = i4;
        rhVar.CpE = str5;
        rhVar.CpK = str6;
        rhVar.CpI = i5;
        rhVar.KYo = str13;
        rhVar.KYq = i9;
        rhVar.jTz = str7;
        rhVar.KHW = str14;
        if (anr != null) {
            rhVar.KHP = anr;
        }
        rhVar.KYa = str8;
        rhVar.Coi = i7;
        if (i6 == 1) {
            WifiInfo wifiInfo = NetStatusUtil.getWifiInfo(MMApplicationContext.getContext());
            if (wifiInfo != null) {
                rhVar.KYi = wifiInfo.getBSSID();
            } else {
                Log.w("MicroMsg.NetSceneBusiF2fPlaceOrder", "wifi info is null");
            }
            rhVar.KYj = 0;
        }
        rhVar.FhU = str17;
        rhVar.hFF = str18;
        rhVar.KYl = t.fQI().fRo();
        g.af(a.class);
        rhVar.KYk = false;
        rhVar.KYm = str9;
        rhVar.CpG = str10;
        rhVar.nickname = str11;
        rhVar.KYp = i8;
        rhVar.Cpg = str12;
        rhVar.KYr = str15;
        rhVar.KYs = str16;
        Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "dycodeurl: %s", str9);
        Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "NetSceneBusiF2fPlaceOrder, scene: %s, channel: %s, total: %s, qrcode: %s, getPayWifi: %s favor_compose_info %s dynamicCodeUrl %s cancel_f2fid:%s cancel_reason:%s unpayType:%s amount_remind_sign:%s inputRecvName:%s checkRecvNameSign:%s ", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3), str2, Integer.valueOf(i6), a.a(anr), str9, str13, Integer.valueOf(i9), Integer.valueOf(i8), str14, str15, str16);
        AppMethodBeat.o(174416);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1633;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(67850);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(67850);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67851);
        Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.CoB = (ri) ((d) sVar).iLL.iLR;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("trans_id: %s,", this.CoB.KHN));
        stringBuffer.append(String.format("zero_pay_flag: %s,", Integer.valueOf(this.CoB.KYy)));
        stringBuffer.append(String.format("can_use_fingerprint: %s,", Integer.valueOf(this.CoB.KYE)));
        stringBuffer.append(String.format("payer_need_auth_flag: %s,", Integer.valueOf(this.CoB.KYz)));
        com.tencent.mm.wallet_core.c.e eVar = new com.tencent.mm.wallet_core.c.e(i3, i4, str);
        com.tencent.mm.wallet_core.c.s.getRetModel(i3, i4, str, eVar);
        Log.i("MicroMsg.NetSceneBusiF2fPlaceOrder", "ret_code: %s, ret_msg: %s trans_id: %s f2f_id: %s re_getfavor: %s payok_checksign: %s reqKey %s ret:%s", Integer.valueOf(this.CoB.pTZ), this.CoB.pUa, this.CoB.KHN, this.CoB.KHM, Integer.valueOf(this.CoB.KYx), this.CoB.KHO, this.CoB.dNQ, stringBuffer.toString());
        if (this.callback != null) {
            this.callback.onSceneEnd(eVar.errType, eVar.errCode, eVar.errMsg, this);
        }
        AppMethodBeat.o(67851);
    }

    public static JSONObject a(rb rbVar) {
        AppMethodBeat.i(67852);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flag", rbVar.cSx);
            jSONObject.put("succpage_first_delay_ms", rbVar.KXU);
            jSONObject.put("succpage_max_retry_cnt", rbVar.KXV);
            jSONObject.put("succpage_retry_waiting_ms", rbVar.KXW);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "getBusiF2FFaultConfigJSONObject() Exception: %s", e2.getMessage());
        }
        AppMethodBeat.o(67852);
        return jSONObject;
    }

    public static rb aMc(String str) {
        AppMethodBeat.i(67853);
        rb rbVar = new rb();
        try {
            JSONObject jSONObject = new JSONObject(str);
            rbVar.cSx = jSONObject.optInt("flag");
            rbVar.KXU = jSONObject.optInt("succpage_first_delay_ms");
            rbVar.KXV = jSONObject.optInt("succpage_max_retry_cnt");
            rbVar.KXW = jSONObject.optInt("succpage_retry_waiting_ms");
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneBusiF2fPlaceOrder", "createBusiF2FFaultConfigFromJSONObject() Exception: %s", e2.getMessage());
        }
        AppMethodBeat.o(67853);
        return rbVar;
    }
}
