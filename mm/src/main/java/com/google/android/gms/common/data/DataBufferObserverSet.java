package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
    private HashSet<DataBufferObserver> zzni = new HashSet<>();

    public DataBufferObserverSet() {
        AppMethodBeat.i(11531);
        AppMethodBeat.o(11531);
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public final void addObserver(DataBufferObserver dataBufferObserver) {
        AppMethodBeat.i(11534);
        this.zzni.add(dataBufferObserver);
        AppMethodBeat.o(11534);
    }

    public final void clear() {
        AppMethodBeat.i(11533);
        this.zzni.clear();
        AppMethodBeat.o(11533);
    }

    public final boolean hasObservers() {
        AppMethodBeat.i(11532);
        if (!this.zzni.isEmpty()) {
            AppMethodBeat.o(11532);
            return true;
        }
        AppMethodBeat.o(11532);
        return false;
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public final void onDataChanged() {
        AppMethodBeat.i(11536);
        Iterator<DataBufferObserver> it = this.zzni.iterator();
        while (it.hasNext()) {
            it.next().onDataChanged();
        }
        AppMethodBeat.o(11536);
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public final void onDataRangeChanged(int i2, int i3) {
        AppMethodBeat.i(11537);
        Iterator<DataBufferObserver> it = this.zzni.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeChanged(i2, i3);
        }
        AppMethodBeat.o(11537);
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public final void onDataRangeInserted(int i2, int i3) {
        AppMethodBeat.i(11538);
        Iterator<DataBufferObserver> it = this.zzni.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeInserted(i2, i3);
        }
        AppMethodBeat.o(11538);
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public final void onDataRangeMoved(int i2, int i3, int i4) {
        AppMethodBeat.i(11540);
        Iterator<DataBufferObserver> it = this.zzni.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeMoved(i2, i3, i4);
        }
        AppMethodBeat.o(11540);
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public final void onDataRangeRemoved(int i2, int i3) {
        AppMethodBeat.i(11539);
        Iterator<DataBufferObserver> it = this.zzni.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeRemoved(i2, i3);
        }
        AppMethodBeat.o(11539);
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public final void removeObserver(DataBufferObserver dataBufferObserver) {
        AppMethodBeat.i(11535);
        this.zzni.remove(dataBufferObserver);
        AppMethodBeat.o(11535);
    }
}
