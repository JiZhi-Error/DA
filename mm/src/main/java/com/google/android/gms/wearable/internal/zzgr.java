package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.CapabilityApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgr extends zzgm<CapabilityApi.GetCapabilityResult> {
    public zzgr(BaseImplementation.ResultHolder<CapabilityApi.GetCapabilityResult> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzdk zzdk) {
        AppMethodBeat.i(101362);
        zza(new zzy(zzgd.zzb(zzdk.statusCode), zzdk.zzdq == null ? null : new zzw(zzdk.zzdq)));
        AppMethodBeat.o(101362);
    }
}
