package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.k;

/* access modifiers changed from: package-private */
public final class a implements b<Bundle, Bundle> {
    a() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        AppMethodBeat.i(46762);
        Bundle bundle2 = bundle;
        try {
            ((k) g.af(k.class)).g(bundle2.getInt(NativeProtocol.WEB_DIALOG_ACTION), bundle2);
            AppMethodBeat.o(46762);
        } catch (Exception e2) {
            AppMethodBeat.o(46762);
        }
    }
}
