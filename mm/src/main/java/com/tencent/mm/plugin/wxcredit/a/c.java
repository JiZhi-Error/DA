package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public final class c extends m {
    public double JPH = 0.0d;

    public c(List<l> list, String str) {
        AppMethodBeat.i(72301);
        HashMap hashMap = new HashMap();
        hashMap.put("session_key", str);
        int i2 = 0;
        for (l lVar : list) {
            hashMap.put("qt_id_".concat(String.valueOf(i2)), lVar.id);
            hashMap.put("ans_cont_".concat(String.valueOf(i2)), lVar.yWF);
            hashMap.put("level_".concat(String.valueOf(i2)), new StringBuilder().append(lVar.level).toString());
            hashMap.put("parent_id_".concat(String.valueOf(i2)), lVar.JQc);
            int i3 = i2 + 1;
            if (lVar.JQe == null || !"Y".equals(lVar.yWF)) {
                i2 = i3;
            } else {
                hashMap.put("qt_id_".concat(String.valueOf(i3)), lVar.JQe.id);
                hashMap.put("ans_cont_".concat(String.valueOf(i3)), lVar.JQe.yWF);
                hashMap.put("level_".concat(String.valueOf(i3)), new StringBuilder().append(lVar.JQe.level).toString());
                hashMap.put("parent_id_".concat(String.valueOf(i3)), lVar.JQe.JQc);
                i2 = i3 + 1;
            }
        }
        hashMap.put("total_num", String.valueOf(i2));
        setRequestData(hashMap);
        AppMethodBeat.o(72301);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 60;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72302);
        Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(72302);
            return;
        }
        try {
            this.JPH = ((double) jSONObject.getInt("credit_amount")) / 100.0d;
            AppMethodBeat.o(72302);
        } catch (Exception e2) {
            Log.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e2, "", new Object[0]);
            AppMethodBeat.o(72302);
        }
    }
}
