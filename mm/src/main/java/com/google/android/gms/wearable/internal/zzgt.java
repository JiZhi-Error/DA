package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgt extends zzgm<Channel.GetOutputStreamResult> {
    private final zzbr zzeu;

    public zzgt(BaseImplementation.ResultHolder<Channel.GetOutputStreamResult> resultHolder, zzbr zzbr) {
        super(resultHolder);
        AppMethodBeat.i(101365);
        this.zzeu = (zzbr) Preconditions.checkNotNull(zzbr);
        AppMethodBeat.o(101365);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzdo zzdo) {
        AppMethodBeat.i(101366);
        zzbl zzbl = null;
        if (zzdo.zzdr != null) {
            zzbl = new zzbl(new ParcelFileDescriptor.AutoCloseOutputStream(zzdo.zzdr));
            this.zzeu.zza(new zzbm(zzbl));
        }
        zza(new zzbh(new Status(zzdo.statusCode), zzbl));
        AppMethodBeat.o(101366);
    }
}
