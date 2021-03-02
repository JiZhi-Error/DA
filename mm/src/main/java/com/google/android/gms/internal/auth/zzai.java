package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "SendDataRequestCreator")
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzaj();
    @SafeParcelable.Field(id = 2)
    private final String accountType;
    @SafeParcelable.Field(id = 3)
    private final byte[] zzbz;
    @SafeParcelable.VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(10754);
        AppMethodBeat.o(10754);
    }

    @SafeParcelable.Constructor
    zzai(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) byte[] bArr) {
        AppMethodBeat.i(10752);
        this.zzy = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
        this.zzbz = (byte[]) Preconditions.checkNotNull(bArr);
        AppMethodBeat.o(10752);
    }

    public zzai(String str, byte[] bArr) {
        this(1, str, bArr);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10753);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzbz, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10753);
    }
}
