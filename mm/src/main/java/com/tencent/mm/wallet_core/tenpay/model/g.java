package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g extends p {
    protected JSONObject RuJ;
    public boolean RuK = false;
    public int RuL = 0;
    public boolean RuM = false;

    public g(Map<String, String> map) {
        AppMethodBeat.i(72891);
        Log.i("MicroMsg.NetSceneDelayQueryOrder", "NetSceneDelayQueryOrder call");
        setRequestData(map);
        AppMethodBeat.o(72891);
    }

    public final void ag(boolean z, int i2) {
        AppMethodBeat.i(72892);
        HashMap hashMap = new HashMap();
        hashMap.put("is_last_query", new StringBuilder().append(z ? 1 : 0).toString());
        hashMap.put("curr_query_count", String.valueOf(i2));
        addRequestData(hashMap);
        AppMethodBeat.o(72892);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getTenpayCgicmd() {
        return 1525;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/payorderquery";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getFuncId() {
        return 1525;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        boolean z;
        AppMethodBeat.i(72893);
        super.onGYNetEnd(i2, str, jSONObject);
        if (ac.jPC) {
            try {
                jSONObject = new JSONObject("{\"retcode\":268447844,\"retmsg\":\"系统麻烦请稍后再试\",\"can_pay_retry\":1,\"show_retmsg_type\":1}");
            } catch (Exception e2) {
            }
        }
        Log.i("MicroMsg.NetSceneDelayQueryOrder", "errCode = " + i2 + "errMsg=" + str);
        this.RuJ = jSONObject;
        if (jSONObject != null) {
            Log.d("MicroMsg.NetSceneDelayQueryOrder", "ret json: %s", jSONObject.toString());
            if (jSONObject.optInt("can_pay_retry") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.RuK = z;
            this.RuL = jSONObject.optInt("show_retmsg_type");
        }
        AppMethodBeat.o(72893);
    }

    public final JSONObject hhL() {
        return this.RuJ;
    }
}
