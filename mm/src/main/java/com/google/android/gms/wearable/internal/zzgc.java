package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzgc implements ChannelApi.ChannelListener {
    private final String zzce;
    private final ChannelApi.ChannelListener zzeq;

    zzgc(String str, ChannelApi.ChannelListener channelListener) {
        AppMethodBeat.i(101337);
        this.zzce = (String) Preconditions.checkNotNull(str);
        this.zzeq = (ChannelApi.ChannelListener) Preconditions.checkNotNull(channelListener);
        AppMethodBeat.o(101337);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101342);
        if (this == obj) {
            AppMethodBeat.o(101342);
            return true;
        } else if (!(obj instanceof zzgc)) {
            AppMethodBeat.o(101342);
            return false;
        } else {
            zzgc zzgc = (zzgc) obj;
            if (!this.zzeq.equals(zzgc.zzeq) || !this.zzce.equals(zzgc.zzce)) {
                AppMethodBeat.o(101342);
                return false;
            }
            AppMethodBeat.o(101342);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(101343);
        int hashCode = (this.zzce.hashCode() * 31) + this.zzeq.hashCode();
        AppMethodBeat.o(101343);
        return hashCode;
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onChannelClosed(Channel channel, int i2, int i3) {
        AppMethodBeat.i(101339);
        this.zzeq.onChannelClosed(channel, i2, i3);
        AppMethodBeat.o(101339);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onChannelOpened(Channel channel) {
        AppMethodBeat.i(101338);
        this.zzeq.onChannelOpened(channel);
        AppMethodBeat.o(101338);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onInputClosed(Channel channel, int i2, int i3) {
        AppMethodBeat.i(101340);
        this.zzeq.onInputClosed(channel, i2, i3);
        AppMethodBeat.o(101340);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onOutputClosed(Channel channel, int i2, int i3) {
        AppMethodBeat.i(101341);
        this.zzeq.onOutputClosed(channel, i2, i3);
        AppMethodBeat.o(101341);
    }
}
