package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcy extends DataBufferRef implements DataEvent {
    private final int zzdl;

    public zzcy(DataHolder dataHolder, int i2, int i3) {
        super(dataHolder, i2);
        this.zzdl = i3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ DataEvent freeze() {
        AppMethodBeat.i(101163);
        zzcx zzcx = new zzcx(this);
        AppMethodBeat.o(101163);
        return zzcx;
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final DataItem getDataItem() {
        AppMethodBeat.i(101160);
        zzdf zzdf = new zzdf(this.mDataHolder, this.mDataRow, this.zzdl);
        AppMethodBeat.o(101160);
        return zzdf;
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final int getType() {
        AppMethodBeat.i(101161);
        int integer = getInteger("event_type");
        AppMethodBeat.o(101161);
        return integer;
    }

    public final String toString() {
        AppMethodBeat.i(101162);
        String str = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        String valueOf = String.valueOf(getDataItem());
        String sb = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(valueOf).length()).append("DataEventRef{ type=").append(str).append(", dataitem=").append(valueOf).append(" }").toString();
        AppMethodBeat.o(101162);
        return sb;
    }
}
