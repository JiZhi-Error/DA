package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cnf extends a {
    public String MtA;
    public String MtB;
    public int MtC;
    public String MtD;
    public un MtE;
    public String MtF;
    public String Mtz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201347);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mtz != null) {
                aVar.e(1, this.Mtz);
            }
            if (this.MtA != null) {
                aVar.e(2, this.MtA);
            }
            if (this.MtB != null) {
                aVar.e(3, this.MtB);
            }
            aVar.aM(4, this.MtC);
            if (this.MtD != null) {
                aVar.e(5, this.MtD);
            }
            if (this.MtE != null) {
                aVar.ni(6, this.MtE.computeSize());
                this.MtE.writeFields(aVar);
            }
            if (this.MtF != null) {
                aVar.e(7, this.MtF);
            }
            AppMethodBeat.o(201347);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Mtz != null ? g.a.a.b.b.a.f(1, this.Mtz) + 0 : 0;
            if (this.MtA != null) {
                f2 += g.a.a.b.b.a.f(2, this.MtA);
            }
            if (this.MtB != null) {
                f2 += g.a.a.b.b.a.f(3, this.MtB);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.MtC);
            if (this.MtD != null) {
                bu += g.a.a.b.b.a.f(5, this.MtD);
            }
            if (this.MtE != null) {
                bu += g.a.a.a.nh(6, this.MtE.computeSize());
            }
            if (this.MtF != null) {
                bu += g.a.a.b.b.a.f(7, this.MtF);
            }
            AppMethodBeat.o(201347);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(201347);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cnf cnf = (cnf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cnf.Mtz = aVar3.UbS.readString();
                    AppMethodBeat.o(201347);
                    return 0;
                case 2:
                    cnf.MtA = aVar3.UbS.readString();
                    AppMethodBeat.o(201347);
                    return 0;
                case 3:
                    cnf.MtB = aVar3.UbS.readString();
                    AppMethodBeat.o(201347);
                    return 0;
                case 4:
                    cnf.MtC = aVar3.UbS.zi();
                    AppMethodBeat.o(201347);
                    return 0;
                case 5:
                    cnf.MtD = aVar3.UbS.readString();
                    AppMethodBeat.o(201347);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        un unVar = new un();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = unVar.populateBuilderWithField(aVar4, unVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cnf.MtE = unVar;
                    }
                    AppMethodBeat.o(201347);
                    return 0;
                case 7:
                    cnf.MtF = aVar3.UbS.readString();
                    AppMethodBeat.o(201347);
                    return 0;
                default:
                    AppMethodBeat.o(201347);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201347);
            return -1;
        }
    }
}
