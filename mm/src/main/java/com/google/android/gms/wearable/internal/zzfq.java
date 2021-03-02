package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "OpenChannelResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzfq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfq> CREATOR = new zzfr();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;
    @SafeParcelable.Field(id = 3)
    public final zzay zzck;

    static {
        AppMethodBeat.i(101318);
        AppMethodBeat.o(101318);
    }

    @SafeParcelable.Constructor
    public zzfq(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) zzay zzay) {
        this.statusCode = i2;
        this.zzck = zzay;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101317);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzck, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101317);
    }
}
