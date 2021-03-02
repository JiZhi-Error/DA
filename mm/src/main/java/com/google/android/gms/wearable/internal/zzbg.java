package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

final class zzbg implements Channel.GetInputStreamResult {
    private final InputStream zzct;
    private final Status zzp;

    zzbg(Status status, @Nullable InputStream inputStream) {
        AppMethodBeat.i(101053);
        this.zzp = (Status) Preconditions.checkNotNull(status);
        this.zzct = inputStream;
        AppMethodBeat.o(101053);
    }

    @Override // com.google.android.gms.wearable.Channel.GetInputStreamResult
    @Nullable
    public final InputStream getInputStream() {
        return this.zzct;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzp;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        AppMethodBeat.i(101054);
        if (this.zzct != null) {
            try {
                this.zzct.close();
                AppMethodBeat.o(101054);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(101054);
    }
}
