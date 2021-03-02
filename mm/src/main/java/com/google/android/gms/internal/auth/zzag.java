package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "RetrieveDataRequestCreator")
public final class zzag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();
    @SafeParcelable.Field(id = 2)
    private final String accountType;
    @SafeParcelable.VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(10750);
        AppMethodBeat.o(10750);
    }

    @SafeParcelable.Constructor
    zzag(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str) {
        AppMethodBeat.i(10748);
        this.zzy = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
        AppMethodBeat.o(10748);
    }

    public zzag(String str) {
        this(1, str);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10749);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10749);
    }
}
