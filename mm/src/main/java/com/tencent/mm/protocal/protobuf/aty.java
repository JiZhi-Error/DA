package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aty extends a {
    public float bottom;
    public float left;
    public float right;
    public float top;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209463);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.E(1, this.left);
            aVar.E(2, this.top);
            aVar.E(3, this.right);
            aVar.E(4, this.bottom);
            AppMethodBeat.o(209463);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 4 + 0 + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.fS(4) + 4;
            AppMethodBeat.o(209463);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209463);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aty aty = (aty) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aty.left = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209463);
                    return 0;
                case 2:
                    aty.top = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209463);
                    return 0;
                case 3:
                    aty.right = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209463);
                    return 0;
                case 4:
                    aty.bottom = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209463);
                    return 0;
                default:
                    AppMethodBeat.o(209463);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209463);
            return -1;
        }
    }
}