package com.tencent.wcdb.support;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;

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
        AppMethodBeat.i(3411);
        if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
            AppMethodBeat.o(3411);
            throw illegalArgumentException;
        }
        this.maxSize = i2;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
        AppMethodBeat.o(3411);
    }

    public void resize(int i2) {
        AppMethodBeat.i(3412);
        if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
            AppMethodBeat.o(3412);
            throw illegalArgumentException;
        }
        synchronized (this) {
            try {
                this.maxSize = i2;
            } catch (Throwable th) {
                AppMethodBeat.o(3412);
                throw th;
            }
        }
        trimToSize(i2);
        AppMethodBeat.o(3412);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        r1 = create(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r1 != null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(3413);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r5.createCount++;
        r0 = r5.map.put(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        if (r0 == null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        r5.map.put(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r0 == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        entryRemoved(false, r6, r1, r0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(3413);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005e, code lost:
        r5.size += safeSizeOf(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006a, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(3413);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006e, code lost:
        trimToSize(r5.maxSize);
        com.tencent.matrix.trace.core.AppMethodBeat.o(3413);
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
    public final V get(K r6) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.support.LruCache.get(java.lang.Object):java.lang.Object");
    }

    public final V put(K k, V v) {
        V put;
        AppMethodBeat.i(3414);
        if (k == null || v == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null || value == null");
            AppMethodBeat.o(3414);
            throw nullPointerException;
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
                AppMethodBeat.o(3414);
                throw th;
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        AppMethodBeat.o(3414);
        return put;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(3415);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r7) {
        /*
        // Method dump skipped, instructions count: 161
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.support.LruCache.trimToSize(int):void");
    }

    public final V remove(K k) {
        V remove;
        AppMethodBeat.i(3416);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.o(3416);
            throw nullPointerException;
        }
        synchronized (this) {
            try {
                remove = this.map.remove(k);
                if (remove != null) {
                    this.size -= safeSizeOf(k, remove);
                }
            } finally {
                AppMethodBeat.o(3416);
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
        AppMethodBeat.i(3417);
        int sizeOf = sizeOf(k, v);
        if (sizeOf < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("Negative size: " + ((Object) k) + "=" + ((Object) v));
            AppMethodBeat.o(3417);
            throw illegalStateException;
        }
        AppMethodBeat.o(3417);
        return sizeOf;
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public final void evictAll() {
        AppMethodBeat.i(3418);
        trimToSize(-1);
        AppMethodBeat.o(3418);
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
        AppMethodBeat.i(3419);
        linkedHashMap = new LinkedHashMap(this.map);
        AppMethodBeat.o(3419);
        return linkedHashMap;
    }

    @SuppressLint({"DefaultLocale"})
    public final synchronized String toString() {
        String format;
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(3420);
            int i3 = this.hitCount + this.missCount;
            if (i3 != 0) {
                i2 = (this.hitCount * 100) / i3;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i2));
            AppMethodBeat.o(3420);
        }
        return format;
    }
}
