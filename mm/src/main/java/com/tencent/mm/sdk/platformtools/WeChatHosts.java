package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WeChatHosts {
    public static final String TAG = "MicroMsg.WeChatHosts";

    public static String domainString(int i2) {
        AppMethodBeat.i(200973);
        String string = MMApplicationContext.getContext().getString(i2);
        AppMethodBeat.o(200973);
        return string;
    }
}
