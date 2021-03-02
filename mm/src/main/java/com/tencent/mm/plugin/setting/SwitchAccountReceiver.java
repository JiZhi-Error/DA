package com.tencent.mm.plugin.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;

public class SwitchAccountReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(73757);
        if (context == null || intent == null) {
            AppMethodBeat.o(73757);
            return;
        }
        String stringExtra = intent.getStringExtra("switch_process_action_code_key");
        Log.i("MicroMsg.SwitchAccountReceiver", "onReceive, action %s", stringExtra);
        if (Util.isNullOrNil(stringExtra)) {
            AppMethodBeat.o(73757);
            return;
        }
        if (stringExtra.equals("action_reload_resources")) {
            String stringExtra2 = intent.getStringExtra("switch_language");
            Log.i("MicroMsg.SwitchAccountReceiver", "onReceive, language %s", stringExtra2);
            Locale transLanguageToLocale = LocaleUtil.transLanguageToLocale(stringExtra2);
            if (LocaleUtil.LANGUAGE_DEFAULT.equalsIgnoreCase(stringExtra2)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    transLanguageToLocale = LocaleUtil.sysDefaultLocale;
                    Locale.setDefault(transLanguageToLocale);
                } else {
                    transLanguageToLocale = Locale.getDefault();
                }
            }
            LocaleUtil.updateApplicationResourceLocale(context.getApplicationContext(), transLanguageToLocale);
            MMApplicationContext.setResources(b.a(context.getApplicationContext().getResources(), context.getApplicationContext(), stringExtra2));
        }
        AppMethodBeat.o(73757);
    }
}
