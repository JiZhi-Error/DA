package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static LinkedList<anr> D(JSONArray jSONArray) {
        AppMethodBeat.i(67830);
        LinkedList<anr> linkedList = new LinkedList<>();
        if (jSONArray == null) {
            AppMethodBeat.o(67830);
        } else {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    anr anr = new anr();
                    anr.LyJ = jSONObject.optString("favor_compose_id");
                    anr.LyK = jSONObject.optLong("show_favor_amount");
                    anr.LyL = jSONObject.optLong("show_pay_amount");
                    anr.LyM = jSONObject.optString("total_favor_amount");
                    anr.Coh = jSONObject.optString("favor_desc");
                    anr.LyN = jSONObject.optLong("compose_sort_flag");
                    anr.Lhy = jSONObject.optString("extend_str");
                    anr.KXX = E(jSONObject.optJSONArray("favor_info_list"));
                    linkedList.add(anr);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.BusiFavorInfoParser", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(67830);
        }
        return linkedList;
    }

    public static LinkedList<ans> E(JSONArray jSONArray) {
        AppMethodBeat.i(67831);
        LinkedList<ans> linkedList = new LinkedList<>();
        if (jSONArray == null) {
            AppMethodBeat.o(67831);
        } else {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    ans ans = new ans();
                    ans.Lza = jSONObject.optString("business_receipt_no");
                    ans.Lhy = jSONObject.optString("extend_str");
                    ans.LyU = jSONObject.optString("fav_desc");
                    ans.LyS = jSONObject.optLong("fav_id", 0);
                    ans.LyT = jSONObject.optString("fav_name");
                    ans.LyX = jSONObject.optString("fav_price");
                    ans.LyQ = jSONObject.optLong("fav_property", 0);
                    ans.LyZ = jSONObject.optInt("fav_scope_type", 0);
                    ans.LyP = jSONObject.optLong("fav_sub_type", 0);
                    ans.LyO = jSONObject.optLong("fav_type", 0);
                    ans.LyW = jSONObject.optString("favor_remarks");
                    ans.LyR = jSONObject.optString("favor_type_desc");
                    ans.LyV = jSONObject.optString("favor_use_manual");
                    ans.LyY = jSONObject.optString("real_fav_fee");
                    ans.Lzb = jSONObject.optInt("unavailable");
                    linkedList.add(ans);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.BusiFavorInfoParser", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(67831);
        }
        return linkedList;
    }
}
