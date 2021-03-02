package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eqn extends a {
    public int NnT;
    public vg NnU;
    public vg NnV;
    public int NnW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117940);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NnT);
            if (this.NnU != null) {
                aVar.ni(4, this.NnU.computeSize());
                this.NnU.writeFields(aVar);
            }
            if (this.NnV != null) {
                aVar.ni(5, this.NnV.computeSize());
                this.NnV.writeFields(aVar);
            }
            aVar.aM(6, this.NnW);
            AppMethodBeat.o(117940);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NnT) + 0;
            if (this.NnU != null) {
                bu += g.a.a.a.nh(4, this.NnU.computeSize());
            }
            if (this.NnV != null) {
                bu += g.a.a.a.nh(5, this.NnV.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.NnW);
            AppMethodBeat.o(117940);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117940);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqn eqn = (eqn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eqn.NnT = aVar3.UbS.zi();
                    AppMethodBeat.o(117940);
                    return 0;
                case 2:
                case 3:
                default:
                    AppMethodBeat.o(117940);
                    return -1;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        vg vgVar = new vg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = vgVar.populateBuilderWithField(aVar4, vgVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eqn.NnU = vgVar;
                    }
                    AppMethodBeat.o(117940);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        vg vgVar2 = new vg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = vgVar2.populateBuilderWithField(aVar5, vgVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        eqn.NnV = vgVar2;
                    }
                    AppMethodBeat.o(117940);
                    return 0;
                case 6:
                    eqn.NnW = aVar3.UbS.zi();
                    AppMethodBeat.o(117940);
                    return 0;
            }
        } else {
            AppMethodBeat.o(117940);
            return -1;
        }
    }
}
