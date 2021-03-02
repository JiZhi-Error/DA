package com.google.android.gms.signin;

import android.os.Bundle;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class SignIn {
    public static final Api<SignInOptions> API = new Api<>("SignIn.API", CLIENT_BUILDER, CLIENT_KEY);
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> CLIENT_BUILDER = new zza();
    public static final Api.ClientKey<SignInClientImpl> CLIENT_KEY = new Api.ClientKey<>();
    public static final Api<SignInOptionsInternal> INTERNAL_API = new Api<>("SignIn.INTERNAL_API", zzacz, INTERNAL_CLIENT_KEY);
    public static final Api.ClientKey<SignInClientImpl> INTERNAL_CLIENT_KEY = new Api.ClientKey<>();
    public static final Scope SCOPE_EMAIL = new Scope(Scopes.EMAIL);
    public static final Scope SCOPE_PROFILE = new Scope(Scopes.PROFILE);
    private static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptionsInternal> zzacz = new zzb();

    public static class SignInOptionsInternal implements Api.ApiOptions.HasOptions {
        private final Bundle zzada;

        private SignInOptionsInternal(Bundle bundle) {
            AppMethodBeat.i(12135);
            this.zzada = bundle == null ? new Bundle() : bundle;
            AppMethodBeat.o(12135);
        }

        public static SignInOptionsInternal create(Bundle bundle) {
            AppMethodBeat.i(12134);
            SignInOptionsInternal signInOptionsInternal = new SignInOptionsInternal(bundle);
            AppMethodBeat.o(12134);
            return signInOptionsInternal;
        }

        public Bundle getSignInOptionsBundle() {
            return this.zzada;
        }
    }

    static {
        AppMethodBeat.i(12136);
        AppMethodBeat.o(12136);
    }

    private SignIn() {
    }
}
