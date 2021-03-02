package com.tencent.mm.plugin.profile.ui.newbizinfo.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(27581);
        if ("//usenewprofile".equals(strArr[0])) {
            SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
            if (strArr.length <= 1) {
                defaultPreference.edit().putBoolean("use_new_profile", true).commit();
                AppMethodBeat.o(27581);
            } else {
                String str2 = strArr[1];
                char c2 = 65535;
                switch (str2.hashCode()) {
                    case 3569038:
                        if (str2.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 97196323:
                        if (str2.equals("false")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        defaultPreference.edit().putBoolean("use_new_profile", true).commit();
                        break;
                    case 1:
                        defaultPreference.edit().putBoolean("use_new_profile", false).commit();
                        break;
                }
                AppMethodBeat.o(27581);
            }
        } else {
            AppMethodBeat.o(27581);
        }
        return true;
    }
}
