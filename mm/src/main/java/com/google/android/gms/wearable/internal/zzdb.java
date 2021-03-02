package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzdb extends DataBufferRef implements DataItemAsset {
    public zzdb(DataHolder dataHolder, int i2) {
        super(dataHolder, i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ DataItemAsset freeze() {
        AppMethodBeat.i(101173);
        zzcz zzcz = new zzcz(this);
        AppMethodBeat.o(101173);
        return zzcz;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public final String getDataItemKey() {
        AppMethodBeat.i(101172);
        String string = getString("asset_key");
        AppMethodBeat.o(101172);
        return string;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public final String getId() {
        AppMethodBeat.i(101171);
        String string = getString("asset_id");
        AppMethodBeat.o(101171);
        return string;
    }
}
