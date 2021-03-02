package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;

public final class PositionFilteredDataBuffer<T> extends FilteredDataBuffer<T> {
    private final ArrayList<Integer> zzob = new ArrayList<>();
    private final HashSet<Integer> zzoe = new HashSet<>();

    public PositionFilteredDataBuffer(AbstractDataBuffer<T> abstractDataBuffer) {
        super(abstractDataBuffer);
        AppMethodBeat.i(11654);
        zzcl();
        AppMethodBeat.o(11654);
    }

    private final void zzcl() {
        AppMethodBeat.i(11660);
        this.zzob.clear();
        int count = this.mDataBuffer.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            if (!this.zzoe.contains(Integer.valueOf(i2))) {
                this.zzob.add(Integer.valueOf(i2));
            }
        }
        AppMethodBeat.o(11660);
    }

    public final void clearFilters() {
        AppMethodBeat.i(11659);
        this.zzoe.clear();
        zzcl();
        AppMethodBeat.o(11659);
    }

    @Override // com.google.android.gms.common.data.FilteredDataBuffer
    public final int computeRealPosition(int i2) {
        AppMethodBeat.i(11656);
        if (i2 < 0 || i2 >= getCount()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i2).append(" is out of bounds for this buffer").toString());
            AppMethodBeat.o(11656);
            throw illegalArgumentException;
        }
        int intValue = this.zzob.get(i2).intValue();
        AppMethodBeat.o(11656);
        return intValue;
    }

    public final void filterOut(int i2) {
        AppMethodBeat.i(11657);
        if (i2 >= 0 && i2 <= this.mDataBuffer.getCount()) {
            this.zzoe.add(Integer.valueOf(i2));
            zzcl();
        }
        AppMethodBeat.o(11657);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public final int getCount() {
        AppMethodBeat.i(11655);
        int count = this.mDataBuffer.getCount() - this.zzoe.size();
        AppMethodBeat.o(11655);
        return count;
    }

    public final void unfilter(int i2) {
        AppMethodBeat.i(11658);
        this.zzoe.remove(Integer.valueOf(i2));
        zzcl();
        AppMethodBeat.o(11658);
    }
}
