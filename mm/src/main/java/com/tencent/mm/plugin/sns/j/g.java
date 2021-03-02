package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class g extends a {
    public int DRV;
    public String postId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(96158);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.postId != null) {
                aVar.e(1, this.postId);
            }
            aVar.aM(2, this.DRV);
            AppMethodBeat.o(96158);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.postId != null ? g.a.a.b.b.a.f(1, this.postId) + 0 : 0) + g.a.a.b.b.a.bu(2, this.DRV);
            AppMethodBeat.o(96158);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(96158);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.postId = aVar3.UbS.readString();
                    AppMethodBeat.o(96158);
                    return 0;
                case 2:
                    gVar.DRV = aVar3.UbS.zi();
                    AppMethodBeat.o(96158);
                    return 0;
                default:
                    AppMethodBeat.o(96158);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96158);
            return -1;
        }
    }
}
