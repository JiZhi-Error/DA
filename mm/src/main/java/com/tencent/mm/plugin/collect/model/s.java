package com.tencent.mm.plugin.collect.model;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s extends m {
    public int dKt;
    public boolean iGD = false;
    private int limit;
    public List<a> qwH = new ArrayList();
    public long qwd;
    public int qwe;
    public int type;

    public s(int i2, long j2, String str, int i3) {
        AppMethodBeat.i(63846);
        this.limit = i3;
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i2));
        hashMap.put("from_timestamp", String.valueOf(j2));
        hashMap.put("last_bill_id", str);
        hashMap.put("num", String.valueOf(i3));
        setRequestData(hashMap);
        AppMethodBeat.o(63846);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvdlist";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1963;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(63847);
        this.qwe = jSONObject.optInt("total_num");
        this.dKt = jSONObject.optInt("total_amt");
        this.qwd = jSONObject.optLong("from_timestamp", 0);
        this.type = jSONObject.optInt("type", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            Log.i("MicroMsg.NetSceneTenpayF2fRecordList", "empty records");
        } else {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    a aVar = new a();
                    aVar.qvC = jSONObject2.optString("bill_id");
                    aVar.qvD = jSONObject2.optString("trans_id");
                    aVar.timestamp = jSONObject2.optLong(AppMeasurement.Param.TIMESTAMP, 0);
                    aVar.desc = jSONObject2.optString("desc");
                    aVar.dFu = jSONObject2.optInt("fee", 0);
                    this.qwH.add(aVar);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneTenpayF2fRecordList", e2, "", new Object[0]);
                }
            }
        }
        if (this.qwH.size() < this.limit) {
            Log.i("MicroMsg.NetSceneTenpayF2fRecordList", "finish query");
            this.iGD = true;
        }
        AppMethodBeat.o(63847);
    }
}
