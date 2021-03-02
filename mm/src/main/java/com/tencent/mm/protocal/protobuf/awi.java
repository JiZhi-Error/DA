package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class awi extends a {
    public awg LGn;
    public int LHa;
    public int LHb;
    public int LHc;
    public String description;
    public int extFlag;
    public String id;
    public int iqg;
    public int trl;
    public int ugF;
    public int uhE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209529);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            aVar.aM(2, this.LHa);
            aVar.aM(3, this.iqg);
            aVar.aM(4, this.LHb);
            if (this.description != null) {
                aVar.e(5, this.description);
            }
            if (this.LGn != null) {
                aVar.ni(6, this.LGn.computeSize());
                this.LGn.writeFields(aVar);
            }
            aVar.aM(7, this.ugF);
            aVar.aM(8, this.trl);
            aVar.aM(9, this.uhE);
            aVar.aM(10, this.extFlag);
            aVar.aM(11, this.LHc);
            AppMethodBeat.o(209529);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.id != null ? g.a.a.b.b.a.f(1, this.id) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LHa) + g.a.a.b.b.a.bu(3, this.iqg) + g.a.a.b.b.a.bu(4, this.LHb);
            if (this.description != null) {
                f2 += g.a.a.b.b.a.f(5, this.description);
            }
            if (this.LGn != null) {
                f2 += g.a.a.a.nh(6, this.LGn.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.ugF) + g.a.a.b.b.a.bu(8, this.trl) + g.a.a.b.b.a.bu(9, this.uhE) + g.a.a.b.b.a.bu(10, this.extFlag) + g.a.a.b.b.a.bu(11, this.LHc);
            AppMethodBeat.o(209529);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209529);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            awi awi = (awi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awi.id = aVar3.UbS.readString();
                    AppMethodBeat.o(209529);
                    return 0;
                case 2:
                    awi.LHa = aVar3.UbS.zi();
                    AppMethodBeat.o(209529);
                    return 0;
                case 3:
                    awi.iqg = aVar3.UbS.zi();
                    AppMethodBeat.o(209529);
                    return 0;
                case 4:
                    awi.LHb = aVar3.UbS.zi();
                    AppMethodBeat.o(209529);
                    return 0;
                case 5:
                    awi.description = aVar3.UbS.readString();
                    AppMethodBeat.o(209529);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        awg awg = new awg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = awg.populateBuilderWithField(aVar4, awg, a.getNextFieldNumber(aVar4))) {
                        }
                        awi.LGn = awg;
                    }
                    AppMethodBeat.o(209529);
                    return 0;
                case 7:
                    awi.ugF = aVar3.UbS.zi();
                    AppMethodBeat.o(209529);
                    return 0;
                case 8:
                    awi.trl = aVar3.UbS.zi();
                    AppMethodBeat.o(209529);
                    return 0;
                case 9:
                    awi.uhE = aVar3.UbS.zi();
                    AppMethodBeat.o(209529);
                    return 0;
                case 10:
                    awi.extFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209529);
                    return 0;
                case 11:
                    awi.LHc = aVar3.UbS.zi();
                    AppMethodBeat.o(209529);
                    return 0;
                default:
                    AppMethodBeat.o(209529);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209529);
            return -1;
        }
    }
}
