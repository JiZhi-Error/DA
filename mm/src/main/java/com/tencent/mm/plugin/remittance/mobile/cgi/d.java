package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.protocal.protobuf.eke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.l;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a {
    public eke ClS;

    public d() {
        AppMethodBeat.i(67630);
        d.a aVar = new d.a();
        aVar.iLN = new ekd();
        aVar.iLO = new eke();
        aVar.funcId = 2952;
        aVar.uri = "/cgi-bin/mmpay-bin/transferphonehomepage";
        this.rr = aVar.aXF();
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "do scene NetSceneMobileRemitGetHomePage");
        AppMethodBeat.o(67630);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67631);
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ClS = (eke) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.ClS.pTZ), this.ClS.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67631);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        eke eke = (eke) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        this.RtZ = eke.pTZ;
        this.Rua = eke.pUa;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2952;
    }

    public static String a(eke eke) {
        AppMethodBeat.i(67632);
        if (eke == null) {
            AppMethodBeat.o(67632);
            return "TransferPhoneHomePageResp{null}";
        }
        String str = "TransferPhoneHomePageResp{ret_code=" + eke.pTZ + ", ret_msg='" + eke.pUa + '\'' + ", title='" + eke.title + '\'' + ", subtitle='" + eke.subtitle + '\'' + ", has_his_rcvr=" + eke.Njq + ", menu=" + l.bO(eke.Njr) + ", announcement=" + l.b(eke.Njs) + ", homepage_ext='" + eke.Njj + '\'' + '}';
        AppMethodBeat.o(67632);
        return str;
    }

    public static String b(eke eke) {
        AppMethodBeat.i(67633);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret_code", eke.pTZ);
            jSONObject.put("ret_msg", eke.pUa);
            jSONObject.put("title", eke.title);
            jSONObject.put(MessengerShareContentUtility.SUBTITLE, eke.subtitle);
            jSONObject.put("has_his_rcvr", eke.Njq);
            if (eke.Njr != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<cfl> it = eke.Njr.iterator();
                while (it.hasNext()) {
                    jSONArray.put(l.c(it.next()));
                }
                jSONObject.put("menu", jSONArray);
            }
            jSONObject.put("announcement", eke.Njs);
            jSONObject.put("homepage_ext", eke.Njj);
            String jSONObject2 = jSONObject.toString();
            AppMethodBeat.o(67633);
            return jSONObject2;
        } catch (JSONException e2) {
            Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "getJsonStrFromHomePageInfo() Exception: %s", e2.getMessage());
            AppMethodBeat.o(67633);
            return "";
        }
    }

    public static eke aLZ(String str) {
        AppMethodBeat.i(67634);
        eke eke = new eke();
        try {
            JSONObject jSONObject = new JSONObject(str);
            eke.pTZ = jSONObject.optInt("ret_code");
            eke.pUa = jSONObject.optString("ret_msg");
            eke.title = jSONObject.optString("title");
            eke.subtitle = jSONObject.optString(MessengerShareContentUtility.SUBTITLE);
            eke.Njq = jSONObject.optInt("has_his_rcvr");
            JSONArray optJSONArray = jSONObject.optJSONArray("menu");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    eke.Njr.add(l.ci(optJSONArray.getJSONObject(i2)));
                }
            }
            eke.Njs = l.bpm(jSONObject.optString("announcement"));
            eke.Njj = jSONObject.optString("homepage_ext");
            AppMethodBeat.o(67634);
            return eke;
        } catch (JSONException e2) {
            Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetHomePage", "createFromJson() Exception:%s", e2.getMessage());
            AppMethodBeat.o(67634);
            return null;
        }
    }
}
