package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepName
@SafeParcelable.Class(creator = "DataItemAssetParcelableCreator")
@SafeParcelable.Reserved({1})
public class DataItemAssetParcelable extends AbstractSafeParcelable implements ReflectedParcelable, DataItemAsset {
    public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzda();
    @SafeParcelable.Field(getter = "getId", id = 2)
    private final String zzdm;
    @SafeParcelable.Field(getter = "getDataItemKey", id = 3)
    private final String zzdn;

    static {
        AppMethodBeat.i(100925);
        AppMethodBeat.o(100925);
    }

    public DataItemAssetParcelable(DataItemAsset dataItemAsset) {
        AppMethodBeat.i(100922);
        this.zzdm = (String) Preconditions.checkNotNull(dataItemAsset.getId());
        this.zzdn = (String) Preconditions.checkNotNull(dataItemAsset.getDataItemKey());
        AppMethodBeat.o(100922);
    }

    @SafeParcelable.Constructor
    DataItemAssetParcelable(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2) {
        this.zzdm = str;
        this.zzdn = str2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.data.Freezable
    public /* bridge */ /* synthetic */ DataItemAsset freeze() {
        return this;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String getDataItemKey() {
        return this.zzdn;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    public String getId() {
        return this.zzdm;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        AppMethodBeat.i(100924);
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetParcelable[");
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
        AppMethodBeat.o(100924);
        return sb2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(100923);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDataItemKey(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(100923);
    }
}
