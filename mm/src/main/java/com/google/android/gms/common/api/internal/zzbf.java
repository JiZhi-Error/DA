package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzbf extends Handler {
    private final /* synthetic */ zzbd zzjh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbf(zzbd zzbd, Looper looper) {
        super(looper);
        this.zzjh = zzbd;
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.i(11326);
        switch (message.what) {
            case 1:
                ((zzbe) message.obj).zzc(this.zzjh);
                AppMethodBeat.o(11326);
                return;
            case 2:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                AppMethodBeat.o(11326);
                throw runtimeException;
            default:
                new StringBuilder(31).append("Unknown message id: ").append(message.what);
                AppMethodBeat.o(11326);
                return;
        }
    }
}
