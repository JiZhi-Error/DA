package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@SafeParcelable.Class(creator = "GetConnectedNodesResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzea extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzea> CREATOR = new zzeb();
    @SafeParcelable.Field(id = 2)
    public final int statusCode;
    @SafeParcelable.Field(id = 3)
    public final List<zzfo> zzdx;

    static {
        AppMethodBeat.i(101220);
        AppMethodBeat.o(101220);
    }

    @SafeParcelable.Constructor
    public zzea(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) List<zzfo> list) {
        this.statusCode = i2;
        this.zzdx = list;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101219);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzdx, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101219);
    }
}
