package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "GetDataItemResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzec extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzec> CREATOR = new zzed();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;
    @SafeParcelable.Field(id = 3)
    public final zzdd zzdy;

    static {
        AppMethodBeat.i(101223);
        AppMethodBeat.o(101223);
    }

    @SafeParcelable.Constructor
    public zzec(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) zzdd zzdd) {
        this.statusCode = i2;
        this.zzdy = zzdd;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101222);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdy, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101222);
    }
}
