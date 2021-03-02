package com.tencent.mm.plugin.card.d;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.protobuf.bkx;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.protocal.protobuf.wd;
import com.tencent.mm.protocal.protobuf.we;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j {
    public static void d(LinkedList<wc> linkedList, int i2) {
        AppMethodBeat.i(113805);
        if (linkedList == null) {
            AppMethodBeat.o(113805);
            return;
        }
        int size = linkedList.size();
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            wc wcVar = linkedList.get(i3);
            c ctQ = am.ctQ();
            String str = wcVar.eaO;
            int i4 = ((size - i3) * 10) + i2;
            String str2 = wcVar.pWh;
            int i5 = wcVar.pSb;
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.CardInfoStorage", "cardId null");
            } else {
                ctQ.db.execSQL("UserCardInfo", "update UserCardInfo set stickyIndex=" + i4 + ", stickyAnnouncement='" + str2 + "', stickyEndTime=" + i5 + " where card_id='" + str + "'");
            }
        }
        AppMethodBeat.o(113805);
    }

    public static void e(LinkedList<wc> linkedList, int i2) {
        String str;
        AppMethodBeat.i(113806);
        if (linkedList == null) {
            AppMethodBeat.o(113806);
            return;
        }
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            wc wcVar = linkedList.get(i3);
            c ctQ = am.ctQ();
            String str2 = wcVar.eaO;
            if (wcVar.Lhr != null) {
                str = wcVar.Lhr;
            } else {
                str = "";
            }
            ctQ.db.execSQL("UserCardInfo", "update UserCardInfo set stickyIndex=" + i2 + ", label_wording='" + str + "' where card_id='" + str2 + "'");
        }
        AppMethodBeat.o(113806);
    }

    public static bkx akd(String str) {
        CardInfo ajk;
        AppMethodBeat.i(113807);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.CardStickyHelper", "jsonRet null");
            AppMethodBeat.o(113807);
            return null;
        }
        bkx bkx = new bkx();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bkx.LTF = jSONObject.optString("layout_buff");
            JSONObject jSONObject2 = jSONObject.getJSONObject("list");
            if (jSONObject2 != null) {
                bkx.LTL = new we();
                bkx.LTL.Lht = aF(jSONObject2.optJSONObject("expiring_list"));
                bkx.LTL.Lhu = aF(jSONObject2.optJSONObject("member_card_list"));
                bkx.LTL.Lhv = aF(jSONObject2.optJSONObject("nearby_list"));
                bkx.LTL.Lhw = aF(jSONObject2.optJSONObject("label_list"));
                bkx.LTL.Lhx = aF(jSONObject2.optJSONObject("first_list"));
                if (!(bkx.LTL.Lhx == null || bkx.LTL.Lhx.Lhs == null)) {
                    for (int size = bkx.LTL.Lhx.Lhs.size() - 1; size >= 0; size--) {
                        wc wcVar = bkx.LTL.Lhx.Lhs.get(size);
                        if (!Util.isNullOrNil(wcVar.eaO) && (ajk = am.ctQ().ajk(wcVar.eaO)) != null && !ajk.csx()) {
                            bkx.LTL.Lhx.Lhs.remove(size);
                        }
                    }
                }
                bkx.LTM = jSONObject2.optString("red_dot_wording");
                bkx.LTN = jSONObject2.optInt("show_red_dot", 0) == 1;
                String optString = jSONObject2.optString("title");
                if (optString == null) {
                    optString = "";
                }
                am.ctV().putValue("key_card_entrance_tips", optString);
                bkx.LTO = jSONObject2.optInt("top_scene", 100);
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CardStickyHelper", e2, "", new Object[0]);
        }
        AppMethodBeat.o(113807);
        return bkx;
    }

    private static wd aF(JSONObject jSONObject) {
        wc wcVar;
        AppMethodBeat.i(113808);
        if (jSONObject == null) {
            Log.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
            AppMethodBeat.o(113808);
            return null;
        }
        wd wdVar = new wd();
        wdVar.Lhs = new LinkedList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(FirebaseAnalytics.b.ITEM_LIST);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2 == null) {
                    wcVar = null;
                } else {
                    wcVar = new wc();
                    wcVar.pWh = jSONObject2.optString("announcement");
                    wcVar.eaO = jSONObject2.optString("card_id");
                    wcVar.pSb = jSONObject2.optInt("end_time", 0);
                    wcVar.KWR = jSONObject2.optInt("update_time", 0);
                    wcVar.Lhr = jSONObject2.optString("label_wording");
                }
                if (wcVar == null || (((long) wcVar.pSb) <= Util.nowSecond() && wcVar.pSb != 0)) {
                    Log.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
                } else {
                    wdVar.Lhs.add(wcVar);
                }
            }
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CardStickyHelper", e2, "", new Object[0]);
        }
        AppMethodBeat.o(113808);
        return wdVar;
    }

    public static String a(Context context, int i2, CardInfo cardInfo) {
        AppMethodBeat.i(113809);
        switch (i2 % 10) {
            case 0:
                String string = context.getString(R.string.atg);
                AppMethodBeat.o(113809);
                return string;
            case 1:
                String string2 = context.getString(R.string.atf);
                AppMethodBeat.o(113809);
                return string2;
            case 2:
                String string3 = context.getString(R.string.ate);
                AppMethodBeat.o(113809);
                return string3;
            case 3:
                String string4 = context.getString(R.string.atd);
                AppMethodBeat.o(113809);
                return string4;
            case 4:
                String str = cardInfo.field_label_wording;
                AppMethodBeat.o(113809);
                return str;
            default:
                AppMethodBeat.o(113809);
                return null;
        }
    }
}
