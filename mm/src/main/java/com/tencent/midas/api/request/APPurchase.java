package com.tencent.midas.api.request;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class APPurchase {
    public String mOriginalJson;
    public String mSignature;
    public String mSku;

    public APPurchase(String str, String str2) {
        AppMethodBeat.i(192922);
        this.mOriginalJson = str;
        this.mSku = new JSONObject(new String(Base64.decode(str.getBytes(), 0))).optString("product-id");
        this.mSignature = str2;
        AppMethodBeat.o(192922);
    }

    public APPurchase(String str) {
        AppMethodBeat.i(192923);
        JSONObject jSONObject = new JSONObject(str);
        this.mSignature = (String) jSONObject.get("sign");
        this.mOriginalJson = (String) jSONObject.get("data");
        this.mSku = "";
        AppMethodBeat.o(192923);
    }

    public APPurchase() {
        this.mSignature = "";
        this.mOriginalJson = "";
        this.mSku = "";
    }

    public String getSku() {
        return this.mSku;
    }

    public String getOriginalJson() {
        return this.mOriginalJson;
    }

    public String getSignature() {
        return this.mSignature;
    }

    public String toString() {
        AppMethodBeat.i(192924);
        String str = "PurchaseInfo():" + this.mOriginalJson;
        AppMethodBeat.o(192924);
        return str;
    }
}
