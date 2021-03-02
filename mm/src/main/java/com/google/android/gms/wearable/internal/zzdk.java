package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "GetCapabilityResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdk> CREATOR = new zzdl();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;
    @SafeParcelable.Field(id = 3)
    public final zzah zzdq;

    static {
        AppMethodBeat.i(101195);
        AppMethodBeat.o(101195);
    }

    @SafeParcelable.Constructor
    public zzdk(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) zzah zzah) {
        this.statusCode = i2;
        this.zzdq = zzah;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101194);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdq, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101194);
    }
}
