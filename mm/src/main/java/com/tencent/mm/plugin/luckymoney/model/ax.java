package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class ax extends av {
    public String yPK;
    public String yVk;

    public ax(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(65300);
        this.yVk = str3;
        this.yPK = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("receiveId", str3);
        hashMap.put("wishing", URLEncoder.encode(Util.nullAsNil(str2)));
        hashMap.put("ver", str4);
        setRequestData(hashMap);
        AppMethodBeat.o(65300);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1682;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/wishwxhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }
}
