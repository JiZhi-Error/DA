package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SimpleObjectPool<T> {
    private static final String TAG = "MicroMsg.SimpleObjectPool";
    private Object[] mPool;
    private int mPoolSize;

    public SimpleObjectPool(int i2) {
        AppMethodBeat.i(157835);
        if (i2 <= 0) {
            Log.e(TAG, "The max pool size must be > 0");
            AppMethodBeat.o(157835);
            return;
        }
        this.mPool = new Object[i2];
        AppMethodBeat.o(157835);
    }

    public T acquire() {
        if (this.mPool == null || this.mPoolSize <= 0) {
            return null;
        }
        int i2 = this.mPoolSize - 1;
        T t = (T) this.mPool[i2];
        this.mPool[i2] = null;
        this.mPoolSize--;
        return t;
    }

    public boolean release(T t) {
        AppMethodBeat.i(157836);
        if (this.mPool == null) {
            AppMethodBeat.o(157836);
            return false;
        } else if (isInPool(t)) {
            AppMethodBeat.o(157836);
            return false;
        } else if (this.mPoolSize >= this.mPool.length || this.mPoolSize < 0) {
            Log.e(TAG, "error index %d %d", Integer.valueOf(this.mPoolSize), Integer.valueOf(this.mPool.length));
            AppMethodBeat.o(157836);
            return false;
        } else {
            this.mPool[this.mPoolSize] = t;
            this.mPoolSize++;
            AppMethodBeat.o(157836);
            return true;
        }
    }

    private boolean isInPool(T t) {
        if (this.mPool == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.mPoolSize; i2++) {
            if (this.mPool[i2] == t) {
                return true;
            }
        }
        return false;
    }

    public void putWithoutCheck(T t) {
        if (this.mPool != null && this.mPoolSize < this.mPool.length) {
            this.mPool[this.mPoolSize] = t;
            this.mPoolSize++;
        }
    }

    /* access modifiers changed from: protected */
    public void put(T t) {
        AppMethodBeat.i(230399);
        if (this.mPool == null) {
            AppMethodBeat.o(230399);
            return;
        }
        if (!isInPool(t) && this.mPoolSize < this.mPool.length) {
            this.mPool[this.mPoolSize] = t;
            this.mPoolSize++;
        }
        AppMethodBeat.o(230399);
    }
}
