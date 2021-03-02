package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "HintRequestCreator")
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new zzk();
    @SafeParcelable.Field(getter = "getAccountTypes", id = 4)
    private final String[] zzcv;
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 5)
    private final boolean zzcy;
    @SafeParcelable.Field(getter = "getServerClientId", id = 6)
    private final String zzcz;
    @SafeParcelable.Field(getter = "getIdTokenNonce", id = 7)
    private final String zzda;
    @SafeParcelable.Field(getter = "getHintPickerConfig", id = 1)
    private final CredentialPickerConfig zzdc;
    @SafeParcelable.Field(getter = "isEmailAddressIdentifierSupported", id = 2)
    private final boolean zzdd;
    @SafeParcelable.Field(getter = "isPhoneNumberIdentifierSupported", id = 3)
    private final boolean zzde;
    @SafeParcelable.Field(id = 1000)
    private final int zzy;

    public static final class Builder {
        private String[] zzcv;
        private boolean zzcy = false;
        private String zzcz;
        private String zzda;
        private CredentialPickerConfig zzdc = new CredentialPickerConfig.Builder().build();
        private boolean zzdd;
        private boolean zzde;

        public Builder() {
            AppMethodBeat.i(88239);
            AppMethodBeat.o(88239);
        }

        public final HintRequest build() {
            AppMethodBeat.i(88241);
            if (this.zzcv == null) {
                this.zzcv = new String[0];
            }
            if (this.zzdd || this.zzde || this.zzcv.length != 0) {
                HintRequest hintRequest = new HintRequest(this);
                AppMethodBeat.o(88241);
                return hintRequest;
            }
            IllegalStateException illegalStateException = new IllegalStateException("At least one authentication method must be specified");
            AppMethodBeat.o(88241);
            throw illegalStateException;
        }

        public final Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zzcv = strArr;
            return this;
        }

        public final Builder setEmailAddressIdentifierSupported(boolean z) {
            this.zzdd = z;
            return this;
        }

        public final Builder setHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            AppMethodBeat.i(88240);
            this.zzdc = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
            AppMethodBeat.o(88240);
            return this;
        }

        public final Builder setIdTokenNonce(String str) {
            this.zzda = str;
            return this;
        }

        public final Builder setIdTokenRequested(boolean z) {
            this.zzcy = z;
            return this;
        }

        public final Builder setPhoneNumberIdentifierSupported(boolean z) {
            this.zzde = z;
            return this;
        }

        public final Builder setServerClientId(String str) {
            this.zzcz = str;
            return this;
        }
    }

    static {
        AppMethodBeat.i(88245);
        AppMethodBeat.o(88245);
    }

    @SafeParcelable.Constructor
    HintRequest(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) String[] strArr, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) String str2) {
        AppMethodBeat.i(88242);
        this.zzy = i2;
        this.zzdc = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
        this.zzdd = z;
        this.zzde = z2;
        this.zzcv = (String[]) Preconditions.checkNotNull(strArr);
        if (this.zzy < 2) {
            this.zzcy = true;
            this.zzcz = null;
            this.zzda = null;
            AppMethodBeat.o(88242);
            return;
        }
        this.zzcy = z3;
        this.zzcz = str;
        this.zzda = str2;
        AppMethodBeat.o(88242);
    }

    private HintRequest(Builder builder) {
        this(2, builder.zzdc, builder.zzdd, builder.zzde, builder.zzcv, builder.zzcy, builder.zzcz, builder.zzda);
        AppMethodBeat.i(88243);
        AppMethodBeat.o(88243);
    }

    public final String[] getAccountTypes() {
        return this.zzcv;
    }

    public final CredentialPickerConfig getHintPickerConfig() {
        return this.zzdc;
    }

    public final String getIdTokenNonce() {
        return this.zzda;
    }

    public final String getServerClientId() {
        return this.zzcz;
    }

    public final boolean isEmailAddressIdentifierSupported() {
        return this.zzdd;
    }

    public final boolean isIdTokenRequested() {
        return this.zzcy;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88244);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getHintPickerConfig(), i2, false);
        SafeParcelWriter.writeBoolean(parcel, 2, isEmailAddressIdentifierSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzde);
        SafeParcelWriter.writeStringArray(parcel, 4, getAccountTypes(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(88244);
    }
}
