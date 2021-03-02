package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "NotifyCompletionRequestCreator")
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
    @SafeParcelable.Field(id = 2)
    private final String accountType;
    @SafeParcelable.Field(id = 3)
    private final int zzcg;
    @SafeParcelable.VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(10746);
        AppMethodBeat.o(10746);
    }

    @SafeParcelable.Constructor
    zzae(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3) {
        AppMethodBeat.i(10744);
        this.zzy = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
        this.zzcg = i3;
        AppMethodBeat.o(10744);
    }

    public zzae(String str, int i2) {
        this(1, str, i2);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10745);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzcg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10745);
    }
}
