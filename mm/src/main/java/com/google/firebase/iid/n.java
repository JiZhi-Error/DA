package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class n extends Handler {
    private final /* synthetic */ m bLK;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n(m mVar, Looper looper) {
        super(looper);
        this.bLK = mVar;
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.i(4179);
        m.a(this.bLK, message);
        AppMethodBeat.o(4179);
    }
}
