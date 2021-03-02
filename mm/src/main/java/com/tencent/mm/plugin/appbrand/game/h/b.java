package com.tencent.mm.plugin.appbrand.game.h;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    private static boolean cuS = false;

    public static void showDialog(Context context) {
        AppMethodBeat.i(45379);
        String str = ae.gKC.gDz;
        if (cuS) {
            Log.i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
            AppMethodBeat.o(45379);
            return;
        }
        String string = MMApplicationContext.getResources().getString(R.string.a0q);
        String string2 = MMApplicationContext.getResources().getString(R.string.zb);
        if (Util.isNullOrNil(str)) {
            str = string;
        }
        a.a(context, str, string2, MMApplicationContext.getResources().getString(R.string.x_), "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.game.h.b.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(45376);
                boolean unused = b.cuS = false;
                AppMethodBeat.o(45376);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.game.h.b.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(45377);
                boolean unused = b.cuS = false;
                AppMethodBeat.o(45377);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.game.h.b.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(45378);
                boolean unused = b.cuS = false;
                AppMethodBeat.o(45378);
            }
        });
        cuS = true;
        AppMethodBeat.o(45379);
    }
}
