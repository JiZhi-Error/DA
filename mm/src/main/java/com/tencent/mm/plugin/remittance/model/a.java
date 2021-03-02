package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static JSONObject a(rc rcVar) {
        AppMethodBeat.i(67824);
        if (rcVar == null) {
            JSONObject jSONObject = new JSONObject();
            AppMethodBeat.o(67824);
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            LinkedList<ans> linkedList = rcVar.KXX;
            new ans();
            jSONObject2.put("favor_info_list", gr(linkedList));
            LinkedList<anr> linkedList2 = rcVar.KXY;
            new anr();
            jSONObject2.put("favor_compose_result_list", gs(linkedList2));
            jSONObject2.put("default_fav_compose_id", rcVar.KXZ);
            jSONObject2.put("favor_resp_sign", rcVar.KYa);
            jSONObject2.put("no_compose_wording", rcVar.KYb);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e2, "", new Object[0]);
        }
        AppMethodBeat.o(67824);
        return jSONObject2;
    }

    private static JSONArray gr(List<ans> list) {
        AppMethodBeat.i(67825);
        if (list == null) {
            JSONArray jSONArray = new JSONArray();
            AppMethodBeat.o(67825);
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            int i2 = 0;
            for (ans ans : list) {
                jSONArray2.put(i2, a(ans));
                i2++;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e2, "", new Object[0]);
        }
        AppMethodBeat.o(67825);
        return jSONArray2;
    }

    private static JSONObject a(ans ans) {
        AppMethodBeat.i(67826);
        if (ans == null) {
            JSONObject jSONObject = new JSONObject();
            AppMethodBeat.o(67826);
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("fav_type", ans.LyO);
            jSONObject2.put("fav_sub_type", ans.LyP);
            jSONObject2.put("fav_property", ans.LyQ);
            jSONObject2.put("favor_type_desc", ans.LyR);
            jSONObject2.put("fav_id", ans.LyS);
            jSONObject2.put("fav_name", ans.LyT);
            jSONObject2.put("fav_desc", ans.LyU);
            jSONObject2.put("favor_use_manual", ans.LyV);
            jSONObject2.put("favor_remarks", ans.LyW);
            jSONObject2.put("fav_price", ans.LyX);
            jSONObject2.put("real_fav_fee", ans.LyY);
            jSONObject2.put("fav_scope_type", ans.LyZ);
            jSONObject2.put("business_receipt_no", ans.Lza);
            jSONObject2.put("unavailable", ans.Lzb);
            AppMethodBeat.o(67826);
            return jSONObject2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e2, "", new Object[0]);
            AppMethodBeat.o(67826);
            return jSONObject2;
        }
    }

    private static JSONArray gs(List<anr> list) {
        AppMethodBeat.i(67827);
        if (list == null) {
            JSONArray jSONArray = new JSONArray();
            AppMethodBeat.o(67827);
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            int i2 = 0;
            for (anr anr : list) {
                jSONArray2.put(i2, a(anr));
                i2++;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e2, "", new Object[0]);
        }
        AppMethodBeat.o(67827);
        return jSONArray2;
    }

    public static JSONObject a(anr anr) {
        AppMethodBeat.i(67828);
        if (anr == null) {
            JSONObject jSONObject = new JSONObject();
            AppMethodBeat.o(67828);
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("favor_compose_id", anr.LyJ);
            LinkedList<ans> linkedList = anr.KXX;
            new ans();
            jSONObject2.put("favor_info_list,", gr(linkedList));
            jSONObject2.put("show_favor_amount,", anr.LyK);
            jSONObject2.put("show_pay_amount,", anr.LyL);
            jSONObject2.put("total_favor_amount,", anr.LyM);
            jSONObject2.put("favor_desc", anr.Coh);
            jSONObject2.put("compose_sort_flag", anr.LyN);
            jSONObject2.put("extend_str", anr.Lhy);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e2, "", new Object[0]);
        }
        AppMethodBeat.o(67828);
        return jSONObject2;
    }

    public static JSONObject a(du duVar) {
        AppMethodBeat.i(67829);
        if (duVar == null) {
            JSONObject jSONObject = new JSONObject();
            AppMethodBeat.o(67829);
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("channel", duVar.channel);
            jSONObject2.put("favor_compose_info", a(duVar.KHP));
            jSONObject2.put("f2f_id", duVar.KHM);
            jSONObject2.put("payok_checksign", duVar.KHO);
            jSONObject2.put("receiver_openid", duVar.CpJ);
            jSONObject2.put("receiver_username", duVar.jTz);
            jSONObject2.put("scan_scene", duVar.Coi);
            jSONObject2.put("scene", duVar.scene);
            jSONObject2.put("total_amount", duVar.KHQ);
            jSONObject2.put("trans_id", duVar.KHN);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e2, "", new Object[0]);
        }
        AppMethodBeat.o(67829);
        return jSONObject2;
    }
}
