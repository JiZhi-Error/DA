package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ddh extends a {
    public adt MIr;
    public adt MIs;
    public adt MIt;
    public adt MIu;
    public int bottom;
    public int left;
    public int right;
    public int top;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118412);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.left);
            aVar.aM(2, this.top);
            aVar.aM(3, this.right);
            aVar.aM(4, this.bottom);
            if (this.MIr != null) {
                aVar.ni(5, this.MIr.computeSize());
                this.MIr.writeFields(aVar);
            }
            if (this.MIs != null) {
                aVar.ni(6, this.MIs.computeSize());
                this.MIs.writeFields(aVar);
            }
            if (this.MIt != null) {
                aVar.ni(7, this.MIt.computeSize());
                this.MIt.writeFields(aVar);
            }
            if (this.MIu != null) {
                aVar.ni(8, this.MIu.computeSize());
                this.MIu.writeFields(aVar);
            }
            aVar.aM(100, this.type);
            AppMethodBeat.o(118412);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.left) + 0 + g.a.a.b.b.a.bu(2, this.top) + g.a.a.b.b.a.bu(3, this.right) + g.a.a.b.b.a.bu(4, this.bottom);
            if (this.MIr != null) {
                bu += g.a.a.a.nh(5, this.MIr.computeSize());
            }
            if (this.MIs != null) {
                bu += g.a.a.a.nh(6, this.MIs.computeSize());
            }
            if (this.MIt != null) {
                bu += g.a.a.a.nh(7, this.MIt.computeSize());
            }
            if (this.MIu != null) {
                bu += g.a.a.a.nh(8, this.MIu.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(100, this.type);
            AppMethodBeat.o(118412);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118412);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddh ddh = (ddh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ddh.left = aVar3.UbS.zi();
                    AppMethodBeat.o(118412);
                    return 0;
                case 2:
                    ddh.top = aVar3.UbS.zi();
                    AppMethodBeat.o(118412);
                    return 0;
                case 3:
                    ddh.right = aVar3.UbS.zi();
                    AppMethodBeat.o(118412);
                    return 0;
                case 4:
                    ddh.bottom = aVar3.UbS.zi();
                    AppMethodBeat.o(118412);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        adt adt = new adt();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = adt.populateBuilderWithField(aVar4, adt, a.getNextFieldNumber(aVar4))) {
                        }
                        ddh.MIr = adt;
                    }
                    AppMethodBeat.o(118412);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        adt adt2 = new adt();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = adt2.populateBuilderWithField(aVar5, adt2, a.getNextFieldNumber(aVar5))) {
                        }
                        ddh.MIs = adt2;
                    }
                    AppMethodBeat.o(118412);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        adt adt3 = new adt();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = adt3.populateBuilderWithField(aVar6, adt3, a.getNextFieldNumber(aVar6))) {
                        }
                        ddh.MIt = adt3;
                    }
                    AppMethodBeat.o(118412);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        adt adt4 = new adt();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = adt4.populateBuilderWithField(aVar7, adt4, a.getNextFieldNumber(aVar7))) {
                        }
                        ddh.MIu = adt4;
                    }
                    AppMethodBeat.o(118412);
                    return 0;
                case 100:
                    ddh.type = aVar3.UbS.zi();
                    AppMethodBeat.o(118412);
                    return 0;
                default:
                    AppMethodBeat.o(118412);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118412);
            return -1;
        }
    }
}
