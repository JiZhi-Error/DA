package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;
import com.google.android.gms.wearable.internal.zzcy;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataEventBuffer extends EntityBuffer<DataEvent> implements Result {
    private final Status zzp;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        AppMethodBeat.i(100782);
        this.zzp = new Status(dataHolder.getStatusCode());
        AppMethodBeat.o(100782);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.data.EntityBuffer
    public /* synthetic */ DataEvent getEntry(int i2, int i3) {
        AppMethodBeat.i(100783);
        zzcy zzcy = new zzcy(this.mDataHolder, i2, i3);
        AppMethodBeat.o(100783);
        return zzcy;
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    public String getPrimaryDataMarkerColumn() {
        return "path";
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzp;
    }
}
