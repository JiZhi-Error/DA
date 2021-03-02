package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzgx extends zzgm<DataApi.GetFdForAssetResult> {
    public zzgx(BaseImplementation.ResultHolder<DataApi.GetFdForAssetResult> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzee zzee) {
        AppMethodBeat.i(101370);
        zza(new zzci(zzgd.zzb(zzee.statusCode), zzee.zzdz));
        AppMethodBeat.o(101370);
    }
}
