package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.location.a;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.chk;
import java.util.Collections;

public final class a implements com.tencent.mm.pluginsdk.location.a {
    @Override // com.tencent.mm.pluginsdk.location.a
    public final void a(chk chk, final a.AbstractC2021a aVar) {
        AppMethodBeat.i(163196);
        d dVar = new d(chk);
        g.azz().a(603, new i() {
            /* class com.tencent.mm.plugin.nearlife.b.a.AnonymousClass1 */
            final /* synthetic */ boolean AAD = false;

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                String str2;
                AppMethodBeat.i(163195);
                g.azz().b(603, this);
                if (i2 == 0 && i3 == 0) {
                    if (this.AAD) {
                        str2 = ((bpe) ((d) qVar).rr.iLL.iLR).LXz;
                    } else {
                        str2 = ((bpe) ((d) qVar).rr.iLL.iLR).kea;
                    }
                    aVar.s(str2, ((bpe) ((d) qVar).rr.iLL.iLR).LXu);
                    AppMethodBeat.o(163195);
                    return;
                }
                aVar.s("", Collections.EMPTY_LIST);
                AppMethodBeat.o(163195);
            }
        });
        g.azz().a(dVar, 0);
        AppMethodBeat.o(163196);
    }
}
