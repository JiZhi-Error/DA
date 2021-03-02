package com.tencent.mm.plugin.boots;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.boots.a.c;
import com.tencent.mm.plugin.boots.a.d;
import com.tencent.mm.plugin.boots.a.f;
import java.util.List;

public final class a implements c {
    @Override // com.tencent.mm.plugin.boots.a.c
    public final void CN(int i2) {
        AppMethodBeat.i(117356);
        if (((d) g.ah(d.class)).getTinkerLogic() != null) {
            ((d) g.ah(d.class)).getTinkerLogic().CN(i2);
        }
        AppMethodBeat.o(117356);
    }

    @Override // com.tencent.mm.plugin.boots.a.c
    public final void fb(int i2, int i3) {
        AppMethodBeat.i(117357);
        if (((d) g.ah(d.class)).getTinkerLogic() != null) {
            ((d) g.ah(d.class)).getTinkerLogic().fb(i2, i3);
        }
        AppMethodBeat.o(117357);
    }

    @Override // com.tencent.mm.plugin.boots.a.c
    public final List<com.tencent.mm.plugin.boots.a.a> ckR() {
        AppMethodBeat.i(117358);
        List<com.tencent.mm.plugin.boots.a.a> ckR = ((d) g.ah(d.class)).getTinkerLogic().ckR();
        AppMethodBeat.o(117358);
        return ckR;
    }

    @Override // com.tencent.mm.plugin.boots.a.c
    public final void a(String str, String str2, String str3, f fVar) {
        AppMethodBeat.i(196768);
        ((d) g.ah(d.class)).getTinkerLogic().a(str, str2, str3, fVar);
        AppMethodBeat.o(196768);
    }
}
