package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eqo extends a {
    public int MOQ;
    public eqs NnX;
    public eqq NnY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(176153);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MOQ);
            if (this.NnX != null) {
                aVar.ni(2, this.NnX.computeSize());
                this.NnX.writeFields(aVar);
            }
            if (this.NnY != null) {
                aVar.ni(3, this.NnY.computeSize());
                this.NnY.writeFields(aVar);
            }
            AppMethodBeat.o(176153);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MOQ) + 0;
            if (this.NnX != null) {
                bu += g.a.a.a.nh(2, this.NnX.computeSize());
            }
            if (this.NnY != null) {
                bu += g.a.a.a.nh(3, this.NnY.computeSize());
            }
            AppMethodBeat.o(176153);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(176153);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqo eqo = (eqo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eqo.MOQ = aVar3.UbS.zi();
                    AppMethodBeat.o(176153);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eqs eqs = new eqs();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eqs.populateBuilderWithField(aVar4, eqs, a.getNextFieldNumber(aVar4))) {
                        }
                        eqo.NnX = eqs;
                    }
                    AppMethodBeat.o(176153);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eqq eqq = new eqq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eqq.populateBuilderWithField(aVar5, eqq, a.getNextFieldNumber(aVar5))) {
                        }
                        eqo.NnY = eqq;
                    }
                    AppMethodBeat.o(176153);
                    return 0;
                default:
                    AppMethodBeat.o(176153);
                    return -1;
            }
        } else {
            AppMethodBeat.o(176153);
            return -1;
        }
    }
}
