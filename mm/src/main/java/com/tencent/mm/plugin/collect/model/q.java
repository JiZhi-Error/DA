package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class q extends m {
    public int dKt;
    public String qvC;
    public long qwd;
    public int qwe;
    public int type;

    public q(String str, int i2, long j2) {
        AppMethodBeat.i(63841);
        this.qvC = str;
        HashMap hashMap = new HashMap();
        hashMap.put("bill_id", str);
        hashMap.put("type", String.valueOf(i2));
        hashMap.put("from_timestamp", String.valueOf(j2));
        setRequestData(hashMap);
        AppMethodBeat.o(63841);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frmrcvdrcd";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1964;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(63842);
        this.qwe = jSONObject.optInt("total_num", 0);
        this.dKt = jSONObject.optInt("total_amt", 0);
        this.type = jSONObject.optInt("type", 0);
        this.qwd = jSONObject.optLong("from_timestamp", 0);
        AppMethodBeat.o(63842);
    }
}
