package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzc implements DeferredLifecycleHelper.zza {
    private final /* synthetic */ DeferredLifecycleHelper zzabg;
    private final /* synthetic */ Bundle zzabi;

    zzc(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.zzabg = deferredLifecycleHelper;
        this.zzabi = bundle;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.zza
    public final int getState() {
        return 1;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper.zza
    public final void zza(LifecycleDelegate lifecycleDelegate) {
        AppMethodBeat.i(12129);
        DeferredLifecycleHelper.zzb(this.zzabg).onCreate(this.zzabi);
        AppMethodBeat.o(12129);
    }
}
