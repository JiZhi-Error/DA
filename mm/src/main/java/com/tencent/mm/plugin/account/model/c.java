package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class c implements i, j {
    public Context context;
    public q dGJ;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    public a kio;
    public com.tencent.mm.ui.base.q tipDialog;

    public interface a {
        void boN();
    }

    public c(Context context2, a aVar) {
        AppMethodBeat.i(127826);
        this.context = context2;
        this.kio = aVar;
        AppMethodBeat.o(127826);
    }

    @Override // com.tencent.mm.ak.j
    public final void a(int i2, int i3, q qVar) {
        AppMethodBeat.i(127827);
        final int i4 = i3 != 0 ? (int) ((((long) i2) * 100) / ((long) i3)) : 0;
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.account.model.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(127825);
                if (c.this.tipDialog != null) {
                    c.this.tipDialog.setMessage(c.this.context.getString(R.string.wd) + i4 + "%");
                }
                AppMethodBeat.o(127825);
            }
        });
        AppMethodBeat.o(127827);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127828);
        if (qVar.getType() == 139) {
            g.azz().b(b.CTRL_INDEX, this);
        } else if (qVar.getType() == 138) {
            g.azz().b(138, this);
        }
        if (i3 == 0 && i2 == 0) {
            this.kio.boN();
        } else {
            Log.e("MicroMsg.DoInit", "do init failed, err=" + i2 + "," + i3);
            this.kio.boN();
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(127828);
    }
}
