package com.tencent.midas.api.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class APInventory {
    public ArrayList<APPurchase> mPurchaseList = new ArrayList<>();
    public Map<String, APPurchase> mPurchaseMap = new HashMap();

    public APInventory(String str) {
        AppMethodBeat.i(192925);
        parsePurchse(str);
        AppMethodBeat.o(192925);
    }

    private void parsePurchse(String str) {
        AppMethodBeat.i(192926);
        new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                APPurchase aPPurchase = new APPurchase((String) jSONArray.getJSONObject(i2).get("data"), (String) jSONArray.getJSONObject(i2).get("sign"));
                this.mPurchaseMap.put(aPPurchase.getSku(), aPPurchase);
                this.mPurchaseList.add(aPPurchase);
            }
            AppMethodBeat.o(192926);
        } catch (JSONException e2) {
            AppMethodBeat.o(192926);
        }
    }

    public List<APPurchase> getPurchaseList() {
        return this.mPurchaseList;
    }

    public APPurchase getPurchase(String str) {
        AppMethodBeat.i(192927);
        APPurchase aPPurchase = this.mPurchaseMap.get(str);
        AppMethodBeat.o(192927);
        return aPPurchase;
    }

    public boolean hasPurchase(String str) {
        AppMethodBeat.i(192928);
        boolean containsKey = this.mPurchaseMap.containsKey(str);
        AppMethodBeat.o(192928);
        return containsKey;
    }

    public void erasePurchase(String str) {
        AppMethodBeat.i(192929);
        if (this.mPurchaseMap.containsKey(str)) {
            this.mPurchaseMap.remove(str);
        }
        AppMethodBeat.o(192929);
    }

    /* access modifiers changed from: package-private */
    public List<String> getAllOwnedSkus() {
        AppMethodBeat.i(192930);
        ArrayList arrayList = new ArrayList(this.mPurchaseMap.keySet());
        AppMethodBeat.o(192930);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<APPurchase> getAllPurchases() {
        AppMethodBeat.i(192931);
        ArrayList arrayList = new ArrayList(this.mPurchaseMap.values());
        AppMethodBeat.o(192931);
        return arrayList;
    }
}
