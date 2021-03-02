package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.ui.base.h;

public final class a extends d {
    public a(Context context, String str, String str2, d.a aVar) {
        super(context, str, str2, aVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.base.stub.d
    public final void cjQ() {
        AppMethodBeat.i(22165);
        h.a(this.context, (int) R.string.drx, (int) R.string.zb, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.base.stub.a.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(22164);
                b dSQ = b.a.dSQ();
                if (dSQ != null) {
                    dSQ.k(a.this.openId, z.aUb(), a.this.appId);
                }
                a.this.pdr.jZ(false);
                AppMethodBeat.o(22164);
            }
        });
        AppMethodBeat.o(22165);
    }
}
