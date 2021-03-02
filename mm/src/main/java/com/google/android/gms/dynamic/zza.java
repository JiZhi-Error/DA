package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class zza implements OnDelegateCreatedListener<T> {
    private final /* synthetic */ DeferredLifecycleHelper zzabg;

    zza(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zzabg = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void onDelegateCreated(T t) {
        AppMethodBeat.i(12127);
        DeferredLifecycleHelper.zza(this.zzabg, (LifecycleDelegate) t);
        Iterator it = DeferredLifecycleHelper.zza(this.zzabg).iterator();
        while (it.hasNext()) {
            ((DeferredLifecycleHelper.zza) it.next()).zza(DeferredLifecycleHelper.zzb(this.zzabg));
        }
        DeferredLifecycleHelper.zza(this.zzabg).clear();
        DeferredLifecycleHelper.zza(this.zzabg, (Bundle) null);
        AppMethodBeat.o(12127);
    }
}
