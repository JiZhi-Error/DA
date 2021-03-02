package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzfc extends RegisterListenerMethod<zzhg, MessageClient.OnMessageReceivedListener> {
    private final IntentFilter[] zzba;
    private final ListenerHolder<MessageApi.MessageListener> zzbz;
    private final MessageClient.OnMessageReceivedListener zzej;

    private zzfc(MessageClient.OnMessageReceivedListener onMessageReceivedListener, IntentFilter[] intentFilterArr, ListenerHolder<MessageClient.OnMessageReceivedListener> listenerHolder) {
        super(listenerHolder);
        this.zzej = onMessageReceivedListener;
        this.zzba = intentFilterArr;
        this.zzbz = listenerHolder;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final /* synthetic */ void registerListener(zzhg zzhg, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(101291);
        zzhg.zza(new zzgh(taskCompletionSource), this.zzej, this.zzbz, this.zzba);
        AppMethodBeat.o(101291);
    }
}
