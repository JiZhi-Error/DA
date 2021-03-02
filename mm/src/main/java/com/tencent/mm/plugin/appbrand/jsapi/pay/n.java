package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import org.json.JSONObject;

public class n extends d<k> {
    public static final int CTRL_INDEX = 57;
    public static final String NAME = "requestPayment";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public /* bridge */ /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46733);
        a(kVar, jSONObject, i2);
        AppMethodBeat.o(46733);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final com.tencent.mm.plugin.appbrand.jsapi.k r14, org.json.JSONObject r15, final int r16) {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.pay.n.a(com.tencent.mm.plugin.appbrand.jsapi.k, org.json.JSONObject, int):void");
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.ipcinvoker.k<IPCString, IPCString> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCString iPCString) {
            AppMethodBeat.i(226964);
            IPCString iPCString2 = new IPCString(y.Xy(iPCString.value));
            AppMethodBeat.o(226964);
            return iPCString2;
        }
    }
}
