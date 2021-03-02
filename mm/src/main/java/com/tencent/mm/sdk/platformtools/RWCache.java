package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RWCache<K, V> {
    private static final int DEFAULT_MAX_HOLDER_THRESHOLD = 40;
    private static final long DEFAULT_MAX_SYNC_TIME = 60000;
    private static final long DEFAULT_MAX_TIME_OUT = 60000;
    private static final String TAG = "MicroMsg.RWCache";
    private final IRWCacheAppender<K, V> appender;
    private final LruCache<K, CacheItem<V>> cache;
    private final LinkedHashMap<K, Holder<K, V>> holderMap;
    private volatile boolean isTimeout;
    private final long maxSyncTime;
    protected Object tag;
    private final long threshold;
    private final MTimerHandler timeoutChecker;
    private final long timeoutMillis;
    private final MTimerHandler timer;
    private boolean trigger;

    public static class Holder<K, V> {
        public static final int FUNC_DELETE = 2;
        public static final int FUNC_UPDATE = 1;
        public int funcType;
        public K key;
        public V values;
    }

    public interface IRWCacheAppender<K, V> {
        void append(RWCache<K, V> rWCache, Holder<K, V> holder);

        void postAppend();

        boolean preAppend();
    }

    public RWCache(IRWCacheAppender<K, V> iRWCacheAppender, Looper looper, int i2) {
        this(iRWCacheAppender, looper, i2, 40, Util.MILLSECONDS_OF_MINUTE, Util.MILLSECONDS_OF_MINUTE);
    }

    public RWCache(IRWCacheAppender<K, V> iRWCacheAppender, Looper looper, int i2, int i3, long j2, long j3) {
        AppMethodBeat.i(230377);
        this.holderMap = new LinkedHashMap<>();
        this.trigger = true;
        this.isTimeout = false;
        if (iRWCacheAppender == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("arg appender can not be null!");
            AppMethodBeat.o(230377);
            throw illegalArgumentException;
        } else if (looper == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("arg looper can not be null!");
            AppMethodBeat.o(230377);
            throw illegalArgumentException2;
        } else if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("arg size can not be <= 0!");
            AppMethodBeat.o(230377);
            throw illegalArgumentException3;
        } else {
            this.appender = iRWCacheAppender;
            this.cache = new LruCache<>(i2);
            this.threshold = i3 > 0 ? (long) i3 : 40;
            this.maxSyncTime = j2 <= 0 ? Util.MILLSECONDS_OF_MINUTE : j2;
            this.timeoutMillis = j3 <= 0 ? Util.MILLSECONDS_OF_MINUTE : j3;
            this.timer = new MTimerHandler(looper, (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.sdk.platformtools.RWCache.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public boolean onTimerExpired() {
                    AppMethodBeat.i(157800);
                    long currentTimeMillis = System.currentTimeMillis();
                    RWCache.this.appendAll(false);
                    Log.i(RWCache.TAG, "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    AppMethodBeat.o(157800);
                    return false;
                }
            }, false);
            this.timeoutChecker = new MTimerHandler("RWCache_timeoutChecker", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.sdk.platformtools.RWCache.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public boolean onTimerExpired() {
                    AppMethodBeat.i(230376);
                    RWCache.this.isTimeout = true;
                    AppMethodBeat.o(230376);
                    return false;
                }
            }, false);
            AppMethodBeat.o(230377);
        }
    }

    public Object getTag() {
        return this.tag;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public V get(K k) {
        AppMethodBeat.i(157803);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.o(157803);
            throw nullPointerException;
        }
        CacheItem<V> cacheItem = this.cache.get(k);
        if (cacheItem != null) {
            V v = cacheItem.val;
            AppMethodBeat.o(157803);
            return v;
        }
        this.cache.put(k, new CacheItem<>(null));
        AppMethodBeat.o(157803);
        return null;
    }

    public boolean set(K k, V v) {
        int i2;
        AppMethodBeat.i(157804);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.o(157804);
            throw nullPointerException;
        }
        CacheItem<V> cacheItem = new CacheItem<>(v);
        if (cacheItem.equals(this.cache.get(k))) {
            AppMethodBeat.o(157804);
            return false;
        }
        this.cache.put(k, cacheItem);
        Holder<K, V> holder = new Holder<>();
        holder.key = k;
        holder.values = v;
        if (v == null) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        holder.funcType = i2;
        put(k, holder);
        AppMethodBeat.o(157804);
        return true;
    }

    public boolean remove(K k) {
        AppMethodBeat.i(230378);
        if (k == null) {
            NullPointerException nullPointerException = new NullPointerException("key == null");
            AppMethodBeat.o(230378);
            throw nullPointerException;
        } else if (get(k) != null) {
            boolean z = set(k, null);
            AppMethodBeat.o(230378);
            return z;
        } else {
            AppMethodBeat.o(230378);
            return false;
        }
    }

    public void clear() {
        AppMethodBeat.i(230379);
        synchronized (this) {
            try {
                this.cache.evictAll();
                this.holderMap.clear();
                this.timer.stopTimer();
                this.timeoutChecker.stopTimer();
                this.isTimeout = true;
            } finally {
                AppMethodBeat.o(230379);
            }
        }
    }

    public void appendAll(boolean z) {
        AppMethodBeat.i(157805);
        Log.i(TAG, "summer appendAll force: " + z + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.holderMap.size());
        synchronized (this) {
            try {
                this.trigger = true;
                if (!this.holderMap.isEmpty()) {
                    if (!this.appender.preAppend()) {
                        AppMethodBeat.o(157805);
                        return;
                    }
                    Iterator<Map.Entry<K, Holder<K, V>>> it = this.holderMap.entrySet().iterator();
                    if (z) {
                        while (it.hasNext()) {
                            this.appender.append(this, it.next().getValue());
                            it.remove();
                        }
                    } else {
                        this.isTimeout = false;
                        this.timeoutChecker.startTimer(this.timeoutMillis);
                        while (!this.isTimeout && it.hasNext()) {
                            this.appender.append(this, it.next().getValue());
                            it.remove();
                        }
                        if (this.isTimeout) {
                            Log.i(TAG, "summer appendAll timeout size[%d] hasNext[%b] end", Integer.valueOf(this.holderMap.size()), Boolean.valueOf(it.hasNext()));
                        }
                        this.timeoutChecker.stopTimer();
                    }
                    this.appender.postAppend();
                    AppMethodBeat.o(157805);
                }
            } finally {
                AppMethodBeat.o(157805);
            }
        }
    }

    private void put(K k, Holder<K, V> holder) {
        AppMethodBeat.i(157806);
        synchronized (this) {
            try {
                this.holderMap.put(k, holder);
                if (this.trigger && ((long) this.holderMap.size()) > this.threshold) {
                    this.timer.startTimer(0);
                    this.trigger = false;
                } else if (this.timer.stopped()) {
                    this.timer.startTimer(this.maxSyncTime);
                }
            } finally {
                AppMethodBeat.o(157806);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class CacheItem<V> {
        final V val;

        CacheItem(V v) {
            this.val = v;
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(157801);
            if (obj == null) {
                AppMethodBeat.o(157801);
                return false;
            } else if (!(obj instanceof CacheItem)) {
                AppMethodBeat.o(157801);
                return false;
            } else {
                CacheItem cacheItem = (CacheItem) obj;
                if (this.val != null) {
                    boolean equals = this.val.equals(cacheItem.val);
                    AppMethodBeat.o(157801);
                    return equals;
                } else if (cacheItem.val == null) {
                    AppMethodBeat.o(157801);
                    return true;
                } else {
                    AppMethodBeat.o(157801);
                    return false;
                }
            }
        }
    }
}
