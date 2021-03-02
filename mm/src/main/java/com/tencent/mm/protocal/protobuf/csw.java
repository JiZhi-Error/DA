package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class csw extends a {
    public ccy KZS;
    public ehf Lov;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91551);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KZS != null) {
                aVar.ni(1, this.KZS.computeSize());
                this.KZS.writeFields(aVar);
            }
            if (this.Lov != null) {
                aVar.ni(2, this.Lov.computeSize());
                this.Lov.writeFields(aVar);
            }
            aVar.aM(3, this.type);
            AppMethodBeat.o(91551);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KZS != null ? g.a.a.a.nh(1, this.KZS.computeSize()) + 0 : 0;
            if (this.Lov != null) {
                nh += g.a.a.a.nh(2, this.Lov.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.type);
            AppMethodBeat.o(91551);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91551);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csw csw = (csw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ccy ccy = new ccy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ccy.populateBuilderWithField(aVar4, ccy, a.getNextFieldNumber(aVar4))) {
                        }
                        csw.KZS = ccy;
                    }
                    AppMethodBeat.o(91551);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ehf.populateBuilderWithField(aVar5, ehf, a.getNextFieldNumber(aVar5))) {
                        }
                        csw.Lov = ehf;
                    }
                    AppMethodBeat.o(91551);
                    return 0;
                case 3:
                    csw.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91551);
                    return 0;
                default:
                    AppMethodBeat.o(91551);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91551);
            return -1;
        }
    }
}
