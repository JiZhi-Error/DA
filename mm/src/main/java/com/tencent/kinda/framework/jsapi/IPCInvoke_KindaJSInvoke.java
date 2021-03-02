package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.event.EventCenter;

public class IPCInvoke_KindaJSInvoke implements b<Bundle, Bundle> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* bridge */ /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        AppMethodBeat.i(190309);
        invoke(bundle, dVar);
        AppMethodBeat.o(190309);
    }

    public void invoke(Bundle bundle, final d<Bundle> dVar) {
        AppMethodBeat.i(190308);
        final ll llVar = new ll();
        llVar.dQJ.dQM = bundle.getString("jsapiName", "");
        llVar.dQJ.type = bundle.getInt("jsapi_type", 0);
        llVar.dQJ.dQL = bundle;
        llVar.dQJ.dQN = new Runnable() {
            /* class com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(190307);
                dVar.bn(llVar.dQK.result);
                AppMethodBeat.o(190307);
            }
        };
        EventCenter.instance.publish(llVar);
        AppMethodBeat.o(190308);
    }
}
