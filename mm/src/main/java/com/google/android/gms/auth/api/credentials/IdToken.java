package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "IdTokenCreator")
@SafeParcelable.Reserved({1000})
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new zzl();
    @SafeParcelable.Field(getter = "getAccountType", id = 1)
    private final String zzbx;
    @SafeParcelable.Field(getter = "getIdToken", id = 2)
    private final String zzdf;

    static {
        AppMethodBeat.i(88248);
        AppMethodBeat.o(88248);
    }

    @SafeParcelable.Constructor
    public IdToken(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        boolean z = true;
        AppMethodBeat.i(88246);
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        Preconditions.checkArgument(TextUtils.isEmpty(str2) ? false : z, "id token string cannot be null or empty");
        this.zzbx = str;
        this.zzdf = str2;
        AppMethodBeat.o(88246);
    }

    public final String getAccountType() {
        return this.zzbx;
    }

    public final String getIdToken() {
        return this.zzdf;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88247);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAccountType(), false);
        SafeParcelWriter.writeString(parcel, 2, getIdToken(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(88247);
    }
}
