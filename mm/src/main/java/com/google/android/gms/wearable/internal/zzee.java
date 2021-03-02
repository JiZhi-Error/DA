package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "GetFdForAssetResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzee extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzee> CREATOR = new zzef();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;
    @SafeParcelable.Field(id = 3)
    public final ParcelFileDescriptor zzdz;

    static {
        AppMethodBeat.i(101226);
        AppMethodBeat.o(101226);
    }

    @SafeParcelable.Constructor
    public zzee(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) ParcelFileDescriptor parcelFileDescriptor) {
        this.statusCode = i2;
        this.zzdz = parcelFileDescriptor;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101225);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdz, i2 | 1, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101225);
    }
}
