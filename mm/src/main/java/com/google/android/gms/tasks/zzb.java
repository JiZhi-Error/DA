package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb implements OnSuccessListener<Void> {
    private final /* synthetic */ OnTokenCanceledListener zzafi;

    zzb(zza zza, OnTokenCanceledListener onTokenCanceledListener) {
        this.zzafi = onTokenCanceledListener;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(Void r3) {
        AppMethodBeat.i(13379);
        this.zzafi.onCanceled();
        AppMethodBeat.o(13379);
    }
}
