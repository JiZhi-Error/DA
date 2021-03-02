package com.tencent.mm.modelgeo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskForNative;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends q implements m {
    private i callback;
    private String dNA = "";
    public final d rr;

    public e(double d2, double d3) {
        AppMethodBeat.i(150500);
        d.a aVar = new d.a();
        aVar.iLN = new bht();
        aVar.iLO = new bhu();
        aVar.uri = "/cgi-bin/micromsg-bin/getaddress";
        aVar.funcId = JsApiAddDownloadTaskForNative.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bht bht = (bht) this.rr.iLK.iLR;
        bht.KUu = d2;
        bht.KUt = d3;
        AppMethodBeat.o(150500);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return JsApiAddDownloadTaskForNative.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150501);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150501);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150502);
        Log.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            this.dNA = ((bhu) ((d) sVar).iLL.iLR).LSg;
            Log.d("MicroMsg.NetSceneGetAddress", this.dNA);
            if (this.callback != null) {
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            AppMethodBeat.o(150502);
            return;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(150502);
    }

    public final Addr bce() {
        AppMethodBeat.i(150503);
        if (Util.isNullOrNil(this.dNA)) {
            AppMethodBeat.o(150503);
            return null;
        }
        Addr addr = new Addr();
        try {
            Log.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", this.dNA);
            JSONObject jSONObject = new JSONObject(this.dNA);
            addr.request_id = jSONObject.optString("request_id");
            JSONArray jSONArray = jSONObject.getJSONArray("results");
            addr.iUO = jSONArray.getJSONObject(1).getString("address_name");
            JSONObject jSONObject2 = jSONArray.getJSONObject(0);
            addr.iUP = jSONObject2.getString("p");
            addr.iUQ = jSONObject2.getString("c");
            addr.iUS = jSONObject2.getString("d");
            addr.iUT = "";
            addr.iUU = "";
            addr.iUV = "";
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    String string = jSONObject3.getString("dtype");
                    if ("ST".equals(string)) {
                        addr.iUU = jSONObject3.getString("name");
                    } else if ("ST_NO".equals(string)) {
                        addr.iUV = jSONObject3.getString("name");
                    }
                    if ("FORMAT_ADDRESS".equals(string)) {
                        addr.iUW = jSONObject3.getString("rough_address_name");
                    }
                } catch (Exception e2) {
                }
            }
            if (!Util.isNullOrNil(addr.iUV)) {
                addr.iUU = "";
            }
            AppMethodBeat.o(150503);
            return addr;
        } catch (Exception e3) {
            AppMethodBeat.o(150503);
            return null;
        }
    }
}
