package com.tencent.mm.contact.a.a;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public final class b extends a {
    q gNg;
    i gNh = new i() {
        /* class com.tencent.mm.contact.a.a.b.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0128  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0154  */
        @Override // com.tencent.mm.ak.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.q r12) {
            /*
            // Method dump skipped, instructions count: 403
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.contact.a.a.b.AnonymousClass1.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
        }
    };

    public b(boolean z) {
        AppMethodBeat.i(257893);
        this.gNf = z;
        AppMethodBeat.o(257893);
    }

    public final void a(k.b bVar) {
        AppMethodBeat.i(257894);
        if (this.gNf) {
            this.gNg = new l(bVar);
            AppMethodBeat.o(257894);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(bVar);
        this.gNg = new c(linkedList);
        AppMethodBeat.o(257894);
    }

    @Override // com.tencent.mm.model.aq
    public final void i(Context context, String str, String str2) {
        AppMethodBeat.i(257895);
        if (this.gNg == null) {
            AppMethodBeat.o(257895);
            return;
        }
        this.tipDialog = h.a(context, str2, false, (DialogInterface.OnCancelListener) null);
        if (this.gNg != null) {
            Log.i("MicroMsg.ContactSyncOpLogCallbackFactory", "request scene %s", this.gNg);
            if (this.tipDialog != null || !this.gNc.isEmpty() || !this.gNd.isEmpty() || !this.gNe.isEmpty()) {
                g.aAi();
                g.aAg().hqi.a(this.gNg.getType(), this.gNh);
            }
            g.aAi();
            g.aAg().hqi.a(this.gNg, 0);
        }
        AppMethodBeat.o(257895);
    }
}
