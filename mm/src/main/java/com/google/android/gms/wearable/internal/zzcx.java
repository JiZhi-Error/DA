package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcx implements DataEvent {
    private int type;
    private DataItem zzdg;

    public zzcx(DataEvent dataEvent) {
        AppMethodBeat.i(101158);
        this.type = dataEvent.getType();
        this.zzdg = (DataItem) dataEvent.getDataItem().freeze();
        AppMethodBeat.o(101158);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ DataEvent freeze() {
        return this;
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final DataItem getDataItem() {
        return this.zzdg;
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final int getType() {
        return this.type;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        AppMethodBeat.i(101159);
        String str = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        String valueOf = String.valueOf(getDataItem());
        String sb = new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(valueOf).length()).append("DataEventEntity{ type=").append(str).append(", dataitem=").append(valueOf).append(" }").toString();
        AppMethodBeat.o(101159);
        return sb;
    }
}
