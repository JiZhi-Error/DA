package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzbr extends zzej {
    private final Object lock = new Object();
    @GuardedBy("lock")
    @Nullable
    private zzav zzcw;
    @GuardedBy("lock")
    @Nullable
    private zzbs zzda;

    public zzbr() {
        AppMethodBeat.i(101085);
        AppMethodBeat.o(101085);
    }

    @Override // com.google.android.gms.wearable.internal.zzei
    public final void zza(int i2, int i3) {
        zzbs zzbs;
        zzav zzav;
        AppMethodBeat.i(101087);
        synchronized (this.lock) {
            try {
                zzbs = this.zzda;
                zzav = new zzav(i2, i3);
                this.zzcw = zzav;
            } finally {
                AppMethodBeat.o(101087);
            }
        }
        if (zzbs != null) {
            zzbs.zzb(zzav);
        }
    }

    public final void zza(zzbs zzbs) {
        zzav zzav;
        AppMethodBeat.i(101086);
        synchronized (this.lock) {
            try {
                this.zzda = (zzbs) Preconditions.checkNotNull(zzbs);
                zzav = this.zzcw;
            } finally {
                AppMethodBeat.o(101086);
            }
        }
        if (zzav != null) {
            zzbs.zzb(zzav);
        }
    }
}
