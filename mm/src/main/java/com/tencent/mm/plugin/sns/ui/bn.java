package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;

public final class bn {
    public static void g(Context context, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(99694);
        d.a aVar = new d.a(context);
        aVar.aoO(R.string.hc9);
        aVar.boo(context.getString(R.string.hc_) + "\n\n" + context.getString(R.string.hca));
        aVar.aoV(R.string.j34).c(onClickListener);
        aVar.a(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.sns.ui.bn.AnonymousClass1 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(99693);
                g.aAi();
                g.aAi();
                g.aAh().azQ().set(68385, Integer.valueOf(Util.nullAs((Integer) g.aAh().azQ().get(68385, (Object) null), 0) + 1));
                AppMethodBeat.o(99693);
            }
        });
        aVar.hbn().show();
        AppMethodBeat.o(99694);
    }
}
