package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.aa;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends ab<ac> {
    private static final int CTRL_INDEX = 583;
    private static final String NAME = "getSelectedTextRange";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(ac acVar, JSONObject jSONObject) {
        AppMethodBeat.i(136255);
        final ac acVar2 = acVar;
        int[] iArr = (int[]) new SyncTask<int[]>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h.b.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ int[] run() {
                AppMethodBeat.i(136254);
                aa F = o.F(acVar2);
                if (F == null) {
                    AppMethodBeat.o(136254);
                    return null;
                }
                int[] iArr = {F.caV().getSelectionStart(), F.caV().getSelectionEnd()};
                AppMethodBeat.o(136254);
                return iArr;
            }
        }.exec(new MMHandler(Looper.getMainLooper()));
        if (iArr == null) {
            String h2 = h("fail:no focused input", null);
            AppMethodBeat.o(136255);
            return h2;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("start", Integer.valueOf(iArr[0]));
        hashMap.put("end", Integer.valueOf(iArr[1]));
        String n = n("ok", hashMap);
        AppMethodBeat.o(136255);
        return n;
    }
}
