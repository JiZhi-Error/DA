package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ag {
    private static String HuS = "";

    public static void aUH(String str) {
        AppMethodBeat.i(68547);
        Log.i("MicroMsg.LqtTraceInfoStore", "trace info: %s", str);
        HuS = str;
        AppMethodBeat.o(68547);
    }

    public static String fNb() {
        return HuS;
    }

    public static void parseUrl(String str) {
        AppMethodBeat.i(68548);
        String queryParameter = Uri.parse(str).getQueryParameter("trace_info");
        if (!Util.isNullOrNil(queryParameter)) {
            aUH(queryParameter);
        }
        AppMethodBeat.o(68548);
    }

    public static String aUI(String str) {
        AppMethodBeat.i(68549);
        String queryParameter = Uri.parse(str).getQueryParameter("operate_id");
        AppMethodBeat.o(68549);
        return queryParameter;
    }
}
