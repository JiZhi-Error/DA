package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "SignInAccountCreator")
@SafeParcelable.Reserved({1})
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zze();
    @SafeParcelable.Field(defaultValue = "", id = 4)
    @Deprecated
    private String zzeo;
    @SafeParcelable.Field(getter = "getGoogleSignInAccount", id = 7)
    private GoogleSignInAccount zzep;
    @SafeParcelable.Field(defaultValue = "", id = 8)
    @Deprecated
    private String zzeq;

    static {
        AppMethodBeat.i(88296);
        AppMethodBeat.o(88296);
    }

    @SafeParcelable.Constructor
    SignInAccount(@SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 7) GoogleSignInAccount googleSignInAccount, @SafeParcelable.Param(id = 8) String str2) {
        AppMethodBeat.i(88294);
        this.zzep = googleSignInAccount;
        this.zzeo = Preconditions.checkNotEmpty(str, "8.3 and 8.4 SDKs require non-null email");
        this.zzeq = Preconditions.checkNotEmpty(str2, "8.3 and 8.4 SDKs require non-null userId");
        AppMethodBeat.o(88294);
    }

    @Nullable
    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zzep;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88295);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 4, this.zzeo, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzep, i2, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzeq, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(88295);
    }
}
