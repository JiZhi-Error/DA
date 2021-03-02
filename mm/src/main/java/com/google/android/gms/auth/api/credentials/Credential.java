package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import javax.annotation.Nonnull;

@SafeParcelable.Class(creator = "CredentialCreator")
@SafeParcelable.Reserved({1000})
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zzd();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    @SafeParcelable.Field(getter = "getName", id = 2)
    private final String mName;
    @SafeParcelable.Field(getter = "getAccountType", id = 6)
    private final String zzbx;
    @Nonnull
    @SafeParcelable.Field(getter = "getId", id = 1)
    private final String zzci;
    @SafeParcelable.Field(getter = "getProfilePictureUri", id = 3)
    private final Uri zzcj;
    @Nonnull
    @SafeParcelable.Field(getter = "getIdTokens", id = 4)
    private final List<IdToken> zzck;
    @SafeParcelable.Field(getter = "getPassword", id = 5)
    private final String zzcl;
    @SafeParcelable.Field(getter = "getGeneratedPassword", id = 7)
    private final String zzcm;
    @SafeParcelable.Field(getter = "getGeneratedHintId", id = 8)
    private final String zzcn;
    @SafeParcelable.Field(getter = "getGivenName", id = 9)
    private final String zzco;
    @SafeParcelable.Field(getter = "getFamilyName", id = 10)
    private final String zzcp;

    public static class Builder {
        private String mName;
        private String zzbx;
        private final String zzci;
        private Uri zzcj;
        private List<IdToken> zzck;
        private String zzcl;
        private String zzcm;
        private String zzcn;
        private String zzco;
        private String zzcp;

        public Builder(Credential credential) {
            AppMethodBeat.i(88203);
            this.zzci = credential.zzci;
            this.mName = credential.mName;
            this.zzcj = credential.zzcj;
            this.zzck = credential.zzck;
            this.zzcl = credential.zzcl;
            this.zzbx = credential.zzbx;
            this.zzcm = credential.zzcm;
            this.zzcn = credential.zzcn;
            this.zzco = credential.zzco;
            this.zzcp = credential.zzcp;
            AppMethodBeat.o(88203);
        }

        public Builder(String str) {
            this.zzci = str;
        }

        public Credential build() {
            AppMethodBeat.i(88204);
            Credential credential = new Credential(this.zzci, this.mName, this.zzcj, this.zzck, this.zzcl, this.zzbx, this.zzcm, this.zzcn, this.zzco, this.zzcp);
            AppMethodBeat.o(88204);
            return credential;
        }

        public Builder setAccountType(String str) {
            this.zzbx = str;
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPassword(String str) {
            this.zzcl = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.zzcj = uri;
            return this;
        }
    }

    static {
        AppMethodBeat.i(88209);
        AppMethodBeat.o(88209);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Credential(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) java.lang.String r5, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) java.lang.String r6, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) android.net.Uri r7, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) java.util.List<com.google.android.gms.auth.api.credentials.IdToken> r8, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 5) java.lang.String r9, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 6) java.lang.String r10, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 7) java.lang.String r11, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 8) java.lang.String r12, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 9) java.lang.String r13, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 10) java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 221
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.Credential.<init>(java.lang.String, java.lang.String, android.net.Uri, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(88207);
        if (this == obj) {
            AppMethodBeat.o(88207);
            return true;
        } else if (!(obj instanceof Credential)) {
            AppMethodBeat.o(88207);
            return false;
        } else {
            Credential credential = (Credential) obj;
            if (!TextUtils.equals(this.zzci, credential.zzci) || !TextUtils.equals(this.mName, credential.mName) || !Objects.equal(this.zzcj, credential.zzcj) || !TextUtils.equals(this.zzcl, credential.zzcl) || !TextUtils.equals(this.zzbx, credential.zzbx) || !TextUtils.equals(this.zzcm, credential.zzcm)) {
                AppMethodBeat.o(88207);
                return false;
            }
            AppMethodBeat.o(88207);
            return true;
        }
    }

    public String getAccountType() {
        return this.zzbx;
    }

    public String getFamilyName() {
        return this.zzcp;
    }

    public String getGeneratedPassword() {
        return this.zzcm;
    }

    public String getGivenName() {
        return this.zzco;
    }

    @Nonnull
    public String getId() {
        return this.zzci;
    }

    @Nonnull
    public List<IdToken> getIdTokens() {
        return this.zzck;
    }

    public String getName() {
        return this.mName;
    }

    public String getPassword() {
        return this.zzcl;
    }

    public Uri getProfilePictureUri() {
        return this.zzcj;
    }

    public int hashCode() {
        AppMethodBeat.i(88208);
        int hashCode = Objects.hashCode(this.zzci, this.mName, this.zzcj, this.zzcl, this.zzbx, this.zzcm);
        AppMethodBeat.o(88208);
        return hashCode;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(88206);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getProfilePictureUri(), i2, false);
        SafeParcelWriter.writeTypedList(parcel, 4, getIdTokens(), false);
        SafeParcelWriter.writeString(parcel, 5, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 6, getAccountType(), false);
        SafeParcelWriter.writeString(parcel, 7, getGeneratedPassword(), false);
        SafeParcelWriter.writeString(parcel, 8, this.zzcn, false);
        SafeParcelWriter.writeString(parcel, 9, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 10, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(88206);
    }
}
