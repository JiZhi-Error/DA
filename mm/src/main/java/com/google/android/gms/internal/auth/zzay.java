package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "DeleteRequestCreator")
@SafeParcelable.Reserved({1000})
public final class zzay extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzay> CREATOR = new zzaz();
    @SafeParcelable.Field(getter = "getCredential", id = 1)
    private final Credential zzdq;

    static {
        AppMethodBeat.i(88384);
        AppMethodBeat.o(88384);
    }

    @SafeParcelable.Constructor
    public zzay(@SafeParcelable.Param(id = 1) Credential credential) {
        this.zzdq = credential;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88383);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzdq, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(88383);
    }
}
