package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.f;

public final class b {
    public static void i(Activity activity, String str) {
        AppMethodBeat.i(66369);
        if (TextUtils.isEmpty(str)) {
            str = activity.getString(R.string.itf);
        }
        h.a((Context) activity, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.offline.ui.b.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(66365);
                dialogInterface.dismiss();
                AppMethodBeat.o(66365);
            }
        });
        AppMethodBeat.o(66369);
    }

    public static void d(final Activity activity, String str, final String str2) {
        String str3;
        AppMethodBeat.i(66370);
        if (TextUtils.isEmpty(str)) {
            str3 = activity.getString(R.string.itf);
        } else {
            str3 = str;
        }
        if (!Util.isNullOrNil(str2)) {
            Log.i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
            h.a((Context) activity, str3, (String) null, activity.getResources().getString(R.string.icb), activity.getResources().getString(R.string.x_), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.offline.ui.b.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(66366);
                    f.bn(activity, str2);
                    f.aqm(3);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(66366);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.offline.ui.b.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(66367);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(66367);
                }
            });
            AppMethodBeat.o(66370);
            return;
        }
        i(activity, str3);
        AppMethodBeat.o(66370);
    }

    public static void ax(final Activity activity) {
        AppMethodBeat.i(66371);
        Log.e("MicroMsg.OfflineErrorHelper", "offline code size is 0, show check network error dialog");
        h.a((Context) activity, activity.getString(R.string.ius), (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.offline.ui.b.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(66368);
                if (activity instanceof WalletOfflineCoinPurseUI) {
                    ((WalletOfflineCoinPurseUI) activity).AMq = false;
                }
                dialogInterface.dismiss();
                AppMethodBeat.o(66368);
            }
        });
        AppMethodBeat.o(66371);
    }
}
