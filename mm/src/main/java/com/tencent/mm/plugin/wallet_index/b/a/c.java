package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.ArrayList;
import org.json.JSONObject;

public final class c {
    String IqA;
    public String IqB;
    long IqC;
    int IqD;
    public String IqE;
    public String IqF;
    public String IqG;
    public String mOriginalJson;
    String mPackageName;
    public String mSignature;
    public String mToken;
    public String rcD;

    public c(String str, String str2, String str3) {
        AppMethodBeat.i(71806);
        this.IqA = str;
        this.mOriginalJson = str2;
        JSONObject jSONObject = new JSONObject(this.mOriginalJson);
        this.IqB = jSONObject.optString("orderId");
        this.mPackageName = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        this.rcD = jSONObject.optString("productId");
        this.IqC = jSONObject.optLong("purchaseTime");
        this.IqD = jSONObject.optInt("purchaseState");
        String optString = jSONObject.optString("developerPayload");
        ArrayList<String> aVY = aVY(optString);
        if (aVY.size() == 3) {
            this.IqE = aVY.get(0);
            this.IqG = aVY.get(1);
            this.IqF = aVY.get(2);
        } else {
            this.IqE = optString;
        }
        this.mToken = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.mSignature = str3;
        AppMethodBeat.o(71806);
    }

    public c(String str, String str2, String str3, String str4) {
        this.rcD = str;
        this.IqE = str2;
        this.IqF = str3;
        this.IqG = str4;
    }

    private static ArrayList<String> aVY(String str) {
        AppMethodBeat.i(71807);
        ArrayList<String> arrayList = new ArrayList<>();
        while (str.indexOf("[#]") >= 0) {
            String substring = str.substring(0, str.indexOf("[#]"));
            str = str.substring(substring.length() + 3);
            arrayList.add(substring);
        }
        arrayList.add(str);
        AppMethodBeat.o(71807);
        return arrayList;
    }

    public final String toString() {
        AppMethodBeat.i(71808);
        String str = "PurchaseInfo(type:" + this.IqA + "):" + this.mOriginalJson;
        AppMethodBeat.o(71808);
        return str;
    }
}
