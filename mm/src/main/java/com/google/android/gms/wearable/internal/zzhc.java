package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhc extends zzgm<Status> {
    public zzhc(BaseImplementation.ResultHolder<Status> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzbp zzbp) {
        AppMethodBeat.i(101374);
        zza((Object) new Status(zzbp.statusCode));
        AppMethodBeat.o(101374);
    }
}
