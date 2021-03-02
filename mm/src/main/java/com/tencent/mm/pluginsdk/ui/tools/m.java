package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.ui.base.h;

public final class m {
    public static boolean iC(final Context context) {
        AppMethodBeat.i(152416);
        if (!MMEntryLock.lock("network_doctor_shown")) {
            AppMethodBeat.o(152416);
            return false;
        }
        h.a(context, (int) R.string.fbo, (int) R.string.zb, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.tools.m.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(152415);
                Context context = context;
                a bl = new a().bl(new Intent("android.settings.WIRELESS_SETTINGS"));
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/tools/NetworkErrAlert$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/tools/NetworkErrAlert$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(152415);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(152416);
        return true;
    }
}
