package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Credentials {
    public static CredentialsClient getClient(Activity activity) {
        AppMethodBeat.i(88224);
        CredentialsClient credentialsClient = new CredentialsClient(activity, (Auth.AuthCredentialsOptions) CredentialsOptions.DEFAULT);
        AppMethodBeat.o(88224);
        return credentialsClient;
    }

    public static CredentialsClient getClient(Activity activity, CredentialsOptions credentialsOptions) {
        AppMethodBeat.i(88225);
        CredentialsClient credentialsClient = new CredentialsClient(activity, (Auth.AuthCredentialsOptions) credentialsOptions);
        AppMethodBeat.o(88225);
        return credentialsClient;
    }

    public static CredentialsClient getClient(Context context) {
        AppMethodBeat.i(88226);
        CredentialsClient credentialsClient = new CredentialsClient(context, CredentialsOptions.DEFAULT);
        AppMethodBeat.o(88226);
        return credentialsClient;
    }

    public static CredentialsClient getClient(Context context, CredentialsOptions credentialsOptions) {
        AppMethodBeat.i(88227);
        CredentialsClient credentialsClient = new CredentialsClient(context, credentialsOptions);
        AppMethodBeat.o(88227);
        return credentialsClient;
    }
}
