package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzf extends Handler {
    private final /* synthetic */ GoogleCloudMessaging zzai;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzf(GoogleCloudMessaging googleCloudMessaging, Looper looper) {
        super(looper);
        this.zzai = googleCloudMessaging;
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.i(3705);
        if (message != null) {
            Object obj = message.obj;
        }
        Intent intent = (Intent) message.obj;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            this.zzai.zzag.add(intent);
            AppMethodBeat.o(3705);
            return;
        }
        if (!GoogleCloudMessaging.zzd(this.zzai, intent)) {
            intent.setPackage(this.zzai.zzk.getPackageName());
            this.zzai.zzk.sendBroadcast(intent);
        }
        AppMethodBeat.o(3705);
    }
}
