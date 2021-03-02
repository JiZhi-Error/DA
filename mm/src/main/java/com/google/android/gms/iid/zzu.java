package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzu implements Handler.Callback {
    private final zzt zzch;

    zzu(zzt zzt) {
        this.zzch = zzt;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(2567);
        boolean zzd = this.zzch.zzd(message);
        AppMethodBeat.o(2567);
        return zzd;
    }
}
