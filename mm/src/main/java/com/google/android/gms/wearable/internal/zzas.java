package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzas implements ChannelApi.ChannelListener {
    private final ChannelClient.ChannelCallback zzch;

    public zzas(ChannelClient.ChannelCallback channelCallback) {
        this.zzch = channelCallback;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(101017);
        if (this == obj) {
            AppMethodBeat.o(101017);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(101017);
            return false;
        } else {
            boolean equals = this.zzch.equals(((zzas) obj).zzch);
            AppMethodBeat.o(101017);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(101018);
        int hashCode = this.zzch.hashCode();
        AppMethodBeat.o(101018);
        return hashCode;
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onChannelClosed(Channel channel, int i2, int i3) {
        AppMethodBeat.i(101014);
        this.zzch.onChannelClosed(zzao.zzb(channel), i2, i3);
        AppMethodBeat.o(101014);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onChannelOpened(Channel channel) {
        AppMethodBeat.i(101013);
        this.zzch.onChannelOpened(zzao.zzb(channel));
        AppMethodBeat.o(101013);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onInputClosed(Channel channel, int i2, int i3) {
        AppMethodBeat.i(101015);
        this.zzch.onInputClosed(zzao.zzb(channel), i2, i3);
        AppMethodBeat.o(101015);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onOutputClosed(Channel channel, int i2, int i3) {
        AppMethodBeat.i(101016);
        this.zzch.onOutputClosed(zzao.zzb(channel), i2, i3);
        AppMethodBeat.o(101016);
    }
}
