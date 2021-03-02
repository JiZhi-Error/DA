package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataBufferIterator<T> implements Iterator<T> {
    protected final DataBuffer<T> mDataBuffer;
    protected int mPosition = -1;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        AppMethodBeat.i(11527);
        this.mDataBuffer = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
        AppMethodBeat.o(11527);
    }

    public boolean hasNext() {
        AppMethodBeat.i(11528);
        if (this.mPosition < this.mDataBuffer.getCount() - 1) {
            AppMethodBeat.o(11528);
            return true;
        }
        AppMethodBeat.o(11528);
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        AppMethodBeat.i(11529);
        if (!hasNext()) {
            NoSuchElementException noSuchElementException = new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.mPosition).toString());
            AppMethodBeat.o(11529);
            throw noSuchElementException;
        }
        DataBuffer<T> dataBuffer = this.mDataBuffer;
        int i2 = this.mPosition + 1;
        this.mPosition = i2;
        T t = dataBuffer.get(i2);
        AppMethodBeat.o(11529);
        return t;
    }

    public void remove() {
        AppMethodBeat.i(11530);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
        AppMethodBeat.o(11530);
        throw unsupportedOperationException;
    }
}
