package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends q implements m {
    public cvp IpS;
    public String IpT;
    public String IpU;
    public String IpV;
    private i callback;
    public int dDN;
    public String qwn;
    private com.tencent.mm.ak.d rr;

    public d(String str, String str2, String str3, String str4, String str5, int i2, boolean z, int i3, String str6) {
        this(str, str2, str3, str4, str5, i2, z, false, i3, str6);
    }

    public d(String str, String str2, String str3, String str4, String str5, int i2, boolean z, boolean z2, int i3, String str6) {
        AppMethodBeat.i(71691);
        this.dDN = 0;
        this.qwn = "";
        d.a aVar = new d.a();
        aVar.iLN = new cvo();
        aVar.iLO = new cvp();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/openecard";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cvo cvo = (cvo) this.rr.iLK.iLR;
        cvo.KPu = str;
        cvo.KPv = str2;
        this.rr.setIsUserCmd(true);
        if (z) {
            cvo.MAS = str3;
        } else {
            cvo.MAT = str3;
        }
        if (z2) {
            cvo.MAU = 1;
        } else {
            cvo.MAU = 0;
        }
        cvo.HQc = str4;
        cvo.dDj = str5;
        cvo.dUS = i2;
        cvo.MAR = false;
        cvo.eaQ = i3;
        cvo.MAV = str6;
        this.IpT = str3;
        this.IpU = str4;
        this.IpV = str5;
        Log.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", str3);
        Log.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s, bankCardInfo: %s, fromScene: %s", str, str2, Integer.valueOf(i2), str4, str5, str6, Integer.valueOf(i3));
        AppMethodBeat.o(71691);
    }

    public d(String str, String str2, int i2) {
        AppMethodBeat.i(71692);
        this.dDN = 0;
        this.qwn = "";
        d.a aVar = new d.a();
        aVar.iLN = new cvo();
        aVar.iLO = new cvp();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/openecard";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cvo cvo = (cvo) this.rr.iLK.iLR;
        cvo.KPu = str;
        cvo.KPv = str2;
        this.rr.setIsUserCmd(true);
        cvo.MAU = 0;
        cvo.dUS = i2;
        cvo.eaQ = 1;
        cvo.MAR = true;
        Log.i("MicroMsg.NetSceneOpenECard", "create NetSceneOpenECard with reuse exist card, cardType: %s, reqSerial: %s, openScene: %s", str, str2, Integer.valueOf(i2));
        AppMethodBeat.o(71692);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(71693);
        Log.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.IpS = (cvp) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.IpS.pTZ), this.IpS.pUa);
        if (!Util.isNullOrNil(this.IpS.MAO)) {
            Log.d("MicroMsg.NetSceneOpenECard", "rettext: %s", this.IpS.MAO);
            try {
                JSONObject jSONObject = new JSONObject(this.IpS.MAO);
                this.dDN = jSONObject.optInt("retcode", 0);
                this.qwn = jSONObject.optString("retmsg", "");
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneOpenECard", e2, "", new Object[0]);
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(71693);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return Exif.PARSE_EXIF_ERROR_CORRUPT;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(71694);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71694);
        return dispatch;
    }
}
