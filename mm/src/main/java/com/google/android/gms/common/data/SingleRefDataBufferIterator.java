package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;

public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private T zzoj;

    public SingleRefDataBufferIterator(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // java.util.Iterator, com.google.android.gms.common.data.DataBufferIterator
    public T next() {
        AppMethodBeat.i(11664);
        if (!hasNext()) {
            NoSuchElementException noSuchElementException = new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.mPosition).toString());
            AppMethodBeat.o(11664);
            throw noSuchElementException;
        }
        this.mPosition++;
        if (this.mPosition == 0) {
            this.zzoj = (T) this.mDataBuffer.get(0);
            if (!(this.zzoj instanceof DataBufferRef)) {
                String valueOf = String.valueOf(this.zzoj.getClass());
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("DataBuffer reference of type ").append(valueOf).append(" is not movable").toString());
                AppMethodBeat.o(11664);
                throw illegalStateException;
            }
        } else {
            this.zzoj.setDataRow(this.mPosition);
        }
        T t = this.zzoj;
        AppMethodBeat.o(11664);
        return t;
    }
}
