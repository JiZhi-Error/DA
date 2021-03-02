package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.NodeApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class zzgu extends zzgm<NodeApi.GetConnectedNodesResult> {
    public zzgu(BaseImplementation.ResultHolder<NodeApi.GetConnectedNodesResult> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzea zzea) {
        AppMethodBeat.i(101367);
        ArrayList arrayList = new ArrayList();
        if (zzea.zzdx != null) {
            arrayList.addAll(zzea.zzdx);
        }
        zza(new zzfj(zzgd.zzb(zzea.statusCode), arrayList));
        AppMethodBeat.o(101367);
    }
}
