package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhf extends zzgm<Status> {
    public zzhf(BaseImplementation.ResultHolder<Status> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzbn zzbn) {
        AppMethodBeat.i(101377);
        zza((Object) new Status(zzbn.statusCode));
        AppMethodBeat.o(101377);
    }
}
