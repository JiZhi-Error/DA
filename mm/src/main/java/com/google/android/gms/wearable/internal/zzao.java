package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzao extends ChannelClient {
    private final zzaj zzcg = new zzaj();

    public zzao(Activity activity, GoogleApi.Settings settings) {
        super(activity, settings);
        AppMethodBeat.i(100990);
        AppMethodBeat.o(100990);
    }

    public zzao(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        AppMethodBeat.i(100989);
        AppMethodBeat.o(100989);
    }

    static final /* synthetic */ ChannelClient.Channel zza(ChannelApi.OpenChannelResult openChannelResult) {
        AppMethodBeat.i(101005);
        zzay zza = zza(openChannelResult.getChannel());
        AppMethodBeat.o(101005);
        return zza;
    }

    private static zzay zza(Channel channel) {
        AppMethodBeat.i(100995);
        Preconditions.checkNotNull(channel, "channel must not be null");
        zzay zzay = (zzay) channel;
        AppMethodBeat.o(100995);
        return zzay;
    }

    private static zzay zza(ChannelClient.Channel channel) {
        AppMethodBeat.i(100994);
        Preconditions.checkNotNull(channel, "channel must not be null");
        zzay zzay = (zzay) channel;
        AppMethodBeat.o(100994);
        return zzay;
    }

    static /* synthetic */ zzay zzb(Channel channel) {
        AppMethodBeat.i(101006);
        zzay zza = zza(channel);
        AppMethodBeat.o(101006);
        return zza;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> close(ChannelClient.Channel channel) {
        AppMethodBeat.i(100996);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(zza(channel).close(asGoogleApiClient()));
        AppMethodBeat.o(100996);
        return voidTask;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> close(ChannelClient.Channel channel, int i2) {
        AppMethodBeat.i(100997);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(zza(channel).close(asGoogleApiClient(), i2));
        AppMethodBeat.o(100997);
        return voidTask;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<InputStream> getInputStream(ChannelClient.Channel channel) {
        AppMethodBeat.i(100998);
        Task<InputStream> task = PendingResultUtil.toTask(zza(channel).getInputStream(asGoogleApiClient()), zzaq.zzbx);
        AppMethodBeat.o(100998);
        return task;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<OutputStream> getOutputStream(ChannelClient.Channel channel) {
        AppMethodBeat.i(100999);
        Task<OutputStream> task = PendingResultUtil.toTask(zza(channel).getOutputStream(asGoogleApiClient()), zzar.zzbx);
        AppMethodBeat.o(100999);
        return task;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<ChannelClient.Channel> openChannel(String str, String str2) {
        AppMethodBeat.i(100991);
        Task<ChannelClient.Channel> task = PendingResultUtil.toTask(this.zzcg.openChannel(asGoogleApiClient(), str, str2), zzap.zzbx);
        AppMethodBeat.o(100991);
        return task;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> receiveFile(ChannelClient.Channel channel, Uri uri, boolean z) {
        AppMethodBeat.i(101000);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(zza(channel).receiveFile(asGoogleApiClient(), uri, z));
        AppMethodBeat.o(101000);
        return voidTask;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> registerChannelCallback(ChannelClient.Channel channel, ChannelClient.ChannelCallback channelCallback) {
        AppMethodBeat.i(101003);
        String zzc = ((zzay) channel).zzc();
        Preconditions.checkNotNull(channelCallback, "listener is null");
        Looper looper = getLooper();
        String valueOf = String.valueOf(zzc);
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(channelCallback, looper, valueOf.length() != 0 ? "ChannelListener:".concat(valueOf) : new String("ChannelListener:"));
        IntentFilter[] intentFilterArr = {zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT")};
        zzas zzas = new zzas(channelCallback);
        Task<Void> doRegisterEventListener = doRegisterEventListener(new zzat(zzas, zzc, intentFilterArr, createListenerHolder, ListenerHolders.createListenerHolder(zzas, getLooper(), "ChannelListener")), new zzau(zzas, zzc, createListenerHolder.getListenerKey()));
        AppMethodBeat.o(101003);
        return doRegisterEventListener;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> registerChannelCallback(ChannelClient.ChannelCallback channelCallback) {
        AppMethodBeat.i(100992);
        Preconditions.checkNotNull(channelCallback, "listener is null");
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener");
        IntentFilter[] intentFilterArr = {zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT")};
        zzas zzas = new zzas(channelCallback);
        Task<Void> doRegisterEventListener = doRegisterEventListener(new zzat(zzas, null, intentFilterArr, createListenerHolder, ListenerHolders.createListenerHolder(zzas, getLooper(), "ChannelListener")), new zzau(zzas, null, createListenerHolder.getListenerKey()));
        AppMethodBeat.o(100992);
        return doRegisterEventListener;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> sendFile(ChannelClient.Channel channel, Uri uri) {
        AppMethodBeat.i(101001);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(zza(channel).sendFile(asGoogleApiClient(), uri));
        AppMethodBeat.o(101001);
        return voidTask;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> sendFile(ChannelClient.Channel channel, Uri uri, long j2, long j3) {
        AppMethodBeat.i(101002);
        Task<Void> voidTask = PendingResultUtil.toVoidTask(zza(channel).sendFile(asGoogleApiClient(), uri, j2, j3));
        AppMethodBeat.o(101002);
        return voidTask;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Boolean> unregisterChannelCallback(ChannelClient.Channel channel, ChannelClient.ChannelCallback channelCallback) {
        AppMethodBeat.i(101004);
        String zzc = zza(channel).zzc();
        Looper looper = getLooper();
        String valueOf = String.valueOf(zzc);
        Task<Boolean> doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(channelCallback, looper, valueOf.length() != 0 ? "ChannelListener:".concat(valueOf) : new String("ChannelListener:")).getListenerKey());
        AppMethodBeat.o(101004);
        return doUnregisterEventListener;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Boolean> unregisterChannelCallback(ChannelClient.ChannelCallback channelCallback) {
        AppMethodBeat.i(100993);
        Task<Boolean> doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener").getListenerKey());
        AppMethodBeat.o(100993);
        return doUnregisterEventListener;
    }
}
