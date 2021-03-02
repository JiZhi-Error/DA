package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class au extends av {
    public au(String str, String str2, int i2, int i3, String str3) {
        AppMethodBeat.i(65295);
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", String.valueOf(str));
        hashMap.put("offset", String.valueOf(i3));
        hashMap.put("type", String.valueOf(i2));
        hashMap.put("receiveId", str2);
        hashMap.put("ver", str3);
        setRequestData(hashMap);
        AppMethodBeat.o(65295);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1612;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/deletelistwxhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(65296);
        Log.i("NetSceneLuckyMoneyMyRecordDelete", "onGYNetEnd");
        AppMethodBeat.o(65296);
    }
}
