package com.tencent.wcdb.database;

import java.io.Closeable;

public abstract class SQLiteClosable implements Closeable {
    private int mReferenceCount = 1;

    /* access modifiers changed from: protected */
    public abstract void onAllReferencesReleased();

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAllReferencesReleasedFromContainer() {
        onAllReferencesReleased();
    }

    public void acquireReference() {
        synchronized (this) {
            if (this.mReferenceCount <= 0) {
                throw new IllegalStateException("attempt to re-open an already-closed object: ".concat(String.valueOf(this)));
            }
            this.mReferenceCount++;
        }
    }

    public void releaseReference() {
        boolean z;
        synchronized (this) {
            int i2 = this.mReferenceCount - 1;
            this.mReferenceCount = i2;
            z = i2 == 0;
        }
        if (z) {
            onAllReferencesReleased();
        }
    }

    @Deprecated
    public void releaseReferenceFromContainer() {
        boolean z;
        synchronized (this) {
            int i2 = this.mReferenceCount - 1;
            this.mReferenceCount = i2;
            z = i2 == 0;
        }
        if (z) {
            onAllReferencesReleased();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        releaseReference();
    }
}
