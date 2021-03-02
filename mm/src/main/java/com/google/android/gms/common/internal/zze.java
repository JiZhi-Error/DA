package com.google.android.gms.common.internal;

import android.support.v4.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze extends h<K, V> {
    private final /* synthetic */ ExpirableLruCache zzss;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zze(ExpirableLruCache expirableLruCache, int i2) {
        super(i2);
        this.zzss = expirableLruCache;
    }

    @Override // android.support.v4.e.h
    public final V create(K k) {
        AppMethodBeat.i(4885);
        V v = (V) this.zzss.create(k);
        AppMethodBeat.o(4885);
        return v;
    }

    @Override // android.support.v4.e.h
    public final void entryRemoved(boolean z, K k, V v, V v2) {
        AppMethodBeat.i(4886);
        this.zzss.entryRemoved(z, k, v, v2);
        synchronized (ExpirableLruCache.zza(this.zzss)) {
            if (v2 == null) {
                try {
                    if (ExpirableLruCache.zzb(this.zzss)) {
                        ExpirableLruCache.zzc(this.zzss).remove(k);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(4886);
                    throw th;
                }
            }
            if (v2 == null && ExpirableLruCache.zzd(this.zzss)) {
                ExpirableLruCache.zze(this.zzss).remove(k);
            }
        }
        AppMethodBeat.o(4886);
    }

    @Override // android.support.v4.e.h
    public final int sizeOf(K k, V v) {
        AppMethodBeat.i(4884);
        int sizeOf = this.zzss.sizeOf(k, v);
        AppMethodBeat.o(4884);
        return sizeOf;
    }
}
