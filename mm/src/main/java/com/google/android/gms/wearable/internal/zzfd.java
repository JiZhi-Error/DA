package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.MessageClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzfd extends UnregisterListenerMethod<zzhg, MessageClient.OnMessageReceivedListener> {
    private final MessageClient.OnMessageReceivedListener zzej;

    private zzfd(MessageClient.OnMessageReceivedListener onMessageReceivedListener, ListenerHolder.ListenerKey<MessageClient.OnMessageReceivedListener> listenerKey) {
        super(listenerKey);
        this.zzej = onMessageReceivedListener;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final /* synthetic */ void unregisterListener(zzhg zzhg, TaskCompletionSource taskCompletionSource) {
        AppMethodBeat.i(101292);
        zzhg.zza(new zzgg(taskCompletionSource), this.zzej);
        AppMethodBeat.o(101292);
    }
}
