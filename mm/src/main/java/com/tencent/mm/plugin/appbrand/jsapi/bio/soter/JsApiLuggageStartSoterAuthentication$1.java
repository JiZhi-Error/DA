package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;

class JsApiLuggageStartSoterAuthentication$1 extends ResultReceiver {
    final /* synthetic */ int cvP;
    final /* synthetic */ f czN;
    final /* synthetic */ b lKA;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JsApiLuggageStartSoterAuthentication$1(b bVar, Handler handler, f fVar, int i2) {
        super(handler);
        this.lKA = bVar;
        this.czN = fVar;
        this.cvP = i2;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        AppMethodBeat.i(159050);
        if (i2 == -1) {
            Log.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth ok");
            b bVar = this.lKA;
            f fVar = this.czN;
            int i3 = this.cvP;
            if (bundle == null) {
                bundle = null;
            }
            b.a(bVar, fVar, i3, bundle, "ok");
            AppMethodBeat.o(159050);
        } else if (i2 == 1) {
            Log.w("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter auth failed");
            b bVar2 = this.lKA;
            f fVar2 = this.czN;
            int i4 = this.cvP;
            if (bundle == null) {
                bundle = null;
            }
            b.a(bVar2, fVar2, i4, bundle, "fail");
            AppMethodBeat.o(159050);
        } else {
            Log.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter user cancelled");
            b bVar3 = this.lKA;
            f fVar3 = this.czN;
            int i5 = this.cvP;
            if (bundle == null) {
                bundle = null;
            }
            b.a(bVar3, fVar3, i5, bundle, "cancel");
            AppMethodBeat.o(159050);
        }
    }
}
