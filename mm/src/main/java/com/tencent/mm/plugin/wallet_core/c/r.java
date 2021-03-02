package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class r extends m {
    public String HPV;
    public String HPW;
    public BindCardOrder HPX;
    public String resultMsg;

    public r(BindCardOrder bindCardOrder, String str, String str2, String str3, String str4, long j2, long j3, String str5, String str6, int i2, int i3) {
        AppMethodBeat.i(69928);
        this.HPX = bindCardOrder;
        HashMap hashMap = new HashMap();
        hashMap.put("activity_id", str);
        hashMap.put("award_id", str2);
        hashMap.put("send_record_id", str3);
        hashMap.put("user_record_id", str4);
        hashMap.put("activity_mch_id", String.valueOf(j2));
        hashMap.put("activity_type", String.valueOf(j3));
        hashMap.put("bank_type", String.valueOf(str5));
        hashMap.put("bank_serial", String.valueOf(str6));
        hashMap.put("bindbankscene", String.valueOf(i2));
        hashMap.put("realname_scene", String.valueOf(i3));
        setRequestData(hashMap);
        AppMethodBeat.o(69928);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1786;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69929);
        if (jSONObject != null && i2 == 0) {
            this.HPV = jSONObject.optString("result_code");
            this.resultMsg = jSONObject.optString("result_msg");
            this.HPW = jSONObject.optString("alert_wording");
        }
        AppMethodBeat.o(69929);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1786;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sendbindcardaward";
    }
}
