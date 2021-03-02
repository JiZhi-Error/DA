package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.TenpayCgiCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.p;
import java.util.HashMap;
import org.json.JSONObject;

public class NetSceneTenpay extends p {
    private static final String TAG = "WXP";
    TenpayCgiCallback mCallback;
    int mCgiId;

    public interface EndCallback {
        void onEnd(int i2);
    }

    public NetSceneTenpay(int i2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, TenpayCgiCallback tenpayCgiCallback) {
        AppMethodBeat.i(18669);
        this.mCgiId = i2;
        this.mCallback = tenpayCgiCallback;
        setWXRequestData(hashMap2);
        setRequestData(hashMap);
        AppMethodBeat.o(18669);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getTenpayCgicmd() {
        return this.mCgiId;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getFuncId() {
        return this.mCgiId;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public String getUri() {
        AppMethodBeat.i(18670);
        switch (getFuncId()) {
            case 1544:
                AppMethodBeat.o(18670);
                return "/cgi-bin/mmpay-bin/transferplaceorder";
            case 1679:
                AppMethodBeat.o(18670);
                return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
            case 1992:
                AppMethodBeat.o(18670);
                return "/cgi-bin/mmpay-bin/gettransferwording";
            default:
                String uri = super.getUri();
                AppMethodBeat.o(18670);
                return uri;
        }
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.wallet_core.c.s
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(18671);
        super.onGYNetEnd(i2, str, jSONObject);
        Log.i(TAG, "errCode:%d,errMsg:%s,json:%s", Integer.valueOf(i2), str, jSONObject);
        String.format("errCode:%d,errMsg:%s,json:%s", Integer.valueOf(i2), str, jSONObject);
        if (i2 == 0) {
            this.mCallback.onSuccess(jSONObject.toString());
            AppMethodBeat.o(18671);
            return;
        }
        this.mCallback.onError(i2, str);
        AppMethodBeat.o(18671);
    }
}
