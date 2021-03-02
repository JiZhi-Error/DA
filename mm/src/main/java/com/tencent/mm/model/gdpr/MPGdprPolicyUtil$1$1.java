package com.tencent.mm.model.gdpr;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.c;

class MPGdprPolicyUtil$1$1 extends ResultReceiver {
    final /* synthetic */ c.AnonymousClass1 iGU;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MPGdprPolicyUtil$1$1(c.AnonymousClass1 r1, Handler handler) {
        super(handler);
        this.iGU = r1;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        AppMethodBeat.i(40082);
        r6.sx(i2 > 0 ? 0 : 1);
        AppMethodBeat.o(40082);
    }
}
