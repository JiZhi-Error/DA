package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(17010);
        String stringExtra = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID);
        String stringExtra2 = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION);
        if (!(stringExtra == null || stringExtra2 == null)) {
            Bundle extras = intent.getExtras();
            if (NativeProtocol.isErrorResult(intent)) {
                onFailedAppCall(stringExtra, stringExtra2, extras);
                AppMethodBeat.o(17010);
                return;
            }
            onSuccessfulAppCall(stringExtra, stringExtra2, extras);
        }
        AppMethodBeat.o(17010);
    }

    /* access modifiers changed from: protected */
    public void onSuccessfulAppCall(String str, String str2, Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onFailedAppCall(String str, String str2, Bundle bundle) {
    }
}
