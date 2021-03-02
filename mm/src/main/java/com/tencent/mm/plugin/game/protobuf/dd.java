package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dd extends a {
    public String xKc;
    public de xMO;
    public de xMP;
    public de xMQ;
    public de xMR;
    public de xMS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41817);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMO != null) {
                aVar.ni(1, this.xMO.computeSize());
                this.xMO.writeFields(aVar);
            }
            if (this.xMP != null) {
                aVar.ni(2, this.xMP.computeSize());
                this.xMP.writeFields(aVar);
            }
            if (this.xMQ != null) {
                aVar.ni(3, this.xMQ.computeSize());
                this.xMQ.writeFields(aVar);
            }
            if (this.xMR != null) {
                aVar.ni(4, this.xMR.computeSize());
                this.xMR.writeFields(aVar);
            }
            if (this.xMS != null) {
                aVar.ni(6, this.xMS.computeSize());
                this.xMS.writeFields(aVar);
            }
            if (this.xKc != null) {
                aVar.e(5, this.xKc);
            }
            AppMethodBeat.o(41817);
            return 0;
        } else if (i2 == 1) {
            int nh = this.xMO != null ? g.a.a.a.nh(1, this.xMO.computeSize()) + 0 : 0;
            if (this.xMP != null) {
                nh += g.a.a.a.nh(2, this.xMP.computeSize());
            }
            if (this.xMQ != null) {
                nh += g.a.a.a.nh(3, this.xMQ.computeSize());
            }
            if (this.xMR != null) {
                nh += g.a.a.a.nh(4, this.xMR.computeSize());
            }
            if (this.xMS != null) {
                nh += g.a.a.a.nh(6, this.xMS.computeSize());
            }
            if (this.xKc != null) {
                nh += g.a.a.b.b.a.f(5, this.xKc);
            }
            AppMethodBeat.o(41817);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41817);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dd ddVar = (dd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        de deVar = new de();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = deVar.populateBuilderWithField(aVar4, deVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ddVar.xMO = deVar;
                    }
                    AppMethodBeat.o(41817);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        de deVar2 = new de();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = deVar2.populateBuilderWithField(aVar5, deVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        ddVar.xMP = deVar2;
                    }
                    AppMethodBeat.o(41817);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        de deVar3 = new de();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = deVar3.populateBuilderWithField(aVar6, deVar3, a.getNextFieldNumber(aVar6))) {
                        }
                        ddVar.xMQ = deVar3;
                    }
                    AppMethodBeat.o(41817);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        de deVar4 = new de();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = deVar4.populateBuilderWithField(aVar7, deVar4, a.getNextFieldNumber(aVar7))) {
                        }
                        ddVar.xMR = deVar4;
                    }
                    AppMethodBeat.o(41817);
                    return 0;
                case 5:
                    ddVar.xKc = aVar3.UbS.readString();
                    AppMethodBeat.o(41817);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        de deVar5 = new de();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = deVar5.populateBuilderWithField(aVar8, deVar5, a.getNextFieldNumber(aVar8))) {
                        }
                        ddVar.xMS = deVar5;
                    }
                    AppMethodBeat.o(41817);
                    return 0;
                default:
                    AppMethodBeat.o(41817);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41817);
            return -1;
        }
    }
}
