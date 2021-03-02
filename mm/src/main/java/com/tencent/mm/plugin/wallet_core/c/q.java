package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q extends m {
    public q() {
        AppMethodBeat.i(69926);
        setRequestData(new HashMap());
        AppMethodBeat.o(69926);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1631;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69927);
        Log.i("MicroMsg.NetSceneQueryUserWallet", "errCode is : ".concat(String.valueOf(i2)));
        if (i2 == 0) {
            t.fQL().db.execSQL("WalletKindInfo", "delete from WalletKindInfo");
            if (jSONObject != null) {
                Log.i("MicroMsg.NetSceneQueryUserWallet", "resp json " + jSONObject.toString());
                JSONArray optJSONArray = jSONObject.optJSONArray("UserWalletInfoList");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        ad bO = ad.bO(optJSONArray.optJSONObject(i3));
                        if (bO != null) {
                            t.fQL().insert(bO);
                        }
                    }
                    AppMethodBeat.o(69927);
                    return;
                }
                Log.e("MicroMsg.NetSceneQueryUserWallet", "wallet array is null");
                AppMethodBeat.o(69927);
                return;
            }
            Log.e("MicroMsg.NetSceneQueryUserWallet", "response json is null");
        }
        AppMethodBeat.o(69927);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/queryuserwallet";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1631;
    }
}
