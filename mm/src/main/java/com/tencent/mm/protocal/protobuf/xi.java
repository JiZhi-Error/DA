package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class xi extends a {
    public String LiG;
    public double LiH;
    public double LiI;
    public double LiJ;
    public double LiK;
    public double LiL;
    public int xNc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(87874);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LiG != null) {
                aVar.e(1, this.LiG);
            }
            aVar.e(2, this.LiH);
            aVar.e(3, this.LiI);
            aVar.e(4, this.LiJ);
            aVar.e(5, this.LiK);
            aVar.e(6, this.LiL);
            aVar.aM(7, this.xNc);
            AppMethodBeat.o(87874);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LiG != null ? g.a.a.b.b.a.f(1, this.LiG) + 0 : 0) + g.a.a.b.b.a.fS(2) + 8 + g.a.a.b.b.a.fS(3) + 8 + g.a.a.b.b.a.fS(4) + 8 + g.a.a.b.b.a.fS(5) + 8 + g.a.a.b.b.a.fS(6) + 8 + g.a.a.b.b.a.bu(7, this.xNc);
            AppMethodBeat.o(87874);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(87874);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            xi xiVar = (xi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xiVar.LiG = aVar3.UbS.readString();
                    AppMethodBeat.o(87874);
                    return 0;
                case 2:
                    xiVar.LiH = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(87874);
                    return 0;
                case 3:
                    xiVar.LiI = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(87874);
                    return 0;
                case 4:
                    xiVar.LiJ = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(87874);
                    return 0;
                case 5:
                    xiVar.LiK = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(87874);
                    return 0;
                case 6:
                    xiVar.LiL = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(87874);
                    return 0;
                case 7:
                    xiVar.xNc = aVar3.UbS.zi();
                    AppMethodBeat.o(87874);
                    return 0;
                default:
                    AppMethodBeat.o(87874);
                    return -1;
            }
        } else {
            AppMethodBeat.o(87874);
            return -1;
        }
    }
}
