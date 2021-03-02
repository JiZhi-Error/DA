package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eji extends a {
    public String AesKey;
    public String KMl;
    public int NiR;
    public int NiS;
    public long xui;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127506);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NiR);
            if (this.KMl != null) {
                aVar.e(2, this.KMl);
            }
            if (this.AesKey != null) {
                aVar.e(3, this.AesKey);
            }
            aVar.aM(4, this.NiS);
            aVar.bb(5, this.xui);
            AppMethodBeat.o(127506);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NiR) + 0;
            if (this.KMl != null) {
                bu += g.a.a.b.b.a.f(2, this.KMl);
            }
            if (this.AesKey != null) {
                bu += g.a.a.b.b.a.f(3, this.AesKey);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.NiS) + g.a.a.b.b.a.r(5, this.xui);
            AppMethodBeat.o(127506);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127506);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eji eji = (eji) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eji.NiR = aVar3.UbS.zi();
                    AppMethodBeat.o(127506);
                    return 0;
                case 2:
                    eji.KMl = aVar3.UbS.readString();
                    AppMethodBeat.o(127506);
                    return 0;
                case 3:
                    eji.AesKey = aVar3.UbS.readString();
                    AppMethodBeat.o(127506);
                    return 0;
                case 4:
                    eji.NiS = aVar3.UbS.zi();
                    AppMethodBeat.o(127506);
                    return 0;
                case 5:
                    eji.xui = aVar3.UbS.zl();
                    AppMethodBeat.o(127506);
                    return 0;
                default:
                    AppMethodBeat.o(127506);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127506);
            return -1;
        }
    }
}
