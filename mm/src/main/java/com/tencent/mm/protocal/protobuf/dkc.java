package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dkc extends dop {
    public String HQc;
    public String HVd;
    public int MNZ;
    public String dNQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(174536);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.HQc != null) {
                aVar.e(2, this.HQc);
            }
            if (this.HVd != null) {
                aVar.e(3, this.HVd);
            }
            aVar.aM(4, this.MNZ);
            if (this.dNQ != null) {
                aVar.e(5, this.dNQ);
            }
            AppMethodBeat.o(174536);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.HQc != null) {
                nh += g.a.a.b.b.a.f(2, this.HQc);
            }
            if (this.HVd != null) {
                nh += g.a.a.b.b.a.f(3, this.HVd);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MNZ);
            if (this.dNQ != null) {
                bu += g.a.a.b.b.a.f(5, this.dNQ);
            }
            AppMethodBeat.o(174536);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(174536);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dkc dkc = (dkc) objArr[1];
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
                        dkc.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(174536);
                    return 0;
                case 2:
                    dkc.HQc = aVar3.UbS.readString();
                    AppMethodBeat.o(174536);
                    return 0;
                case 3:
                    dkc.HVd = aVar3.UbS.readString();
                    AppMethodBeat.o(174536);
                    return 0;
                case 4:
                    dkc.MNZ = aVar3.UbS.zi();
                    AppMethodBeat.o(174536);
                    return 0;
                case 5:
                    dkc.dNQ = aVar3.UbS.readString();
                    AppMethodBeat.o(174536);
                    return 0;
                default:
                    AppMethodBeat.o(174536);
                    return -1;
            }
        } else {
            AppMethodBeat.o(174536);
            return -1;
        }
    }
}
