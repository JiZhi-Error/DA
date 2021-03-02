package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgs extends zzgm<Channel.GetInputStreamResult> {
    private final zzbr zzeu;

    public zzgs(BaseImplementation.ResultHolder<Channel.GetInputStreamResult> resultHolder, zzbr zzbr) {
        super(resultHolder);
        AppMethodBeat.i(101363);
        this.zzeu = (zzbr) Preconditions.checkNotNull(zzbr);
        AppMethodBeat.o(101363);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzdm zzdm) {
        AppMethodBeat.i(101364);
        zzbj zzbj = null;
        if (zzdm.zzdr != null) {
            zzbj = new zzbj(new ParcelFileDescriptor.AutoCloseInputStream(zzdm.zzdr));
            this.zzeu.zza(new zzbk(zzbj));
        }
        zza(new zzbg(new Status(zzdm.statusCode), zzbj));
        AppMethodBeat.o(101364);
    }
}
