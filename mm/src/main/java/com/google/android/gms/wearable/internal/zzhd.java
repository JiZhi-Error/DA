package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.CapabilityApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhd extends zzgm<CapabilityApi.RemoveLocalCapabilityResult> {
    public zzhd(BaseImplementation.ResultHolder<CapabilityApi.RemoveLocalCapabilityResult> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzfy zzfy) {
        AppMethodBeat.i(101375);
        zza(new zzu(zzgd.zzb(zzfy.statusCode)));
        AppMethodBeat.o(101375);
    }
}
