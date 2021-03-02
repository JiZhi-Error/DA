package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "DeviceMetaDataRequestCreator")
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();
    @SafeParcelable.Field(id = 2)
    private final String accountType;
    @SafeParcelable.VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(10816);
        AppMethodBeat.o(10816);
    }

    @SafeParcelable.Constructor
    zzy(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str) {
        AppMethodBeat.i(10814);
        this.zzy = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
        AppMethodBeat.o(10814);
    }

    public zzy(String str) {
        this(1, str);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10815);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10815);
    }
}
