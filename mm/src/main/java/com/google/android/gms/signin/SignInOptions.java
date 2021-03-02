package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SignInOptions implements Api.ApiOptions.Optional {
    public static final SignInOptions DEFAULT = new Builder().build();
    private final boolean zzadb;
    private final boolean zzadc;
    private final Long zzadd;
    private final Long zzade;
    private final boolean zzt;
    private final boolean zzv;
    private final String zzw;
    private final String zzx;

    public static final class Builder {
        private boolean zzadf;
        private boolean zzadg;
        private String zzadh;
        private boolean zzadi;
        private String zzadj;
        private boolean zzadk;
        private Long zzadl;
        private Long zzadm;

        private final String zza(String str) {
            AppMethodBeat.i(12142);
            Preconditions.checkNotNull(str);
            Preconditions.checkArgument(this.zzadh == null || this.zzadh.equals(str), "two different server client ids provided");
            AppMethodBeat.o(12142);
            return str;
        }

        public final SignInOptions build() {
            AppMethodBeat.i(12137);
            SignInOptions signInOptions = new SignInOptions(this.zzadf, this.zzadg, this.zzadh, this.zzadi, this.zzadj, this.zzadk, this.zzadl, this.zzadm);
            AppMethodBeat.o(12137);
            return signInOptions;
        }

        public final Builder requestIdToken(String str) {
            AppMethodBeat.i(12139);
            this.zzadg = true;
            this.zzadh = zza(str);
            AppMethodBeat.o(12139);
            return this;
        }

        public final Builder requestServerAuthCode(String str, boolean z) {
            AppMethodBeat.i(12138);
            this.zzadi = z;
            this.zzadf = true;
            this.zzadh = zza(str);
            AppMethodBeat.o(12138);
            return this;
        }

        public final Builder setAuthApiSignInModuleVersion(long j2) {
            AppMethodBeat.i(12140);
            this.zzadl = Long.valueOf(j2);
            AppMethodBeat.o(12140);
            return this;
        }

        public final Builder setHostedDomain(String str) {
            this.zzadj = str;
            return this;
        }

        public final Builder setRealClientLibraryVersion(long j2) {
            AppMethodBeat.i(12141);
            this.zzadm = Long.valueOf(j2);
            AppMethodBeat.o(12141);
            return this;
        }

        public final Builder setWaitForAccessTokenRefresh(boolean z) {
            this.zzadk = z;
            return this;
        }
    }

    static {
        AppMethodBeat.i(12143);
        AppMethodBeat.o(12143);
    }

    private SignInOptions(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
        this.zzadb = z;
        this.zzt = z2;
        this.zzw = str;
        this.zzv = z3;
        this.zzadc = z4;
        this.zzx = str2;
        this.zzadd = l;
        this.zzade = l2;
    }

    public final Long getAuthApiSignInModuleVersion() {
        return this.zzadd;
    }

    public final String getHostedDomain() {
        return this.zzx;
    }

    public final Long getRealClientLibraryVersion() {
        return this.zzade;
    }

    public final String getServerClientId() {
        return this.zzw;
    }

    public final boolean isForceCodeForRefreshToken() {
        return this.zzv;
    }

    public final boolean isIdTokenRequested() {
        return this.zzt;
    }

    public final boolean isOfflineAccessRequested() {
        return this.zzadb;
    }

    public final boolean waitForAccessTokenRefresh() {
        return this.zzadc;
    }
}
