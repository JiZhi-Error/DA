package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.ui.base.m;
import java.util.Iterator;

public final class c {
    i xxA;
    b xxB;
    public d xxC = new d(this.xxA.mContext);

    public c(i iVar, b bVar) {
        AppMethodBeat.i(83101);
        this.xxA = iVar;
        this.xxB = bVar;
        this.xxC.Jsa = new b.AbstractC1995b() {
            /* class com.tencent.mm.plugin.game.luggage.e.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.game.menu.b.AbstractC1995b
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(83099);
                c cVar = c.this;
                b bVar = cVar.xxB;
                i iVar = cVar.xxA;
                for (coq coq : bVar.xxx) {
                    if (coq == null) {
                        mVar.d(-1, "");
                    } else {
                        a aVar = bVar.xxy.get(Integer.valueOf(coq.KWb));
                        if (aVar != null) {
                            aVar.a(iVar, mVar, coq);
                        }
                    }
                }
                AppMethodBeat.o(83099);
            }
        };
        this.xxC.a(new b.c() {
            /* class com.tencent.mm.plugin.game.luggage.e.a.c.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c
            public final void c(MenuItem menuItem) {
                coq coq;
                AppMethodBeat.i(83100);
                c cVar = c.this;
                b bVar = cVar.xxB;
                Context context = cVar.xxA.mContext;
                i iVar = cVar.xxA;
                a aVar = bVar.xxy.get(Integer.valueOf(menuItem.getItemId()));
                Iterator<coq> it = bVar.xxx.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        coq = null;
                        break;
                    }
                    coq = it.next();
                    if (coq != null && coq.KWb == menuItem.getItemId()) {
                        break;
                    }
                }
                if (!(aVar == null || coq == null)) {
                    aVar.a(context, iVar, coq);
                }
                c.this.xxC.bMo();
                AppMethodBeat.o(83100);
            }
        });
        this.xxC.dGm();
        AppMethodBeat.o(83101);
    }
}
