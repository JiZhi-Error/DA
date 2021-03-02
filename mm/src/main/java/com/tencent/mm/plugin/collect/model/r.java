package com.tencent.mm.plugin.collect.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r extends m {
    public boolean iGD;
    public boolean isRetry;
    private int limit;
    public int qwC;
    public int qwD;
    public int qwE;
    public int qwF;
    public String qwG;
    public List<h> qwH;
    public long qwd;

    public r(int i2, long j2, int i3, int i4) {
        AppMethodBeat.i(63843);
        this.iGD = false;
        this.isRetry = false;
        this.qwH = new ArrayList();
        this.limit = i3;
        this.qwD = 0;
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i2));
        hashMap.put("from_timestamp", String.valueOf(j2));
        hashMap.put("direction_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("num", String.valueOf(i3));
        hashMap.put("choose_flag", String.valueOf(i4));
        setRequestData(hashMap);
        AppMethodBeat.o(63843);
    }

    public r(int i2, long j2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(63844);
        this.iGD = false;
        this.isRetry = false;
        this.qwH = new ArrayList();
        this.isRetry = true;
        this.limit = i4;
        this.qwD = i3;
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i2));
        hashMap.put("from_timestamp", String.valueOf(j2));
        hashMap.put("direction_flag", String.valueOf(i3));
        hashMap.put("num", String.valueOf(i4));
        hashMap.put("choose_flag", String.valueOf(i5));
        hashMap.put("try_num", String.valueOf(i6));
        setRequestData(hashMap);
        AppMethodBeat.o(63844);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvrcdhissta";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1993;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(63845);
        Log.d("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "json: %s", jSONObject.toString());
        this.qwC = jSONObject.optInt("choose_flag", 0);
        this.qwd = jSONObject.optLong("from_timestamp", -1);
        this.qwE = jSONObject.optInt("finish_flag", 0);
        this.qwF = jSONObject.optInt("try_num", 0);
        this.qwG = jSONObject.optString("retmsg", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            Log.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "empty records");
        } else {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    h hVar = new h();
                    hVar.type = jSONObject2.optInt("type", 0);
                    hVar.qwd = jSONObject2.optLong("from_timestamp", 0);
                    hVar.qwe = jSONObject2.optInt("total_num", 0);
                    hVar.dKt = jSONObject2.optInt("total_amt", 0);
                    this.qwH.add(hVar);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneTenpayF2fHistoryRecordList", e2, "", new Object[0]);
                }
            }
        }
        if (this.qwE == 1) {
            Log.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "finish query");
            this.iGD = true;
        }
        AppMethodBeat.o(63845);
    }
}
