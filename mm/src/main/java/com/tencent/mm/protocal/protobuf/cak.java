package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cak extends a {
    public caj LWF;
    public boolean MfE;
    public String icon;
    public int nHh;
    public String pTn;
    public String pWf;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72496);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.pTn != null) {
                aVar.e(1, this.pTn);
            }
            if (this.pWf != null) {
                aVar.e(2, this.pWf);
            }
            if (this.icon != null) {
                aVar.e(3, this.icon);
            }
            aVar.cc(4, this.MfE);
            aVar.aM(5, this.nHh);
            if (this.LWF != null) {
                aVar.ni(6, this.LWF.computeSize());
                this.LWF.writeFields(aVar);
            }
            AppMethodBeat.o(72496);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.pTn != null ? g.a.a.b.b.a.f(1, this.pTn) + 0 : 0;
            if (this.pWf != null) {
                f2 += g.a.a.b.b.a.f(2, this.pWf);
            }
            if (this.icon != null) {
                f2 += g.a.a.b.b.a.f(3, this.icon);
            }
            int fS = f2 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.bu(5, this.nHh);
            if (this.LWF != null) {
                fS += g.a.a.a.nh(6, this.LWF.computeSize());
            }
            AppMethodBeat.o(72496);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72496);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cak cak = (cak) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cak.pTn = aVar3.UbS.readString();
                    AppMethodBeat.o(72496);
                    return 0;
                case 2:
                    cak.pWf = aVar3.UbS.readString();
                    AppMethodBeat.o(72496);
                    return 0;
                case 3:
                    cak.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(72496);
                    return 0;
                case 4:
                    cak.MfE = aVar3.UbS.yZ();
                    AppMethodBeat.o(72496);
                    return 0;
                case 5:
                    cak.nHh = aVar3.UbS.zi();
                    AppMethodBeat.o(72496);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        caj caj = new caj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = caj.populateBuilderWithField(aVar4, caj, a.getNextFieldNumber(aVar4))) {
                        }
                        cak.LWF = caj;
                    }
                    AppMethodBeat.o(72496);
                    return 0;
                default:
                    AppMethodBeat.o(72496);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72496);
            return -1;
        }
    }
}
