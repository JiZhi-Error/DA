package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.dde;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.f;

public final class ah {
    public static String aeo(int i2) {
        AppMethodBeat.i(68551);
        Context context = MMApplicationContext.getContext();
        String str = "";
        switch (i2) {
            case 0:
                str = context.getString(R.string.ihs);
                break;
            case 1:
                str = context.getString(R.string.iha);
                break;
            case 2:
                str = context.getString(R.string.ihb);
                break;
            case 3:
                str = context.getString(R.string.ih9);
                break;
            case 4:
                str = context.getString(R.string.ih_);
                break;
        }
        AppMethodBeat.o(68551);
        return str;
    }

    public static void a(final Context context, final dde dde) {
        AppMethodBeat.i(68552);
        if (dde == null) {
            AppMethodBeat.o(68552);
            return;
        }
        d.a aVar = new d.a(context);
        aVar.boo(dde.dQx);
        if (!Util.isNullOrNil(dde.MIh)) {
            aVar.bov(dde.MIh);
        }
        if (!Util.isNullOrNil(dde.HFD)) {
            aVar.bou(dde.HFD);
        }
        aVar.Dk(false);
        aVar.a(true, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.model.lqt.ah.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(68550);
                Log.i("MicroMsg.LqtUtil", "click item, type: %s", Integer.valueOf(dde.type));
                if (dde.type != 1) {
                    if (dde.type == 2) {
                        f.p(context, dde.HLy, true);
                        AppMethodBeat.o(68550);
                        return;
                    } else if (dde.type == 3) {
                        f.u(dde.Hwr, dde.Hws, 0, 1061);
                    }
                }
                AppMethodBeat.o(68550);
            }
        });
        aVar.hbn().show();
        AppMethodBeat.o(68552);
    }
}
