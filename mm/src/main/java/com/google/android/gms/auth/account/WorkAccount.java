package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzk;
import com.google.android.gms.internal.auth.zzu;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WorkAccount {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("WorkAccount.API", CLIENT_BUILDER, CLIENT_KEY);
    private static final Api.AbstractClientBuilder<zzu, Api.ApiOptions.NoOptions> CLIENT_BUILDER = new zzi();
    private static final Api.ClientKey<zzu> CLIENT_KEY = new Api.ClientKey<>();
    @Deprecated
    public static final WorkAccountApi WorkAccountApi = new zzk();

    static {
        AppMethodBeat.i(10623);
        AppMethodBeat.o(10623);
    }

    private WorkAccount() {
    }

    public static WorkAccountClient getClient(Activity activity) {
        AppMethodBeat.i(10621);
        WorkAccountClient workAccountClient = new WorkAccountClient(activity);
        AppMethodBeat.o(10621);
        return workAccountClient;
    }

    public static WorkAccountClient getClient(Context context) {
        AppMethodBeat.i(10622);
        WorkAccountClient workAccountClient = new WorkAccountClient(context);
        AppMethodBeat.o(10622);
        return workAccountClient;
    }
}
