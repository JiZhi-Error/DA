package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.CapabilityApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgq extends zzgm<CapabilityApi.GetAllCapabilitiesResult> {
    public zzgq(BaseImplementation.ResultHolder<CapabilityApi.GetAllCapabilitiesResult> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzdi zzdi) {
        AppMethodBeat.i(101361);
        zza(new zzx(zzgd.zzb(zzdi.statusCode), zzgk.zzb(zzdi.zzdp)));
        AppMethodBeat.o(101361);
    }
}
