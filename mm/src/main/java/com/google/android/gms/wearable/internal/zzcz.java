package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcz implements DataItemAsset {
    private final String zzdm;
    private final String zzdn;

    public zzcz(DataItemAsset dataItemAsset) {
        AppMethodBeat.i(101164);
        this.zzdm = dataItemAsset.getId();
        this.zzdn = dataItemAsset.getDataItemKey();
        AppMethodBeat.o(101164);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ DataItemAsset freeze() {
        return this;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public final String getDataItemKey() {
        return this.zzdn;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public final String getId() {
        return this.zzdm;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        AppMethodBeat.i(101165);
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetEntity[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zzdm == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.zzdm);
        }
        sb.append(", key=");
        sb.append(this.zzdn);
        sb.append("]");
        String sb2 = sb.toString();
        AppMethodBeat.o(101165);
        return sb2;
    }
}
