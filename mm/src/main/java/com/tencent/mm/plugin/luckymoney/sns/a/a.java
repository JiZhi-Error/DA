package com.tencent.mm.plugin.luckymoney.sns.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends m {
    public int yYV = 0;

    public a(int i2, String str, String str2) {
        AppMethodBeat.i(65406);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", String.valueOf(i2));
        hashMap.put("passwd", str);
        hashMap.put("req_key", String.valueOf(str2));
        this.yYV = i2;
        setRequestData(hashMap);
        AppMethodBeat.o(65406);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/snspaymanage";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1697;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1697;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(65407);
        Log.i("MicroMsg.NetSceneSnsPayManage", " errCode: " + i2 + " errMsg :" + str);
        if (i2 != 0) {
            Log.e("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() NetSceneSnsPayManage is false!");
            AppMethodBeat.o(65407);
        } else if (this.yYV == 1) {
            com.tencent.mm.plugin.luckymoney.sns.b.a.PO(1);
            Log.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 1");
            AppMethodBeat.o(65407);
        } else {
            com.tencent.mm.plugin.luckymoney.sns.b.a.PO(0);
            Log.i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 0");
            AppMethodBeat.o(65407);
        }
    }
}
