package com.google.android.gms.common.internal;

import android.support.v4.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ExpirableLruCache<K, V> {
    public static int TIME_UNSET = -1;
    private final Object mLock = new Object();
    private final h<K, V> zzsn;
    private final long zzso;
    private final long zzsp;
    private HashMap<K, Long> zzsq;
    private HashMap<K, Long> zzsr;

    public ExpirableLruCache(int i2, long j2, long j3, TimeUnit timeUnit) {
        AppMethodBeat.i(4616);
        this.zzso = TimeUnit.NANOSECONDS.convert(j2, timeUnit);
        this.zzsp = TimeUnit.NANOSECONDS.convert(j3, timeUnit);
        Preconditions.checkArgument(zzct() || zzcu(), "ExpirableLruCache has both access and write expiration negative");
        this.zzsn = new zze(this, i2);
        if (zzct()) {
            this.zzsq = new HashMap<>();
        }
        if (zzcu()) {
            this.zzsr = new HashMap<>();
        }
        AppMethodBeat.o(4616);
    }

    private final boolean zza(K k) {
        AppMethodBeat.i(4623);
        long nanoTime = System.nanoTime();
        if (zzct() && this.zzsq.containsKey(k) && nanoTime - this.zzsq.get(k).longValue() > this.zzso) {
            AppMethodBeat.o(4623);
            return true;
        } else if (!zzcu() || !this.zzsr.containsKey(k) || nanoTime - this.zzsr.get(k).longValue() <= this.zzsp) {
            AppMethodBeat.o(4623);
            return false;
        } else {
            AppMethodBeat.o(4623);
            return true;
        }
    }

    static /* synthetic */ boolean zzb(ExpirableLruCache expirableLruCache) {
        AppMethodBeat.i(4624);
        boolean zzct = expirableLruCache.zzct();
        AppMethodBeat.o(4624);
        return zzct;
    }

    private final boolean zzct() {
        return this.zzso >= 0;
    }

    private final boolean zzcu() {
        return this.zzsp >= 0;
    }

    static /* synthetic */ boolean zzd(ExpirableLruCache expirableLruCache) {
        AppMethodBeat.i(4625);
        boolean zzcu = expirableLruCache.zzcu();
        AppMethodBeat.o(4625);
        return zzcu;
    }

    /* access modifiers changed from: protected */
    public V create(K k) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    public void evictAll() {
        AppMethodBeat.i(4622);
        this.zzsn.evictAll();
        AppMethodBeat.o(4622);
    }

    public V get(K k) {
        V v;
        AppMethodBeat.i(4618);
        synchronized (this.mLock) {
            try {
                if (zza((Object) k)) {
                    this.zzsn.remove(k);
                }
                v = this.zzsn.get(k);
                if (v != null && this.zzso > 0) {
                    this.zzsq.put(k, Long.valueOf(System.nanoTime()));
                }
            } finally {
                AppMethodBeat.o(4618);
            }
        }
        return v;
    }

    public V put(K k, V v) {
        AppMethodBeat.i(4617);
        if (zzcu()) {
            long nanoTime = System.nanoTime();
            synchronized (this.mLock) {
                try {
                    this.zzsr.put(k, Long.valueOf(nanoTime));
                } catch (Throwable th) {
                    AppMethodBeat.o(4617);
                    throw th;
                }
            }
        }
        V put = this.zzsn.put(k, v);
        AppMethodBeat.o(4617);
        return put;
    }

    public V remove(K k) {
        AppMethodBeat.i(4619);
        V remove = this.zzsn.remove(k);
        AppMethodBeat.o(4619);
        return remove;
    }

    public void removeExpired() {
        AppMethodBeat.i(4620);
        for (K k : this.zzsn.snapshot().keySet()) {
            synchronized (this.mLock) {
                try {
                    if (zza((Object) k)) {
                        this.zzsn.remove(k);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(4620);
                    throw th;
                }
            }
        }
        AppMethodBeat.o(4620);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public Map<K, V> snapshot() {
        AppMethodBeat.i(4621);
        removeExpired();
        Map<K, V> snapshot = this.zzsn.snapshot();
        AppMethodBeat.o(4621);
        return snapshot;
    }
}
