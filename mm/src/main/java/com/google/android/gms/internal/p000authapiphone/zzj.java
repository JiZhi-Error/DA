package com.google.android.gms.internal.p000authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzj  reason: invalid package */
public final class zzj extends SmsRetrieverClient {
    public zzj(Activity activity) {
        super(activity);
    }

    public zzj(Context context) {
        super(context);
    }

    @Override // com.google.android.gms.auth.api.phone.SmsRetrieverApi, com.google.android.gms.auth.api.phone.SmsRetrieverClient
    public final Task<Void> startSmsRetriever() {
        AppMethodBeat.i(940);
        Task<Void> doWrite = doWrite(new zzk(this));
        AppMethodBeat.o(940);
        return doWrite;
    }
}
