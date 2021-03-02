package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.widget.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.h;

public final class d {
    public static boolean a(boolean z, Context context, String str, int i2) {
        AppMethodBeat.i(49041);
        if (z) {
            try {
                if (((ag) g.af(ag.class)).bh(str, i2)) {
                    new c(context).K(context.getResources().getString(R.string.sg)).show();
                    AppMethodBeat.o(49041);
                    return true;
                }
                y(context, z);
            } catch (Exception e2) {
                Log.e("MicroMsg.CollectionModifyInteractLogic", "performClick, (%s %d) added = %b, modify e = %s", str, Integer.valueOf(i2), Boolean.valueOf(z), e2);
                y(context, z);
            }
        } else {
            int bg = ((ag) g.af(ag.class)).bg(str, i2);
            if (bg == 0) {
                new c(context).K(context.getResources().getString(R.string.sf)).show();
                AppMethodBeat.o(49041);
                return true;
            } else if (bg == -2) {
                int bxH = ((ag) g.af(ag.class)).bxH();
                com.tencent.mm.ui.widget.a.d a2 = h.a(context, context.getResources().getString(R.string.k4, Integer.valueOf(bxH)), "", context.getResources().getString(R.string.x_), (DialogInterface.OnClickListener) null);
                if (a2 != null) {
                    a2.setCanceledOnTouchOutside(false);
                    a2.Dh(true);
                }
            } else if (bg == -3) {
                com.tencent.mm.ui.widget.a.d a3 = h.a(context, context.getResources().getString(R.string.i7), "", context.getResources().getString(R.string.x_), (DialogInterface.OnClickListener) null);
                if (a3 != null) {
                    a3.setCanceledOnTouchOutside(false);
                    a3.Dh(true);
                }
            } else {
                y(context, z);
            }
        }
        AppMethodBeat.o(49041);
        return false;
    }

    private static void y(final Context context, final boolean z) {
        AppMethodBeat.i(49042);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.collection.d.AnonymousClass1 */

            public final void run() {
                String string;
                AppMethodBeat.i(49040);
                Context context = context;
                if (z) {
                    string = context.getString(R.string.jm);
                } else {
                    string = context.getString(R.string.jk);
                }
                Toast.makeText(context, string, 0).show();
                AppMethodBeat.o(49040);
            }
        });
        AppMethodBeat.o(49042);
    }
}
