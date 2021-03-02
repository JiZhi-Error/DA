package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.protocal.protobuf.ebf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

final class e {
    static c<String, Integer> a(ebf ebf) {
        AppMethodBeat.i(177365);
        LinkedList<dzv> linkedList = ebf.NaV;
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<dzv> it = linkedList.iterator();
            while (it.hasNext()) {
                dzv next = it.next();
                if (next != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("feedId", next.feedId);
                    jSONObject.put("viewLikeCount", next.likeCount);
                    jSONObject.put("viewCommentCount", next.commentCount);
                    jSONObject.put("userName", next.userName);
                    jSONObject.put("nickName", next.nickName);
                    jSONObject.put("isAd", next.isAd);
                    jSONObject.put("feedheight", next.height);
                    next.MZu = new BigDecimal(next.MZu).setScale(2, 4).doubleValue();
                    jSONObject.put("realShowTime", next.MZu);
                    next.MZt = new BigDecimal(next.MZt).setScale(2, 4).doubleValue();
                    jSONObject.put("stayTimeRelative", next.MZt);
                    jSONObject.put("realScreenHeight", ((next.mEY - next.CHZ) - next.udM) - next.virtualKeyHeight);
                    jSONArray.put(jSONObject);
                }
            }
            int length = jSONArray.length();
            if (length > 0) {
                c<String, Integer> Q = a.Q(jSONArray.toString(), Integer.valueOf(length));
                AppMethodBeat.o(177365);
                return Q;
            }
            Log.e("HABBYGE-MALI.HellTimelineReport", "_feedList2JsonV2 jsonArray Empty !!!!");
            jSONArray.put(b(ebf));
            c<String, Integer> Q2 = a.Q(jSONArray.toString(), 1);
            AppMethodBeat.o(177365);
            return Q2;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", e2, "_feedList2JsonV2-crash, %s", e2.getMessage());
            AppMethodBeat.o(177365);
            return null;
        }
    }

    private static JSONObject b(ebf ebf) {
        AppMethodBeat.i(177366);
        Log.w("HABBYGE-MALI.HellTimelineReport", "createInvalidateFeed, timeline: %s, %s, %s", Long.valueOf(ebf.NaS), Long.valueOf(ebf.NaT), Long.valueOf(ebf.NaU));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("feedId", "10001");
            jSONObject.put("viewLikeCount", 0);
            jSONObject.put("viewCommentCount", 0);
            jSONObject.put("userName", "");
            jSONObject.put("feedheight", 0);
            jSONObject.put("realShowTime", new BigDecimal(ebf.NaS).setScale(2, 4).doubleValue());
            jSONObject.put("stayTimeRelative", new BigDecimal(ebf.NaS).setScale(2, 4).doubleValue());
            jSONObject.put("realScreenHeight", 0);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellTimelineReport", e2, "createInvalidateFeed-crash, %s", e2.getMessage());
        }
        AppMethodBeat.o(177366);
        return jSONObject;
    }
}
