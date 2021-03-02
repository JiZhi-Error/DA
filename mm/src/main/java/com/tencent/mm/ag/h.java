package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.al.k;
import com.tencent.mm.i.d;
import java.util.LinkedList;
import java.util.Map;

public class h extends f {
    public LinkedList<k> iwz = null;

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(20235);
        h hVar = new h();
        AppMethodBeat.o(20235);
        return hVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(20236);
        switch (bVar.dDG) {
            case 1:
                this.iwz = com.tencent.mm.al.k.E(bVar.iwG);
                break;
        }
        AppMethodBeat.o(20236);
    }
}
