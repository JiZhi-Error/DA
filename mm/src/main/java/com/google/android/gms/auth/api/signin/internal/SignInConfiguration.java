package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "SignInConfigurationCreator")
@SafeParcelable.Reserved({1})
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzy();
    @SafeParcelable.Field(getter = "getConsumerPkgName", id = 2)
    private final String zzfe;
    @SafeParcelable.Field(getter = "getGoogleConfig", id = 5)
    private GoogleSignInOptions zzff;

    static {
        AppMethodBeat.i(88301);
        AppMethodBeat.o(88301);
    }

    @SafeParcelable.Constructor
    public SignInConfiguration(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 5) GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(88297);
        this.zzfe = Preconditions.checkNotEmpty(str);
        this.zzff = googleSignInOptions;
        AppMethodBeat.o(88297);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(88299);
        if (obj == null) {
            AppMethodBeat.o(88299);
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.zzfe.equals(signInConfiguration.zzfe) || (this.zzff != null ? !this.zzff.equals(signInConfiguration.zzff) : signInConfiguration.zzff != null)) {
                AppMethodBeat.o(88299);
                return false;
            }
            AppMethodBeat.o(88299);
            return true;
        } catch (ClassCastException e2) {
            AppMethodBeat.o(88299);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(88300);
        int hash = new HashAccumulator().addObject(this.zzfe).addObject(this.zzff).hash();
        AppMethodBeat.o(88300);
        return hash;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88298);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzfe, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzff, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(88298);
    }

    public final GoogleSignInOptions zzt() {
        return this.zzff;
    }
}
