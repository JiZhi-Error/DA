package com.tencent.mm.plugin.base.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

public class ShortcutBroadCastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(151431);
        if (intent == null) {
            Log.e("MicroMsg.ShortcutBroadCastReceiver", "alvinluo shortcut receiver intent is null");
            AppMethodBeat.o(151431);
            return;
        }
        h.cD(context, context.getString(R.string.h9));
        AppMethodBeat.o(151431);
    }
}
