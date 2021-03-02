package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dey extends a {
    public boolean LYA;
    public LinkedList<cty> MJY = new LinkedList<>();
    public String MJZ;
    public int Mzl;
    public String dQx;
    public String pTL;

    public dey() {
        AppMethodBeat.i(176148);
        AppMethodBeat.o(176148);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(176149);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.MJY);
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            if (this.MJZ != null) {
                aVar.e(3, this.MJZ);
            }
            if (this.pTL != null) {
                aVar.e(4, this.pTL);
            }
            aVar.cc(5, this.LYA);
            aVar.aM(6, this.Mzl);
            AppMethodBeat.o(176149);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.MJY) + 0;
            if (this.dQx != null) {
                c2 += g.a.a.b.b.a.f(2, this.dQx);
            }
            if (this.MJZ != null) {
                c2 += g.a.a.b.b.a.f(3, this.MJZ);
            }
            if (this.pTL != null) {
                c2 += g.a.a.b.b.a.f(4, this.pTL);
            }
            int fS = c2 + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.bu(6, this.Mzl);
            AppMethodBeat.o(176149);
            return fS;
        } else if (i2 == 2) {
            this.MJY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(176149);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dey dey = (dey) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cty cty = new cty();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cty.populateBuilderWithField(aVar4, cty, a.getNextFieldNumber(aVar4))) {
                        }
                        dey.MJY.add(cty);
                    }
                    AppMethodBeat.o(176149);
                    return 0;
                case 2:
                    dey.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(176149);
                    return 0;
                case 3:
                    dey.MJZ = aVar3.UbS.readString();
                    AppMethodBeat.o(176149);
                    return 0;
                case 4:
                    dey.pTL = aVar3.UbS.readString();
                    AppMethodBeat.o(176149);
                    return 0;
                case 5:
                    dey.LYA = aVar3.UbS.yZ();
                    AppMethodBeat.o(176149);
                    return 0;
                case 6:
                    dey.Mzl = aVar3.UbS.zi();
                    AppMethodBeat.o(176149);
                    return 0;
                default:
                    AppMethodBeat.o(176149);
                    return -1;
            }
        } else {
            AppMethodBeat.o(176149);
            return -1;
        }
    }
}
