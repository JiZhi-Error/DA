package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "ChannelReceiveFileResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzbn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbn> CREATOR = new zzbo();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;

    static {
        AppMethodBeat.i(101080);
        AppMethodBeat.o(101080);
    }

    @SafeParcelable.Constructor
    public zzbn(@SafeParcelable.Param(id = 2) int i2) {
        this.statusCode = i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101079);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101079);
    }
}
