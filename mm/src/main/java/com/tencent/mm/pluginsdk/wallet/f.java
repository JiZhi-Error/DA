package com.tencent.mm.pluginsdk.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;

public final class f {
    public static boolean a(Context context, Bundle bundle, boolean z, String str) {
        AppMethodBeat.i(117575);
        Intent intent = new Intent();
        intent.putExtra("orderhandlerui_checkapp_result", z);
        if (!Util.isNullOrNil(str)) {
            intent.putExtra(ConstantsAPI.APP_PACKAGE, str);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        PayReq payReq = new PayReq();
        payReq.fromBundle(intent.getExtras());
        Util.isNullOrNil(payReq.prepayId);
        if (gsT()) {
            intent.addFlags(268435456);
            intent.addFlags(32768);
        }
        c.b(context, "wallet_index", ".ui.OrderHandlerUI", intent);
        AppMethodBeat.o(117575);
        return true;
    }

    public static boolean a(MMActivity mMActivity, WalletJsapiData walletJsapiData, int i2, MMActivity.a aVar) {
        AppMethodBeat.i(117576);
        if (walletJsapiData == null) {
            AppMethodBeat.o(117576);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("WalletJsapiData", walletJsapiData);
        intent.putExtra("requestCode", i2);
        if (aVar != null) {
            mMActivity.mmSetOnActivityResultCallback(aVar);
        }
        Log.i("MicroMsg.WalletManager", "startJsapiPay context %s from %s", mMActivity, Util.getStack());
        c.a((Context) mMActivity, "wallet_index", ".ui.WalletBrandUI", intent, i2, false);
        AppMethodBeat.o(117576);
        return true;
    }

    public static boolean a(MMActivity mMActivity, String str, Map<String, String> map, int i2, MMActivity.a aVar) {
        AppMethodBeat.i(117577);
        WalletJsapiData walletJsapiData = new WalletJsapiData();
        walletJsapiData.KxH = 4;
        walletJsapiData.DWX = str;
        walletJsapiData.KxP = map;
        Intent intent = new Intent();
        intent.putExtra("WalletJsapiData", walletJsapiData);
        intent.putExtra("requestCode", i2);
        mMActivity.mmSetOnActivityResultCallback(aVar);
        Log.i("MicroMsg.WalletManager", "startPayComponent context %s from %s", mMActivity, Util.getStack());
        c.a((Context) mMActivity, "wallet_index", ".ui.WalletBrandUI", intent, i2, false);
        AppMethodBeat.o(117577);
        return true;
    }

    public static void aD(Context context, int i2) {
        AppMethodBeat.i(117578);
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", i2);
        c.b(context, "collect", ".ui.CollectAdapterUI", intent);
        AppMethodBeat.o(117578);
    }

    public static boolean a(Context context, String str, String str2, int i2, int i3) {
        AppMethodBeat.i(117579);
        boolean b2 = b(context, str, str2, i2, i3);
        AppMethodBeat.o(117579);
        return b2;
    }

    private static boolean b(Context context, String str, String str2, int i2, int i3) {
        AppMethodBeat.i(117580);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(117580);
            return false;
        }
        boolean a2 = a(context, ap(str, str2, i2), i3);
        AppMethodBeat.o(117580);
        return a2;
    }

    public static PayInfo ap(String str, String str2, int i2) {
        AppMethodBeat.i(117581);
        PayInfo payInfo = new PayInfo();
        payInfo.dDL = str;
        payInfo.appId = str2;
        payInfo.IqM = null;
        payInfo.dVv = i2;
        payInfo.errMsg = null;
        payInfo.channel = 0;
        AppMethodBeat.o(117581);
        return payInfo;
    }

    public static boolean a(Context context, PayInfo payInfo, int i2) {
        AppMethodBeat.i(117582);
        boolean a2 = a(context, false, "", payInfo, i2);
        AppMethodBeat.o(117582);
        return a2;
    }

    private static boolean a(Context context, boolean z, String str, PayInfo payInfo, int i2) {
        AppMethodBeat.i(117583);
        boolean b2 = b(context, z, str, payInfo, i2);
        AppMethodBeat.o(117583);
        return b2;
    }

    private static boolean b(Context context, boolean z, String str, PayInfo payInfo, int i2) {
        AppMethodBeat.i(117584);
        boolean a2 = a(context, z, str, payInfo, null, new Intent(), i2);
        AppMethodBeat.o(117584);
        return a2;
    }

    public static boolean a(Context context, boolean z, String str, PayInfo payInfo, String str2, Intent intent, int i2) {
        AppMethodBeat.i(117585);
        boolean a2 = a(context, z, str, "", payInfo, str2, intent, i2);
        AppMethodBeat.o(117585);
        return a2;
    }

    public static boolean a(Context context, boolean z, String str, String str2, PayInfo payInfo, String str3, Intent intent, int i2) {
        AppMethodBeat.i(117586);
        if (2 == payInfo.dVv || 1 == payInfo.dVv || 4 == payInfo.dVv || 36 == payInfo.dVv) {
            payInfo.crp = false;
        } else {
            payInfo.crp = true;
        }
        if (payInfo.dVv == 4 || payInfo.dVv == 1 || 36 == payInfo.dVv || 8 == payInfo.dVv) {
            payInfo.Kxs = true;
        } else {
            payInfo.Kxs = false;
        }
        payInfo.Cpg = str3;
        intent.putExtra("key_pay_info", payInfo);
        intent.putExtra("key_force_use_bind_serail", Util.nullAsNil(str));
        intent.putExtra("key_is_force_use_given_card", z);
        if (context instanceof Activity) {
            intent.putExtra("key_context_hashcode", context.hashCode());
            Log.i("MicroMsg.WalletManager", "startPay context %s %s", context, Integer.valueOf(context.hashCode()));
        }
        if (!Util.isNullOrNil(str2)) {
            intent.putExtra("key_is_use_default_card", str2);
        }
        Log.i("MicroMsg.WalletManager", "startPay context %s from %s", context, Util.getStack());
        intent.putExtra("key_receiver_true_name", str3);
        if (z.aUo()) {
            c.b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent, i2);
        } else {
            c.b(context, "wallet", ".pay.ui.WalletPayUI", intent, i2);
        }
        AppMethodBeat.o(117586);
        return true;
    }

