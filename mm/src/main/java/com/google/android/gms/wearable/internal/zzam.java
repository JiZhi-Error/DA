package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

final class zzam implements ChannelApi.OpenChannelResult {
    private final Channel zzcd;
    private final Status zzp;

    zzam(Status status, @Nullable Channel channel) {
        AppMethodBeat.i(100986);
        this.zzp = (Status) Preconditions.checkNotNull(status);
        this.zzcd = channel;
        AppMethodBeat.o(100986);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.OpenChannelResult
    @Nullable
    public final Channel getChannel() {
        return this.zzcd;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzp;
    }
}
