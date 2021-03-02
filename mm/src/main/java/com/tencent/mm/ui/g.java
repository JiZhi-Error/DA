package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.k;

public final class g {
    public static void c(final Context context, final Runnable runnable) {
        AppMethodBeat.i(232469);
        if (com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_CONVERSATION_DISMISS_INTRO_BOOLEAN_SYNC, true)) {
            final k kVar = new k(context);
            kVar.bmc(context.getString(R.string.eup)).bmd(context.getString(R.string.euo)).g(new View.OnClickListener() {
                /* class com.tencent.mm.ui.g.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(232467);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/DismissConversationHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    kVar.bMo();
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_CONVERSATION_DISMISS_INTRO_BOOLEAN_SYNC, Boolean.FALSE);
                    g.d(context, runnable);
                    a.a(this, "com/tencent/mm/ui/DismissConversationHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(232467);
                }
            });
            kVar.dGm();
            AppMethodBeat.o(232469);
            return;
        }
        d(context, runnable);
        AppMethodBeat.o(232469);
    }

    static void d(Context context, final Runnable runnable) {
        AppMethodBeat.i(232470);
        h.a(context, context.getString(R.string.eum), "", context.getString(R.string.eun), context.getString(R.string.sz), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.g.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(232468);
                runnable.run();
                AppMethodBeat.o(232468);
            }
        }, (DialogInterface.OnClickListener) null, (int) R.color.cd);
        AppMethodBeat.o(232470);
    }
}
