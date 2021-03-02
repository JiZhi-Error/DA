package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public Orders CwO;
    private String mReqKey;

    public b(String str) {
        this(str, (byte) 0);
    }

    private b(String str, byte b2) {
        AppMethodBeat.i(163874);
        this.CwO = null;
        this.mReqKey = null;
        this.mReqKey = str;
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", this.mReqKey);
        hashMap.put("query_scene", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        setRequestData(hashMap);
        AppMethodBeat.o(163874);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 8;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72085);
        this.CwO = Orders.by(jSONObject);
        if (this.CwO != null) {
            this.CwO.dDL = this.mReqKey;
        }
        AppMethodBeat.o(72085);
    }
}
