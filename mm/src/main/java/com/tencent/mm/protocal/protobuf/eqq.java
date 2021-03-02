package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eqq extends a {
    public LinkedList<eqr> Lhs = new LinkedList<>();
    public String MJZ;
    public int Nhi;
    public String dNI;
    public String dQx;
    public int version;

    public eqq() {
        AppMethodBeat.i(176154);
        AppMethodBeat.o(176154);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(176155);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Lhs);
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            aVar.aM(3, this.Nhi);
            if (this.MJZ != null) {
                aVar.e(4, this.MJZ);
            }
            if (this.dNI != null) {
                aVar.e(5, this.dNI);
            }
            aVar.aM(6, this.version);
            AppMethodBeat.o(176155);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Lhs) + 0;
            if (this.dQx != null) {
                c2 += g.a.a.b.b.a.f(2, this.dQx);
            }
            int bu = c2 + g.a.a.b.b.a.bu(3, this.Nhi);
            if (this.MJZ != null) {
                bu += g.a.a.b.b.a.f(4, this.MJZ);
            }
            if (this.dNI != null) {
                bu += g.a.a.b.b.a.f(5, this.dNI);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.version);
            AppMethodBeat.o(176155);
            return bu2;
        } else if (i2 == 2) {
            this.Lhs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(176155);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqq eqq = (eqq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eqr eqr = new eqr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eqr.populateBuilderWithField(aVar4, eqr, a.getNextFieldNumber(aVar4))) {
                        }
                        eqq.Lhs.add(eqr);
                    }
                    AppMethodBeat.o(176155);
                    return 0;
                case 2:
                    eqq.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(176155);
                    return 0;
                case 3:
                    eqq.Nhi = aVar3.UbS.zi();
                    AppMethodBeat.o(176155);
                    return 0;
                case 4:
                    eqq.MJZ = aVar3.UbS.readString();
                    AppMethodBeat.o(176155);
                    return 0;
                case 5:
                    eqq.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(176155);
                    return 0;
                case 6:
                    eqq.version = aVar3.UbS.zi();
                    AppMethodBeat.o(176155);
                    return 0;
                default:
                    AppMethodBeat.o(176155);
                    return -1;
            }
        } else {
            AppMethodBeat.o(176155);
            return -1;
        }
    }
}
