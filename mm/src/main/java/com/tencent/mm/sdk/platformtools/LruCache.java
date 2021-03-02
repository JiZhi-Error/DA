package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int i2) {
        AppMethodBeat.i(157589);
        if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
            AppMethodBeat.o(157589);
            throw illegalArgumentException;
        }
        this.maxSize = i2;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
        AppMethodBeat.o(157589);
    }

    public synchronized void setMaxSize(int i2) {
        AppMethodBeat.i(157590);
        if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
            AppMethodBeat.o(157590);
            throw illegalArgumentException;
        }
        Log.i("LruCache", "setMaxSize %s", Integer.valueOf(i2));
        this.maxSize = i2;
        AppMethodBeat.o(157590);
    }

    public synchronized boolean check(K k) {
        boolean containsKey;
        AppMethodBeat.i(157591);
        containsKey = this.map.containsKey(k);
        AppMethodBeat.o(157591);
        return containsKey;
    }

    public synchronized boolean checkAndUpTime(K k) {
        boolean z;
        AppMethodBeat.i(157592);
        if (get(k) != null) {
            z = true;
            AppMethodBeat.o(157592);
        } else {
            z = false;
            AppMethodBeat.o(157592);
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        r1 = create(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r1 != null) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(157593);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r7.createCount++;
        r0 = r7.map.put(r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (r0 == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        r7.map.put(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        if (r0 == null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        entryRemoved(false, r8, r1, r0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(157593);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
        r7.size += safeSizeOf(r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(157593);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007e, code lost:
        trimToSize(r7.maxSize);
        com.tencent.matrix.trace.core.AppMethodBeat.o(157593);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r8) {
        /*
        // Method dump skipped, instructions count: 136
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.LruCache.get(java.lang.Object):java.lang.Object");
    }

    public final V put(K k, V v) {
        V put;
        AppMethodBeat.i(157594);
        if (k == null || v == null) {
            Log.e("MicroMsg.LruMap", "put key == null or value == null [%s, %s], %s", k, v, Util.getStack().toString());
        }
        synchronized (this) {
            try {
                this.putCount++;
                this.size += safeSizeOf(k, v);
                put = this.map.put(k, v);
                if (put != null) {
                    this.size -= safeSizeOf(k, put);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(157594);
                throw th;
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        AppMethodBeat.o(157594);
        return put;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r6) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.LruCache.trimToSize(int):void");
    }

    public final V remove(K k) {
        V remove;
        AppMethodBeat.i(157596);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.o(157596);
            throw nullPointerException;
        }
        synchronized (this) {
            try {
                remove = this.map.remove(k);
                if (remove != null) {
                    this.size -= safeSizeOf(k, remove);
                }
            } finally {
                AppMethodBeat.o(157596);
            }
        }
        if (remove != null) {
            entryRemoved(false, k, remove, null);
        }
        return remove;
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    /* access modifiers changed from: protected */
    public V create(K k) {
        return null;
    }

    private int safeSizeOf(K k, V v) {
        AppMethodBeat.i(157597);
        int sizeOf = sizeOf(k, v);
        if (sizeOf < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Negative size: " + ((Object) k) + "=" + ((Object) v));
            AppMethodBeat.o(157597);
            throw illegalStateException;
        }
        AppMethodBeat.o(157597);
        return sizeOf;
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public final void evictAll() {
        AppMethodBeat.i(230324);
        trimToSize(-1);
        AppMethodBeat.o(230324);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final synchronized Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        AppMethodBeat.i(157598);
        linkedHashMap = new LinkedHashMap(this.map);
        AppMethodBeat.o(157598);
        return linkedHashMap;
    }

    public final synchronized String toString() {
        String format;
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(157599);
            int i3 = this.hitCount + this.missCount;
            if (i3 != 0) {
                i2 = (this.hitCount * 100) / i3;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i2));
            AppMethodBeat.o(157599);
        }
        return format;
    }

    public Set<K> keySet() {
        AppMethodBeat.i(186049);
        Set<K> keySet = this.map.keySet();
        AppMethodBeat.o(186049);
        return keySet;
    }

    public Collection<V> values() {
        AppMethodBeat.i(230325);
        Collection<V> values = this.map.values();
        AppMethodBeat.o(230325);
        return values;
    }
}
