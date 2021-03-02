package com.tencent.mm.plugin.address.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.protocal.protobuf.dqp;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback;
    public dqp ksS;
    private d rr;

    public i(b bVar) {
        AppMethodBeat.i(20789);
        d.a aVar = new d.a();
        aVar.iLN = new dqo();
        aVar.iLO = new dqp();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
        aVar.funcId = 1180;
        this.rr = aVar.aXF();
        dqo dqo = (dqo) this.rr.iLK.iLR;
        dqo.source = 2;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("{\"user_uin\":");
        bg.aVF();
        sb.append(sb2.append(c.getUin()).append(" ,\"user_data_list\": [").toString());
        if (bVar.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            sb.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.ynP + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + bVar.ynR + "\"},{\"key\": \"bank_number\",\"value\": \"" + bVar.ynS + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.ynV + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + bVar.ynX + "\"},{\"key\": \"bank_name\",\"value\": \"" + bVar.ynT + "\"}]}}");
        } else {
            sb.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.ynP + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.ynQ + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.ynW + "\"},{\"key\": \"email\",\"value\": \"" + bVar.fuD + "\"}]}}");
        }
        sb.append("]}");
        dqo.McH = sb.toString();
        AppMethodBeat.o(20789);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20790);
        Log.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            this.ksS = (dqp) ((d) sVar).iLL.iLR;
            if (!(this.ksS == null || this.ksS.MTy == null || this.ksS.MTy.size() <= 0 || this.ksS.MTy.get(0) == null)) {
                Log.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + this.ksS.MTy.get(0).Lqz);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20790);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1180;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(20791);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20791);
        return dispatch;
    }
}
