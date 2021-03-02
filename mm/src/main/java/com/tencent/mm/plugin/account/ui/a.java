package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class a {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean a(final Activity activity, int i2, int i3, final Intent intent, String str) {
        Map<String, String> parseXml;
        AppMethodBeat.i(196861);
        if (i2 != 4) {
            AppMethodBeat.o(196861);
            return false;
        }
        Log.i("MicroMsg.AccountExpiredUtil", "errType = " + i2 + " errCode = " + i3);
        switch (i3) {
            case -205:
            case -72:
            case -9:
            case -4:
            case -3:
                Log.e("MicroMsg.AccountExpiredUtil", "account expired=".concat(String.valueOf(i3)));
                if (!boV()) {
                    h.a(activity, (int) R.string.ev7, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.a.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(196858);
                            if (intent != null) {
                                activity.finish();
                                Activity activity = activity;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                activity.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                b.az(activity, intent);
                                t.ds(activity);
                            }
                            AppMethodBeat.o(196858);
                        }
                    });
                } else if (intent != null) {
                    activity.finish();
                    intent.putExtra("key_errType", i2);
                    intent.putExtra("key_errCode", i3);
                    intent.putExtra("key_errMsg", MMApplicationContext.getContext().getString(R.string.ev7));
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil", "accountExpired", "(Landroid/app/Activity;IILandroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil", "accountExpired", "(Landroid/app/Activity;IILandroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    b.az(activity, intent);
                    t.ds(activity);
                }
                AppMethodBeat.o(196861);
                return true;
            case -140:
            case -104:
                Log.e("MicroMsg.AccountExpiredUtil", "accout errCode[%d], errMsg[%s]", Integer.valueOf(i3), str);
                if (Util.isNullOrNil(str) || !str.startsWith("autoauth_errmsg_")) {
                    if (i3 == -104) {
                        Log.i("MicroMsg.AccountExpiredUtil", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", str);
                        break;
                    }
                } else {
                    str = str.substring(16);
                }
                if (!Util.isNullOrNil(str) && str.startsWith("<") && (parseXml = XmlParser.parseXml(str, "e", null)) != null && !Util.isNullOrNil(parseXml.get(".e.Content"))) {
                    str = parseXml.get(".e.Content");
                }
                if (Util.isNullOrNil(str)) {
                    str = MMApplicationContext.getContext().getString(R.string.ev7);
                }
                h.d(activity, str, MMApplicationContext.getContext().getString(R.string.zb), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.a.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(196860);
                        if (intent != null) {
                            activity.finish();
                            Activity activity = activity;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            b.az(activity, intent);
                            t.ds(activity);
                        }
                        AppMethodBeat.o(196860);
                    }
                });
                AppMethodBeat.o(196861);
                return true;
            case -75:
                Log.e("MicroMsg.AccountExpiredUtil", "account expired=".concat(String.valueOf(i3)));
                h.a(activity, (int) R.string.gz, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.a.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(196859);
                        if (intent != null) {
                            activity.finish();
                            Activity activity = activity;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            b.az(activity, intent);
                            t.ds(activity);
                        }
                        AppMethodBeat.o(196859);
                    }
                });
                AppMethodBeat.o(196861);
                return true;
        }
        AppMethodBeat.o(196861);
        return false;
    }

    public static boolean dJ(int i2, int i3) {
        AppMethodBeat.i(196862);
        if (i3 == -100 || i3 == -2023) {
            Log.i("MicroMsg.AccountExpiredUtil", "process,errType %d,errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(196862);
            return true;
        }
        AppMethodBeat.o(196862);
        return false;
    }

    public static boolean dK(int i2, int i3) {
        if ((i3 == -100 || i3 == -2023 || i3 == -3 || i3 == -4 || i3 == -9 || i3 == -205 || i3 == -72) && i2 == 4) {
            return true;
        }
        return false;
    }

    private static boolean boV() {
        boolean z;
        AppMethodBeat.i(196863);
        try {
            z = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_account_expired_enable, false);
            Log.i("MicroMsg.AccountExpiredUtil", "accountExpriredEnable is: %s!!", Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AccountExpiredUtil", e2, "accountExpriredEnable", new Object[0]);
            z = false;
        }
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            z = true;
        }
        AppMethodBeat.o(196863);
        return z;
    }
}
