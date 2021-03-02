package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

final class zzbh implements Channel.GetOutputStreamResult {
    private final OutputStream zzcu;
    private final Status zzp;

    zzbh(Status status, @Nullable OutputStream outputStream) {
        AppMethodBeat.i(101055);
        this.zzp = (Status) Preconditions.checkNotNull(status);
        this.zzcu = outputStream;
        AppMethodBeat.o(101055);
    }

    @Override // com.google.android.gms.wearable.Channel.GetOutputStreamResult
    @Nullable
    public final OutputStream getOutputStream() {
        return this.zzcu;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzp;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        AppMethodBeat.i(101056);
        if (this.zzcu != null) {
            try {
                this.zzcu.close();
                AppMethodBeat.o(101056);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(101056);
    }
}
