package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ayr extends a {
    public ays LIR;
    public int dataType;
    public FinderObject tuO;
    public azm vEa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209599);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.dataType);
            if (this.LIR != null) {
                aVar.ni(2, this.LIR.computeSize());
                this.LIR.writeFields(aVar);
            }
            if (this.vEa != null) {
                aVar.ni(3, this.vEa.computeSize());
                this.vEa.writeFields(aVar);
            }
            if (this.tuO != null) {
                aVar.ni(4, this.tuO.computeSize());
                this.tuO.writeFields(aVar);
            }
            AppMethodBeat.o(209599);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.dataType) + 0;
            if (this.LIR != null) {
                bu += g.a.a.a.nh(2, this.LIR.computeSize());
            }
            if (this.vEa != null) {
                bu += g.a.a.a.nh(3, this.vEa.computeSize());
            }
            if (this.tuO != null) {
                bu += g.a.a.a.nh(4, this.tuO.computeSize());
            }
            AppMethodBeat.o(209599);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209599);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ayr ayr = (ayr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ayr.dataType = aVar3.UbS.zi();
                    AppMethodBeat.o(209599);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ays ays = new ays();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ays.populateBuilderWithField(aVar4, ays, a.getNextFieldNumber(aVar4))) {
                        }
                        ayr.LIR = ays;
                    }
                    AppMethodBeat.o(209599);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        azm azm = new azm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = azm.populateBuilderWithField(aVar5, azm, a.getNextFieldNumber(aVar5))) {
                        }
                        ayr.vEa = azm;
                    }
                    AppMethodBeat.o(209599);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderObject.populateBuilderWithField(aVar6, finderObject, a.getNextFieldNumber(aVar6))) {
                        }
                        ayr.tuO = finderObject;
                    }
                    AppMethodBeat.o(209599);
                    return 0;
                default:
                    AppMethodBeat.o(209599);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209599);
            return -1;
        }
    }
}
