package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class erg extends a {
    public cyf MTe;
    public cml NoS;
    public int NoT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91725);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MTe != null) {
                aVar.ni(1, this.MTe.computeSize());
                this.MTe.writeFields(aVar);
            }
            if (this.NoS != null) {
                aVar.ni(2, this.NoS.computeSize());
                this.NoS.writeFields(aVar);
            }
            aVar.aM(3, this.NoT);
            AppMethodBeat.o(91725);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MTe != null ? g.a.a.a.nh(1, this.MTe.computeSize()) + 0 : 0;
            if (this.NoS != null) {
                nh += g.a.a.a.nh(2, this.NoS.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.NoT);
            AppMethodBeat.o(91725);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91725);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            erg erg = (erg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cyf cyf = new cyf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cyf.populateBuilderWithField(aVar4, cyf, a.getNextFieldNumber(aVar4))) {
                        }
                        erg.MTe = cyf;
                    }
                    AppMethodBeat.o(91725);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cml cml = new cml();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cml.populateBuilderWithField(aVar5, cml, a.getNextFieldNumber(aVar5))) {
                        }
                        erg.NoS = cml;
                    }
                    AppMethodBeat.o(91725);
                    return 0;
                case 3:
                    erg.NoT = aVar3.UbS.zi();
                    AppMethodBeat.o(91725);
                    return 0;
                default:
                    AppMethodBeat.o(91725);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91725);
            return -1;
        }
    }
}
