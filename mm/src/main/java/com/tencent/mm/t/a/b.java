package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class b extends a {
    public String dNI;
    public String gTi;
    public String gTj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194674);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.gTi != null) {
                aVar.e(2, this.gTi);
            }
            if (this.gTj != null) {
                aVar.e(3, this.gTj);
            }
            AppMethodBeat.o(194674);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.gTi != null) {
                f2 += g.a.a.b.b.a.f(2, this.gTi);
            }
            if (this.gTj != null) {
                f2 += g.a.a.b.b.a.f(3, this.gTj);
            }
            AppMethodBeat.o(194674);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194674);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(194674);
                    return 0;
                case 2:
                    bVar.gTi = aVar3.UbS.readString();
                    AppMethodBeat.o(194674);
                    return 0;
                case 3:
                    bVar.gTj = aVar3.UbS.readString();
                    AppMethodBeat.o(194674);
                    return 0;
                default:
                    AppMethodBeat.o(194674);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194674);
            return -1;
        }
    }
}
