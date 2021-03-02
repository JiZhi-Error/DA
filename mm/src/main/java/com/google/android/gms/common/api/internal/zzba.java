package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzba extends Handler {
    private final /* synthetic */ zzav zzit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzba(zzav zzav, Looper looper) {
        super(looper);
        this.zzit = zzav;
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.i(11305);
        switch (message.what) {
            case 1:
                zzav.zzb(this.zzit);
                AppMethodBeat.o(11305);
                return;
            case 2:
                zzav.zza(this.zzit);
                AppMethodBeat.o(11305);
                return;
            default:
                new StringBuilder(31).append("Unknown message id: ").append(message.what);
                AppMethodBeat.o(11305);
                return;
        }
    }
}
