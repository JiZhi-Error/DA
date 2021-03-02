package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@SafeParcelable.Class(creator = "GetAllCapabilitiesResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdi> CREATOR = new zzdj();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;
    @VisibleForTesting
    @SafeParcelable.Field(id = 3)
    public final List<zzah> zzdp;

    static {
        AppMethodBeat.i(101192);
        AppMethodBeat.o(101192);
    }

    @SafeParcelable.Constructor
    public zzdi(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) List<zzah> list) {
        this.statusCode = i2;
        this.zzdp = list;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101191);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzdp, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101191);
    }
}
