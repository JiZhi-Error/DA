package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzev extends zzn<MessageApi.SendMessageResult> {
    private final /* synthetic */ String val$action;
    private final /* synthetic */ String zzcb;
    private final /* synthetic */ byte[] zzee;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzev(zzeu zzeu, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        super(googleApiClient);
        this.zzcb = str;
        this.val$action = str2;
        this.zzee = bArr;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.i(101276);
        zzey zzey = new zzey(status, -1);
        AppMethodBeat.o(101276);
        return zzey;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101275);
        ((zzep) zzhg.getService()).zza(new zzhe(this), this.zzcb, this.val$action, this.zzee);
        AppMethodBeat.o(101275);
    }
}
