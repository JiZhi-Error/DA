package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FirebaseInstanceIdService extends zzb {
    /* access modifiers changed from: protected */
    @Override // com.google.firebase.iid.zzb
    public final Intent e(Intent intent) {
        AppMethodBeat.i(4146);
        Intent poll = o.yr().bLO.poll();
        AppMethodBeat.o(4146);
        return poll;
    }

    public void onTokenRefresh() {
    }

    @Override // com.google.firebase.iid.zzb
    public final void f(Intent intent) {
        AppMethodBeat.i(4147);
        if ("com.google.firebase.iid.TOKEN_REFRESH".equals(intent.getAction())) {
            onTokenRefresh();
            AppMethodBeat.o(4147);
            return;
        }
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length()).append("Received command: ").append(stringExtra).append(" - ").append(valueOf);
            }
            if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                FirebaseInstanceId.yc().yh();
                AppMethodBeat.o(4147);
                return;
            } else if ("SYNC".equals(stringExtra)) {
                FirebaseInstanceId yc = FirebaseInstanceId.yc();
                FirebaseInstanceId.bLg.bQ("");
                yc.startSync();
            }
        }
        AppMethodBeat.o(4147);
    }
}
