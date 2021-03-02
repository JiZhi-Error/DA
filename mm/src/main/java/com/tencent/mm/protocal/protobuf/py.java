package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class py extends a {
    public String KQV;
    public int KTf;
    public pz KWP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124454);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KWP != null) {
                aVar.ni(1, this.KWP.computeSize());
                this.KWP.writeFields(aVar);
            }
            aVar.aM(2, this.KTf);
            if (this.KQV != null) {
                aVar.e(3, this.KQV);
            }
            AppMethodBeat.o(124454);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.KWP != null ? g.a.a.a.nh(1, this.KWP.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KTf);
            if (this.KQV != null) {
                nh += g.a.a.b.b.a.f(3, this.KQV);
            }
            AppMethodBeat.o(124454);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124454);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            py pyVar = (py) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        pz pzVar = new pz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = pzVar.populateBuilderWithField(aVar4, pzVar, a.getNextFieldNumber(aVar4))) {
                        }
                        pyVar.KWP = pzVar;
                    }
                    AppMethodBeat.o(124454);
                    return 0;
                case 2:
                    pyVar.KTf = aVar3.UbS.zi();
                    AppMethodBeat.o(124454);
                    return 0;
                case 3:
                    pyVar.KQV = aVar3.UbS.readString();
                    AppMethodBeat.o(124454);
                    return 0;
                default:
                    AppMethodBeat.o(124454);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124454);
            return -1;
        }
    }
}
