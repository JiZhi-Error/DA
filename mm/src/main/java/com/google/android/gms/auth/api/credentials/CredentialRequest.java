package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SafeParcelable.Class(creator = "CredentialRequestCreator")
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzh();
    @SafeParcelable.Field(getter = "isPasswordLoginSupported", id = 1)
    private final boolean zzcu;
    @SafeParcelable.Field(getter = "getAccountTypes", id = 2)
    private final String[] zzcv;
    @SafeParcelable.Field(getter = "getCredentialPickerConfig", id = 3)
    private final CredentialPickerConfig zzcw;
    @SafeParcelable.Field(getter = "getCredentialHintPickerConfig", id = 4)
    private final CredentialPickerConfig zzcx;
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 5)
    private final boolean zzcy;
    @SafeParcelable.Field(getter = "getServerClientId", id = 6)
    private final String zzcz;
    @SafeParcelable.Field(getter = "getIdTokenNonce", id = 7)
    private final String zzda;
    @SafeParcelable.Field(getter = "getRequireUserMediation", id = 8)
    private final boolean zzdb;
    @SafeParcelable.Field(id = 1000)
    private final int zzy;

    public static final class Builder {
        private boolean zzcu;
        private String[] zzcv;
        private CredentialPickerConfig zzcw;
        private CredentialPickerConfig zzcx;
        private boolean zzcy = false;
        private String zzcz = null;
        private String zzda;
        private boolean zzdb = false;

        public final CredentialRequest build() {
            AppMethodBeat.i(88216);
            if (this.zzcv == null) {
                this.zzcv = new String[0];
            }
            if (this.zzcu || this.zzcv.length != 0) {
                CredentialRequest credentialRequest = new CredentialRequest(this);
                AppMethodBeat.o(88216);
                return credentialRequest;
            }
            IllegalStateException illegalStateException = new IllegalStateException("At least one authentication method must be specified");
            AppMethodBeat.o(88216);
            throw illegalStateException;
        }

        public final Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zzcv = strArr;
            return this;
        }

        public final Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzcx = credentialPickerConfig;
            return this;
        }

        public final Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzcw = credentialPickerConfig;
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

        public final Builder setPasswordLoginSupported(boolean z) {
            this.zzcu = z;
            return this;
        }

        public final Builder setServerClientId(String str) {
            this.zzcz = str;
            return this;
        }

        @Deprecated
        public final Builder setSupportsPasswordLogin(boolean z) {
            AppMethodBeat.i(88215);
            Builder passwordLoginSupported = setPasswordLoginSupported(z);
            AppMethodBeat.o(88215);
            return passwordLoginSupported;
        }
    }

    static {
        AppMethodBeat.i(88222);
        AppMethodBeat.o(88222);
    }

    @SafeParcelable.Constructor
    CredentialRequest(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(id = 4) CredentialPickerConfig credentialPickerConfig2, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z3) {
        AppMethodBeat.i(88217);
        this.zzy = i2;
        this.zzcu = z;
        this.zzcv = (String[]) Preconditions.checkNotNull(strArr);
        this.zzcw = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig;
        this.zzcx = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig2;
        if (i2 < 3) {
            this.zzcy = true;
            this.zzcz = null;
            this.zzda = null;
        } else {
            this.zzcy = z2;
            this.zzcz = str;
            this.zzda = str2;
        }
        this.zzdb = z3;
        AppMethodBeat.o(88217);
    }

    private CredentialRequest(Builder builder) {
        this(4, builder.zzcu, builder.zzcv, builder.zzcw, builder.zzcx, builder.zzcy, builder.zzcz, builder.zzda, false);
        AppMethodBeat.i(88218);
        AppMethodBeat.o(88218);
    }

    public final String[] getAccountTypes() {
        return this.zzcv;
    }

    public final Set<String> getAccountTypesSet() {
        AppMethodBeat.i(88220);
        HashSet hashSet = new HashSet(Arrays.asList(this.zzcv));
        AppMethodBeat.o(88220);
        return hashSet;
    }

    public final CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzcx;
    }

    public final CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzcw;
    }

    public final String getIdTokenNonce() {
        return this.zzda;
    }

    public final String getServerClientId() {
        return this.zzcz;
    }

    @Deprecated
    public final boolean getSupportsPasswordLogin() {
        AppMethodBeat.i(88219);
        boolean isPasswordLoginSupported = isPasswordLoginSupported();
        AppMethodBeat.o(88219);
        return isPasswordLoginSupported;
    }

    public final boolean isIdTokenRequested() {
        return this.zzcy;
    }

    public final boolean isPasswordLoginSupported() {
        return this.zzcu;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88221);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isPasswordLoginSupported());
        SafeParcelWriter.writeStringArray(parcel, 2, getAccountTypes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getCredentialPickerConfig(), i2, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getCredentialHintPickerConfig(), i2, false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzy);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(88221);
    }
}
