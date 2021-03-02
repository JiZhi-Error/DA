package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cpv extends a {
    public String Cyk;
    public String MvO;
    public int oUv;
    public String xMo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127501);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMo != null) {
                aVar.e(1, this.xMo);
            }
            if (this.MvO != null) {
                aVar.e(2, this.MvO);
            }
            if (this.Cyk != null) {
                aVar.e(3, this.Cyk);
            }
            aVar.aM(4, this.oUv);
            AppMethodBeat.o(127501);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xMo != null ? g.a.a.b.b.a.f(1, this.xMo) + 0 : 0;
            if (this.MvO != null) {
                f2 += g.a.a.b.b.a.f(2, this.MvO);
            }
            if (this.Cyk != null) {
                f2 += g.a.a.b.b.a.f(3, this.Cyk);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.oUv);
            AppMethodBeat.o(127501);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127501);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cpv cpv = (cpv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cpv.xMo = aVar3.UbS.readString();
                    AppMethodBeat.o(127501);
                    return 0;
                case 2:
                    cpv.MvO = aVar3.UbS.readString();
                    AppMethodBeat.o(127501);
                    return 0;
                case 3:
                    cpv.Cyk = aVar3.UbS.readString();
                    AppMethodBeat.o(127501);
                    return 0;
                case 4:
                    cpv.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(127501);
                    return 0;
                default:
                    AppMethodBeat.o(127501);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127501);
            return -1;
        }
    }
}
