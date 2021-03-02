package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CredentialsOptions extends Auth.AuthCredentialsOptions {
    public static final CredentialsOptions DEFAULT = ((CredentialsOptions) new Builder().zzh());

    public static final class Builder extends Auth.AuthCredentialsOptions.Builder {
        public final CredentialsOptions build() {
            AppMethodBeat.i(88235);
            CredentialsOptions credentialsOptions = new CredentialsOptions(this);
            AppMethodBeat.o(88235);
            return credentialsOptions;
        }

        @Override // com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder
        public final Builder forceEnableSaveDialog() {
            this.zzar = Boolean.TRUE;
            return this;
        }

        @Override // com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder
        public final /* synthetic */ Auth.AuthCredentialsOptions zzh() {
            AppMethodBeat.i(88236);
            CredentialsOptions build = build();
            AppMethodBeat.o(88236);
            return build;
        }
    }

    static {
        AppMethodBeat.i(88238);
        AppMethodBeat.o(88238);
    }

    private CredentialsOptions(Builder builder) {
        super(builder);
    }
}
