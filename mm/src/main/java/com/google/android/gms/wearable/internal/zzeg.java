package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "GetLocalNodeResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzeg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeg> CREATOR = new zzeh();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;
    @SafeParcelable.Field(id = 3)
    public final zzfo zzea;

    static {
        AppMethodBeat.i(101229);
        AppMethodBeat.o(101229);
    }

    @SafeParcelable.Constructor
    public zzeg(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) zzfo zzfo) {
        this.statusCode = i2;
        this.zzea = zzfo;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101228);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzea, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101228);
    }
}
