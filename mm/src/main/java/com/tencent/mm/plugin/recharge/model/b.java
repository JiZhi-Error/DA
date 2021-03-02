package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static ArrayList<MallRechargeProduct> a(String str, JSONArray jSONArray) {
        ArrayList<MallRechargeProduct> arrayList;
        AppMethodBeat.i(67091);
        if (jSONArray != null) {
            try {
                arrayList = new ArrayList<>();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(n(str, jSONArray.getJSONObject(i2)));
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.MallLogic", e2, "", new Object[0]);
                AppMethodBeat.o(67091);
                return null;
            }
        } else {
            arrayList = null;
        }
        AppMethodBeat.o(67091);
        return arrayList;
    }

    public static MallRechargeProduct n(String str, JSONObject jSONObject) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(67092);
        MallRechargeProduct mallRechargeProduct = new MallRechargeProduct(jSONObject.optInt("need_getlatestinfo", 1) == 1);
        mallRechargeProduct.kHR = str;
        mallRechargeProduct.productId = jSONObject.getString("product_id");
        mallRechargeProduct.rjt = jSONObject.getString("product_name");
        mallRechargeProduct.BCZ = jSONObject.optString("product_desc");
        mallRechargeProduct.BDa = ((float) jSONObject.getInt("product_min_price")) / 100.0f;
        mallRechargeProduct.BDb = ((float) jSONObject.getInt("product_max_price")) / 100.0f;
        mallRechargeProduct.appId = jSONObject.optString("app_id");
        if (jSONObject.getInt("is_infinite") == 1) {
            z = true;
        } else {
            z = false;
        }
        mallRechargeProduct.BDc = z;
        mallRechargeProduct.BDd = jSONObject.getInt("left_count");
        mallRechargeProduct.BDe = jSONObject.getInt("discount");
        if (jSONObject.optInt("is_default_choose", 0) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        mallRechargeProduct.isDefault = z2;
        mallRechargeProduct.BDg = true;
        mallRechargeProduct.iFf = jSONObject.optInt("product_type", 0);
        AppMethodBeat.o(67092);
        return mallRechargeProduct;
    }

    public static String Ts(String str) {
        AppMethodBeat.i(67093);
        if (str == null) {
            AppMethodBeat.o(67093);
            return null;
        }
        String replaceAll = str.replaceAll("\\D", "");
        if (replaceAll.startsWith("86")) {
            replaceAll = replaceAll.substring(2);
        }
        AppMethodBeat.o(67093);
        return replaceAll;
    }

    public static String aKR(String str) {
        AppMethodBeat.i(67094);
        if (str == null) {
            AppMethodBeat.o(67094);
            return "";
        }
        StringBuilder sb = new StringBuilder(str.replaceAll(" ", ""));
        int length = sb.length();
        if (length >= 4) {
            sb.insert(3, ' ');
            if (length >= 8) {
                sb.insert(8, ' ');
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(67094);
            return sb2;
        }
        String sb3 = sb.toString();
        AppMethodBeat.o(67094);
        return sb3;
    }

    public static void eHO() {
        AppMethodBeat.i(67095);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN, Boolean.TRUE);
        AppMethodBeat.o(67095);
    }

    public static boolean g(MallFunction mallFunction) {
        AppMethodBeat.i(67096);
        if (mallFunction.Icf == null || mallFunction.Icf.trD != 1 || Util.isNullOrNil(mallFunction.Icf.Ict)) {
            AppMethodBeat.o(67096);
            return false;
        }
        g.aAi();
        if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            AppMethodBeat.o(67096);
            return true;
        }
        AppMethodBeat.o(67096);
        return false;
    }
}
