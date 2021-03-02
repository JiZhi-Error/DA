package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import javax.annotation.Nullable;

@VisibleForTesting
public final class zzhk<T> extends zzen {
    private final IntentFilter[] zzba;
    @Nullable
    private final String zzbb;
    private ListenerHolder<Object> zzfj;
    private ListenerHolder<Object> zzfk;
    private ListenerHolder<DataApi.DataListener> zzfl;
    private ListenerHolder<MessageApi.MessageListener> zzfm;
    private ListenerHolder<Object> zzfn;
    private ListenerHolder<Object> zzfo;
    private ListenerHolder<ChannelApi.ChannelListener> zzfp;
    private ListenerHolder<CapabilityApi.CapabilityListener> zzfq;

    private zzhk(IntentFilter[] intentFilterArr, @Nullable String str) {
        AppMethodBeat.i(101406);
        this.zzba = (IntentFilter[]) Preconditions.checkNotNull(intentFilterArr);
        this.zzbb = str;
        AppMethodBeat.o(101406);
    }

    public static zzhk<ChannelApi.ChannelListener> zza(ListenerHolder<ChannelApi.ChannelListener> listenerHolder, String str, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101404);
        zzhk<ChannelApi.ChannelListener> zzhk = new zzhk<>(intentFilterArr, (String) Preconditions.checkNotNull(str));
        ((zzhk) zzhk).zzfp = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        AppMethodBeat.o(101404);
        return zzhk;
    }

    public static zzhk<DataApi.DataListener> zza(ListenerHolder<DataApi.DataListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101401);
        zzhk<DataApi.DataListener> zzhk = new zzhk<>(intentFilterArr, null);
        ((zzhk) zzhk).zzfl = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        AppMethodBeat.o(101401);
        return zzhk;
    }

    private static void zza(ListenerHolder<?> listenerHolder) {
        AppMethodBeat.i(101412);
        if (listenerHolder != null) {
            listenerHolder.clear();
        }
        AppMethodBeat.o(101412);
    }

    public static zzhk<MessageApi.MessageListener> zzb(ListenerHolder<MessageApi.MessageListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101402);
        zzhk<MessageApi.MessageListener> zzhk = new zzhk<>(intentFilterArr, null);
        ((zzhk) zzhk).zzfm = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        AppMethodBeat.o(101402);
        return zzhk;
    }

    public static zzhk<ChannelApi.ChannelListener> zzc(ListenerHolder<ChannelApi.ChannelListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101403);
        zzhk<ChannelApi.ChannelListener> zzhk = new zzhk<>(intentFilterArr, null);
        ((zzhk) zzhk).zzfp = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        AppMethodBeat.o(101403);
        return zzhk;
    }

    public static zzhk<CapabilityApi.CapabilityListener> zzd(ListenerHolder<CapabilityApi.CapabilityListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101405);
        zzhk<CapabilityApi.CapabilityListener> zzhk = new zzhk<>(intentFilterArr, null);
        ((zzhk) zzhk).zzfq = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        AppMethodBeat.o(101405);
        return zzhk;
    }

    public final void clear() {
        AppMethodBeat.i(101407);
        zza((ListenerHolder<?>) null);
        this.zzfj = null;
        zza((ListenerHolder<?>) null);
        this.zzfk = null;
        zza(this.zzfl);
        this.zzfl = null;
        zza(this.zzfm);
        this.zzfm = null;
        zza((ListenerHolder<?>) null);
        this.zzfn = null;
        zza((ListenerHolder<?>) null);
        this.zzfo = null;
        zza(this.zzfp);
        this.zzfp = null;
        zza(this.zzfq);
        this.zzfq = null;
        AppMethodBeat.o(101407);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void onConnectedNodes(List<zzfo> list) {
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(DataHolder dataHolder) {
        AppMethodBeat.i(101408);
        if (this.zzfl != null) {
            this.zzfl.notifyListener(new zzhl(dataHolder));
            AppMethodBeat.o(101408);
            return;
        }
        dataHolder.close();
        AppMethodBeat.o(101408);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzah zzah) {
        AppMethodBeat.i(101411);
        if (this.zzfq != null) {
            this.zzfq.notifyListener(new zzho(zzah));
        }
        AppMethodBeat.o(101411);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzaw zzaw) {
        AppMethodBeat.i(101410);
        if (this.zzfp != null) {
            this.zzfp.notifyListener(new zzhn(zzaw));
        }
        AppMethodBeat.o(101410);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzfe zzfe) {
        AppMethodBeat.i(101409);
        if (this.zzfm != null) {
            this.zzfm.notifyListener(new zzhm(zzfe));
        }
        AppMethodBeat.o(101409);
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzfo zzfo2) {
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzi zzi) {
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zza(zzl zzl) {
    }

    @Override // com.google.android.gms.wearable.internal.zzem
    public final void zzb(zzfo zzfo2) {
    }

    public final IntentFilter[] zze() {
        return this.zzba;
    }

    @Nullable
    public final String zzf() {
        return this.zzbb;
    }
}
