package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgp extends zzgm<DataApi.DeleteDataItemsResult> {
    public zzgp(BaseImplementation.ResultHolder<DataApi.DeleteDataItemsResult> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzdg zzdg) {
        AppMethodBeat.i(101360);
        zza(new zzch(zzgd.zzb(zzdg.statusCode), zzdg.zzdh));
        AppMethodBeat.o(101360);
    }
}
