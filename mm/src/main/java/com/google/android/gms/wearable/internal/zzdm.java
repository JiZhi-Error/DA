package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GetChannelInputStreamResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdm> CREATOR = new zzdn();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;
    @Nullable
    @SafeParcelable.Field(id = 3)
    public final ParcelFileDescriptor zzdr;

    static {
        AppMethodBeat.i(101198);
        AppMethodBeat.o(101198);
    }

    @SafeParcelable.Constructor
    public zzdm(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) ParcelFileDescriptor parcelFileDescriptor) {
        this.statusCode = i2;
        this.zzdr = parcelFileDescriptor;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101197);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdr, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101197);
    }
}
