package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.DataApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.FutureTask;

/* access modifiers changed from: package-private */
public final class zzhb extends zzgm<DataApi.DataItemResult> {
    private final List<FutureTask<Boolean>> zzev;

    zzhb(BaseImplementation.ResultHolder<DataApi.DataItemResult> resultHolder, List<FutureTask<Boolean>> list) {
        super(resultHolder);
        this.zzev = list;
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzfu zzfu) {
        AppMethodBeat.i(101373);
        zza(new zzcg(zzgd.zzb(zzfu.statusCode), zzfu.zzdy));
        if (zzfu.statusCode != 0) {
            for (FutureTask<Boolean> futureTask : this.zzev) {
                futureTask.cancel(true);
            }
        }
        AppMethodBeat.o(101373);
    }
}
