package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.MessageApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzex extends zzn<Status> {
    private ListenerHolder<MessageApi.MessageListener> zzax;
    private IntentFilter[] zzba;
    private MessageApi.MessageListener zzeg;

    private zzex(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, ListenerHolder<MessageApi.MessageListener> listenerHolder, IntentFilter[] intentFilterArr) {
        super(googleApiClient);
        AppMethodBeat.i(101278);
        this.zzeg = (MessageApi.MessageListener) Preconditions.checkNotNull(messageListener);
        this.zzax = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        this.zzba = (IntentFilter[]) Preconditions.checkNotNull(intentFilterArr);
        AppMethodBeat.o(101278);
    }

    /* synthetic */ zzex(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr, zzev zzev) {
        this(googleApiClient, messageListener, listenerHolder, intentFilterArr);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        this.zzeg = null;
        this.zzax = null;
        this.zzba = null;
        return status;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzhg zzhg) {
        AppMethodBeat.i(101279);
        zzhg.zza(this, this.zzeg, this.zzax, this.zzba);
        this.zzeg = null;
        this.zzax = null;
        this.zzba = null;
        AppMethodBeat.o(101279);
    }
}
