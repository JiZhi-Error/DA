package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.CapabilityApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgl extends zzgm<CapabilityApi.AddLocalCapabilityResult> {
    public zzgl(BaseImplementation.ResultHolder<CapabilityApi.AddLocalCapabilityResult> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzf zzf) {
        AppMethodBeat.i(101356);
        zza(new zzu(zzgd.zzb(zzf.statusCode)));
        AppMethodBeat.o(101356);
    }
}
