package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eco extends a {
    public ecp NcH;
    public ecn NcI;
    public ecm NcJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125844);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NcH != null) {
                aVar.ni(1, this.NcH.computeSize());
                this.NcH.writeFields(aVar);
            }
            if (this.NcI != null) {
                aVar.ni(2, this.NcI.computeSize());
                this.NcI.writeFields(aVar);
            }
            if (this.NcJ != null) {
                aVar.ni(3, this.NcJ.computeSize());
                this.NcJ.writeFields(aVar);
            }
            AppMethodBeat.o(125844);
            return 0;
        } else if (i2 == 1) {
            int nh = this.NcH != null ? g.a.a.a.nh(1, this.NcH.computeSize()) + 0 : 0;
            if (this.NcI != null) {
                nh += g.a.a.a.nh(2, this.NcI.computeSize());
            }
            if (this.NcJ != null) {
                nh += g.a.a.a.nh(3, this.NcJ.computeSize());
            }
            AppMethodBeat.o(125844);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125844);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eco eco = (eco) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ecp ecp = new ecp();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ecp.populateBuilderWithField(aVar4, ecp, a.getNextFieldNumber(aVar4))) {
                        }
                        eco.NcH = ecp;
                    }
                    AppMethodBeat.o(125844);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ecn ecn = new ecn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ecn.populateBuilderWithField(aVar5, ecn, a.getNextFieldNumber(aVar5))) {
                        }
                        eco.NcI = ecn;
                    }
                    AppMethodBeat.o(125844);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ecm ecm = new ecm();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ecm.populateBuilderWithField(aVar6, ecm, a.getNextFieldNumber(aVar6))) {
                        }
                        eco.NcJ = ecm;
                    }
                    AppMethodBeat.o(125844);
                    return 0;
                default:
                    AppMethodBeat.o(125844);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125844);
            return -1;
        }
    }
}
