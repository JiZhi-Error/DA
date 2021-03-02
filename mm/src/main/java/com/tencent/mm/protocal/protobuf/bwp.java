package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bwp extends dop {
    public int BsF;
    public int BsG;
    public int KCx;
    public int Mck;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(74659);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.Mck);
            aVar.aM(3, this.BsF);
            aVar.aM(4, this.BsG);
            aVar.aM(5, this.KCx);
            AppMethodBeat.o(74659);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Mck) + g.a.a.b.b.a.bu(3, this.BsF) + g.a.a.b.b.a.bu(4, this.BsG) + g.a.a.b.b.a.bu(5, this.KCx);
            AppMethodBeat.o(74659);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(74659);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bwp bwp = (bwp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        bwp.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(74659);
                    return 0;
                case 2:
                    bwp.Mck = aVar3.UbS.zi();
                    AppMethodBeat.o(74659);
                    return 0;
                case 3:
                    bwp.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(74659);
                    return 0;
                case 4:
                    bwp.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(74659);
                    return 0;
                case 5:
                    bwp.KCx = aVar3.UbS.zi();
                    AppMethodBeat.o(74659);
                    return 0;
                default:
                    AppMethodBeat.o(74659);
                    return -1;
            }
        } else {
            AppMethodBeat.o(74659);
            return -1;
        }
    }
}
