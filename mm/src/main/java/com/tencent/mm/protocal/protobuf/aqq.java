package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aqq extends a {
    public FinderObject LCD;
    public int LCE;
    public azm LCF;
    public ayj LCG;
    public int dataType;
    public long id;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168953);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            aVar.bb(2, this.id);
            if (this.LCD != null) {
                aVar.ni(3, this.LCD.computeSize());
                this.LCD.writeFields(aVar);
            }
            aVar.aM(4, this.LCE);
            if (this.LCF != null) {
                aVar.ni(5, this.LCF.computeSize());
                this.LCF.writeFields(aVar);
            }
            aVar.aM(6, this.dataType);
            if (this.LCG != null) {
                aVar.ni(7, this.LCG.computeSize());
                this.LCG.writeFields(aVar);
            }
            AppMethodBeat.o(168953);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0 + g.a.a.b.b.a.r(2, this.id);
            if (this.LCD != null) {
                bu += g.a.a.a.nh(3, this.LCD.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.LCE);
            if (this.LCF != null) {
                bu2 += g.a.a.a.nh(5, this.LCF.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(6, this.dataType);
            if (this.LCG != null) {
                bu3 += g.a.a.a.nh(7, this.LCG.computeSize());
            }
            AppMethodBeat.o(168953);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168953);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aqq aqq = (aqq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aqq.type = aVar3.UbS.zi();
                    AppMethodBeat.o(168953);
                    return 0;
                case 2:
                    aqq.id = aVar3.UbS.zl();
                    AppMethodBeat.o(168953);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderObject.populateBuilderWithField(aVar4, finderObject, a.getNextFieldNumber(aVar4))) {
                        }
                        aqq.LCD = finderObject;
                    }
                    AppMethodBeat.o(168953);
                    return 0;
                case 4:
                    aqq.LCE = aVar3.UbS.zi();
                    AppMethodBeat.o(168953);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        azm azm = new azm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = azm.populateBuilderWithField(aVar5, azm, a.getNextFieldNumber(aVar5))) {
                        }
                        aqq.LCF = azm;
                    }
                    AppMethodBeat.o(168953);
                    return 0;
                case 6:
                    aqq.dataType = aVar3.UbS.zi();
                    AppMethodBeat.o(168953);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ayj ayj = new ayj();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ayj.populateBuilderWithField(aVar6, ayj, a.getNextFieldNumber(aVar6))) {
                        }
                        aqq.LCG = ayj;
                    }
                    AppMethodBeat.o(168953);
                    return 0;
                default:
                    AppMethodBeat.o(168953);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168953);
            return -1;
        }
    }
}
