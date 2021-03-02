package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class at extends av {
    public String yXA = null;
    public String yXg;
    public x yXx;
    public List<String> yXy;
    public String yXz;

    public at(int i2, int i3, int i4, String str, String str2, String str3) {
        AppMethodBeat.i(65293);
        HashMap hashMap = new HashMap();
        hashMap.put("limit", String.valueOf(i2));
        hashMap.put("offset", String.valueOf(i3));
        hashMap.put("type", String.valueOf(i4));
        hashMap.put("year", str);
        hashMap.put("ver", str2);
        hashMap.put("processContent", str3);
        setRequestData(hashMap);
        AppMethodBeat.o(65293);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1514;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public final String czD() {
        return "/cgi-bin/mmpay-bin/qrylistwxhb";
    }

    public final boolean efl() {
        if (this.yXx == null || this.yXx.yVn == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        String[] split;
        AppMethodBeat.i(65294);
        try {
            x xVar = new x();
            xVar.yWi = jSONObject.optInt("recTotalNum");
            xVar.yWj = jSONObject.optLong("recTotalAmount");
            xVar.yWk = jSONObject.optInt("sendTotalNum");
            xVar.yWl = jSONObject.optLong("sendTotalAmount");
            xVar.yVn = jSONObject.optInt("isContinue");
            xVar.yWm = jSONObject.optInt("gameCount");
            JSONArray optJSONArray = jSONObject.optJSONArray("record");
            LinkedList<y> linkedList = new LinkedList<>();
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    y yVar = new y();
                    yVar.yWn = jSONObject2.optString("sendName");
                    yVar.yVe = jSONObject2.optString("sendHeadImg");
                    yVar.yWo = jSONObject2.optLong("receiveAmount");
                    yVar.yWp = jSONObject2.optString("receiveTime");
                    yVar.egY = jSONObject2.optInt("hbType");
                    yVar.yWq = jSONObject2.optString("sendTitle");
                    yVar.yWr = jSONObject2.optString("sendTime");
                    yVar.yVj = jSONObject2.optLong("totalAmount");
                    yVar.yWs = jSONObject2.optLong("totalNum");
                    yVar.yVh = jSONObject2.optLong("recNum");
                    yVar.status = jSONObject2.optInt("status");
                    yVar.yWt = jSONObject2.optInt("thxCount");
                    yVar.yVk = jSONObject2.optString("receiveId");
                    yVar.yQE = jSONObject2.optString("sendId");
                    yVar.yVv = jSONObject2.optInt("hbKind");
                    yVar.yWu = jSONObject2.optString("sendsuffix");
                    yVar.yWv = jSONObject2.optString("sendDesc");
                    linkedList.add(yVar);
                }
            }
            xVar.yVw = linkedList;
            this.yXx = xVar;
            this.yXy = new ArrayList();
            String optString = jSONObject.optString("years");
            if (!Util.isNullOrNil(optString) && (split = optString.split("\\|")) != null) {
                for (String str2 : split) {
                    this.yXy.add(str2);
                }
            }
            this.yXz = jSONObject.optString("recordYear");
            this.yXA = jSONObject.optString("clickedUrl");
            this.yXg = jSONObject.optString("processContent");
            AppMethodBeat.o(65294);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", e2, "", new Object[0]);
            AppMethodBeat.o(65294);
        }
    }
}
