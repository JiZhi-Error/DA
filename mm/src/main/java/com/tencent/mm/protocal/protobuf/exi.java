package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class exi extends a {
    public String NuI;
    public th NuJ;
    public boolean NuK;
    public String NuL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91731);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NuI != null) {
                aVar.e(1, this.NuI);
            }
            if (this.NuJ != null) {
                aVar.ni(2, this.NuJ.computeSize());
                this.NuJ.writeFields(aVar);
            }
            aVar.cc(3, this.NuK);
            if (this.NuL != null) {
                aVar.e(4, this.NuL);
            }
            AppMethodBeat.o(91731);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.NuI != null ? g.a.a.b.b.a.f(1, this.NuI) + 0 : 0;
            if (this.NuJ != null) {
                f2 += g.a.a.a.nh(2, this.NuJ.computeSize());
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 1;
            if (this.NuL != null) {
                fS += g.a.a.b.b.a.f(4, this.NuL);
            }
            AppMethodBeat.o(91731);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91731);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            exi exi = (exi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    exi.NuI = aVar3.UbS.readString();
                    AppMethodBeat.o(91731);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        th thVar = new th();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = thVar.populateBuilderWithField(aVar4, thVar, a.getNextFieldNumber(aVar4))) {
                        }
                        exi.NuJ = thVar;
                    }
                    AppMethodBeat.o(91731);
                    return 0;
                case 3:
                    exi.NuK = aVar3.UbS.yZ();
                    AppMethodBeat.o(91731);
                    return 0;
                case 4:
                    exi.NuL = aVar3.UbS.readString();
                    AppMethodBeat.o(91731);
                    return 0;
                default:
                    AppMethodBeat.o(91731);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91731);
            return -1;
        }
    }
}
