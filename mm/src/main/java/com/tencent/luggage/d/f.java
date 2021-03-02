package com.tencent.luggage.d;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.luggage.bridge.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import org.a.a;

public class f extends n {
    static final /* synthetic */ boolean $assertionsDisabled = (!f.class.desiredAssertionStatus());
    private o csD;
    private g cte;
    private final Context mContext;

    static {
        AppMethodBeat.i(221183);
        AppMethodBeat.o(221183);
    }

    public f(Context context, Class<? extends g> cls) {
        AppMethodBeat.i(221179);
        this.mContext = context;
        if ($assertionsDisabled || cls != null) {
            this.cte = (g) a.bF(cls).ak(context).object;
            evaluateJavascript("var self = this;", null);
            evaluateJavascript("let require = process.mainModule.require;", null);
            this.csD = new o(this.cte);
            evaluateJavascript(d.afA("LuggageBridge.js"), null);
            this.cte.Le();
            AppMethodBeat.o(221179);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(221179);
        throw assertionError;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(221180);
        this.cte.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(221180);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.luggage.d.n
    public final o getBridge() {
        return this.csD;
    }

    @Override // com.tencent.luggage.d.n
    public final String getUserAgent() {
        AppMethodBeat.i(221181);
        String userAgent = this.cte.getUserAgent();
        AppMethodBeat.o(221181);
        return userAgent;
    }

    @Override // com.tencent.luggage.d.n
    public final void destroy() {
        AppMethodBeat.i(221182);
        this.cte.destroy();
        AppMethodBeat.o(221182);
    }
}
