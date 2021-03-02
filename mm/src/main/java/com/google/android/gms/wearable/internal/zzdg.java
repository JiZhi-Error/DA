package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "DeleteDataItemsResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdg> CREATOR = new zzdh();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;
    @SafeParcelable.Field(id = 3)
    public final int zzdh;

    static {
        AppMethodBeat.i(101189);
        AppMethodBeat.o(101189);
    }

    @SafeParcelable.Constructor
    public zzdg(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3) {
        this.statusCode = i2;
        this.zzdh = i3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101188);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101188);
    }
}
