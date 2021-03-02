package android.support.v4.e;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class h<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public h(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i2;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    public void resize(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = i2;
        }
        trimToSize(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        r1 = create(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r1 != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.createCount++;
        r0 = r4.map.put(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r0 == null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        r4.map.put(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (r0 == null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        entryRemoved(false, r5, r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
        r4.size += safeSizeOf(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0057, code lost:
        trimToSize(r4.maxSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x000b
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "key == null"
            r0.<init>(r1)
            throw r0
        L_0x000b:
            monitor-enter(r4)
            java.util.LinkedHashMap<K, V> r0 = r4.map     // Catch:{ all -> 0x002b }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x001c
            int r1 = r4.hitCount     // Catch:{ all -> 0x002b }
            int r1 = r1 + 1
            r4.hitCount = r1     // Catch:{ all -> 0x002b }
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
        L_0x001b:
            return r0
        L_0x001c:
            int r0 = r4.missCount     // Catch:{ all -> 0x002b }
            int r0 = r0 + 1
            r4.missCount = r0     // Catch:{ all -> 0x002b }
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            java.lang.Object r1 = r4.create(r5)
            if (r1 != 0) goto L_0x002e
            r0 = 0
            goto L_0x001b
        L_0x002b:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x002e:
            monitor-enter(r4)
            int r0 = r4.createCount     // Catch:{ all -> 0x0054 }
            int r0 = r0 + 1
            r4.createCount = r0     // Catch:{ all -> 0x0054 }
            java.util.LinkedHashMap<K, V> r0 = r4.map     // Catch:{ all -> 0x0054 }
            java.lang.Object r0 = r0.put(r5, r1)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x004a
            java.util.LinkedHashMap<K, V> r2 = r4.map     // Catch:{ all -> 0x0054 }
            r2.put(r5, r0)     // Catch:{ all -> 0x0054 }
        L_0x0042:
            monitor-exit(r4)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0057
            r2 = 0
            r4.entryRemoved(r2, r5, r1, r0)
            goto L_0x001b
        L_0x004a:
            int r2 = r4.size
            int r3 = r4.safeSizeOf(r5, r1)
            int r2 = r2 + r3
            r4.size = r2
            goto L_0x0042
        L_0x0054:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x0057:
            int r0 = r4.maxSize
            r4.trimToSize(r0)
            r0 = r1
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.e.h.get(java.lang.Object):java.lang.Object");
    }

    public final V put(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.putCount++;
            this.size += safeSizeOf(k, v);
            put = this.map.put(k, v);
            if (put != null) {
                this.size -= safeSizeOf(k, put);
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        return put;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r5) {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.e.h.trimToSize(int):void");
    }

    public final V remove(K k) {
        V remove;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            remove = this.map.remove(k);
            if (remove != null) {
                this.size -= safeSizeOf(k, remove);
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
        int sizeOf = sizeOf(k, v);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException("Negative size: " + ((Object) k) + "=" + ((Object) v));
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public final void evictAll() {
        trimToSize(-1);
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
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        String format;
        int i2 = 0;
        synchronized (this) {
            int i3 = this.hitCount + this.missCount;
            if (i3 != 0) {
                i2 = (this.hitCount * 100) / i3;
            }
            format = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i2));
        }
        return format;
    }
}
