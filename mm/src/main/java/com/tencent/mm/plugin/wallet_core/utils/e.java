package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import org.json.JSONObject;

public final class e {
    public static void bW(JSONObject jSONObject) {
        String str;
        String str2;
        AppMethodBeat.i(71641);
        if (jSONObject == null) {
            Log.e("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData() json is null");
            AppMethodBeat.o(71641);
            return;
        }
        Log.i("MicroMsg.WalletNetSceneUtil", "parseLuckyMoneySnsPayData()");
        String str3 = "";
        String str4 = "";
        int optInt = jSONObject.optInt("is_open_sns_pay", 0);
        int optInt2 = jSONObject.optInt("can_open_sns_pay", 0);
        int optInt3 = jSONObject.optInt("is_white_user", 0);
        if (optInt2 == 1) {
            str3 = jSONObject.optString("open_sns_pay_title");
            str4 = jSONObject.optString("open_sns_pay_wording");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_OPEN_SNS_PAY_TITLE_STRING_SYNC, str3);
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_OPEN_SNS_PAY_WORDING_STRING_SYNC, str4);
        }
        Log.i("MicroMsg.WalletNetSceneUtil", "is_open_sns_pay:" + optInt + ", can_open_sns_pay:" + optInt2 + ", is_white_user:" + optInt3);
        Log.i("MicroMsg.WalletNetSceneUtil", "open_sns_pay_title:" + str3 + ", open_sns_pay_wording:" + str4);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(optInt));
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_CAN_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(optInt2));
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_IS_WHITE_USER_INT_SYNC, Integer.valueOf(optInt3));
        if (optInt3 == 1) {
            str2 = jSONObject.optString("set_sns_pay_title");
            str = jSONObject.optString("set_sns_pay_wording");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_TITLE_STRING_SYNC, str2);
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_WORDING_STRING_SYNC, str);
        } else {
            str = "";
            str2 = "";
        }
        Log.i("MicroMsg.WalletNetSceneUtil", "set_sns_pay_title:" + str2 + ", set_sns_pay_wording:" + str);
        g.aAi();
        g.aAh().azQ().gBI();
        AppMethodBeat.o(71641);
    }
}
