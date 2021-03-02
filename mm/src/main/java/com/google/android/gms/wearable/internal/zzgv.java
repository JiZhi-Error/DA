package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgv extends zzgm<DataApi.DataItemResult> {
    public zzgv(BaseImplementation.ResultHolder<DataApi.DataItemResult> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzec zzec) {
        AppMethodBeat.i(101368);
        zza(new zzcg(zzgd.zzb(zzec.statusCode), zzec.zzdy));
        AppMethodBeat.o(101368);
    }
}
