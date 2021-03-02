package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "GetCloudSyncOptInStatusCreator")
@SafeParcelable.Reserved({1})
public final class zzdt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdt> CREATOR = new zzds();
    @SafeParcelable.Field(id = 2)
    private final int statusCode;
    @SafeParcelable.Field(id = 3)
    private final boolean zzdt;
    @SafeParcelable.Field(id = 4)
    private final boolean zzdu;

    static {
        AppMethodBeat.i(101208);
        AppMethodBeat.o(101208);
    }

    @SafeParcelable.Constructor
    public zzdt(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) boolean z2) {
        this.statusCode = i2;
        this.zzdt = z;
        this.zzdu = z2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101207);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzdt);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdu);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101207);
    }
}
