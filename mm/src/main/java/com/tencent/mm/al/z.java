package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjv;
import com.tencent.mm.protocal.protobuf.bjw;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class z extends q implements m {
    private i callback;
    private Object data = null;
    public d rr;

    public static void a(i iVar) {
        AppMethodBeat.i(124129);
        g.aAg().hqi.a(1285, iVar);
        AppMethodBeat.o(124129);
    }

    public static void b(i iVar) {
        AppMethodBeat.i(124130);
        g.aAg().hqi.b(1285, iVar);
        AppMethodBeat.o(124130);
    }

    public static boolean m(String str, String str2, String str3) {
        AppMethodBeat.i(124131);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand_user_name", str2);
            jSONObject.put("bizchat_id", str3);
            boolean a2 = g.aAg().hqi.a(new z(str, jSONObject.toString()), 0);
            AppMethodBeat.o(124131);
            return a2;
        } catch (Exception e2) {
            AppMethodBeat.o(124131);
            return false;
        }
    }

    private z(String str, String str2) {
        AppMethodBeat.i(124132);
        d.a aVar = new d.a();
        aVar.iLN = new bjv();
        aVar.iLO = new bjw();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
        aVar.funcId = 1285;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bjv bjv = (bjv) this.rr.iLK.iLR;
        bjv.Lpg = str;
        bjv.EX = 1;
        bjv.data = str2;
        AppMethodBeat.o(124132);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124133);
        Log.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124133);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1285;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(124134);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124134);
        return dispatch;
    }
}
