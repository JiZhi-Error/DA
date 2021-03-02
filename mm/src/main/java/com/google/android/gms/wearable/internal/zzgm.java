package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class zzgm<T> extends zza {
    private BaseImplementation.ResultHolder<T> zzet;

    public zzgm(BaseImplementation.ResultHolder<T> resultHolder) {
        this.zzet = resultHolder;
    }

    public final void zza(T t) {
        AppMethodBeat.i(101357);
        BaseImplementation.ResultHolder<T> resultHolder = this.zzet;
        if (resultHolder != null) {
            resultHolder.setResult(t);
            this.zzet = null;
        }
        AppMethodBeat.o(101357);
    }
}
