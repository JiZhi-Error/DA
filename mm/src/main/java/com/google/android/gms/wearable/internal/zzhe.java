package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.MessageApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhe extends zzgm<MessageApi.SendMessageResult> {
    public zzhe(BaseImplementation.ResultHolder<MessageApi.SendMessageResult> resultHolder) {
        super(resultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzga zzga) {
        AppMethodBeat.i(101376);
        zza(new zzey(zzgd.zzb(zzga.statusCode), zzga.zzeh));
        AppMethodBeat.o(101376);
    }
}
