package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class o extends m {
    public o(int i2, int i3, int i4, String str) {
        this(i2, i3, i4, 0, str);
    }

    public o(int i2, int i3, int i4) {
        this(i2, i3, 0, i4, "");
    }

    private o(int i2, int i3, int i4, int i5, String str) {
        AppMethodBeat.i(66312);
        HashMap hashMap = new HashMap();
        hashMap.put("residue_num", String.valueOf(i2));
        hashMap.put("entry_scene", String.valueOf(i3));
        hashMap.put("is_snapshot", String.valueOf(i4));
        hashMap.put("user_view_digit", String.valueOf(i5));
        StringBuilder sb = new StringBuilder();
        g.aAi();
        hashMap.put("code_ver", sb.append(g.aAh().azQ().get(ar.a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, "")).toString());
        hashMap.put("card_id", a.pQH);
        hashMap.put("user_card_id", a.ANj);
        hashMap.put("card_code", a.ANk);
        hashMap.put("ext_business_attach", str);
        setRequestData(hashMap);
        Log.i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "hy: residue_num == %d, entryscene = %d,is_snapshot = %d, user_view_digit: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        Log.d("MicroMsg.NetSceneTenpayWxOfflineShowCode", "card_id=%s,  user_card_id=%s,  card_code:%s ", a.pQH, a.ANj, a.ANk);
        AppMethodBeat.o(66312);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 102;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66313);
        Log.i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "onGynetEnd %s %s", Integer.valueOf(i2), str);
        AppMethodBeat.o(66313);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1645;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineshowcode";
    }
}
