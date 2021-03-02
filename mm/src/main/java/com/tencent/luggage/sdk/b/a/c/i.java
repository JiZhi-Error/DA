package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.s;

public class i<SERVICE extends d> extends b<SERVICE> {
    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final /* synthetic */ int a(s sVar) {
        AppMethodBeat.i(146852);
        int bvd = ((d) sVar).bqZ().bvd();
        AppMethodBeat.o(146852);
        return bvd;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.luggage.sdk.b.a.c.i<SERVICE extends com.tencent.luggage.sdk.b.a.c.d> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.b
    public /* synthetic */ String b(s sVar) {
        AppMethodBeat.i(146853);
        String c2 = c((d) sVar);
        AppMethodBeat.o(146853);
        return c2;
    }

    protected i(SERVICE service, t tVar) {
        super(service, tVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.b
    public final String MK() {
        return "WASubContext.js";
    }

    /* access modifiers changed from: protected */
    public String c(SERVICE service) {
        boolean z;
        AppMethodBeat.i(146851);
        if (service.getRuntime() == null) {
            z = false;
        } else {
            z = service.getRuntime().OU().ldK;
        }
        String afA = z ? com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/native/WASubContext.js") : service.bqZ().UM("WASubContext.js");
        if (TextUtils.isEmpty(afA)) {
            aq aqVar = new aq("WASubContext.js");
            AppMethodBeat.o(146851);
            throw aqVar;
        }
        AppMethodBeat.o(146851);
        return afA;
    }
}
