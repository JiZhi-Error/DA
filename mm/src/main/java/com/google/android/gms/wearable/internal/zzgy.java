package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.NodeApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgy extends zzgm<NodeApi.GetLocalNodeResult> {
    public zzgy(BaseImplementation.ResultHolder<NodeApi.GetLocalNodeResult> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzeg zzeg) {
        AppMethodBeat.i(101371);
        zza(new zzfk(zzgd.zzb(zzeg.statusCode), zzeg.zzea));
        AppMethodBeat.o(101371);
    }
}