    public static boolean b(Context context, String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(117587);
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(117587);
            return false;
        }
        boolean a2 = a(context, true, str, ap(str2, str3, i2), i3);
        AppMethodBeat.o(117587);
        return a2;
    }

    public static boolean b(MMActivity mMActivity, WalletJsapiData walletJsapiData, int i2, MMActivity.a aVar) {
        AppMethodBeat.i(117588);
        Intent intent = new Intent();
        intent.putExtra("appId", walletJsapiData.appId);
        intent.putExtra("timeStamp", walletJsapiData.timeStamp);
        intent.putExtra("nonceStr", walletJsapiData.nonceStr);
        intent.putExtra("packageExt", walletJsapiData.packageExt);
        intent.putExtra("signtype", walletJsapiData.signType);
        intent.putExtra("paySignature", walletJsapiData.dVt);
        intent.putExtra("url", walletJsapiData.url);
        intent.putExtra("key_bind_scene", walletJsapiData.dVw);
        intent.putExtra("pay_channel", walletJsapiData.payChannel);
        mMActivity.mmSetOnActivityResultCallback(aVar);
        c.a((Context) mMActivity, "wallet", ".bind.ui.WalletBindUI", intent, i2, false);
        AppMethodBeat.o(117588);
        return true;
    }

    public static boolean aE(Context context, int i2) {
        AppMethodBeat.i(117589);
        Intent intent = new Intent();
        intent.putExtra("key_bind_scene", 5);
        intent.putExtra("key_offline_add_fee", i2);
        c.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
        AppMethodBeat.o(117589);
        return true;
    }

    public static boolean aF(Context context, int i2) {
        AppMethodBeat.i(117590);
        Intent intent = new Intent();
        intent.putExtra("key_scene_balance_manager", i2);
        if (z.aUo()) {
            c.b(context, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            c.b(context, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
        }
        AppMethodBeat.o(117590);
        return true;
    }

    public static boolean iF(Context context) {
        AppMethodBeat.i(117591);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
        Log.i("MicroMsg.WalletManager", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
        if (a2) {
            c.V(context, "mall", ".ui.MallIndexUIv2");
        } else {
            c.V(context, "mall", ".ui.MallIndexUI");
        }
        AppMethodBeat.o(117591);
        return true;
    }

    public static boolean a(Context context, int i2, String str, int i3, a aVar) {
        AppMethodBeat.i(117592);
        Intent intent = new Intent();
        intent.putExtra("scene", i2);
        intent.putExtra("receiver_name", str);
        if (i3 > 0) {
            intent.putExtra("pay_channel", i3);
        }
        a.a(aVar, intent);
        if (z.aUo()) {
            c.b(context, "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", intent);
        } else if (z.aUp()) {
            c.b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            h.INSTANCE.a(12097, 12, 0, Long.valueOf(System.currentTimeMillis()));
            h.INSTANCE.a(11850, 7, 1);
        } else {
            c.b(context, "remittance", ".ui.RemittanceAdapterUI", intent);
            h.INSTANCE.a(12097, 12, 0, Long.valueOf(System.currentTimeMillis()));
            h.INSTANCE.a(11850, 3, 1);
        }
        AppMethodBeat.o(117592);
        return true;
    }

    public static void a(Context context, String str, int i2, String str2, int i3) {
        AppMethodBeat.i(117593);
        Intent intent = new Intent();
        intent.putExtra("key_qrcode_url", str);
        intent.putExtra("key_channel", i2);
        intent.putExtra("key_web_url", str2);
        intent.putExtra("key_scene", i3);
        c.b(context, "collect", ".reward.ui.QrRewardSelectMoneyUI", intent);
        AppMethodBeat.o(117593);
    }

    private static boolean gsT() {
        AppMethodBeat.i(117594);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_kinda_open, false);
        AppMethodBeat.o(117594);
        return a2;
    }
}
