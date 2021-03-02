package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class exe extends a {
    public b NuB;
    public b NuC;
    public b NuD;
    public b NuE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91729);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NuB != null) {
                aVar.c(1, this.NuB);
            }
            if (this.NuC != null) {
                aVar.c(2, this.NuC);
            }
            if (this.NuD != null) {
                aVar.c(3, this.NuD);
            }
            if (this.NuE != null) {
                aVar.c(4, this.NuE);
            }
            AppMethodBeat.o(91729);
            return 0;
        } else if (i2 == 1) {
            int b2 = this.NuB != null ? g.a.a.b.b.a.b(1, this.NuB) + 0 : 0;
            if (this.NuC != null) {
                b2 += g.a.a.b.b.a.b(2, this.NuC);
            }
            if (this.NuD != null) {
                b2 += g.a.a.b.b.a.b(3, this.NuD);
            }
            if (this.NuE != null) {
                b2 += g.a.a.b.b.a.b(4, this.NuE);
            }
            AppMethodBeat.o(91729);
            return b2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91729);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            exe exe = (exe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    exe.NuB = aVar3.UbS.hPo();
                    AppMethodBeat.o(91729);
                    return 0;
                case 2:
                    exe.NuC = aVar3.UbS.hPo();
                    AppMethodBeat.o(91729);
                    return 0;
                case 3:
                    exe.NuD = aVar3.UbS.hPo();
                    AppMethodBeat.o(91729);
                    return 0;
                case 4:
                    exe.NuE = aVar3.UbS.hPo();
                    AppMethodBeat.o(91729);
                    return 0;
                default:
                    AppMethodBeat.o(91729);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91729);
            return -1;
        }
    }
}
