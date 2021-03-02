package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.roomsdk.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

public final class b extends a {
    public q gNg;
    i gNh = new i() {
        /* class com.tencent.mm.roomsdk.a.c.b.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(152774);
            if (b.this.gNg.equals(qVar)) {
                g.aAi();
                g.aAg().hqi.b(qVar.getType(), b.this.gNh);
                if (b.this.tipDialog != null) {
                    b.this.tipDialog.dismiss();
                }
                if (qVar instanceof a) {
                    ((a) qVar).a(b.this.NDO);
                }
                if (b.this.NDO != null) {
                    b.this.NDO.a(i2, i3, str, b.this.NDO);
                }
                if (i2 == 0 && i3 == 0) {
                    if (b.this.NDM != null) {
                        b.this.NDM.a(i2, i3, str, b.this.NDM);
                        AppMethodBeat.o(152774);
                        return;
                    }
                } else if (b.this.NDN != null) {
                    b.this.NDN.a(i2, i3, str, b.this.NDN);
                }
            }
            AppMethodBeat.o(152774);
        }
    };

    public b(boolean z) {
        AppMethodBeat.i(152775);
        this.NDL = z;
        AppMethodBeat.o(152775);
    }

    @Override // com.tencent.mm.roomsdk.a.c.a
    public final void cancel() {
        AppMethodBeat.i(152776);
        if (this.gNg == null) {
            AppMethodBeat.o(152776);
            return;
        }
        g.aAi();
        g.aAg().hqi.a(this.gNg);
        g.aAi();
        g.aAg().hqi.b(this.gNg.getType(), this.gNh);
        AppMethodBeat.o(152776);
    }

    @Override // com.tencent.mm.roomsdk.a.c.a
    public final void aJu() {
        AppMethodBeat.i(152777);
        if (this.gNg == null) {
            AppMethodBeat.o(152777);
            return;
        }
        Log.i("MicroMsg.RoomCallbackFactory", "request scene %s", this.gNg);
        if (!(this.tipDialog == null && this.NDM == null && this.NDN == null && this.NDO == null)) {
            g.aAi();
            g.aAg().hqi.a(this.gNg.getType(), this.gNh);
        }
        g.aAi();
        g.aAg().hqi.a(this.gNg, 0);
        AppMethodBeat.o(152777);
    }

    @Override // com.tencent.mm.roomsdk.a.c.a
    public final void a(Context context, String str, String str2, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(223896);
        if (this.gNg == null) {
            AppMethodBeat.o(223896);
            return;
        }
        this.tipDialog = h.a(context, str2, z2, onCancelListener);
        aJu();
        AppMethodBeat.o(223896);
    }
}
