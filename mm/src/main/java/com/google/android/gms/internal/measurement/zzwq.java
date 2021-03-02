package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzwq extends ContentObserver {
    private final /* synthetic */ zzwp zzbnb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzwq(zzwp zzwp, Handler handler) {
        super(null);
        this.zzbnb = zzwp;
    }

    public final void onChange(boolean z) {
        AppMethodBeat.i(2283);
        this.zzbnb.zzru();
        zzwp.zza(this.zzbnb);
        AppMethodBeat.o(2283);
    }
}
