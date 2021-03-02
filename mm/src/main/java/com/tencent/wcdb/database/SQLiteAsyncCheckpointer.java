package com.tencent.wcdb.database;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public class SQLiteAsyncCheckpointer implements Handler.Callback, SQLiteCheckpointListener {
    private static final int DEFAULT_BLOCKING_THRESHOLD = 300;
    private static final int DEFAULT_THRESHOLD = 100;
    private static HandlerThread gDefaultThread;
    private static final Object gDefaultThreadLock = new Object();
    private static int gDefaultThreadRefCount = 0;
    private int mBlockingThreshold;
    private Handler mHandler;
    private int mLastSyncMode;
    private Looper mLooper;
    private final HashSet<Pair<SQLiteDatabase, String>> mPendingCheckpoints;
    private int mThreshold;
    private boolean mUseDefaultLooper;

    public SQLiteAsyncCheckpointer() {
        this(null, 100, 300);
    }

    public SQLiteAsyncCheckpointer(Looper looper) {
        this(looper, 100, 300);
    }

    public SQLiteAsyncCheckpointer(Looper looper, int i2, int i3) {
        AppMethodBeat.i(2912);
        this.mLooper = looper;
        this.mThreshold = i2;
        this.mBlockingThreshold = i3;
        this.mPendingCheckpoints = new HashSet<>();
        AppMethodBeat.o(2912);
    }

    @Override // com.tencent.wcdb.database.SQLiteCheckpointListener
    public void onAttach(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(2913);
        if (this.mLooper == null) {
            this.mLooper = acquireDefaultLooper();
            this.mUseDefaultLooper = true;
        }
        this.mHandler = new Handler(this.mLooper, this);
        this.mLastSyncMode = sQLiteDatabase.getSynchronousMode();
        sQLiteDatabase.setSynchronousMode(1);
        AppMethodBeat.o(2913);
    }

    @Override // com.tencent.wcdb.database.SQLiteCheckpointListener
    public void onWALCommit(SQLiteDatabase sQLiteDatabase, String str, int i2) {
        boolean add;
        int i3 = 1;
        AppMethodBeat.i(2914);
        if (i2 < this.mThreshold) {
            AppMethodBeat.o(2914);
            return;
        }
        boolean z = i2 >= this.mBlockingThreshold;
        Pair<SQLiteDatabase, String> pair = new Pair<>(sQLiteDatabase, str);
        synchronized (this.mPendingCheckpoints) {
            try {
                add = this.mPendingCheckpoints.add(pair);
            } catch (Throwable th) {
                AppMethodBeat.o(2914);
                throw th;
            }
        }
        if (!add) {
            AppMethodBeat.o(2914);
            return;
        }
        sQLiteDatabase.acquireReference();
        Handler handler = this.mHandler;
        if (!z) {
            i3 = 0;
        }
        this.mHandler.sendMessage(handler.obtainMessage(0, i3, 0, pair));
        AppMethodBeat.o(2914);
    }

    @Override // com.tencent.wcdb.database.SQLiteCheckpointListener
    public void onDetach(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(2915);
        sQLiteDatabase.setSynchronousMode(this.mLastSyncMode);
        this.mHandler = null;
        if (this.mUseDefaultLooper) {
            this.mLooper = null;
            releaseDefaultLooper();
            this.mUseDefaultLooper = false;
        }
        AppMethodBeat.o(2915);
    }

    public boolean handleMessage(Message message) {
        AppMethodBeat.i(2916);
        Pair pair = (Pair) message.obj;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) pair.first;
        String str = (String) pair.second;
        boolean z = message.arg1 != 0;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            Pair<Integer, Integer> walCheckpoint = sQLiteDatabase.walCheckpoint(str, z);
            onCheckpointResult(sQLiteDatabase, ((Integer) walCheckpoint.first).intValue(), ((Integer) walCheckpoint.second).intValue(), SystemClock.uptimeMillis() - uptimeMillis);
            sQLiteDatabase.releaseReference();
            synchronized (this.mPendingCheckpoints) {
                try {
                    if (!this.mPendingCheckpoints.remove(pair)) {
                        AssertionError assertionError = new AssertionError("mPendingCheckpoints.remove(p)");
                        AppMethodBeat.o(2916);
                        throw assertionError;
                    }
                } finally {
                    AppMethodBeat.o(2916);
                }
            }
            return true;
        } catch (Throwable th) {
            sQLiteDatabase.releaseReference();
            AppMethodBeat.o(2916);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onCheckpointResult(SQLiteDatabase sQLiteDatabase, int i2, int i3, long j2) {
    }

    private static Looper acquireDefaultLooper() {
        Looper looper;
        AppMethodBeat.i(2917);
        synchronized (gDefaultThreadLock) {
            try {
                int i2 = gDefaultThreadRefCount;
                gDefaultThreadRefCount = i2 + 1;
                if (i2 == 0) {
                    if (gDefaultThread != null) {
                        AssertionError assertionError = new AssertionError("gDefaultThread == null");
                        AppMethodBeat.o(2917);
                        throw assertionError;
                    }
                    HandlerThread handlerThread = new HandlerThread("WCDB.AsyncCheckpointer", 4);
                    gDefaultThread = handlerThread;
                    handlerThread.start();
                }
                looper = gDefaultThread.getLooper();
            } finally {
                AppMethodBeat.o(2917);
            }
        }
        return looper;
    }

    private static void releaseDefaultLooper() {
        AppMethodBeat.i(2918);
        synchronized (gDefaultThreadLock) {
            try {
                int i2 = gDefaultThreadRefCount - 1;
                gDefaultThreadRefCount = i2;
                if (i2 <= 0) {
                    if (gDefaultThreadRefCount < 0) {
                        AssertionError assertionError = new AssertionError("gDefaultThreadRefCount == 0");
                        AppMethodBeat.o(2918);
                        throw assertionError;
                    }
                    gDefaultThread.quit();
                    gDefaultThread = null;
                }
            } finally {
                AppMethodBeat.o(2918);
            }
        }
    }

    static {
        AppMethodBeat.i(2919);
        AppMethodBeat.o(2919);
    }
}
