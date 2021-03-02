package com.tencent.mm.sdk.platformtools;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class PeriodRecorder {
    private static final String TAG = "MicroMsg.PeriodRecorder";
    private volatile boolean mIsPreloaded;
    private final Map<String, Long> mLastTimeCache;
    private long mPeriod;
    private byte[] mPreloadLock;
    private final String mScene;
    private SharedPreferences mStorage;
    private final String mStorageName;
    private final boolean mTriggerOnNewlyInit;
    private final boolean mUseCalenderTime;

    public PeriodRecorder(String str, long j2, boolean z) {
        this(str, j2, z, false);
    }

    public PeriodRecorder(String str, long j2, boolean z, boolean z2) {
        AppMethodBeat.i(215431);
        this.mPeriod = 0;
        this.mPreloadLock = new byte[0];
        this.mIsPreloaded = false;
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scene is null.");
            AppMethodBeat.o(215431);
            throw illegalArgumentException;
        }
        this.mScene = str;
        this.mUseCalenderTime = z;
        this.mStorageName = "prm_" + this.mScene + "_" + j2 + (z ? "_c" : "");
        this.mLastTimeCache = new ConcurrentHashMap(20);
        this.mPeriod = j2;
        this.mTriggerOnNewlyInit = z2;
        AppMethodBeat.o(215431);
    }

    private synchronized void ensureInitialized() {
        AppMethodBeat.i(185216);
        if (this.mStorage != null) {
            AppMethodBeat.o(185216);
        } else {
            try {
                this.mStorage = MultiProcessMMKV.getMMKVWithTransportByName(this.mStorageName);
                AppMethodBeat.o(185216);
            } catch (Throwable th) {
                Log.printErrStackTrace(TAG, th, "fail to get sharedpreferences, disable PeriodRecorder.", new Object[0]);
                this.mStorage = null;
                AppMethodBeat.o(185216);
            }
        }
    }

    public final synchronized boolean isExpired(String str) {
        boolean z;
        AppMethodBeat.i(185217);
        ensureInitialized();
        if (this.mStorage == null) {
            Log.w(TAG, "PeriodRecorder is disabled.");
            AppMethodBeat.o(185217);
            z = false;
        } else if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("key is null.");
            AppMethodBeat.o(185217);
            throw illegalArgumentException;
        } else {
            preloadOnDemand();
            long nowTime = getNowTime();
            if (!this.mLastTimeCache.containsKey(str)) {
                this.mLastTimeCache.put(str, Long.valueOf(nowTime));
                this.mStorage.edit().putLong(str, nowTime).apply();
                z = this.mTriggerOnNewlyInit;
                AppMethodBeat.o(185217);
            } else if (nowTime - this.mLastTimeCache.get(str).longValue() > this.mPeriod) {
                this.mLastTimeCache.put(str, Long.valueOf(nowTime));
                this.mStorage.edit().putLong(str, nowTime).apply();
                z = true;
                AppMethodBeat.o(185217);
            } else {
                AppMethodBeat.o(185217);
                z = false;
            }
        }
        return z;
    }

    private long getNowTime() {
        AppMethodBeat.i(215432);
        if (this.mUseCalenderTime) {
            long currentTimeMillis = System.currentTimeMillis();
            AppMethodBeat.o(215432);
            return currentTimeMillis;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.o(215432);
        return elapsedRealtime;
    }

    private void preloadOnDemand() {
        AppMethodBeat.i(215433);
        synchronized (this.mPreloadLock) {
            try {
                if (!(this.mIsPreloaded || this.mStorage == null)) {
                    if (this.mStorage instanceof MultiProcessMMKV) {
                        String[] allKeys = ((MultiProcessMMKV) this.mStorage).allKeys();
                        if (allKeys == null) {
                            AppMethodBeat.o(215433);
                            return;
                        }
                        for (String str : allKeys) {
                            try {
                                long j2 = this.mStorage.getLong(str, 0);
                                if (j2 != 0) {
                                    this.mLastTimeCache.put(str, Long.valueOf(j2));
                                }
                            } catch (Throwable th) {
                                Log.printErrStackTrace(TAG, th, "exception occurred.", new Object[0]);
                            }
                        }
                    } else {
                        Map<String, ?> all = this.mStorage.getAll();
                        if (all == null) {
                            AppMethodBeat.o(215433);
                            return;
                        }
                        for (Map.Entry<String, ?> entry : all.entrySet()) {
                            Object value = entry.getValue();
                            if (value instanceof Long) {
                                this.mLastTimeCache.put(entry.getKey(), (Long) value);
                            }
                        }
                    }
                    this.mIsPreloaded = true;
                    AppMethodBeat.o(215433);
                }
            } finally {
                AppMethodBeat.o(215433);
            }
        }
    }
}
