package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CurrentAccessTokenExpirationBroadcastReceiver extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(17009);
        if (AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED.equals(intent.getAction())) {
            AccessTokenManager.getInstance().currentAccessTokenChanged();
        }
        AppMethodBeat.o(17009);
    }
}
