package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends q implements m {
    public int Cnj = 0;
    rd Cou;
    public re Cov;
    public c Cow;
    public d Cox;
    public boolean Coy = false;
    public String Coz = "";
    private i callback;
    public boolean cancel = false;
    private d hJu;

    public g(int i2, int i3, int i4, String str, String str2, String str3, String str4, String str5, String str6, int i5, c cVar, d dVar) {
        AppMethodBeat.i(67843);
        this.Coz = new StringBuilder().append(System.currentTimeMillis()).append(i2).toString();
        d.a aVar = new d.a();
        this.Cnj = i2;
        aVar.iLN = new rd();
        aVar.iLO = new re();
        aVar.funcId = 2677;
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fgetfavor";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.Cou = (rd) this.hJu.iLK.iLR;
        this.Cou.yRL = i2;
        this.Cou.channel = i3;
        this.Cou.Coi = i4;
        this.Cou.KYc = str;
        this.Cou.CpG = str2;
        this.Cou.Coj = str3;
        this.Cou.CpJ = str4;
        this.Cou.jTz = str5;
        this.Cou.Cok = str6;
        this.Cou.KYd = i5;
        this.Cow = cVar;
        this.Cox = dVar;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("request.amount %s", Integer.valueOf(this.Cou.yRL)));
        stringBuffer.append(String.format("request.channel %s", Integer.valueOf(this.Cou.channel)));
        stringBuffer.append(String.format("request.scan_scene %s", Integer.valueOf(this.Cou.Coi)));
        stringBuffer.append(String.format("request.receiver_desc %s", this.Cou.KYc));
        stringBuffer.append(String.format("request.mch_name %s", this.Cou.CpG));
        stringBuffer.append(String.format("request.favor_req_sign %s", this.Cou.Coj));
        stringBuffer.append(String.format("request.receiver_openid %s", this.Cou.CpJ));
        stringBuffer.append(String.format("request.receiver_username %s", this.Cou.jTz));
        stringBuffer.append(String.format("request.favor_req_extend %s", this.Cou.Cok));
        stringBuffer.append(String.format("request.fail_click_cell %s", Integer.valueOf(this.Cou.KYd)));
        Log.i("MicroMsg.NetSceneBusiF2fGetFavor", "NetSceneBusiF2fGetFavor req %s", stringBuffer.toString());
        AppMethodBeat.o(67843);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2677;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(67844);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(67844);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67845);
        Log.i("MicroMsg.NetSceneBusiF2fGetFavor", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.Cov = (re) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBusiF2fGetFavor", "ret_code: %s, ret_msg: %s favor_comm_resp : %s", Integer.valueOf(this.Cov.pTZ), this.Cov.pUa, a.a(this.Cov.Com));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(67845);
    }
}
