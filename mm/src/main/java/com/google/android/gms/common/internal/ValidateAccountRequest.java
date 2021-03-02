package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "ValidateAccountRequestCreator")
@Deprecated
public class ValidateAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new ValidateAccountRequestCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;

    static {
        AppMethodBeat.i(4746);
        AppMethodBeat.o(4746);
    }

    @SafeParcelable.Constructor
    ValidateAccountRequest(@SafeParcelable.Param(id = 1) int i2) {
        this.zzal = i2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(4745);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(4745);
    }
}
