package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "UserChallengeRequestCreator")
public final class zzak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzak> CREATOR = new zzal();
    @SafeParcelable.Field(id = 2)
    private final String accountType;
    @SafeParcelable.Field(id = 3)
    private final PendingIntent zzch;
    @SafeParcelable.VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(10758);
        AppMethodBeat.o(10758);
    }

    @SafeParcelable.Constructor
    zzak(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent) {
        AppMethodBeat.i(10756);
        this.zzy = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
        this.zzch = (PendingIntent) Preconditions.checkNotNull(pendingIntent);
        AppMethodBeat.o(10756);
    }

    public zzak(String str, PendingIntent pendingIntent) {
        this(1, str, pendingIntent);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(10757);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzch, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(10757);
    }
}
