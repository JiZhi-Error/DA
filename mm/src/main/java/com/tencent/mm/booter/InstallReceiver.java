package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
@Deprecated
public class InstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(19874);
        if (context == null || intent == null) {
            AppMethodBeat.o(19874);
            return;
        }
        String action = intent.getAction();
        Log.i("MicroMsg.InstallReceiver", "action:[%s]", action);
        if (Util.isNullOrNil(action) || !action.equals("com.android.vending.INSTALL_REFERRER")) {
            Log.e("MicroMsg.InstallReceiver", "action is null or nil, or not the installed action");
            AppMethodBeat.o(19874);
            return;
        }
        String str = "";
        try {
            str = intent.getStringExtra("referrer");
        } catch (Exception e2) {
            Log.e("MicroMsg.InstallReceiver", "%s", Util.stackTraceToString(e2));
        }
        Log.i("MicroMsg.InstallReceiver", "get referer:[%s]", str);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.InstallReceiver", "get referer is null or nil");
            AppMethodBeat.o(19874);
            return;
        }
        Log.d("MicroMsg.InstallReceiver", "[PREF] write installreferer = ".concat(String.valueOf(str)));
        context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putString("installreferer", str).commit();
        AppMethodBeat.o(19874);
    }
}
