package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eqv extends a {
    public String KSu;
    public int KSv;
    public int KSw;
    public int KSx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212314);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KSu != null) {
                aVar.e(1, this.KSu);
            }
            aVar.aM(2, this.KSv);
            aVar.aM(3, this.KSw);
            aVar.aM(4, this.KSx);
            AppMethodBeat.o(212314);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KSu != null ? g.a.a.b.b.a.f(1, this.KSu) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KSv) + g.a.a.b.b.a.bu(3, this.KSw) + g.a.a.b.b.a.bu(4, this.KSx);
            AppMethodBeat.o(212314);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212314);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqv eqv = (eqv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eqv.KSu = aVar3.UbS.readString();
                    AppMethodBeat.o(212314);
                    return 0;
                case 2:
                    eqv.KSv = aVar3.UbS.zi();
                    AppMethodBeat.o(212314);
                    return 0;
                case 3:
                    eqv.KSw = aVar3.UbS.zi();
                    AppMethodBeat.o(212314);
                    return 0;
                case 4:
                    eqv.KSx = aVar3.UbS.zi();
                    AppMethodBeat.o(212314);
                    return 0;
                default:
                    AppMethodBeat.o(212314);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212314);
            return -1;
        }
    }
}
