package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* access modifiers changed from: package-private */
public abstract class zzav<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzax> {
    zzav(GoogleApiClient googleApiClient) {
        super(Auth.CREDENTIALS_API, googleApiClient);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public /* synthetic */ void doExecute(zzax zzax) {
        zzax zzax2 = zzax;
        zzd(zzax2.getContext(), (zzbc) zzax2.getService());
    }

    /* access modifiers changed from: protected */
    public abstract void zzd(Context context, zzbc zzbc);
}
