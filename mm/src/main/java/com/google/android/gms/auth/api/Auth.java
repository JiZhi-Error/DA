package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzao;
import com.google.android.gms.internal.auth.zzax;
import com.google.android.gms.internal.auth.zzbn;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", zzal, zzaj);
    public static final CredentialsApi CredentialsApi = new zzao();
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", zzam, zzak);
    public static final GoogleSignInApi GoogleSignInApi = new zzg();
    @KeepForSdk
    public static final Api<zzh> PROXY_API = zzf.API;
    @KeepForSdk
    public static final ProxyApi ProxyApi = new zzbn();
    public static final Api.ClientKey<zzax> zzaj = new Api.ClientKey<>();
    public static final Api.ClientKey<zzh> zzak = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzax, AuthCredentialsOptions> zzal = new zzd();
    private static final Api.AbstractClientBuilder<zzh, GoogleSignInOptions> zzam = new zze();

    @Deprecated
    public static class AuthCredentialsOptions implements Api.ApiOptions.Optional {
        private static final AuthCredentialsOptions zzan = new Builder().zzh();
        private final String zzao = null;
        private final PasswordSpecification zzap;
        private final boolean zzaq;

        @Deprecated
        public static class Builder {
            protected PasswordSpecification zzap = PasswordSpecification.zzdg;
            protected Boolean zzar = Boolean.FALSE;

            public Builder forceEnableSaveDialog() {
                this.zzar = Boolean.TRUE;
                return this;
            }

            public AuthCredentialsOptions zzh() {
                AppMethodBeat.i(88198);
                AuthCredentialsOptions authCredentialsOptions = new AuthCredentialsOptions(this);
                AppMethodBeat.o(88198);
                return authCredentialsOptions;
            }
        }

        static {
            AppMethodBeat.i(88201);
            AppMethodBeat.o(88201);
        }

        public AuthCredentialsOptions(Builder builder) {
            AppMethodBeat.i(88199);
            this.zzap = builder.zzap;
            this.zzaq = builder.zzar.booleanValue();
            AppMethodBeat.o(88199);
        }

        public final Bundle toBundle() {
            AppMethodBeat.i(88200);
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putParcelable("password_specification", this.zzap);
            bundle.putBoolean("force_save_dialog", this.zzaq);
            AppMethodBeat.o(88200);
            return bundle;
        }

        public final PasswordSpecification zzg() {
            return this.zzap;
        }
    }

    static {
        AppMethodBeat.i(88202);
        AppMethodBeat.o(88202);
    }

    private Auth() {
    }
}
