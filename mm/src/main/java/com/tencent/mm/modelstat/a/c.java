package com.tencent.mm.modelstat.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static Bundle PV(String str) {
        AppMethodBeat.i(151154);
        Log.v("MicroMsg.WebViewMMReportUtil", "create webview bundle name[%s]", str);
        Bundle bundle = new Bundle();
        bundle.putString("mm_event_class", str);
        AppMethodBeat.o(151154);
        return bundle;
    }
}
