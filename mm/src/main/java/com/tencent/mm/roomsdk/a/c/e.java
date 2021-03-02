package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.roomsdk.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class e {
    protected a NDM;
    protected a NDN;
    protected a NDO;
    private int NDY = 700;
    private i gNh = new i() {
        /* class com.tencent.mm.roomsdk.a.c.e.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(152786);
            if (qVar instanceof com.tencent.mm.roomsdk.a.a) {
                ((com.tencent.mm.roomsdk.a.a) qVar).a(e.this.NDO);
            }
            if (e.this.NDO != null) {
                e.this.NDO.a(i2, i3, str, e.this.NDO);
            }
            if (i2 == 0 && i3 == 0) {
                if (e.this.NDM != null) {
                    e.this.NDM.a(i2, i3, str, e.this.NDM);
                    AppMethodBeat.o(152786);
                    return;
                }
            } else if (e.this.NDN != null) {
                e.this.NDN.a(i2, i3, str, e.this.NDN);
            }
            AppMethodBeat.o(152786);
        }
    };

    public static e gvQ() {
        AppMethodBeat.i(223904);
        e eVar = new e(700);
        AppMethodBeat.o(223904);
        return eVar;
    }

    private e(int i2) {
        AppMethodBeat.i(223905);
        AppMethodBeat.o(223905);
    }

    public final e e(a aVar) {
        this.NDM = aVar;
        return this;
    }

    public final e f(a aVar) {
        this.NDN = aVar;
        return this;
    }

    public final e gvR() {
        AppMethodBeat.i(152788);
        Log.i("MicroMsg.RoomWatchCallbackFactory", "alive");
        g.aAi();
        g.aAg().hqi.a(this.NDY, this.gNh);
        AppMethodBeat.o(152788);
        return this;
    }

    public final void dead() {
        AppMethodBeat.i(152789);
        Log.i("MicroMsg.RoomWatchCallbackFactory", "dead");
        g.aAi();
        g.aAg().hqi.b(this.NDY, this.gNh);
        AppMethodBeat.o(152789);
    }
}
