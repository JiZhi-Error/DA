package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public final class zzbb extends GooglePlayServicesUpdatedReceiver.Callback {
    private WeakReference<zzav> zziy;

    zzbb(zzav zzav) {
        AppMethodBeat.i(11306);
        this.zziy = new WeakReference<>(zzav);
        AppMethodBeat.o(11306);
    }

    @Override // com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver.Callback
    public final void zzv() {
        AppMethodBeat.i(11307);
        zzav zzav = this.zziy.get();
        if (zzav == null) {
            AppMethodBeat.o(11307);
            return;
        }
        zzav.zza(zzav);
        AppMethodBeat.o(11307);
    }
}
