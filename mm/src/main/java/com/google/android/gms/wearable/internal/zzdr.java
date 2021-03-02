package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "GetCloudSyncOptInOutDoneCreator")
@SafeParcelable.Reserved({1})
public final class zzdr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdr> CREATOR = new zzdq();
    @SafeParcelable.Field(id = 2)
    private final int statusCode;
    @SafeParcelable.Field(id = 3)
    private final boolean zzds;

    static {
        AppMethodBeat.i(101205);
        AppMethodBeat.o(101205);
    }

    @SafeParcelable.Constructor
    public zzdr(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) boolean z) {
        this.statusCode = i2;
        this.zzds = z;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101204);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzds);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101204);
    }
}
