package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.MessageApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzeu implements MessageApi {
    private static PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101273);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzex(googleApiClient, messageListener, googleApiClient.registerListener(messageListener), intentFilterArr, null));
        AppMethodBeat.o(101273);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener) {
        AppMethodBeat.i(101271);
        PendingResult<Status> zza = zza(googleApiClient, messageListener, new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.MESSAGE_RECEIVED")});
        AppMethodBeat.o(101271);
        return zza;
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, Uri uri, int i2) {
        AppMethodBeat.i(101272);
        Preconditions.checkNotNull(uri, "uri must not be null");
        Preconditions.checkArgument(i2 == 0 || i2 == 1, "invalid filter type");
        PendingResult<Status> zza = zza(googleApiClient, messageListener, new IntentFilter[]{zzgj.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED", uri, i2)});
        AppMethodBeat.o(101272);
        return zza;
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener) {
        AppMethodBeat.i(101274);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzew(this, googleApiClient, messageListener));
        AppMethodBeat.o(101274);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        AppMethodBeat.i(101270);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzev(this, googleApiClient, str, str2, bArr));
        AppMethodBeat.o(101270);
        return enqueue;
    }
}
