package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "GetConfigResponseCreator")
@SafeParcelable.Reserved({1})
@Deprecated
public final class zzdw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdw> CREATOR = new zzdx();
    @SafeParcelable.Field(id = 2)
    private final int statusCode;
    @SafeParcelable.Field(id = 3)
    private final ConnectionConfiguration zzdv;

    static {
        AppMethodBeat.i(101213);
        AppMethodBeat.o(101213);
    }

    @SafeParcelable.Constructor
    public zzdw(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) ConnectionConfiguration connectionConfiguration) {
        this.statusCode = i2;
        this.zzdv = connectionConfiguration;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101212);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdv, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101212);
    }
}
