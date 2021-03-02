package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AntiReentrantAuthListenerImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;)V", "mCalled", "", "onAuthResult", "", "luggage-wechat-full-sdk_release"})
public final class a implements e {
    private final e lFd;
    private boolean mCalled;

    public a(e eVar) {
        this.lFd = eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.e
    public final void bEE() {
        AppMethodBeat.i(169556);
        if (this.mCalled) {
            AppMethodBeat.o(169556);
            return;
        }
        e eVar = this.lFd;
        if (eVar != null) {
            eVar.bEE();
        }
        this.mCalled = true;
        AppMethodBeat.o(169556);
    }
}
