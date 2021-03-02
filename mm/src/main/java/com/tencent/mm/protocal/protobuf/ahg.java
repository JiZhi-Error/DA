package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ahg extends a {
    public dqe KEP;
    public abm KZT;
    public String title;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91435);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.KEP != null) {
                aVar.ni(3, this.KEP.computeSize());
                this.KEP.writeFields(aVar);
            }
            if (this.KZT != null) {
                aVar.ni(4, this.KZT.computeSize());
                this.KZT.writeFields(aVar);
            }
            AppMethodBeat.o(91435);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(2, this.title);
            }
            if (this.KEP != null) {
                bu += g.a.a.a.nh(3, this.KEP.computeSize());
            }
            if (this.KZT != null) {
                bu += g.a.a.a.nh(4, this.KZT.computeSize());
            }
            AppMethodBeat.o(91435);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91435);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahg ahg = (ahg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ahg.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91435);
                    return 0;
                case 2:
                    ahg.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91435);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqe dqe = new dqe();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqe.populateBuilderWithField(aVar4, dqe, a.getNextFieldNumber(aVar4))) {
                        }
                        ahg.KEP = dqe;
                    }
                    AppMethodBeat.o(91435);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        abm abm = new abm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = abm.populateBuilderWithField(aVar5, abm, a.getNextFieldNumber(aVar5))) {
                        }
                        ahg.KZT = abm;
                    }
                    AppMethodBeat.o(91435);
                    return 0;
                default:
                    AppMethodBeat.o(91435);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91435);
            return -1;
        }
    }
}
