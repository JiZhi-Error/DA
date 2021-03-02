package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aeo extends a {
    public cmv LpQ;
    public dlh LpR;
    public dlh LpS;
    public dlh LpT;
    public dlh LpU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201293);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LpQ != null) {
                aVar.ni(1, this.LpQ.computeSize());
                this.LpQ.writeFields(aVar);
            }
            if (this.LpR != null) {
                aVar.ni(2, this.LpR.computeSize());
                this.LpR.writeFields(aVar);
            }
            if (this.LpS != null) {
                aVar.ni(3, this.LpS.computeSize());
                this.LpS.writeFields(aVar);
            }
            if (this.LpT != null) {
                aVar.ni(4, this.LpT.computeSize());
                this.LpT.writeFields(aVar);
            }
            if (this.LpU != null) {
                aVar.ni(5, this.LpU.computeSize());
                this.LpU.writeFields(aVar);
            }
            AppMethodBeat.o(201293);
            return 0;
        } else if (i2 == 1) {
            int nh = this.LpQ != null ? g.a.a.a.nh(1, this.LpQ.computeSize()) + 0 : 0;
            if (this.LpR != null) {
                nh += g.a.a.a.nh(2, this.LpR.computeSize());
            }
            if (this.LpS != null) {
                nh += g.a.a.a.nh(3, this.LpS.computeSize());
            }
            if (this.LpT != null) {
                nh += g.a.a.a.nh(4, this.LpT.computeSize());
            }
            if (this.LpU != null) {
                nh += g.a.a.a.nh(5, this.LpU.computeSize());
            }
            AppMethodBeat.o(201293);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(201293);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aeo aeo = (aeo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cmv cmv = new cmv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cmv.populateBuilderWithField(aVar4, cmv, a.getNextFieldNumber(aVar4))) {
                        }
                        aeo.LpQ = cmv;
                    }
                    AppMethodBeat.o(201293);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dlh dlh = new dlh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dlh.populateBuilderWithField(aVar5, dlh, a.getNextFieldNumber(aVar5))) {
                        }
                        aeo.LpR = dlh;
                    }
                    AppMethodBeat.o(201293);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dlh dlh2 = new dlh();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dlh2.populateBuilderWithField(aVar6, dlh2, a.getNextFieldNumber(aVar6))) {
                        }
                        aeo.LpS = dlh2;
                    }
                    AppMethodBeat.o(201293);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dlh dlh3 = new dlh();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dlh3.populateBuilderWithField(aVar7, dlh3, a.getNextFieldNumber(aVar7))) {
                        }
                        aeo.LpT = dlh3;
                    }
                    AppMethodBeat.o(201293);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dlh dlh4 = new dlh();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dlh4.populateBuilderWithField(aVar8, dlh4, a.getNextFieldNumber(aVar8))) {
                        }
                        aeo.LpU = dlh4;
                    }
                    AppMethodBeat.o(201293);
                    return 0;
                default:
                    AppMethodBeat.o(201293);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201293);
            return -1;
        }
    }
}
