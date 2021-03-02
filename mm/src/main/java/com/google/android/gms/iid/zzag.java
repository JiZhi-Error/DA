package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzag extends Handler {
    private final /* synthetic */ zzaf zzcx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzag(zzaf zzaf, Looper looper) {
        super(looper);
        this.zzcx = zzaf;
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.i(2501);
        this.zzcx.zze(message);
        AppMethodBeat.o(2501);
    }
}
