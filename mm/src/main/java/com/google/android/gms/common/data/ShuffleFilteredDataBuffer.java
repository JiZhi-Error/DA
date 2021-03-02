package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShuffleFilteredDataBuffer<T> extends FilteredDataBuffer<T> {
    private final List<Integer> zzoh;
    private final int zzoi;

    public ShuffleFilteredDataBuffer(DataBuffer<T> dataBuffer, int i2) {
        super(dataBuffer);
        AppMethodBeat.i(11661);
        this.zzoi = i2;
        int i3 = this.zzoi;
        int count = this.mDataBuffer.getCount();
        if (i3 > count) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("numIndexes must be smaller or equal to max");
            AppMethodBeat.o(11661);
            throw illegalArgumentException;
        }
        ArrayList arrayList = new ArrayList(count);
        for (int i4 = 0; i4 < count; i4++) {
            arrayList.add(Integer.valueOf(i4));
        }
        Collections.shuffle(arrayList);
        this.zzoh = arrayList.subList(0, i3);
        AppMethodBeat.o(11661);
    }

    @Override // com.google.android.gms.common.data.FilteredDataBuffer
    public final int computeRealPosition(int i2) {
        AppMethodBeat.i(11663);
        if (i2 < 0 || i2 >= getCount()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i2).append(" is out of bounds for this buffer").toString());
            AppMethodBeat.o(11663);
            throw illegalArgumentException;
        }
        int intValue = this.zzoh.get(i2).intValue();
        AppMethodBeat.o(11663);
        return intValue;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final int getCount() {
        AppMethodBeat.i(11662);
        int min = Math.min(this.zzoi, this.mDataBuffer.getCount());
        AppMethodBeat.o(11662);
        return min;
    }
}
