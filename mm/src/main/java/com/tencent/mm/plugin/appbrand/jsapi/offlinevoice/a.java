package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.sdk.platformtools.Log;

public class a implements b<Bundle, Bundle> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        AppMethodBeat.i(46651);
        StringBuilder sb = new StringBuilder("0,");
        d.bIh();
        String sb2 = sb.append(d.bIf()).toString();
        d.bIh();
        String bIg = d.bIg();
        Log.i("MicroMsg.OfflineVoice.IPCLoadPaySpeechDialectConfig", "idsStr:%s  resId:%s", sb2, bIg);
        Bundle bundle2 = new Bundle();
        bundle2.putString("idsStr", sb2);
        bundle2.putString("resId", bIg);
        if (dVar != null) {
            dVar.bn(bundle2);
        }
        AppMethodBeat.o(46651);
    }
}
