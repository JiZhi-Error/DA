package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GetChannelOutputStreamResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdo> CREATOR = new zzdp();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;
    @Nullable
    @SafeParcelable.Field(id = 3)
    public final ParcelFileDescriptor zzdr;

    static {
        AppMethodBeat.i(101201);
        AppMethodBeat.o(101201);
    }

    @SafeParcelable.Constructor
    public zzdo(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) ParcelFileDescriptor parcelFileDescriptor) {
        this.statusCode = i2;
        this.zzdr = parcelFileDescriptor;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101200);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdr, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101200);
    }
}
