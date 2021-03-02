package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "GetCloudSyncSettingCreator")
@SafeParcelable.Reserved({1})
public final class zzdv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdv> CREATOR = new zzdu();
    @SafeParcelable.Field(id = 3)
    private final boolean enabled;
    @SafeParcelable.Field(id = 2)
    private final int statusCode;

    static {
        AppMethodBeat.i(101211);
        AppMethodBeat.o(101211);
    }

    @SafeParcelable.Constructor
    public zzdv(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) boolean z) {
        this.statusCode = i2;
        this.enabled = z;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101210);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeBoolean(parcel, 3, this.enabled);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101210);
    }
}
