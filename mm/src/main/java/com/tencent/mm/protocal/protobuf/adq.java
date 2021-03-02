package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class adq extends a {
    public dqe KEP;
    public abm KZT;
    public dph Lpf;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91426);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.Lpf != null) {
                aVar.ni(2, this.Lpf.computeSize());
                this.Lpf.writeFields(aVar);
            }
            if (this.KEP != null) {
                aVar.ni(3, this.KEP.computeSize());
                this.KEP.writeFields(aVar);
            }
            if (this.KZT != null) {
                aVar.ni(4, this.KZT.computeSize());
                this.KZT.writeFields(aVar);
            }
            AppMethodBeat.o(91426);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.Lpf != null) {
                bu += g.a.a.a.nh(2, this.Lpf.computeSize());
            }
            if (this.KEP != null) {
                bu += g.a.a.a.nh(3, this.KEP.computeSize());
            }
            if (this.KZT != null) {
                bu += g.a.a.a.nh(4, this.KZT.computeSize());
            }
            AppMethodBeat.o(91426);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91426);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            adq adq = (adq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    adq.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91426);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dph dph = new dph();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dph.populateBuilderWithField(aVar4, dph, a.getNextFieldNumber(aVar4))) {
                        }
                        adq.Lpf = dph;
                    }
                    AppMethodBeat.o(91426);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqe dqe = new dqe();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqe.populateBuilderWithField(aVar5, dqe, a.getNextFieldNumber(aVar5))) {
                        }
                        adq.KEP = dqe;
                    }
                    AppMethodBeat.o(91426);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        abm abm = new abm();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = abm.populateBuilderWithField(aVar6, abm, a.getNextFieldNumber(aVar6))) {
                        }
                        adq.KZT = abm;
                    }
                    AppMethodBeat.o(91426);
                    return 0;
                default:
                    AppMethodBeat.o(91426);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91426);
            return -1;
        }
    }
}
