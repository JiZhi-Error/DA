package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.e.m;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzez extends MessageClient {
    @VisibleForTesting
    private final MessageApi zzei = new zzeu();

    public zzez(Activity activity, GoogleApi.Settings settings) {
        super(activity, settings);
        AppMethodBeat.i(101281);
        AppMethodBeat.o(101281);
    }

    public zzez(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        AppMethodBeat.i(101280);
        AppMethodBeat.o(101280);
    }

    private final Task<Void> zza(MessageClient.OnMessageReceivedListener onMessageReceivedListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101285);
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(onMessageReceivedListener, getLooper(), "MessageListener");
        Task<Void> doRegisterEventListener = doRegisterEventListener(new zzfc(onMessageReceivedListener, intentFilterArr, createListenerHolder), new zzfd(onMessageReceivedListener, createListenerHolder.getListenerKey()));
        AppMethodBeat.o(101285);
        return doRegisterEventListener;
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Void> addListener(MessageClient.OnMessageReceivedListener onMessageReceivedListener) {
        AppMethodBeat.i(101283);
        Task<Void> zza = zza(onMessageReceivedListener, new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.MESSAGE_RECEIVED")});
        AppMethodBeat.o(101283);
        return zza;
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Void> addListener(MessageClient.OnMessageReceivedListener onMessageReceivedListener, Uri uri, int i2) {
        AppMethodBeat.i(101284);
        m.checkNotNull(uri, "uri must not be null");
        Preconditions.checkArgument(i2 == 0 || i2 == 1, "invalid filter type");
        Task<Void> zza = zza(onMessageReceivedListener, new IntentFilter[]{zzgj.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED", uri, i2)});
        AppMethodBeat.o(101284);
        return zza;
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Boolean> removeListener(MessageClient.OnMessageReceivedListener onMessageReceivedListener) {
        AppMethodBeat.i(101286);
        Task<Boolean> doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(onMessageReceivedListener, getLooper(), "MessageListener").getListenerKey());
        AppMethodBeat.o(101286);
        return doUnregisterEventListener;
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Integer> sendMessage(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(101282);
        Task<Integer> task = PendingResultUtil.toTask(this.zzei.sendMessage(asGoogleApiClient(), str, str2, bArr), zzfa.zzbx);
        AppMethodBeat.o(101282);
        return task;
    }
}
