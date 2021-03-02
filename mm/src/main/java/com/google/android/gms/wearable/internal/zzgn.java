package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgn extends zzgm<Status> {
    public zzgn(BaseImplementation.ResultHolder<Status> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzbt zzbt) {
        AppMethodBeat.i(101358);
        zza((Object) new Status(zzbt.statusCode));
        AppMethodBeat.o(101358);
    }
}
