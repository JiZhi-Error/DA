package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.internal.zzdf;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class DataItemBuffer extends EntityBuffer<DataItem> implements Result {
    private final Status zzp;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        AppMethodBeat.i(100784);
        this.zzp = new Status(dataHolder.getStatusCode());
        AppMethodBeat.o(100784);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.data.EntityBuffer
    public /* synthetic */ DataItem getEntry(int i2, int i3) {
        AppMethodBeat.i(100785);
        zzdf zzdf = new zzdf(this.mDataHolder, i2, i3);
        AppMethodBeat.o(100785);
        return zzdf;
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
