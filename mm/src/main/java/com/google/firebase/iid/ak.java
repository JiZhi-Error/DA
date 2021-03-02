package com.google.firebase.iid;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class ak implements Handler.Callback {
    private final aj bMN;

    ak(aj ajVar) {
        this.bMN = ajVar;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(4266);
        boolean f2 = this.bMN.f(message);
        AppMethodBeat.o(4266);
        return f2;
    }
}
