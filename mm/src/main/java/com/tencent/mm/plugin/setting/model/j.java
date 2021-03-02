package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class j extends q implements m {
    private i callback;
    private d rr;

    public j() {
        AppMethodBeat.i(73773);
        d.a aVar = new d.a();
        aVar.iLN = new bwx();
        aVar.iLO = new bwy();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        aVar.funcId = 1191;
        this.rr = aVar.aXF();
        bwx bwx = (bwx) this.rr.iLK.iLR;
        bwx.source = 2;
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("invoice_info.title");
        linkedList.add("invoice_info.tax_number");
        linkedList.add("invoice_info.bank_number");
        linkedList.add("invoice_info.bank_name");
        linkedList.add("invoice_info.type");
        linkedList.add("invoice_info.email");
        linkedList.add("invoice_info.company_address");
        linkedList.add("invoice_info.company_address_detail");
        linkedList.add("invoice_info.company_address_postcode");
        linkedList.add("invoice_info.phone");
        bwx.McG = linkedList;
        bwx.McF = false;
        AppMethodBeat.o(73773);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(73774);
        Log.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we parse the json and resetList..");
            bwy bwy = (bwy) ((d) sVar).iLL.iLR;
            if (bwy.McH != null) {
                try {
                    boolean z = new JSONObject(bwy.McH).getBoolean("has_invoice_info");
                    Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "has_invoice_info is ..".concat(String.valueOf(z)));
                    g.aAh().azQ().set(ar.a.USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN, Boolean.valueOf(z));
                } catch (JSONException e2) {
                    Log.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(73774);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1191;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(73775);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(73775);
        return dispatch;
    }
}
