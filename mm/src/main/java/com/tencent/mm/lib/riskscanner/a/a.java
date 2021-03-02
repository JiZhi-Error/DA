package com.tencent.mm.lib.riskscanner.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider;

public final class a {
    public static Bundle cM(Context context) {
        Bundle bundle = null;
        AppMethodBeat.i(138304);
        try {
            bundle = context.getContentResolver().call(RiskScannerReqBufferProvider.CONTENT_URI, "prepareReqBuffer", (String) null, (Bundle) null);
            AppMethodBeat.o(138304);
        } catch (Throwable th) {
            AppMethodBeat.o(138304);
        }
        return bundle;
    }
}
