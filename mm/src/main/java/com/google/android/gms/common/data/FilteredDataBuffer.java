package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.internal.Asserts;
import java.util.Iterator;

public abstract class FilteredDataBuffer<T> implements DataBuffer<T> {
    protected final DataBuffer<T> mDataBuffer;

    public FilteredDataBuffer(DataBuffer<T> dataBuffer) {
        Asserts.checkNotNull(dataBuffer);
        Asserts.checkState(!(dataBuffer instanceof FilteredDataBuffer), "Not possible to have nested FilteredDataBuffers.");
        this.mDataBuffer = dataBuffer;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public void close() {
        release();
    }

    /* access modifiers changed from: protected */
    public abstract int computeRealPosition(int i2);

    @Override // com.google.android.gms.common.data.DataBuffer
    public T get(int i2) {
        return this.mDataBuffer.get(computeRealPosition(i2));
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Bundle getMetadata() {
        return this.mDataBuffer.getMetadata();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    @Deprecated
    public boolean isClosed() {
        return this.mDataBuffer.isClosed();
    }

    @Override // com.google.android.gms.common.data.DataBuffer, java.lang.Iterable
    public Iterator<T> iterator() {
        return new DataBufferIterator(this);
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        this.mDataBuffer.release();
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Iterator<T> singleRefIterator() {
        return iterator();
    }
}
