package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bia extends a {
    public int KIm;
    public int LSq;
    public String jfi;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123572);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi != null) {
                aVar.e(1, this.jfi);
            }
            aVar.aM(2, this.oUv);
            aVar.aM(3, this.KIm);
            aVar.aM(4, this.LSq);
            AppMethodBeat.o(123572);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.jfi != null ? g.a.a.b.b.a.f(1, this.jfi) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.KIm) + g.a.a.b.b.a.bu(4, this.LSq);
            AppMethodBeat.o(123572);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123572);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bia bia = (bia) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bia.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(123572);
                    return 0;
                case 2:
                    bia.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(123572);
                    return 0;
                case 3:
                    bia.KIm = aVar3.UbS.zi();
                    AppMethodBeat.o(123572);
                    return 0;
                case 4:
                    bia.LSq = aVar3.UbS.zi();
                    AppMethodBeat.o(123572);
                    return 0;
                default:
                    AppMethodBeat.o(123572);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123572);
            return -1;
        }
    }
}
