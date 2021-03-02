package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzjv implements zzek {
    private final /* synthetic */ zzjr zzaqu;
    zzkq zzaqv;
    List<Long> zzaqw;
    List<zzkn> zzaqx;
    private long zzaqy;

    private zzjv(zzjr zzjr) {
        this.zzaqu = zzjr;
    }

    /* synthetic */ zzjv(zzjr zzjr, zzjs zzjs) {
        this(zzjr);
    }

    private static long zza(zzkn zzkn) {
        AppMethodBeat.i(2014);
        long longValue = ((zzkn.zzatb.longValue() / 1000) / 60) / 60;
        AppMethodBeat.o(2014);
        return longValue;
    }

    @Override // com.google.android.gms.internal.measurement.zzek
    public final boolean zza(long j2, zzkn zzkn) {
        AppMethodBeat.i(2013);
        Preconditions.checkNotNull(zzkn);
        if (this.zzaqx == null) {
            this.zzaqx = new ArrayList();
        }
        if (this.zzaqw == null) {
            this.zzaqw = new ArrayList();
        }
        if (this.zzaqx.size() <= 0 || zza(this.zzaqx.get(0)) == zza(zzkn)) {
            long zzvm = this.zzaqy + ((long) zzkn.zzvm());
            if (zzvm >= ((long) Math.max(0, zzew.zzagq.get().intValue()))) {
                AppMethodBeat.o(2013);
                return false;
            }
            this.zzaqy = zzvm;
            this.zzaqx.add(zzkn);
            this.zzaqw.add(Long.valueOf(j2));
            if (this.zzaqx.size() >= Math.max(1, zzew.zzagr.get().intValue())) {
                AppMethodBeat.o(2013);
                return false;
            }
            AppMethodBeat.o(2013);
            return true;
        }
        AppMethodBeat.o(2013);
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzek
    public final void zzb(zzkq zzkq) {
        AppMethodBeat.i(2012);
        Preconditions.checkNotNull(zzkq);
        this.zzaqv = zzkq;
        AppMethodBeat.o(2012);
    }
}
