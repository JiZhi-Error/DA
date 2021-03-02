package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dcs extends a {
    public float AAH;
    public int MHY;
    public String MHf;
    public String Name;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209796);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            if (this.MHf != null) {
                aVar.e(2, this.MHf);
            }
            aVar.aM(3, this.MHY);
            aVar.E(4, this.AAH);
            AppMethodBeat.o(209796);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Name != null ? g.a.a.b.b.a.f(1, this.Name) + 0 : 0;
            if (this.MHf != null) {
                f2 += g.a.a.b.b.a.f(2, this.MHf);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MHY) + g.a.a.b.b.a.fS(4) + 4;
            AppMethodBeat.o(209796);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209796);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dcs dcs = (dcs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcs.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(209796);
                    return 0;
                case 2:
                    dcs.MHf = aVar3.UbS.readString();
                    AppMethodBeat.o(209796);
                    return 0;
                case 3:
                    dcs.MHY = aVar3.UbS.zi();
                    AppMethodBeat.o(209796);
                    return 0;
                case 4:
                    dcs.AAH = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209796);
                    return 0;
                default:
                    AppMethodBeat.o(209796);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209796);
            return -1;
        }
    }
}
