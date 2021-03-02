package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "SendMessageResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzga extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzga> CREATOR = new zzgb();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;
    @SafeParcelable.Field(id = 3)
    public final int zzeh;

    static {
        AppMethodBeat.i(101335);
        AppMethodBeat.o(101335);
    }

    @SafeParcelable.Constructor
    public zzga(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3) {
        this.statusCode = i2;
        this.zzeh = i3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101334);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeInt(parcel, 3, this.zzeh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101334);
    }
}
