package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzaw {
    public static PendingIntent zzd(Context context, Auth.AuthCredentialsOptions authCredentialsOptions, HintRequest hintRequest) {
        AppMethodBeat.i(88380);
        Preconditions.checkNotNull(context, "context must not be null");
        Preconditions.checkNotNull(hintRequest, "request must not be null");
        PasswordSpecification zzg = (authCredentialsOptions == null || authCredentialsOptions.zzg() == null) ? PasswordSpecification.zzdg : authCredentialsOptions.zzg();
        Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("com.google.android.gms.credentials.hintRequestVersion", 2).putExtra("com.google.android.gms.credentials.RequestType", "Hints").putExtra("com.google.android.gms.credentials.ClaimedCallingPackage", (String) null);
        SafeParcelableSerializer.serializeToIntentExtra(zzg, putExtra, "com.google.android.gms.credentials.PasswordSpecification");
        SafeParcelableSerializer.serializeToIntentExtra(hintRequest, putExtra, "com.google.android.gms.credentials.HintRequest");
        PendingIntent activity = PendingIntent.getActivity(context, 2000, putExtra, 134217728);
        AppMethodBeat.o(88380);
        return activity;
    }
}
