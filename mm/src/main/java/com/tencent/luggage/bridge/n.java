package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class n {
    private o csD;
    private MMHandler csE = new MMHandler("Js2JavaAsyncHandler_" + this.csD.hashCode());

    n(o oVar) {
        AppMethodBeat.i(140332);
        this.csD = oVar;
        AppMethodBeat.o(140332);
    }

    /* access modifiers changed from: package-private */
    public final String i(final String str, boolean z) {
        AppMethodBeat.i(140333);
        if (z) {
            String j2 = j(str, true);
            AppMethodBeat.o(140333);
            return j2;
        }
        this.csE.post(new Runnable() {
            /* class com.tencent.luggage.bridge.n.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(140330);
                n.this.j(str, false);
                AppMethodBeat.o(140330);
            }
        });
        AppMethodBeat.o(140333);
        return "";
    }

    /* access modifiers changed from: package-private */
    public final String j(String str, boolean z) {
        AppMethodBeat.i(140334);
        m cM = cM(str);
        if (cM == null) {
            AppMethodBeat.o(140334);
            return "";
        }
        Log.i("Js2JavaMessageQueue", "processImpl, jsMsg.type = %s", cM.KW().name());
        e eVar = null;
        switch (cM.KW()) {
            case READY:
                this.csD.csJ.KY();
                break;
            case INVOKE:
                eVar = this.csD.a(cM, z);
                break;
            case EVENT:
                this.csD.a(cM);
                break;
            case CALLBACK:
                this.csD.b(cM);
                break;
        }
        Object[] objArr = new Object[1];
        objArr[0] = eVar == null ? BuildConfig.COMMAND : eVar.KW().name();
        Log.v("Js2JavaMessageQueue", "processImpl, javaMsg.type = %s", objArr);
        if (eVar == null) {
            AppMethodBeat.o(140334);
            return "";
        }
        String eVar2 = eVar.toString();
        AppMethodBeat.o(140334);
        return eVar2;
    }

    private static m cM(String str) {
        AppMethodBeat.i(140335);
        try {
            m mVar = new m(new JSONObject(str));
            AppMethodBeat.o(140335);
            return mVar;
        } catch (Exception e2) {
            Log.e("Js2JavaMessageQueue", "Message parse failed, ex = %s", e2.getMessage());
            AppMethodBeat.o(140335);
            return null;
        }
    }
}
