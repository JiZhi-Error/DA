package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@KeepForSdk
public class DataBufferResponse<T, R extends AbstractDataBuffer<T> & Result> extends Response<R> implements DataBuffer<T> {
    @KeepForSdk
    public DataBufferResponse() {
    }

    @KeepForSdk
    public DataBufferResponse(R r) {
        super(r);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public void close() {
        AppMethodBeat.i(10990);
        ((AbstractDataBuffer) getResult()).close();
        AppMethodBeat.o(10990);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public T get(int i2) {
        AppMethodBeat.i(10988);
        T t = (T) ((AbstractDataBuffer) getResult()).get(i2);
        AppMethodBeat.o(10988);
        return t;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        AppMethodBeat.i(10987);
        int count = ((AbstractDataBuffer) getResult()).getCount();
        AppMethodBeat.o(10987);
        return count;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Bundle getMetadata() {
        AppMethodBeat.i(10989);
        Bundle metadata = ((AbstractDataBuffer) getResult()).getMetadata();
        AppMethodBeat.o(10989);
        return metadata;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public boolean isClosed() {
        AppMethodBeat.i(10991);
        boolean isClosed = ((AbstractDataBuffer) getResult()).isClosed();
        AppMethodBeat.o(10991);
        return isClosed;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, java.lang.Iterable
    public Iterator<T> iterator() {
        AppMethodBeat.i(10992);
        Iterator<T> it = ((AbstractDataBuffer) getResult()).iterator();
        AppMethodBeat.o(10992);
        return it;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        AppMethodBeat.i(10994);
        ((AbstractDataBuffer) getResult()).release();
        AppMethodBeat.o(10994);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Iterator<T> singleRefIterator() {
        AppMethodBeat.i(10993);
        Iterator<T> singleRefIterator = ((AbstractDataBuffer) getResult()).singleRefIterator();
        AppMethodBeat.o(10993);
        return singleRefIterator;
    }
}
