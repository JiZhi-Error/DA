package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXAPIFactory {
    private static final String TAG = "MicroMsg.PaySdk.WXFactory";

    private WXAPIFactory() {
        AppMethodBeat.i(3767);
        RuntimeException runtimeException = new RuntimeException(WXAPIFactory.class.getSimpleName() + " should not be instantiated");
        AppMethodBeat.o(3767);
        throw runtimeException;
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        AppMethodBeat.i(3765);
        IWXAPI createWXAPI = createWXAPI(context, str, true);
        AppMethodBeat.o(3765);
        return createWXAPI;
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        AppMethodBeat.i(3766);
        Log.d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z);
        WXApiImplV10 wXApiImplV10 = new WXApiImplV10(context, str, z);
        AppMethodBeat.o(3766);
        return wXApiImplV10;
    }
}
