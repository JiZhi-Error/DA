package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cor;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.ag;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l extends q implements m {
    private final String TAG = "MicroMsg.NetSceneF2fQrcode";
    private i callback;
    public vv qwk;
    private d rr;

    public l() {
        AppMethodBeat.i(63827);
        d.a aVar = new d.a();
        aVar.iLN = new vu();
        aVar.iLO = new vv();
        aVar.funcId = 1588;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(63827);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1588;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63828);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(63828);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63829);
        this.qwk = (vv) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        Log.d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", this.qwk.url, this.qwk.HTZ, this.qwk.LgO);
        if (!Util.isNullOrNil(this.qwk.url)) {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_F2F_COLLECT_PAY_URL_STRING_SYNC, this.qwk.url);
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_F2F_COLLECT_PAY_URL_ERROR_LEVEL_INT_SYNC, Integer.valueOf(ag.aqj(this.qwk.LgF)));
        if (!Util.isNullOrNil(this.qwk.HTZ)) {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_F2F_COLLECT_TRUE_NAME_STRING_SYNC, this.qwk.HTZ);
        }
        if (!Util.isNullOrNil(this.qwk.LgW)) {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_F2F_COLLECT_SAVEQRCODE_STRING_SYNC, this.qwk.LgW);
        }
        if (!Util.isNullOrNil(this.qwk.LgU)) {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_F2F_COLLECT_SCREENSHOT_STRING_SYNC, this.qwk.LgU);
        }
        if (!Util.isNullOrNil(this.qwk.LgV)) {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_F2F_COLLECT_LONGPRESS_STRING_SYNC, this.qwk.LgV);
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_LEFT_ICON_URL_STRING_SYNC, this.qwk.LgO);
        JSONObject a2 = a(this.qwk.LgN);
        JSONArray dc = dc(this.qwk.LgM);
        if (a2 != null) {
            Log.d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", a2.toString());
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_MENU_STRING_SYNC, a2.toString());
        }
        if (dc != null) {
            Log.d("MicroMsg.NetSceneF2fQrcode", "upright: %s", dc.toString());
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_F2F_COLLECT_UPRIGHT_MENU_STRING_SYNC, dc.toString());
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(63829);
    }

    private static JSONArray dc(List<cor> list) {
        AppMethodBeat.i(63830);
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.size() == 0) {
            Log.w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
            AppMethodBeat.o(63830);
            return null;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                JSONObject a2 = a(list.get(i2));
                if (a2 != null) {
                    jSONArray.put(i2, a2);
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e2, "", new Object[0]);
                AppMethodBeat.o(63830);
                return null;
            }
        }
        AppMethodBeat.o(63830);
        return jSONArray;
    }

    private static JSONObject a(cor cor) {
        boolean z;
        AppMethodBeat.i(63831);
        if (cor == null || Util.isNullOrNil(cor.dQx)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            Log.w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
            AppMethodBeat.o(63831);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", cor.type);
            jSONObject.put("wording", cor.dQx);
            jSONObject.put("url", cor.url);
            jSONObject.put("waapp_username", cor.MuQ);
            jSONObject.put("waapp_path", cor.MuR);
            AppMethodBeat.o(63831);
            return jSONObject;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e2, "", new Object[0]);
            AppMethodBeat.o(63831);
            return null;
        }
    }
}
