package com.google.android.gms.common.data;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public final class SortedDataBuffer<T> implements DataBuffer<T> {
    private final DataBuffer<T> zzok;
    private final Integer[] zzol;

    public SortedDataBuffer(DataBuffer<T> dataBuffer, Comparator<T> comparator) {
        AppMethodBeat.i(11665);
        this.zzok = dataBuffer;
        this.zzol = new Integer[dataBuffer.getCount()];
        for (int i2 = 0; i2 < this.zzol.length; i2++) {
            this.zzol[i2] = Integer.valueOf(i2);
        }
        Arrays.sort(this.zzol, new zzb(this, comparator));
        AppMethodBeat.o(11665);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final void close() {
        AppMethodBeat.i(11669);
        this.zzok.release();
        AppMethodBeat.o(11669);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final T get(int i2) {
        AppMethodBeat.i(11666);
        T t = this.zzok.get(this.zzol[i2].intValue());
        AppMethodBeat.o(11666);
        return t;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final int getCount() {
        return this.zzol.length;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final Bundle getMetadata() {
        AppMethodBeat.i(11668);
        Bundle metadata = this.zzok.getMetadata();
        AppMethodBeat.o(11668);
        return metadata;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final boolean isClosed() {
        AppMethodBeat.i(11670);
        boolean isClosed = this.zzok.isClosed();
        AppMethodBeat.o(11670);
        return isClosed;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, java.lang.Iterable
    public final Iterator<T> iterator() {
        AppMethodBeat.i(11671);
        DataBufferIterator dataBufferIterator = new DataBufferIterator(this);
        AppMethodBeat.o(11671);
        return dataBufferIterator;
    }

    @Override // com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public final void release() {
        AppMethodBeat.i(11667);
        this.zzok.release();
        AppMethodBeat.o(11667);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final Iterator<T> singleRefIterator() {
        AppMethodBeat.i(11672);
        Iterator<T> it = iterator();
        AppMethodBeat.o(11672);
        return it;
    }
}
