package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e {
    public static boolean a(Context context, String str, PayResp payResp, PayReq.Options options) {
        AppMethodBeat.i(117561);
        Log.d("MicroMsg.PayCallbackHelper", "callback, packageName = ".concat(String.valueOf(str)));
        String str2 = (options == null || Util.isNullOrNil(options.callbackClassName)) ? str + ".wxapi.WXPayEntryActivity" : options.callbackClassName;
        int i2 = (options == null || options.callbackFlags == -1) ? 268435456 : options.callbackFlags;
        Log.d("MicroMsg.PayCallbackHelper", "callback, cbPkg = " + str + ", cbCls = " + str2 + ", cbFlags(hex) = " + Integer.toHexString(i2));
        Bundle bundle = new Bundle();
        bundle.putString(ConstantsAPI.Token.WX_TOKEN_KEY, ConstantsAPI.Token.WX_TOKEN_VALUE_MSG);
        if (payResp != null) {
            payResp.toBundle(bundle);
        }
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.targetPkgName = str;
        args.targetClassName = str2;
        args.bundle = bundle;
        args.flags = i2;
        boolean send = MMessageActV2.send(context, args);
        AppMethodBeat.o(117561);
        return send;
    }
}
