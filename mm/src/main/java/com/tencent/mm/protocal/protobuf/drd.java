package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class drd extends a {
    public b MTL;
    public b MTM;
    public b MTN;
    public b MTO;
    public dre MTP;
    public int lHz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225296);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.lHz);
            if (this.MTL != null) {
                aVar.c(2, this.MTL);
            }
            if (this.MTM != null) {
                aVar.c(3, this.MTM);
            }
            if (this.MTN != null) {
                aVar.c(4, this.MTN);
            }
            if (this.MTO != null) {
                aVar.c(5, this.MTO);
            }
            if (this.MTP != null) {
                aVar.ni(6, this.MTP.computeSize());
                this.MTP.writeFields(aVar);
            }
            AppMethodBeat.o(225296);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.lHz) + 0;
            if (this.MTL != null) {
                bu += g.a.a.b.b.a.b(2, this.MTL);
            }
            if (this.MTM != null) {
                bu += g.a.a.b.b.a.b(3, this.MTM);
            }
            if (this.MTN != null) {
                bu += g.a.a.b.b.a.b(4, this.MTN);
            }
            if (this.MTO != null) {
                bu += g.a.a.b.b.a.b(5, this.MTO);
            }
            if (this.MTP != null) {
                bu += g.a.a.a.nh(6, this.MTP.computeSize());
            }
            AppMethodBeat.o(225296);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(225296);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drd drd = (drd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    drd.lHz = aVar3.UbS.zi();
                    AppMethodBeat.o(225296);
                    return 0;
                case 2:
                    drd.MTL = aVar3.UbS.hPo();
                    AppMethodBeat.o(225296);
                    return 0;
                case 3:
                    drd.MTM = aVar3.UbS.hPo();
                    AppMethodBeat.o(225296);
                    return 0;
                case 4:
                    drd.MTN = aVar3.UbS.hPo();
                    AppMethodBeat.o(225296);
                    return 0;
                case 5:
                    drd.MTO = aVar3.UbS.hPo();
                    AppMethodBeat.o(225296);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dre dre = new dre();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dre.populateBuilderWithField(aVar4, dre, a.getNextFieldNumber(aVar4))) {
                        }
                        drd.MTP = dre;
                    }
                    AppMethodBeat.o(225296);
                    return 0;
                default:
                    AppMethodBeat.o(225296);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225296);
            return -1;
        }
    }
}
