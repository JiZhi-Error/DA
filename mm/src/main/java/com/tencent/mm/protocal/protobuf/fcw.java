package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class fcw extends a {
    public b KSW;
    public String Mmv;
    public String dNI;
    public String qwo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123700);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mmv != null) {
                aVar.e(1, this.Mmv);
            }
            if (this.KSW != null) {
                aVar.c(2, this.KSW);
            }
            if (this.dNI != null) {
                aVar.e(3, this.dNI);
            }
            if (this.qwo != null) {
                aVar.e(4, this.qwo);
            }
            AppMethodBeat.o(123700);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Mmv != null ? g.a.a.b.b.a.f(1, this.Mmv) + 0 : 0;
            if (this.KSW != null) {
                f2 += g.a.a.b.b.a.b(2, this.KSW);
            }
            if (this.dNI != null) {
                f2 += g.a.a.b.b.a.f(3, this.dNI);
            }
            if (this.qwo != null) {
                f2 += g.a.a.b.b.a.f(4, this.qwo);
            }
            AppMethodBeat.o(123700);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123700);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fcw fcw = (fcw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fcw.Mmv = aVar3.UbS.readString();
                    AppMethodBeat.o(123700);
                    return 0;
                case 2:
                    fcw.KSW = aVar3.UbS.hPo();
                    AppMethodBeat.o(123700);
                    return 0;
                case 3:
                    fcw.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(123700);
                    return 0;
                case 4:
                    fcw.qwo = aVar3.UbS.readString();
                    AppMethodBeat.o(123700);
                    return 0;
                default:
                    AppMethodBeat.o(123700);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123700);
            return -1;
        }
    }
}
