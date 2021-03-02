package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ba.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public final class d extends a {
    c NDW;
    i gNh = new i() {
        /* class com.tencent.mm.roomsdk.a.c.d.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0083  */
        @Override // com.tencent.mm.ak.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.q r12) {
            /*
            // Method dump skipped, instructions count: 194
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.roomsdk.a.c.d.AnonymousClass1.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
        }
    };

    public d() {
        AppMethodBeat.i(223899);
        this.NDL = true;
        AppMethodBeat.o(223899);
    }

    @Override // com.tencent.mm.roomsdk.a.c.a
    public final void cancel() {
        AppMethodBeat.i(223900);
        if (this.NDW == null) {
            AppMethodBeat.o(223900);
            return;
        }
        g.aAi();
        g.aAg().hqi.a(this.NDW);
        g.aAi();
        g.aAg().hqi.b(this.NDW.getType(), this.gNh);
        AppMethodBeat.o(223900);
    }

    public final void a(k.b bVar) {
        AppMethodBeat.i(223901);
        LinkedList linkedList = new LinkedList();
        linkedList.add(bVar);
        this.NDW = new c(linkedList);
        AppMethodBeat.o(223901);
    }

    @Override // com.tencent.mm.roomsdk.a.c.a
    public final void aJu() {
        AppMethodBeat.i(223902);
        if (this.NDW == null) {
            AppMethodBeat.o(223902);
            return;
        }
        Log.i("MicroMsg.RoomCallbackFactory", "request scene %s", this.NDW);
        if (!(this.tipDialog == null && this.NDM == null && this.NDN == null && this.NDO == null)) {
            g.aAi();
            g.aAg().hqi.a(this.NDW.getType(), this.gNh);
        }
        g.aAi();
        g.aAg().hqi.a(this.NDW, 0);
        AppMethodBeat.o(223902);
    }

    @Override // com.tencent.mm.roomsdk.a.c.a
    public final void a(Context context, String str, String str2, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(223903);
        if (this.NDW == null) {
            AppMethodBeat.o(223903);
            return;
        }
        this.tipDialog = h.a(context, str2, z2, onCancelListener);
        aJu();
        AppMethodBeat.o(223903);
    }
}
