package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "GetConfigsResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdy> CREATOR = new zzdz();
    @SafeParcelable.Field(id = 2)
    private final int statusCode;
    @SafeParcelable.Field(id = 3)
    private final ConnectionConfiguration[] zzdw;

    static {
        AppMethodBeat.i(101216);
        AppMethodBeat.o(101216);
    }

    @SafeParcelable.Constructor
    public zzdy(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) ConnectionConfiguration[] connectionConfigurationArr) {
        this.statusCode = i2;
        this.zzdw = connectionConfigurationArr;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101215);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zzdw, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(101215);
    }
}
